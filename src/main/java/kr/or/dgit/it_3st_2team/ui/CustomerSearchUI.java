package kr.or.dgit.it_3st_2team.ui;

import java.awt.FlowLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;

import kr.or.dgit.it_3st_2team.dto.Customer;
import kr.or.dgit.it_3st_2team.service.CustomerService;
import java.awt.BorderLayout;

//khj 180226
public class CustomerSearchUI extends JFrame {

	private JPanel contentPane;
	private CustomerService service;
	private EnrollPanel enrollPanel;
	private NonEditableModel model;
	private JPanel panel_1;
	private JPanel panel_2;
	private JScrollPane scrollPane;
	private JTable table;
	private List<Customer> lists;

	public CustomerSearchUI(EnrollPanel panel) {
		enrollPanel = panel;
		service = new CustomerService();
		initComponents();
	}
	private void initComponents() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 335, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		setTitle("고객찾기");
		contentPane.setLayout(new BorderLayout(0, 0));
		
		panel_1 = new JPanel();
		contentPane.add(panel_1, BorderLayout.CENTER);
		panel_1.setLayout(new BorderLayout(0, 0));
		
		scrollPane = new JScrollPane();
		table = new JTable();
//		scrollPane.setViewportView(table);
		panel_1.add(scrollPane);
		table.addMouseListener(new TableMouseListener());
	
//		lists = service.selectAllCustomer();
		lists = service.SelectAllCustomerEmpName(new Customer(true)); //c_tf가 1인 고객만
		drawTable(lists);
		
		panel_2 = new JPanel();
		contentPane.add(panel_2, BorderLayout.SOUTH);
		JButton btnOk = new JButton("등록");
		panel_2.add(btnOk);
		btnOk.addMouseListener(new MyMouseListener());
	}
	
	public class TableMouseListener extends MouseAdapter{

		@Override
		public void mouseClicked(MouseEvent e) { //테이블 더블클릭
			super.mouseClicked(e);
			if(e.getClickCount()==2) {
				int row = table.getSelectedRow();
				String name = table.getValueAt(row, 1).toString();
				int no = (int) table.getValueAt(row, 0);
				enrollPanel.setTfSelectedCus(String.format("%s(%d)", name,no));
				enrollPanel.setTfCusNo(no);
				setVisible(false);
			}
		}		
	}
	
	private void drawTable(List<Customer> lists) {
		String[] columnType = new String[] {"고객번호","고객명"};
		NonEditableModel neModel = new NonEditableModel(getRows(lists), columnType);
		table.setModel(neModel);
		setAlignWidth();
		scrollPane.setViewportView(table);
	}
	
	private class MyMouseListener extends MouseAdapter{
		public void mouseClicked(MouseEvent e) {
			if(table.getSelectedRow()!=-1) {
				int row = table.getSelectedRow();
				String name = table.getValueAt(row, 1).toString();
				int no = (int) table.getValueAt(row, 0);
				enrollPanel.setTfSelectedCus(String.format("%s(%d)", name,no));
				enrollPanel.setTfCusNo(no);
				setVisible(false);
			}
		}
	}

	public Object[][] getRows(List<Customer> list) {
		Object[][] rows = null;

		rows = new Object[list.size()][];
		for (int i = 0; i < list.size(); i++) {
			rows[i] = list.get(i).toArray();
		}

		return rows;
	}
	
	//테이블 내용을 수정하지 못하게 함
	class NonEditableModel extends DefaultTableModel{
		public NonEditableModel(Object[][] data, Object[] columnNames) {
			super(data, columnNames);
		}

		@Override
		public boolean isCellEditable(int row, int column) {
			return false;
		}
	}
	
	public void setAlignWidth() {
		tableCellAlign(SwingConstants.CENTER, 0, 1);
		tableCellWidth(50, 100);
	}
	
	protected void tableCellAlign(int align, int... idx) {
		DefaultTableCellRenderer dtcr = new DefaultTableCellRenderer();
		dtcr.setHorizontalAlignment(align);

		TableColumnModel model = table.getColumnModel();
		for (int i = 0; i < idx.length; i++) {
			model.getColumn(idx[i]).setCellRenderer(dtcr);
		}
	}

	protected void tableCellWidth(int... width) {
		TableColumnModel model = table.getColumnModel();
		for (int i = 0; i < width.length; i++) {
			model.getColumn(i).setPreferredWidth(width[i]);
		}
	}
}
