package com.antilia.flyingsaucer.web.report.panels.rating

import com.antilia.domain.entities.{QuestionType, Question}
import com.antilia.flyingsaucer.web.report.panels.{QuestionPanel, IQuestionHandler}
import org.apache.wicket.Component
import org.apache.wicket.markup.html.panel.Panel
import org.apache.wicket.model.IModel

object RatingQuestionHandler {
  
  val instance = new RatingQuestionHandler
  
}


/**
  * DefaultQuestionHandler
  */
class RatingQuestionHandler extends IQuestionHandler {

   override def canHandle(model: IModel[Question]): Boolean = QuestionType.rating.equals(model.getObject.getType)

   override def createQuestionPanel(id: String, model: IModel[Question]): Panel = new QuestionPanel(id, model) {
     
     override protected def getBody(id: String, model: IModel[Question]): Component = new RatingQuestionBodyPanel(id, model)
   }
 }
