/*
 * CheckListByGroupsDto2ServiceImpl
 *
 * Version 1.0-SNAPSHOT
 *
 * 03.12.17
 *
 * All rights reserved by DoubleO Team (Team#1)
 * */

package ua.softserve.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ua.softserve.persistence.entity.views.CheckListReport;
import ua.softserve.persistence.repo.AcademyRepository;
import ua.softserve.persistence.repo.CheckListReportRepository;
import ua.softserve.service.CheckListReportService;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Implementation of Check List By Groups Report Service.
 */
@Service
public class CheckListReportServiceImpl implements CheckListReportService {
    @Autowired
    private AcademyRepository academyRepository;
    @Autowired
    private CheckListReportRepository checkListReportRepository;

    /**
     * Generate Check List By Groups Report.
     * @return list of Check List By Groups DTOs
     */
    @Override
    public List<CheckListReport> getCheckListDto() {
        // TODO filters
        List<Integer> allAcademiesId = academyRepository.findAllAcademyId()
                .stream()
                .limit(50)
                .collect(Collectors.toList());

        return checkListReportRepository.findAllByAcademyIdIn(allAcademiesId);
    }

}
