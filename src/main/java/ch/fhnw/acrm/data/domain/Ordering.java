package ch.fhnw.acrm.data.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

//Author: Luca
@Entity
public class Ordering {

    @Id
    @GeneratedValue
    private Long orderId;
    private int amountA;
    private int amountB;
    private int amountC;
    private int amountD;
    private double shippingCost;
    private double orderPrice;
    /*@ManyToOne
    @JsonIgnore
    private User user;*/

    public Ordering(Long orderId, int amountA, int amountB, int amountC, int amountD, double shippingCost, double orderPrice) {
        this.orderId = orderId;
        this.amountA = amountA;
        this.amountB = amountB;
        this.amountC = amountC;
        this.amountD = amountD;
        this.shippingCost = shippingCost;
        this.orderPrice = orderPrice;
    }

    public Ordering(int amountA, int amountB, int amountC, int amountD, double shippingCost, double orderPrice) {
        this.amountA = amountA;
        this.amountB = amountB;
        this.amountC = amountC;
        this.amountD = amountD;
        this.shippingCost = shippingCost;
        this.orderPrice = orderPrice;
    }

    public Ordering() {
    }



    //getter & setter
    public Long getOrderId() {
        return orderId;
    }
    public void setOrderId(Long orderId) {
        this.orderId = orderId;
    }

    public int getAmountA() {
        return amountA;
    }
    public void setAmountA(int amountA) {
        this.amountA = amountA;
    }

    public int getAmountB() {
        return amountB;
    }
    public void setAmountB(int amountB) {
        this.amountB = amountB;
    }

    public int getAmountC() {
        return amountC;
    }
    public void setAmountC(int amountC) {
        this.amountC = amountC;
    }

    public int getAmountD() {
        return amountD;
    }
    public void setAmountD(int amountD) {
        this.amountD = amountD;
    }

    public double getShippingCost() {
        return shippingCost;
    }
    public void setShippingCost(Long shippingCost) {
        this.shippingCost = shippingCost;
    }

    public double getOrderPrice() {
        return orderPrice;
    }
    public void setOrderPrice(Long orderPrice) {
        this.orderPrice = orderPrice;
    }

    /*
    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }*/
}
