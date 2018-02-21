package kr.or.dgit.it_3st_2team.ui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.GridLayout;
import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.BoxLayout;
import java.awt.FlowLayout;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Dimension;
import java.awt.Font;
import javax.swing.border.LineBorder;
import java.awt.Color;

public class Event extends JFrame {

	private JPanel 이벤트관리;
	private JTable table;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;

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
	public Event() {
		initComponents();
	}
	private void initComponents() {
		setTitle("이벤트등록");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 406, 374);
		이벤트관리 = new JPanel();
		이벤트관리.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(이벤트관리);
		이벤트관리.setLayout(new BorderLayout(0, 0));
		
		JPanel panel = new JPanel();
		이벤트관리.add(panel, BorderLayout.CENTER);
		panel.setLayout(new GridLayout(0, 1, 0, 0));
		
		JPanel panel_5 = new JPanel();
		panel.add(panel_5);
		panel_5.setLayout(new BorderLayout(0, 0));
		
		JPanel panel_6 = new JPanel();
		panel_5.add(panel_6);
		panel_6.setLayout(new BorderLayout(0, 0));
		
		JPanel panel_8 = new JPanel();
		FlowLayout flowLayout = (FlowLayout) panel_8.getLayout();
		panel_6.add(panel_8, BorderLayout.CENTER);
		
		JPanel panel_15 = new JPanel();
		panel_15.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel_8.add(panel_15);
		panel_15.setLayout(new GridLayout(0, 1, 0, 0));
		
		JPanel panel_9 = new JPanel();
		panel_15.add(panel_9);
		FlowLayout flowLayout_1 = (FlowLayout) panel_9.getLayout();
		
		JLabel label = new JLabel("이벤트 번호");
		label.setFont(new Font("굴림", Font.PLAIN, 17));
		label.setHorizontalAlignment(SwingConstants.CENTER);
		panel_9.add(label);
		
		textField = new JTextField();
		textField.setColumns(10);
		panel_9.add(textField);
		
		JPanel panel_10 = new JPanel();
		panel_15.add(panel_10);
		panel_10.setLayout(new FlowLayout(FlowLayout.RIGHT, 20, 5));
		
		JLabel label_1 = new JLabel("이벤트 명");
		label_1.setFont(new Font("굴림", Font.PLAIN, 17));
		label_1.setHorizontalAlignment(SwingConstants.CENTER);
		panel_10.add(label_1);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		panel_10.add(textField_1);
		
		JPanel panel_14 = new JPanel();
		panel_15.add(panel_14);
		panel_14.setLayout(new FlowLayout(FlowLayout.RIGHT, 10, 5));
		
		JLabel label_2 = new JLabel("이벤트 할인율");
		label_2.setHorizontalAlignment(SwingConstants.CENTER);
		label_2.setFont(new Font("굴림", Font.PLAIN, 17));
		panel_14.add(label_2);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		panel_14.add(textField_2);
		
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
		이벤트관리.add(panel_1, BorderLayout.SOUTH);
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
		이벤트관리.add(panel_3, BorderLayout.NORTH);
		panel_3.setLayout(new BoxLayout(panel_3, BoxLayout.X_AXIS));
	}

}
