DELIMITER //
DROP PROCEDURE IF EXISTS addSchool;

CREATE PROCEDURE addSchool
( nameIn    VARCHAR(50),
  provinceIn VARCHAR(20),
  languageIn CHAR(2),
  levelIn    VARCHAR(10)
)
BEGIN

  INSERT INTO schools (name, province, language, level)
    VALUES (nameIn, provinceIn, languageIn, levelIn);

    IF(ROW_COUNT() = 0) THEN
      SIGNAL SQLSTATE '52711'
        SET MESSAGE_TEXT = 'Unable to add the school.';
    END IF;

    SELECT LAST_INSERT_ID();
END//
DELIMITER ;
