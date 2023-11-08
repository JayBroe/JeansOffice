# JeansOffice


This project is an example of Hibernate ORM implementation combined
with Swing GUI framework. MySQL was used for database management system.
I present Jeans' Office - a desktop app to manage the students in the university 
by just selecting right buttons. The structure is quite simple, but from the second
hand complicated... better use Spring next time ;)

Additionally, I've perceived that a lot of tutorials about Hibernate 
shows examples uncomplete in respect of required settings 
or are just obsolete. 

Feel free to change the code for our own experiments!

## Project structure 

<!--<img src="https://github.com/JayBroe/JeansOffice/blob/master/Main-menu-screen.png" alt="Alt text" title="Optional title"> -->

<img src="https://github.com/JayBroe/JeansOffice/blob/master/project-structure.png" alt="Alt text" title="Optional title">
<!--https://github.com/JayBroe/JeansOffice/blob/master/project-structure.png-->

Description of the folders:

+ application
  - contains classes responsible for Swing GUI windows
+ database
  - contains classes for MySQL's DB connection and executing functions 
+ entities
  - ORM mapped classes
+ main
  - Just main class 
+ querries
  - contains start-up tables with basic data (Years, Majors, Forms and Replicas)
+ swing
  - overrided classes from original Swing 

<!--->
## Hibenate
Framework for Java used to implement an ORM (Object-Relational Mapping). Every class 
from the entities folder was mapped to enable doing specified, ORM querries and native querries.
More here: https://hibernate.org/

## Swing

Another framework to create desktop application with many functions. 
More here: https://docs.oracle.com/javase/tutorial/uiswing/

## Tables and relations

<img src="https://github.com/JayBroe/JeansOffice/blob/master/Main-menu-screen.png" alt="Alt text" title="Optional title">

## Possibilities

Project offers:

+ basic CRUD operations
  - Showing all the entities
  - creating custom/random objects
  - updating some of features of the object
  - showing all or selected objects
  - delecting objects 
+ saving/retrieving state of the database

# Steps to run the project 

At first, you have to create the database - it's on your own. 
Personally, I recommend to make it via MySQL workbench (https://www.mysql.com/products/workbench/).

After that, please go to the file querries/data.sql
and copy the lines responsible for creating the tables and their basic fullfilment.

In the end, just go to the resources/hibernate.cfg.xml (standard xml file with basic db connection settings)

and estimate your database name, user and password you set while creating the database.

Now, you can test the project. 
  
