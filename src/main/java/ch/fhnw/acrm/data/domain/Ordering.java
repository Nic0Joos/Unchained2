package ch.fhnw.acrm.data.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;

//Author: Luca
@Entity
public class Ordering {

    @Id
    @GeneratedValue
    private Long orderId;
    private String amountA;
    private String amountB;
    private String amountC;
    private String amountD;
    private String shippingCost;
    private String orderPrice;
    @ManyToOne
    @JsonIgnore
    private UnchainedUser user;

    public Ordering() {
    }


    public Ordering(Long orderId, String amountA, String amountB, String amountC, String amountD, String shippingCost, String orderPrice) {
        this.orderId = orderId;
        this.amountA = amountA;
        this.amountB = amountB;
        this.amountC = amountC;
        this.amountD = amountD;
        this.shippingCost = shippingCost;
        this.orderPrice = orderPrice;
    }

    public Ordering(String amountA, String amountB, String amountC, String amountD, String shippingCost, String orderPrice) {
        this.amountA = amountA;
        this.amountB = amountB;
        this.amountC = amountC;
        this.amountD = amountD;
        this.shippingCost = shippingCost;
        this.orderPrice = orderPrice;
    }




    //getter & setter
    public Long getOrderId() {
        return orderId;
    }
    public void setOrderId(Long orderId) {
        this.orderId = orderId;
    }

    public String getAmountA() {
        return amountA;
    }
    public void setAmountA(String amountA) {
        this.amountA = amountA;
    }

    public String getAmountB() {
        return amountB;
    }
    public void setAmountB(String amountB) {
        this.amountB = amountB;
    }

    public String getAmountC() {
        return amountC;
    }
    public void setAmountC(String amountC) {
        this.amountC = amountC;
    }

    public String getAmountD() {
        return amountD;
    }
    public void setAmountD(String amountD) {
        this.amountD = amountD;
    }

    public String getShippingCost() {
        return shippingCost;
    }
    public void setShippingCost(String shippingCost) {
        this.shippingCost = shippingCost;
    }

    public String getOrderPrice() {
        return orderPrice;
    }
    public void setOrderPrice(String orderPrice) {
        this.orderPrice = orderPrice;
    }


    public UnchainedUser getUser() {
        return user;
    }
    public void setUser(UnchainedUser user) {
        this.user = user;
    }
}
