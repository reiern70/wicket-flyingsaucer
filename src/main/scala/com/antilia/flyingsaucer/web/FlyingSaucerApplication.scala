package com.antilia.flyingsaucer.web

import com.antilia.flyingsaucer.web.report.QuestionReportPage
import com.antilia.flyingsaucer.web.resource.{LineChartResourceReference, SurveyPDFResourceReference}
import org.apache.wicket.Page
import org.apache.wicket.injection.Injector
import org.apache.wicket.protocol.http.WebApplication
import org.apache.wicket.spring.injection.annot.SpringComponentInjector
import org.springframework.context.ApplicationContext
import org.springframework.web.context.support.WebApplicationContextUtils

/**
 * extends WebApplication
 */
class FlyingSaucerApplication extends WebApplication {
  
  override def getHomePage: Class[_ <: Page] = classOf[QuestionReportPage]

  override def init(): Unit = {
    super.init()

    getMarkupSettings.setStripWicketTags(true)
    val springContext: ApplicationContext = getSpringContext
    getComponentInstantiationListeners.add(new SpringComponentInjector(this, springContext))
    Injector.get.inject(this)

    mountResource("/report", new SurveyPDFResourceReference)
    mountResource("/chart", new LineChartResourceReference)

  }


  final def getSpringContext: ApplicationContext = {
    WebApplicationContextUtils.getRequiredWebApplicationContext(getServletContext)
  }
  
}
