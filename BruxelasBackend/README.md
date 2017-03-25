# Bruxelas Project Backend

**Development Environemnt**   

> set Profile = dev   

``` 
spring.profiles.active=dev
```   

```   
CREATE SCHEMA bruxelasdev DEFAULT CHARACTER SET utf8;
CREATE USER 'bruxelasdev'@'localhost' IDENTIFIED BY 'bruxelasdev';
GRANT ALL PRIVILEGES ON * . * TO 'bruxelasdev'@'localhost';
```

-------

**Production Environment**

```   
CREATE SCHEMA bruxelas DEFAULT CHARACTER SET utf8;
CREATE USER 'bruxelas'@'localhost' IDENTIFIED BY 'bruxelas';
GRANT ALL PRIVILEGES ON * . * TO 'bruxelas'@'localhost';
```   

> set Profile = prod   

``` 
spring.profiles.active=prod
```   
