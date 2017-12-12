/*
* User
*
* Version 1.0-SNAPSHOT
*
* 15.11.17
*
* All rights reserved by DoubleO Team (Team#1)
* */

package ua.softserve.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import ua.softserve.persistence.entity.User;
import ua.softserve.service.dto.UserShortViewDto;

import java.util.List;

public interface UserService {

    void save(User user);

    User findOne(int id);

    List<User> findAll();

    void remove(User user);

    Page<UserShortViewDto> findPageById(Integer notInAcademy, String id, Integer page, Integer size, String direction);

    List<UserShortViewDto> getAllUsersByAcademy(Integer academyId);
}
