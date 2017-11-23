package ua.softserve.data.entity;

import com.sun.istack.internal.NotNull;

import javax.persistence.*;

@Entity
@Table(name = "directions")
public class Directions {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int direction_id;

    @NotNull
    @Column(name = "name")
    private String name;

    @NotNull
    @Column(name = "item")
    private String item;

    @Column(name = "crm_id")
    private Integer crm_id;

    @Column(name = "ita")
    private Byte ita;

    @Column(name = "vacancy", columnDefinition = "")
    private Byte vacancy;

    @Column(name = "status")
    private Byte status;

    public Directions() {}

    public int getDirection_id() {
        return direction_id;
    }

    public void setDirection_id(int direction_id) {
        this.direction_id = direction_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getItem() {
        return item;
    }

    public void setItem(String item) {
        this.item = item;
    }

    public Integer getCrm_id() {
        return crm_id;
    }

    public void setCrm_id(Integer crm_id) {
        this.crm_id = crm_id;
    }

    public Byte getIta() {
        return ita;
    }

    public void setIta(Byte ita) {
        this.ita = ita;
    }

    public Byte getVacancy() {
        return vacancy;
    }

    public void setVacancy(Byte vacancy) {
        this.vacancy = vacancy;
    }

    public Byte getStatus() {
        return status;
    }

    public void setStatus(Byte status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "Directions{" +
                "direction_id=" + direction_id +
                ", name='" + name + '\'' +
                ", item='" + item + '\'' +
                ", crm_id=" + crm_id +
                ", ita=" + ita +
                ", vacancy=" + vacancy +
                ", status=" + status +
                '}';
    }
}
