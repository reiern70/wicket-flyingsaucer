package com.antilia.flyingsaucer.web.resource

import java.io.ByteArrayOutputStream

import org.apache.wicket.injection.Injector
import org.apache.wicket.request.cycle.RequestCycle
import org.apache.wicket.request.resource.{ByteArrayResource, IResource, ResourceReference}
import org.apache.wicket.request.{IRequestParameters, Request}

abstract class PNGResourceReference(scope: Class[_], name: String) extends ResourceReference(scope, name) {
  
  Injector.get.inject(this)


  final def getResource: IResource = {
    val webResponse: ByteArrayOutputStream = new ByteArrayOutputStream
    val request: Request = RequestCycle.get.getRequest
    val params: IRequestParameters = request.getRequestParameters
    webResponse.write(generateImage(params))
    new ByteArrayResource( "image/png", webResponse.toByteArray)
  }

  def generateImage(params: IRequestParameters): Array[Byte]

}
