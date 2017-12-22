drop procedure if exists getTeachers;
DELIMITER $$
CREATE PROCEDURE getTeachers(IN academy_id_in int, IN teacher_type_id_in int, OUT teacher_full_name varchar(1000))
BEGIN
	declare i int;
    declare teachs_fn varchar(1000);
    declare teach_fn varchar(100);
    declare teach_ln varchar(100);
    set teachs_fn = "";
    set i = 0;
    select count(*) into @teach_count 
		from group_info_teachers 
		where academy_id = academy_id_in and teacher_type_id = teacher_type_id_in;
    while i < @teach_count do
		select e.first_name_eng, e.last_name_eng into teach_fn, teach_ln from group_info_teachers as git
			join employee as e on e.employee_id = git.employee_id
			where academy_id = academy_id_in and teacher_type_id = teacher_type_id_in limit 1 offset i;
		set i = i + 1;
        set teachs_fn = concat(teachs_fn, " ", teach_fn, " ", teach_ln, ";");
	end while;
    set teacher_full_name = teachs_fn;
END$$
DELIMITER ;