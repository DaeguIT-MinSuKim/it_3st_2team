package kr.or.dgit.it_3st_2team.ui;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import java.awt.Color;

@SuppressWarnings("serial")
public class TitleManage extends JFrame {

	private JPanel titlemanage;
	private JTable table;
	private JTextField textField;
	private JTextField textField_1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Event frame = new Event();
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
	public TitleManage() {
		initComponents();
	}

	private void initComponents() {
		setTitle("직책등록 및 관리");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 406, 374);
		titlemanage = new JPanel();
		titlemanage.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(titlemanage);
		titlemanage.setLayout(new BorderLayout(0, 0));

		JPanel panel = new JPanel();
		titlemanage.add(panel, BorderLayout.CENTER);
		panel.setLayout(new GridLayout(0, 1, 0, 0));

		JPanel panel_5 = new JPanel();
		panel.add(panel_5);
		panel_5.setLayout(new BorderLayout(0, 0));

		JPanel panel_6 = new JPanel();
		panel_5.add(panel_6);
		panel_6.setLayout(new BorderLayout(0, 0));

		JPanel panel_8 = new JPanel();
		panel_8.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel_6.add(panel_8, BorderLayout.CENTER);
		panel_8.setLayout(new GridLayout(0, 1, 0, 0));

		JPanel panel_9 = new JPanel();
		FlowLayout flowLayout_1 = (FlowLayout) panel_9.getLayout();
		flowLayout_1.setVgap(15);
		panel_8.add(panel_9);

		JLabel label = new JLabel("직책 번호");
		label.setFont(new Font("굴림", Font.PLAIN, 17));
		label.setHorizontalAlignment(SwingConstants.CENTER);
		panel_9.add(label);

		textField = new JTextField();
		textField.setColumns(10);
		panel_9.add(textField);

		JPanel panel_10 = new JPanel();
		panel_8.add(panel_10);
		panel_10.setLayout(new FlowLayout(FlowLayout.CENTER, 18, 15));

		JLabel label_1 = new JLabel("직책 명");
		label_1.setFont(new Font("굴림", Font.PLAIN, 17));
		label_1.setHorizontalAlignment(SwingConstants.CENTER);
		panel_10.add(label_1);

		textField_1 = new JTextField();
		textField_1.setColumns(10);
		panel_10.add(textField_1);

		JPanel panel_7 = new JPanel();
		panel_6.add(panel_7, BorderLayout.SOUTH);
		panel_7.setLayout(new GridLayout(0, 3, 0, 0));

		JPanel panel_11 = new JPanel();
		panel_7.add(panel_11);

		JPanel panel_12 = new JPanel();
		panel_7.add(panel_12);

		JPanel panel_13 = new JPanel();
		FlowLayout flowLayout_2 = (FlowLayout) panel_13.getLayout();
		flowLayout_2.setAlignment(FlowLayout.RIGHT);
		panel_7.add(panel_13);

		JButton btnNewButton_3 = new JButton("추가");
		panel_13.add(btnNewButton_3);

		table = new JTable();
		panel.add(table);

		JPanel panel_1 = new JPanel();
		titlemanage.add(panel_1, BorderLayout.SOUTH);
		panel_1.setLayout(new GridLayout(0, 2, 0, 0));

		JPanel panel_2 = new JPanel();
		panel_1.add(panel_2);

		JPanel panel_4 = new JPanel();
		panel_1.add(panel_4);
		panel_4.setLayout(new GridLayout(1, 0, 0, 0));

		JButton btnNewButton = new JButton("수정");
		panel_4.add(btnNewButton);

		JButton btnNewButton_1 = new JButton("확인");
		panel_4.add(btnNewButton_1);

		JButton btnNewButton_2 = new JButton("삭제");
		panel_4.add(btnNewButton_2);

		JPanel panel_3 = new JPanel();
		titlemanage.add(panel_3, BorderLayout.NORTH);
		panel_3.setLayout(new BoxLayout(panel_3, BoxLayout.X_AXIS));
	}
	

}
