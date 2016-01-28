package com.antilia.flyingsaucer.web.report.panels

import java.text.DecimalFormat

import org.apache.wicket.model.{AbstractReadOnlyModel, LoadableDetachableModel}

/**
 */
class RoundToTwoPlacesModel(value: Double) extends AbstractReadOnlyModel[String] {

  val formatter = new DecimalFormat(".##")

  override def getObject: String = formatter.format(value)
}
