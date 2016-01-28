package com.antilia.flyingsaucer.web.resource

import java.awt.Color
import java.io.ByteArrayOutputStream
import java.util
import java.util.Date

import org.apache.commons.lang3.time.DateUtils
import org.apache.wicket.request.IRequestParameters
import org.jfree.chart.axis.NumberAxis
import org.jfree.chart.renderer.xy.XYLineAndShapeRenderer
import org.jfree.chart.{ChartFactory, ChartUtilities, JFreeChart}
import org.jfree.data.xy.{XYDataset, XYSeries, XYSeriesCollection}

import scala.util.Random

/**
 * LineChartResourceReference
 */
class LineChartResourceReference extends PNGResourceReference(classOf[LineChartResourceReference], "LineChartResourceReference") {

  val random = new Random()
  override def generateImage(params: IRequestParameters): Array[Byte] = {
    val dataset = createDataset
    val chart = createChart(dataset)
    val out = new ByteArrayOutputStream()
    ChartUtilities.writeChartAsPNG(out, chart, 300, 130)
    out.close()
    out.toByteArray
  }


  private def createChart(dataset: XYDataset): JFreeChart = {
    // create the chart...
    val chart = ChartFactory.createTimeSeriesChart(
      null,      // chart title
      null,                      // x axis label
      null,                      // y axis label
      dataset)

    // NOW DO SOME OPTIONAL CUSTOMISATION OF THE CHART...
    chart.setBackgroundPaint(Color.white)

    //        final StandardLegend legend = (StandardLegend) chart.getLegend();
    //      legend.setDisplaySeriesShapes(true);

    // get a reference to the plot for further customisation...
    val  plot = chart.getXYPlot()
    plot.setBackgroundPaint(Color.white)
    plot.setDomainGridlinesVisible(false)
    plot.getRangeAxis.setRange(1,5)
    plot.getRangeAxis.setAutoRange(false)
    plot.setRangeGridlinePaint(Color.gray)
    chart.setSubtitles(new util.ArrayList[Nothing]())
    plot.setOutlineVisible(false)

    val renderer = new XYLineAndShapeRenderer()
    // show lines
    renderer.setSeriesLinesVisible(0, true)
    renderer.setSeriesLinesVisible(1, true)
    // hide shapes
    renderer.setSeriesShapesVisible(0, false)
    renderer.setSeriesShapesVisible(1, false)
    renderer.setUseFillPaint(true)

    renderer.setSeriesFillPaint(0, Color.GRAY)

    plot.setRenderer(renderer)

    // change the auto tick unit selection to integer units only...
    val rangeAxis =  plot.getRangeAxis().asInstanceOf[NumberAxis]
    rangeAxis.setStandardTickUnits(NumberAxis.createIntegerTickUnits())
    // OPTIONAL CUSTOMISATION COMPLETED.

    return chart

  }

  private def createDataset: XYDataset ={
    val series1 = new XYSeries("First")
    val now = new Date()
    for( i <- 0 to 24) {
      series1.add(DateUtils.addDays(now, -i*15).getTime, 3+random.nextDouble()*2)
    }

    val series2 = new XYSeries("Second")
    for( i <- 0 to 24) {
      series2.add(DateUtils.addDays(now, -i*15).getTime, 3+random.nextDouble()*2)
    }


    val dataset = new XYSeriesCollection()
    dataset.addSeries(series1)
    dataset.addSeries(series2)

    dataset
  }
}
