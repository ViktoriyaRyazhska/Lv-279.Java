//package ua.softserve.controller;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Controller;
//import org.springframework.ui.Model;
//import org.springframework.web.bind.WebDataBinder;
//import org.springframework.web.bind.annotation.*;
//import ua.softserve.persistence.entity.Feedback;
//import ua.softserve.persistence.entity.Mark;
//import ua.softserve.persistence.entity.Students;
//import ua.softserve.service.FeedbackService;
//import ua.softserve.service.MarkService;
//import ua.softserve.service.StudentService;
//import ua.softserve.service.dto.FeedbackDTO;
//import ua.softserve.service.editor.MarkEditor;
//
//import java.util.ArrayList;
//import java.util.HashMap;
//import java.util.List;
//import java.util.Map;
//
//@Controller
//@RequestMapping("/feedback")
//public class FeedbackController {
//    @Autowired
//    private FeedbackService feedbackService;
//
//    @Autowired
//    private StudentService studentService;
//
//    @Autowired
//    private MarkService markService;
//
//    @Autowired
//    private MarkEditor markEditor;
//
//    @RequestMapping("/addStudentFeedback")
//    public String addStudentFeedback(@RequestParam("studentId") Integer studentId,
//                                     @RequestParam("isTeacher") Integer isTeacher,
//                                     Model model) {
//
//        FeedbackDTO feedbackDTO = new FeedbackDTO();
//
//        System.out.println(studentId);
//        System.out.println(isTeacher);
//        model.addAttribute("feedbackDTO", feedbackDTO);
//
//        model.addAttribute("sId", studentId);
//        model.addAttribute("isT", isTeacher);
//        List<Mark> learningAbility = markService.findAllByCharacteristicId(1);
//        List<Mark> overallTechnicalCompetence = markService.findAllByCharacteristicId(2);
//        List<Mark> passionalInitiative = markService.findAllByCharacteristicId(3);
//        List<Mark> teamWork = markService.findAllByCharacteristicId(4);
//        List<Mark> gettingThingsDone = markService.findAllByCharacteristicId(5);
//        List<Mark> activeCommunicator = markService.findAllByCharacteristicId(6);
//
//        model.addAttribute("learningAbility", learningAbility);
//        model.addAttribute("overallTechnicalCompetence", overallTechnicalCompetence);
//        model.addAttribute("passionalInitiative", passionalInitiative);
//        model.addAttribute("teamWork", teamWork);
//        model.addAttribute("gettingThingsDone", gettingThingsDone);
//        model.addAttribute("activeCommunicator", activeCommunicator);
//
//        List<Mark> markList = markService.findAll();
//        Map<Integer,String> map = new HashMap<>();
//        List<Integer> index = new ArrayList<>();
//        for (int i = 1; i <= markList.size(); i++) {
//            index.add(i);
//            map.put(markList.get(i-1).getId(), markList.get(i-1).getDescription());
//        }
//        model.addAttribute("mapMark", map);
//        model.addAttribute("indexList", index);
//        return "feedback-student-form";
//    }
//
//    @RequestMapping("/processFeedbackForm")
//    public String processFeedbackForm(@ModelAttribute("feedbackDTO") FeedbackDTO feedbackDTO,
//                                      Model model) {
//        System.out.println(feedbackDTO);
//        if(feedbackDTO.getStudentId() != null) {
//            System.out.println("Im here");
//            Students student = studentService.findById(feedbackDTO.getStudentId());
//            if(feedbackDTO.getIsTeacher() == 1) {
//                student.setTeacherFeedback(convert(feedbackDTO));
//            } else {
//                student.setExpertFeedback(convert(feedbackDTO));
//            }
//            studentService.save(student);
//        }
//
//        List<Student> students = studentService.getStudentFromGroup(796);
//        model.addAttribute("allStudent", students);
//        return "student-of-group-feedback";
//    }
//
//    @RequestMapping("/addFeedback")
//    public String addFeedback(Model model) {
//        model.addAttribute("feedbackDTO", new FeedbackDTO());
//
//        List<Mark> learningAbility = markService.findAllByCharacteristicId(1);
//        List<Mark> overallTechnicalCompetence = markService.findAllByCharacteristicId(2);
//        List<Mark> passionalInitiative = markService.findAllByCharacteristicId(3);
//        List<Mark> teamWork = markService.findAllByCharacteristicId(4);
//        List<Mark> gettingThingsDone = markService.findAllByCharacteristicId(5);
//        List<Mark> activeCommunicator = markService.findAllByCharacteristicId(6);
//
//        model.addAttribute("learningAbility", learningAbility);
//        model.addAttribute("overallTechnicalCompetence", overallTechnicalCompetence);
//        model.addAttribute("passionalInitiative", passionalInitiative);
//        model.addAttribute("teamWork", teamWork);
//        model.addAttribute("gettingThingsDone", gettingThingsDone);
//        model.addAttribute("activeCommunicator", activeCommunicator);
//
//        List<Mark> markList = markService.findAll();
//        Map<Integer,String> map = new HashMap<>();
//        List<Integer> index = new ArrayList<>();
//        for (int i = 1; i <= markList.size(); i++) {
//            index.add(i);
//            map.put(markList.get(i-1).getId(), markList.get(i-1).getDescription());
//        }
//        model.addAttribute("mapMark", map);
//        model.addAttribute("indexList", index);
//        return "feedback-form";
//    }
//
//    @PostMapping("/processForm")
//    public String processForm(@ModelAttribute("feedbackDTO") FeedbackDTO feedbackDTO) {
//        feedbackService.saveDTO(feedbackDTO);
//        return "feedback-confirmation";
//    }
//
//    @RequestMapping(value = "/showFeedbacks",method = RequestMethod.GET)
//    public String showFeedbacks(Model model) {
//        List<Feedback> allFeedback = feedbackService.findAll();
//        model.addAttribute("allFeedback", allFeedback);
//        return "showFeedbacks";
//    }
//
//    @RequestMapping(value = "/allGroupStudentFeedback",method = RequestMethod.GET)
//    public String getGroupAllFeedback(Model model) {
//        List<Student> students = studentService.getStudentFromGroup(796);
//        model.addAttribute("allStudent", students);
//        return "student-of-group-feedback";
//    }
//
//    @InitBinder("feedbackDTO")
//    public void binder(WebDataBinder binder) {
//        binder.registerCustomEditor(Mark.class,"learningAbility", markEditor);
//        binder.registerCustomEditor(Mark.class,"overallTechnicalCompetence", markEditor);
//        binder.registerCustomEditor(Mark.class,"passionalInitiative", markEditor);
//        binder.registerCustomEditor(Mark.class,"teamWork", markEditor);
//        binder.registerCustomEditor(Mark.class,"gettingThingsDone", markEditor);
//        binder.registerCustomEditor(Mark.class,"activeCommunicator", markEditor);
//    }
//
//    public Feedback convert(FeedbackDTO feedbackDTO) {
//            Feedback feedback = new Feedback();
//
//            feedback.setLearningAbility(feedbackDTO.getLearningAbility());
//            feedback.setActiveCommunicator(feedbackDTO.getActiveCommunicator());
//            feedback.setGettingThingsDone(feedbackDTO.getGettingThingsDone());
//            feedback.setOverallTechnicalCompetence(feedbackDTO.getOverallTechnicalCompetence());
//            feedback.setPassionalInitiative(feedbackDTO.getPassionalInitiative());
//            feedback.setTeamWork(feedbackDTO.getTeamWork());
//            feedback.setSummary(feedbackDTO.getSummary());
//
//            return feedback;
//    }
//}
