package kr.or.dgit.it_3st_2team.ui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import java.awt.FlowLayout;
import javax.swing.JTable;
import java.awt.GridLayout;
import javax.swing.JSpinner;
import javax.swing.JComboBox;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JTextField;

public class SearchAddressFrame extends JFrame {

	private JPanel contentPane;
	private JTable table;
	private JTextField textField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SearchAddressFrame frame = new SearchAddressFrame();
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
	public SearchAddressFrame() {
		initComponents();
	}
	private void initComponents() {
		setTitle("주소 검색");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		
		JPanel panel = new JPanel();
		contentPane.add(panel, BorderLayout.NORTH);
		panel.setLayout(new GridLayout(2, 4, 0, 0));
		
		JLabel lblNewLabel = new JLabel("시도선택");
		panel.add(lblNewLabel);
		
		JComboBox comboBox = new JComboBox();
		panel.add(comboBox);
		
		JLabel lblNewLabel_1 = new JLabel("시군구");
		panel.add(lblNewLabel_1);
		
		JComboBox comboBox_1 = new JComboBox();
		panel.add(comboBox_1);
		
		JLabel lblNewLabel_2 = new JLabel("검색어");
		panel.add(lblNewLabel_2);
		
		textField = new JTextField();
		panel.add(textField);
		textField.setColumns(10);
		
		JButton btnNewButton = new JButton("검색");
		panel.add(btnNewButton);
		
		table = new JTable();
		contentPane.add(table, BorderLayout.SOUTH);
	}
}
