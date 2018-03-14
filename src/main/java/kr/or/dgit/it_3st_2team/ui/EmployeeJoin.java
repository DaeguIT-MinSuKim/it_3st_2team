package kr.or.dgit.it_3st_2team.ui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.ComponentOrientation;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.swing.BoxLayout;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.border.MatteBorder;

import kr.or.dgit.it_3st_2team.dto.Employee;
import kr.or.dgit.it_3st_2team.dto.Title;
import kr.or.dgit.it_3st_2team.service.EmployeeService;
import kr.or.dgit.it_3st_2team.service.TitleService;

@SuppressWarnings("serial")
public class EmployeeJoin extends JFrame implements ActionListener {

	private JPanel empjoin;
	private JTextField tfNo;
	private JTextField tfName;
	private JTextField empJoin_day;
	private JTextField tfid;
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
	private int idCk = 0;
	private int idw = 0;
	private int empnameCk = 0;
	private int pwCk = 0;
	private int repwCk = 0;
	private JComboBox<Title> empfind;
	private List<Title> tlist;
	private JComboBox<String> hday;
	private TitleService tservice;

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
		tservice = new TitleService();
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

		tfid = new JTextField();
		tfid.setBorder(new MatteBorder(0, 1, 0, 1, (Color) new Color(0, 0, 0)));
		tfid.setPreferredSize(new Dimension(10, 21));
		tfid.setHorizontalAlignment(SwingConstants.CENTER);
		tfid.setColumns(10);
		panel_8.add(tfid);

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

		List<Title> list = tservice.selectTitle();
		Title[] items = list.toArray(new Title[list.size()]);
		DefaultComboBoxModel<Title> model = new DefaultComboBoxModel<>(items);
		empfind = new JComboBox<>(model);
		empfind.setSelectedIndex(4);
		empfind.setBorder(new MatteBorder(1, 0, 0, 1, (Color) new Color(0, 0, 0)));
		empfind.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
		empfind.setEnabled(false);
		// empfind.setModel(new DefaultComboBoxModel<Title>(new Title[] { new
		// Title("인턴") }));
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

