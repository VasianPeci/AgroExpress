package entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;
import java.math.BigDecimal;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "admins")
public class Admin {

    // --- Primary Key Shared with Manager ---
    @Id
    private Long id;

    // --- The One-to-One Link back to MANAGER (CRITICAL CHANGE) ---
    @OneToOne
    @MapsId
    @JoinColumn(name = "manager_id")
    private Manager manager;

    @Column(name = "total_platform_revenue", precision = 12, scale = 2)
    private BigDecimal totalPlatformRevenue = BigDecimal.ZERO;

    @Column(name = "total_manager_accounts_closed")
    private Integer totalManagerAccountsClosed = 0;
}