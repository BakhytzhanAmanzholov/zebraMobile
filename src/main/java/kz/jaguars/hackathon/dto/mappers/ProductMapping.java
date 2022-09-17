package kz.jaguars.hackathon.dto.mappers;

import kz.jaguars.hackathon.dto.response.ProductDto;
import kz.jaguars.hackathon.models.Product;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ProductMapping {
    public static ProductDto productDto(Product product){
        return ProductDto.builder()
                .id(product.getId())
                .description(product.getDescription())
                .title(product.getTitle())
                .build();
    }
}
