package com.agroexpress.service;

import com.agroexpress.exception.ReviewNotFoundException;
import com.agroexpress.model.Product;
import com.agroexpress.model.Review;
import com.agroexpress.model.User;
import com.agroexpress.request.CreateReviewRequest;
import javax.naming.AuthenticationException;
import java.util.List;

public interface ReviewService {
    Review createReview(CreateReviewRequest req,
                        User user,
                        Product product);
    List<Review> getReviewsByProductId(Long productId);
    Review updateReview(Long reviewId,
                        String reviewText,
                        double rating,
                        Long userId) throws ReviewNotFoundException, AuthenticationException;
    void deleteReview(Long reviewId, Long userId) throws ReviewNotFoundException, AuthenticationException;

}


