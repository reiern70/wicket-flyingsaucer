package com.antilia.flyingsaucer.web.report.panels.rating

import com.antilia.flyingsaucer.web.report.panels.RoundToTwoPlacesModel
import org.apache.wicket.AttributeModifier
import org.apache.wicket.markup.html.basic.Label
import org.apache.wicket.markup.html.panel.GenericPanel
import org.apache.wicket.model.Model

/**
 * DeltaPanel
 */
class ChangePanel(id: String, value: java.lang.Integer) extends GenericPanel[java.lang.Integer](id, new Model[java.lang.Integer](value)) {

  setRenderBodyOnly(false)

  override def onInitialize(): Unit = {
    super.onInitialize()
    val sign = if(value > 0) "+ " else "- "
    val label = new Label("value", sign + Math.abs(value) )
    add(label)
  }
}
