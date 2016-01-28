package com.antilia.flyingsaucer.web.report.panels

import com.antilia.domain.entities.Question
import org.apache.wicket.markup.html.panel.Panel
import org.apache.wicket.model.IModel

object DefaultQuestionHandler {

  val instance = new DefaultQuestionHandler

}

/**
 * DefaultQuestionHandler
 */
class DefaultQuestionHandler extends IQuestionHandler {
  
  override def canHandle(model: IModel[Question]): Boolean = true

  override def createQuestionPanel(id: String, model: IModel[Question]): Panel = new QuestionPanel(id, model)
}
