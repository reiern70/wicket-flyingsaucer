package com.antilia.flyingsaucer.domain.service.mock

import java.util

import com.antilia.domain.entities.{RatingLine, RatingSummary, Question}
import com.antilia.flyingsaucer.domain.service.IRatingSummaryRepository

import scala.util.Random

object  MockRatingSummaryRepository {
  val instance = new MockRatingSummaryRepository
  
}
/**
 * MockRatingSummaryRepository
 */
class MockRatingSummaryRepository extends IRatingSummaryRepository {
  val random = new Random()
  
  val values = new util.HashMap[String, RatingSummary]()
  
  override def getRatingSummaryFor(question: Question): Option[RatingSummary] = {
    getRatingSummaryFor(question.getId)
  }

  override def getRatingSummaryFor(questionId: String): Option[RatingSummary] = {
    var sumary = values.get(questionId)
    if(sumary != null) {
      return Some(sumary)      
    }
    sumary = new RatingSummary()
    sumary.setQuestionId(questionId)
    sumary.setMaxRating(5)
    sumary.setAverageRating(random.nextDouble()*5)
    sumary.setRatingIncrease(getRandomSign*random.nextDouble()*1)
    sumary.setPreviousAverageRating(random.nextDouble()*5)

    var total = 0
    for(i <- 1 to 5) {
      val ratingLine = new RatingLine
      ratingLine.setValue(i)
      ratingLine.setQuestionId(questionId)
      val responses = random.nextInt(1000)
      ratingLine.setResponses(responses)
      total = total + responses
      ratingLine.setChange(getRandomSign*random.nextInt(200))
      sumary.addLine(ratingLine)
    }

    sumary.setTotalResponses(total)
    sumary.setTotalResponsesDelta(getRandomSign*random.nextInt(200))
    sumary.setPreviousTotalResponses(total + getRandomSign*random.nextInt(200))
    sumary.setPreviousTotalResponsesDelta(getRandomSign*random.nextInt(200))

    values.put(questionId, sumary)
    Some(sumary)
  }

  def getRandomSign: Int = {
    if(random.nextBoolean()) 1 else -1
  }
}
