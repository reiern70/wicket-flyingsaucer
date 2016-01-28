package com.antilia.flyingsaucer.web.report

import javax.inject.Inject

import com.antilia.domain.entities.{Survey, Language}
import com.antilia.flyingsaucer.domain.service.ISurveyRepository
import org.apache.wicket.model.LoadableDetachableModel

/**
 * SurveyModel
 */
class SurveyLDM(survey: Survey) extends LoadableDetachableModel[Survey](survey){

  val id = survey.getId
  val language: Language = survey.getLanguage

  @Inject
  var surveyClient: ISurveyRepository = _

  override def load(): Survey = {
    surveyClient.findByIdAndLanguage(id, language).orNull
  }
}
