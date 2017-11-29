package ua.softserve.persistence.entity;


import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Getter @Setter
@ToString
@Entity
@Table(name = "languages")
public class Languages {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "language_id")
    private int languageId;

    @NotNull
    @Column(name = "local")
    private String local;

    @NotNull
    @Column(name = "name")
    private String name;

    public Languages() {}
}
