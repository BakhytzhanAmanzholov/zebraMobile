package kz.jaguars.hackathon.services.implementations;

import kz.jaguars.hackathon.exceptions.NotFoundException;
import kz.jaguars.hackathon.models.Product;
import kz.jaguars.hackathon.repositories.ProductRepository;
import kz.jaguars.hackathon.services.ProductService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


@Service
@RequiredArgsConstructor
@Transactional
@Slf4j
public class ProductServiceImpl implements ProductService {

    private final ProductRepository productRepository;

    @Override
    public Product save(Product entity) {
        return productRepository.save(entity);
    }

    @Override
    public void delete(Long aLong) {
        Product product = findById(aLong);
        productRepository.delete(product);
    }

    @Override
    public Product update(Product entity) {
        Product product = findById(entity.getId());
        product.setDescription(entity.getDescription());
        product.setTitle(entity.getTitle());
        return product;
    }

    @Override
    public Product findById(Long aLong) {
        return productRepository.findById(aLong).orElseThrow(
                () -> new NotFoundException("Product <" + aLong + "> not found"));
    }

    @Override
    public List<Product> findAll() {
        return productRepository.findAll();
    }
}
