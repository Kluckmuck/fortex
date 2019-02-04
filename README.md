## Fortex application for waybills

### Backend
#### Connect to mysql-database-dockercontainer.
1. Create mysql container. with this command.:
```shell
docker run -d -p 3306:3306 --name=docker-mysql --env="MYSQL_ROOT_PASSWORD=admin123" --env="MYSQL_PASSWORD=admin123" --env="MYSQL_DATABASE=fortex" mysql
```
2. This creates the mysql database. Now you have to grant privilages to
spring boot user to post to the database. Follow this steps:
  1. docker exec -it docker-mysql mysql -uroot -p
  2. Enter password "admin123"
  3. Then create the database:  create database fortex;
  4. After create a user: create user 'admin123'@'localhost' identified by 'admin123';
  5. And last grant privileges to the user:
    grant all on fortex.* to 'admin123'@'localhost';

> You have now created the the mysql database within the docker container
the password, username and databasename is reflected in the
application.properties file under src/main/resources/application.properties.

If the container stops, it may be started with 
```shell
docker start docker-mysql
```

#### Run
```shell
cd backend/
mvn spring-boot:run
```
Runs on port 8080.

#### Test
```shell
cd backend/
mvn test
```

```shell
mvn jacoco:report
```
Produces report as a readable format (HTML, XML, CSV).
These can be find in target/site/jacoco/

### Frontend
#### Run
```shell
cd fortex-front/
npm install
npm start
```
Runs on port 4200.

#### Run json-server
```shell
json-server --watch MOCK_DATA.json
```
Runs on port 3000.
