package com.antilia.flyingsaucer.web.report.panels

import com.antilia.domain.entities.SurveyReport
import org.apache.wicket.markup.html.basic.Label
import org.apache.wicket.markup.html.panel.GenericPanel
import org.apache.wicket.model.IModel

/**
 * GeneralInfoPanel
 */
class GeneralInfoPanel(id: String, model: IModel[SurveyReport]) extends GenericPanel[SurveyReport](id,model) {
  override def onInitialize(): Unit = {    
    super.onInitialize()
    add( new Label("title", model.getObject.getReportTitle))
    add( new Label("subTitle", model.getObject.getReportSubTitle))
    add( new Label("from", model.getObject.getFrom))
    add( new Label("to", model.getObject.getTo))

  }
}
