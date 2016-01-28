package com.antilia.flyingsaucer.web.report

import javax.inject.Inject

import com.antilia.domain.entities.{Language, Question}
import com.antilia.flyingsaucer.domain.service.IQuestionRepository
import org.apache.wicket.model.LoadableDetachableModel

/**
 * SurveyModel
 */
class QuestionLDM(question: Question) extends LoadableDetachableModel[Question](question){

  val id = question.getId
  val language: Language = question.getLanguage

  @Inject
  var repository: IQuestionRepository = _

  override def load(): Question = {
    repository.findByIdAndLanguage(id, language).orNull
  }
}
