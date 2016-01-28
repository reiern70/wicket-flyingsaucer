package com.antilia.domain.service.mock

import java.util
import java.util.{Comparator, Collections}

import com.antilia.domain.entities.{QuestionType, Question, Language}
import com.antilia.flyingsaucer.domain.service.IQuestionRepository
import com.antilia.util.FileUtils
import scala.collection.JavaConversions._

object MockQuestionRepository {
  
  val instance = new MockQuestionRepository
}
/**
  * MockSurveyRepository
  */
class MockQuestionRepository extends IQuestionRepository {
  
  val questions = new util.HashMap[String, Question]()
  
  FileUtils.readLines(classOf[MockQuestionRepository].getResourceAsStream("/questions.txt")).foreach( line => {
    val strings = line.split("\\|")
    val question = new Question
    question.setId(strings(0))
    question.setLanguage(Language.valueOf(strings(1)))
    question.addI18n("shortLabel", strings(2))
    question.setType(QuestionType.valueOf(strings(3)))
    questions.put(question.getId, question)
  })  
  
  
  override def findByIdAndLanguage(id: String, language: Language): Option[Question] = {
    val question =  questions.get(id)
    if(question != null) {
      Some(question)
    } else {
      None
    }
  }

  override def findAllForSurvey(surveyId: String): java.lang.Iterable[Question] = {
    val qs = new java.util.ArrayList(questions.values())
    Collections.sort(qs)
    qs
  }
}
