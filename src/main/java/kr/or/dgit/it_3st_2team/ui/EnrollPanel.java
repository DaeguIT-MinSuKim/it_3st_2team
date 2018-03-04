package kr.or.dgit.it_3st_2team.ui;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
//khj EnrollFrame 쓸 예정
public class EnrollPanel extends JPanel {
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;
	private JTextField textField_6;

	/**
	 * Create the panel.
	 */
	public EnrollPanel() {

		initComponents();
	}
	private void initComponents() {
		setLayout(new GridLayout(1, 1, 0, 0));
		
		JPanel panel_2 = new JPanel();
		panel_2.setPreferredSize(new Dimension(10, 500));
		add(panel_2);
		panel_2.setLayout(new GridLayout(7, 1, 0, 0));
		
		JPanel panel_3 = new JPanel();
		panel_2.add(panel_3);
		panel_3.setLayout(new GridLayout(0, 4, 0, 0));
		
		JLabel lblNewLabel_1 = new JLabel("영업번호");
		panel_3.add(lblNewLabel_1);
		
		textField = new JTextField();
		panel_3.add(textField);
		textField.setColumns(10);
		
		JLabel lblNewLabel_4 = new JLabel("");
		panel_3.add(lblNewLabel_4);
		
		JLabel lblNewLabel_5 = new JLabel("");
		panel_3.add(lblNewLabel_5);
		
		JPanel panel_4 = new JPanel();
		panel_2.add(panel_4);
		panel_4.setLayout(new GridLayout(0, 4, 0, 0));
		
		JLabel label = new JLabel("방문일자");
		panel_4.add(label);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		panel_4.add(textField_1);
		
		JLabel lblNewLabel_3 = new JLabel("방문시간");
		panel_4.add(lblNewLabel_3);
		
		textField_2 = new JTextField();
		panel_4.add(textField_2);
		textField_2.setColumns(10);
		
		JPanel panel_1 = new JPanel();
		panel_2.add(panel_1);
		panel_1.setLayout(new GridLayout(0, 4, 0, 0));
		
		JLabel lblNewLabel_2 = new JLabel("고객명");
		panel_1.add(lblNewLabel_2);
		
		textField_3 = new JTextField();
		panel_1.add(textField_3);
		textField_3.setColumns(10);
		
		JButton btnNewButton_1 = new JButton("선택");
		panel_1.add(btnNewButton_1);
		
		JLabel lblNewLabel_6 = new JLabel("");
		panel_1.add(lblNewLabel_6);
		
		JPanel panel_5 = new JPanel();
		panel_2.add(panel_5);
		panel_5.setLayout(new GridLayout(0, 4, 0, 0));
		
		JLabel lblNewLabel_7 = new JLabel("헤어명");
		panel_5.add(lblNewLabel_7);
		
		JButton btnNewButton = new JButton("선택");
		panel_5.add(btnNewButton);
		
		textField_4 = new JTextField();
		panel_5.add(textField_4);
		textField_4.setColumns(10);
		
		JLabel lblNewLabel_8 = new JLabel("");
		panel_5.add(lblNewLabel_8);
		
		JPanel panel_6 = new JPanel();
		panel_2.add(panel_6);
		panel_6.setLayout(new GridLayout(0, 4, 0, 0));
		
		JLabel lblNewLabel_9 = new JLabel("이벤트명");
		panel_6.add(lblNewLabel_9);
		
		JComboBox comboBox = new JComboBox();
		panel_6.add(comboBox);
		
		JLabel lblNewLabel_10 = new JLabel("할인율");
		panel_6.add(lblNewLabel_10);
		
		textField_5 = new JTextField();
		panel_6.add(textField_5);
		textField_5.setColumns(10);
		
		JPanel panel = new JPanel();
		FlowLayout flowLayout = (FlowLayout) panel.getLayout();
		flowLayout.setAlignment(FlowLayout.RIGHT);
		panel_2.add(panel);
		
		JLabel lblNewLabel = new JLabel("금액 :");
		panel.add(lblNewLabel);
		
		textField_6 = new JTextField();
		panel.add(textField_6);
		textField_6.setColumns(10);
		
		JPanel panel_7 = new JPanel();
		FlowLayout flowLayout_1 = (FlowLayout) panel_7.getLayout();
		flowLayout_1.setAlignment(FlowLayout.RIGHT);
		panel_2.add(panel_7);
		
		JButton btnNewButton_2 = new JButton("add");
		panel_7.add(btnNewButton_2);
		
		JButton btnNewButton_3 = new JButton("cancel");
		panel_7.add(btnNewButton_3);
	}

}
