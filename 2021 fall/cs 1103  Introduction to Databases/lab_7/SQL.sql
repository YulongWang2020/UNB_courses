CREATE TABLE Students
(   studentId INT AUTO_INCREMENT,
    stName VARCHAR(30) NOT NULL,
    email VARCHAR(40),
    gpa FLOAT DEFAULT 0.0,
    scholarship INT DEFAULT 0,
    PRIMARY KEY (studentId),
    CONSTRAINT CHECK_GPA
    CHECK (gpa BETWEEN 0 AND 4.3)
);

DROP PROCEDURE AcceptStudent;
DELIMITER $$
    CREATE PROCEDURE AcceptStudent(
        studentName CHAR(30),
        emailAddress CHAR(30),
        highSchoolAvg FLOAT
    )
    BEGIN
        DECLARE scholarship INT;
        IF highSchoolAvg>100.0 OR highSchoolAvg<0.0 THEN
            SIGNAL SQLSTATE '45001'
                SET MESSAGE_TEXT = 'Mark out of range!';
        END IF;
        IF highSchoolAvg > 90.0 THEN
            SET scholarship = 1500;
        ELSEIF highSchoolAvg > 85.0 THEN
            SET scholarship = 1000;
        ELSE 
            SET scholarship = 0;
        END IF;
        INSERT INTO Students(stName, email,scholarship) VALUE (studentName, emailAddress,scholarship);
    END$$
DELIMITER ;

-- tests
CALL AcceptStudent('yulong wang', '123@unb.ca', 80.0);
CALL AcceptStudent('MAX', '123@unb.ca', 88.0);
CALL AcceptStudent('CHRIS', '123@unb.ca', 95.0);
CALL AcceptStudent('XXX', '123@unb.ca', 120.0);
SELECT * FROM Students;