		hday = new JComboBox<>();
		hday.setBorder(new MatteBorder(0, 0, 0, 0, (Color) new Color(0, 0, 0)));
		hday.setModel(
				new DefaultComboBoxModel<String>(new String[] { "월요일", "화요일", "수요일", "목요일", "금요일", "토요일", "일요일" }));
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
		tfid.setText("");
		pw.setText("");
		repw.setText("");
		tfAddr.setText("");

	}

	protected void actionPerformedBtnJoin(ActionEvent e) {
		char[] pw2 = pw.getPassword();
		String strPw = new String(pw2);
		char[] repw2 = repw.getPassword();
		String strrePw = new String(repw2);
		if (tfName.getText().equals("")) {
			empnameCk = 0;
			JOptionPane.showMessageDialog(this, "직원명을 입력해주세요");
			tfName.requestFocus();
			return;
		} else {
			empnameCk++;
		}
		if (tfid.getText().equals("")) {
			idw = 0;
			JOptionPane.showMessageDialog(this, "아이디를 입력해주세요");
			tfid.requestFocus();
			return;
		} else {
			idw++;
		}
		if (strPw.equals("")) {

			pwCk = 0;
			JOptionPane.showMessageDialog(this, "비밀번호를 입력해주세요");
			pw.requestFocus();
			return;
		} else {
			pwCk++;
		}

		if (strrePw.equals("")) {

			repwCk = 0;
			JOptionPane.showMessageDialog(this, "비밀번호 확인란을 입력해주세요");
			repw.requestFocus();
			return;

		} else if (strrePw.equals(strPw)) {
			repwCk++;
			JOptionPane.showMessageDialog(this, "비밀번호가 일치합니다");
		} else if (strrePw != strPw) {
			repwCk = 0;
			System.out.println(repw);
			JOptionPane.showMessageDialog(this, "비밀번호가 다릅니다  확인후 다시 입력해주세요 ");
			return;
		}
		if (idCk == 0) {
			JOptionPane.showMessageDialog(this, "아이디 중복을 확인 하십시오. ");
			return;
		} else if (idCk != 0 && idw == 0) {
			JOptionPane.showMessageDialog(this, "아이디를 입력하십시오.");
			return;
		} else if (idCk != 0 && idw != 0 && empnameCk == 0) {
			JOptionPane.showMessageDialog(this, "직원명을 입력하십시오.");
			return;
		} else if (idCk != 0 && idw != 0 && empnameCk != 0 && pwCk == 0) {
			JOptionPane.showMessageDialog(this, "비밀번호를 입력하십시오.");
			return;
		} else if (idCk != 0 && idw != 0 && empnameCk != 0 && pwCk != 0 && repwCk == 0) {
			JOptionPane.showMessageDialog(this, "비밀번호 확인을 입력하십시오.");
			return;
		} else if (idCk != 0 && idw != 0 && empnameCk != 0 && pwCk != 0 && repwCk != 0) {
			JOptionPane.showMessageDialog(this, "회원가입이 성공적으로 완료 되었습니다.");

			Employee Emp = addEmployee();
			eservice.insertEmployee(Emp);

			LoginFrame lf = new LoginFrame();
			lf.setVisible(true);
			this.dispose();

			System.out.println(empfind);
		}
	}

	private Employee addEmployee() {
		int tfno = Integer.parseInt(tfNo.getText().trim());
		String tfname = tfName.getText();

		Calendar calender = GregorianCalendar.getInstance();
		String date = empJoin_day.getText();
		String[] arrDate = date.split("-");
		int year = Integer.parseInt(arrDate[0]);
		int month = Integer.parseInt(arrDate[1]);
		int day = Integer.parseInt(arrDate[2]);
		calender.set(year, month - 1, day);

		String id = tfid.getText();
		String addr = tfAddr.getText();
		// String tfpw = pw.getText();
		char[] pw2 = pw.getPassword();
		String strPw = new String(pw2);
		// String tfrepw = repw.getText();

		Title selectedEventempch = (Title) empfind.getSelectedItem();

		System.out.println(selectedEventempch);
		if (hday.equals("월")) {
			hday.setSelectedIndex(0);
		} else if (hday.equals("화")) {
			hday.setSelectedIndex(1);
		} else if (hday.equals("수")) {
			hday.setSelectedIndex(2);
		} else if (hday.equals("목")) {
			hday.setSelectedIndex(3);
		} else if (hday.equals("금")) {
			hday.setSelectedIndex(4);
		} else if (hday.equals("토")) {
			hday.setSelectedIndex(5);
		} else if (hday.equals("일")) {
			hday.setSelectedIndex(6);
		}

		int selectedEventhdaych = hday.getSelectedIndex();

		Employee Emp = new Employee(tfno, tfname, calender.getTime(), addr, id, strPw, selectedEventempch,
				selectedEventhdaych, true);
		System.out.println(tfno);
		return Emp;
	}

	// 아이디 중복확인 검사
	protected void actionPerformedCkid(ActionEvent check) {
		String id = tfid.getText().trim();
		if (id.equals("")) {
			JOptionPane.showMessageDialog(this, "아이디를 입력하세요.");
			idCk = 0;
			return;
		}
		List<Employee> list = eservice.selectEmployeeByid();
		for (Employee emp : list) {
			System.out.println(emp.getId());
			if (emp.getId().equals(id)) {
				idCk = 0;
				break;
			} else {

				idCk++;

			}
		}
		if (idCk == 0) {
			JOptionPane.showMessageDialog(this, "아이디가 이미 있습니다.");
		} else {
			JOptionPane.showMessageDialog(this, "사용가능한 아이디 입니다.");
		}
	}
}
