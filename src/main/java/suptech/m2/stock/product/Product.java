package suptech.m2.stock.product;

import lombok.*;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.time.LocalDate;

@Entity @Getter @Setter
@NoArgsConstructor @AllArgsConstructor
public class Product {
    @Id @Column(length = 20)
    private String ref ;
    @NotNull
    @Size(min = 5, max = 15)
    private String label ;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate creation_date;
    private String description ;
    private double price ;
    private int quantity;
}
