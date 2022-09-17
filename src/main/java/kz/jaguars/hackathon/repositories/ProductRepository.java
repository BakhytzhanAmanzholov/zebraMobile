package kz.jaguars.hackathon.repositories;

import kz.jaguars.hackathon.models.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long> {
}
