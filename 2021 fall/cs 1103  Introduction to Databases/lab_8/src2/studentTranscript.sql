DELIMITER //
DROP PROCEDURE IF EXISTS studentTranscript;
CREATE PROCEDURE studentTranscript
( IN studentId INT
)
BEGIN
    UPDATE Students AS A SET A.studentId = studentId WHERE A.studentId = studentId;
    IF(ROW_COUNT() = 0) THEN
          SIGNAL SQLSTATE '52711'
            SET MESSAGE_TEXT = 'Student not Found.';
        END IF;
    SELECT C.courseName, B.letterGrade
    FROM Students AS A
    JOIN Enrollments AS B ON A.studentId = B.studentId
    JOIN Courses AS C ON B.courseId = C.courseId
    WHERE A.studentId = studentId;
END//
DELIMITER ;
