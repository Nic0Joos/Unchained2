package ch.fhnw.acrm.data.domain;


//Author: Nico
public class CostRequest {

    private double price;
    private int km;
    private int pallets;

    //getter and setter
    public double getPrice() {
        return price;
    }
    public void setPrice(double price) {
        this.price = price;
    }

    public int getKm() {
        return km;
    }
    public void setKm(int km) {
        this.km = km;
    }

    public int getPallets() {
        return pallets;
    }
    public void setPallets(int pallets) {
        this.pallets = pallets;
    }
}
