package ua.softserve.persistence.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Getter @Setter
@Entity
@Table(name = "profile_info")
public class ProfileInfo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "profile_id")
    private Integer profileId;

    @NotNull
    @Column(name = "profile_name")
    private String profileName;

    @ManyToOne
    @JoinColumn(name = "technology_id")
    private Technologies technologies;

    public ProfileInfo() {}
}
