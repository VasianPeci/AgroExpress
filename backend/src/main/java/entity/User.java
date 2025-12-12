package entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;
import java.math.BigDecimal;
import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "users",
        uniqueConstraints = {
                @UniqueConstraint(columnNames = {"username"}),
                @UniqueConstraint(columnNames = {"email"}),
                @UniqueConstraint(columnNames = {"phoneNumber"})
        })
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name", nullable = false, length = 50)
    private String name;

    @Column(name = "surname", nullable = false, length = 50)
    private String surname;

    @Column(name = "username", nullable = false, unique = true, length = 50)
    private String username;

    // CRITICAL: Stored as a secure hash (e.g., BCrypt hash string)
    @Column(name = "password", nullable = false)
    private String password;

    @Column(name = "email", nullable = false, unique = true, length = 100)
    private String email;

    @Column(name = "phone_number", unique = true, length = 15)
    private String phoneNumber;

    @Column(name = "image_url", length = 255)
    private String imageUrl;

    @Column(name = "birthday")
    private LocalDate birthday;

    @Column(name = "bio", length = 500)
    private String bio;

    @Column(name = "verified", nullable = false)
    private Boolean verified = false;

    @Column(name = "total_expenses", precision = 10, scale = 2)
    private BigDecimal totalExpenses = BigDecimal.ZERO;

    @Column(name = "total_orders")
    private Integer totalOrders = 0;

    @Column(name = "address", length = 255)
    private String address;

    @Enumerated(EnumType.STRING)
    @Column(name = "payment_method", length = 50)
    private PaymentMethod paymentMethod;

    // --- Role Field ---
    // This column will be NULL for a base ROLE_USER/Buyer.
    // It will hold ROLE_SELLER, ROLE_MANAGER, or ROLE_ADMIN for higher-privilege users.
    @Enumerated(EnumType.STRING)
    @Column(name = "role", nullable = true, length = 20)
    private Roles role;

    // --- One-to-One Relationship to the Seller profile ---
    @OneToOne(mappedBy = "user", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private Seller sellerProfile;

    // 🌟 NEW: One-to-One Relationship to the Manager profile ---
    @OneToOne(mappedBy = "user", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private Manager managerProfile;

    public User(String name, String surname, String username, String email, String password, String phoneNumber, Roles role) {
        this.name = name;
        this.surname = surname;
        this.username = username;
        this.email = email;
        this.password = password;
        this.phoneNumber = phoneNumber;
        this.role = role;
    }
}