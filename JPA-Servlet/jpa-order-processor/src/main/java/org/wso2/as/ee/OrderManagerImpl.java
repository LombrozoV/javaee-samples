package org.wso2.as.ee;

import javax.ejb.Stateful;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceContextType;
import javax.persistence.Query;
import java.util.List;

@Stateful
public class OrderManagerImpl implements OrderManager {

    @PersistenceContext(unitName = "jpaSample", type = PersistenceContextType.EXTENDED)
    private EntityManager entityManager;

    @Override
    public void addOrder(String item, int quantity) {
        Order order = new Order(item, quantity);
        entityManager.persist(order);
    }

    @Override
    public List<Order> getOrders() {
        Query query = entityManager.createQuery("SELECT o FROM ORDERS o");
        List<Order> results = query.getResultList();
        return results;
    }

    @Override
    public void deleteOrder(Order order) {
        entityManager.remove(order);
    }

    @Override
    public Order findOrder(int id) {
        return entityManager.find(Order.class, id);
    }

}
