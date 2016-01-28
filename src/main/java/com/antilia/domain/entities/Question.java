package com.antilia.domain.entities;


import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

/**
 * FlatQuestion
 */
public class Question implements Comparable<Question> {
    
    private String id;
    private Language language;
    private QuestionType type;
    private String topic;
    private Integer outOf;
    private Map<String, String> i18n;

    public Question() {
        i18n = new HashMap<String, String>();
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

    public QuestionType getType() {
        return type;
    }

    public void setType(QuestionType type) {
        this.type = type;
    }

    public String getTopic() {
        return topic;
    }

    public void setTopic(String topic) {
        this.topic = topic;
    }

    public Integer getOutOf() {
        return outOf;
    }

    public void setOutOf(Integer outOf) {
        this.outOf = outOf;
    }

    public Map<String, String> getI18n() {
        return i18n;
    }

    public void setI18n(Map<String, String> i18n) {
        this.i18n = i18n;
    }

    public void addI18n(String key, String value) {
        this.i18n.put(key, value);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Question)) return false;

        Question that = (Question) o;

        if (!id.equals(that.id)) return false;
        if (!language.equals(that.language)) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id.hashCode();
        result = 31 * result + language.hashCode();
        return result;
    }

    @Override
    public int compareTo(Question o) {
        return getId().compareTo(o.getId());
    }
}
