package kr.or.dgit.it_3st_2team.ui;

import java.awt.Container;
import java.awt.EventQueue;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BoxLayout;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import kr.or.dgit.it_3st_2team.dto.Sale;

public class EnrollFrame extends JFrame implements ActionListener {

	private JPanel contentPane;
	private JTextField tfNo;
	private JTextField textField_1;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_6;
	private JTextField textField_7;
	private JTextField textField_5;
	private JRadioButton rdbtnNewRadioButton;
	private JPanel pnlCase1;
	private JRadioButton rdbtnNewRadioButton_1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					EnrollFrame frame = new EnrollFrame();
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
	public EnrollFrame() {
		initComponents();
	}
	private void initComponents() {
		setTitle("헤어주문");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 477, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new BoxLayout(contentPane, BoxLayout.Y_AXIS));
		
		JPanel panel = new JPanel();
		contentPane.add(panel);
		panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
		
		JPanel panel_2 = new JPanel();
		panel.add(panel_2);
		panel_2.setLayout(new GridLayout(0, 6, 0, 0));
		
		JLabel lblNewLabel = new JLabel("order no :");
		panel_2.add(lblNewLabel);
		
		tfNo = new JTextField();
		tfNo.setEditable(false);
		tfNo.setEnabled(false);
		tfNo.setFocusable(false);
		panel_2.add(tfNo);
		tfNo.setColumns(10);
		int orderNum=-1;
		Sale sale = new Sale();
		tfNo.setText(Integer.toString(orderNum));
		
		JPanel panel_3 = new JPanel();
		panel.add(panel_3);
		panel_3.setLayout(new GridLayout(0, 6, 0, 0));
		
		JLabel lblSal = new JLabel("order date :");
		panel_3.add(lblSal);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		panel_3.add(textField_1);
		
		JLabel lblNewLabel_5 = new JLabel("");
		panel_3.add(lblNewLabel_5);
		
		JLabel lblOrderTime = new JLabel("order time :");
		panel_3.add(lblOrderTime);
		
		textField_3 = new JTextField();
		textField_3.setColumns(10);
		panel_3.add(textField_3);
		
		JPanel panel_4 = new JPanel();
		panel.add(panel_4);
		panel_4.setLayout(new GridLayout(0, 5, 0, 0));
		
		JLabel lblCustomerName = new JLabel("customer :");
		panel_4.add(lblCustomerName);
		
		JButton btnNewButton = new JButton("Search");
		btnNewButton.setFocusable(false);
		panel_4.add(btnNewButton);
		
		JLabel lblNewLabel_7 = new JLabel("선택된 고객 :");
		panel_4.add(lblNewLabel_7);
		
		textField_4 = new JTextField();
		textField_4.setEditable(false);
		textField_4.setFocusable(false);
		panel_4.add(textField_4);
		textField_4.setColumns(10);
		
		JPanel panel_5 = new JPanel();
		panel.add(panel_5);
		panel_5.setLayout(new GridLayout(0, 2, 0, 0));
		
		JPanel panel_9 = new JPanel();
		panel_5.add(panel_9);
		panel_9.setLayout(new GridLayout(0, 2, 0, 0));
		
		JLabel lblNewLabel_1 = new JLabel("hair service :");
		panel_9.add(lblNewLabel_1);
		
		JButton btnNewButton_1 = new JButton("Search");
		btnNewButton_1.setFocusable(false);
		panel_9.add(btnNewButton_1);
		
		JPanel panel_10 = new JPanel();
		panel_5.add(panel_10);
		panel_10.setLayout(new BoxLayout(panel_10, BoxLayout.X_AXIS));
		
		textField_5 = new JTextField();
		textField_5.setEditable(false);
		textField_5.setFocusable(false);
		panel_10.add(textField_5);
		textField_5.setColumns(10);
		
		JPanel panel_6 = new JPanel();
		panel.add(panel_6);
		panel_6.setLayout(new GridLayout(0, 4, 0, 0));
		
		JLabel lblNewLabel_2 = new JLabel("event :");
		panel_6.add(lblNewLabel_2);
		
		JComboBox comboBox = new JComboBox();
		panel_6.add(comboBox);
		
		JLabel lblNewLabel_3 = new JLabel("discount :");
		panel_6.add(lblNewLabel_3);
		
		textField_6 = new JTextField();
		textField_6.setEditable(false);
		panel_6.add(textField_6);
		textField_6.setColumns(10);
		
		JPanel panel_7 = new JPanel();
		panel.add(panel_7);
		panel_7.setLayout(new FlowLayout(FlowLayout.RIGHT, 5, 5));
		
		JLabel lblNewLabel_4 = new JLabel("price :");
		panel_7.add(lblNewLabel_4);
		
		textField_7 = new JTextField();
		textField_7.setEditable(false);
		panel_7.add(textField_7);
		textField_7.setColumns(10);
		
		JPanel panel_8 = new JPanel();
		FlowLayout flowLayout = (FlowLayout) panel_8.getLayout();
		flowLayout.setAlignment(FlowLayout.RIGHT);
		panel.add(panel_8);
		
		JButton btnNewButton_2 = new JButton("add");
		panel_8.add(btnNewButton_2);
		
		JButton btnNewButton_3 = new JButton("cancel");
		panel_8.add(btnNewButton_3);
		
		JPanel panel_1 = new JPanel();
		contentPane.add(panel_1);
		panel_1.setLayout(new BoxLayout(panel_1, BoxLayout.X_AXIS));
		
		JPanel panel_11 = new JPanel();
		panel_1.add(panel_11);
		panel_11.setLayout(new GridLayout(0, 7, 0, 0));
		
		JLabel lblNewLabel_6 = new JLabel("검색기준 :");
		panel_11.add(lblNewLabel_6);
		
		rdbtnNewRadioButton = new JRadioButton("기간별");
		rdbtnNewRadioButton.addActionListener(this);
		panel_11.add(rdbtnNewRadioButton);
		
		rdbtnNewRadioButton_1 = new JRadioButton("고객별");
		rdbtnNewRadioButton_1.addActionListener(this);
		panel_11.add(rdbtnNewRadioButton_1);
		
		JPanel panel_13 = new JPanel();
		contentPane.add(panel_13);
		panel_13.setLayout(new BoxLayout(panel_13, BoxLayout.X_AXIS));
		
		pnlCase1 = new JPanel();
		contentPane.add(pnlCase1);
		
		ButtonGroup group = new ButtonGroup();
		group.add(rdbtnNewRadioButton);
		group.add(rdbtnNewRadioButton_1);
	}

	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == rdbtnNewRadioButton_1) {
			actionPerformedRdbtnNewRadioButton_1(e);
		}
		if (e.getSource() == rdbtnNewRadioButton) {
			actionPerformedRdbtnNewRadioButton(e);
		}
	}
	protected void actionPerformedRdbtnNewRadioButton(ActionEvent e) {
		Container cp = getContentPane();
		cp.revalidate();
		cp.repaint();
		cp.invalidate();
		EnrollSearchCase1 case1 = new EnrollSearchCase1();
		pnlCase1.removeAll();
		pnlCase1.add(case1);
	}
	protected void actionPerformedRdbtnNewRadioButton_1(ActionEvent e) {
		Container cp = getContentPane();
		cp.revalidate();
		cp.repaint();
		EnrollSearchCase2 case2 = new EnrollSearchCase2();
		pnlCase1.removeAll();
		pnlCase1.add(case2);
	}
}
