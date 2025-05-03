package com.workshop;

import weka.core.Instances;
import weka.core.converters.ConverterUtils.DataSource;
import weka.classifiers.bayes.NaiveBayes;
import weka.classifiers.Evaluation;
import java.util.Random;

public class ClassificationExample {
    public static void main(String[] args) throws Exception {
        DataSource source = new DataSource("data/iris.csv");
        Instances data = source.getDataSet();
        data.setClassIndex(data.numAttributes() - 1);

        NaiveBayes nb = new NaiveBayes();
        nb.buildClassifier(data);

        Evaluation eval = new Evaluation(data);
        eval.crossValidateModel(nb, data, 10, new Random(1));
        System.out.println(eval.toSummaryString());
    }
}