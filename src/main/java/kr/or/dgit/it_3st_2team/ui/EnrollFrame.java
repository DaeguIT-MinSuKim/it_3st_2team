package kr.or.dgit.it_3st_2team.ui;

import java.awt.EventQueue;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;

import javax.swing.BoxLayout;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.border.EmptyBorder;

import kr.or.dgit.it_3st_2team.dto.Event;
import kr.or.dgit.it_3st_2team.dto.Hair;
import kr.or.dgit.it_3st_2team.service.EventService;
import kr.or.dgit.it_3st_2team.service.HairService;
import kr.or.dgit.it_3st_2team.service.SaleService;
import javax.swing.table.DefaultTableModel;
import java.awt.BorderLayout;

public class EnrollFrame extends JFrame implements ActionListener {

	private JPanel contentPane;
	private JTextField tfNo;
	private JTextField tfDate;
	private JTextField tfTime;
	private JTextField tfSelectedCus;
	private JTextField tfDiscount;
	private JTextField tfPrice;
	private JButton btnSearchCus;
	private JComboBox<String> cmbEvent;
	private HashMap<String, Float> mapEvent;
	private HashMap<String, Integer> mapHair;
	private JList<String> listHair;
	private JTable table;
	private JTextField tfSelectedEmp;
	private JButton btnSearchEmp;
	private JButton btnAdd;

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
		tfNo.setFocusable(false);
		pnl1_1.add(tfNo);
		tfNo.setColumns(10);
		int orderNum=-1;
		//Sale sale = new Sale();
		SaleService service = new SaleService();
		orderNum=service.getPresentSaleNo()+1;
		tfNo.setText(Integer.toString(orderNum));
		
		JPanel pnl1_2 = new JPanel();
		pnl1.add(pnl1_2);
		pnl1_2.setLayout(new GridLayout(0, 6, 0, 0));
		
		JLabel lblDate = new JLabel("order date :");
		pnl1_2.add(lblDate);
		
		tfDate = new JTextField();
		tfDate.setEditable(false);
		tfDate.setColumns(10);
		pnl1_2.add(tfDate);
		Calendar now = Calendar.getInstance();
		int year = now.get(Calendar.YEAR);
		int month = now.get(Calendar.MONTH)+1;
		int day = now.get(Calendar.DAY_OF_MONTH);
		tfDate.setText(toString().format("%s-%s-%s",year,month,day));
		
		JLabel lblNewLabel_5 = new JLabel("");
		pnl1_2.add(lblNewLabel_5);
		
		JLabel lblTime = new JLabel("order time :");
		pnl1_2.add(lblTime);
		
		tfTime = new JTextField();
		tfTime.setEditable(false);
		tfTime.setColumns(10);
		pnl1_2.add(tfTime);
		int hour = now.get(Calendar.HOUR);
		int minute = now.get(Calendar.MINUTE);
		tfTime.setText(toString().format("%s:%s",hour,minute));
		
		JPanel pnl1_3 = new JPanel();
		pnl1.add(pnl1_3);
		pnl1_3.setLayout(new GridLayout(0, 5, 0, 0));
		
		JLabel lblName = new JLabel("customer :");
		pnl1_3.add(lblName);
		
		btnSearchCus = new JButton("찾기");
		btnSearchCus.addActionListener(this);
		btnSearchCus.setFocusable(false);
		pnl1_3.add(btnSearchCus);
		
		JLabel lblSelectedCus = new JLabel("선택한 고객 :");
		pnl1_3.add(lblSelectedCus);
		
		tfSelectedCus = new JTextField();
		tfSelectedCus.setEditable(false);
		tfSelectedCus.setFocusable(false);
		pnl1_3.add(tfSelectedCus);
		tfSelectedCus.setColumns(10);
		
		JPanel pnl1_7 = new JPanel();
		pnl1.add(pnl1_7);
		pnl1_7.setLayout(new GridLayout(0, 5, 0, 0));
		
