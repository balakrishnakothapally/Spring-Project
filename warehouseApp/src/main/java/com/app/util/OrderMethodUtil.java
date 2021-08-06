package com.app.util;

import java.io.File;
import java.util.List;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartUtils;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.data.general.DefaultPieDataset;
import org.springframework.stereotype.Component;

@Component
public class OrderMethodUtil {

	public void generatePie(String path,List<Object[]>data) {

		DefaultPieDataset dataset=new DefaultPieDataset();
		for(Object[] ob:data) {
			dataset.setValue(ob[0].toString(), new Double(ob[1].toString()));
		}
		JFreeChart chart=ChartFactory.createPieChart3D("Order Method type mode", dataset,true,true,false);
		try {
			ChartUtils.saveChartAsJPEG(new File(path+"/resources/images/ordersA.jpg"), chart, 400,400);

		} catch (Exception e) {

			e.printStackTrace();
		}

	}
	public void generateBar(String path,List<Object[]>data) {
		DefaultCategoryDataset dataset=new DefaultCategoryDataset();
		for(Object[] ob:data) {
			dataset.setValue(new Double(ob[1].toString()),ob[0].toString(), "");
			JFreeChart chart=ChartFactory.createBarChart("order type report", "Mode","Count", dataset,PlotOrientation.VERTICAL,true,true,false);
			try {
				ChartUtils.saveChartAsJPEG(new File(path+"/resources/images/ordersB.jpg"),chart,400, 400);

			} catch (Exception e) {
				e.printStackTrace();

			}
		}
	}
}
