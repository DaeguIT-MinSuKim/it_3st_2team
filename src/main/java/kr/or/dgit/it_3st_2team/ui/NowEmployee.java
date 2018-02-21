package kr.or.dgit.it_3st_2team.ui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.GridLayout;
import java.awt.FlowLayout;
import javax.swing.JButton;
import javax.swing.JTree;
import javax.swing.JSpinner;
import javax.swing.JToggleButton;
import javax.swing.JTable;
import javax.swing.JLabel;
import javax.swing.JCheckBox;
import javax.swing.border.BevelBorder;
import javax.swing.border.LineBorder;
import java.awt.Color;
import javax.swing.border.MatteBorder;

public class NowEmployee extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					NowEmployee frame = new NowEmployee();
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
	public NowEmployee() {
		initComponents();
	}
	private void initComponents() {
		setTitle("직원현황");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		
		JPanel panel = new JPanel();
		contentPane.add(panel, BorderLayout.CENTER);
		panel.setLayout(new GridLayout(0, 6, 0, 0));
		
		JPanel panel_3 = new JPanel();
		panel_3.setBorder(new MatteBorder(1, 1, 1, 0, (Color) new Color(0, 0, 0)));
		panel.add(panel_3);
		panel_3.setLayout(new BorderLayout(0, 0));
		
		JPanel panel_9 = new JPanel();
		panel_9.setBorder(new MatteBorder(0, 0, 1, 0, (Color) new Color(0, 0, 0)));
		panel_3.add(panel_9, BorderLayout.NORTH);
		
		JLabel lblNewLabel = new JLabel("직원번호");
		panel_9.add(lblNewLabel);
		
		JPanel panel_10 = new JPanel();
		panel_3.add(panel_10, BorderLayout.CENTER);
		panel_10.setLayout(new GridLayout(5, 2, 0, 0));
		
		JPanel panel_21 = new JPanel();
		panel_10.add(panel_21);
		panel_21.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		JCheckBox chckbxNewCheckBox = new JCheckBox("");
		panel_21.add(chckbxNewCheckBox);
		
		JLabel lblNewLabel_1 = new JLabel("1");
		panel_21.add(lblNewLabel_1);
		
		JPanel panel_22 = new JPanel();
		panel_10.add(panel_22);
		panel_22.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		JCheckBox checkBox = new JCheckBox("");
		panel_22.add(checkBox);
		
		JLabel label_5 = new JLabel("2");
		panel_22.add(label_5);
		
		JPanel panel_23 = new JPanel();
		panel_10.add(panel_23);
		panel_23.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		JCheckBox checkBox_1 = new JCheckBox("");
		panel_23.add(checkBox_1);
		
		JLabel label_6 = new JLabel("3");
		panel_23.add(label_6);
		
		JPanel panel_24 = new JPanel();
		panel_10.add(panel_24);
		panel_24.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		JCheckBox checkBox_2 = new JCheckBox("");
		panel_24.add(checkBox_2);
		
		JLabel label_7 = new JLabel("4");
		panel_24.add(label_7);
		
		JPanel panel_25 = new JPanel();
		panel_10.add(panel_25);
		panel_25.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		JCheckBox checkBox_3 = new JCheckBox("");
		panel_25.add(checkBox_3);
		
		JLabel label_8 = new JLabel("5");
		panel_25.add(label_8);
		
		JPanel panel_4 = new JPanel();
		panel_4.setBorder(new MatteBorder(1, 1, 1, 0, (Color) new Color(0, 0, 0)));
		panel.add(panel_4);
		panel_4.setLayout(new BorderLayout(0, 0));
		
		JPanel panel_11 = new JPanel();
		panel_11.setBorder(new MatteBorder(0, 0, 1, 0, (Color) new Color(0, 0, 0)));
		panel_4.add(panel_11, BorderLayout.NORTH);
		
		JLabel label = new JLabel("이름");
		panel_11.add(label);
		
		JPanel panel_16 = new JPanel();
		panel_4.add(panel_16, BorderLayout.CENTER);
		panel_16.setLayout(new GridLayout(5, 0, 0, 0));
		
		JPanel panel_5 = new JPanel();
		panel_5.setBorder(new MatteBorder(1, 1, 1, 0, (Color) new Color(0, 0, 0)));
		panel.add(panel_5);
		panel_5.setLayout(new BorderLayout(0, 0));
		
		JPanel panel_12 = new JPanel();
		panel_12.setBorder(new MatteBorder(0, 0, 1, 0, (Color) new Color(0, 0, 0)));
		panel_5.add(panel_12, BorderLayout.NORTH);
		
		JLabel label_1 = new JLabel("입사일");
		panel_12.add(label_1);
		
		JPanel panel_17 = new JPanel();
		panel_5.add(panel_17, BorderLayout.CENTER);
		panel_17.setLayout(new GridLayout(5, 0, 0, 0));
		
		JPanel panel_6 = new JPanel();
		panel_6.setBorder(new MatteBorder(1, 1, 1, 0, (Color) new Color(0, 0, 0)));
		panel.add(panel_6);
		panel_6.setLayout(new BorderLayout(0, 0));
		
		JPanel panel_13 = new JPanel();
		panel_13.setBorder(new MatteBorder(0, 0, 1, 0, (Color) new Color(0, 0, 0)));
		panel_6.add(panel_13, BorderLayout.NORTH);
		
		JLabel label_2 = new JLabel("아이디");
		panel_13.add(label_2);
		
		JPanel panel_18 = new JPanel();
		panel_6.add(panel_18, BorderLayout.CENTER);
		panel_18.setLayout(new GridLayout(5, 0, 0, 0));
		
		JPanel panel_7 = new JPanel();
		panel_7.setBorder(new MatteBorder(1, 1, 1, 0, (Color) new Color(0, 0, 0)));
		panel.add(panel_7);
		panel_7.setLayout(new BorderLayout(0, 0));
		
		JPanel panel_14 = new JPanel();
		panel_14.setBorder(new MatteBorder(0, 0, 1, 0, (Color) new Color(0, 0, 0)));
		panel_7.add(panel_14, BorderLayout.NORTH);
		
		JLabel label_3 = new JLabel("패스워드");
		panel_14.add(label_3);
		
		JPanel panel_19 = new JPanel();
		panel_7.add(panel_19, BorderLayout.CENTER);
		panel_19.setLayout(new GridLayout(5, 0, 0, 0));
		
		JPanel panel_8 = new JPanel();
		panel_8.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)));
		panel.add(panel_8);
		panel_8.setLayout(new BorderLayout(0, 0));
		
		JPanel panel_15 = new JPanel();
		panel_15.setBorder(new MatteBorder(0, 0, 1, 0, (Color) new Color(0, 0, 0)));
		panel_8.add(panel_15, BorderLayout.NORTH);
		
		JLabel label_4 = new JLabel("직책");
		panel_15.add(label_4);
		
		JPanel panel_20 = new JPanel();
		panel_8.add(panel_20, BorderLayout.CENTER);
		panel_20.setLayout(new GridLayout(5, 0, 0, 0));
		
		JPanel panel_1 = new JPanel();
		contentPane.add(panel_1, BorderLayout.NORTH);
		panel_1.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		JPanel panel_2 = new JPanel();
		panel_1.add(panel_2);
		
		JButton btnNewButton = new JButton("등록");
		panel_2.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("삭제");
		panel_2.add(btnNewButton_1);
	}

}
