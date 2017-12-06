package ua.softserve.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import ua.softserve.persistence.entity.Academy;
import ua.softserve.service.AcademyService;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

import static java.util.Arrays.asList;

@RestController
public class AcademyRestController {
    @Autowired
    private AcademyService academyService;

    @RequestMapping(value = "/searchSite",method = RequestMethod.POST)
    public @ResponseBody List<String> searchSite(HttpServletRequest request) {
        Academy list = academyService.findWithEmployeeExperts(1);
        return asList("A", "B");
    }
}
