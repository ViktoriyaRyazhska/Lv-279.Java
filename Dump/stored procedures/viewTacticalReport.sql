drop view if exists tacticalReport;
CREATE VIEW tacticalReport AS
  SELECT
    year(a.start_date)                                                                     year,
    month(a.start_date)                                                                    month,
    a.academy_id                                                                           academy_id,
    gi.group_name,
    t.name                                                                                       cg,
    pi.profile_name                                                                    profile,
    lt.trasnlation                                                            location,
    gi.students_planned_to_enrollment                                                    requested,
    get_student_in_progress (a.academy_id) student_in_progress,
    get_student_status(a.academy_id, 8)         graduated,
    get_student_status(a.academy_id, 9)          hired,
    a.start_date,
    a.end_date,
    get_trainers(a.academy_id)                                                             trainers,
    a.free                                                                                 payment_status
  FROM academy a
    LEFT JOIN group_info gi
      ON a.academy_id = gi.academy_id
    LEFT JOIN profile_info pi
      ON gi.profile_id = pi.profile_id
    LEFT JOIN language_translations lt
      ON lt.item_id = a.city_id
    LEFT JOIN technologies t
      ON t.technology_id = a.technology_id
    WHERE lt.local LIKE 'en' AND lt.tag LIKE 'city'
  GROUP BY a.academy_id;
