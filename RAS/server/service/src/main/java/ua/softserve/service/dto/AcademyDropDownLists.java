package ua.softserve.service.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import ua.softserve.persistence.entity.*;

import java.util.List;
import java.util.Set;

@Getter
@Setter
@ToString
public class AcademyDropDownLists {
    List<AcademyStages> academyStages;
    Set<LanguageTranslations> cityNames;
    List<Directions> direction;
    List<Technologies> technologie;
    List<ProfileInfo> profile;
}
