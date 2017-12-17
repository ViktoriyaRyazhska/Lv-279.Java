package ua.softserve.service.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.List;

@Getter
@Setter
@ToString
public class AcademyForViewDTO extends AcademyDTO{
    private Integer id;
    private Integer academyId;
    private String paymentStatus;
    private String profileName;
    private String directionName;
    private String technologyName;
    private String cityName;
    private String status;
    private List<String> experts;
    private String name;
}
