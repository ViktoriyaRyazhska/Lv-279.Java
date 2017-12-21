package ua.softserve.service.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class AcademyForSaveDTO extends AcademyDTO {
    private int directionId;
    private int technologieId;
    private int profileId;
    private int cityId;
}
