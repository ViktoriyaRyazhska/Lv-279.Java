select academy.academy_id, group_name, profile_info.profile_name, language_translations.trasnlation,students_planned_to_graduate, students_planned_to_enrollment,start_date ,end_date, free,
employee.first_name_eng, employee.last_name_eng
    from academy 
join group_info
on academy.academy_id=group_info.academy_id
join profile_info
on group_info.profile_id = profile_info.profile_id
join language_translations
on language_translations.item_id = academy.city_id
join group_info_teachers 
on group_info_teachers.academy_id = academy.academy_id
join employee
on group_info_teachers.employee_id = employee.employee_id
where language_translations.tag like 'city' and language_translations.local like 'en'

