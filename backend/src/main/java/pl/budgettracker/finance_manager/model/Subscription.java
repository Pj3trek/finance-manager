package pl.budgettracker.finance_manager.model;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
@Table(name = "user_subscriptions") // (1) Musi być dokładnie tak jak na screenie
@Getter @Setter
public class Subscription {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @ManyToOne
    @JoinColumn(name = "plan_id")
    private ServicePlan servicePlan;


    @Column(name = "custom_price")
    private BigDecimal customPrice;

    @Column(name = "start_date")
    private LocalDate startDate;

    @Column(name = "next_payment_date")
    private LocalDate nextPaymentDate;

    private Boolean isActive;

    @Column(columnDefinition = "TEXT")
    private String notes;
}
