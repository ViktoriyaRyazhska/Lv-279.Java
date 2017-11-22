/* User
*
* Version 1.0-SNAPSHOT
*
* 15.11.17
*
* All rights reserved by DoubleO Team (Team#1)
*/


package ua.softserve.persistence.entity;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import ua.softserve.util.encrypt.aes.EncryptConverter;

import javax.persistence.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

//    @OneToOne
//    @JoinColumn(name = "country_id")
//    private Country country;


    @Column(name = "user_name", nullable = false)
    private String userName;

    @Convert(converter = EncryptConverter.class)
    @Column(nullable = false)
    private String email;

    @Convert(converter = EncryptConverter.class)
    @Column(name = "first_name")
    private String firstName;

    @Convert(converter = EncryptConverter.class)
    @Column(name = "last_name")
    private String lastName;

    @Convert(converter = EncryptConverter.class)
    private String phone;

    private String salt = "_";

    private String password = "_";

    @Column(name = "eng_level")
    private Integer englishLevel;


}
