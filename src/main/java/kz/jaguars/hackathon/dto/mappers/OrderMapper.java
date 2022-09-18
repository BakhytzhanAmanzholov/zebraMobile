package kz.jaguars.hackathon.dto.mappers;

import kz.jaguars.hackathon.dto.response.OrderHistoryDto;
import kz.jaguars.hackathon.models.Booking;
import kz.jaguars.hackathon.models.Product;
import lombok.Builder;
import lombok.Data;

import java.util.ArrayList;

@Data
@Builder
public class OrderMapper {
    public static OrderHistoryDto toResponseDto(Booking booking) {
        OrderHistoryDto dto = OrderHistoryDto.builder()
                .id(booking.getId())
                .date(booking.getDate().toString())
                .coffeeHouse(CoffeeMapper.toResponseDto(booking.getCoffeeHouse()))
                .completed(booking.getCompleted())
                .price(booking.getFinalPrice())
                .products(new ArrayList<>())
                .build();

        for (Product product : booking.getProducts()) {
            dto.getProducts().add(ProductMapper.toResponseDto(product));
        }

        return dto;
    }
}
