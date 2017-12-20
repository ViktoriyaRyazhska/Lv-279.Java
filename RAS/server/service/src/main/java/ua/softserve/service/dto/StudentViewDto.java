package ua.softserve.service.dto;

import lombok.*;
import ua.softserve.persistence.entity.*;

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
    private StudentStatuses studentStatus;
    private EmployeeEngShortDto approvedBy;
    private Feedback teacherFeedback;
    private Feedback expertFeedback;
    private boolean removed;

    public static StudentViewDto of(Student student) {
        return new StudentViewDto(student.getId(), student.getUser(), student.getAcademy().getAcademyId(),
                student.getData(), student.getStudentStatus(),
                student.getApprovedBy() == null ? null : EmployeeEngShortDto.of(student.getApprovedBy()),
                student.getTeacherFeedback(), student.getExpertFeedback(), student.isRemoved());
    }

    public Student update(Student student) {
        student.setData(data);
        student.setStudentStatus(studentStatus);
        student.setTeacherFeedback(teacherFeedback);
        student.setExpertFeedback(expertFeedback);
        if (approvedBy != null) {
            student.setApprovedBy(new Employee(approvedBy.getEmployeeId()));
        }
        return student;
    }
}
