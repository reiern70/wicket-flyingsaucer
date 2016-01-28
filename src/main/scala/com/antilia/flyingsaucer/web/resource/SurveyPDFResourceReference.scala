package com.antilia.flyingsaucer.web.resource

import java.util.Date

import com.antilia.domain.entities.SurveyReport
import com.antilia.flyingsaucer.web.report.QuestionReportPage
import com.antilia.flyingsaucer.web.util.PageUtils
import org.apache.commons.lang3.time.DateUtils
import org.apache.wicket.request.IRequestParameters

/**
 */
class SurveyPDFResourceReference extends PDFResourceReference(classOf[SurveyPDFResourceReference], "SurveyPDFResourceReference")
{
  override def generatePDF(params: IRequestParameters): Array[Byte] = {
    PageUtils.pageToPdf( new QuestionReportPage( ) )
  }
}
