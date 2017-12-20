
DELIMITER $$
CREATE PROCEDURE get_student_count(IN academy_id_in int, OUT countz int)
BEGIN
	select count(*) into countz from students
    where academy_id = academy_id_in and student_status_id in (1,3,8);
END$$

CREATE PROCEDURE get_entry_score(IN academy_id_in int, OUT countz int)
BEGIN
	select count(entry_score) into countz from students
    where academy_id = academy_id_in and student_status_id in (1,3,8);
END$$

CREATE PROCEDURE get_english_level(IN academy_id_in int, OUT countz int)
BEGIN   
	select count(english_level_id) into countz from students
    where academy_id = academy_id_in and student_status_id in (1,3,8);
END$$

CREATE PROCEDURE get_min_english_level(IN academy_id_in int, OUT minEL int)
BEGIN   
	select min(english_level_id) into minEL from students
    where academy_id = academy_id_in and student_status_id in (1,3,8);
END$$

CREATE PROCEDURE get_incoming_test(IN academy_id_in int, OUT countz int)
BEGIN   
	select count(incoming_test) into countz from students
    where academy_id = academy_id_in and student_status_id in (1,3,8);
END$$

CREATE PROCEDURE get_approved_by(IN academy_id_in int, OUT countz int)
BEGIN   
	select count(employee_id) into countz from students
    where academy_id = academy_id_in and student_status_id in (1,3,8);
END$$

CREATE PROCEDURE get_final_base(IN academy_id_in int, OUT countz int)
BEGIN   
	select count(final_base) into countz from students
    where academy_id = academy_id_in and student_status_id in (1,3,8);
END$$

CREATE PROCEDURE get_final_lang(IN academy_id_in int, OUT countz int)
BEGIN   
	select count(final_lang) into countz from students
    where academy_id = academy_id_in and student_status_id in (1,3,8);
END$$

CREATE PROCEDURE get_interm_test_base(IN academy_id_in int, OUT countz int)
BEGIN   
	select count(interm_test_base) into countz from students
    where academy_id = academy_id_in and student_status_id in (1,3,8);
END$$

CREATE PROCEDURE get_interm_test_lang(IN academy_id_in int, OUT countz int)
BEGIN   
	select count(interm_test_lang) into countz from students
    where academy_id = academy_id_in and student_status_id in (1,3,8);
END$$

CREATE PROCEDURE get_interviewer_score(IN academy_id_in int, OUT countz int)
BEGIN   
	select count(interviewer_score) into countz from students
    where academy_id = academy_id_in and student_status_id in (1,3,8);
END$$

CREATE PROCEDURE get_teacher_score(IN academy_id_in int, OUT countz int)
BEGIN   
	select count(teacher_score) into countz from students
    where academy_id = academy_id_in and student_status_id in (1,3,8);
END$$

CREATE PROCEDURE get_expert_score(IN academy_id_in int, OUT countz int)
BEGIN   
	select count(expert_score) into countz from students
    where academy_id = academy_id_in and student_status_id in (1,3,8);
END$$

CREATE PROCEDURE get_expert_feedback(IN academy_id_in int, OUT countz int)
BEGIN   
	select count(expert_student_feedback_id) into countz from students
    where academy_id = academy_id_in and student_status_id in (1,3,8);
END$$

CREATE PROCEDURE get_teacher_feedback(IN academy_id_in int, OUT countz int)
BEGIN   
	select count(teacher_student_feedback_id) into countz from students
    where academy_id = academy_id_in and student_status_id in (1,3,8);
END$$

CREATE PROCEDURE get_test_1(IN academy_id_in int, OUT countz int)
BEGIN   
	select count(test_1) into countz from students
    where academy_id = academy_id_in and student_status_id in (1,3,8);
END$$

CREATE PROCEDURE get_test_2(IN academy_id_in int, OUT countz int)
BEGIN   
	select count(test_2) into countz from students
    where academy_id = academy_id_in and student_status_id in (1,3,8);
END$$

CREATE PROCEDURE get_test_3(IN academy_id_in int, OUT countz int)
BEGIN   
	select count(test_3) into countz from students
    where academy_id = academy_id_in and student_status_id in (1,3,8);
END$$

CREATE PROCEDURE get_test_4(IN academy_id_in int, OUT countz int)
BEGIN   
	select count(test_4) into countz from students
    where academy_id = academy_id_in and student_status_id in (1,3,8);
END$$

CREATE PROCEDURE get_test_5(IN academy_id_in int, OUT countz int)
BEGIN   
	select count(test_5) into countz from students
    where academy_id = academy_id_in and student_status_id in (1,3,8);
END$$

CREATE PROCEDURE get_test_6(IN academy_id_in int, OUT countz int)
BEGIN   
	select count(test_6) into countz from students
    where academy_id = academy_id_in and student_status_id in (1,3,8);
END$$

CREATE PROCEDURE get_test_7(IN academy_id_in int, OUT countz int)
BEGIN   
	select count(test_7) into countz from students
    where academy_id = academy_id_in and student_status_id in (1,3,8);
END$$

CREATE PROCEDURE get_test_8(IN academy_id_in int, OUT countz int)
BEGIN   
	select count(test_8) into countz from students
    where academy_id = academy_id_in and student_status_id in (1,3,8);
END$$

CREATE PROCEDURE get_test_9(IN academy_id_in int, OUT countz int)
BEGIN   
	select count(test_9) into countz from students
    where academy_id = academy_id_in and student_status_id in (1,3,8);
END$$

CREATE PROCEDURE get_test_10(IN academy_id_in int, OUT countz int)
BEGIN   
	select count(test_10) into countz from students
    where academy_id = academy_id_in and student_status_id in (1,3,8);
END$$

CREATE PROCEDURE get_teachers(IN academy_id_in int, IN teacherType int, OUT countz int)
BEGIN   
	select count(employee_id) into countz from group_info_teachers
    where academy_id = academy_id_in and teacher_type_id = teacherType;
END$$
DELIMITER ;