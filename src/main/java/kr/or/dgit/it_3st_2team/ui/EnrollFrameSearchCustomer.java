package kr.or.dgit.it_3st_2team.ui;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import kr.or.dgit.it_3st_2team.dto.Customer;
import kr.or.dgit.it_3st_2team.service.CustomerService;

import java.awt.FlowLayout;
import java.awt.Desktop.Action;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.List;

import javax.swing.JTable;

public class EnrollFrameSearchCustomer extends JFrame {

	private JPanel contentPane;
	private JTable table;
	private JScrollPane scollPane;
	private String[] columnType= {"고객번호","고객명"};
	//private DefaultTableModel model = new DefaultTableModel(columnType, 0);
	private NonEditableModel model;
	private String cusName;
	
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
		//table = new JTable(data, columnType);
		
		model = new NonEditableModel(data, columnType);
		table = new JTable(model);
		//table.setModel(model);
		scollPane = new JScrollPane(table);
		contentPane.add(table);
		
		table.setPreferredScrollableViewportSize(new Dimension(300, 500));
		table.setFillsViewportHeight(true);
		
		table.addMouseListener(new MyMouseListener());
	}
	
	private class MyMouseListener extends MouseAdapter{
		public void mouseClicked(MouseEvent e) {
			if(e.getClickCount()==1) { //더블클릭 처리안됨 khj
				int row = table.getSelectedRow();
				int column = table.getSelectedColumn();
				//System.out.println(model.getValueAt(row, 1));
				String str = model.getValueAt(row, 1).toString();
				System.out.println(str);
				cusName = str;
				//Customer customer = new Customer();
			}
		}
	}
	
	class NonEditableModel extends DefaultTableModel{
		public NonEditableModel(Object[][] data, Object[] columnNames) {
			super(data, columnNames);
		}

		@Override
		public boolean isCellEditable(int row, int column) {
			return false;
		}
		
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
