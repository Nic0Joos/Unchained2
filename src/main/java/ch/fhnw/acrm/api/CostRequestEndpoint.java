package ch.fhnw.acrm.api;


import ch.fhnw.acrm.business.service.CostRequestService;
import ch.fhnw.acrm.business.service.LoggerService;
import ch.fhnw.acrm.business.service.UserService;
import ch.fhnw.acrm.data.domain.CostRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

//Author: Nico

@Controller
@RequestMapping(path = "/costrequest")
public class CostRequestEndpoint {

    @Autowired
    private CostRequestService costRequestService;

    @Autowired
    private UserService userService;

    @Autowired
    private LoggerService loggerService;

    //Tested with postman: 19.05.2022/NJ
    @PostMapping(consumes = {"application/json"}, produces = {"application/json"})
    public @ResponseBody
    CostRequest getShippingCosts(@RequestBody CostRequest costRequest){
        try {
            costRequest.setPrice(costRequestService.getCosts(costRequest.getPallets(),  userService.getCurrentUser().getTravelDistance()));
            costRequest.setKm(userService.getCurrentUser().getTravelDistance());
        } catch (Exception e) {
            loggerService.logSystem("warning",e.toString());
        }
        return costRequest;
    }

}
