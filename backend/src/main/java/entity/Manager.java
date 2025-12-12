package entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "managers")
public class Manager {

    // --- Primary Key Shared with User ---
    // The ID of the Manager is the same as the ID of the User.
    @Id
    private Long id;

    // --- The One-to-One Link back to User (CRITICAL for shared ID) ---
    @OneToOne
    @MapsId
    @JoinColumn(name = "user_id")
    private User user;

    @Column(name = "total_accounts_closed")
    private Integer totalAccountsClosed = 0;

    @Column(name = "banned_account", nullable = false)
    private Boolean bannedAccount = false;

    // One-to-One Relationship to the Admin profile ---
    @OneToOne(mappedBy = "manager", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private Admin adminProfile;
}