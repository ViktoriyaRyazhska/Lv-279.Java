package ua.softserve.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;
import ua.softserve.persistence.dto.FeedbackDTO;
import ua.softserve.persistence.dto.StudentsViewDto;
import ua.softserve.persistence.entity.Feedback;
import ua.softserve.persistence.entity.Mark;
import ua.softserve.persistence.entity.Student;
import ua.softserve.service.FeedbackService;
import ua.softserve.service.MarkService;
import ua.softserve.service.StudentService;
import ua.softserve.service.editor.MarkEditor;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/feedback")
public class FeedbackController {
    @Autowired
    private FeedbackService feedbackService;

    @Autowired
    private StudentService studentService;

    @Autowired
    private MarkService markService;

    @Autowired
    private MarkEditor markEditor;


    @RequestMapping("/addFeedback")
    public String addFeedback(Model model) {
        model.addAttribute("feedbackDTO", new FeedbackDTO());

        List<Mark> learningAbility = markService.findAllByCharacteristicId(1);
        List<Mark> overallTechnicalCompetence = markService.findAllByCharacteristicId(2);
        List<Mark> passionalInitiative = markService.findAllByCharacteristicId(3);
        List<Mark> teamWork = markService.findAllByCharacteristicId(4);
        List<Mark> gettingThingsDone = markService.findAllByCharacteristicId(5);
        List<Mark> activeCommunicator = markService.findAllByCharacteristicId(6);

        model.addAttribute("learningAbility", learningAbility);
        model.addAttribute("overallTechnicalCompetence", overallTechnicalCompetence);
        model.addAttribute("passionalInitiative", passionalInitiative);
        model.addAttribute("teamWork", teamWork);
        model.addAttribute("gettingThingsDone", gettingThingsDone);
        model.addAttribute("activeCommunicator", activeCommunicator);

        List<Mark> markList = markService.findAll();
        Map<Integer,String> map = new HashMap<>();
        List<Integer> indx = new ArrayList<>();
        for (int i = 1; i <= markList.size(); i++) {
            indx.add(i);
            map.put(markList.get(i-1).getId(), markList.get(i-1).getDescription());
        }
        model.addAttribute("mapAP", map);
        model.addAttribute("indxList", indx);
        return "feedback-form";
    }

    @PostMapping("/processForm")
    public String processForm(@ModelAttribute("feedbackDTO") FeedbackDTO feedbackDTO) {
        System.out.println(feedbackDTO);
        feedbackService.saveDTO(feedbackDTO);
        return "feedback-confirmation";
    }


    @GetMapping("/showFeedbacks")
    public String showFeedbacks(Model model) {
        List<Feedback> allFeedback = feedbackService.findAll();
        model.addAttribute("allFeedback", allFeedback);
        return "showFeedbacks";
    }

    @RequestMapping(value = "/allGroupStudentFeedback",method = RequestMethod.GET)
    public String getGroupAllFeedback(Model model) {
        List<StudentsViewDto> students = studentService.getAllStudentsOfAcademy(796);
        model.addAttribute("allStudent", students);
        return "student-of-group-feedback";
    }

    @InitBinder("feedbackDTO")
    public void binder(WebDataBinder binder) {
        binder.registerCustomEditor(Mark.class,"learningAbility", markEditor);
        binder.registerCustomEditor(Mark.class,"overallTechnicalCompetence", markEditor);
        binder.registerCustomEditor(Mark.class,"passionalInitiative", markEditor);
        binder.registerCustomEditor(Mark.class,"teamWork", markEditor);
        binder.registerCustomEditor(Mark.class,"gettingThingsDone", markEditor);
        binder.registerCustomEditor(Mark.class,"activeCommunicator", markEditor);
    }
}
