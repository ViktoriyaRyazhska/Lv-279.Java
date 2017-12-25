/*
 * CheckListRepositoryImplTest
 *
 * Version 1.0-SNAPSHOT
 *
 * 25.12.17
 *
 * All rights reserved by DoubleO Team (Team#1)
 * */
package ua.softserve.persistence.repo.impl;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import ua.softserve.persistence.dto.CheckListDto;

import javax.persistence.EntityManager;
import javax.persistence.StoredProcedureQuery;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
public class CheckListRepositoryImplTest {

    @Mock
    private EntityManager entityManager;

    @InjectMocks
    private CheckListRepositoryImpl checkListRepository;

    @Test
    public void reportCheckList() {

        StoredProcedureQuery reportCheckList = mock(StoredProcedureQuery.class);

        Object[] result = new Object[32];
        result[0] = (String) "Lv-279.Java";
        result[1] = null;
        result[2] = (String) "In Progress";
        result[3] = (String) "Viktoria Ryazhska";
        result[4] = (String) "Mykola Marchuk";
        result[5] = null;
        for (int i = 6; i < 32; i++) {
            result[i] = (byte) (i%2);
        }

        when(entityManager.createStoredProcedureQuery("reportCheckList")).thenReturn(reportCheckList);
        when(reportCheckList.getSingleResult()).thenReturn(result);

        CheckListDto checkListDto = checkListRepository.reportCheckList(586);

        assertEquals("Lv-279.Java", checkListDto.getReport().get("groupName"));
        assertEquals(null, checkListDto.getReport().get("cityName"));
        assertEquals("In Progress", checkListDto.getReport().get("status"));
        assertEquals("Viktoria Ryazhska", checkListDto.getReport().get("teachers"));
        assertEquals("Mykola Marchuk", checkListDto.getReport().get("experts"));

    }
}