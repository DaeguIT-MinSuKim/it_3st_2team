package kr.or.dgit.it_3st_2team.ui;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;

import kr.or.dgit.it_3st_2team.dto.Customer;
import kr.or.dgit.it_3st_2team.service.CustomerService;

import java.awt.FlowLayout;
import java.util.List;

import javax.swing.JTable;

public class EnrollFrameSearchCustomer extends JFrame {

	private JPanel contentPane;
	private JTable table;
	private JScrollPane scollPane;
	private String[] columnType= {"고객번호","고객명"};

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					EnrollFrameSearchCustomer frame = new EnrollFrameSearchCustomer();
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
	public EnrollFrameSearchCustomer() {
		initComponents();
	}
	private void initComponents() {
		setTitle("고객 검색");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		List<Customer> lists = null;
		CustomerService service = new CustomerService();
		lists = service.selectAllCustomer();
		Object[][] data = getRows(lists);
		table = new JTable(data, columnType);
		scollPane = new JScrollPane(table);
		contentPane.add(table);
		
		table.setPreferredScrollableViewportSize(new Dimension(300, 500));
		table.setFillsViewportHeight(true);
	}
	
	public Object[][] getRows(List<Customer> list){
		Object[][] rows=null;
		rows=new Object[list.size()][];
		for(int i=0; i<list.size(); i++) {
			rows[i]=list.get(i).toArray();
		}
		return rows;
	}

}
