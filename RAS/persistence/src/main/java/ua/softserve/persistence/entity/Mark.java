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
@Table(name = "mark")
public class Mark {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "mark_id")
    private int id;

    @ManyToOne
    @JoinColumn(name = "characteristic_id")
    private Characteristic characteristic;

    @Column(name = "mark")
    private String markName;

    @Column(name = "description")
    private String description;

    @Override
    public String toString() {
        return "Mark{" +
                ", characteristic=" + characteristic +
                ", markName='" + markName + '\'' +
                ", description='" + description + '\'' +
                '}';
    }
}
