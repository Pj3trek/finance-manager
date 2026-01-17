package pl.budgettracker.finance_manager;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import pl.budgettracker.finance_manager.model.User;
import pl.budgettracker.finance_manager.service.UserService;

@SpringBootApplication
public class FinanceManagerApplication {

	public static void main(String[] args) {

        SpringApplication.run(FinanceManagerApplication.class, args);

//        var context = SpringApplication.run(FinanceManagerApplication.class, args);
//
//        UserService userService = context.getBean(UserService.class);
//
//        User testUser = new User();
//        testUser.setUsername("Pj3trek");
//        testUser.setEmail("test@wp.pl");
//        testUser.setPassword("tajnehaslo123");
//
//        userService.registerUser(testUser);
//        System.out.println("Użytkownik testowy zapisany!");
	}

}
