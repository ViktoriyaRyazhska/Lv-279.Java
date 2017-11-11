package ua.softserve.data.entity;

import com.sun.istack.internal.NotNull;

import javax.persistence.*;

@Entity
@Table(name = "city")
public class City {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int city_id;

    @NotNull
    @Column(name = "crm_id")
    private int crm_id;

    @Column(name = "country_id")
    private Integer country_id;

    @Column(name = "status")
    private Byte status;

    @Column(name = "ita")
    private Integer ita;

    @Column(name = "vacancy")
    private Integer vacancy;

    @Column(name = "state_id", columnDefinition = "INT(11) UNSIGNED")
    private Integer state_id;

    public City() {}

    public int getCity_id() {
        return city_id;
    }

    public void setCity_id(int city_id) {
        this.city_id = city_id;
    }

    public int getCrm_id() {
        return crm_id;
    }

    public void setCrm_id(int crm_id) {
        this.crm_id = crm_id;
    }

    public Integer getCountry_id() {
        return country_id;
    }

    public void setCountry_id(Integer country_id) {
        this.country_id = country_id;
    }

    public Byte getStatus() {
        return status;
    }

    public void setStatus(Byte status) {
        this.status = status;
    }

    public Integer getIta() {
        return ita;
    }

    public void setIta(Integer ita) {
        this.ita = ita;
    }

    public Integer getVacancy() {
        return vacancy;
    }

    public void setVacancy(Integer vacancy) {
        this.vacancy = vacancy;
    }

    public Integer getState_id() {
        return state_id;
    }

    public void setState_id(Integer state_id) {
        this.state_id = state_id;
    }

    @Override
    public String toString() {
        return "City{" +
                "city_id=" + city_id +
                ", crm_id=" + crm_id +
                ", country_id=" + country_id +
                ", status=" + status +
                ", ita=" + ita +
                ", vacancy=" + vacancy +
                ", state_id=" + state_id +
                '}';
    }
}
