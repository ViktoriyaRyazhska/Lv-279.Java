package ua.softserve.persistence.entity;

import javax.persistence.*;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.validation.constraints.NotNull;

@Getter @Setter
@ToString
@Entity
@Table(name = "language_translations")
public class LanguageTranslations {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int translation_id;

    @ManyToOne
    @JoinColumn(name = "language_id")
    private Languages language;

    @Column(name = "local")
    private Character local;

    @NotNull
    @Column(name = "item_id")
    private int itemId;

    @NotNull
    @Column(name = "tag")
    private String tag;

    @NotNull
    @Column(name = "field")
    private String field;

    @NotNull
    @Column(name = "trasnlation")
    private String trasnlation;

    public LanguageTranslations() {}
}
