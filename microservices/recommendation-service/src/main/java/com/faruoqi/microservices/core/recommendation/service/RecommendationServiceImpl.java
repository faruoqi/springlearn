package com.faruoqi.microservices.core.recommendation.service;


import com.faruoqi.api.core.recommendation.Recommendation;
import com.faruoqi.api.core.recommendation.RecommendationService;
import com.faruoqi.api.exceptions.InvalidInputException;
import com.faruoqi.util.http.ServiceUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class RecommendationServiceImpl implements RecommendationService {

    private final ServiceUtil serviceUtil;
    private static final Logger LOG = LoggerFactory.getLogger(RecommendationServiceImpl.class);

    @Autowired
    public RecommendationServiceImpl(ServiceUtil serviceUtil) {
        this.serviceUtil = serviceUtil;
    }


    @Override
    public List<Recommendation> getRecommendations(int productId) {

        if (productId < 1) {
            throw new InvalidInputException("Invalid productId: " + productId);
        }

        if (productId == 113) {
            LOG.debug("No reviews found for productId: {}", productId);
            return new ArrayList<>();
        }

        Recommendation recommendation =
                new Recommendation(productId,1,"author 1",8,"good",this.serviceUtil.getServiceAddress());

        Recommendation recommendation2 =
                new Recommendation(productId,2,"author 2",9,"great",this.serviceUtil.getServiceAddress());

        Recommendation recommendation3 =
                new Recommendation(productId,3,"author 3",9,"great",this.serviceUtil.getServiceAddress());

        List<Recommendation> recommendationList = new ArrayList<Recommendation>();
        recommendationList.add(recommendation);
        recommendationList.add(recommendation2);
        recommendationList.add(recommendation3);

        return recommendationList;

    }
}
