package kr.or.dgit.it_3st_2team.ui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import org.junit.Assert;

import kr.or.dgit.it_3st_2team.dao.EmployeeDao;
import kr.or.dgit.it_3st_2team.dto.Employee;
import kr.or.dgit.it_3st_2team.service.EmployeeService;

import javax.swing.JTextField;
import java.awt.GridLayout;
import java.awt.FlowLayout;
import javax.swing.BoxLayout;
import java.awt.Dimension;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class LoginFrame extends JFrame implements ActionListener {

	private JPanel contentPane;
	private JTextField tfId;
	private JTextField tfPw;
	private JButton btnLogin;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LoginFrame frame = new LoginFrame();
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
	public LoginFrame() {
		initComponents();
	}
	private void initComponents() {
		setTitle("login");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		
		JPanel panel = new JPanel();
		panel.setBorder(new EmptyBorder(50, 80, 50, 80));
		contentPane.add(panel, BorderLayout.CENTER);
		panel.setLayout(new GridLayout(0, 1, 0, 0));
		
		tfId = new JTextField();
		panel.add(tfId);
		tfId.setColumns(10);
		
		tfPw = new JTextField();
		panel.add(tfPw);
		tfPw.setColumns(10);
		
		btnLogin = new JButton("로그인");
		btnLogin.addActionListener(this);
		panel.add(btnLogin);
		
		JPanel panel_1 = new JPanel();
		contentPane.add(panel_1, BorderLayout.SOUTH);
		
		JButton btnNewButton_1 = new JButton("회원가입");
		panel_1.add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("비밀번호찾기");
		panel_1.add(btnNewButton_2);
	}

	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnLogin) {
			actionPerformedBtnNewButton(e);
		}
	}
	protected void actionPerformedBtnNewButton(ActionEvent e) {
		String id = tfId.getText().trim();
		String pw = tfPw.getText().trim();
		Employee employee = new Employee();
		employee.setId(id);
		employee.setPassword(pw);
		
		EmployeeService service = new EmployeeService();
		
		Employee searchEmployee=service.selectEmployeeByLoginId(employee);
		//Assert.assertSame(searchEmployee.getPassword(), employee.getPassword());
		
		System.out.println("입력:"+employee);
		System.out.println("DB:"+searchEmployee);
		
		if(employee.getPassword().equals(searchEmployee.getPassword())) {
			System.out.println("로그인 성공");
		}else {
			System.out.println("비밀번호가 틀렸습니다");
		}
		
		
		
		
	}
}
