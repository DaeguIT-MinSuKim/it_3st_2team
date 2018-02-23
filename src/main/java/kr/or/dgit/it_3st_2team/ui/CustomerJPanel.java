package kr.or.dgit.it_3st_2team.ui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;

import kr.or.dgit.it_3st_2team.dto.Customer;
import kr.or.dgit.it_3st_2team.dto.Employee;
import kr.or.dgit.it_3st_2team.service.CustomerService;
import kr.or.dgit.it_3st_2team.service.EmployeeService;

@SuppressWarnings("serial")
public class CustomerJPanel extends JPanel implements ActionListener, KeyListener{
	private JTextField tfNo;
	private JTextField tfName;
	private JTextField tfBirth;
	private JTextField tfJoin;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_4;
	private JButton btnNewButton;
	private JTextField tfSearch;
	private JTable table;
	private JTextField tfAge;
	private List<Customer> cList = new ArrayList<>();
	
	
	private CustomerService cservice;
	private EmployeeService eservice;
	/**
	 * Create the panel.
	 */
	public CustomerJPanel() {
		cservice = new CustomerService();
		eservice = new EmployeeService();
		initComponents();
		
	}
	private void initComponents() {
		
		cList = cservice.SelectAllCustomerEmpName();
		
		setLayout(new BorderLayout(0, 0));
		
		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(null, "\uACE0\uAC1D\uB4F1\uB85D", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		add(panel, BorderLayout.NORTH);
		panel.setLayout(new BorderLayout(0, 0));
		
		JPanel panel_2 = new JPanel();
		panel.add(panel_2, BorderLayout.WEST);
		panel_2.setLayout(new BorderLayout(0, 0));
		
		JPanel panel_3 = new JPanel();
		panel_2.add(panel_3, BorderLayout.SOUTH);
		panel_3.setLayout(new BorderLayout(0, 0));
		
		JPanel panel_1 = new JPanel();
		panel_3.add(panel_1, BorderLayout.NORTH);
		panel_1.setLayout(new GridLayout(0, 4, 10, 5));
		
		JLabel lblNo = new JLabel("고객번호");
		lblNo.setHorizontalAlignment(SwingConstants.CENTER);
		panel_1.add(lblNo);
		
		
		int no = cList.size()+1;
		tfNo = new JTextField();
		tfNo.setFocusable(false);
		panel_1.add(tfNo);
		tfNo.setColumns(10);
		tfNo.setEditable(false);
		tfNo.setText(toString().format("%s", no));
		
		JLabel lblName = new JLabel("고객이름");
		lblName.setHorizontalAlignment(SwingConstants.CENTER);
		panel_1.add(lblName);
		
		tfName = new JTextField();
		tfName.addKeyListener(this);
		tfName.setColumns(10);
		panel_1.add(tfName);
		
		
		
		JLabel lblJoin = new JLabel("가입일자");
		lblJoin.setHorizontalAlignment(SwingConstants.CENTER);
		panel_1.add(lblJoin);
		
		tfJoin = new JTextField();
		tfJoin.setColumns(10);
		panel_1.add(tfJoin);
		tfJoin.setEditable(false);
		getJoinDate();
		
		
		JLabel lblBirth = new JLabel("생년월일");
		lblBirth.setHorizontalAlignment(SwingConstants.CENTER);
		panel_1.add(lblBirth);
		
		tfBirth = new JTextField();
		tfBirth.addKeyListener(this);
		tfBirth.setColumns(10);
		panel_1.add(tfBirth);
		
		JLabel lblAge = new JLabel("나이");
		lblAge.setHorizontalAlignment(SwingConstants.CENTER);
		panel_1.add(lblAge);
		
		tfAge = new JTextField();
		panel_1.add(tfAge);
		tfAge.setColumns(10);
		tfAge.setEditable(false);
		JLabel lblEmp = new JLabel("담당직원");
		lblEmp.setHorizontalAlignment(SwingConstants.CENTER);
		panel_1.add(lblEmp);
		
		
		
		List<Employee> list = eservice.selectEmployeeAddTitle();
		List<SimpleEmp> lists = transToString(list);
		SimpleEmp [] items = new SimpleEmp[list.size()];
		lists.toArray(items);	
		DefaultComboBoxModel<SimpleEmp> cModel = new DefaultComboBoxModel<>(items);
				
		JComboBox cmbEmp = new JComboBox();
		panel_1.add(cmbEmp);
		cmbEmp.setModel(cModel);
		
		
		
		JPanel panel_6 = new JPanel();
		panel_3.add(panel_6, BorderLayout.WEST);
		panel_6.setLayout(new BorderLayout(0, 0));
		
		JPanel panel_4 = new JPanel();
		panel_6.add(panel_4, BorderLayout.WEST);
		panel_4.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		JLabel lblNewLabel_1 = new JLabel("                 ");
		panel_4.add(lblNewLabel_1);
		
		JLabel lblPhone1 = new JLabel("전화번호");
		lblPhone1.setHorizontalAlignment(SwingConstants.LEFT);
		panel_4.add(lblPhone1);
		
		JComboBox comboBox_1 = new JComboBox();
		comboBox_1.setModel(new DefaultComboBoxModel(new String[] {"010"}));
		
		panel_4.add(comboBox_1);
		
		
		JLabel lblPhone2 = new JLabel("-");
		panel_4.add(lblPhone2);
		
		textField = new JTextField();
		panel_4.add(textField);
		textField.setColumns(5);
		
		JLabel lblPhone3 = new JLabel("-");
		panel_4.add(lblPhone3);
		
		textField_1 = new JTextField();
		panel_4.add(textField_1);
		textField_1.setColumns(5);
		
		JLabel lblNewLabel = new JLabel("                     ");
		panel_4.add(lblNewLabel);
		
		JPanel panel_5 = new JPanel();
		panel_6.add(panel_5, BorderLayout.CENTER);
		panel_5.setLayout(new FlowLayout(FlowLayout.CENTER, 3, 3));
		
		JLabel lblAddr = new JLabel("주소");
		panel_5.add(lblAddr);
		
		textField_4 = new JTextField();
		panel_5.add(textField_4);
		textField_4.setColumns(25);
		
		btnNewButton = new JButton("주소 찾기");
		btnNewButton.addActionListener(this);
		panel_5.add(btnNewButton);
		
		JPanel panel_7 = new JPanel();
		panel_6.add(panel_7, BorderLayout.SOUTH);
		
		JButton btnNewButton_1 = new JButton("등록");
		panel_7.add(btnNewButton_1);
		
		JButton btnNewButton_3 = new JButton("수정");
		panel_7.add(btnNewButton_3);
		
		JButton btnNewButton_2 = new JButton("취소");
		panel_7.add(btnNewButton_2);
		
		JPanel panel_11 = new JPanel();
		panel_11.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "\uACE0\uAC1D\uC815\uBCF4", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		add(panel_11, BorderLayout.CENTER);
		panel_11.setLayout(new BorderLayout(0, 0));
		
		JPanel pCenter = new JPanel();
		panel_11.add(pCenter, BorderLayout.NORTH);
		pCenter.setBorder(new EmptyBorder(0, 0, 0, 0));
		
		JPanel panel_8 = new JPanel();
		pCenter.add(panel_8);
		panel_8.setLayout(new BorderLayout(0, 0));
		
		JPanel panel_9 = new JPanel();
		panel_8.add(panel_9, BorderLayout.NORTH);
		
		tfSearch = new JTextField();
		panel_9.add(tfSearch);
		tfSearch.setColumns(10);
		
		JButton btnName = new JButton("고객찾기");
		panel_9.add(btnName);
		
		JButton btnAll = new JButton("모든고객보기");
		panel_9.add(btnAll);
		
		JButton btnNewButton_4 = new JButton("고객 탈퇴");
		panel_9.add(btnNewButton_4);
		
		JPanel panel_10 = new JPanel();
		panel_11.add(panel_10);
		panel_10.setLayout(new BorderLayout(0, 0));
		
		JScrollPane scrollPane = new JScrollPane();
		panel_10.add(scrollPane);
		
		table = new JTable();
		
		table.setModel(new DefaultTableModel(getObj(cList),getColumNames()));
		NonEditableModel  Nemodel = new NonEditableModel(getObj(cList),getColumNames());
		table.setModel(Nemodel);
		setAlignWidth();
		scrollPane.setViewportView(table);
	}
	private List<SimpleEmp> transToString(List<Employee> list) {
		List<SimpleEmp> result = new ArrayList<>();
		for(Employee e : list) {
			result.add(new SimpleEmp(e.getEmpNo(), e.getEmpName(), e.getTitleNo().getTitleName()));
		}
		return result;
	}
	private void getJoinDate() {
		Calendar now = Calendar.getInstance();
		int year = now.get(Calendar.YEAR);
		int month = now.get(Calendar.MONTH)+1;
		int day = now.get(Calendar.DAY_OF_MONTH);
		//now.set(year,month,day);
		tfJoin.setText(toString().format("%s-%s-%s",year,month,day));
		
	}

	public void actionPerformed(ActionEvent arg0) {
		if (arg0.getSource() == btnNewButton) {
			actionPerformedBtnNewButton(arg0);
		}
	}
	protected void actionPerformedBtnNewButton(ActionEvent arg0) {
	}
	
	private class SimpleEmp{
		int empNo;
		String empName;
		String titleName;
		
		private SimpleEmp(int empNo, String empName, String titleName) {
			super();
			this.empNo = empNo;
			this.empName = empName;
			this.titleName = titleName;
		}

		public int getEmpNo() {
			return empNo;
		}


		@Override
		public String toString() {
			return String.format("%s(%s)", empName, titleName);
		}
	}

	public void keyPressed(KeyEvent e) {
		if (e.getSource() == tfName) {
			if(e.getKeyChar()==KeyEvent.VK_ENTER) {
				keyPressedTfName(e);
				return;
			}			
		}	
		if (e.getKeyCode() == KeyEvent.VK_ENTER) {
			keyPressedTfBirth(e);
		}
	}
	public void keyReleased(KeyEvent e) {
	}
	public void keyTyped(KeyEvent e) {
	}
	protected void keyPressedTfName(KeyEvent e) {
		tfName.setFocusable(false);
		tfJoin.setFocusable(false);
	
	}
	protected void keyPressedTfBirth(KeyEvent e) {
		Calendar now = Calendar.getInstance();
		int year = now.get(Calendar.YEAR);
		String birth = tfBirth.getText(); 
		String[] b =birth.split("-");
		int bb= Integer.parseInt(b[0]);
		
		int age = year-bb;
		
		tfAge.setText(toString().format("%s", age));
	}
	
	public void setAlignWidth() {
		// 셀의 너비와 정렬
		tableCellAlign(SwingConstants.CENTER, 0, 1, 2, 3, 4,5,6,7);
	//	tableCellAlign(SwingConstants.RIGHT, 4);
		tableCellWidth(100, 200, 350, 100, 350, 300,500,150);
	}

	protected void tableCellAlign(int align, int... idx) {
		DefaultTableCellRenderer dtcr = new DefaultTableCellRenderer();
		dtcr.setHorizontalAlignment(align);

		TableColumnModel model = table.getColumnModel();
		for (int i = 0; i < idx.length; i++) {
			model.getColumn(idx[i]).setCellRenderer(dtcr);
		}
	}

	protected void tableCellWidth(int... width) {
		TableColumnModel model = table.getColumnModel();
		for (int i = 0; i < width.length; i++) {
			model.getColumn(i).setPreferredWidth(width[i]);
		}
	}
	
	
	public String[] getColumNames() {
		return new String[] {"번호", "이름", "생년월일", "나이", "가입일자", "연락처", "주소", "담당직원"};
	}
	
	private Object[][] getObj(List<Customer> cList) {
		Object[][] rows = null;

		rows = new Object[cList.size()][];
		for (int i = 0; i < cList.size(); i++) {
			Customer cm = cList.get(i);
		
			rows[i] = cm.toArraySelectAllCustomer();
		}
		return rows;

	}
	class NonEditableModel extends DefaultTableModel {
		public NonEditableModel(Object[][] data, Object[] columnNames) {
			super(data, columnNames);
		}

		@Override
		public boolean isCellEditable(int row, int column) {
			return false;
		}
	}

}
