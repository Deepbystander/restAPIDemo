<html>
<body>
    <h2>Jersey RESTful API!</h2>
    <h1> Develop by Dipesh Maharjan</h1>
    <p><a href="webapi/students">click here get All records of Database</a>
	<pre>DEMO RESP API with Jersey
IDE: Eclipse IDE for Enterprise Java Developers 2020-03 (4.15.0)
server: TOMCAT 9.0
database: MySQL 8.0.19
jersey version: 2.30.1

This application is developing for the demo representation of Insert, Update, Delete, Retrieve of data
of student from the database using RESP API

Before we start the program there is SQL statement to create database for program

CREATE DATABASE demorestapidb;
USE demorestapidb;
CREATE TABLE student(id INT PRIMARY KEY,name VARCHAR(50) NOT NULL,age INT NOT NULL);

here we create database name demorestapidb and student table in it with varaible id,name and age.

this program is tested with the help of POSTMAN application. 

ABOUT the program url


index page:
http://localhost:8085/demorestapi/webapi 

to get all record
http://localhost:8085/demorestapi/webapi/students

to get single record
http://localhost:8085/demorestapi/webapi/student/"id of student"
e.g: http://localhost:8085/demorestapi/webapi/student/1

to insert with post method
http://localhost:8085/demorestapi/webapi/students/insert
with input type xml or json
e.g.: &lt;student&gt;
	&lt;id&gt;1&lt;/id&gt;
    &lt;name&gt;Dipesh&lt;/name&gt;
    &lt;age&gt;26&lt;/age&gt;
    &lt;/student&gt;

to update with PUT method
http://localhost:8085/demorestapi/webapi/students/update
with input type xml or json
e.g.: &lt;student&gt;
	&lt;id&gt;1&lt;/id&gt;
    &lt;name&gt;Dipesh&lt;/name&gt;
    &lt;age&gt;26&lt;/age&gt;
    &lt;/student&gt;
where the data will update reference to given id

to delete with delete method
http://localhost:8085/demorestapi/webapi/students/delete/"id No which is to be delete"
e.g.: http://localhost:8085/demorestapi/webapi/students/delete/1
	</pre>
</body>
</html>
 	