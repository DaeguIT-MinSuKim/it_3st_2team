package kr.or.dgit.it_3st_2team.ui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;

import kr.or.dgit.it_3st_2team.dto.Address;
import kr.or.dgit.it_3st_2team.service.AddressService;

import javax.swing.JLabel;
import javax.swing.JComboBox;
import java.awt.FlowLayout;
import javax.swing.JTextField;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import java.awt.ScrollPane;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.swing.JScrollPane;
import javax.swing.JTable;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.table.DefaultTableModel;

public class AddressJFrame extends JFrame implements ActionListener {

	private JPanel contentPane;
	private JTextField tfDoro;
	private JTextField tfAddr1;
	private JTextField tfAddr2;
	private JTable table;
	private JComboBox cmbSido;
	private JComboBox cmbSigungu;
	private AddressService aservice;
	private List<Address> siDo;
	private JButton btnSearchDoro;
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
		initComponents();
	}
	private void initComponents() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 594, 384);
		contentPane = new JPanel();
		contentPane.setBorder(new TitledBorder(null, "\uC8FC\uC18C", TitledBorder.LEADING, TitledBorder.TOP, null, null));
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
		
		for(int i =0;i<add.length;i++) {
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
		
		JPanel pCenter = new JPanel();
		contentPane.add(pCenter, BorderLayout.CENTER);
		pCenter.setLayout(new BorderLayout(0, 0));
		
		JPanel panel = new JPanel();
		pCenter.add(panel);
		panel.setLayout(new BorderLayout(0, 0));
		
		JScrollPane scrollPane = new JScrollPane();
		panel.add(scrollPane, BorderLayout.CENTER);
		
		table = new JTable();
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"New column"
			}
		));
		scrollPane.setViewportView(table);
	}

	public void actionPerformed(ActionEvent e) {
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
		
		for(int i =0;i<add.length;i++) {
			add[i] = list.get(i).getSigungu();
		}
		DefaultComboBoxModel<String> aModel = new DefaultComboBoxModel<>(add);
		cmbSigungu.setModel(aModel);
	}
	protected void actionPerformedBtnSearchDoro(ActionEvent e) {
		String sido = (String) cmbSido.getSelectedItem();
		String sigungu = (String) cmbSigungu.getSelectedItem();
		String doro = tfDoro.getText().trim();
		
		Map<String,Object> map = new HashMap<>();	
		map.put("sido", sido);
		map.put("sigungu", sigungu);
		map.put("doro", doro+"%");
		List<Address> list = aservice.SelectDoro(map);
		
	}
}
