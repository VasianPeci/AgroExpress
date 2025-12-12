package entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;
import java.math.BigDecimal;
import java.util.Set;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "products")
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // --- Foreign Key to Seller (Many-to-One Relationship) ---
    // Many Products belong to One Seller. The foreign key column will be 'seller_id'.
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "seller_id", nullable = false)
    private Seller seller;

    @Column(name = "product_name", nullable = false, length = 150)
    private String productName;

    @Column(name = "product_description", columnDefinition = "TEXT")
    private String productDescription;

    @Column(name = "product_image_url", length = 255)
    private String productImageUrl;

    // --- Financial & Stock ---
    @Column(name = "price", nullable = false, precision = 10, scale = 2)
    private BigDecimal price;

    @Column(name = "stock", nullable = false)
    private Integer stock;

    // --- Sales & Performance ---
    @Column(name = "total_sales")
    private Integer totalSales = 0;

    @Column(name = "product_rating", precision = 3, scale = 2)
    private BigDecimal productRating = BigDecimal.valueOf(0.00);

    @Column(name = "banned", nullable = false)
    private Boolean banned = false;

    // Handling 'tags' as a collection of strings in the database (simple way)
    // This creates a separate table (product_tags) behind the scenes
    @ElementCollection(fetch = FetchType.EAGER)
    @CollectionTable(name = "product_tags", joinColumns = @JoinColumn(name = "product_id"))
    @Column(name = "tag")
    private Set<String> tags;

    public Product(Seller seller, String productName, String productDescription, BigDecimal price, Integer stock) {
        this.seller = seller;
        this.productName = productName;
        this.productDescription = productDescription;
        this.price = price;
        this.stock = stock;
    }
}