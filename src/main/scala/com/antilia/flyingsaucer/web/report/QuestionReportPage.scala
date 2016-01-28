package com.antilia.flyingsaucer.web.report

import java.util.Date
import javax.inject.Inject

import com.antilia.domain.entities.SurveyReport
import com.antilia.flyingsaucer.domain.service.ISurveyRepository
import com.antilia.flyingsaucer.web.report.panels.{SurveyNotFoundPanel, SurveyReportPanel}
import org.apache.commons.lang3.time.DateUtils
import org.apache.wicket.markup.html.WebPage

/**
 * QuestionReportPage
 */
class QuestionReportPage extends WebPage {

  val report = new SurveyReport()
  report.setReportTitle("My luxury Hotel!")
  report.setReportSubTitle("Guest Satisfaction Survey: View Name")
  val now = new Date()
  report.setTo(now)
  report.setFrom(DateUtils.addDays(now, -7))
  
  @Inject
  var surveyRepository: ISurveyRepository = _

  val surveyId= "54c0dfe790eeff7c06b46e4d"

  override def onBeforeRender(): Unit = {
    super.onBeforeRender()
    val surveyOpt = surveyRepository.findByIdAndLanguage(report.getSurveyId, report.getLanguage)
    surveyOpt match {
      case Some(survey) => add( new SurveyReportPanel("report", new SurveyLDM(survey), report))
      case None => add( new SurveyNotFoundPanel("report", surveyId))
    }
  }
}
