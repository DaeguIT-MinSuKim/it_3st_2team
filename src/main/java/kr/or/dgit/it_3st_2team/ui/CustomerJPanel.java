package kr.or.dgit.it_3st_2team.ui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Calendar;

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
import javax.swing.table.DefaultTableModel;

@SuppressWarnings("serial")
public class CustomerJPanel extends JPanel implements ActionListener {
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

	/**
	 * Create the panel.
	 */
	public CustomerJPanel() {

		initComponents();
		
	}
	private void initComponents() {
		
		
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
		
		tfNo = new JTextField();
		panel_1.add(tfNo);
		tfNo.setColumns(10);
		tfNo.setEditable(false);
		tfNo.setFocusable(false);
		
		JLabel lblName = new JLabel("고객이름");
		lblName.setHorizontalAlignment(SwingConstants.CENTER);
		panel_1.add(lblName);
		
		tfName = new JTextField();
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
		
		JComboBox cmbEmp = new JComboBox();
		panel_1.add(cmbEmp);
		
		/*List<Employee> list = service.selectAllEmployee();
		Employee [] items = new Employee[list.size()];
		System.out.println(items);
		list.toArray(items);
		DefaultComboBoxModel<Employee> cModel = new DefaultComboBoxModel<>(items);*/
		
		
		JPanel panel_6 = new JPanel();
		panel_3.add(panel_6, BorderLayout.WEST);
		panel_6.setLayout(new BorderLayout(0, 0));
		
		JPanel panel_4 = new JPanel();
		panel_6.add(panel_4, BorderLayout.WEST);
		panel_4.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
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
		
		JPanel panel_10 = new JPanel();
		panel_11.add(panel_10);
		panel_10.setLayout(new BorderLayout(0, 0));
		
		JScrollPane scrollPane = new JScrollPane();
		panel_10.add(scrollPane);
		
		table = new JTable();
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"번호", "이름", "생년월일", "나이", "가입일자", "연락처", "주소", "담당직원"
			}
		));
		scrollPane.setViewportView(table);
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
}
