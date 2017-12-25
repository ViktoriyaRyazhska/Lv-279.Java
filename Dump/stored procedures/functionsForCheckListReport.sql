DELIMITER //

drop function if exists check_english_level//
create function check_english_level (ac int, id int)
returns int 
deterministic
begin
	declare res int;
    set res = 0;
    
    if ac = 0 then set ac = 10; end if;
    
    select count(english_level_id) into @countz from students s
	where s.academy_id = id and student_status_id in (1,3,8);
	
    if ac - @countz = 0 then set res = 1; end if;
    
    return res;
end//

drop function if exists check_english_level_correct//
create function check_english_level_correct (ac int, id int)
returns int 
deterministic
begin
	declare res int;
    set res = 0;
    
    select check_english_level(ac, id) into @countz;
    
    if @countz <> 0 then
		begin
			select min(english_level_id) into @min_english_level from students s
			where s.academy_id = id and student_status_id in (1,3,8);
        
			if @min_english_level >= 8 then set res = 1; end if;
        end;
	end if;
    
    return res;
end//

drop function if exists check_entry_score//
create function check_entry_score (ac int, id int)
returns int 
deterministic
begin
	declare res int;
    set res = 0;
    
    if ac = 0 then set ac = 10; end if;
    
    select count(entry_score) into @countz from students s
	where s.academy_id = id and student_status_id in (1,3,8);
	
    if ac - @countz = 0 then set res = 1; end if;
    
    return res;
end//

drop function if exists check_incoming_test//
create function check_incoming_test (ac int, id int)
returns int 
deterministic
begin
	declare res int;
    set res = 0;
    
    if ac = 0 then set ac = 10; end if;
    
    select count(incoming_test) into @countz from students s
	where s.academy_id = id and student_status_id in (1,3,8);
	
    if ac - @countz = 0 then set res = 1; end if;
    
    return res;
end//

drop function if exists check_approved_by//
create function check_approved_by (ac int, id int)
returns int 
deterministic
begin
	declare res int;
    set res = 0;
    
    if ac = 0 then set ac = 10; end if;
    
    select count(employee_id) into @countz from students s
	where s.academy_id = id and student_status_id in (1,3,8);
	
    if ac - @countz = 0 then set res = 1; end if;
    
    return res;
end//

drop function if exists check_test_1//
create function check_test_1 (ac int, id int)
returns int 
deterministic
begin
	declare res int;
    set res = 0;
    
    if ac = 0 then set ac = 10; end if;
    
    select count(test_1) into @countz from students s
	where s.academy_id = id and student_status_id in (1,3,8);
	
    if ac - @countz = 0 then set res = 1; end if;
    
    return res;
end//

drop function if exists check_test_2//
create function check_test_2 (ac int, id int)
returns int 
deterministic
begin
	declare res int;
    set res = 0;
    
    if ac = 0 then set ac = 10; end if;
    
    select count(test_2) into @countz from students s
	where s.academy_id = id and student_status_id in (1,3,8);
	
    if ac - @countz = 0 then set res = 1; end if;
    
    return res;
end//

drop function if exists check_test_3//
create function check_test_3 (ac int, id int)
returns int 
deterministic
begin
	declare res int;
    set res = 0;
    
    if ac = 0 then set ac = 10; end if;
    
    select count(test_3) into @countz from students s
	where s.academy_id = id and student_status_id in (1,3,8);
	
    if ac - @countz = 0 then set res = 1; end if;
    
    return res;
end//

drop function if exists check_test_4//
create function check_test_4 (ac int, id int)
returns int 
deterministic
begin
	declare res int;
    set res = 0;
    
    if ac = 0 then set ac = 10; end if;
    
    select count(test_4) into @countz from students s
	where s.academy_id = id and student_status_id in (1,3,8);
	
    if ac - @countz = 0 then set res = 1; end if;
    
    return res;
end//

drop function if exists check_test_5//
create function check_test_5 (ac int, id int)
returns int 
deterministic
begin
	declare res int;
    set res = 0;
    
    if ac = 0 then set ac = 10; end if;
    
    select count(test_5) into @countz from students s
	where s.academy_id = id and student_status_id in (1,3,8);
	
    if ac - @countz = 0 then set res = 1; end if;
    
    return res;
end//

drop function if exists check_test_6//
create function check_test_6 (ac int, id int)
returns int 
deterministic
begin
	declare res int;
    set res = 0;
    
    if ac = 0 then set ac = 10; end if;
    
    select count(test_6) into @countz from students s
	where s.academy_id = id and student_status_id in (1,3,8);
	
    if ac - @countz = 0 then set res = 1; end if;
    
    return res;
