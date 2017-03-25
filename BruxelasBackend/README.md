# Bruxelas Project Backend

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
