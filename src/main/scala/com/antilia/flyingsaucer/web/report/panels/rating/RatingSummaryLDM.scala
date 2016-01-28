package com.antilia.flyingsaucer.web.report.panels.rating

import javax.inject.Inject

import com.antilia.domain.entities.RatingSummary
import com.antilia.flyingsaucer.domain.service.IRatingSummaryRepository
import org.apache.wicket.model.LoadableDetachableModel

/**
 * SurveyModel
 */
class RatingSummaryLDM(summary: RatingSummary) extends LoadableDetachableModel[RatingSummary](summary){

  val id = summary.getQuestionId

  @Inject
  var repository: IRatingSummaryRepository = _

  override def load(): RatingSummary = {
    repository.getRatingSummaryFor(id).orNull
  }
}
