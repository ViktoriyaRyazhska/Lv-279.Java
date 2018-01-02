package ua.softserve.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ua.softserve.persistence.repo.UserRepository;
import ua.softserve.service.UserService;
import ua.softserve.service.dto.UserShortViewDto;

import java.util.List;
import java.util.stream.Collectors;

import static ua.softserve.persistence.constants.ConstantsFromDb.*;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    @Transactional
    public List<UserShortViewDto> getAllUsersByAcademyAndStatus(Integer academyId) {
        return userRepository.findAllByAcademyAndStatus(academyId, STUDENT_ID).stream()
                .map(UserShortViewDto::of)
                .collect(Collectors.toList());
    }
}
