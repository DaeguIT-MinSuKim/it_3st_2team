package kr.or.dgit.it_3st_2team.ui;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Calendar;
import java.util.List;

import javax.swing.BoxLayout;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import kr.or.dgit.it_3st_2team.dto.Employee;
import kr.or.dgit.it_3st_2team.dto.Title;
import kr.or.dgit.it_3st_2team.service.EmployeeService;
import java.awt.Insets;
import java.awt.Point;
import java.awt.ComponentOrientation;
import javax.swing.border.LineBorder;
import java.awt.Color;
import javax.swing.border.MatteBorder;
import javax.swing.JPasswordField;

@SuppressWarnings("serial")
public class EmployeeJoin extends JFrame implements ActionListener {

	private JPanel empjoin;
	private JTextField tfNo;
	private JTextField tfName;
	private JTextField empJoin_day;
	private JTextField id;
	private JPasswordField pw;
	private JPasswordField repw;
	private JTextField tfAddr;
	private JButton findaddr;
	private JFrame jf;
	private EmployeeService eservice;
	private List<Employee> list;
	private JButton btncn;
	private JButton btnJoin;
	private JButton ckid;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					EmployeeJoin frame = new EmployeeJoin();
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
	public EmployeeJoin() {

		eservice = new EmployeeService();
		initComponents();
	}

	private void initComponents() {
		setTitle("회원가입");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 612, 397);
		empjoin = new JPanel();
		empjoin.setToolTipText("회원가입");
		empjoin.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(empjoin);
		empjoin.setLayout(new BorderLayout(0, 0));

		JPanel panel = new JPanel();
		empjoin.add(panel, BorderLayout.CENTER);
		panel.setLayout(new GridLayout(1, 2, 0, 0));

		JPanel panel_2 = new JPanel();
		panel_2.setToolTipText("회원가입");
		panel.add(panel_2);
		panel_2.setLayout(new GridLayout(9, 1, 0, 0));

		JPanel panel_4 = new JPanel();
		panel_4.setBorder(new MatteBorder(1, 1, 0, 1, (Color) new Color(0, 0, 0)));
		panel_2.add(panel_4);
		panel_4.setLayout(new BoxLayout(panel_4, BoxLayout.X_AXIS));

		JLabel empNo = new JLabel("직원번호");
		empNo.setPreferredSize(new Dimension(250, 0));
		empNo.setHorizontalAlignment(SwingConstants.CENTER);
		panel_4.add(empNo);

		tfNo = new JTextField();
		tfNo.setBorder(new MatteBorder(0, 1, 0, 0, (Color) new Color(0, 0, 0)));
		tfNo.setPreferredSize(new Dimension(10, 21));
		tfNo.setHorizontalAlignment(SwingConstants.CENTER);
		tfNo.setEnabled(false);
		panel_4.add(tfNo);
		tfNo.setColumns(10);
		addtfNo();

		JPanel panel_5 = new JPanel();
		panel_5.setBorder(new MatteBorder(1, 1, 0, 1, (Color) new Color(0, 0, 0)));
		panel_2.add(panel_5);
		panel_5.setLayout(new BoxLayout(panel_5, BoxLayout.X_AXIS));

		JLabel empName = new JLabel("직원명");
		empName.setPreferredSize(new Dimension(250, 0));
		empName.setHorizontalAlignment(SwingConstants.CENTER);
		panel_5.add(empName);

		tfName = new JTextField();
		tfName.setBorder(new MatteBorder(0, 1, 0, 0, (Color) new Color(0, 0, 0)));
		tfName.setPreferredSize(new Dimension(10, 21));
		tfName.setHorizontalAlignment(SwingConstants.CENTER);
		tfName.setColumns(10);
		panel_5.add(tfName);

		JPanel panel_6 = new JPanel();
		panel_6.setBorder(new MatteBorder(1, 1, 0, 1, (Color) new Color(0, 0, 0)));
		panel_2.add(panel_6);
		panel_6.setLayout(new BoxLayout(panel_6, BoxLayout.X_AXIS));

		JLabel joinDate = new JLabel("입사일자");
		joinDate.setPreferredSize(new Dimension(250, 0));
		joinDate.setHorizontalAlignment(SwingConstants.CENTER);
		panel_6.add(joinDate);

		empJoin_day = new JTextField();
		empJoin_day.setBorder(new MatteBorder(0, 1, 0, 0, (Color) new Color(0, 0, 0)));
		empJoin_day.setPreferredSize(new Dimension(10, 21));
		empJoin_day.setEnabled(false);
		empJoin_day.setHorizontalAlignment(SwingConstants.CENTER);
		empJoin_day.setColumns(10);
		panel_6.add(empJoin_day);
		getJoinDate();

