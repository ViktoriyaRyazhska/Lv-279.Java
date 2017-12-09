package ua.softserve.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ua.softserve.persistence.entity.Academy;
import ua.softserve.persistence.repo.GroupInfoRepository;
import ua.softserve.persistence.repo.LanguageTranslationsRepository;
import ua.softserve.service.AcademyService;
import ua.softserve.service.ItaTacticalPlanByGroupStageDtoService;
import ua.softserve.service.dto.ItaTacticalPlanByGroupStageDto;

import java.util.ArrayList;
import java.util.List;

@Service
public class ItaTacticalPlanByGroupStageDtoServiceImpl implements ItaTacticalPlanByGroupStageDtoService {

    @Autowired
    AcademyService academyService;
    @Autowired
    LanguageTranslationsRepository languageTranslationsRepository;
    @Autowired
    GroupInfoRepository groupInfoRepository;


    @Override
    public ItaTacticalPlanByGroupStageDto findById(int id) {
        ItaTacticalPlanByGroupStageDto dto = new ItaTacticalPlanByGroupStageDto();
        Academy academy = academyService.findOne(id);
        dto.setGroupId(id);
        dto.setCG(academy.getTechnologies().getName());
        dto.setLocation(languageTranslationsRepository.getOneCityNameTranslationByItemId(academy.getCity().getCityId()));
        dto.setStartDate(academy.getStartDate());
        dto.setEndDate(academy.getEndDate());
        dto.setGroupStatus(academy.getAcademyStages().getName());
        dto.setPaymentSatus(academy.getFree() == 1 ? "Founded by Softserve" : "Open group");
//        dto.setGroupName(groupInfoRepository.findByAcademyAcademyId(academy.getAcademyId()).getGroupName());
//        dto.setProfile(groupInfoRepository.findByAcademyAcademyId(academy.getAcademyId()).getProfileInfo().getProfileName());

        return dto;
    }

    @Override
    public List<ItaTacticalPlanByGroupStageDto> findAll() {
        List<ItaTacticalPlanByGroupStageDto> itaTacticalPlanByGroupStageDtos = new ArrayList<ItaTacticalPlanByGroupStageDto>();
        List<Academy> academies = academyService.getAllAcademies();
        for (Academy a : academies) {
            itaTacticalPlanByGroupStageDtos.add(this.findById(a.getAcademyId()));
        }
        return itaTacticalPlanByGroupStageDtos;
    }

}
