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
import ua.softserve.persistence.dto.CheckListDto;
import ua.softserve.persistence.repo.AcademyRepository;
import ua.softserve.persistence.repo.CheckListRepository;
import ua.softserve.service.CheckListReportService;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class CheckListReportServiceImpl implements CheckListReportService {
    @Autowired
    private AcademyRepository academyRepository;
    @Autowired
    private CheckListRepository checkListRepository;

    @Override
    public List<CheckListDto> getCheckListDto() {
        List<Integer> allAcademiesId = academyRepository.findAllAcademyId()
                .stream()
                .limit(50)
                .collect(Collectors.toList());
        System.out.println(allAcademiesId);

        List<CheckListDto> checkListDtos = new ArrayList<>();

        for (Integer academyId : allAcademiesId) {
            checkListDtos.add(checkListRepository.reportCheckList(academyId));
        }
        return checkListDtos;
    }

}
