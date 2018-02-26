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
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import kr.or.dgit.it_3st_2team.dto.Employee;
import kr.or.dgit.it_3st_2team.service.EmployeeService;

//khj
public class EmployeeSearchUI extends JFrame {

	private JPanel contentPane;
	private JTable table;
	private EmployeeService service;
	private EnrollFrame enrollFrame;
	private NonEditableModel model;

	public EmployeeSearchUI(EnrollFrame frame) {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new FlowLayout(FlowLayout.CENTER));
		setContentPane(contentPane);
		
		setTitle("직원찾기");
		JButton btnOk = new JButton("등록");
		contentPane.add(btnOk);
		btnOk.addMouseListener(new MyMouseListener());
		
		String[] columnType = new String[] {"직원번호","직원명"};
		service = new EmployeeService();
		List<Employee> lists = service.selectAllEmployee();
		Object[][] data = getRows(lists);
		model = new NonEditableModel(data, columnType);
		table = new JTable(model);
		contentPane.add(table);
		
		enrollFrame = frame;
		
	}
	private class MyMouseListener extends MouseAdapter{
		public void mouseClicked(MouseEvent e) {
			if(e.getClickCount()==1) { //더블클릭 처리안됨 khj
				int row = table.getSelectedRow();
				String str = model.getValueAt(row, 1).toString();
				enrollFrame.setTfSelectedEmp(str);
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
}
