package ua.softserve.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ua.softserve.persistence.entity.History;
import ua.softserve.service.HistoryService;

import java.util.ArrayList;
import java.util.List;

@RestController
public class HistoryController {
    @Autowired
    private HistoryService historyService;

    @GetMapping(value = "/history/{id}")
    public ResponseEntity<List<History>> getHistory(@PathVariable int id) {
        return new ResponseEntity<>(historyService.findByAcademyId(id), HttpStatus.OK);
        }
}
