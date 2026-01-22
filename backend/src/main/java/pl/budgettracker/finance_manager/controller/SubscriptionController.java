package pl.budgettracker.finance_manager.controller;


import org.springframework.web.bind.annotation.*;
import pl.budgettracker.finance_manager.model.Subscription;
import pl.budgettracker.finance_manager.model.User;
import pl.budgettracker.finance_manager.repository.SubscriptionRepository;
import pl.budgettracker.finance_manager.service.UserService;

import java.security.Principal;
import java.util.List;

@RestController
@RequestMapping("/api/subsriptions")
public class SubscriptionController {

    private final SubscriptionRepository subscriptionRepository;
    private final UserService userService;

    public SubscriptionController(SubscriptionRepository subscriptionRepository, UserService userService) {
        this.subscriptionRepository = subscriptionRepository;
        this.userService = userService;
    }

    @GetMapping
    public List<Subscription> getMySubscriptions(Principal principal) {
        return subscriptionRepository.findByUserEmail(principal.getName());
    }

    @PostMapping
    public Subscription add(@RequestBody Subscription sub, Principal principal) {
        User user = userService.findByEmail(principal.getName());
        sub.setUser(user);

        if (sub.getIsActive() == null) {
            sub.setIsActive(true);
        }

        return subscriptionRepository.save(sub);
    }


    @DeleteMapping("/{id}")
    public void deleteSubscription(@PathVariable Integer id, Principal principal) {
        Subscription sub = subscriptionRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Nie znaleziono subskrypcji o ID: " + id));

        if (!sub.getUser().getEmail().equals(principal.getName())) {
            throw new RuntimeException("Nie masz uprawnień do usunięcia tej subskrypcji!");
        }
        subscriptionRepository.delete(sub);
    }
}
