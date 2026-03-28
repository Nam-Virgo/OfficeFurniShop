package model;

import jakarta.persistence.*;
import lombok.*;
import java.math.BigDecimal;
import java.util.List;

@Entity
@Table(name = "Product")
@Getter
@Setter
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int productId;

    private String name;

    @Column(columnDefinition = "TEXT")
    private String descript;

    private String productImage;

    private BigDecimal price;

    private int quantity;

    private int isDelete;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "categoryId")
    private Category category;

    @ManyToMany(mappedBy = "products")
    private List<Wishlist> wishlists;
}