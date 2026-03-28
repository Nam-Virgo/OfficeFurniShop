package model;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Table(name = "VoucherByProduct")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString(exclude = {"voucher", "products"})
public class VoucherByProduct {

    @Id
    private int voucherId;

    @OneToOne
    @MapsId
    @JoinColumn(name = "voucherId")
    private Voucher voucher;

    private float discountPercent;

    // 🔗 ManyToMany với Product
    @ManyToMany
    @JoinTable(
            name = "voucher_product",
            joinColumns = @JoinColumn(name = "voucherByProductId"),
            inverseJoinColumns = @JoinColumn(name = "productId")
    )
    private List<Product> products;
}