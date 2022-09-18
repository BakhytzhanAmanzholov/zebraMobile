package kz.jaguars.hackathon.controllers;

import kz.jaguars.hackathon.dto.mappers.OrderMapper;
import kz.jaguars.hackathon.dto.response.OrderHistoryDto;
import kz.jaguars.hackathon.models.Booking;
import kz.jaguars.hackathon.services.OrderService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.awt.print.Book;
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
        List<OrderHistoryDto> dtoList = new ArrayList<>();
        for (Booking booking: orders){
            dtoList.add(OrderMapper.toResponseDto(booking));
        }
        return new ResponseEntity<>(dtoList, HttpStatus.OK);
    }
}
