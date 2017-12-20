drop procedure if exists getReportCheckList;
DELIMITER $$
CREATE PROCEDURE getReportCheckList(IN academy_id_in int)
BEGIN
	call get_teachers(academy_id_in,1, @teachers);
	call get_teachers(academy_id_in,2, @experts);
	call get_teachers(academy_id_in,3, @interviewers);
	call get_student_count(academy_id_in, @sc);
    call get_approved_by(academy_id_in, @approved_by);
    call get_english_level(academy_id_in, @english_level);
    call get_min_english_level(academy_id_in, @min_english_level);
    call get_entry_score(academy_id_in, @entry_score);
    call get_expert_feedback(academy_id_in, @expert_feedback);
    call get_expert_score(academy_id_in, @expert_score);
    call get_final_base(academy_id_in, @final_base);
    call get_final_lang(academy_id_in, @final_lang);
    call get_incoming_test(academy_id_in, @incoming_test);
    call get_interm_test_base(academy_id_in, @interm_test_base);
    call get_interm_test_lang(academy_id_in, @interm_test_lang);
    call get_interviewer_score(academy_id_in, @interviewer_score);
    call get_teacher_feedback(academy_id_in, @teacher_feedback);
    call get_teacher_score(academy_id_in, @teacher_score);
    call get_test_1(academy_id_in, @test_1);
    call get_test_2(academy_id_in, @test_2);
    call get_test_3(academy_id_in, @test_3);
    call get_test_4(academy_id_in, @test_4);
    call get_test_5(academy_id_in, @test_5);
    call get_test_6(academy_id_in, @test_6);
    call get_test_7(academy_id_in, @test_7);
    call get_test_8(academy_id_in, @test_8);
    call get_test_9(academy_id_in, @test_9);
    call get_test_10(academy_id_in, @test_10);
    IF @teachers <> 0 then set @teachers = 1; END IF;
    IF @experts <> 0 then set @experts = 1; END IF;
    IF @interviewers <> 0 then set @interviewers = 1; END IF;
    IF @sc = 0 then set @sc = 10; END IF;
    IF @min_english_level is null then set @min_english_level = 0; END IF;
    IF @sc - @approved_by <> 0 then set @approved_by = 0; else set @approved_by = 1; END IF;
    IF @sc - @english_level <> 0 then set @english_level = 0; else set @english_level = 1; END IF;
    IF @min_english_level < 8 then set @min_english_level = 0; else set @min_english_level = 1; END IF;
    IF @sc - @entry_score <> 0 then set @entry_score = 0; else set @entry_score = 1; END IF;
    IF @sc - @final_base <> 0 then set @final_base = 0; else set @final_base = 1; END IF;
    IF @sc - @final_lang <> 0 then set @final_lang = 0; else set @final_lang = 1; END IF;
    IF @sc - @incoming_test <> 0 then set @incoming_test = 0; else set @incoming_test = 1; END IF;
    IF @sc - @interm_test_base <> 0 then set @interm_test_base = 0; else set @interm_test_base = 1; END IF;
    IF @sc - @interm_test_lang <> 0 then set @interm_test_lang = 0; else set @interm_test_lang = 1; END IF;
    IF @sc - @interviewer_score <> 0 then set @interviewer_score = 0; else set @interviewer_score = 1; END IF;
    IF @sc - @test_1 <> 0 then set @test_1 = 0; else set @test_1 = 1; END IF;
    IF @sc - @test_2 <> 0 then set @test_2 = 0; else set @test_2 = 1; END IF;
    IF @sc - @test_3 <> 0 then set @test_3 = 0; else set @test_3 = 1; END IF;
    IF @sc - @test_4 <> 0 then set @test_4 = 0; else set @test_4 = 1; END IF;
    IF @sc - @test_5 <> 0 then set @test_5 = 0; else set @test_5 = 1; END IF;
    IF @sc - @test_6 <> 0 then set @test_6 = 0; else set @test_6 = 1; END IF;
    IF @sc - @test_7 <> 0 then set @test_7 = 0; else set @test_7 = 1; END IF;
    IF @sc - @test_8 <> 0 then set @test_8 = 0; else set @test_8= 1; END IF;
    IF @sc - @test_9 <> 0 then set @test_9 = 0; else set @test_9 = 1; END IF;
    IF @sc - @test_10 <> 0 then set @test_10 = 0; else set @test_10 = 1; END IF;
    
    IF @sc - @expert_feedback <> 0 then set @expert_feedback = 0;
    elseif @sc - @expert_score <> 0 then set @expert_feedback = 0;
    else set @expert_feedback = 1; END IF;
    
    IF @sc - @teacher_feedback <> 0 then set @teacher_feedback = 0;
    elseif @sc - @teacher_score <> 0 then set @teacher_feedback = 0;
    else set @teacher_feedback = 1; END IF;
    
    select 
		gi.group_name,
        lt.trasnlation,
        acs.name,
		@teachers,
        @experts,
        @interviewers,
        @approved_by,
        @english_level,
        @min_english_level,
        @entry_score,
        @expert_feedback,
        @final_base,
        @final_lang,
        @incoming_test,
        @interm_test_base,
        @interm_test_lang,
        @interviewer_score,
        @teacher_feedback,
        @test_1,
        @test_2,
        @test_3,
        @test_4,
        @test_5,
        @test_6,
        @test_7,
        @test_8,
        @test_9,
        @test_10
	from group_info gi
		join academy a
			on gi.academy_id = a.academy_id
		join academy_stages acs
			on acs.stage_id = a.stage_id
		join language_translations lt
			on lt.item_id = a.city_id
            and lt.tag like 'city'
            and lt.local like 'en'
    where gi.academy_id = academy_id_in;
END$$
DELIMITER ;

call getReportCheckList(636);