package ua.softserve.data.entity;

import com.sun.istack.internal.NotNull;

import javax.persistence.*;

@Entity
@Table(name = "country")
public class Country {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int country_id;

    @NotNull
    @Column(name = "crm_id")
    private int crm_id;

    @Column(name = "code")
    private String code;

    @Column(name = "hot_line")
    private String hot_line;

    @Column(name = "status")
    private Byte status;

    @Column(name = "ita")
    private Integer ita;

    @Column(name = "vacancy")
    private Integer vacancy;

    public Country() {}

    public int getCountry_id() {
        return country_id;
    }

    public void setCountry_id(int country_id) {
        this.country_id = country_id;
    }

    public int getCrm_id() {
        return crm_id;
    }

    public void setCrm_id(int crm_id) {
        this.crm_id = crm_id;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getHot_line() {
        return hot_line;
    }

    public void setHot_line(String hot_line) {
        this.hot_line = hot_line;
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

    @Override
    public String toString() {
        return "Country{" +
                "country_id=" + country_id +
                ", crm_id=" + crm_id +
                ", code='" + code + '\'' +
                ", hot_line='" + hot_line + '\'' +
                ", status=" + status +
                ", ita=" + ita +
                ", vacancy=" + vacancy +
                '}';
    }
}
