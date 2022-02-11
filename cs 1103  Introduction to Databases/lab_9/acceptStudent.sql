
DELIMITER //
DROP PROCEDURE IF EXISTS acceptStudent;

CREATE PROCEDURE acceptStudent
( studname  VARCHAR(255),
  studemail    VARCHAR(255),
  hsaverage FLOAT
)
BEGIN
  DECLARE scholarship INT;
  IF (hsaverage > 90 AND hsaverage <= 100) THEN
    SET scholarship = 1500;
  ELSEIF (hsaverage > 80 AND hsaverage <= 100) THEN
    SET scholarship = 1000;
  ELSEIF (hsaverage >= 0 AND hsaverage <= 100) THEN
    SET scholarship = 0;
  ELSE
  	SIGNAL SQLSTATE '45000'
      	SET MESSAGE_TEXT = 'Invalid high school average.';
  END IF;

  INSERT INTO Students (stName, email, scholarship)
    VALUES (studname, studemail, scholarship);
  IF (ROW_COUNT() = 0) THEN   
    SIGNAL SQLSTATE '45001'
      SET MESSAGE_TEXT = 'Unable to add record. ';
  END IF;    

  
END//
DELIMITER ;
