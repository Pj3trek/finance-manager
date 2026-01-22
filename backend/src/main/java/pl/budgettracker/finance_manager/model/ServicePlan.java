package pl.budgettracker.finance_manager.model;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Entity
@Table(name = "service_plans")
@Getter
@Setter
public class ServicePlan {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "service_id")
    private ServiceProvider serviceProvider;

    private String planName;
    private BigDecimal defaultPrice;
    private String defaultCurrency;
    private String billingCycle;
}
