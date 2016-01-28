package com.antilia.flyingsaucer.web.report.panels.rating

import com.antilia.flyingsaucer.web.report.panels.RoundToTwoPlacesModel
import org.apache.wicket.AttributeModifier
import org.apache.wicket.markup.html.basic.Label
import org.apache.wicket.markup.html.panel.GenericPanel
import org.apache.wicket.model.Model

/**
 * DeltaPanel
 */
class DeltaPanel(id: String, value: java.lang.Double) extends GenericPanel[java.lang.Double](id, new Model[java.lang.Double](value)) {

  setRenderBodyOnly(true)

  override def onInitialize(): Unit = {
    super.onInitialize()
    val sign = if(value > 0) "+ " else "- "
    val label = new Label("value", sign + new RoundToTwoPlacesModel(Math.abs(value)).getObject )
    label.add(new AttributeModifier("class", if(value > 0) "DeltaPlus" else "DeltaMinus"))
    add(label)
  }
}
