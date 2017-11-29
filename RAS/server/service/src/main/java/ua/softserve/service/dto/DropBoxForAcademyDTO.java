package ua.softserve.service.dto;

import lombok.Getter;
import lombok.Setter;
import ua.softserve.persistence.entity.*;

import java.util.List;

@Setter @Getter
public class DropBoxForAcademyDTO {
    List<AcademyStages> academyStages;
    List<LanguageTranslations> cityNames;
    List<Directions> direction;
    List<Technologies> technologie;
    List<Profile> profile; //rename
}
