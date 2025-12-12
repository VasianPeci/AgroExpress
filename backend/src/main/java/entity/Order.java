package entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Set;
import java.util.HashSet;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "orders")
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // --- Foreign Key to User (Buyer) ---
    // Many Orders belong to one User.
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", nullable = false)
    private User buyer;

    // --- One-to-Many Relationship to Line Items ---
    // One Order has Many OrderItems.
    @OneToMany(mappedBy = "order", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.LAZY)
    private Set<OrderItem> items = new HashSet<>();

    // --- Transaction Status & Details ---
    @Enumerated(EnumType.STRING)
    @Column(name = "status", nullable = false, length = 20)
    private OrderStatus status = OrderStatus.PENDING;

    @Column(name = "total_payment", nullable = false, precision = 12, scale = 2)
    private BigDecimal totalPayment = BigDecimal.ZERO;

    @Column(name = "paid", nullable = false)
    private Boolean paid = false;

    @Column(name = "fulfilled", nullable = false)
    private Boolean fulfilled = false;

    // Date/Time Tracking
    @Column(name = "date_created", nullable = false)
    private LocalDateTime dateCreated = LocalDateTime.now();

    @Column(name = "date_paid")
    private LocalDateTime datePaid;

    @Column(name = "date_fulfilled")
    private LocalDateTime dateFulfilled;

    public void addItem(OrderItem item) {
        items.add(item);
        item.setOrder(this);
        this.calculateTotalPayment();
    }

    public void calculateTotalPayment() {
        BigDecimal total = BigDecimal.ZERO;

        if (this.items != null) {
            for (OrderItem item : this.items) {

                // Calculate item cost: unitPriceAtPurchase * amount
                BigDecimal itemCost = item.getItemPrice().multiply(new BigDecimal(item.getAmount()));
                total = total.add(itemCost);
            }
        }
        this.totalPayment = total;
    }
}