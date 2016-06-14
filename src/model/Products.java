/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import javax.persistence.Entity;
import javax.persistence.Id;

/**
 *
 * @author iftekher
 */
@Entity
public class Products {
    @Id
    private int id;
    private String title;
    private double unitPrice;

    public Products() {
    }

    public Products(int id, String title, double unitPrice) {
        this.id = id;
        this.title = title;
        this.unitPrice = unitPrice;
    }

    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public double getUnitPrice() {
        return unitPrice;
    }

    @Override
    public String toString() {
        return "Products{" + "id=" + id + ", title=" + title + ", unitPrice=" + unitPrice + '}';
    }
    
}
