/*
 * CustomRepository
 *
 * Version 1.0-SNAPSHOT
 *
 * 21.12.17
 *
 * All rights reserved by DoubleO Team (Team#1)
 * */

package ua.softserve.persistence.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import ua.softserve.persistence.entity.views.CheckListReport;

import java.util.List;

/**
 * Check List By Groups Report Repository.
 */
public interface CheckListReportRepository extends JpaRepository<CheckListReport, Integer>{

    List<CheckListReport> findAllByAcademyIdIn(List<Integer> ids);

}
