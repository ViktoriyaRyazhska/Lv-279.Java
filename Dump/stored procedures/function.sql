DELIMITER //
DROP FUNCTION IF EXISTS get_student_in_progress//
CREATE FUNCTION get_student_in_progress(acid INT)
  RETURNS INT
DETERMINISTIC
  BEGIN
    RETURN (SELECT count(s.student_status_id)
            FROM students s
            WHERE s.academy_id = acid AND s.student_status_id IN (1, 2, 3));
  END//

DROP FUNCTION IF EXISTS get_student_status//

CREATE FUNCTION get_student_status(acid INT, ssid INT)
  RETURNS INT
DETERMINISTIC
  BEGIN
RETURN (SELECT count(s.id)
            FROM students s
            WHERE s.academy_id = acid AND s.student_status_id = ssid);
  END//

DROP FUNCTION IF EXISTS get_trainers//

CREATE FUNCTION get_trainers(id INT)
  RETURNS VARCHAR(100)
DETERMINISTIC
  BEGIN
    RETURN (SELECT group_concat(concat(" ", e.first_name_eng, " ", e.last_name_eng)) name
            FROM employee e
              JOIN group_info_teachers git
                ON git.employee_id = e.employee_id
             WHERE git.academy_id = id AND
                  e.employee_id = git.employee_id AND git.teacher_type_id IN (1, 2));
  END //

 DELIMITER ;