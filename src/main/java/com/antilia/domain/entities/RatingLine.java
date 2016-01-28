package com.antilia.domain.entities;

/**
 * RatingLine
 */
public class RatingLine {
    
    private String questionId;
    private int value;
    private int responses;
    private int change;


    public RatingLine() {
    }

    public String getQuestionId() {
        return questionId;
    }

    public void setQuestionId(String questionId) {
        this.questionId = questionId;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public int getResponses() {
        return responses;
    }

    public void setResponses(int responses) {
        this.responses = responses;
    }

    public int getChange() {
        return change;
    }

    public void setChange(int change) {
        this.change = change;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof RatingLine)) return false;

        RatingLine that = (RatingLine) o;

        if (value != that.value) return false;
        if (questionId != null ? !questionId.equals(that.questionId) : that.questionId != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = questionId != null ? questionId.hashCode() : 0;
        result = 31 * result + value;
        return result;
    }
}