end//

drop function if exists check_test_7//
create function check_test_7 (ac int, id int)
returns int 
deterministic
begin
	declare res int;
    set res = 0;
    
    if ac = 0 then set ac = 10; end if;
    
    select count(test_7) into @countz from students s
	where s.academy_id = id and student_status_id in (1,3,8);
	
    if ac - @countz = 0 then set res = 1; end if;
    
    return res;
end//

drop function if exists check_test_8//
create function check_test_8 (ac int, id int)
returns int 
deterministic
begin
	declare res int;
    set res = 0;
    
    if ac = 0 then set ac = 10; end if;
    
    select count(test_8) into @countz from students s
	where s.academy_id = id and student_status_id in (1,3,8);
	
    if ac - @countz = 0 then set res = 1; end if;
    
    return res;
end//

drop function if exists check_test_9//
create function check_test_9 (ac int, id int)
returns int 
deterministic
begin
	declare res int;
    set res = 0;
    
    if ac = 0 then set ac = 10; end if;
    
    select count(test_9) into @countz from students s
	where s.academy_id = id and student_status_id in (1,3,8);
	
    if ac - @countz = 0 then set res = 1; end if;
    
    return res;
end//

drop function if exists check_test_10//
create function check_test_10 (ac int, id int)
returns int 
deterministic
begin
	declare res int;
    set res = 0;
    
    if ac = 0 then set ac = 10; end if;
    
    select count(test_10) into @countz from students s
	where s.academy_id = id and student_status_id in (1,3,8);
	
    if ac - @countz = 0 then set res = 1; end if;
    
    return res;
end//

drop function if exists check_interm_test_base//
create function check_interm_test_base (ac int, id int)
returns int 
deterministic
begin
	declare res int;
    set res = 0;
    
    if ac = 0 then set ac = 10; end if;
    
    select count(interm_test_base) into @countz from students s
	where s.academy_id = id and student_status_id in (1,3,8);
	
    if ac - @countz = 0 then set res = 1; end if;
    
    return res;
end//

drop function if exists check_interm_test_lang//
create function check_interm_test_lang (ac int, id int)
returns int 
deterministic
begin
	declare res int;
    set res = 0;
    
    if ac = 0 then set ac = 10; end if;
    
    select count(interm_test_lang) into @countz from students s
	where s.academy_id = id and student_status_id in (1,3,8);
	
    if ac - @countz = 0 then set res = 1; end if;
    
    return res;
end//

drop function if exists check_teacher_feedback//
create function check_teacher_feedback (ac int, id int)
returns int 
deterministic
begin
	declare res int;
    set res = 0;
    
    if ac = 0 then set ac = 10; end if;
    
    select count(teacher_student_feedback_id) into @teacher_feedback from students s
	where s.academy_id = id and student_status_id in (1,3,8);
    
    select count(teacher_score) into @teacher_score from students s
	where s.academy_id = id and student_status_id in (1,3,8);
    
    if ac - @teacher_feedback = 0 then 
		if ac - @teacher_score = 0 then
			set res = 1;
		end if;
	end if;
    
    return res;
end//

drop function if exists check_expert_feedback//
create function check_expert_feedback (ac int, id int)
returns int 
deterministic
begin
	declare res int;
    set res = 0;
    
    if ac = 0 then set ac = 10; end if;
    
    select count(expert_student_feedback_id) into @expert_feedback from students s
	where s.academy_id = id and student_status_id in (1,3,8);
    
    select count(expert_score) into @expert_score from students s
	where s.academy_id = id and student_status_id in (1,3,8);
    
    if ac - @expert_feedback = 0 then 
		if ac - @expert_score = 0 then
			set res = 1;
		end if;
	end if;
    
    return res;
end//

drop function if exists check_final_base//
create function check_final_base (ac int, id int)
returns int 
deterministic
begin
	declare res int;
    set res = 0;
    
    if ac = 0 then set ac = 10; end if;
    
    select count(final_base) into @countz from students s
	where s.academy_id = id and student_status_id in (1,3,8);
	
    if ac - @countz = 0 then set res = 1; end if;
    
    return res;
end//

drop function if exists check_final_lang//
create function check_final_lang (ac int, id int)
returns int 
deterministic
begin
	declare res int;
    set res = 0;
    
    if ac = 0 then set ac = 10; end if;
    
    select count(final_lang) into @countz from students s
	where s.academy_id = id and student_status_id in (1,3,8);
	
    if ac - @countz = 0 then set res = 1; end if;
    
    return res;
