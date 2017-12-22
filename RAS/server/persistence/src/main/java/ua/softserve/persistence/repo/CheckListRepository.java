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

import ua.softserve.persistence.dto.CheckListDto;

public interface CheckListRepository {

    CheckListDto reportCheckList(Integer academyId);

}
