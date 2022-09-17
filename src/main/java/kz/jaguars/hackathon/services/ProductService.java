package kz.jaguars.hackathon.services;

import kz.jaguars.hackathon.models.Product;

import java.util.List;

public interface ProductService extends CrudService<Product, Long>{
    List<Product> findAll();
}
