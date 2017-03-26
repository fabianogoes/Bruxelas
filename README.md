# Bruxelas
Bruxelas Project - Connect to Practice

### Technologies   

* Spring Boot
* Spring MVC
* Spring Data
* Angular 1
* Bootstrap 3
* Spring Social
* Spring Security

------   

### Bruxelas Project Backend

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

------    

### Bruxelas Project Frontend

**Development Environemnt**   

```
$ npm install && grunt build
```

------    

![Dash](doc/dash-1.0.JPG)

------

[![Build Status](https://travis-ci.org/fabianogoes/Bruxelas.svg?branch=master)](https://travis-ci.org/fabianogoes/Bruxelas)
