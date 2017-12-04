package ua.softserve.service;

import ua.softserve.service.dto.ItaTacticalPlanByGroupStageDto;

import java.util.List;

public interface ItaTacticalPlanByGroupStageDtoService {
    ItaTacticalPlanByGroupStageDto findById( int id);
    List<ItaTacticalPlanByGroupStageDto> findAll();

}