		JLabel lblNewLabel = new JLabel("직원명 :");
		pnl1_7.add(lblNewLabel);
		
		btnSearchEmp = new JButton("찾기");
		btnSearchEmp.addActionListener(this);
		pnl1_7.add(btnSearchEmp);
		
		JLabel lblNewLabel_1 = new JLabel("선택한 직원 :");
		pnl1_7.add(lblNewLabel_1);
		
		tfSelectedEmp = new JTextField();
		tfSelectedEmp.setEditable(false);
		pnl1_7.add(tfSelectedEmp);
		tfSelectedEmp.setColumns(10);
		
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
		
		cmbEvent = new JComboBox<String>();
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
		
		btnAdd = new JButton("add");
		btnAdd.addActionListener(this);
		pnl1_6.add(btnAdd);
		
		JButton btnNewButton_3 = new JButton("cancel");
		pnl1_6.add(btnNewButton_3);
		
		JPanel pnl2 = new JPanel();
		contentPane.add(pnl2);
		pnl2.setLayout(new BorderLayout(0, 0));
		
		table = new JTable();
		table.setModel(new DefaultTableModel(
			new Object[][] {
				{"영업번호", "영업일", "방문시간", "고객명", "직원명", "헤어명", "이벤트명", "단가"},
			},
			new String[] {
				"New column", "New column", "New column", "New column", "New column", "New column", "New column", "New column"
			}
		));
		pnl2.add(table, BorderLayout.CENTER);
	
	}
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnAdd) {
			actionPerformedBtnAdd(e);
		}
		if (e.getSource() == btnSearchEmp) {
			EmployeeSearchUI empUi = new EmployeeSearchUI(this);
			empUi.setVisible(true);
		}
		if (e.getSource() == btnSearchCus) {
			CustomerSearchUI cusUi = new CustomerSearchUI(this);
			cusUi.setVisible(true);
		}
		if (e.getSource() == cmbEvent) {
			String selectedEventName = cmbEvent.getSelectedItem().toString();
			Float discount = mapEvent.get(selectedEventName);
			tfDiscount.setText(Float.toString(discount));
			String selectedHairName = listHair.getSelectedValue();
			int price = mapHair.get(selectedHairName);
			price = (int) Math.ceil(price-(price*discount));
			tfPrice.setText(Integer.toString(price));
		}
	}

	public void setTfSelectedCus(String cusName) {
		tfSelectedCus.setText(cusName);
	}
	
	public void setTfSelectedEmp(String empName) {
		tfSelectedEmp.setText(empName);
	}
	

/*	public class DialogEx extends JFrame{
		private MyModalDialog dialog;

		public DialogEx(String title) throws HeadlessException {
			super(title);
			setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			dialog = new MyModalDialog(this, title);
			dialog.setVisible(true);
		}
		
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
		//private String[] columnType= {"고객번호","고객명"};
		private String[] columnType;
		private NonEditableModel model;
		private JTextField tf = new JTextField(10);
		private JButton okButton = new JButton("ok");
		
		public MyModalDialog(JFrame frame, String title) {
			super(frame, title);
			setBounds(100, 100, 450 ,300);
			contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
			setContentPane(contentPane);
			contentPane.setLayout(new FlowLayout(FlowLayout.CENTER));
			if(title.equals("고객검색")) {
				columnType = new String[] {"고객번호","고객명"};
				List<Customer> lists = null;
				CustomerService service = new CustomerService();
				lists = service.selectAllCustomer();
				Object[][] data = getRows(lists);
				model = new NonEditableModel(data, columnType);
			}
			else if(title.equals("직원검색")) {
				columnType = new String[] {"직원번호","직원명"};
				List<Employee> lists = null;
				EmployeeService service = new EmployeeService();
				lists = service.selectAllEmployee();
				Object[][] data = getRows(lists);
				model = new NonEditableModel(data, columnType);
			}
			
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
		
	}*/
	protected void actionPerformedBtnAdd(ActionEvent e) {
	}
}
