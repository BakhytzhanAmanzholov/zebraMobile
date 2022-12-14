package kz.jaguars.hackathon.controllers;

import kz.jaguars.hackathon.dto.mappers.OrderMapper;
import kz.jaguars.hackathon.dto.response.OrderDto;
import kz.jaguars.hackathon.models.Booking;
import kz.jaguars.hackathon.services.OrderService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@Slf4j
@RequiredArgsConstructor
@RequestMapping("/order")
public class OrderController {
    private final OrderService orderService;

    @GetMapping("/client")
    public ResponseEntity<?> findByClient(){
        List<Booking> orders = orderService.findByCustomer();
        List<OrderDto> dtoList = new ArrayList<>();
        for (Booking booking: orders){
            dtoList.add(OrderMapper.toResponseDto(booking));
        }
        return new ResponseEntity<>(dtoList, HttpStatus.OK);
    }

    @PostMapping("/{id}")
    public ResponseEntity<?> save(@PathVariable("id") Long id){
        Booking booking = orderService.saveWithClient(id);
        return new ResponseEntity<>(OrderMapper.toResponseDto(booking), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> findById(@PathVariable("id") Long id){
        return new ResponseEntity<>(OrderMapper.toResponseDto(orderService.findById(id)),HttpStatus.OK);
    }

    @PostMapping("/{id}/products/{product-id}/{count}")
    public ResponseEntity<?> addProduct(@PathVariable("id") Long id, @PathVariable("product-id") Long productId,
                                        @PathVariable("count") Integer count){
        orderService.addProductsToOrder(id, productId, count);
        return new ResponseEntity<>("Product " + productId + " successfully added to the order by id " + id, HttpStatus.OK);
    }

    @PutMapping("/{id}/products/{product-id}/{count}")
    public ResponseEntity<?> removeProduct(@PathVariable("id") Long id, @PathVariable("product-id") Long productId,
                                           @PathVariable("count") Integer count){
        orderService.removeProductsFromOrder(id, productId, count);
        return new ResponseEntity<>("Product " + productId + " successfully removed from the order by id " + id, HttpStatus.OK);
    }

    @PostMapping("/{id}/client")
    public ResponseEntity<?> complete(@PathVariable("id") Long id){
        orderService.complete(id);
        return new ResponseEntity<>("The order was successfully completed",HttpStatus.OK);
    }

}
