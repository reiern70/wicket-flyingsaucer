package com.antilia.domain.entities;

import java.util.ArrayList;
import java.util.List;

/**
 * FlatSurvey
 */
public class Survey {

    private String id;
    private Language language;
    private List<Question> questions;
    
    public Survey(Language language) {
        this.language = language;
        this.questions = new ArrayList<Question>();
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Language getLanguage() {
        return language;
    }

    public void setLanguage(Language language) {
        this.language = language;
    }

    public List<Question> getQuestions() {
        return questions;
    }

    public void setQuestions(List<Question> questions) {
        this.questions = questions;
    }

    public void addQuestion(Question question) {
        this.questions.add(question);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Survey)) return false;

        Survey that = (Survey) o;

        if (id != null ? !id.equals(that.id) : that.id != null) return false;
        if (language != null ? !language.equals(that.language) : that.language != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (language != null ? language.hashCode() : 0);
        return result;
    }
}
