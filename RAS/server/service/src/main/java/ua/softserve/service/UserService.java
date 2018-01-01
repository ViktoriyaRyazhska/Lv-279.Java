package ua.softserve.service;

import ua.softserve.service.dto.UserShortViewDto;

import java.util.List;

public interface UserService {

    List<UserShortViewDto> getAllUsersByAcademyAndStatus(Integer academyId);
}
