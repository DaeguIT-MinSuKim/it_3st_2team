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
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.regex.Matcher;

import javax.naming.RefAddr;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPopupMenu;
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

import org.apache.logging.log4j.core.config.builder.api.Component;

import kr.or.dgit.it_3st_2team.dto.Customer;
import kr.or.dgit.it_3st_2team.dto.Employee;
import kr.or.dgit.it_3st_2team.dto.PhoneNumber;
import kr.or.dgit.it_3st_2team.service.CustomerService;
import kr.or.dgit.it_3st_2team.service.EmployeeService;
import java.awt.event.MouseListener;
import java.awt.event.MouseEvent;

@SuppressWarnings("serial")
public class CustomerJPanel extends JPanel implements ActionListener, KeyListener, MouseListener {
	private JTextField tfNo;
	private JTextField tfName;
	private JTextField tfBirth;
	private JTextField tfJoin;
	private JTextField tfphone2;
	private JTextField tfphone3;
	private JTextField tfaddr;
	private JButton btnNewButton;
	private JTextField tfSearch;
	private JTable table;
	private JTextField tfAge;
	private List<Customer> cList = new ArrayList<>();
	private int cmbEmpNo;

	private CustomerService cservice;
	private EmployeeService eservice;
	private JButton btnAdd;
	private JComboBox cmbEmp;
	private JComboBox cmbphone1;
	private JScrollPane scrollPane;
	private JButton btnCancel;
	private JButton btnUpdate;
	private List<Employee> list;
	private JButton btnDelete;
	private JButton btnSearch;
	private JButton btnAll;

	/**
	 * Create the panel.
	 */
	public CustomerJPanel() {
		cservice = new CustomerService();
		eservice = new EmployeeService();
		initComponents();

	}

	private void initComponents() {
		cList = cservice.SelectAllCustomerEmpName(new Customer(true));

		setLayout(new BorderLayout(0, 0));

		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(null, "\uACE0\uAC1D\uB4F1\uB85D", TitledBorder.LEADING, TitledBorder.TOP, null,
				new Color(0, 0, 0)));
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

		tfNo = new JTextField();
		tfNo.setFocusable(false);
		panel_1.add(tfNo);
		tfNo.setColumns(10);
		tfNo.setEditable(false);
		addtfNo();

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

		list = eservice.selectEmployeeAddTitle(new Employee(true));
		List<SimpleEmp> lists = transToString(list);
		SimpleEmp[] items = new SimpleEmp[list.size()];
		lists.toArray(items);
		DefaultComboBoxModel<SimpleEmp> cModel = new DefaultComboBoxModel<>(items);

		cmbEmp = new JComboBox();
		cmbEmp.addActionListener(this);
		cmbEmp.addMouseListener(this);
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

		cmbphone1 = new JComboBox();
		cmbphone1.setModel(new DefaultComboBoxModel(new String[] { "010", "000" }));

		panel_4.add(cmbphone1);

		JLabel lblPhone2 = new JLabel("-");
		panel_4.add(lblPhone2);

		tfphone2 = new JTextField();
		panel_4.add(tfphone2);
		tfphone2.setColumns(5);

		JLabel lblPhone3 = new JLabel("-");
		panel_4.add(lblPhone3);

		tfphone3 = new JTextField();
		panel_4.add(tfphone3);
		tfphone3.setColumns(5);

		JLabel lblNewLabel = new JLabel("                     ");
		panel_4.add(lblNewLabel);

		JPanel panel_5 = new JPanel();
		panel_6.add(panel_5, BorderLayout.CENTER);
		panel_5.setLayout(new FlowLayout(FlowLayout.CENTER, 3, 3));

		JLabel lblAddr = new JLabel("주소");
		panel_5.add(lblAddr);

		tfaddr = new JTextField();
		panel_5.add(tfaddr);
		tfaddr.setColumns(25);

		btnNewButton = new JButton("주소 찾기");
		btnNewButton.addActionListener(this);
		panel_5.add(btnNewButton);

		JPanel panel_7 = new JPanel();
		panel_6.add(panel_7, BorderLayout.SOUTH);

