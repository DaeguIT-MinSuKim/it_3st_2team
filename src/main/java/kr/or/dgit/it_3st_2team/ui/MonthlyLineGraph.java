package kr.or.dgit.it_3st_2team.ui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.swing.JPanel;

import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.axis.CategoryAxis;
import org.jfree.chart.axis.CategoryLabelPositions;
import org.jfree.chart.axis.NumberAxis;
import org.jfree.chart.labels.CategoryItemLabelGenerator;
import org.jfree.chart.labels.ItemLabelAnchor;
import org.jfree.chart.labels.ItemLabelPosition;
import org.jfree.chart.labels.StandardCategoryItemLabelGenerator;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.DatasetRenderingOrder;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.renderer.category.BarRenderer;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.ui.TextAnchor;

import kr.or.dgit.it_3st_2team.dto.Enroll;
import kr.or.dgit.it_3st_2team.dto.Hair;
import kr.or.dgit.it_3st_2team.service.SaleService;
import javax.swing.JComboBox;
import java.awt.FlowLayout;
import javax.swing.DefaultComboBoxModel;

public class MonthlyLineGraph extends JPanel {

	private SaleService saleService;
	private String syear;
	private String[] smonth=null;
	/**
	 * Create the panel.
	 */
	public MonthlyLineGraph(String year, String[] month) {
		syear = year;
		smonth = month;
		this.validate();
		initComponents();
	}
	private void initComponents() {
		saleService = new SaleService();
		
		setLayout(new BorderLayout());
		
		if(!syear.equals("")) {
			JFreeChart chart = this.getChart();
			
			ChartPanel cp = new ChartPanel(chart);
			add(cp);

		}		
	}
	
	public JFreeChart getChart() {
		DefaultCategoryDataset dataset1 = new DefaultCategoryDataset();
		
		
		//그래프1
		Map<String,String> map = new HashMap<>();
		map.put("date", syear);
		List<Integer> priceList = saleService.selectMonthlyChart(map);
		int cnt=0;
		for(Integer i:priceList) {
			System.out.println("월"+smonth[cnt]+"값"+i);
			dataset1.addValue(i, "월", smonth[cnt++]);
		}	
		
		//랜더링 생성
		final BarRenderer renderer = new BarRenderer();
		
		//공통옵션 정의
		final CategoryItemLabelGenerator generator = new StandardCategoryItemLabelGenerator();
		final ItemLabelPosition pCenter = new ItemLabelPosition(ItemLabelAnchor.CENTER, TextAnchor.CENTER);
		final ItemLabelPosition pBelow = new ItemLabelPosition(ItemLabelAnchor.OUTSIDE6,TextAnchor.TOP_LEFT);
		Font f = new Font("Gulim", Font.BOLD, 14);
		Font axisF = new Font("Gulim", Font.PLAIN, 14);
		
		//그래프1
		renderer.setBaseItemLabelGenerator(generator);
		renderer.setBaseItemLabelsVisible(true);
		renderer.setBasePositiveItemLabelPosition(pCenter);
		renderer.setBaseItemLabelFont(f);
		renderer.setSeriesPaint(0, new Color(0, 162, 255));
		
		//그래프2
		//그래프3
		
		//plot 생성
		final CategoryPlot plot = new CategoryPlot();
		plot.setDataset(dataset1);
		plot.setRenderer(renderer);
		
		//plot 기본설정
		plot.setOrientation(PlotOrientation.VERTICAL);
		plot.setRangeGridlinesVisible(true);
		plot.setDomainGridlinesVisible(true);
		
		plot.setDatasetRenderingOrder(DatasetRenderingOrder.FORWARD);
		
		//x축 세팅
		plot.setDomainAxis(new CategoryAxis());
		plot.getDomainAxis().setTickLabelFont(axisF);
		plot.getDomainAxis().setCategoryLabelPositions(CategoryLabelPositions.STANDARD);
		
		plot.setRangeAxis(new NumberAxis());
		plot.getRangeAxis().setTickLabelFont(axisF);
		
		final JFreeChart chart = new JFreeChart(plot);
		return chart;
	}
}
