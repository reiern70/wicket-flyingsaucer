package com.antilia.flyingsaucer.web.util

import java.io.{ByteArrayOutputStream, OutputStream}

import org.apache.wicket.Page
import org.apache.wicket.protocol.http.BufferedWebResponse
import org.apache.wicket.request.Response
import org.xhtmlrenderer.pdf.ITextRenderer

/**
 * PagUtils.
 */
object PageUtils {

  def toHtml(page: Page): String = {
    val bufferedWebResponse: BufferedWebResponse = new BufferedWebResponse(null)
    val response: Response = page.getRequestCycle.getResponse
    page.getRequestCycle.setResponse(bufferedWebResponse)
    page.render()
    page.getRequestCycle.setResponse(response)
    var html = bufferedWebResponse.getText.toString
    if(html.indexOf("<!DOCTYPE html>") >= 0) {
      html = html.replace("<!DOCTYPE html>", "<!DOCTYPE html [<!ENTITY nbsp \"&#160;\">]>")
    }
    html
  }

  def pageToPdf(page: Page, os: OutputStream): Unit = {
    val renderer = new ITextRenderer()
    val html = toHtml(page)
    //println(html)
    renderer.setDocumentFromString(html, "http://localhost:8080/page.html")
    renderer.layout()
    renderer.createPDF(os)
    os.close()
  }

  def pageToPdf(page: Page): Array[Byte] = {
    val out = new ByteArrayOutputStream
    pageToPdf(page, out)
    out.toByteArray
  }
}
