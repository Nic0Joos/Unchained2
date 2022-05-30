package ch.fhnw.acrm.business.service;


import ch.fhnw.acrm.data.domain.UnchainedUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

//Author: Lennart
@Component
public class StartUpService implements ApplicationListener<ApplicationReadyEvent> {

    @Autowired
    UserService userService;



    @Override
    public void onApplicationEvent(ApplicationReadyEvent event) {
        this.createAdmin();
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
            userService.saveUser(defaultAdmin);
            LoggerService.logUser("Default Admin created");
        } catch (Exception e) {
            LoggerService.logSystem("info", "Default admin creation failed");
        }

    }



}
