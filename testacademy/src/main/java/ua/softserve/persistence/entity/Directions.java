package ua.softserve.persistence.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "directions")
public class Directions {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "direction_id")
    private int directionId;

    @NotNull
    @Column(name = "name")
    private String name;

    @Column(name = "ita")
    private Byte ita;
}
