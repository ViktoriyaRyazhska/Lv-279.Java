package ua.softserve.persistence.entity;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Getter @Setter
@ToString
@Entity
@Table(name = "language_translations")
public class LanguageTranslations {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "translation_id")
    private Integer translationId;

    @ManyToOne
    @JoinColumn(name = "language_id")
    private Languages language;

    @Column(name = "local", columnDefinition = "char(2)")
    private Character local;

    @NotNull
    @Column(name = "item_id")
    private Integer itemId;

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
