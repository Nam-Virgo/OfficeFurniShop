package model;

import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;

@Entity
@Table(name = "VoucherByPrice")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString(exclude = "voucher")
public class VoucherByPrice {

    @Id
    private int voucherId;

    @OneToOne
    @MapsId
    @JoinColumn(name = "voucherId")
    private Voucher voucher;

    private BigDecimal lowerbound;

    private float discountPercent;

    private BigDecimal maxDiscount;
}