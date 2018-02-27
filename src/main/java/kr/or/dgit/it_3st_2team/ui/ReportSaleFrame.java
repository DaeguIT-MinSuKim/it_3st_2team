package kr.or.dgit.it_3st_2team.ui;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.ButtonGroup;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.border.TitledBorder;

import kr.or.dgit.it_3st_2team.dto.Sale;
import kr.or.dgit.it_3st_2team.service.SaleService;
import kr.or.dgit.it_3st_2team.t.TableSaleRe;

/*yyj*/
public class ReportSaleFrame extends JFrame implements ActionListener {

	private JPanel contentPane;
	private TableSaleRe tbs;
	private JPanel pCenter;
	private SaleService sservice;
	private JRadioButton rdbMonth;
	private JRadioButton rdbYear;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ReportSaleFrame frame = new ReportSaleFrame();
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
	public ReportSaleFrame() {
		sservice = new SaleService();
		tbs= new TableSaleRe();
		initComponents();
	}
	private void initComponents() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 779, 503);
		contentPane = new JPanel();
		contentPane.setBorder(new TitledBorder(null, "\uC601\uC5C5 \uBCF4\uACE0\uC11C", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JPanel panel = new JPanel();
		contentPane.add(panel, BorderLayout.NORTH);
		panel.setLayout(new BorderLayout(0, 0));
		
		JPanel panel_1 = new JPanel();
		panel.add(panel_1, BorderLayout.NORTH);
		panel_1.setLayout(new BorderLayout(0, 0));
		
		JPanel panel_2 = new JPanel();
		panel_1.add(panel_2, BorderLayout.NORTH);
		
		JLabel lblNewLabel = new JLabel("영업 현황 보고서");
		lblNewLabel.setFont(new Font("굴림", Font.PLAIN, 21));
		panel_2.add(lblNewLabel);
		
		JPanel panel_3 = new JPanel();
		panel_1.add(panel_3, BorderLayout.WEST);
		panel_3.setLayout(new BorderLayout(0, 0));
		
		JPanel panel_4 = new JPanel();
		panel_3.add(panel_4);
		
		JLabel lblNewLabel_1 = new JLabel("보고서 선택");
		panel_4.add(lblNewLabel_1);
		
		JPanel panel_5 = new JPanel();
		panel_3.add(panel_5, BorderLayout.SOUTH);
		
		
		ButtonGroup btng = new ButtonGroup();
		rdbMonth = new JRadioButton("월별");
		rdbMonth.addActionListener(this);
		panel_5.add(rdbMonth);
		
		rdbYear = new JRadioButton("연도별");
		rdbYear.addActionListener(this);
		panel_5.add(rdbYear);
		
		btng.add(rdbMonth);
		btng.add(rdbYear);
		
		
		pCenter = new JPanel();
		contentPane.add(pCenter, BorderLayout.CENTER);
		pCenter.setLayout(new BorderLayout(0, 0));
		
		rdbYear.setVisible(false);
		showTables();
	}

	private void showTables() {
		List<Sale> saletable= sservice.selectReportMonth();
		tbs.loadDatas(saletable);
		tbs.getRows(saletable);
		pCenter.setLayout(new BorderLayout(0, 0));	
		pCenter.add(tbs);
		
	}

	public void actionPerformed(ActionEvent arg0) {
		if (arg0.getSource() == rdbYear) {
			actionPerformedRdbYear(arg0);
		}
		if (arg0.getSource() == rdbMonth) {
			actionPerformedRdbMonth(arg0);
		}
	}
	protected void actionPerformedRdbMonth(ActionEvent arg0) {
//		pCenter.setVisible(true);
//		showTables();
		
	}
	protected void actionPerformedRdbYear(ActionEvent arg0) {
		/*pCenter.setVisible(false);*/
	}
}
