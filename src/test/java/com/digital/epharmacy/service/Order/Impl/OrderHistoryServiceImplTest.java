package com.digital.epharmacy.service.Order.Impl;


/** Author: Ayabulela Mahlathini - 218017774
 * Date: 03/09/2020
 * Description: Testing Implementation for the OrderHistory service, getting all orders from the database
 */


import com.digital.epharmacy.entity.Order.OrderHistory;
import com.digital.epharmacy.factory.Order.OrderHistoryFactory;

import com.digital.epharmacy.repository.Order.OrderHistoryRepository;
import com.digital.epharmacy.service.Order.OrderHistoryService;
import org.junit.Assert;
import org.junit.FixMethodOrder;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.junit.runners.MethodSorters;

import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class OrderHistoryServiceImplTest {

    private static OrderHistoryService service = OrderHistoryServiceImpl.getService();

    private static OrderHistory orderHistory = OrderHistoryFactory
            .createOrderHistory("User's ID", 25,6500.00);

    @Order(1)
    @Test
    void a_create() {

        OrderHistory createdOrderHistory = service.create(orderHistory);
        Assert.assertEquals(orderHistory.getUserId(), createdOrderHistory.getUserId());
        System.out.println("Created:" + createdOrderHistory);

    }

    @Order(2)
    @Test
    void b_read() {

        OrderHistory readOrderHistory = service.read(orderHistory.getUserId());
        assertEquals(25, readOrderHistory.getTotalNumberOfOrders());
        System.out.println("Read:" + readOrderHistory);
    }

    @Order(3)
    @Test
    void c_update() {

        OrderHistory updatedOrderHistory = new OrderHistory
                .Builder()
                .copy(orderHistory)
                .setTotalNumberOfOrders(150)
                .build();

        service.update(updatedOrderHistory);

        assertNotEquals(orderHistory.getTotalNumberOfOrders(), updatedOrderHistory.getTotalNumberOfOrders());

        System.out.println("Updated: " + updatedOrderHistory);
    }

    @Order(4)
    @Test
    void d_getAll() {

        Set<OrderHistory> orderHistories = service.getAll();
        assertEquals(1, orderHistories.size());

        System.out.println("Get All: " + orderHistories);
    }

    @Order(5)
    @Test
    void e_delete() {
        String orderHistoryToDel = orderHistory.getUserId();
        boolean deleted = service.delete(orderHistoryToDel);

        Assert.assertTrue(deleted);

        if (deleted) {
            System.out.println("Deleted: " + orderHistoryToDel);
        }
    }


}