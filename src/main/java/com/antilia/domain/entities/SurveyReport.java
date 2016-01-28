package com.antilia.domain.entities;

import java.io.Serializable;
import java.util.Date;

/**
 * SurveyReport
 */
public class SurveyReport implements Serializable {
    
    private String surveyId;
    private String companyName;
    private String reportTitle;
    private String reportSubTitle;
    private Date from;
    private Date to;
    private byte[] companyIcon;
    private Language language;
    
    public SurveyReport() {
    }

    public String getSurveyId() {
        return surveyId;
    }

    public void setSurveyId(String surveyId) {
        this.surveyId = surveyId;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public Date getFrom() {
        return from;
    }

    public void setFrom(Date from) {
        this.from = from;
    }

    public String getReportTitle() {
        return reportTitle;
    }

    public void setReportTitle(String reportTitle) {
        this.reportTitle = reportTitle;
    }

    public Date getTo() {
        return to;
    }

    public void setTo(Date to) {
        this.to = to;
    }

    public byte[] getCompanyIcon() {
        return companyIcon;
    }

    public void setCompanyIcon(byte[] companyIcon) {
        this.companyIcon = companyIcon;
    }

    public Language getLanguage() {
        return language;
    }

    public void setLanguage(Language language) {
        this.language = language;
    }

    public String getReportSubTitle() {
        return reportSubTitle;
    }

    public void setReportSubTitle(String reportSubTitle) {
        this.reportSubTitle = reportSubTitle;
    }
}
