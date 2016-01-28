package com.antilia.flyingsaucer.web.spring

import com.antilia.flyingsaucer.domain.spring.SpringBootstrap
import com.antilia.flyingsaucer.web.FlyingSaucerApplication
import org.apache.wicket.protocol.http.WebApplication
import org.springframework.context.annotation.{Bean, ComponentScan, Configuration, Import}

/**
 * Wicket spring configuration!
 */
@ComponentScan(Array("com.antilia.flyingsaucer"))
@Configuration
@Import(Array(classOf[SpringBootstrap]))
class WicketSpringBootstrap {
  /**
   * webApplication
   * @return WebApplication
   */
  @Bean
  def webApplication: WebApplication = {
    new FlyingSaucerApplication
  }
}
