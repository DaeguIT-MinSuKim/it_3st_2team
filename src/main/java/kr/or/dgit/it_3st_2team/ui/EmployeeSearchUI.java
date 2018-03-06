package kr.or.dgit.it_3st_2team.ui;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.FlowLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;

import kr.or.dgit.it_3st_2team.dto.Customer;
import kr.or.dgit.it_3st_2team.dto.Employee;
import kr.or.dgit.it_3st_2team.service.EmployeeService;
import kr.or.dgit.it_3st_2team.ui.CustomerSearchUI.NonEditableModel;
import kr.or.dgit.it_3st_2team.ui.CustomerSearchUI.TableMouseListener;

import javax.swing.JScrollPane;

//khj 2018-02-26
public class EmployeeSearchUI extends JFrame {

	private JPanel contentPane;
	private EmployeeService service;
	private EnrollPanel enrollPanel;
	private NonEditableModel model;
	private JPanel panel_1;
	private JPanel panel_2;
	private JScrollPane scrollPane;
	private JTable table;
	private List<Employee> lists;

	public EmployeeSearchUI(EnrollPanel panel) {
		enrollPanel = panel;
		service = new EmployeeService();
		initComponents();
	}
	private void initComponents() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 350, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		setTitle("직원찾기");
		contentPane.setLayout(new BorderLayout(0, 0));
		
		panel_1 = new JPanel();
		contentPane.add(panel_1, BorderLayout.CENTER);
		panel_1.setLayout(new BorderLayout(0, 0));
		
		scrollPane = new JScrollPane();
		table = new JTable();
//		scrollPane.setViewportView(table);
		panel_1.add(scrollPane, BorderLayout.CENTER);
		table.addMouseListener(new TableMouseListener());
		
		lists = service.selectAllEmployee();
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
				enrollPanel.setTfSelectedEmp(String.format("%s(%d)", name,no));
				enrollPanel.setTfEmpNo(no);
				setVisible(false);
			}
		}		
	}
	
	private void drawTable(List<Employee> lists) {
		String[] columnType = new String[] {"직원번호","직원명"};
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
				enrollPanel.setTfSelectedEmp(String.format("%s(%d)", name,no));
				enrollPanel.setTfEmpNo(no);
				setVisible(false);
			}
		}
	}
	
	public Object[][] getRows(List<Employee> list){
		Object[][] rows = null;

		rows = new Object[list.size()][];
		for (int i = 0; i < list.size(); i++) {
			rows[i] = list.get(i).toArrayNoandName();
		}

		return rows;
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
	
	public void setAlignWidth() {
		tableCellAlign(SwingConstants.CENTER, 0, 1);
		tableCellWidth(30, 100);
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
