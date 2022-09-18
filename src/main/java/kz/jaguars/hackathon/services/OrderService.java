package kz.jaguars.hackathon.services;

import kz.jaguars.hackathon.models.Booking;
import kz.jaguars.hackathon.models.Product;

import java.util.List;

public interface OrderService extends CrudService<Booking, Long>{
    List<Booking> findByCustomer();

    void addProductsToOrder(Long orderId, Long productId, Integer count);

    void addProductToOrder(Product product, Long orderId);

    void removeProductsFromOrder(Long orderId, Long productId, Integer count);

    void addClientToOrder(Long id, Long clientId);


    void complete(Long id);

    boolean pay(Booking booking);

    Booking saveWithClient(Long coffeeHouse);
}