		btnAdd = new JButton("등록");
		btnAdd.addActionListener(this);
		panel_7.add(btnAdd);

		btnCancel = new JButton("취소");
		btnCancel.addActionListener(this);
		panel_7.add(btnCancel);

		JPanel panel_11 = new JPanel();
		panel_11.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "\uACE0\uAC1D\uC815\uBCF4",
				TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
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

		btnSearch = new JButton("고객찾기");
		btnSearch.addActionListener(this);
		panel_9.add(btnSearch);

		btnAll = new JButton("모든고객보기");
		btnAll.addActionListener(this);
		panel_9.add(btnAll);

		btnUpdate = new JButton("고객 수정");
		btnUpdate.addActionListener(this);
		panel_9.add(btnUpdate);
		btnUpdate.setEnabled(false);

		btnDelete = new JButton("고객 탈퇴");
		btnDelete.addActionListener(this);
		btnDelete.setEnabled(false);
		panel_9.add(btnDelete);

		JPanel panel_10 = new JPanel();
		panel_11.add(panel_10);
		panel_10.setLayout(new BorderLayout(0, 0));

		scrollPane = new JScrollPane();
		panel_10.add(scrollPane, BorderLayout.NORTH);

		table = new JTable();
		table.addMouseListener(this);

		showTables();
	}

	private void clear() {
		getJoinDate();
		tfName.setText("");
		tfBirth.setText("");
		tfAge.setText("");
		cmbEmp.setSelectedIndex(0);
		cmbphone1.setSelectedIndex(0);
		tfphone2.setText("");
		tfphone3.setText("");
		tfaddr.setText("");
		addtfNo();
		btnAdd.setText("등록");
	}

	private void addtfNo() {
		int no = cservice.cusomerSizeNo() + 1;
		tfNo.setText(toString().format("%s", no));
	}

	private void showTables() {

		table.setModel(new DefaultTableModel(getObj(cList), getColumNames()));
		NonEditableModel Nemodel = new NonEditableModel(getObj(cList), getColumNames());
		table.setModel(Nemodel);
		setAlignWidth();
		scrollPane.setViewportView(table);
	}

	private List<SimpleEmp> transToString(List<Employee> list) {
		List<SimpleEmp> result = new ArrayList<>();
		for (Employee e : list) {
			result.add(new SimpleEmp(e.getEmpNo(), e.getEmpName(), e.getTitleNo().getTitleName()));
		}
		return result;
	}

	private void getJoinDate() {
		Calendar now = Calendar.getInstance();
		int year = now.get(Calendar.YEAR);
		int month = now.get(Calendar.MONTH) + 1;
		int day = now.get(Calendar.DAY_OF_MONTH);
		// now.set(year,month,day);
		tfJoin.setText(toString().format("%s-%s-%s", year, month, day));

	}

	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnAll) {
			actionPerformedBtnAll(e);
		}
		if (e.getSource() == btnSearch) {
			actionPerformedBtnSearch(e);
		}
		if (e.getSource() == btnDelete) {
			actionPerformedBtnDelete(e);
		}
		if (e.getSource() == cmbEmp) {
			do_cmbEmp_actionPerformed(e);
		}
		if (e.getSource() == btnUpdate) {
			do_btnUpdate_actionPerformed(e);
		}
		if (e.getSource() == btnCancel) {
			do_btnCancel_actionPerformed(e);
		}
		if (e.getSource() == btnAdd) {
			if (e.getActionCommand().equals("등록")) {
				actionPerformedBtnAdd(e);
			} else if (e.getActionCommand().equals("수정")) {
				actionPerformedBtnUpdate(e);
			}
		}
		if (e.getSource() == btnNewButton) {
			actionPerformedBtnNewButton(e);
		}
	}

	private void actionPerformedBtnUpdate(ActionEvent e) {
		btnUpdate.setEnabled(false);
		Customer ctm = addCustomers();
		cservice.updateSetCustomer(ctm);
		JOptionPane.showMessageDialog(null, "고객정보가 수정 되었습니다.");
		getJoinDate();
		btnAdd.setText("등록");
		cList = cservice.SelectAllCustomerEmpName(new Customer(true));
		showTables();
		addtfNo();
		clear();

	}

	protected void actionPerformedBtnNewButton(ActionEvent arg0) {
	}

	private class SimpleEmp {
		int empNo;
		String empName;
		String titleName;

		public SimpleEmp() {
			super();
			// TODO Auto-generated constructor stub
		}

		private SimpleEmp(int empNo, String empName, String titleName) {
			super();
			this.empNo = empNo;
			this.empName = empName;
			this.titleName = titleName;
		}

		public int getEmpNo() {
			return empNo;
		}

		public void setEmpName(String empName) {
			this.empName = empName;
		}

		public String getEmpName() {
			return empName;
		}

		public String getTitleName() {
			return titleName;
		}

		@Override
		public String toString() {
			return String.format("%s(%s)", empName, titleName);
		}

		private CustomerJPanel getOuterType() {
			return CustomerJPanel.this;
		}
	}

	public void keyPressed(KeyEvent e) {
		if (e.getSource() == tfName) {
			if (e.getKeyChar() == KeyEvent.VK_ENTER) {
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
		String[] b = birth.split("-");
		int bb = Integer.parseInt(b[0]);

		int age = year - bb;

		tfAge.setText(toString().format("%s", age));
	}

	public void setAlignWidth() {
		// 셀의 너비와 정렬
		tableCellAlign(SwingConstants.CENTER, 0, 1, 2, 3, 4, 5, 6, 7);
		// tableCellAlign(SwingConstants.RIGHT, 4);
		tableCellWidth(100, 200, 350, 100, 350, 300, 500, 150);
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
		return new String[] { "번호", "이름", "생년월일", "나이", "가입일자", "연락처", "주소", "담당직원" };
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

	protected void actionPerformedBtnAdd(ActionEvent arg0) {

		Customer ctm = addCustomers();
		cservice.inSertCustomer(ctm);
		JOptionPane.showMessageDialog(null, "고객이 등록 되었습니다.");

		cList = cservice.SelectAllCustomerEmpName(new Customer(true));
		showTables();
		addtfNo();
		clear();
	}

	private Customer addCustomers() {
		int tfno = Integer.parseInt(tfNo.getText().trim());
		String tfname = tfName.getText();

		Calendar jDate = GregorianCalendar.getInstance();
		String jdate = tfJoin.getText();
		String[] jd = jdate.split("-");
		int jdyear = Integer.parseInt(jd[0]);
		int jdmonth = Integer.parseInt(jd[1]);
		int jdday = Integer.parseInt(jd[2]);
		jDate.set(jdyear, jdmonth - 1, jdday);

		Calendar jBirth = GregorianCalendar.getInstance();
		String jbirth = tfBirth.getText();
		String[] jdr = jbirth.split("-");
		int jdryear = Integer.parseInt(jdr[0]);
		int jdrmonth = Integer.parseInt(jdr[1]);
		int jdrday = Integer.parseInt(jdr[2]);
		jBirth.set(jdryear, jdrmonth - 1, jdrday);

		int age = Integer.parseInt(tfAge.getText());

		String phone1 = (String) cmbphone1.getSelectedItem();
		String phone2 = tfphone2.getText();
		String phone3 = tfphone3.getText();
		String phone = phone1 + "-" + phone2 + "-" + phone3;

		String addr = tfaddr.getText();

		Customer ctm = new Customer(tfno, tfname, jBirth.getTime(), age, jDate.getTime(), new PhoneNumber(phone), addr,
				new Employee(cmbEmpNo), true);
		return ctm;
	}

	protected void do_btnCancel_actionPerformed(ActionEvent arg0) {
		clear();
	}

	public void mouseClicked(MouseEvent e) {

		if (e.getSource() == table) {
			do_table_mouseClicked(e);

		}
		if (e.getButton() == MouseEvent.BUTTON3) {
			JPopupMenu jp = new JPopupMenu();
			JMenuItem updateMenu = new JMenuItem("고객 수정");
			jp.add(updateMenu);
			JMenuItem delMenu = new JMenuItem("고객 탈퇴");
			jp.add(delMenu);
			 updateMenu.addActionListener(menuListener);
			 delMenu.addActionListener(menuListener);
			jp.show((java.awt.Component) e.getSource(), e.getX(), e.getY());

		}
	}
	ActionListener menuListener = new ActionListener() {
		@Override
		public void actionPerformed(ActionEvent e) {
			if (e.getActionCommand().equals("고객 수정")) {
				do_btnUpdate_actionPerformed(e);
			}
			if (e.getActionCommand().equals("고객 탈퇴")) {
				actionPerformedBtnDelete(e);
			}
		}

	};
	public void mouseEntered(MouseEvent arg0) {
	}

	public void mouseExited(MouseEvent e) {
	}

	public void mousePressed(MouseEvent e) {
	}

	public void mouseReleased(MouseEvent e) {
	}

	protected void do_table_mouseClicked(MouseEvent arg0) {
		btnUpdate.setEnabled(true);
		btnDelete.setEnabled(true);
	}

	protected void do_btnUpdate_actionPerformed(ActionEvent e) {

		int row = table.getSelectedRow();
		int cusno = (int) (table.getValueAt(row, 0));

		String ph = toString().format("%s", table.getValueAt(row, 5));
		String[] ph1 = ph.split("-");

		tfNo.setText(toString().format("%s", table.getValueAt(row, 0)));
		tfName.setText(toString().format("%s", table.getValueAt(row, 1)));
		tfJoin.setText(toString().format("%s", table.getValueAt(row, 4)));
		tfBirth.setText(toString().format("%s", table.getValueAt(row, 2)));
		tfAge.setText(toString().format("%s", table.getValueAt(row, 3)));
		tfaddr.setText(toString().format("%s", table.getValueAt(row, 6)));
		cmbphone1.setSelectedItem(ph1[0]);
		tfphone2.setText(toString().format("%s", ph1[1]));
		tfphone3.setText(toString().format("%s", ph1[2]));

		btnAdd.setText("수정");
		btnUpdate.setEnabled(false);
		btnDelete.setEnabled(false);

		Object updateempname = table.getValueAt(row, 7);
		String st = null;
		for (int i = 0; i < list.size(); i++) {
			st = list.get(i).getEmpName();
			Boolean s = st.equals(updateempname);
			if (s) {
				cmbEmp.setSelectedIndex(i);
				return;
			} else {
				cmbEmp.setSelectedIndex(0);
			}
		}
	}

	protected void do_cmbEmp_actionPerformed(ActionEvent e) {
		/* 추가할때 */
		String em = toString().format("%s", cmbEmp.getSelectedItem());
		String aem = em.substring(0, 3);
		Employee emp = new Employee(aem);
		cmbEmpNo = eservice.selectEmpNo(emp);
	}

	protected void actionPerformedBtnDelete(ActionEvent e) {
		int row = table.getSelectedRow();
		int cusno = (int) (table.getValueAt(row, 0));
		System.out.println(cusno);
		Customer cus = new Customer(cusno, false);
		cservice.deleteCustomer(cus);
		JOptionPane.showMessageDialog(null, "고객정보가 삭제되었습니다.");
		cList = cservice.SelectAllCustomerEmpName(new Customer(true));
		showTables();
		btnUpdate.setEnabled(false);
		btnDelete.setEnabled(false);
	}

	protected void actionPerformedBtnSearch(ActionEvent e) {
		String cusname = tfSearch.getText().trim();
		List<Customer> cus = cservice.selectAllCustomer();
		Boolean s = false;
		for (int i = 0; i < cus.size(); i++) {
			String name = cus.get(i).getCusName();
			s = name.equals(cusname);
			if (s) {
				Customer ctm = new Customer();
				ctm.setCusName(cusname);
				ctm.setcTf(true);
				cList = cservice.SelectAllCustomerName(ctm);
				showTables();
				tfSearch.setText("");
				return;
			}
		}
		JOptionPane.showMessageDialog(null, "없는 고객입니다.");
		tfSearch.setText("");
	}

	protected void actionPerformedBtnAll(ActionEvent e) {
		cList = cservice.SelectAllCustomerEmpName(new Customer(true));
		showTables();
	}
}