end//

drop function if exists check_interviewer_summary//
create function check_interviewer_summary (ac int, id int)
returns int 
deterministic
begin
	declare res int;
    set res = 0;
    
    if ac = 0 then set ac = 10; end if;
    
    select count(interviewer_comment) into @countz from students s
	where s.academy_id = id and student_status_id in (1,3,8);
	
    if ac - @countz = 0 then set res = 1; end if;
    
    return res;
end//

drop function if exists check_assigned_teachers//
create function check_assigned_teachers (teacher_type int, id int)
returns int 
deterministic
begin
	declare res int;
    set res = 0;
    
    select count(employee_id) into @countz from group_info_teachers git
		where git.academy_id = id and teacher_type_id = teacher_type;
	
    if @countz <> 0 then set res = 1; end if;
    
    return res;
end//

drop function if exists check_contributed_hours//
create function check_contributed_hours (teacher_type int, id int)
returns int 
deterministic
begin
	declare res int;
    set res = 0;
    
    select count(contributed_hours) into @countz from group_info_teachers git
		where git.academy_id = id and teacher_type_id = teacher_type;
	
    if @countz <> 0 then set res = 1; end if;
    
    return res;
end//

drop function if exists group_started_successfuly//
create function group_started_successfuly (i1 int, i2 int, i3 int, i4 int, i5 int, i6 int, i7 int)
returns int 
deterministic
begin
	declare res int;
    set res = 0;
    
    if i1 = 1 then
		if i2 = 1 then
			if i3 = 1 then
				if i4 = 1 then
					if i5 = 1 then
						if i6 = 1 then
							if i7 = 1 then
								set res = 1;
							end if;
						end if;
					end if;
				end if;
			end if;
		end if;
	end if;
       
    
    return res;
end//

drop function if exists group_ready_to_offering//
create function group_ready_to_offering (i1 int, i2 int, i3 int, i4 int, i5 int, i6 int, i7 int, i8 int, i9 int, i10 int)
returns int 
deterministic
begin
	declare res int;
    set res = 0;
    
    if i1 = 1 then
		if i2 = 1 then
			if i3 = 1 then
				if i4 = 1 then
					if i5 = 1 then
						if i6 = 1 then
							if i7 = 1 then
								if i8 = 1 then
									if i9 = 1 then
										if i10 = 1 then
											set res = 1;
										end if;
									end if;
								end if;
							end if;
						end if;
					end if;
				end if;
			end if;
		end if;
	end if;
       
    
    return res;
end//

drop function if exists group_ready_for_close//
create function group_ready_for_close (i1 int, i2 int, i3 int, i4 int, i5 int, i6 int, i7 int)
returns int 
deterministic
begin
	declare res int;
    set res = 0;
    
    if i1 = 1 then
		if i2 = 1 then
			if i3 = 1 then
				if i4 = 1 then
					if i5 = 1 then
						if i6 = 1 then
							if i7 = 1 then
								set res = 1;
							end if;
						end if;
					end if;
				end if;
			end if;
		end if;
	end if;       
    
    return res;
end//

drop function if exists check_list_report_total//
create function check_list_report_total (i1 int, i2 int, i3 int, i4 int, i5 int, i6 int, i7 int, i8 int, i9 int, i10 int, i11 int, i12 int,
                                        i13 int, i14 int, i15 int, i16 int, i17 int, i18 int, i19 int, i20 int, i21 int, i22 int)
returns float 
deterministic
begin
	declare res float;
    set res = 0;
    
    set res = i1 + i2 + i3 + i4 + i5 + i6 + i7 + i8 + i9 + i10 + i11 + i12 + i13 + i14 + i15 + i16 + i17 + i18 + i19 + i20 + i21 + i22;
    set res = round(res / 22 * 100 * 100) / 100;
    
    return res;
end//

drop function if exists get_teachers_names//
create function get_teachers_names (teacher_type int, id int)
returns varchar(255) 
deterministic
begin
	declare res varchar(255);
    
    SELECT teachers_select.name into res FROM 
			(SELECT
				group_concat(concat(" ",e.first_name_eng, " ", e.last_name_eng)) name,
				a.academy_id  aid
			FROM employee e
				join group_info_teachers git
					on git.employee_id = e.employee_id
                join academy a
					on git.academy_id = a.academy_id
			WHERE git.teacher_type_id = teacher_type
			GROUP BY a.academy_id) teachers_select
		WHERE teachers_select.aid = id;
    
    return res;
end//

DELIMITER ;