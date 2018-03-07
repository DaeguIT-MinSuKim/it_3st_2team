package kr.or.dgit.it_3st_2team.ui;

import java.awt.Font;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JPanel;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.axis.CategoryAxis;
import org.jfree.chart.axis.CategoryLabelPositions;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.renderer.category.BarRenderer;
import org.jfree.chart.renderer.category.CategoryItemRenderer;
import org.jfree.data.category.CategoryDataset;
import org.jfree.data.category.DefaultCategoryDataset;

import kr.or.dgit.it_3st_2team.dto.Employee;
import kr.or.dgit.it_3st_2team.service.EmployeeService;

public class EmpChart extends JPanel {
	private EmployeeService eservice;
	
	public EmpChart() {
		
		eservice = new EmployeeService();
		final CategoryDataset dataset = createDataset();
		
		final JFreeChart chart = createChart(dataset);
		CategoryPlot plot = chart.getCategoryPlot();
		plot.getDomainAxis().setLabelFont(new Font("굴림",Font.BOLD,15));
		final ChartPanel chartPanel = new ChartPanel(chart);
		chartPanel.setPreferredSize(new java.awt.Dimension(900, 700));
	//	setContentPane(chartPanel);
		add(chartPanel);
	}

	private CategoryDataset createDataset() {

		List<Employee> list = new ArrayList<>();
		list = eservice.selectEmpEmpPerformance();
		
		Employee ee = new Employee();
		final DefaultCategoryDataset dataset = new DefaultCategoryDataset();
		for(Employee e : list) {
			ee.setEmpNo(e.getEmpNo());
			int p = eservice.SelectEmpPrice(ee);
			String name = e.getEmpName();
			dataset.addValue(p, name, "");
		}
		return dataset;

	}

	private JFreeChart createChart(final CategoryDataset dataset) {

		final JFreeChart chart = ChartFactory.createBarChart3D("직원별 성과", 																				
				"직원이름", // domain axis label
				"", // range axis label
				dataset, // data
				PlotOrientation.VERTICAL, // orientation
				true, // include legend
				true, // tooltips
				false // urls
		);
		chart.getTitle().setFont(new Font("굴림", Font.BOLD,30));
		chart.getLegend().setItemFont(new Font("굴림", Font.BOLD,15));
		final CategoryPlot plot = chart.getCategoryPlot();
		final CategoryAxis axis = plot.getDomainAxis();
		axis.setCategoryLabelPositions(CategoryLabelPositions.createUpRotationLabelPositions(Math.PI / 8.0));

		final CategoryItemRenderer renderer = plot.getRenderer();
	//	renderer.setItemLabelsVisible(true);
		
	//	final BarRenderer r = (BarRenderer) renderer;
	//	 r.setMaxBarWidth(0.05);

		return chart;
	}

	public static void main(final String[] args) {

		final EmpChart demo = new EmpChart();
		demo.setVisible(true);

	}
}