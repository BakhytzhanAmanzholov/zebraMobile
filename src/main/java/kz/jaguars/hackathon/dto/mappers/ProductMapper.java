package kz.jaguars.hackathon.dto.mappers;

import kz.jaguars.hackathon.dto.response.ProductDto;
import kz.jaguars.hackathon.models.Product;
import lombok.Builder;
import lombok.Data;

public class ProductMapper {
    public static ProductDto toResponseDto(Product product){
        return ProductDto.builder()
                .id(product.getId())
                .description(product.getDescription())
                .title(product.getTitle())
                .price(product.getSalePrice())
                .build();
    }
}
