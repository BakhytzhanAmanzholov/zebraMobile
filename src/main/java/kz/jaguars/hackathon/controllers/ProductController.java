package kz.jaguars.hackathon.controllers;

import kz.jaguars.hackathon.dto.mappers.ProductMapper;
import kz.jaguars.hackathon.dto.response.ProductDto;
import kz.jaguars.hackathon.models.Product;
import kz.jaguars.hackathon.services.ProductService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@Slf4j
@RequiredArgsConstructor
@RequestMapping("/products")
public class ProductController {

    private final ProductService productService;

    @GetMapping("/{id}")
    public ResponseEntity<?> findById(@PathVariable("id") Long id){
        return new ResponseEntity<>(ProductMapper.toResponseDto(productService.findById(id)), HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<?> findAll(){
        List<Product> products = productService.findAll();
        List<ProductDto> dtoList = new ArrayList<>();
        for (Product product: products){
            dtoList.add(ProductMapper.toResponseDto(product));
        }
        return new ResponseEntity<>(dtoList, HttpStatus.OK);
    }
}