		JPanel panel_7 = new JPanel();
		panel_7.setBorder(new MatteBorder(1, 1, 0, 1, (Color) new Color(0, 0, 0)));
		panel_2.add(panel_7);
		panel_7.setLayout(new BoxLayout(panel_7, BoxLayout.X_AXIS));

		JLabel label = new JLabel("주소");
		label.setPreferredSize(new Dimension(290, 0));
		label.setHorizontalAlignment(SwingConstants.CENTER);
		panel_7.add(label);

		tfAddr = new JTextField();
		tfAddr.setBorder(new MatteBorder(0, 1, 0, 1, (Color) new Color(0, 0, 0)));
		tfAddr.setPreferredSize(new Dimension(10, 21));
		tfAddr.setHorizontalAlignment(SwingConstants.CENTER);
		tfAddr.setColumns(25);
		panel_7.add(tfAddr);

		findaddr = new JButton("주소 찾기");
		findaddr.setPreferredSize(new Dimension(100, 0));
		findaddr.addActionListener(this);
		panel_7.add(findaddr);

		JPanel panel_8 = new JPanel();
		panel_8.setBorder(new MatteBorder(1, 1, 0, 1, (Color) new Color(0, 0, 0)));
		panel_2.add(panel_8);
		panel_8.setLayout(new BoxLayout(panel_8, BoxLayout.X_AXIS));

		JLabel Id = new JLabel("아이디");
		Id.setPreferredSize(new Dimension(250, 0));
		Id.setHorizontalAlignment(SwingConstants.CENTER);
		panel_8.add(Id);

		id = new JTextField();
		id.setBorder(new MatteBorder(0, 1, 0, 1, (Color) new Color(0, 0, 0)));
		id.setPreferredSize(new Dimension(10, 21));
		id.setHorizontalAlignment(SwingConstants.CENTER);
		id.setColumns(10);
		panel_8.add(id);

		ckid = new JButton("중복검사");
		ckid.addActionListener(this);
		ckid.setPreferredSize(new Dimension(100, 0));
		panel_8.add(ckid);

		JPanel panel_9 = new JPanel();
		panel_9.setBorder(new MatteBorder(1, 1, 0, 1, (Color) new Color(0, 0, 0)));
		panel_2.add(panel_9);
		panel_9.setLayout(new BoxLayout(panel_9, BoxLayout.X_AXIS));

		JLabel password = new JLabel("비밀번호");
		password.setPreferredSize(new Dimension(250, 0));
		password.setHorizontalAlignment(SwingConstants.CENTER);
		panel_9.add(password);
		
		
		pw = new JPasswordField();
		pw.setBorder(new MatteBorder(0, 1, 0, 0, (Color) new Color(0, 0, 0)));
		pw.setPreferredSize(new Dimension(10, 21));
		pw.setHorizontalAlignment(SwingConstants.CENTER);
		pw.setColumns(10);
		panel_9.add(pw);

		JPanel panel_10 = new JPanel();
		panel_10.setBorder(new MatteBorder(1, 1, 0, 1, (Color) new Color(0, 0, 0)));
		panel_2.add(panel_10);
		panel_10.setLayout(new BoxLayout(panel_10, BoxLayout.X_AXIS));

		JLabel cheackPassword = new JLabel("비밀번호확인");
		cheackPassword.setPreferredSize(new Dimension(250, 0));
		cheackPassword.setHorizontalAlignment(SwingConstants.CENTER);
		panel_10.add(cheackPassword);

		repw = new JPasswordField();
		repw.setBorder(new MatteBorder(0, 1, 0, 0, (Color) new Color(0, 0, 0)));
		repw.setPreferredSize(new Dimension(10, 21));
		repw.setHorizontalAlignment(SwingConstants.CENTER);
		repw.setColumns(10);
		panel_10.add(repw);

		JPanel panel_11 = new JPanel();
		panel_2.add(panel_11);
		panel_11.setLayout(new GridLayout(0, 2, 0, 0));

		JLabel findtitle = new JLabel("직책찾기");
		findtitle.setBorder(new MatteBorder(1, 1, 0, 0, (Color) new Color(0, 0, 0)));
		findtitle.setPreferredSize(new Dimension(250, 0));
		findtitle.setMaximumSize(new Dimension(100, 15));
		findtitle.setHorizontalAlignment(SwingConstants.CENTER);
		panel_11.add(findtitle);

		JComboBox empfind = new JComboBox();
		empfind.setBorder(new MatteBorder(1, 0, 0, 1, (Color) new Color(0, 0, 0)));
		empfind.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
		empfind.setEnabled(false);
		empfind.setModel(new DefaultComboBoxModel(new String[] { "인턴" }));
		empfind.setMaximumSize(new Dimension(80, 30));
		empfind.setPreferredSize(new Dimension(25, 21));
		panel_11.add(empfind);

