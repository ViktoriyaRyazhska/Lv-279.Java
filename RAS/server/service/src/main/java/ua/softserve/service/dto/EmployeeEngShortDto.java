package ua.softserve.service.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import ua.softserve.persistence.entity.Employee;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class EmployeeEngShortDto {
    private int employeeId;
    private String firstNameEng;
    private String lastNameEng;

    public static EmployeeEngShortDto of(Employee employee) {
        return new EmployeeEngShortDto(employee.getEmployeeId(), employee.getFirstNameEng(), employee.getLastNameEng());
    }
}
