package ua.softserve.service.dto;

import lombok.*;
import ua.softserve.persistence.entity.Feedback;
import ua.softserve.persistence.entity.Student;
import ua.softserve.persistence.entity.StudentTestData;
import ua.softserve.persistence.entity.User;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class StudentViewDto {
    private Integer id;
    private User user;
    private Integer academyId;
    private StudentTestData data;
    private EmployeeEngShortDto approvedBy;
    private Feedback teacherFeedback;
    private Feedback expertFeedback;
    private boolean removed;

    public static StudentViewDto of(Student student) {
        return new StudentViewDto(
                student.getId(),
                student.getUser(),
                student.getAcademy().getAcademyId(),
                student.getData(),
                student.getApprovedBy() == null ?
                        null :
                        EmployeeEngShortDto.of(student.getApprovedBy()),
                student.getTeacherFeedback(),
                student.getExpertFeedback(),
                student.isRemoved());
    }
}
