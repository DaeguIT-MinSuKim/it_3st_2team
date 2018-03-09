package kr.or.dgit.it_3st_2team.ui;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;

import kr.or.dgit.it_3st_2team.dto.Employee;
import kr.or.dgit.it_3st_2team.service.EmployeeService;

@SuppressWarnings("serial")

public class LoginFrame extends JFrame implements ActionListener {

	private JPanel contentPane;

	private JTextField tfId;
	private JPasswordField tfPw;
	private JButton btnLogin;
	private EmployeeService service;
	private JButton btnJoin;

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
		service = new EmployeeService();
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
		tfId.addKeyListener(new KeyAdapter() {

			@Override
			public void keyPressed(KeyEvent e) {
				// TODO Auto-generated method stub
				super.keyPressed(e);
				if (e.getKeyCode() == KeyEvent.VK_ENTER) {
					checkIdPassword();
				}
			}

		});

		btnLogin = new JButton("로그인");
		btnLogin.addActionListener(this);

		tfPw = new JPasswordField();
		panel.add(tfPw);
		panel.add(btnLogin);
		tfPw.addKeyListener(new KeyAdapter() {

			@Override
			public void keyPressed(KeyEvent e) {
				// TODO Auto-generated method stub
				super.keyPressed(e);
				if (e.getKeyCode() == KeyEvent.VK_ENTER) {
					checkIdPassword();
				}
			}

		});

		JPanel panel_1 = new JPanel();
		contentPane.add(panel_1, BorderLayout.SOUTH);

		btnJoin = new JButton("회원가입");
		btnJoin.addActionListener(this);
		panel_1.add(btnJoin);
	}

	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnJoin) {
			actionPerformedBtnJoin(e);
		}

		if (e.getSource() == btnLogin) {
			actionPerformedBtnNewButton(e);
		}
	}

	protected void actionPerformedBtnNewButton(ActionEvent e) {
		checkIdPassword();
	}

	private void checkIdPassword() {
		String id = tfId.getText().trim();
		char[] pw = tfPw.getPassword();
		String strPw = new String(pw);

		boolean b = false;
		String adminId = "a";
		String adminPw = "a";

		if (!id.equals("") && (pw.length != 0)) {
			if (id.equals(adminId) && (strPw.equals(adminPw))) {
				String titleName = "admin";
				Hair hf = new Hair(titleName);
				hf.setVisible(true);
				this.dispose();
			} else {
				List<Employee> list = new ArrayList<>();
				list = service.selectEmployeeByLoginId();
				for (Employee emp : list) {
					if (emp.getId().equals(id)) {
						b = true;
						if (!strPw.equals(emp.getEpassword())) {
							JOptionPane.showMessageDialog(null, "비밀번호가 틀렸습니다");
						} else {
							String titleName = emp.getTitle().getTitleName();
							Hair hf = new Hair(titleName);
							hf.setVisible(true);
							this.dispose();
						}
					}
				}
				if (b != true) {
					JOptionPane.showMessageDialog(null, "존재하지 않은 아이디입니다. 회원가입 해주세요");
				}
			}

		} else {
			JOptionPane.showMessageDialog(null, "아이디, 비밀번호를 모두 입력하세요");
		}
	}
//bjh 회원가입 버튼 클릭시 직원 회원가입 화면으로 이동.
	protected void actionPerformedBtnJoin(ActionEvent e) {
		JFrame EmployeeJoin = new EmployeeJoin();
		EmployeeJoin.setVisible(true);
		this.dispose();
	}
}
