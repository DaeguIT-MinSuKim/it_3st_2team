package kr.or.dgit.it_3st_2team.ui;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.border.TitledBorder;

import kr.or.dgit.it_3st_2team.dto.Sale;
import kr.or.dgit.it_3st_2team.service.SaleService;
import kr.or.dgit.it_3st_2team.t.TableSaleReAll;
import kr.or.dgit.it_3st_2team.t.TableSaleReMonth;
import kr.or.dgit.it_3st_2team.t.TableSaleReYear;
import java.awt.event.ActionEvent;

/*yyj*/
public class ReportSaleFrame extends JFrame implements ActionListener {

	private JPanel contentPane;
	private TableSaleReYear tbs;
	private TableSaleReMonth tbmonth;
	private TableSaleReAll tball;
	private JPanel pCenter;
	private SaleService sservice;
	private JRadioButton rdbMonth;
	private JRadioButton rdbYear;
	private JTextField tfDate;
	private JButton btnSearch;
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
		tbs= new TableSaleReYear(this);
		tbmonth = new TableSaleReMonth(this);
		tball = new TableSaleReAll(this);
		initComponents();
	}


	public JTextField getTfDate() {
		return tfDate;
	}

	public void setTfDate(JTextField tfDate) {
		this.tfDate = tfDate;
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
		lblNewLabel.setFont(new Font("굴림", Font.BOLD, 21));
		panel_2.add(lblNewLabel);
		
		JPanel panel_3 = new JPanel();
		panel_1.add(panel_3, BorderLayout.WEST);
		panel_3.setLayout(new BorderLayout(0, 0));
		
		JPanel panel_4 = new JPanel();
		panel_3.add(panel_4, BorderLayout.NORTH);
		
		JLabel lblNewLabel_1 = new JLabel("보고서 선택");
		panel_4.add(lblNewLabel_1);
		
		JPanel panel_5 = new JPanel();
		panel_3.add(panel_5, BorderLayout.CENTER);
		
		
		ButtonGroup btng = new ButtonGroup();
		rdbMonth = new JRadioButton("월별");
		
		rdbYear = new JRadioButton("연도별");
	
		
		
		panel_5.add(rdbYear);
		btng.add(rdbYear);
		panel_5.add(rdbMonth);
		
		btng.add(rdbMonth);
		
		JPanel panel_6 = new JPanel();
		panel_3.add(panel_6, BorderLayout.SOUTH);
		
		tfDate = new JTextField();
		panel_6.add(tfDate);
		tfDate.setColumns(10);
		
		btnSearch = new JButton("검색");
		btnSearch.addActionListener(this);
		panel_6.add(btnSearch);
		
		
		pCenter = new JPanel();
		contentPane.add(pCenter, BorderLayout.CENTER);
		pCenter.setLayout(new BorderLayout(0, 0));
		
			
		List<Sale> saletable= sservice.selectReportAll();
		tball.loadDatas(saletable);
		tball.getRows(saletable);
		pCenter.setLayout(new BorderLayout(0, 0));	
		pCenter.add(tball);
	}

	private void showTablesYear(Map<String,Object> map) {
		
		List<Sale> saletable= sservice.selectReportYear(map);
		tbs.loadDatas(saletable);
		tbs.getRows(saletable);
		pCenter.setLayout(new BorderLayout(0, 0));	
		pCenter.add(tbs);
		tbmonth.setVisible(false);
		tball.setVisible(false);
		tbs.setVisible(true);
		
	}
	
	public void actionPerformed(ActionEvent arg0) {
		if (arg0.getSource() == btnSearch) {
			actionPerformedBtnSearch(arg0);
		}
	}
	protected void actionPerformedBtnSearch(ActionEvent arg0) {
		Boolean m = rdbMonth.isSelected();
		Boolean y = rdbYear.isSelected();
		String getdate = tfDate.getText();
		
		if(m) {
			
			Map<String,Object> map = new HashMap<>();			
			map.put("sDate","%-"+getdate+"-%");
			gettableMonth(map);
			tfDate.setText("");
			return;
			
		}else if(y) {			
			List<String> list = sservice.selectYearExist();	
			String existYear=null;
			boolean tf = false;
			for(int i =0;i<list.size();i++) {
				existYear=list.get(i);
				existYear= existYear.substring(0,4);
				if(getdate.equals(existYear)) {
					tf=true;
				}
			}
				if(tf) {			
					Map<String,Object> map = new HashMap<>();			
					map.put("sDate",getdate+"%");
					showTablesYear(map);
					tfDate.setText("");
					return;
				}else {
					JOptionPane.showMessageDialog(null, getdate+"년의 데이터가 존재하지 않습니다.");
					tfDate.setText("");
					return;				
			}
		}
	}

	private void gettableMonth(Map<String, Object> map) {
		List<Sale> saletable= sservice.selectReportYear(map);
		tbmonth.loadDatas(saletable);
		tbmonth.getRows(saletable);
		pCenter.setLayout(new BorderLayout(0, 0));	
		pCenter.add(tbmonth);
		tbs.setVisible(false);
		tball.setVisible(false);
		tbmonth.setVisible(true);
	}
}
