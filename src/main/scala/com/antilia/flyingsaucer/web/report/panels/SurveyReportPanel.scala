package com.antilia.flyingsaucer.web.report.panels

import com.antilia.domain.entities.{Survey, SurveyReport}
import com.antilia.flyingsaucer.web.report.QuestionLDM
import com.antilia.flyingsaucer.web.report.panels.rating.RatingQuestionHandler
import org.apache.wicket.markup.html.panel.GenericPanel
import org.apache.wicket.markup.repeater.RepeatingView
import org.apache.wicket.model.{IModel, Model}

import scala.collection.JavaConversions._

/**
 * SurveyReportPanel
 */
class SurveyReportPanel(id: String, model: IModel[Survey], report: SurveyReport) extends GenericPanel[Survey](id, model) {
  
  // default has to be the last one
  val handlers = Array[IQuestionHandler](RatingQuestionHandler.instance, DefaultQuestionHandler.instance)
  
  override def onInitialize(): Unit = {
    super.onInitialize()
    add( new GeneralInfoPanel("generalInfo", Model.of(report)))
    val questions = new RepeatingView("questions")
    model.getObject.getQuestions.foreach(question => {
      val qModel = new QuestionLDM(question)
      // find the proper handler to handle a question
      val handler: IQuestionHandler = handlers.find(handler => handler.canHandle(qModel)) match {
        case Some(h) => h
        case None => DefaultQuestionHandler.instance
      }
      questions.add(handler.createQuestionPanel(questions.newChildId(), qModel))
    })
    add(questions)
  }
}
