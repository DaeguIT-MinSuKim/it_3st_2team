package kr.or.dgit.it_3st_2team.ui;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.border.EmptyBorder;

import kr.or.dgit.it_3st_2team.service.SaleService;


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
	private JMenu mnAdmin;
	private JMenuItem itemAdimin;
	private JMenuItem itemEmp;
	private JMenuItem itemLogout;
	public JPanel01 jpanel01 = null; //직원별 매출그래프
	public JPanel02 jpanel02 = null; //월별 매출그래프
	private JTabbedPane jTab;

	/**
	 * Launch the application.
	 */
/*	public static void main(String[] args) {
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
	}*/ //khj 로그인 성공해야 뜨도록
	
	/**
	 * Create the frame.
	 */
	public Hair(String titleName) {
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1000, 800);
		
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
		
		itemLogout = new JMenuItem("로그아웃");
		itemLogout.addActionListener(this);
		mnEmp.add(itemLogout);
		
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
		
		itemEmp = new JMenuItem("직원현황");
		itemEmp.addActionListener(this);
		mnHair.add(itemEmp);
		
		itemChart = new JMenuItem("트랜드/차트");
		itemChart.addActionListener(this);
		mnHair.add(itemChart);
		
		mnAdmin = new JMenu("Admin");
		menuBar.add(mnAdmin);
		
		itemAdimin = new JMenuItem("DB초기화");
		itemAdimin.addActionListener(this);
		mnAdmin.add(itemAdimin);
		
		
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		
		JPanel cpanel = new CustomerJPanel();
		contentPane.add(cpanel);
		validate();
		setContentPane(contentPane);
		
		/*yyj 03-07 수정  setEnabled -> setVisible*/
		if(titleName.equals("admin")) {
			mnHair.setEnabled(true);
		}else if(!titleName.equals("사장")) { //khj 직급별 기능제한
			mnHair.setVisible(false);
			mnAdmin.setVisible(false);
		}else if(titleName.equals("사장")) { //khj 직급별 기능제한
			mnAdmin.setVisible(false);
		}
		
	}

	public void actionPerformed(ActionEvent arg0) {
		if (arg0.getSource() == itemLogout) {
			actionPerformedItemLogout(arg0);
		}
		if (arg0.getSource() == itemEmp) {
			actionPerformedItemEmp(arg0);
		}
		if (arg0.getSource() == itemAdimin) {
			actionPerformedItemAdimin(arg0);
		}
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
		JPanel jp = new EventManage();
		setContentPane(jp);
		validate();
	}
	protected void actionPerformedItemHair_1(ActionEvent arg0) {
		JPanel jp = new HairManage();
		setContentPane(jp);
		validate();
	}
	protected void actionPerformedItemTitle(ActionEvent arg0) {
		JPanel jp = new TitleManage();
		setContentPane(jp);
		validate();
	}
	protected void actionPerformedItemRe(ActionEvent arg0) {
		JPanel jp = new ReportSaleJPanel();
		setContentPane(jp);
		validate();
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
		/*PolylineBarChart cf = new PolylineBarChart();
		setContentPane(cf);
		validate();*/
		this.jpanel01 = new JPanel01();
		this.jpanel02 = new JPanel02();
		
		jTab = new JTabbedPane();
		PolylineBarChart cf = new PolylineBarChart();
		EmpChart ec = new EmpChart();
		jTab.addTab("헤어서비스별", cf);
		jTab.addTab("직원별", ec);
		jTab.addTab("기간별", this.jpanel02);
		
		setContentPane(jTab);
		validate();
	}
	protected void actionPerformedItemAdimin(ActionEvent arg0) {
		SettingMain se = new SettingMain();
		se.setVisible(true);
	}
	protected void actionPerformedItemEmp(ActionEvent arg0) {
		JPanel NowEmployee = new NowEmployee();
		setContentPane(NowEmployee);
		validate();
	}
	protected void actionPerformedItemLogout(ActionEvent arg0) { //로그아웃
		LoginFrame lf = new LoginFrame();
		lf.setVisible(true);
		this.dispose();
	}
	
	class JPanel01 extends JPanel{ //직원별 
		public JPanel01() {
			super();
			// TODO Auto-generated constructor stub
			setLayout(null);
		}		
	}

	class JPanel02 extends JPanel implements ActionListener{ //기간별
		private JComboBox cmbYear;
		private JComboBox cmbMonth;
		private SaleService service;
		private JPanel panel_1;
		private JPanel panel_2;
		
		public JPanel02() {
			setLayout(new BorderLayout());
			JPanel panel = new JPanel();
			add(panel, BorderLayout.NORTH);
			panel.setLayout(new BorderLayout(0, 0));
			
			panel_1 = new JPanel();
			panel.add(panel_1, BorderLayout.WEST);
			panel_1.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
			
			//년도
			cmbYear = new JComboBox();
			service = new SaleService();
			List<String> yearList = service.selectYear();
			String[] yearArr = new String[yearList.size()+1];
			yearArr[0]="----년";
			int i=1;
			for(String str:yearList) {
				yearArr[i++]=str;
			}
			cmbYear.setModel(new DefaultComboBoxModel(yearArr));
			panel_1.add(cmbYear);
			cmbYear.addActionListener(this);
			
			panel_2 = new JPanel();
			panel.add(panel_2, BorderLayout.SOUTH);
			panel_2.setLayout(new FlowLayout(FlowLayout.LEFT, 5, 5));
		}
		
		public void actionPerformed(ActionEvent e) {
			if(e.getSource()==cmbYear) {
				String selectYear = cmbYear.getSelectedItem().toString()+"%";
				Map<String,String> map = new HashMap<>();	
				map.put("date",selectYear);
				List<String> monthList = service.selectMonth(map);
				String[] monthArr = monthList.toArray(new String[monthList.size()]);
				MonthlyLineGraph ml = new MonthlyLineGraph(selectYear,monthArr);
				panel_2.add(ml);
				panel_2.validate();
			}
		}
	}

}
