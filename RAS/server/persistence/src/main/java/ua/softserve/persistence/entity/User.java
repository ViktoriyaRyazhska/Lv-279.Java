package ua.softserve.persistence.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import ua.softserve.util.encrypt.aes.EncryptConverter;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "users")
@NamedStoredProcedureQuery(name = "findUsers",
                procedureName = "find_users",
                resultClasses = {User.class},
                parameters = {
                        @StoredProcedureParameter(name = "academyId", type = Integer.class, mode = ParameterMode.IN),
                        @StoredProcedureParameter(name = "academyStatus", type = Integer.class, mode = ParameterMode.IN)
                })
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "user_name", nullable = false)
    private String userName;

    @Convert(converter = EncryptConverter.class)
    @NotNull
    @Column
    private String email;

    @Convert(converter = EncryptConverter.class)
    @Column(name = "first_name")
    private String firstName;

    @Convert(converter = EncryptConverter.class)
    @Column(name = "last_name")
    private String lastName;

    @Convert(converter = EncryptConverter.class)
    private String phone;

    private String salt = "EMPTY";

    private String password = "EMPTY";

    @Column(name = "eng_level")
    private Integer englishLevel;
}