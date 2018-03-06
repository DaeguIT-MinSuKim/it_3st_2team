package kr.or.dgit.it_3st_2team.ui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Hair extends JFrame implements ActionListener {

	private JPanel contentPane;
	private JMenu mnEmp;
	private JMenuItem itemEvent;
	private JMenuItem itemHair_1;
	private JMenuItem itemTitle;
	private JMenuItem itemRe;
	private JMenuItem itemHair;
	private JMenuItem itemCus;
	private JMenuItem itemChart;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Hair frame = new Hair();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Hair() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 978, 583);
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JMenu mnCus = new JMenu("고객관리");
		menuBar.add(mnCus);
		
		itemCus = new JMenuItem("고객관리");
		itemCus.addActionListener(this);
		mnCus.add(itemCus);
		
		mnEmp = new JMenu("직원");
		mnEmp.addActionListener(this);
		menuBar.add(mnEmp);
		
		itemHair = new JMenuItem("헤어주문");
		itemHair.addActionListener(this);
		mnEmp.add(itemHair);
		
		JMenu mnHair = new JMenu("미용실운영");
		menuBar.add(mnHair);
		
		itemEvent = new JMenuItem("이벤트등록");
		itemEvent.addActionListener(this);
		mnHair.add(itemEvent);
		
		itemHair_1 = new JMenuItem("헤어등록");
		itemHair_1.addActionListener(this);
		mnHair.add(itemHair_1);
		
		itemTitle = new JMenuItem("직책등록");
		itemTitle.addActionListener(this);
		mnHair.add(itemTitle);
		
		itemRe = new JMenuItem("운영보고서");
		itemRe.addActionListener(this);
		mnHair.add(itemRe);
		
		JMenuItem itemEmp = new JMenuItem("직원현황");
		mnHair.add(itemEmp);
		
		itemChart = new JMenuItem("트랜드/차트");
		itemChart.addActionListener(this);
		mnHair.add(itemChart);
		
		
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		
	//	JPanel cpanel = new CustomerJPanel();
	//	contentPane.add(cpanel);
	//	validate();
		setContentPane(contentPane);
	}

	public void actionPerformed(ActionEvent arg0) {
		if (arg0.getSource() == itemChart) { //차트
			actionPerformedItemChart(arg0);
		}
		if (arg0.getSource() == itemCus) {
			actionPerformedItemCus_1(arg0);
		}
		if (arg0.getSource() == itemHair) { //헤어주문
			actionPerformedItemHair(arg0);
		}
		if (arg0.getSource() == itemRe) {
			actionPerformedItemRe(arg0);
		}
		if (arg0.getSource() == itemTitle) {
			actionPerformedItemTitle(arg0);
		}
		if (arg0.getSource() == itemHair_1) {
			actionPerformedItemHair_1(arg0);
		}
		if (arg0.getSource() == itemEvent) {
			actionPerformedItemEvent(arg0);
		}
	}
	protected void actionPerformedItemEvent(ActionEvent arg0) {
		JFrame jf = new EventManage();
		jf.setVisible(true);
	}
	protected void actionPerformedItemHair_1(ActionEvent arg0) {
		JFrame jf = new HairManage();
		jf.setVisible(true);
	}
	protected void actionPerformedItemTitle(ActionEvent arg0) {
		JFrame jf = new TitleManage();
		jf.setVisible(true);
	}
	protected void actionPerformedItemRe(ActionEvent arg0) {
		JFrame jf = new ReportSaleFrame();
		jf.setVisible(true);
	}
	protected void actionPerformedItemHair(ActionEvent arg0) { //헤어주문
		/*JFrame jf = new EnrollFrame();		
		jf.setVisible(true);*/
		JPanel enrollPanel = new EnrollPanel();
		setContentPane(enrollPanel);
		validate();
	}
	protected void actionPerformedItemCus_1(ActionEvent arg0) {
		JPanel cpanel = new CustomerJPanel();
		setContentPane(cpanel);
		validate();
	}
	protected void actionPerformedItemChart(ActionEvent arg0) { //차트
		PolylineBarChart cf = new PolylineBarChart();
		setContentPane(cf);
		validate();
	}
}
