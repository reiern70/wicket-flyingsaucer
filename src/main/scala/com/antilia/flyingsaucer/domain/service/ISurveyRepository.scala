package com.antilia.flyingsaucer.domain.service

import com.antilia.domain.entities.{Language, Survey}

/**
 * IFlatSurveyRepository
 */
trait ISurveyRepository {
  
  def findByIdAndLanguage(surveyId: String, language: Language) : Option[Survey]

}
