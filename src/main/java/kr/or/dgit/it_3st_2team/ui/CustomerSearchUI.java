package kr.or.dgit.it_3st_2team.ui;

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

import kr.or.dgit.it_3st_2team.dto.Customer;
import kr.or.dgit.it_3st_2team.service.CustomerService;

//khj 2018-02-26
public class CustomerSearchUI extends JFrame {

	private JPanel contentPane;
	private JTable table;
	private CustomerService service;
	private EnrollFrame enrollFrame;
	private NonEditableModel model;

	public CustomerSearchUI(EnrollFrame frame) {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new FlowLayout(FlowLayout.CENTER));
		setContentPane(contentPane);
		
		setTitle("고객찾기");
		JButton btnOk = new JButton("등록");
		contentPane.add(btnOk);
		btnOk.addMouseListener(new MyMouseListener());
		
		String[] columnType = new String[] {"고객번호","고객명"};
		service = new CustomerService();
		List<Customer> lists = service.selectAllCustomer();
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
				String name = model.getValueAt(row, 1).toString();
				enrollFrame.setTfSelectedCus(name);
				int no = (int) model.getValueAt(row, 0);
				enrollFrame.setTfCusNo(no);
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

	public String[] getColumNames() {
		return new String[] {"고객번호", "고객명"};
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
}
