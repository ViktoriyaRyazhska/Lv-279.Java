package ua.softserve.persistence.dto;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class StudentsShortViewDto {
    private Integer id;
    private String fullName;
    private boolean checked = false;
}
