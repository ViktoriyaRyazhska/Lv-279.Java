package ua.softserve.persistence.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "profile_info")
public class ProfileInfo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "profile_id")
    private int profileId;

    @NotNull
    @Column(name = "profile_name")
    private String profileName;

    @ManyToOne
    @JoinColumn(name = "technology_id")
    private Technologies technologies;

}


