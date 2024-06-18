package com.faruoqi.microservices.core.recommendation.service;


import com.faruoqi.api.core.recommendation.Recommendation;
import com.faruoqi.api.core.recommendation.RecommendationService;
import com.faruoqi.util.http.ServiceUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class RecommendationServiceImpl implements RecommendationService {

    private final ServiceUtil serviceUtil;

    @Autowired
    public RecommendationServiceImpl(ServiceUtil serviceUtil) {
        this.serviceUtil = serviceUtil;
    }


    @Override
    public List<Recommendation> getRecommendations(int productId) {
        Recommendation recommendation =
                new Recommendation(productId,1,"author 1",8,"good",this.serviceUtil.getServiceAddress());

        Recommendation recommendation2 =
                new Recommendation(productId,2,"author 2",9,"great",this.serviceUtil.getServiceAddress());


        List<Recommendation> recommendationList = new ArrayList<Recommendation>();
        recommendationList.add(recommendation);
        recommendationList.add(recommendation2);

        return recommendationList;

    }
}
