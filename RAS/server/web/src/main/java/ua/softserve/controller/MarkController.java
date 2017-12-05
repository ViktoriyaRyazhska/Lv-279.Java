package ua.softserve.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import ua.softserve.persistence.entity.Mark;
import ua.softserve.service.MarkService;

import java.util.List;

@RestController
public class MarkController {

    @Autowired
    private MarkService markService;

    @RequestMapping(value = "/marks", method = RequestMethod.GET, produces = "application/json")
    @CrossOrigin(origins = "http://localhost:4200")
    public ResponseEntity<List<Mark>> getAllMarks() {
        return new ResponseEntity<List<Mark>>(markService.findAll(), HttpStatus.OK);
    }

    @RequestMapping(value = "/mark", method = RequestMethod.GET, produces = "application/json")
    @CrossOrigin(origins = "http://localhost:4200")
    public ResponseEntity<List<Mark>> getMarks() {
        return new ResponseEntity<List<Mark>>(markService.findAllByCharacteristicId(1), HttpStatus.OK);
    }
}
