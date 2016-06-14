/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hibernatecustomerdemo;

import java.util.List;
import model.Customer;
import model.Products;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

/**
 *
 * @author iftekher
 */
public class HibernateCustomerDemo {

    /**
     * @param args the command line arguments
     * @return 
     */
    public SessionFactory buildSession() {
        Configuration configuration = new Configuration();
        configuration.configure(HibernateCustomerDemo.class.getResource("hibernate.cfg.xml"));
        ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder().applySettings(configuration.getProperties()).build();
        return configuration.buildSessionFactory(serviceRegistry);
    }
    
    public HibernateCustomerDemo() {
        SessionFactory factory = buildSession();
        Session session = factory.openSession();
        
        List<Customer> customers = null;
        
        Transaction transaction = session.beginTransaction();
        try {
            //session.save(new Student(12, "Akter"));
            //session.save(new Course("CSE4047", "Advanced Java", 3.0));
            Customer c1 = new Customer(99, "Alam", "01823986743");
            Customer c2 = new Customer(100, "Molom", "01823436798");
            Customer c3 = new Customer(101, "Galon", "01687345909");
            Products p1 = new Products(1033, "Chicken Biriani", 120.0);
            Products p2 = new Products(1034, "Kacchi Biriani", 140.0);
            Products p3 = new Products(1024, "Morog Polao", 140.0);
            c1.addProducts(p3);
            c1.addProducts(p2);
            c2.addProducts(p1);
            c2.addProducts(p2);
            c3.addProducts(p1);
            c3.addProducts(p3);
            c3.addProducts(p2);
            session.save(c1);
            session.save(c2);
            session.save(c3);
            session.save(p1);
            session.save(p2);
            session.save(p3);
            transaction.commit();
            customers = session.createCriteria(Customer.class).list();
        } catch (Exception e) {
            transaction.rollback();
        }
        
        customers.forEach(System.out::println);
        
        session.close();
        System.exit(0); 
    }
    
    public static void main(String[] args) {
        // TODO code application logic here
       new HibernateCustomerDemo(); 
    }
    
}
