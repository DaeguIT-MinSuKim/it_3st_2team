package kr.or.dgit.it_3st_2team.ui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

/*import org.jfree.chart.ChartFrame;
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
import org.jfree.ui.TextAnchor;*/

import kr.or.dgit.it_3st_2team.dto.Enroll;
import kr.or.dgit.it_3st_2team.service.EnrollService;

public class PolylineBarChart extends JFrame {

	private JPanel contentPane;
	private EnrollService enrollService;

	/**
	 * Launch the application.
	 */
/*	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PolylineBarChart frame = new PolylineBarChart();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}*/

	/**
	 * Create the frame.
	 */
	public PolylineBarChart() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		/*JFreeChart chart = this.getChart();
		ChartFrame frame1 = new ChartFrame("차트 현황", chart);
		frame1.setSize(800, 400);
		frame1.setVisible(true);
		
		enrollService = new EnrollService();
		List<String> list = enrollService.selectChart();
		for(String str:list) {
			System.out.println(str);
		}*/
	}
	
	/*public JFreeChart getChart() {
		DefaultCategoryDataset dataset1 = new DefaultCategoryDataset();
		DefaultCategoryDataset dataset2 = new DefaultCategoryDataset();
		DefaultCategoryDataset dataset3 = new DefaultCategoryDataset();
		
		
		
		//그래프1
		dataset1.addValue(1.0, "S1", "1월");
		dataset1.addValue(4.0, "S1", "2월");
		dataset1.addValue(3.0, "S1", "3월");
		dataset1.addValue(5.0, "S1", "4월");
		dataset1.addValue(5.0, "S1", "5월");
		dataset1.addValue(7.0, "S1", "6월");
		dataset1.addValue(7.0, "S1", "7월");
		dataset1.addValue(8.0, "S1", "8월");
		dataset1.addValue(0, "S1", "9월");
		dataset1.addValue(0, "S1", "10월");
		dataset1.addValue(0, "S1", "11월");
		dataset1.addValue(0, "S1", "12월");
		
		//그래프2
		dataset2.addValue(0, "S2", "1월");
		
		//그래프3
		dataset3.addValue(9.0, "T1", "1월");
		
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
	}*/

}
