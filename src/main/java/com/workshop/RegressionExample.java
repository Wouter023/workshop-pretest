package com.workshop;

import weka.core.Instances;
import weka.core.converters.CSVLoader;
import weka.classifiers.functions.LinearRegression;

import java.io.File;

public class RegressionExample {
    public static void main(String[] args) throws Exception {
        CSVLoader loader = new CSVLoader();
        // Load the dataset
        loader.setSource(new File("data/housing.csv"));
        Instances data = loader.getDataSet();

        // Set the target attribute (last column)
        data.setClassIndex(data.numAttributes() - 1);

        // Build and print the regression model
        LinearRegression model = new LinearRegression();
        model.buildClassifier(data);
        System.out.println(model);
    }
}