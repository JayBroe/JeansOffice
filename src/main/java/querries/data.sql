<--Create tables-->
CREATE TABLE jeans_base.majors (
`major_id` BIGINT NOT NULL AUTO_INCREMENT,
`major_name` VARCHAR(20) NOT NULL,
PRIMARY KEY (`major_id`)
) AUTO_INCREMENT=1;


CREATE TABLE jeans_base.years (
`year_id` BIGINT NOT NULL AUTO_INCREMENT,
`year_name` BIGINT NOT NULL,
PRIMARY KEY (`year_id`)
) AUTO_INCREMENT=1;


CREATE TABLE jeans_base.forms (
`form_id` BIGINT NOT NULL AUTO_INCREMENT,
`form_name` VARCHAR(20) NOT NULL,
PRIMARY KEY (`form_id`)
) AUTO_INCREMENT=1;


CREATE TABLE jeans_base.students (
`student_id` BIGINT NOT NULL AUTO_INCREMENT,
`form_id` BIGINT NOT NULL,
`major_id` BIGINT NOT NULL,
`year_id` BIGINT NOT NULL,
`name` varchar(45) NOT NULL,
`surname` varchar(45) NOT NULL,
PRIMARY KEY (`student_id`),
KEY `fk_form` (`form_id`),
KEY `fk_major` (`major_id`),
KEY `fk_year` (`year_id`),
CONSTRAINT `fk_form` FOREIGN KEY (`form_id`) REFERENCES `forms` (`form_id`),
CONSTRAINT `fk_major` FOREIGN KEY (`major_id`) REFERENCES `majors` (`major_id`),
CONSTRAINT `fk_year` FOREIGN KEY (`year_id`) REFERENCES `years` (`year_id`)
) AUTO_INCREMENT=100000;

CREATE TABLE jeans_base.replicas(
`id` BIGINT NOT NULL AUTO_INCREMENT,
`CopyName` VARCHAR(255) NOT NULL,
`Date` DATE NOT NULL,
`Time` TIME NOT NULL,
PRIMARY KEY (`id`)
);
<--Create tables-->

<--Fulfill the tables with an example data-->
INSERT INTO jeans_base.forms VALUES(1,"Stationary");
INSERT INTO jeans_base.forms VALUES(2,"Part-time");

INSERT INTO jeans_base.years VALUES(1,1);
INSERT INTO jeans_base.years VALUES(2,2);
INSERT INTO jeans_base.years VALUES(3,3);
INSERT INTO jeans_base.years VALUES(4,4);
INSERT INTO jeans_base.years VALUES(5,5);

INSERT INTO jeans_base.majors VALUES (1,"A");
INSERT INTO jeans_base.majors VALUES (2,"B");
INSERT INTO jeans_base.majors VALUES (3,"C");
INSERT INTO jeans_base.majors VALUES (4,"D");
INSERT INTO jeans_base.majors VALUES (5,"E");

DELETE FROM jeans_base.forms;
DELETE FROM jeans_base.years;
DELETE FROM jeans_base.majors;

SELECT * FROM jeans_base.forms;
SELECT * FROM jeans_base.years;
SELECT * FROM jeans_base.majors;
SELECT * FROM jeans_base.students;
<--Fulfill tables with example data-->

<--clean all the tables-->
SET FOREIGN_KEY_CHECKS = 0;
TRUNCATE table jeans_base.years;
TRUNCATE table jeans_base.students;
TRUNCATE table jeans_base.forms;
TRUNCATE table jeans_base.majors;
TRUNCATE table jeans_base.students_copy;
TRUNCATE table jeans_base.replicas;
SET FOREIGN_KEY_CHECKS = 1;
<--clean all the tables-->