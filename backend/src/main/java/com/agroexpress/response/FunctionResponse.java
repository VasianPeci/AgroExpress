package com.agroexpress.response;

import com.agroexpress.dto.OrderHistory;
import com.agroexpress.model.Cart;
import com.agroexpress.model.Product;
import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class FunctionResponse {
    private String functionName;
    private Cart userCart;
    private OrderHistory orderHistory;
    private Product product;
}


