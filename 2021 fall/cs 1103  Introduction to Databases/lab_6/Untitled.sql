CREATE TABLE Students
(   studentId INT AUTO_INCREMENT,
    stName VARCHAR(30) NOT NULL,
    email VARCHAR(40),
    gpa FLOAT DEFAULT 0.0,
    PRIMARY KEY (studentId),
    CONSTRAINT CHECK_GPA
    CHECK (gpa BETWEEN 0 AND 4.3)
);

CREATE TABLE Courses
    ( courseId INT AUTO_INCREMENT,
    courseNumber VARCHAR(10) NOT NULL,
    courseName VARCHAR(50) NOT NULL,
    courseDescription VARCHAR(200),
    creditHours INT DEFAULT 3,
    approvedDate DATE,
    PRIMARY KEY (courseId),
    CONSTRAINT CHECK_CREDIT_HOUR
    CHECK (creditHours BETWEEN 0 AND 6)
);

CREATE TABLE Enrollments
    ( studentId INT,
    courseId INT,
    letterGrade CHAR(2),
    PRIMARY KEY (studentId, courseId),
    FOREIGN KEY (studentId)
    REFERENCES Students(studentId)
    ON DELETE NO ACTION
    ON UPDATE CASCADE,
    FOREIGN KEY (courseId)
    REFERENCES Courses(courseId)
    ON DELETE NO ACTION
    ON UPDATE CASCADE
);


-- test creditHours constraint
INSERT INTO Courses (courseNumber, courseName, creditHours, courseDescription)
VALUE ('CS1111', 'INTRO TO Something', NULL , 'intro to something description');

INSERT INTO Courses (courseNumber, courseName, creditHours, courseDescription)
VALUE ('CS1111', 'INTRO TO Something', 8 , 'intro to something description');

-- test course not null constraint
INSERT INTO Courses (courseNumber, courseName, courseDescription)
VALUE (NULL, 'INTRO TO Something', 'intro to something description');

INSERT INTO Courses (courseNumber, courseName, courseDescription)
VALUE ('something', NULL, 'intro to something description');

-- Add an approvedDate attribute to the Course table
ALTER TABLE Courses ADD approvedDate DATE;

-- Use Insert (or Update) statements to add (or update) data to the table with the extra attribute
INSERT INTO Courses (courseNumber, courseName, creditHours, courseDescription, approvedDate)
VALUE ('CS1110', 'Java 23', 6, 'java course 23', '20210312');

UPDATE Courses
SET approvedDate = '20210520'
WHERE courseId = 2;

-- create some normal students
INSERT INTO Students (stName, email, gpa)
VALUE ('yulong wang', '123@unb.ca', 4.0);

INSERT INTO Students (stName, email, gpa)
VALUE ('max', '456@unb.ca', 4.0);

-- test student gpa constraint:
INSERT INTO Students (stName, email, gpa)
VALUE ('hui', '456@unb.ca', 5.0);


-- test student not null constraint:
INSERT INTO Students (stName, email, gpa)
VALUE (NULL, '456@unb.ca', 2.0);

UPDATE Students
SET stName = NULL
WHERE studentId = 3;

-- create Enrollments rows
INSERT INTO Enrollments (studentId, courseId, letterGrade)
VALUE (1, 1, 'B');
INSERT INTO Enrollments (studentId, courseId, letterGrade)
VALUE (1, 2, 'A');
INSERT INTO Enrollments (studentId, courseId, letterGrade)
VALUE (2, 3, 'A');
INSERT INTO Enrollments (studentId, courseId, letterGrade)
VALUE (2, 1, 'A');

-- test deleting student that has enrolled in a course
DELETE FROM Students
WHERE studentId = 1;

-- for each student lists the information for courses they’ve taken and their letter grade.
SELECT *
FROM Students AS A
LEFT JOIN Enrollments AS B ON A.studentId = B.studentId
LEFT JOIN Courses AS C ON B.courseId = C.courseId;

select * from Courses;

select * from Students;

select * from Enrollments;
