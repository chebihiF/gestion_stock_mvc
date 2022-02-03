package suptech.m2.stock.product;

import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.time.LocalDate;

@Entity @Getter @Setter
@NoArgsConstructor @AllArgsConstructor
public class Product {
    @Id @Column(length = 20)
    private String ref ;
    @Column(unique = true)
    private String label ;
    private LocalDate creation_date;
    private String description ;
    private double price ;
    private int quantity;
}
