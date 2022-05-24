package ch.fhnw.acrm.business.service;


import ch.fhnw.acrm.data.domain.Ordering;
import ch.fhnw.acrm.data.domain.Product;
import ch.fhnw.acrm.data.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

//Author: Luca
@Service
public class OrderService {


    @Autowired
    private OrderRepository orderRepository;
    @Autowired
    private UserService userService;

    public Ordering saveOrder(@Valid Ordering ordering) throws Exception {
        if (ordering.getShippingCost() <= 0) {
            throw new Exception("Shipping costs cannot be below 0");
        }
        ordering.setUser(userService.getCurrentUser());
        return orderRepository.save(ordering);
    }


    public List<Ordering> findAllOrders() {
        List<Ordering> OrderList = new ArrayList<>();

        for (Ordering order: orderRepository.findAll()) {
            OrderList.add(order);
        }
        return OrderList;
    }
}
