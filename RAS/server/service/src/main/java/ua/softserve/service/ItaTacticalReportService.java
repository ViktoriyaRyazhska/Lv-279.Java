package ua.softserve.service;

import ua.softserve.persistence.entity.ItaTacticalReport;

import java.util.List;
import java.util.Map;

public interface ItaTacticalReportService {

    ItaTacticalReport findById(int id);
    Map<String,List<ItaTacticalReport>> generateItaTacticalReport();
}
