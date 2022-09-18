package kz.jaguars.hackathon.models;

import lombok.*;

import javax.persistence.*;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
@Builder
public class Booking {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private Integer price;
    private Integer finalPrice;
    private Boolean completed;
    @ManyToOne
    private CoffeeHouse coffeeHouse;
    private Date date;
    @ManyToOne
    @ToString.Exclude
    private Account account;
    @ManyToMany
    @ToString.Exclude
    private List<Product> products = new ArrayList<>();
}
