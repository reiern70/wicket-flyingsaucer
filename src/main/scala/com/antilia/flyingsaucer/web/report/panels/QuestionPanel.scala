package com.antilia.flyingsaucer.web.report.panels

import com.antilia.domain.entities.Question
import org.apache.wicket.Component
import org.apache.wicket.markup.html.basic.Label
import org.apache.wicket.markup.html.panel.GenericPanel
import org.apache.wicket.model.IModel

/**
 * QuestionPanel
 */
class QuestionPanel(id: String, model: IModel[Question]) extends GenericPanel[Question](id, model){

  override def onInitialize(): Unit = {
    super.onInitialize()
    val map = model.getObject.getI18n.asInstanceOf[java.util.Map[String, String]]
    add( new Label("title", map.get("shortLabel")))
    add( getBody("body", model))
  }
  
  protected def getBody(id: String, model: IModel[Question]): Component = new Label(id, "To be implemented!!! --> " + model.getObject.getType)
}
