package com.antilia.flyingsaucer.web.report.panels

import com.antilia.domain.entities.Question
import org.apache.wicket.markup.html.panel.Panel
import org.apache.wicket.model.IModel

/**
 * IQuestionHandler
 */
trait IQuestionHandler {
  
  def canHandle(model: IModel[Question]): Boolean
  
  def createQuestionPanel(id: String, model: IModel[Question]): Panel

}
