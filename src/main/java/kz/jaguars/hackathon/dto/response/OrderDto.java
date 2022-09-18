package kz.jaguars.hackathon.dto.response;

import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class OrderDto {
    private Long id;
    private String date;
    private Boolean completed;
    private Integer price;
    private CoffeeDto coffeeHouse;
    private List<ProductDto> products;
}
