DELIMITER //
DROP PROCEDURE IF EXISTS studentTranscript;

CREATE PROCEDURE studentTranscript
( IN studentId  INT
)
BEGIN
    SELECT C.courseName, B.letterGrade
    FROM Students AS A
    JOIN Enrollments AS B ON A.studentId = B.studentId
    JOIN Courses AS C ON B.courseId = C.courseId;
END//
DELIMITER ;
