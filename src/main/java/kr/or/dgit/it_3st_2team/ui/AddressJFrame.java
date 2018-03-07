package kr.or.dgit.it_3st_2team.ui;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;

import kr.or.dgit.it_3st_2team.dto.Address;
import kr.or.dgit.it_3st_2team.service.AddressService;

/*yyj*/
public class AddressJFrame extends JFrame implements ActionListener, MouseListener {

	private JPanel contentPane;
	private JTextField tfDoro;
	private JTextField tfAddr1;
	private JTextField tfAddr2;
	private JComboBox cmbSido;
	private JComboBox cmbSigungu;
	private AddressService aservice;
	private List<Address> siDo;
	private JButton btnSearchDoro;
	private JPanel pCenter;
	private JTable table;
	private List<Address> list;
	private JTable table_1;
	private JScrollPane scrollPane;
	private JButton btnAddrAdd;

	private CustomerJPanel cjpanel;
	private String addr1;
	private String addr2;
	private EmployeeJoin empjoin;
	private Class<? extends ActionEvent> CustomerJPanel;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AddressJFrame frame = new AddressJFrame();
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
	public AddressJFrame() {
		aservice = new AddressService();
		cjpanel = new CustomerJPanel();
		empjoin = new EmployeeJoin();
		initComponents();

	}

	public AddressJFrame(CustomerJPanel customerJPanel) {
		cjpanel = customerJPanel;
		aservice = new AddressService();
		initComponents();

	}

	public AddressJFrame(EmployeeJoin employeeJoin) {
		empjoin = employeeJoin;
		aservice = new AddressService();
		initComponents();
	}

