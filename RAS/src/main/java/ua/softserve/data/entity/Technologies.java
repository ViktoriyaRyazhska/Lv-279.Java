package ua.softserve.data.entity;

import com.sun.istack.internal.NotNull;

import javax.persistence.*;

@Entity
@Table(name = "technologies")
public class Technologies {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int technology_id;

    @NotNull
    @Column(name = "alias")
    private String alias;

    @NotNull
    @Column(name = "free")
    private int free;

    @NotNull
    @Column(name = "image")
    private String image;

    @NotNull
    @Column(name = "image2")
    private String image2;

    @Column(name = "status")
    private char status = '1';

    @Column(name = "position")
    private Integer position;

    @Column(name = "price")
    private Integer price;

    @Column(name = "ita")
    private Byte ita;

    @Column(name = "vacancy")
    private Byte vacancy;

    @Column(name = "name")
    private String name;

    @Column(name = "directiond_id", columnDefinition = "INT(11) UNSIGNED")
    private int directiond_id;

    @Column(name = "crm_id")
    private Integer crm_id;

    @Column(name = "activeGroups")
    private Integer activeGroups;

    public Technologies() {
    }

    public int getTechnology_id() {
        return technology_id;
    }

    public void setTechnology_id(int technology_id) {
        this.technology_id = technology_id;
    }

    public String getAlias() {
        return alias;
    }

    public void setAlias(String alias) {
        this.alias = alias;
    }

    public int getFree() {
        return free;
    }

    public void setFree(int free) {
        this.free = free;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getImage2() {
        return image2;
    }

    public void setImage2(String image2) {
        this.image2 = image2;
    }

    public char getStatus() {
        return status;
    }

    public void setStatus(char status) {
        this.status = status;
    }

    public Integer getPosition() {
        return position;
    }

    public void setPosition(Integer position) {
        this.position = position;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getDirectiond_id() {
        return directiond_id;
    }

    public void setDirectiond_id(int directiond_id) {
        this.directiond_id = directiond_id;
    }

    public Integer getCrm_id() {
        return crm_id;
    }

    public void setCrm_id(Integer crm_id) {
        this.crm_id = crm_id;
    }

    public Integer getActiveGroups() {
        return activeGroups;
    }

    public void setActiveGroups(Integer activeGroups) {
        this.activeGroups = activeGroups;
    }

    @Override
    public String toString() {
        return "Technologies{" +
                "technology_id=" + technology_id +
                ", alias='" + alias + '\'' +
                ", free=" + free +
                ", image='" + image + '\'' +
                ", image2='" + image2 + '\'' +
                ", status=" + status +
                ", position=" + position +
                ", price=" + price +
                ", ita=" + ita +
                ", vacancy=" + vacancy +
                ", name='" + name + '\'' +
                ", directiond_id=" + directiond_id +
                ", crm_id=" + crm_id +
                ", activeGroups=" + activeGroups +
                '}';
    }
}
