### Fortex application for waybills

#### Connect to mysql-database-dockercontainer.
1. Create mysql container. with this command.:
```shell
docker run -d -p 3306:3306 --name=docker-mysql --env="MYSQL_ROOT_PASSWORD=admin123" --env="MYSQL_PASSWORD=admin123" --env="MYSQL_DATABASE=fortex1" mysql
```
2. This creates the mysql database. Now you have to grant privilages to
spring boot user to post to the database. Follow this steps:
  1. docker exec -it docker-mysql mysql -uroot -p
  2. Enter password "admin123"
  3. Then create the database:  create database fortex;
  4. After create a user: create user 'admin123'@'%' identified by 'admin123'; 
  5. And last grant privileges to the user:
    grant all on fortex.* to 'admin123'@'%';

> You have now created the the mysql database within the docker container
the password, username and databasename is reflected in the 
application.properties file under src/main/resources/application.properties.
