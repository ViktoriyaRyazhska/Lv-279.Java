package ua.softserve.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import ua.softserve.persistence.dto.AcademyDTO;
import ua.softserve.persistence.entity.Academy;
import ua.softserve.service.AcademyService;

import javax.servlet.http.HttpServletRequest;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import static java.util.Arrays.asList;

@RestController
public class AcademyRestController {
    @Autowired
    private AcademyService academyService;

    @RequestMapping(value = "/searchSite",method = RequestMethod.POST)
    public List<AcademyDTO> searchSite(HttpServletRequest request) {
        List<AcademyDTO> list = academyService.findWithEmployeeExperts();
        list = list.stream().limit(20).collect(Collectors.toList());
        return list;
    }
}
