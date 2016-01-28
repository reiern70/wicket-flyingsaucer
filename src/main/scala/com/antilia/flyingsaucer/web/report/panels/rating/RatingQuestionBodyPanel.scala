package com.antilia.flyingsaucer.web.report.panels.rating

import javax.inject.Inject

import com.antilia.domain.entities.Question
import com.antilia.flyingsaucer.domain.service.IRatingSummaryRepository
import com.antilia.flyingsaucer.web.report.panels.RoundToTwoPlacesModel
import org.apache.wicket.WicketRuntimeException
import org.apache.wicket.markup.html.WebMarkupContainer
import org.apache.wicket.markup.html.basic.Label
import org.apache.wicket.markup.html.panel.Panel
import org.apache.wicket.markup.repeater.RepeatingView
import org.apache.wicket.model.IModel
import scala.collection.JavaConversions._

/**
 * RatingQuestionPanel
 */
class RatingQuestionBodyPanel(id: String, model: IModel[Question]) extends Panel(id, model) {
  
  @Inject
  var ratingSummaryRepository: IRatingSummaryRepository = _

  override def onInitialize(): Unit = {
    super.onInitialize()
    ratingSummaryRepository.getRatingSummaryFor(model.getObject) match {
      case Some(summary) =>
        add( new Label("averageRating", new RoundToTwoPlacesModel(summary.getAverageRating)) )
        add( new Label("maxRating", summary.getMaxRating))
        add( new DeltaPanel("ratingIncrease", summary.getRatingIncrease))

        add( new Label("previousAverageRating", new RoundToTwoPlacesModel(summary.getPreviousAverageRating)) )
        add( new Label("previousMaxRating", summary.getMaxRating))
        add( new DeltaPanel("previousRatingIncrease", summary.getPreviousAverageRating))

        add( new Label("totalResponses", summary.getTotalResponses) )
        add( new ChangePanel("totalResponsesDelta", summary.getTotalResponsesDelta) )

        add( new Label("previousTotalResponses", summary.getPreviousTotalResponses) )
        add( new ChangePanel("previousTotalResponsesDelta", summary.getPreviousTotalResponsesDelta) )

        val row = new RepeatingView("row")
        add(row)
        // add detail lines
        summary.getRatingLines.foreach(line => {
            val wm = new WebMarkupContainer(row.newChildId())
            row.add(wm)
            wm.add(new Label("rating", line.getValue))
            wm.add(new Label("responses", line.getResponses))
            wm.add(new ChangePanel("change", line.getChange))
            wm.add(new PercentageOfTotalResponsesPanel("percentage", line.getResponses, summary.getTotalResponses))
        })
      // complain if we have no summary
      case None => throw new WicketRuntimeException("Could not find a rating summary!")
    }
  }
}
