package ua.softserve.service;

import ua.softserve.persistence.entity.ItaTacticalReport;

import java.util.List;

public interface ItaTacticalReportService {

    ItaTacticalReport findById(int id);
    List<List<ItaTacticalReport>> generateItaTacticalReport();
}
