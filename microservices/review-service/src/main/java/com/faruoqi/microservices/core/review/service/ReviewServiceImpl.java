package com.faruoqi.microservices.core.review.service;

import com.faruoqi.api.core.review.Review;
import com.faruoqi.api.core.review.ReviewService;
import com.faruoqi.api.exceptions.InvalidInputException;
import com.faruoqi.util.http.ServiceUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class ReviewServiceImpl implements ReviewService {

    private final ServiceUtil serviceUtil;
    private static final Logger LOG = LoggerFactory.getLogger(ReviewServiceImpl.class);


    @Autowired
    public ReviewServiceImpl(ServiceUtil serviceUtil) {
        this.serviceUtil = serviceUtil;
    }

    @Override
    public List<Review> getReviews(int productId) {

        if (productId < 1) {
            throw new InvalidInputException("Invalid productId: " + productId);
        }

        if (productId == 213) {
            LOG.debug("No reviews found for productId: {}", productId);
            return new ArrayList<>();
        }

        Review review =
                new Review(productId,1,"author review 1",
                        "good review","good",
                        this.serviceUtil.getServiceAddress());

        Review review2 =
                new Review(productId,2,"author review 2",
                        "bad review","bad",
                        this.serviceUtil.getServiceAddress());

        List<Review> reviews = new ArrayList<Review>();
        reviews.add(review);
        reviews.add(review2);
        return reviews;
    }
}

