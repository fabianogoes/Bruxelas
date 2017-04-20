import os
import fabric.api

from fabric.api import *
from fabric.colors import *


env.hosts=["31.220.55.236"]
env.user="root"
env.password="diego@lirio123"

def install_core():
    sudo("apt-get -y update")
    sudo("apt-get -y upgrade")
    sudo("apt-get -y install git-core")
    sudo("apt-get -y install software-properties-common python-software-properties debconf-utils")

def install_mysql(mysql_root_password='root'):
    print(green(">>> install MySQL..."))
    sudo('echo "mysql-server-5.0 mysql-server/root_password password %s" | debconf-set-selections' % mysql_root_password)
    sudo('echo "mysql-server-5.0 mysql-server/root_password_again password %s" | debconf-set-selections' % mysql_root_password)
    sudo('apt-get -y install mysql-server')

def install_java8():
    print(green(">>> install Java 8..."))
    sudo("add-apt-repository ppa:webupd8team/java -y")
    sudo("apt-get update")
    sudo('echo "oracle-java8-installer shared/accepted-oracle-license-v1-1 select true" | sudo debconf-set-selections')
    sudo("apt-get install -y oracle-java8-installer")

def install_tomcat8():
    print(green(">>> install tomcat 8...")) 
    sudo("wget http://download.nextag.com/apache/tomcat/tomcat-8/v8.0.43/bin/apache-tomcat-8.0.43.tar.gz")
    run("tar -xvf apache-tomcat-8.0.43.tar.gz")
    run("rm -rf apache-tomcat-8.0.43.tar.gz")
    run("chmod 777 -R /root/apache-tomcat-8.0.43")

def install_maven3():
    print(green(">>> install Maven 3..."))
    sudo("apt-get -y install maven")

def config_env():
    print(green("<<< Config Env...>>>"))
    run("echo export JAVA_HOME=/usr/lib/jvm/java-8-oracle >> /root/.bashrc")
    run("echo export CATALINA_HOME=/root/apache-tomcat-8.0.43 >> /root/.bashrc")
    run("echo export PATH=/usr/lib/jvm/java-8-oracle/bin:/root/apache-tomcat-8.0.43/bin:$PATH >> /root/.bashrc")
    sudo("source /root/.bashrc")

def build_app():
    print(green(">>> Deployng..."))
    run("git clone https://github.com/fabianogoes/bruxelas.git")
    with cd("bruxelas"):
        run("mvn clean package -Dmaven.test.skip=true")
        run("cp target/bruxelas.war /root/apache-tomcat-8.0.43/webapps/")

def deploy_app():
    print(green(">>> Deploy Bruxelas..."))
    build_app()
    run("cp /root/bruxelas/target/bruxelas.war /root/apache-tomcat-8.0.43/webapps/")
    run("/etc/init.d/tomcat start")

def startup_tomcat():
    print(green(">>> Startup Tomcat..."))
    tomcat_start_script = """#!/bin/sh

        export JAVA_HOME=/usr/lib/jvm/java-8-oracle
        export CATALINA_HOME=/root/apache-tomcat-8.0.43

        case $1 in
        start)
            $CATALINA_HOME/bin/catalina.sh start
        ;;
        stop)
            $CATALINA_HOME/bin/catalina.sh stop
        ;;
        restart)
            $CATALINA_HOME/bin/catalina.sh stop
            $CATALINA_HOME/bin/catalina.sh start
        ;;
        esac
        exit 0"""    

    with cd("/etc/init.d/"):
        run("echo '%s' > tomcat" % tomcat_start_script)

    sudo("chmod 755 /etc/init.d/tomcat")
    sudo("update-rc.d tomcat defaults")

def mysql_create_user(user='root',password='root',new_user='',new_password=''):
    mysql_execute("""GRANT ALL privileges ON *.* TO "%s" IDENTIFIED BY "%s";FLUSH PRIVILEGES;""" % (new_user, new_password), user, password)

def mysql_execute(sql, user='root', password='root'):
    with fabric.api.settings(warn_only=True):
        return fabric.api.run("echo '%s' | mysql -u%s -p%s" % (sql, user, password))

def mysql_create_db(database_name='bruxelas', mysql_root='root', mysql_root_password='root'):
    print(green(">>> MySQL Create Database..."))
    params = 'DEFAULT CHARACTER SET utf8 DEFAULT COLLATE utf8_general_ci'
    mysql_execute('CREATE DATABASE %s %s;' % (database_name, params), mysql_root, mysql_root_password)

def mysql_dump(mysql_user_root='root', mysql_user_root_password='root', bruxelas_database_name='bruxelas'):
    print(green(">>> MySQL Bruxelas Dump..."))
    run("wget https://raw.githubusercontent.com/fabianogoes/bruxelas/master/bruxelas-dump.sql")
    run("mysql -u%s -p%s %s < bruxelas-dump.sql" % (mysql_user_root, mysql_user_root_password, bruxelas_database_name))

def mysql_setup(mysql_root='root', mysql_root_password='root', mysql_database_bruxelas='bruxelas', mysql_user_bruxelas='bruxelas', mysql_password_bruxelas='bruxelas'):
    print(green("******************************"))
    print(green(">>> MySQL Setup...            "))
    print(green("******************************"))
    install_mysql(mysql_root_password)
    mysql_create_db(mysql_database_bruxelas, mysql_root, mysql_root_password)
    mysql_create_user(mysql_root, mysql_root_password, mysql_user_bruxelas, mysql_password_bruxelas)
    mysql_dump(mysql_root, mysql_root_password)

def java_setup():
    print(green("******************************"))
    print(green(">>> Java Setup...            "))
    print(green("******************************"))
    install_java8()
    install_tomcat8()
    install_maven3() 
    config_env()
    startup_tomcat()

def bruxelas(host='31.220.55.236', host_user='root', host_password='diego@lirio123', mysql_user_root='root', mysql_user_root_password='root'):
    env.hosts    = host
    env.user     = host_user
    env.password = host_password

    mysql_root          = mysql_user_root
    mysql_root_password = mysql_user_root_password
    
    bruxelas_database_name     = 'bruxelas'
    bruxelas_database_user     = 'bruxelas'
    bruxelas_database_password = 'bruxelas'

    install_core()    
    mysql_setup(mysql_root, mysql_root_password, bruxelas_database_name, bruxelas_database_user, bruxelas_database_password)
    java_setup()

    deploy_app()

