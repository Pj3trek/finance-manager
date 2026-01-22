package pl.budgettracker.finance_manager.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.budgettracker.finance_manager.model.Subscription;

import java.util.List;

public interface SubscriptionRepository extends JpaRepository<Subscription, Integer> {
    List<Subscription> findByUserEmail(String email);
}
