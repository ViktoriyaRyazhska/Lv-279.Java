//package ua.softserve.persistence.repo.impl;
//
//import ua.softserve.persistence.dto.ItaTacticalReportDTO;
//import ua.softserve.persistence.repo.ItaTacticalReportRepository;
//
//import javax.persistence.EntityManager;
//import javax.persistence.ParameterMode;
//import javax.persistence.PersistenceContext;
//import javax.persistence.StoredProcedureQuery;
//import java.util.*;
//
//public class ItaTacticalReportRepositoryImpl implements ItaTacticalReportRepository {
//    @PersistenceContext
//    private EntityManager entityManager;
//
//    @Override
//    public ItaTacticalReportDTO reportItaTactical(Integer academyId){
//        StoredProcedureQuery reportItaTactical = entityManager.createStoredProcedureQuery("getItaTacticalReport");
//        reportItaTactical.registerStoredProcedureParameter("academy_id_in", Integer.class, ParameterMode.IN);
//        reportItaTactical.setParameter("academy_id_in", academyId);
//        reportItaTactical.execute();
//        Object[] singleResult = (Object[]) reportItaTactical.getSingleResult();
//        ItaTacticalReportDTO itaTacticalReportDTO = new ItaTacticalReportDTO();
//        Map<String,Object> report = new HashMap<>();
//     return itaTacticalReportDTO;
//    }
//}
