package kr.or.dgit.it_3st_2team.ui;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.JTextField;

public class EnrollSearchCase1 extends JPanel {
	private JTextField textField;
	private JTextField textField_1;
	private JTable table;

	/**
	 * Create the panel.
	 */
	public EnrollSearchCase1() {

		initComponents();
	}
	private void initComponents() {
		setLayout(new BorderLayout(0, 0));
		
		JPanel panel = new JPanel();
		add(panel, BorderLayout.NORTH);
		panel.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		JLabel lblNewLabel = new JLabel("날짜 :");
		panel.add(lblNewLabel);
		
		JPanel panel_2 = new JPanel();
		panel.add(panel_2);
		
		textField = new JTextField();
		panel_2.add(textField);
		textField.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("~");
		panel_2.add(lblNewLabel_1);
		
		textField_1 = new JTextField();
		panel_2.add(textField_1);
		textField_1.setColumns(10);
		
		JButton btnNewButton = new JButton("검색");
		panel.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("취소");
		panel.add(btnNewButton_1);
		
		JPanel panel_1 = new JPanel();
		add(panel_1, BorderLayout.CENTER);
		
		table = new JTable();
		panel_1.add(table);
	}

}
