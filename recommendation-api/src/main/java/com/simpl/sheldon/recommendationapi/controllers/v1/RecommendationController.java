package com.simpl.sheldon.recommendationapi.controllers.v1;


import com.simpl.sheldon.recommendationapi.models.requests.ComplRecommendRequest;
import com.simpl.sheldon.recommendationapi.models.responses.recommendation.RecommendationResponse;
import com.simpl.sheldon.recommendationapi.models.responses.recommendation.RecommendationResponseData;
import com.simpl.sheldon.recommendationapi.services.ComplRecommenderService;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1")
public class RecommendationController {

    @Autowired
    @Qualifier("mockedComplementaryRecommenderService")
    private ComplRecommenderService mockedComplRecommenderService;

    @Autowired
    @Qualifier("complRecommenderServicev1")
    private ComplRecommenderService complRecommenderServicev1;

    private static final Logger logger = LogManager.getLogger(RecommendationController.class);

    @PostMapping(path = "/recommendation", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<RecommendationResponse> getRecommendation(
            @Valid @NotBlank @RequestBody ComplRecommendRequest request,
            @RequestHeader(value = "X-REQUEST-ID") String requestId)
    {
        logger.info("Received Recommendation Request: " + requestId);
        RecommendationResponseData responseData = null;
        try {
            responseData = mockedComplRecommenderService.getRecommendation(request);
        } catch (Exception ex) {
            logger.error("Error while processing request: " + requestId, ex);
            throw ex;
        }
        return ResponseEntity.ok(new RecommendationResponse(responseData));
    }

    @PostMapping(path = "/recommendation/new", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<RecommendationResponse> getRecommendationv2(
            @Valid @NotBlank @RequestBody ComplRecommendRequest request,
            @RequestHeader(value = "X-REQUEST-ID") String requestId)
    {
        logger.info("Received Recommendation Request: " + requestId);
        RecommendationResponseData responseData = null;
        try {
            responseData = complRecommenderServicev1.getRecommendation(request);
        } catch (Exception ex) {
            logger.error("Error while processing request: " + requestId, ex);
            throw ex;
        }
        return ResponseEntity.ok(new RecommendationResponse(responseData));
    }
}
