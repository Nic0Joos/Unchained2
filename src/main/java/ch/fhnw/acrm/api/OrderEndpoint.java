package ch.fhnw.acrm.api;


import ch.fhnw.acrm.business.service.LoggerService;
import ch.fhnw.acrm.business.service.OrderService;
import ch.fhnw.acrm.data.domain.Ordering;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

//Author: Luca
@RestController
@RequestMapping(path = "/api/order")
public class OrderEndpoint {


    @Autowired
    private OrderService orderService;

    //Tested with PostMan: 21.05.2022 (Cookie has to be deleted)
    @PostMapping
    public ResponseEntity<Void> postOrder(@RequestBody Ordering ordering){
        try {
            orderService.saveOrder(ordering);
            LoggerService.logSystem("info", "Order created with ID: " + ordering.getOrderId());
        } catch (Exception e) {
            LoggerService.logSystem("warning", "Order couldn't be processed: " + e.toString());
            throw new ResponseStatusException(HttpStatus.CONFLICT, e.getMessage());
        }
        return ResponseEntity.ok().build();
    }

    //all orders
    @GetMapping(produces = "application/json")
    public List<Ordering> getAllOrders() {
        return orderService.findAllOrders();
    }



}
