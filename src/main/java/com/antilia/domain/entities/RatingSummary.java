package com.antilia.domain.entities;

import java.util.ArrayList;
import java.util.List;

/**
 * RatingSummary
 */
public class RatingSummary {
    
    private String questionId;

    private int maxRating;
    private double averageRating;
    private double ratingIncrease;

    private double previousAverageRating;
    private double previousRatingIncrease;

    private int totalResponses;
    private int totalResponsesDelta;
    private int previousTotalResponses;
    private int previousTotalResponsesDelta;
    
    private List<RatingLine> ratingLines = new ArrayList<RatingLine>();
    
    public RatingSummary() {
    }

    public String getQuestionId() {
        return questionId;
    }

    public void setQuestionId(String questionId) {
        this.questionId = questionId;
    }

    public int getMaxRating() {
        return maxRating;
    }

    public void setMaxRating(int maxRating) {
        this.maxRating = maxRating;
    }

    public double getAverageRating() {
        return averageRating;
    }

    public void setAverageRating(double averageRating) {
        this.averageRating = averageRating;
    }

    public double getRatingIncrease() {
        return ratingIncrease;
    }

    public void setRatingIncrease(double ratingIncrease) {
        this.ratingIncrease = ratingIncrease;
    }

    public double getPreviousAverageRating() {
        return previousAverageRating;
    }

    public void setPreviousAverageRating(double previousAverageRating) {
        this.previousAverageRating = previousAverageRating;
    }

    public double getPreviousRatingIncrease() {
        return previousRatingIncrease;
    }

    public void setPreviousRatingIncrease(double previousRatingIncrease) {
        this.previousRatingIncrease = previousRatingIncrease;
    }

    public int getTotalResponses() {
        return totalResponses;
    }

    public void setTotalResponses(int totalResponses) {
        this.totalResponses = totalResponses;
    }

    public int getTotalResponsesDelta() {
        return totalResponsesDelta;
    }

    public void setTotalResponsesDelta(int totalResponsesDelta) {
        this.totalResponsesDelta = totalResponsesDelta;
    }

    public int getPreviousTotalResponses() {
        return previousTotalResponses;
    }

    public void setPreviousTotalResponses(int previousTotalResponses) {
        this.previousTotalResponses = previousTotalResponses;
    }

    public int getPreviousTotalResponsesDelta() {
        return previousTotalResponsesDelta;
    }

    public void setPreviousTotalResponsesDelta(int previousTotalResponsesDelta) {
        this.previousTotalResponsesDelta = previousTotalResponsesDelta;
    }

    public List<RatingLine> getRatingLines() {
        return ratingLines;
    }
    
    public void addLine(RatingLine line) {
        ratingLines.add(line);
    }
}
