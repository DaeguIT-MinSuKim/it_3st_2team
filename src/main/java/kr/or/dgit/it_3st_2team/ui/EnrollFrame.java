package kr.or.dgit.it_3st_2team.ui;

import java.awt.Container;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.HashMap;
import java.util.List;

import javax.swing.BoxLayout;
import javax.swing.ButtonGroup;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import kr.or.dgit.it_3st_2team.dto.Customer;
import kr.or.dgit.it_3st_2team.dto.Event;
import kr.or.dgit.it_3st_2team.dto.Hair;
import kr.or.dgit.it_3st_2team.dto.Sale;
import kr.or.dgit.it_3st_2team.service.CustomerService;
import kr.or.dgit.it_3st_2team.service.EventService;
import kr.or.dgit.it_3st_2team.service.HairService;
import kr.or.dgit.it_3st_2team.service.SaleService;

public class EnrollFrame extends JFrame implements ActionListener {

	private JPanel contentPane;
	private JTextField tfNo;
	private JTextField tfDate;
	private JTextField tfTime;
	private JTextField tfSelectedCus;
	private JTextField tfDiscount;
	private JRadioButton rdbtnNewRadioButton;
	private JPanel pnlCase1;
	private JRadioButton rdbtnNewRadioButton_1;
	private JTextField tfPrice;
	private JButton btnSearch;
	private JComboBox<String> cmbEvent;
	private HashMap<String, Float> mapEvent;
	private HashMap<String, Integer> mapHair;
	private JList<String> listHair;

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
		setBounds(100, 100, 477, 377);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new BoxLayout(contentPane, BoxLayout.Y_AXIS));
		
		JPanel pnl1 = new JPanel();
		contentPane.add(pnl1);
		pnl1.setLayout(new BoxLayout(pnl1, BoxLayout.Y_AXIS));
		
		JPanel pnl1_1 = new JPanel();
		pnl1.add(pnl1_1);
		pnl1_1.setLayout(new GridLayout(0, 6, 0, 0));
		
		JLabel lblNo = new JLabel("order no :");
		pnl1_1.add(lblNo);
		
		tfNo = new JTextField();
		tfNo.setEditable(false);
		tfNo.setEnabled(false);
		tfNo.setFocusable(false);
		pnl1_1.add(tfNo);
		tfNo.setColumns(10);
		int orderNum=-1;
		Sale sale = new Sale();
		SaleService service = new SaleService();
		orderNum=service.getPresentSaleNo()+1;
		tfNo.setText(Integer.toString(orderNum));
		
		JPanel pnl1_2 = new JPanel();
		pnl1.add(pnl1_2);
		pnl1_2.setLayout(new GridLayout(0, 6, 0, 0));
		
		JLabel lblDate = new JLabel("order date :");
		pnl1_2.add(lblDate);
		
		tfDate = new JTextField();
		tfDate.setColumns(10);
		pnl1_2.add(tfDate);
		
		JLabel lblNewLabel_5 = new JLabel("");
		pnl1_2.add(lblNewLabel_5);
		
		JLabel lblTime = new JLabel("order time :");
		pnl1_2.add(lblTime);
		
		tfTime = new JTextField();
		tfTime.setColumns(10);
		pnl1_2.add(tfTime);
		
		JPanel pnl1_3 = new JPanel();
		pnl1.add(pnl1_3);
		pnl1_3.setLayout(new GridLayout(0, 5, 0, 0));
		
		JLabel lblName = new JLabel("customer :");
		pnl1_3.add(lblName);
		
		btnSearch = new JButton("Search");
		btnSearch.addActionListener(this);
		btnSearch.setFocusable(false);
		pnl1_3.add(btnSearch);
		
		JLabel lblSelectedCus = new JLabel("선택된 고객 :");
		pnl1_3.add(lblSelectedCus);
		
		tfSelectedCus = new JTextField();
		tfSelectedCus.setEditable(false);
		tfSelectedCus.setFocusable(false);
		pnl1_3.add(tfSelectedCus);
		tfSelectedCus.setColumns(10);
		
		JPanel pnl1_4 = new JPanel();
		pnl1.add(pnl1_4);
		pnl1_4.setLayout(new GridLayout(0, 2, 0, 0));
		
		JPanel pnl1_4_1 = new JPanel();
		pnl1_4.add(pnl1_4_1);
		pnl1_4_1.setLayout(new GridLayout(0, 2, 0, 0));
		
		JLabel lblHair = new JLabel("hair service :");
		pnl1_4_1.add(lblHair);
		
		
		HairService hairService = new HairService();
		List<Hair> hairList = hairService.SelectAllHair();
		mapHair = new HashMap<>();
		for(Hair h:hairList) {
			mapHair.put(h.getHairName(), h.getPrice());
		}
		String[] hairNames = new String[mapHair.size()];
		mapHair.keySet().toArray(hairNames);
		listHair = new JList(hairNames);
		listHair.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		pnl1_4_1.add(listHair);
		
		JPanel pnl1_5 = new JPanel();
		pnl1.add(pnl1_5);
		pnl1_5.setLayout(new GridLayout(0, 6, 0, 0));
		
		JLabel lblEvent = new JLabel("이벤트 :");
		pnl1_5.add(lblEvent);
		
		cmbEvent = new JComboBox();
		EventService eventService = new EventService();
		List<Event> eventList = eventService.selectAllEvent();
		mapEvent = new HashMap<>();

		for(Event e:eventList) {
			mapEvent.put(e.getEvnName(), e.getDiscount());
		}
		
		String[] eventNames = new String[mapEvent.size()];
		mapEvent.keySet().toArray(eventNames);
		
		cmbEvent.setModel(new DefaultComboBoxModel(eventNames));
		cmbEvent.addActionListener(this);
		pnl1_5.add(cmbEvent);
		
		JLabel lblDiscount = new JLabel("할인율 : ");
		pnl1_5.add(lblDiscount);
		
		tfDiscount = new JTextField();
		tfDiscount.setEditable(false);
		pnl1_5.add(tfDiscount);
		tfDiscount.setColumns(10);
		
		JLabel lblPrice = new JLabel("금액 :");
		pnl1_5.add(lblPrice);
		
		tfPrice = new JTextField();
		tfPrice.setEditable(false);
		pnl1_5.add(tfPrice);
		tfPrice.setColumns(10);
		
		JPanel pnl1_6 = new JPanel();
		FlowLayout fl_pnl1_6 = (FlowLayout) pnl1_6.getLayout();
		fl_pnl1_6.setAlignment(FlowLayout.RIGHT);
		pnl1.add(pnl1_6);
		
		JButton btnNewButton_2 = new JButton("add");
		pnl1_6.add(btnNewButton_2);
		
		JButton btnNewButton_3 = new JButton("cancel");
		pnl1_6.add(btnNewButton_3);
		
		JPanel pnl2 = new JPanel();
		contentPane.add(pnl2);
		pnl2.setLayout(new BoxLayout(pnl2, BoxLayout.X_AXIS));
		
		JPanel panel_11 = new JPanel();
		pnl2.add(panel_11);
		panel_11.setLayout(new GridLayout(0, 7, 0, 0));
		
		JLabel lblNewLabel_6 = new JLabel("검색기준 :");
		panel_11.add(lblNewLabel_6);
		
		rdbtnNewRadioButton = new JRadioButton("기간별");
		rdbtnNewRadioButton.addActionListener(this);
		panel_11.add(rdbtnNewRadioButton);
		
		rdbtnNewRadioButton_1 = new JRadioButton("고객별");
		rdbtnNewRadioButton_1.addActionListener(this);
		panel_11.add(rdbtnNewRadioButton_1);
		
		pnlCase1 = new JPanel();
		contentPane.add(pnlCase1);
		
		ButtonGroup group = new ButtonGroup();
		group.add(rdbtnNewRadioButton);
		group.add(rdbtnNewRadioButton_1);
	
	}

	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == cmbEvent) {
			String selectedEventName = cmbEvent.getSelectedItem().toString();
			Float discount = mapEvent.get(selectedEventName);
			tfDiscount.setText(Float.toString(discount));
			String selectedHairName = listHair.getSelectedValue();
			int price = mapHair.get(selectedHairName);
			price = (int) Math.ceil(price-(price*discount));
			tfPrice.setText(Integer.toString(price));
		}
		if (e.getSource() == btnSearch) {
			new DialogEx();
		}
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
	
	public class DialogEx extends JFrame{
		private MyModalDialog dialog;
		
		public DialogEx() {
			setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			dialog = new MyModalDialog(this, "고객검색");
			dialog.setVisible(true);
		}
	}
	
	class MyModalDialog extends JDialog{
		
		private JPanel contentPane = new JPanel();
		private JTable table;
		private JScrollPane scollPane;
		private String[] columnType= {"고객번호","고객명"};
		private NonEditableModel model;
		private JTextField tf = new JTextField(10);
		private JButton okButton = new JButton("ok");
		
		public MyModalDialog(JFrame frame, String title) {
			super(frame, title);
			setBounds(100, 100, 450 ,300);
			contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
			setContentPane(contentPane);
			contentPane.setLayout(new FlowLayout(FlowLayout.CENTER));
			List<Customer> lists = null;
			CustomerService service = new CustomerService();
			lists = service.selectAllCustomer();
			Object[][] data = getRows(lists);
			model = new NonEditableModel(data, columnType);
			table = new JTable(model);
			scollPane = new JScrollPane(table);
			
			contentPane.add(tf);
			contentPane.add(okButton);
			contentPane.add(table);
			
			table.setPreferredScrollableViewportSize(new Dimension(300, 500));
			table.setFillsViewportHeight(true);
			
			okButton.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					setVisible(false);
					//tfSelectedCus.setText(getInput());	
				}
			});
			
			table.addMouseListener(new MyMouseListener());
		}
		public String getInput() {
			if(tf.getText().length()==0) {
				return null;
			}else {
				return tf.getText();
			}
		}
		
		private class MyMouseListener extends MouseAdapter{
			public void mouseClicked(MouseEvent e) {
				if(e.getClickCount()==1) { //더블클릭 처리안됨 khj
					int row = table.getSelectedRow();
					System.out.println(model.getValueAt(row, 1));
					String str = model.getValueAt(row, 1).toString();
					tfSelectedCus.setText(str);
					
				}
			}
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
