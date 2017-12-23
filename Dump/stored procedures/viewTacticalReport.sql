create view  tacticalReport as
SELECT
  year(academy.start_date) year,
  month(academy.start_date) month,
  group_info.group_name,
  profile_info.profile_name profile,
  language_translations.trasnlation location,
  group_info.students_planned_to_enrollment requested,
  (SELECT count(students.student_status_id)
   FROM students
   WHERE students.academy_id = academy.academy_id AND students.student_status_id IN (1, 2, 3)) study_in_progress,
  (SELECT count(students.student_status_id)
   FROM students
   WHERE students.academy_id = academy.academy_id AND students.student_status_id = 8) graduated,
  (SELECT count(students.student_status_id) 
   FROM students
   WHERE students.academy_id = academy.academy_id AND students.student_status_id = 9) hired,
  academy.start_date,
  academy.end_date,
  (SELECT selas.name
   FROM (SELECT
           group_concat(concat(" ",employee.first_name_eng, " ", employee.last_name_eng)) name,
           academy.academy_id  aid
         FROM employee, group_info_teachers, academy
         WHERE group_info_teachers.academy_id = academy.academy_id AND
               employee.employee_id = group_info_teachers.employee_id AND group_info_teachers.teacher_type_id IN (1, 2)
         GROUP BY academy.academy_id) selas
   WHERE selas.aid = academy.academy_id) trainers

FROM academy
  LEFT JOIN group_info
    ON academy.academy_id = group_info.academy_id
  LEFT JOIN profile_info
    ON group_info.profile_id = profile_info.profile_id
  LEFT JOIN language_translations
    ON language_translations.item_id = academy.city_id
  LEFT JOIN group_info_teachers
    ON group_info_teachers.academy_id = academy.academy_id
  LEFT JOIN employee
    ON employee.employee_id = group_info_teachers.employee_id
WHERE language_translations.local LIKE 'en' AND language_translations.tag LIKE 'city'
group by academy.academy_id;