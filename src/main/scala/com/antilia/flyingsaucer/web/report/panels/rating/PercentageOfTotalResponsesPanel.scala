package com.antilia.flyingsaucer.web.report.panels.rating

import com.antilia.flyingsaucer.web.report.panels.RoundToTwoPlacesModel
import org.apache.wicket.AttributeModifier
import org.apache.wicket.markup.html.WebMarkupContainer
import org.apache.wicket.markup.html.basic.Label
import org.apache.wicket.markup.html.panel.Panel

/**
 * PercentageOfTotalResponsesPanel
 */
class PercentageOfTotalResponsesPanel(id: String, responses: Int, total: Int) extends Panel(id){

  override def onInitialize(): Unit = {
    super.onInitialize()
    val percentage = (responses.asInstanceOf[Double]/total.asInstanceOf[Double])*100
    add( new Label("percentage", new RoundToTwoPlacesModel(percentage) {
      override def getObject: String = super.getObject + "%"
    }))

    val child = new WebMarkupContainer("child")
    child.add( new AttributeModifier("style", "width: " + percentage.asInstanceOf[Int] +"px"))
    add(child)
  }
}
