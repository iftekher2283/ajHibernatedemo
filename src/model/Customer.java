/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;

/**
 *
 * @author iftekher
 */
@Entity
public class Customer {
    @Id
    private int id;
    private String name;
    private String contact;
    @OneToMany
    private List<Products> productList;

    public Customer() {
        productList = new ArrayList<>();
    }

    public Customer(int id, String name, String contact) {
        this.id = id;
        this.name = name;
        this.contact = contact;
        productList = new ArrayList<>();
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getContact() {
        return contact;
    }

    public List<Products> getProductList() {
        return productList;
    }
    
    public void addProducts(Products product){
        productList.add(product);
    }

    @Override
    public String toString() {
        return "Customer{" + "id=" + id + ", name=" + name + ", contact=" + contact + ", productList=" + productList + '}';
    }
}
