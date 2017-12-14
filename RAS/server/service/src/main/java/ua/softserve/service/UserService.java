package ua.softserve.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import ua.softserve.persistence.entity.User;
import ua.softserve.service.dto.UserShortViewDto;

import java.util.List;

public interface UserService {

    Page<UserShortViewDto> findPageById(Integer notInAcademy, String id, Integer page, Integer size, String direction);

    List<UserShortViewDto> getAllUsersByAcademy(Integer academyId);
}