	private void initComponents() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(800, 200, 594, 384);
		contentPane = new JPanel();
		contentPane
				.setBorder(new TitledBorder(null, "\uC8FC\uC18C", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);

		JPanel pNorth = new JPanel();
		contentPane.add(pNorth, BorderLayout.NORTH);
		pNorth.setLayout(new BorderLayout(0, 0));

		JPanel panel_1 = new JPanel();
		pNorth.add(panel_1, BorderLayout.WEST);
		panel_1.setLayout(new BorderLayout(0, 0));

		JPanel panel_2 = new JPanel();
		panel_1.add(panel_2, BorderLayout.NORTH);
		panel_2.setLayout(new FlowLayout(FlowLayout.LEFT, 5, 5));

		JLabel lblAddr = new JLabel("구분");
		panel_2.add(lblAddr);

		JLabel lblNewLabel_2 = new JLabel("                            ");
		panel_2.add(lblNewLabel_2);

		cmbSido = new JComboBox();

		panel_2.add(cmbSido);

		siDo = aservice.SelectSidoSql();
		String[] add = new String[siDo.size()];

		for (int i = 0; i < add.length; i++) {
			add[i] = siDo.get(i).getSido();
		}
		DefaultComboBoxModel<String> aModel = new DefaultComboBoxModel<>(add);
		cmbSido.setModel(aModel);

		cmbSido.setSelectedIndex(0);
		cmbSido.addActionListener(this);

		cmbSigungu = new JComboBox();
		cmbSigungu.addActionListener(this);
		panel_2.add(cmbSigungu);
		getSigungu();
		cmbSigungu.setSelectedIndex(0);

		JPanel panel_3 = new JPanel();
		FlowLayout flowLayout = (FlowLayout) panel_3.getLayout();
		flowLayout.setAlignment(FlowLayout.LEFT);
		panel_1.add(panel_3, BorderLayout.CENTER);

		JLabel lblDoro = new JLabel("도로명");
		panel_3.add(lblDoro);

		tfDoro = new JTextField();
		panel_3.add(tfDoro);
		tfDoro.setColumns(10);

		btnSearchDoro = new JButton("검색");
		btnSearchDoro.addActionListener(this);
		panel_3.add(btnSearchDoro);

		JPanel panel_4 = new JPanel();
		panel_1.add(panel_4, BorderLayout.SOUTH);

		JLabel lblad = new JLabel("주소");
		panel_4.add(lblad);

		tfAddr1 = new JTextField();
		panel_4.add(tfAddr1);
		tfAddr1.setColumns(20);

		tfAddr2 = new JTextField();
		panel_4.add(tfAddr2);
		tfAddr2.setColumns(15);

		btnAddrAdd = new JButton("주소 추가");
		btnAddrAdd.addActionListener(this);
		btnAddrAdd.setEnabled(false);
		panel_4.add(btnAddrAdd);

		pCenter = new JPanel();
		contentPane.add(pCenter, BorderLayout.CENTER);
		pCenter.setLayout(new BorderLayout(0, 0));

		scrollPane = new JScrollPane();
		pCenter.add(scrollPane, BorderLayout.CENTER);

		table = new JTable();
		table.addMouseListener(this);

		Map<String, Object> map = getsigungu();
		list = aservice.SelectDoro(map);
		showTables();

	}

	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnAddrAdd) {
			actionPerformedBtnAddrAdd(e);
		}
		if (e.getSource() == btnSearchDoro) {
			actionPerformedBtnSearchDoro(e);
		}
		if (e.getSource() == cmbSido) {
			actionPerformedCmbSido(e);
		}
		if (e.getSource() == cmbSigungu) {
			actionPerformedCmbSigungu(e);
		}
	}

	protected void actionPerformedCmbSigungu(ActionEvent e) {
	}

	protected void actionPerformedCmbSido(ActionEvent e) {
		getSigungu();

	}

	private void getSigungu() {
		String sido = (String) cmbSido.getSelectedItem();
		Address addr = new Address();
		addr.setSido(sido);
		List<Address> list = aservice.SelectSigunguSql(addr);
		String[] add = new String[list.size()];

		for (int i = 0; i < add.length; i++) {
			add[i] = list.get(i).getSigungu();
		}
		DefaultComboBoxModel<String> aModel = new DefaultComboBoxModel<>(add);
		cmbSigungu.setModel(aModel);
	}

	protected void actionPerformedBtnSearchDoro(ActionEvent e) {
		String doro = tfDoro.getText().trim();
		Map<String, Object> map = getsigungu();
		map.put("doro", doro + "%");
		list = aservice.SelectDoro(map);

		showTables();

	}

	private Map<String, Object> getsigungu() {
		String sido = (String) cmbSido.getSelectedItem();
		String sigungu = (String) cmbSigungu.getSelectedItem();
		Map<String, Object> map = new HashMap<>();
		map.put("sido", sido);
		map.put("sigungu", sigungu);
		return map;
	}

	private void showTables() {

		table.setModel(new DefaultTableModel(getObj(list), getColumNames()));
		NonEditableModel Nemodel = new NonEditableModel(getObj(list), getColumNames());
		table.setModel(Nemodel);
		setAlignWidth();
		scrollPane.setViewportView(table);
	}

	public void setAlignWidth() {
		// 셀의 너비와 정렬
		tableCellAlign(SwingConstants.CENTER, 0);
		tableCellAlign(SwingConstants.LEFT, 1);
		tableCellWidth(200, 700);
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

	public String[] getColumNames() {
		return new String[] { "우편 번호", "주소" };
	}

	private Object[][] getObj(List<Address> list) {
		Object[][] rows = null;

		rows = new Object[list.size()][];
		for (int i = 0; i < list.size(); i++) {
			Address cm = list.get(i);

			rows[i] = cm.toArray();
		}
		return rows;

	}

	class NonEditableModel extends DefaultTableModel {
		public NonEditableModel(Object[][] data, Object[] columnNames) {
			super(data, columnNames);
		}

		@Override
		public boolean isCellEditable(int row, int column) {
			return false;
		}
	}

	public void mouseClicked(MouseEvent e) {
		if (e.getSource() == table) {
			if (e.getClickCount() == 2) {
				mouseClickedTable(e);
			}
		}
	}

	public void mouseEntered(MouseEvent e) {
	}

	public void mouseExited(MouseEvent e) {
	}

	public void mousePressed(MouseEvent e) {
	}

	public void mouseReleased(MouseEvent e) {
	}

	protected void mouseClickedTable(MouseEvent e) {
		int row = table.getSelectedRow();
		String addr1 = (String) (table.getValueAt(row, 1));
		tfAddr1.setText(addr1);
		btnAddrAdd.setEnabled(true);
		tfAddr2.setFocusable(true);
		tfAddr2.requestFocus();

	}

	protected void actionPerformedBtnAddrAdd(ActionEvent e) {
		addr1 = tfAddr1.getText();
		addr2 = tfAddr2.getText();
		
		if(e.getClass()==CustomerJPanel) {
			cjpanel.setTfaddr(addr1 + " " + addr2);
			setVisible(false);
			return;

		}else {
			empjoin.setaddr(addr1 + " " + addr2);
			setVisible(false);
			return;
		}
		
	}
}
