package ua.softserve.controller;


import ua.softserve.persistence.entity.GroupInfo;
import ua.softserve.persistence.repo.GroupInfoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;


@Controller
public class AcademyController {
    @Autowired
    GroupInfoRepository groupInfoRepository;

    @RequestMapping(value = "/academy/addgroup",method = RequestMethod.GET, produces = {"application/json"})
    public ResponseEntity<GroupInfo> getAcademys() {
        return new ResponseEntity<GroupInfo>(groupInfoRepository.findByAcademyAcademyId(5), HttpStatus.OK);
    }
}

