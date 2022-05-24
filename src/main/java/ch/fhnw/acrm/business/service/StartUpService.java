package ch.fhnw.acrm.business.service;


import ch.fhnw.acrm.data.domain.Product;
import ch.fhnw.acrm.data.domain.UnchainedUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

//Author: Lennart
@Component
public class StartUpService implements ApplicationListener<ApplicationReadyEvent> {

    @Autowired
    UserService userService;

    @Autowired
    ProductService productService;


    @Override
    public void onApplicationEvent(ApplicationReadyEvent event) {
        this.createAdmin();
        this.createProducts();
    }

    private void createAdmin() {

        try {
            UnchainedUser defaultAdmin = new UnchainedUser();
            defaultAdmin.setName("admin");
            defaultAdmin.setStreet("Peter-Merian-Strasse 86");
            defaultAdmin.setZipCode("4052");
            defaultAdmin.setCity("Basel");
            defaultAdmin.setTravelDistance(1);
            defaultAdmin.setEmail("admin@unchained.com");
            defaultAdmin.setAnAdmin(true);
            defaultAdmin.setPassword("password");
            defaultAdmin.setRole("ADMIN");
            userService.saveUser(defaultAdmin);
            LoggerService.logUser("Default Admin created");
        } catch (Exception e) {
            LoggerService.logSystem("info", "Default admin creation failed");
        }

    }

    private void createProducts() {

        try {
        productService.saveProduct(new Product("Prod. A", 25L, 1.2, 13.50));
        productService.saveProduct(new Product("Prod. B",  10L, 2.0, 15.0));
        productService.saveProduct(new Product("Prod. C",  15L, 2.5, 11.90));
        productService.saveProduct(new Product("Prod. D", 100L, 0.8, 2.50));
            LoggerService.logSystem("info", "Default Products created");
        } catch (Exception e) {
            LoggerService.logSystem("info", "Default Products creation failed");
        }
    }


}
