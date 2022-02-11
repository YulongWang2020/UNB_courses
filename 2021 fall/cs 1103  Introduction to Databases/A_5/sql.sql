DROP TABLE EMPLOYEE;
DROP TABLE JOB;
CREATE TABLE JOB(
    Job_Code INT NOT NULL AUTO_INCREMENT,
    Job_Description VARCHAR(200),
    Job_Chg_Hour FLOAT,
    Job_Last_Update DATE,
    PRIMARY KEY(Job_Code)
);

CREATE TABLE EMPLOYEE(
    Emp_Num INT NOT NULL AUTO_INCREMENT,
    Emp_LName VARCHAR(20),
    Emp_FName VARCHAR(20),
    Emp_Initial VARCHAR(1),
    Emp_HireDate DATE,
    Job_Code INT,
    Emp_Years INT,
    PRIMARY KEY(Emp_Num),
    FOREIGN KEY(Job_Code)
    REFERENCES JOB(Job_Code)
    ON DELETE NO ACTION
    ON UPDATE CASCADE
);

INSERT INTO JOB (Job_Description, Job_Chg_Hour, Job_Last_Update) VALUE ('TEST JOB ONE', 12.3, '20211102');
INSERT INTO JOB (Job_Description, Job_Chg_Hour, Job_Last_Update) VALUE ('TEST JOB TWO', 14.1, '20211101');
INSERT INTO JOB (Job_Description, Job_Chg_Hour, Job_Last_Update) VALUE ('TEST JOB THREE', 20.0, '20211104');
SELECT * FROM JOB;

INSERT INTO EMPLOYEE (Emp_LName, Emp_FName, Emp_Initial, Emp_HireDate, Job_Code, Emp_Years) VALUE ('yulong', 'wang', 'I', '20211104', 1, '12');
INSERT INTO EMPLOYEE (Emp_LName, Emp_FName, Emp_Initial, Emp_HireDate, Job_Code, Emp_Years) VALUE ('tony', 'john', 'H', '20211102', 2, '1');
INSERT INTO EMPLOYEE (Emp_LName, Emp_FName, Emp_Initial, Emp_HireDate, Job_Code, Emp_Years) VALUE ('tom', 'jack', 'Q', '20211111', 3, '20');
SELECT * FROM EMPLOYEE;


DROP TABLE IF EXISTS schools;
CREATE TABLE schools (
    schoolId INT NOT NULL AUTO_INCREMENT,
    name VARCHAR(50) NOT NULL,
    province VARCHAR(20) DEFAULT NULL,
    language CHAR(2) DEFAULT NULL,
    level VARCHAR(10) DEFAULT NULL,
    PRIMARY KEY (schoolId)
); 

INSERT INTO schools (name, province, language, level) VALUE ('University of New Brunswick', 'NB', 'EN','University');
INSERT INTO schools (name, province, language, level) VALUE ('Miami University', 'OH', 'EN','University');
INSERT INTO schools (name, province, language, level) VALUE ('Columbia University', 'NY', 'EN','University');
SELECT * FROM schools;

UPDATE schools
SET province = 'Manitoba'
WHERE schoolId = 2;
SELECT * FROM schools;

DELETE FROM schools WHERE province = 'Manitoba';
SELECT * FROM schools;
