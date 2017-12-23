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

/**
 * Check List By Groups Report Repository.
 */
public interface CheckListRepository {

    /**
     * Returns Check List By Groups DTO by academy.
     * @param academyId ID of academy.
     * @return Check List By Groups DTO.
     */
    CheckListDto reportCheckList(Integer academyId);

}
