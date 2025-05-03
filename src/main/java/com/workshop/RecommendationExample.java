package com.workshop;

import org.apache.mahout.cf.taste.impl.model.file.FileDataModel;
import org.apache.mahout.cf.taste.impl.similarity.PearsonCorrelationSimilarity;
import org.apache.mahout.cf.taste.impl.neighborhood.NearestNUserNeighborhood;
import org.apache.mahout.cf.taste.impl.recommender.GenericUserBasedRecommender;
import org.apache.mahout.cf.taste.model.DataModel;
import org.apache.mahout.cf.taste.similarity.UserSimilarity;
import org.apache.mahout.cf.taste.neighborhood.UserNeighborhood;
import org.apache.mahout.cf.taste.recommender.RecommendedItem;
import org.apache.mahout.cf.taste.recommender.Recommender;

import java.io.File;
import java.net.URL;
import java.util.List;

public class RecommendationExample {
    public static void main(String[] args) throws Exception {
        // Load ratings.csv from the classpath
        URL res = RecommendationExample.class.getResource("/data/ratings.csv");
        if (res == null) {
            throw new IllegalStateException("Could not find /data/ratings.csv on classpath");
        }
        File ratingsFile = new File(res.toURI());

        DataModel model = new FileDataModel(ratingsFile);
        UserSimilarity similarity = new PearsonCorrelationSimilarity(model);
        UserNeighborhood neighborhood = new NearestNUserNeighborhood(3, similarity, model);
        Recommender recommender = new GenericUserBasedRecommender(model, neighborhood, similarity);

        List<RecommendedItem> recs = recommender.recommend(1, 5);
        for (RecommendedItem r : recs) {
            System.out.printf("Item %d (score: %.3f)%n", r.getItemID(), r.getValue());
        }
    }
}