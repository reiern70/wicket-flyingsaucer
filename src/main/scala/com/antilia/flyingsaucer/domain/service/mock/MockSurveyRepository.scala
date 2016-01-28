package com.antilia.domain.service.mock

import com.antilia.domain.entities.{Survey, Language}
import com.antilia.flyingsaucer.domain.service.ISurveyRepository
import scala.collection.JavaConversions._

object MockSurveyRepository {
  
  val instance = new MockSurveyRepository
}

/**
 * MockSurveyRepository
 */
class MockSurveyRepository extends ISurveyRepository {

  val survey = new Survey(Language.en)
  survey.setId("aasddeqweweweqwe")
  MockQuestionRepository.instance.findAllForSurvey(survey.getId).foreach( q => {
    survey.addQuestion(q)
  })

  
  override def findByIdAndLanguage(surveyId: String, language: Language): Option[Survey] = {
    Some(survey)
  }
}
