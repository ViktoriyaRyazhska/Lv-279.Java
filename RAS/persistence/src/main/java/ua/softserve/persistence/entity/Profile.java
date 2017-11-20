package ua.softserve.persistence.entity;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import javax.validation.constraints.NotNull;


@ToString
@Getter @Setter
@Entity
@Table(name = "profile")
public class Profile {

    @Id
    @GeneratedValue
    @Column(name = "profile_id")
    private int profileId;

    @NotNull
    @Column(name = "profile_name")
    private String profileName;

    public Profile() {}
}


