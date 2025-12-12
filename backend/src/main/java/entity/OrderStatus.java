package entity;

public enum OrderStatus {
    PENDING,        // Waiting for payment/confirmation
    PROCESSING,     // Payment confirmed, preparing for shipment
    SHIPPED,        // In transit
    DELIVERED,      // Received by buyer
    CANCELLED,      // Order cancelled
    REFUNDED        // Payment reversed
}