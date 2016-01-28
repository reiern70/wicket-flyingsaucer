package com.antilia.flyingsaucer.domain.spring

import java.util
import java.util.Properties

import com.antilia.domain.service.mock.{MockQuestionRepository, MockSurveyRepository}
import com.antilia.flyingsaucer.domain.service.mock.MockRatingSummaryRepository
import com.antilia.flyingsaucer.domain.service.{IRatingSummaryRepository, IQuestionRepository, ISurveyRepository}
import org.springframework.beans.factory.FactoryBean
import org.springframework.context.annotation.{Bean, Configuration, Primary}
import org.springframework.jndi.JndiObjectFactoryBean

/**
 * Bootstrap spring.
 */
@Configuration
class SpringBootstrap {

  @Bean def getQuestionRepository: IQuestionRepository = MockQuestionRepository.instance
  
  @Bean def getSurveyRepository: ISurveyRepository = MockSurveyRepository.instance
  
  @Bean def getRatingSummaryRepository: IRatingSummaryRepository = MockRatingSummaryRepository.instance

}
