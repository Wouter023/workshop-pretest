package com.workshop;

public class Main {
    public static void main(String[] args) throws Exception {
        System.out.println("=== Regression ===");
        RegressionExample.main(args);

        System.out.println("\n=== Clustering ===");
        ClusteringExample.main(args);

        System.out.println("\n=== Classification ===");
        ClassificationExample.main(args);

        System.out.println("\n=== Recommendation ===");
        RecommendationExample.main(args);
    }
}