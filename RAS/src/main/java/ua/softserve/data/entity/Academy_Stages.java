package ua.softserve.data.entity;

import com.sun.istack.internal.NotNull;

import javax.persistence.*;

@Entity
@Table(name = "academy_stages")
public class Academy_Stages {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int stage_id;

    @NotNull
    @Column(name = "name")
    private String name;

    @NotNull
    @Column(name = "sort")
    private byte sort;

    public Academy_Stages() {}

    public int getStage_id() {
        return stage_id;
    }

    public void setStage_id(int stage_id) {
        this.stage_id = stage_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public byte getSort() {
        return sort;
    }

    public void setSort(byte sort) {
        this.sort = sort;
    }

    @Override
    public String toString() {
        return "Academy_Stages{" +
                "stage_id=" + stage_id +
                ", name='" + name + '\'' +
                ", sort=" + sort +
                '}';
    }
}
