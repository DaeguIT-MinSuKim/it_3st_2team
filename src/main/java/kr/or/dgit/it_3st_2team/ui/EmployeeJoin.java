package kr.or.dgit.it_3st_2team.ui;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.FlowLayout;
import java.awt.GridLayout;

import javax.swing.BoxLayout;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

@SuppressWarnings("serial")
public class EmployeeJoin extends JFrame {

	private JPanel empjoin;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;
	private JTextField textField_6;

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
		initComponents();
	}
	private void initComponents() {
		setTitle("회원가입");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 612, 397);
		empjoin = new JPanel();
		empjoin.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(empjoin);
		empjoin.setLayout(new BorderLayout(0, 0));
		
		JPanel panel = new JPanel();
		empjoin.add(panel, BorderLayout.CENTER);
		panel.setLayout(new GridLayout(1, 2, 0, 0));
		
		JPanel panel_2 = new JPanel();
		panel.add(panel_2);
		panel_2.setLayout(new GridLayout(7, 1, 0, 0));
		
		JPanel panel_4 = new JPanel();
		panel_2.add(panel_4);
		panel_4.setLayout(new FlowLayout(FlowLayout.LEFT, 15, 10));
		
		JLabel empNo = new JLabel("직원번호");
		empNo.setHorizontalAlignment(SwingConstants.CENTER);
		panel_4.add(empNo);
		
		textField = new JTextField();
		textField.setHorizontalAlignment(SwingConstants.LEFT);
		panel_4.add(textField);
		textField.setColumns(10);
		
		JPanel panel_5 = new JPanel();
		panel_2.add(panel_5);
		panel_5.setLayout(new FlowLayout(FlowLayout.LEFT, 21, 10));
		
		JLabel empName = new JLabel("직원명");
		empName.setHorizontalAlignment(SwingConstants.CENTER);
		panel_5.add(empName);
		
		textField_1 = new JTextField();
		textField_1.setHorizontalAlignment(SwingConstants.LEFT);
		textField_1.setColumns(10);
		panel_5.add(textField_1);
		
		JPanel panel_6 = new JPanel();
		panel_2.add(panel_6);
		panel_6.setLayout(new FlowLayout(FlowLayout.LEFT, 15, 10));
		
		JLabel joinDate = new JLabel("입사일자");
		joinDate.setHorizontalAlignment(SwingConstants.CENTER);
		panel_6.add(joinDate);
		
		textField_2 = new JTextField();
		textField_2.setHorizontalAlignment(SwingConstants.LEFT);
		textField_2.setColumns(10);
		panel_6.add(textField_2);
		
		JPanel panel_7 = new JPanel();
		panel_2.add(panel_7);
		panel_7.setLayout(new FlowLayout(FlowLayout.LEFT, 15, 10));
		
		JLabel address = new JLabel("주소");
		address.setHorizontalAlignment(SwingConstants.CENTER);
		panel_7.add(address);
		
		textField_3 = new JTextField();
		textField_3.setHorizontalAlignment(SwingConstants.LEFT);
		textField_3.setColumns(10);
		panel_7.add(textField_3);
		
		JButton btnNewButton_3 = new JButton("주소찾기");
		panel_7.add(btnNewButton_3);
		
		JPanel panel_8 = new JPanel();
		panel_2.add(panel_8);
		panel_8.setLayout(new FlowLayout(FlowLayout.LEFT, 10, 10));
		
		JLabel Id = new JLabel("아이디");
		Id.setHorizontalAlignment(SwingConstants.CENTER);
		panel_8.add(Id);
		
		textField_4 = new JTextField();
		textField_4.setHorizontalAlignment(SwingConstants.LEFT);
		textField_4.setColumns(10);
		panel_8.add(textField_4);
		
		JButton btnNewButton_2 = new JButton("중복검사");
		panel_8.add(btnNewButton_2);
		
		JPanel panel_9 = new JPanel();
		panel_2.add(panel_9);
		panel_9.setLayout(new FlowLayout(FlowLayout.LEFT, 27, 10));
		
		JLabel password = new JLabel("비밀번호");
		password.setHorizontalAlignment(SwingConstants.CENTER);
		panel_9.add(password);
		
		textField_5 = new JTextField();
		textField_5.setHorizontalAlignment(SwingConstants.LEFT);
		textField_5.setColumns(10);
		panel_9.add(textField_5);
		
		JPanel panel_10 = new JPanel();
		panel_2.add(panel_10);
		panel_10.setLayout(new FlowLayout(FlowLayout.LEFT, 15, 10));
		
		JLabel cheackPassword = new JLabel("비밀번호확인");
		cheackPassword.setHorizontalAlignment(SwingConstants.CENTER);
		panel_10.add(cheackPassword);
		
		textField_6 = new JTextField();
		textField_6.setHorizontalAlignment(SwingConstants.LEFT);
		textField_6.setColumns(10);
		panel_10.add(textField_6);
		
		JPanel panel_3 = new JPanel();
		panel.add(panel_3);
		panel_3.setLayout(new GridLayout(6, 1, 0, 0));
		
		JPanel panel_11 = new JPanel();
		panel_3.add(panel_11);
		panel_11.setLayout(new BoxLayout(panel_11, BoxLayout.X_AXIS));
		
		JLabel findtitle = new JLabel("직책찾기");
		findtitle.setMaximumSize(new Dimension(100, 15));
		findtitle.setHorizontalAlignment(SwingConstants.CENTER);
		panel_11.add(findtitle);
		
		JComboBox empfind = new JComboBox();
		empfind.setEnabled(false);
		empfind.setModel(new DefaultComboBoxModel(new String[] {"인턴"}));
		empfind.setMaximumSize(new Dimension(80, 30));
		empfind.setPreferredSize(new Dimension(25, 21));
		panel_11.add(empfind);
		
		JPanel panel_14 = new JPanel();
		panel_3.add(panel_14);
		panel_14.setLayout(new BoxLayout(panel_14, BoxLayout.X_AXIS));
		
		JLabel hoppyday = new JLabel("희망휴무요일");
		hoppyday.setMaximumSize(new Dimension(100, 15));
		hoppyday.setHorizontalAlignment(SwingConstants.CENTER);
		panel_14.add(hoppyday);
		
		JComboBox hday = new JComboBox();
		hday.setModel(new DefaultComboBoxModel(new String[] {"월요일", "화요일", "수요일", "목요일", "금요일", "토요일", "일요일"}));
		hday.setMaximumSize(new Dimension(150, 30));
		hday.setToolTipText("희망휴무요일");
		panel_14.add(hday);
		
		JPanel panel_1 = new JPanel();
		empjoin.add(panel_1, BorderLayout.SOUTH);
		panel_1.setLayout(new GridLayout(0, 2, 0, 0));
		
		JPanel panel_12 = new JPanel();
		panel_1.add(panel_12);
		
		JPanel panel_13 = new JPanel();
		panel_1.add(panel_13);
		panel_13.setLayout(new GridLayout(0, 2, 0, 0));
		
		JButton btnNewButton = new JButton("가입하기");
		panel_13.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("취소");
		panel_13.add(btnNewButton_1);
	}

}
