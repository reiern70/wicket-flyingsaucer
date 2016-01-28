package com.antilia.flyingsaucer.web.report.panels

import org.apache.wicket.markup.html.basic.Label
import org.apache.wicket.markup.html.panel.Panel

/**
 * SurveyNotFoundPanel
 */
class SurveyNotFoundPanel(id: String, surveyId: String) extends Panel(id) {

  override def onInitialize(): Unit = {
    super.onInitialize()
    add( new Label("surveyId", surveyId))
  }
}
