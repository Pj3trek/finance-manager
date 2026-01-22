package pl.budgettracker.finance_manager.model;


import jakarta.persistence.*;

@Entity
@Table(name = "service_providers")
public class ServiceProvider {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String name;
    private String category_name;
    private String logo_url;

}
