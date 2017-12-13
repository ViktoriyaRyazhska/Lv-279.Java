package ua.softserve.persistence.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Getter
@Setter
@Entity
@Table(name = "group_payment_status")
public class GroupPaymentStatus {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "group_payment_status_id")
    private Integer groupPaymentStatusId;

    @NotNull
    @Column(name = "group_payment_status_name")
    private String groupPaymentStatusName;

    @NotNull
    @Column(name = "group_payment_status")
    private Integer groupPaymentStatus;

}
