package ua.softserve.persistence.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "characteristic")
public class Characteristic {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "characteristic_id")
    private int id;

    @Column(name = "name")
    private String characteristicName;

    @Override
    public String toString() {
        return "Characteristic{" +
                "characteristicName='" + characteristicName + '\'' +
                '}';
    }
}
