package kr.or.dgit.it_3st_2team.ui;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
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
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import kr.or.dgit.it_3st_2team.dto.Customer;
import kr.or.dgit.it_3st_2team.dto.Employee;
import kr.or.dgit.it_3st_2team.dto.Enroll;
import kr.or.dgit.it_3st_2team.dto.Event;
import kr.or.dgit.it_3st_2team.dto.Hair;
import kr.or.dgit.it_3st_2team.dto.Sale;
import kr.or.dgit.it_3st_2team.service.CustomerService;
import kr.or.dgit.it_3st_2team.service.EnrollService;
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
	private JTextField tfPrice;
	private JButton btnSearchCus;
	private JComboBox<String> cmbEvent;
	private HashMap<String, Float> mapEventDiscount;
	private HashMap<String, Integer> mapNoEvent;
	private HashMap<String, Integer> mapHairPrice;
	private JList<String> listHair;
	private HashMap<String, Integer> mapHairNo;
	private JTable table;
	private JTextField tfSelectedEmp;
	private JButton btnSearchEmp;
	private JButton btnAdd;
	private JTextField tfCusNo;
	private JTextField tfEmpNo;
	private JTextField tfEvnNo;
	private List<Sale> saleList;
	private SaleService saleService = new SaleService();
	private CustomerService customerService = new CustomerService();
	private NonEditableModel model;
	private JScrollPane scrollPane;
	private Calendar calender;
	private EnrollService enrollservice = new EnrollService();
	private JButton btnDelete;
	private JButton btnUpdate;
	private JButton btnCancel;

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
		saleList = new ArrayList<>();
		/*saleService = new SaleService();
		customerService = new CustomerService();
		enrollservice = new EnrollService();*/
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
		

		JLabel lblNo = new JLabel("영업번호 :");
		pnl1_1.add(lblNo);
		
		tfNo = new JTextField();
		tfNo.setEditable(false);
		tfNo.setFocusable(false);
		pnl1_1.add(tfNo);
		tfNo.setColumns(10);
		renewtfNo();
		
		JPanel pnl1_2 = new JPanel();
		pnl1.add(pnl1_2);
		pnl1_2.setLayout(new GridLayout(0, 6, 0, 0));
		
		JLabel lblDate = new JLabel("영업일 :");
		pnl1_2.add(lblDate);
		
		tfDate = new JTextField();
		tfDate.setEditable(false);
		tfDate.setColumns(10);
		pnl1_2.add(tfDate);
		renewtfDate();
		
		JLabel lblNewLabel_5 = new JLabel("");
		pnl1_2.add(lblNewLabel_5);
		
		JLabel lblTime = new JLabel("영업시간 :");
		pnl1_2.add(lblTime);
		
		tfTime = new JTextField();
		tfTime.setEditable(false);
		tfTime.setColumns(10);
		pnl1_2.add(tfTime);
		renewtfTime();
		
		JPanel pnl1_3 = new JPanel();
		pnl1.add(pnl1_3);
		pnl1_3.setLayout(new GridLayout(0, 6, 0, 0));
		
		JLabel lblName = new JLabel("고객명 :");
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
		
		JLabel lblNewLabel_2 = new JLabel("고객 번호 :");
		pnl1_3.add(lblNewLabel_2);
		
		tfCusNo = new JTextField();
		tfCusNo.setEditable(false);
		pnl1_3.add(tfCusNo);
		tfCusNo.setColumns(10);
		
		JPanel pnl1_7 = new JPanel();
		pnl1.add(pnl1_7);
		pnl1_7.setLayout(new GridLayout(0, 6, 0, 0));
		
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
		
		JLabel lblNewLabel_3 = new JLabel("직원 번호 :");
		pnl1_7.add(lblNewLabel_3);
		
		tfEmpNo = new JTextField();
		tfEmpNo.setEditable(false);
		pnl1_7.add(tfEmpNo);
		tfEmpNo.setColumns(10);
		
		JPanel pnl1_4 = new JPanel();
		pnl1.add(pnl1_4);
		pnl1_4.setLayout(new GridLayout(0, 2, 0, 0));
		
		JPanel pnl1_4_1 = new JPanel();
		pnl1_4.add(pnl1_4_1);
		pnl1_4_1.setLayout(new GridLayout(0, 2, 0, 0));
		
		JLabel lblHair = new JLabel("헤어명 :");
		pnl1_4_1.add(lblHair);
		
		
		HairService hairService = new HairService();
		List<Hair> hairList = hairService.SelectAllHair();
		mapHairPrice = new HashMap<>();
		mapHairNo = new HashMap<>();
		for(Hair h:hairList) {
			mapHairPrice.put(h.getHairName(), h.getPrice());
			mapHairNo.put(h.getHairName(), h.getHairNo());
		}
		String[] hairNames = new String[mapHairPrice.size()];
		mapHairPrice.keySet().toArray(hairNames);
		
		listHair = new JList(hairNames);
		listHair.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
		pnl1_4_1.add(new JScrollPane(listHair));
		
		JPanel pnl1_5 = new JPanel();
		pnl1.add(pnl1_5);
		pnl1_5.setLayout(new GridLayout(0, 8, 0, 0));
		
		JLabel lblEvent = new JLabel("이벤트 :");
		pnl1_5.add(lblEvent);
		
		cmbEvent = new JComboBox<String>();
		EventService eventService = new EventService();
		List<Event> eventList = eventService.selectAllEvent();
		mapEventDiscount = new HashMap<>();
		for(Event e:eventList) {
			mapEventDiscount.put(e.getEvnName(), e.getDiscount());
		}
		
		mapNoEvent = new HashMap<>();
		for(Event e:eventList) {
			mapNoEvent.put(e.getEvnName(),e.getEvnNo());
		}
		
		String[] eventNames = new String[mapEventDiscount.size()];
		mapEventDiscount.keySet().toArray(eventNames);
		
		cmbEvent.setModel(new DefaultComboBoxModel(eventNames));
		cmbEvent.addActionListener(this);
		pnl1_5.add(cmbEvent);
		
		JLabel lblNewLabel_4 = new JLabel("번호 :");
		pnl1_5.add(lblNewLabel_4);
		
		tfEvnNo = new JTextField();
		tfEvnNo.setEditable(false);
		pnl1_5.add(tfEvnNo);
		tfEvnNo.setColumns(10);
		
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
		
		btnAdd = new JButton("등록");
		btnAdd.addActionListener(this);
		pnl1_6.add(btnAdd);
		
		btnCancel = new JButton("취소");
		btnCancel.addActionListener(this);
		pnl1_6.add(btnCancel);
		
		btnDelete = new JButton("삭제");
		btnDelete.addActionListener(this);
		pnl1_6.add(btnDelete);
		
		btnUpdate = new JButton("수정");
		btnUpdate.addActionListener(this);
		pnl1_6.add(btnUpdate);
		
		JButton btnSelect = new JButton("검색");
		pnl1_6.add(btnSelect);
		
		JPanel pnl2 = new JPanel();
		contentPane.add(pnl2);
		pnl2.setLayout(new BorderLayout(0, 0));
		
		scrollPane = new JScrollPane();
		pnl2.add(scrollPane, BorderLayout.NORTH);
		//table = new JTable(model);
		//pnl2.add(table, BorderLayout.SOUTH);
		table = new JTable();
		
		drawTable();
	}

	private void renewtfTime() {
		int hour = calender.get(Calendar.HOUR);
		int minute = calender.get(Calendar.MINUTE);
		tfTime.setText(toString().format("%s:%s",hour,minute));
	}

	private void renewtfDate() {
		calender = Calendar.getInstance();
		int year = calender.get(Calendar.YEAR);
		int month = calender.get(Calendar.MONTH)+1;
		int day = calender.get(Calendar.DAY_OF_MONTH);
		tfDate.setText(toString().format("%s-%s-%s",year,month,day));
	}

	private void renewtfNo() {
		int orderNum=-1;
		orderNum=saleService.getPresentSaleNo()+1;
		tfNo.setText(Integer.toString(orderNum));
	}

	private void drawTable() {
		saleList = saleService.selectAllSale();
		String[] columnType = new String[] {"영업번호","영업일","방문시간","고객명","직원명","이벤트명","금액","헤어"};
		table.setModel(new NonEditableModel(getRows(saleList), columnType));
		scrollPane.setViewportView(table);
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
	
	public Object[][] getRows(List<Sale> list) {
		Object[][] rows = null;

		rows = new Object[list.size()][];
		for (int i = 0; i < list.size(); i++) {
			Sale sale = list.get(i);
			rows[i] = sale.toArraySelectAllSale();
		}

		return rows;
	}
	
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnCancel) {
			actionPerformedBtnCancel(e);
		}
		if (e.getSource() == btnUpdate) {
			actionPerformedBtnUpdate(e);
		}
		if (e.getSource() == btnDelete) {
			actionPerformedBtnDelete(e);
		}
		if (e.getSource() == btnAdd) { //등록 버튼 누르면
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
			Float discount = mapEventDiscount.get(selectedEventName);
			tfDiscount.setText(Float.toString(discount));
			/*String selectedHairName = listHair.getSelectedValue();
			int price = mapHairPrice.get(selectedHairName);
			price = (int) Math.ceil(price-(price*discount));
			tfPrice.setText(Integer.toString(price));*/
			int saleNo = mapNoEvent.get(selectedEventName);
			tfEvnNo.setText(Integer.toString(saleNo));
			List<String> selectedHairList = listHair.getSelectedValuesList();
			int[] arrPrice = new int[selectedHairList.size()];
			int i=0;
			for(String str:selectedHairList) {
				int price = mapHairPrice.get(str);
				arrPrice[i]=price;
				i++;
			}
			int totalPrice=0;
			for(Integer integer :arrPrice) {
				totalPrice+=integer;
			}
			tfPrice.setText(Integer.toString(totalPrice));
		}
	}

	public void setTfSelectedCus(String cusName) {
		tfSelectedCus.setText(cusName);
	}
	
	public void setTfCusNo(int cusNo) {
		tfCusNo.setText(Integer.toString(cusNo));
	}
	
	public void setTfSelectedEmp(String empName) {
		tfSelectedEmp.setText(empName);
	}
	
	public void setTfEmpNo(int empNo) {
		tfEmpNo.setText(Integer.toString(empNo));
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
		//sale 테이블 넣기
		int saleNo = Integer.parseInt(tfNo.getText());
		Calendar calender = GregorianCalendar.getInstance();
		String date = tfDate.getText();
		String[] arrDate = date.split("-");
		int year = Integer.parseInt(arrDate[0]);
		int month = Integer.parseInt(arrDate[1]);
		int day = Integer.parseInt(arrDate[2]);
		calender.set(year, month-1, day);
		int cus = Integer.parseInt(tfCusNo.getText());
		int emp = Integer.parseInt(tfEmpNo.getText());
		int evn = Integer.parseInt(tfEvnNo.getText());
		int price = Integer.parseInt(tfPrice.getText());
		Customer customer = new Customer(cus);
		Employee employee = new Employee(emp);
		Event event = new Event(evn);
		Sale sale = new Sale(saleNo, calender.getTime(), calender.getTime(), customer, employee, event, price);
		saleService.insertSale(sale);
		
		/*String selectedHairName = listHair.getSelectedValue();
		int hairNo = mapHairNo.get(selectedHairName);
		Enroll enroll = new Enroll(saleNo, hairNo);
		enrollservice.insertEnroll(enroll);*/
		
		//enroll 테이블 넣기 (여러 헤어)
		List<String> selectedHairList = listHair.getSelectedValuesList();
		for(String str:selectedHairList) {
			Enroll enroll2 = new Enroll(saleNo, mapHairNo.get(str));
			enrollservice.insertEnroll(enroll2);
		}
		
		//테이블 다시 그리기
		drawTable();
		
		//영업번호 업데이트
		renewtfNo();
		
		//입력 필드값 초기화
		resetTextfields();
	}

	private void resetTextfields() {
		tfSelectedCus.setText("");
		tfCusNo.setText("");
		tfSelectedEmp.setText("");
		tfEmpNo.setText("");
		tfEvnNo.setText("");
		tfDiscount.setText("");
		tfPrice.setText("");
		renewtfDate();
		renewtfTime();
	}
	protected void actionPerformedBtnDelete(ActionEvent e) { //삭제
		int row = table.getSelectedRow();
		int saleNo = (int) table.getValueAt(row, 0);
		
		Enroll enroll = new Enroll(saleNo);
		enrollservice.deleteEnroll(enroll);
		
		Sale sale = new Sale(saleNo);
		saleService.deleteSale(sale);
		
		drawTable();
	}
	protected void actionPerformedBtnUpdate(ActionEvent e) { //수정
	} 
	protected void actionPerformedBtnCancel(ActionEvent e) { //취소
	}
}
