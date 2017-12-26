package ua.softserve.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;
import ua.softserve.persistence.repo.UserRepository;
import ua.softserve.service.UserService;
import ua.softserve.service.dto.UserShortViewDto;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    @Transactional
    public List<UserShortViewDto> getAllUsersByAcademy(Integer academyId) {
        return userRepository.findAllByAcademy(academyId).stream().map(UserShortViewDto::of)
                .collect(Collectors.toList());
    }

    /**
     * Get list of UserShortViewDto using pagination
     *
     * @param notInAcademy - id of group in which we want to add new students.
     *                     We need to print only those users who are not students of the selected group
     * @param id           - id from table filter.
     * @param page         - number of page
     * @param size         - count of users per page
     * @param direction    - asc of desc
     * @return - page with the corresponding number,
     * number of records, and filtering,
     * and which contains a list of users to display on the UI
     */
    @Override
    @Transactional
    public Page<UserShortViewDto> findPageById(Integer notInAcademy, String id, Integer page, Integer size,
                                               String direction) {
        Pageable pageable = new PageRequest(page, size, dirOf(direction), "id");

        return userRepository.findByIdAndName(wrapForLike(id), notInAcademy, pageable).map(UserShortViewDto::of);
    }

    /**
     * Transform sorting keywords from UI to SQl keywords
     *
     * @param dir - asc of desc
     * @return - ASC of DESC
     */
    private Sort.Direction dirOf(String dir) {
        return dir != null && dir.toLowerCase().equals("desc") ? Sort.Direction.DESC : Sort.Direction.ASC;
    }

    /**
     * Wrap input string to format %string% for using it in query
     *
     * @param value - input string
     * @return - string wrapped in %
     */
    private String wrapForLike(String value) {
        return StringUtils.isEmpty(value) ? "%" : "%" + value + "%";
    }

}
