drop view if exists check_list_report;
create view  check_list_report as
	select 
		
		gi.academy_id,
		gi.group_name group_name,
        lt.trasnlation city_name,
        acs.name status,
        
        (SELECT teachers_select.name FROM 
			(SELECT
				group_concat(concat(" ",e.first_name_eng, " ", e.last_name_eng)) name,
				a.academy_id  aid
			FROM employee e
				join group_info_teachers git
					on git.employee_id = e.employee_id
                join academy a
					on git.academy_id = a.academy_id
			WHERE git.teacher_type_id = 1
			GROUP BY a.academy_id) teachers_select
		WHERE teachers_select.aid = a.academy_id) teachers,
        
        (SELECT experts_select.name FROM 
			(SELECT
				group_concat(concat(" ",e.first_name_eng, " ", e.last_name_eng)) name,
				a.academy_id  aid
			FROM employee e
				join group_info_teachers git
					on git.employee_id = e.employee_id
                join academy a
					on git.academy_id = a.academy_id
			WHERE git.teacher_type_id = 2
			GROUP BY a.academy_id) experts_select
		WHERE experts_select.aid = a.academy_id) experts,
        
        (select count(*) from students s
		where s.academy_id = a.academy_id and student_status_id in (1,3,8)) active_students_count,
        
        (select check_english_level(active_students_count, gi.academy_id)) english_level,
        
        (select check_english_level_correct(active_students_count, gi.academy_id)) english_level_correct,
        
		(select check_english_level(active_students_count, gi.academy_id)) entry_score,
        
        (select check_incoming_test(active_students_count, gi.academy_id)) incoming_test,
        
        (select check_approved_by(active_students_count, gi.academy_id)) approved_by,
        
        (select check_test_1(active_students_count, gi.academy_id)) test_1,
        
        (select check_test_2(active_students_count, gi.academy_id)) test_2,
        
        (select check_test_3(active_students_count, gi.academy_id)) test_3,
        
        (select check_test_4(active_students_count, gi.academy_id)) test_4,
        
        (select check_test_5(active_students_count, gi.academy_id)) test_5,
        
        (select check_test_6(active_students_count, gi.academy_id)) test_6,
        
        (select check_test_7(active_students_count, gi.academy_id)) test_7,
        
        (select check_test_8(active_students_count, gi.academy_id)) test_8,
        
        (select check_test_9(active_students_count, gi.academy_id)) test_9,
        
        (select check_test_10(active_students_count, gi.academy_id)) test_10,
        
        (select check_interm_test_base(active_students_count, gi.academy_id)) interm_test_base,
        
        (select check_interm_test_lang(active_students_count, gi.academy_id)) interm_test_lang,
        
        (select check_teacher_feedback(active_students_count, gi.academy_id)) teacher_feedback,
        
        (select check_expert_feedback(active_students_count, gi.academy_id)) expert_feedback,
        
        (select check_final_base(active_students_count, gi.academy_id)) final_base,
        
        (select check_final_lang(active_students_count, gi.academy_id)) final_lang,
        
        (select check_interviewer_summary(active_students_count, gi.academy_id)) interviewer_summary,
                
        (select check_assigned_teachers(1, gi.academy_id)) teachers_assigned,
                
        (select check_assigned_teachers(2, gi.academy_id)) experts_assigned,
                
        (select check_assigned_teachers(3, gi.academy_id)) interviewers_assigned,
        
        (select check_contributed_hours(2, gi.academy_id)) experts_load,
        
        (select check_contributed_hours(3, gi.academy_id)) interviewer_load,
        
        (select group_started_successfuly(
			english_level, english_level_correct, entry_score, incoming_test, approved_by, teachers_assigned, experts_assigned)) group_started_successfuly,
            
		(select group_ready_to_offering(group_started_successfuly,
            test_1, test_2, test_3, test_4, test_5, interm_test_base, interm_test_lang, teacher_feedback, expert_feedback)) group_ready_to_offering,
        
        (select group_ready_for_close(group_ready_to_offering,
            final_base, final_lang, interviewers_assigned, interviewer_summary, experts_load, interviewer_load)) group_ready_for_close,
        
        (select check_list_report_total(
			english_level, english_level_correct, entry_score, incoming_test, approved_by, teachers_assigned, experts_assigned,
            test_1, test_2, test_3, test_4, test_5, interm_test_base, interm_test_lang, teacher_feedback, expert_feedback,
            final_base, final_lang, interviewers_assigned, interviewer_summary, experts_load, interviewer_load)) total
        
	from academy a
		join group_info gi
			on gi.academy_id = a.academy_id
		join academy_stages acs
			on acs.stage_id = a.stage_id
		join language_translations lt
			on lt.item_id = a.city_id
            and lt.tag like 'city'
            and lt.local like 'en'
	order by a.academy_id;