		JPanel panel_14 = new JPanel();
		panel_14.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)));
		panel_2.add(panel_14);
		panel_14.setLayout(new GridLayout(0, 2, 0, 0));

		JLabel hoppyday = new JLabel("희망휴무요일");
		hoppyday.setPreferredSize(new Dimension(250, 0));
		hoppyday.setMaximumSize(new Dimension(100, 15));
		hoppyday.setHorizontalAlignment(SwingConstants.CENTER);
		panel_14.add(hoppyday);

		JComboBox hday = new JComboBox();
		hday.setBorder(new MatteBorder(0, 0, 0, 0, (Color) new Color(0, 0, 0)));
		hday.setModel(new DefaultComboBoxModel(new String[] { "월요일", "화요일", "수요일", "목요일", "금요일", "토요일", "일요일" }));
		hday.setToolTipText("희망휴무요일");
		panel_14.add(hday);

		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)));
		empjoin.add(panel_1, BorderLayout.SOUTH);
		panel_1.setLayout(new GridLayout(0, 2, 0, 0));

		JPanel panel_12 = new JPanel();
		panel_1.add(panel_12);

		JPanel panel_13 = new JPanel();
		panel_1.add(panel_13);
		panel_13.setLayout(new GridLayout(0, 2, 0, 0));

		btnJoin = new JButton("가입하기");
		btnJoin.addActionListener(this);
		panel_13.add(btnJoin);

		btncn = new JButton("취소");
		btncn.addActionListener(this);
		panel_13.add(btncn);
	}

	private void getJoinDate() {
		Calendar now = Calendar.getInstance();
		int year = now.get(Calendar.YEAR);
		int month = now.get(Calendar.MONTH) + 1;
		int day = now.get(Calendar.DAY_OF_MONTH);
		// now.set(year,month,day);
		empJoin_day.setText(toString().format("%s-%s-%s", year, month, day));

	}

	
	
	
	public void setTfAddrValue(String value) {
		tfAddr.setText(value);
	}

	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == ckid) {
			actionPerformedCkid(e);
		}
		if (e.getSource() == btnJoin) {
			actionPerformedBtnJoin(e);
		}
		if (e.getSource() == btncn) {
			actionPerformedBtncn(e);
		}
		if (e.getSource() == findaddr) {
			actionPerformedButton(e);
		}
	}

	private void addtfNo() {
		int no = eservice.EmployeeSizeNo() + 1;
		tfNo.setText(toString().format("%s", no));
	}

	protected void actionPerformedButton(ActionEvent e) {
		jf = new AddressJFrame(this);
		jf.setVisible(true);
	}

	public void setaddr(String string) {
		tfAddr.setText(string);
	}

	protected void actionPerformedBtncn(ActionEvent e) {
		clear();

	}

	private void clear() {
		tfName.setText("");
		id.setText("");
		pw.setText("");
		repw.setText("");
		tfAddr.setText("");

	}

	protected void actionPerformedBtnJoin(ActionEvent e) {
		String[] str = new String[9];
		Object ob = e.getSource();
		if (tfName.getText().equals("")) {
			JOptionPane.showMessageDialog(this, "직원명을 입력해주세요");
			tfName.requestFocus();
			return;
		}
		if (id.getText().equals("")) {
			JOptionPane.showMessageDialog(this, "아이디를 입력해주세요");
			id.requestFocus();
			return;
		}
		if (pw.getText().equals("")) {
			JOptionPane.showMessageDialog(this, "비밀번호를 입력해주세요");
			pw.requestFocus();
			return;
		}
		
		if (repw.getText().equals("")) {
			JOptionPane.showMessageDialog(this, "비밀번호를 다시 입력해주세요");
			repw.requestFocus();
			return;
			
		} else if (repw.getText().equals(pw.getText())) {
			JOptionPane.showMessageDialog(this, "비밀번호가 일치합니다");
		}else {
			JOptionPane.showMessageDialog(this, "비밀번호를  확인후 다시 입력해주세요 ");
		}

		str[1] = tfName.getText();
		str[4] = id.getText();
		str[5] = pw.getText();
		str[6] = repw.getText();

		/*
		 * eservice.insertTitle(new Employee(Integer.parseInt(str[1]),
		 * str[4],str[6],str[7])); lNow();
		 */
	}
	protected void actionPerformedCkid(ActionEvent e) {
		Employee employee = new Employee();
		Employee searchEmployee = eservice.selectEmployeeByLoginId(employee);
		
		if (employee.getId().equals(searchEmployee.getId())) {
			JOptionPane.showMessageDialog(this, "아이디가 이미 있습니다.");

		}else {

			System.out.println("사용가능한 아이디 입니다.");
		} 
	}
}
