package entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;
import java.math.BigDecimal;
import java.util.HashSet;
import java.util.Set;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "sellers")
public class Seller {

    // --- Primary Key Shared with User ---
    // The ID of the Seller is the same as the ID of the User.
    @Id
    private Long id;

    // --- The One-to-One Link back to User (The CRITICAL step) ---
    @OneToOne
    @MapsId
    @JoinColumn(name = "user_id") // The foreign key column in the 'sellers' table
    private User user;

    // Store Identity
    @Column(name = "store_name", unique = true, nullable = false, length = 100)
    private String storeName;

    @Column(name = "store_description", columnDefinition = "TEXT")
    private String storeDescription;

    @Column(name = "store_image_url", length = 255)
    private String storeImageUrl;

    // Financial/Activity Data
    @Column(name = "total_revenue", precision = 10, scale = 2)
    private BigDecimal totalRevenue = BigDecimal.ZERO;

    @Column(name = "total_sales")
    private Integer totalSales = 0;

    // Status/Performance
    @Column(name = "store_rating", precision = 3, scale = 2)
    private BigDecimal storeRating = BigDecimal.valueOf(0.00);

    @Column(name = "banned_account", nullable = false)
    private Boolean bannedAccount = false;

    // One-to-Many Relationship to Products ---
    @OneToMany(mappedBy = "seller", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private Set<Product> products = new HashSet<>();

    public Seller(String storeName, String storeDescription) {
        this.storeName = storeName;
        this.storeDescription = storeDescription;
    }
}