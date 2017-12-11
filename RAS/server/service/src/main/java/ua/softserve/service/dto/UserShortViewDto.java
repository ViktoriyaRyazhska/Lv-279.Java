package ua.softserve.service.dto;

import lombok.*;
import ua.softserve.persistence.entity.User;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class UserShortViewDto {
    private Integer id;
    private String fullName;

    public static UserShortViewDto of(User user) {
        return new UserShortViewDto(user.getId(), user.getFirstName() + " " + user.getLastName());
    }
}
