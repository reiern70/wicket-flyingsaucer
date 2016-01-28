package com.antilia.flyingsaucer.domain.service

import com.antilia.domain.entities.{Language, Question}

/**
 * IQuestionRepository
 */
trait IQuestionRepository {

  def findByIdAndLanguage(id: String, language: Language) : Option[Question]

  def findAllForSurvey(surveyId: String) : java.lang.Iterable[Question]

}
