package com.antilia.flyingsaucer.domain.service

import com.antilia.domain.entities.{Question, RatingSummary}

/**
 * IRatingSummaryRepository
 */
trait IRatingSummaryRepository {
  
  def getRatingSummaryFor(question: Question): Option[RatingSummary]

  def getRatingSummaryFor(questionId: String): Option[RatingSummary]
}
