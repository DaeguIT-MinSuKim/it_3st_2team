package kr.or.dgit.it_3st_2team.ui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.font.TransformAttribute;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;

import javax.swing.BorderFactory;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;

import kr.or.dgit.it_3st_2team.dto.Customer;
import kr.or.dgit.it_3st_2team.dto.Employee;
import kr.or.dgit.it_3st_2team.dto.Enroll;
import kr.or.dgit.it_3st_2team.dto.Event;
import kr.or.dgit.it_3st_2team.dto.Hair;
import kr.or.dgit.it_3st_2team.dto.Sale;
import kr.or.dgit.it_3st_2team.service.CustomerService;
import kr.or.dgit.it_3st_2team.service.EmployeeService;
import kr.or.dgit.it_3st_2team.service.EnrollService;
import kr.or.dgit.it_3st_2team.service.EventService;
import kr.or.dgit.it_3st_2team.service.HairService;
import kr.or.dgit.it_3st_2team.service.SaleService;
//khj
public class EnrollFrame extends JFrame implements ActionListener {

	private JPanel contentPane;
	private JTextField tfNo;
	private JTextField tfDate;
	private JTextField tfTime;
	private JTextField tfSelectedCus;
	private JTextField tfCusNo;
	private JTextField tfSelectedEmp;
	private JTextField tfEmpNo;
	private JTextField tfDiscount;
	private JTextField tfPrice;
	private JTextField tfSearchCusName;
	private JTextField tfSearchDate1;
	private JTextField tfSearchDate2;
	private List<Sale> saleList;
	private SaleService saleService;
	private Calendar calender;
	private JButton btnSearchCus;
	private JButton btnSearchEmp;
	private HairService hairService;
	private HashMap<String, Integer> mapHairPrice;
	private HashMap<String, Integer> mapHairNo;
	private JTextField tfDanga;
	private EventService eventService;
	private HashMap<String, Float> mapEventDiscount;
	private HashMap<String, Integer> mapNoEvent;
	private JComboBox cmbEvent;
	private JList<String> listHair;
	private Float discount;
	private int totalDanga;
	private JButton btnCancel;
	private JButton btnAdd;
	private EnrollService enrollservice;
	private JTable table;
	private JScrollPane scrollPane;
	private JButton btnSearchCancel;
	private JButton btnSearch;
	private JButton btnDelete;
	private JButton btnUpdate;
	private CustomerService customerService;
	private EmployeeService employeeService;

/*	*//**
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
		saleList = new ArrayList<>();
		saleService = new SaleService();
		hairService = new HairService();
		eventService = new EventService();
		enrollservice = new EnrollService();
		customerService = new CustomerService();
		employeeService = new EmployeeService();
		
		initComponents();
	}
	private void initComponents() {
		setTitle("헤어주문");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 839, 811);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		
		JPanel panel = new JPanel();
		contentPane.add(panel, BorderLayout.NORTH);
		panel.setLayout(new BorderLayout(0, 0));
		
		JPanel panel_1 = new JPanel();
		panel.add(panel_1, BorderLayout.WEST);
		panel_1.setLayout(new BorderLayout(0, 0));
		
		JPanel panel_2 = new JPanel();
		panel_1.add(panel_2, BorderLayout.NORTH);
		panel_2.setLayout(new BorderLayout(0, 0));
		
		JPanel panel_3 = new JPanel();
		panel_3.setBorder(new TitledBorder("영업정보"));
		panel_2.add(panel_3, BorderLayout.NORTH);
		panel_3.setLayout(new GridLayout(0, 6, 5, 5));
		
		JLabel lblNewLabel = new JLabel("영업번호 :");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		panel_3.add(lblNewLabel);
		
		tfNo = new JTextField();
		tfNo.setEditable(false);
		panel_3.add(tfNo);
		tfNo.setColumns(10);
		renewtfNo();
		
		JLabel lblNewLabel_1 = new JLabel("");
		panel_3.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("");
		panel_3.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("");
		panel_3.add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("");
		panel_3.add(lblNewLabel_4);
		
		JLabel lblNewLabel_5 = new JLabel("영업일 :");
		lblNewLabel_5.setHorizontalAlignment(SwingConstants.CENTER);
		panel_3.add(lblNewLabel_5);
		
		tfDate = new JTextField();
		tfDate.setEditable(false);
		panel_3.add(tfDate);
		tfDate.setColumns(10);
		renewtfDate();
		
		JLabel lblNewLabel_6 = new JLabel("");
		panel_3.add(lblNewLabel_6);
		
		JLabel lblNewLabel_7 = new JLabel("방문시간 :");
		lblNewLabel_7.setHorizontalAlignment(SwingConstants.CENTER);
		panel_3.add(lblNewLabel_7);
		
		tfTime = new JTextField();
		tfTime.setEditable(false);
		panel_3.add(tfTime);
		tfTime.setColumns(10);
		renewtfTime();
		
		JLabel lblNewLabel_8 = new JLabel("");
		panel_3.add(lblNewLabel_8);
		
		JPanel panel_4 = new JPanel();
		panel_4.setBorder(new TitledBorder("주문 정보"));
		panel_2.add(panel_4, BorderLayout.CENTER);
		panel_4.setLayout(new GridLayout(0, 6, 5, 5));
		
		JLabel lblNewLabel_9 = new JLabel("고객명 :");
		lblNewLabel_9.setHorizontalAlignment(SwingConstants.CENTER);
		panel_4.add(lblNewLabel_9);
		
		tfSelectedCus = new JTextField();
		tfSelectedCus.setEditable(false);
		panel_4.add(tfSelectedCus);
		tfSelectedCus.setColumns(10);
		
		btnSearchCus = new JButton("찾기");
		btnSearchCus.addActionListener(this);
		panel_4.add(btnSearchCus);
		
		JLabel lblNewLabel_10 = new JLabel("고객번호 :");
		lblNewLabel_10.setHorizontalAlignment(SwingConstants.CENTER);
		panel_4.add(lblNewLabel_10);
		
		tfCusNo = new JTextField();
		tfCusNo.setEditable(false);
		panel_4.add(tfCusNo);
		tfCusNo.setColumns(10);
		
		JLabel label = new JLabel("");
		label.setHorizontalAlignment(SwingConstants.CENTER);
		panel_4.add(label);
		
		JLabel lblNewLabel_13 = new JLabel("직원명 :");
		lblNewLabel_13.setHorizontalAlignment(SwingConstants.CENTER);
		panel_4.add(lblNewLabel_13);
		
		tfSelectedEmp = new JTextField();
		tfSelectedEmp.setEditable(false);
		tfSelectedEmp.setColumns(10);
		panel_4.add(tfSelectedEmp);
		
		btnSearchEmp = new JButton("찾기");
		btnSearchEmp.addActionListener(this);
		panel_4.add(btnSearchEmp);
		
		JLabel label_1 = new JLabel("직원번호 :");
		label_1.setHorizontalAlignment(SwingConstants.CENTER);
		panel_4.add(label_1);
		
		tfEmpNo = new JTextField();
		tfEmpNo.setEditable(false);
		panel_4.add(tfEmpNo);
		tfEmpNo.setColumns(10);
		
		JLabel lblNewLabel_12 = new JLabel("");
		panel_4.add(lblNewLabel_12);
		
		JLabel label_2 = new JLabel("이벤트 :");
		label_2.setHorizontalAlignment(SwingConstants.CENTER);
		panel_4.add(label_2);
		
		cmbEvent = new JComboBox();
		cmbEvent.addActionListener(this);
		panel_4.add(cmbEvent);
		//ComboBox
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
		
		JLabel label_3 = new JLabel("할인율 :");
		label_3.setHorizontalAlignment(SwingConstants.CENTER);
		panel_4.add(label_3);
		
		tfDiscount = new JTextField();
		tfDiscount.setEditable(false);
		tfDiscount.setColumns(10);
		panel_4.add(tfDiscount);
		
		JLabel label_4 = new JLabel("금액 :");
		label_4.setHorizontalAlignment(SwingConstants.CENTER);
		panel_4.add(label_4);
		
		tfPrice = new JTextField();
		tfPrice.setEditable(false);
		tfPrice.setColumns(10);
		panel_4.add(tfPrice);
		
		JLabel lblNewLabel_14 = new JLabel("");
		panel_4.add(lblNewLabel_14);
		
		JLabel lblNewLabel_15 = new JLabel("");
		panel_4.add(lblNewLabel_15);
		
		JLabel lblNewLabel_16 = new JLabel("");
		panel_4.add(lblNewLabel_16);
		
		JLabel lblNewLabel_20 = new JLabel("");
		panel_4.add(lblNewLabel_20);
		
		JPanel panel_5 = new JPanel();
		panel_5.setBorder(new TitledBorder("헤어정보"));
		panel_2.add(panel_5, BorderLayout.SOUTH);
		panel_5.setLayout(new BorderLayout(0, 0));
		
		hairService = new HairService();
		List<Hair> hairList = hairService.SelectAllHair();
		mapHairPrice = new HashMap<>();
		mapHairNo = new HashMap<>();
		for(Hair h:hairList) {
			mapHairPrice.put(h.getHairName(), h.getPrice());
			mapHairNo.put(h.getHairName(), h.getHairNo());
		}
		String[] hairNames = new String[mapHairPrice.size()];
		mapHairPrice.keySet().toArray(hairNames);
		
		JPanel panel_9 = new JPanel();
		FlowLayout flowLayout = (FlowLayout) panel_9.getLayout();
		flowLayout.setAlignment(FlowLayout.LEFT);
		panel_5.add(panel_9, BorderLayout.NORTH);
		
		JLabel lblNewLabel_11 = new JLabel("헤어명 :");
		panel_9.add(lblNewLabel_11);
		lblNewLabel_11.setHorizontalAlignment(SwingConstants.CENTER);
		
		listHair = new JList(hairNames);
		panel_9.add(listHair);
		listHair.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
		JListHandler handler = new JListHandler(); //JList에 이벤트 등록
		listHair.addListSelectionListener(handler); 
		listHair.setBorder(BorderFactory.createLineBorder(Color.BLACK,1)); //경계선
		listHair.setVisibleRowCount(5); //5개까지 보이도록
		scrollPane = new JScrollPane(listHair);
		scrollPane.setPreferredSize(new Dimension(180, 120));
		panel_9.add(scrollPane);
		
		JLabel lblNewLabel_17 = new JLabel("단가 :");
		panel_9.add(lblNewLabel_17);
		
		tfDanga = new JTextField();
		panel_9.add(tfDanga);
		tfDanga.setEditable(false);
		tfDanga.setColumns(10);
		
		JPanel panel_8 = new JPanel();
		panel_5.add(panel_8);
		panel_8.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		btnAdd = new JButton("등록");
		btnAdd.addActionListener(this);
		panel_8.add(btnAdd);
		
		btnCancel = new JButton("취소");
		btnCancel.addActionListener(this);
		panel_8.add(btnCancel);
		
		JPanel panel_6 = new JPanel();
		panel_6.setBorder(new TitledBorder("검색"));
		contentPane.add(panel_6, BorderLayout.CENTER);
		panel_6.setLayout(new BorderLayout(0, 0));
		
		JPanel panel_7 = new JPanel();
		panel_6.add(panel_7, BorderLayout.NORTH);
		
		JLabel lblNewLabel_21 = new JLabel("고객명 :");
		panel_7.add(lblNewLabel_21);
		
		tfSearchCusName = new JTextField();
		panel_7.add(tfSearchCusName);
		tfSearchCusName.setColumns(10);
		
		JLabel lblNewLabel_22 = new JLabel("기간 :");
		panel_7.add(lblNewLabel_22);
		
		tfSearchDate1 = new JTextField();
		panel_7.add(tfSearchDate1);
		tfSearchDate1.setColumns(10);
		
		JLabel lblNewLabel_23 = new JLabel("~");
		panel_7.add(lblNewLabel_23);
		
		tfSearchDate2 = new JTextField();
		panel_7.add(tfSearchDate2);
		tfSearchDate2.setColumns(10);
		
		btnSearch = new JButton("검색");
		btnSearch.addActionListener(this);
		panel_7.add(btnSearch);
		
		btnSearchCancel = new JButton("취소");
		btnSearchCancel.addActionListener(this);
		panel_7.add(btnSearchCancel);
		
		btnDelete = new JButton("삭제");
		btnDelete.setVisible(false);
		btnDelete.addActionListener(this);
		
		btnUpdate = new JButton("수정");
		btnUpdate.addActionListener(this);
		panel_7.add(btnUpdate);
		btnUpdate.setEnabled(false);
		panel_7.add(btnDelete);
		
		scrollPane = new JScrollPane();
		table = new JTable();
		scrollPane.setViewportView(table);
		panel_6.add(scrollPane);
		
		saleList = saleService.selectAllSale();
		drawTable(saleList);
		
		table.addMouseListener(new TableMouseListener());
	}
	
	public class TableMouseListener extends MouseAdapter{

		@Override
		public void mouseClicked(MouseEvent e) { //테이블 더블클릭
			super.mouseClicked(e);
			if(e.getClickCount()==2) {
				setdataTabletoTextfield();
				btnUpdate.setEnabled(true);
			}
		}		
	}
	
	private void setdataTabletoTextfield() {
		int row = table.getSelectedRow();
		int saleNo = (int) table.getValueAt(row, 0);
		tfNo.setText(Integer.toString(saleNo));
		String date = (String) table.getValueAt(row, 1);
		tfDate.setText(date);
		String time = (String) table.getValueAt(row, 2);
		tfTime.setText(time);
		String cusName = (String) table.getValueAt(row, 3);
		tfSelectedCus.setText(cusName);
		tfCusNo.setText(Integer.toString(getCusNo(cusName)));
		String empName = (String) table.getValueAt(row, 4);
		tfSelectedEmp.setText(empName);
		tfEmpNo.setText(Integer.toString(getEmpNo(empName)));
		String event = (String) table.getValueAt(row, 5);
		cmbEvent.setSelectedItem(event);
		int price = (int) table.getValueAt(row, 6);
		tfPrice.setText(Integer.toString(price));
		String hairs = (String) table.getValueAt(row, 7); //JList는 어떻게 처리할래?
	}
	
	private void renewtfNo() {
		int orderNum=-1;
		orderNum=saleService.getPresentSaleNo()+1;
		tfNo.setText(Integer.toString(orderNum));
	}
	
	private void renewtfDate() {
		calender = Calendar.getInstance();
		int year = calender.get(Calendar.YEAR);
		int month = calender.get(Calendar.MONTH)+1;
		int day = calender.get(Calendar.DAY_OF_MONTH);
		tfDate.setText(toString().format("%s-%s-%s",year,month,day));
	}

	private void renewtfTime() {
		int hour = calender.get(Calendar.HOUR);
		int minute = calender.get(Calendar.MINUTE);
		tfTime.setText(toString().format("%s:%s",hour,minute));
	}
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnUpdate) { //수정
			actionPerformedBtnUpdate(e);
		}
		if (e.getSource() == btnDelete) { //삭제
			actionPerformedBtnDelete(e);
		}
		if (e.getSource() == btnSearch) { //검색
			actionPerformedBtnSearch(e);
		}
		if (e.getSource() == btnSearchCancel) { //검색취소
			actionPerformedBtnSearchCancel(e);
		}
		if (e.getSource() == btnAdd) { //등록
			actionPerformedBtnAdd(e);
		}
		if (e.getSource() == btnCancel) { //취소
			actionPerformedBtnCancel(e);
		}
		if (e.getSource() == cmbEvent) { //할인이벤트
			actionPerformedCmbEvent(e);
		}
		if (e.getSource() == btnSearchEmp) { //직원찾기
			EmployeeSearchUI empUi = new EmployeeSearchUI(this);
			empUi.setVisible(true);
		}
		if (e.getSource() == btnSearchCus) { //고객찾기
			CustomerSearchUI cusUi = new CustomerSearchUI(this);
			cusUi.setVisible(true);
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
	protected void actionPerformedCmbEvent(ActionEvent e) {
		tfPrice.setText(""); //초기화
		String selectedEventName = cmbEvent.getSelectedItem().toString();
		discount = mapEventDiscount.get(selectedEventName);
		tfDiscount.setText(Float.toString(discount)); //할인율
		if(!tfDanga.getText().equals("")) {
			int danga = Integer.parseInt(tfDanga.getText());
			int price = (int) Math.ceil(danga-(danga*discount));
			tfPrice.setText(Integer.toString(price)); //할인후 금액
		}
	}
	
	private class JListHandler implements ListSelectionListener{
		@Override
		public void valueChanged(ListSelectionEvent e) {
			List<String> selectedHairList = listHair.getSelectedValuesList();
			int[] arrPrice = new int[selectedHairList.size()];
			int i=0;
			for(String str:selectedHairList) {
				int price = mapHairPrice.get(str);
				arrPrice[i]=price;
				i++;
			}
			totalDanga = 0;
			for(Integer integer :arrPrice) {
				totalDanga+=integer;
			}
			tfDanga.setText(Integer.toString(totalDanga)); //단가
			if(!tfDiscount.getText().equals("")) { //할인율 선택값이 있을때
				int price = (int) Math.ceil(totalDanga-(totalDanga*discount));
				tfPrice.setText(Integer.toString(price));

			}
		}
	}
	
	private void resetTextfields() {
		tfSelectedCus.setText("");
		tfCusNo.setText("");
		tfSelectedEmp.setText("");
		tfEmpNo.setText("");
		tfDiscount.setText("");
		tfPrice.setText("");
		tfDanga.setText("");
		cmbEvent.setSelectedIndex(0); //JList 초기화는?
		renewtfDate(); //날짜 초기화
		renewtfTime(); //시간 초기화
	}
	
	protected void actionPerformedBtnCancel(ActionEvent e) {
		resetTextfields();
	}
	
	protected void actionPerformedBtnAdd(ActionEvent e) { //등록
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
		String selectedEventName = cmbEvent.getSelectedItem().toString();
		int evn = mapNoEvent.get(selectedEventName);
		int price = Integer.parseInt(tfPrice.getText());
		Customer customer = new Customer(cus);
		Employee employee = new Employee(emp);
		Event event = new Event(evn);
		Sale sale = new Sale(saleNo, calender.getTime(), calender.getTime(), customer, employee, event, price);
		saleService.insertSale(sale);
				
		//enroll 테이블 넣기 (여러 헤어)
		List<String> selectedHairList = listHair.getSelectedValuesList();
		for(String str:selectedHairList) {
			Enroll enroll2 = new Enroll(saleNo, mapHairNo.get(str));
			enrollservice.insertEnroll(enroll2);
		}
				
		//테이블 다시 그리기
		saleList = saleService.selectAllSale();
		drawTable(saleList);
				
		//영업번호 업데이트
		renewtfNo();
		//모든 입력필드값 초기화
		resetTextfields();
	}
	
	private void drawTable(List<Sale> saleList) {
		//saleList = saleService.selectAllSale();
		String[] columnType = new String[] {"영업번호","영업일","방문시간","고객명","직원명","이벤트명","금액","헤어"};
		table.setModel(new NonEditableModel(getRows(saleList), columnType));
		scrollPane.setViewportView(table);
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
	
	class NonEditableModel extends DefaultTableModel {
		public NonEditableModel(Object[][] data, Object[] columnNames) {
			super(data, columnNames);
		}

		@Override
		public boolean isCellEditable(int row, int column) {
			return false;
		}
	}
	protected void actionPerformedBtnSearchCancel(ActionEvent e) { //검색취소
		tfSearchCusName.setText("");
		tfSearchDate1.setText("");
		tfSearchDate2.setText("");
		saleList = saleService.selectAllSale();
		drawTable(saleList);
	}
	protected void actionPerformedBtnSearch(ActionEvent e) { //검색
		String cusName = tfSearchCusName.getText().trim();
		String from = tfSearchDate1.getText().trim();
		String to = tfSearchDate2.getText().trim();
		if(!cusName.equals("")) {
			List<Customer> cusList = customerService.selectAllCustomer();
			boolean b = false;
			for(Customer c : cusList) {
				if(c.getCusName().equals(cusName)) {
					b = true;
					Customer customer = new Customer(cusName);
					int cusNo = customerService.selectCusNoByName(customer);
					customer = new Customer(cusNo);
					Sale sale = new Sale(customer);
					List<Sale> list = saleService.selectSaleByCusNo(sale);
					drawTable(list);
				}
			}
			if(b==false) {
				JOptionPane.showMessageDialog(null, "없는 고객입니다");
			}	
		}
		if(!from.equals("")&&(!to.equals(""))) {
			List<Sale> list = saleService.selectSaleByDate(from, to);
			drawTable(list);
		}
		if(!cusName.equals("")&&(!from.equals("")&&(!to.equals("")))) {
			List<Customer> cusList = customerService.selectAllCustomer();
			boolean b = false;
			for(Customer c : cusList) {
				if(c.getCusName().equals(cusName)) {
					b = true;
					List<Sale> list = saleService.selectSaleByCusNoAndDate(cusName, from, to);
					drawTable(list);
				}
			}
			if(b==false) {
				JOptionPane.showMessageDialog(null, "없는 고객입니다");
			}
		}
	}
		
	protected void actionPerformedBtnDelete(ActionEvent e) { //삭제
		int row = table.getSelectedRow();
		int saleNo = (int) table.getValueAt(row, 0);
		
		Enroll enroll = new Enroll(saleNo);
		enrollservice.deleteEnroll(enroll);
		
		Sale sale = new Sale(saleNo);
		saleService.deleteSale(sale);
		
		saleList = saleService.selectAllSale();
		drawTable(saleList);
	}
	protected void actionPerformedBtnUpdate(ActionEvent e) { //수정
		int row = table.getSelectedRow();
		int saleNo = Integer.parseInt(tfNo.getText());
		
		List<String> selectedHairList = listHair.getSelectedValuesList();
		for(String str:selectedHairList) {
			Enroll enroll = new Enroll(saleNo, mapHairNo.get(str));
			enrollservice.updateEnrollofHair(enroll);
		}
		//Enroll enroll = new Enroll(saleNo);
		/*List<Enroll> enrollList = enrollservice.selectEnrollBySaleNo(enroll);
		System.out.println(enrollList);
		List<String> hairs = new ArrayList<>();
		for(Enroll n : enrollList) {
			hairs.add(Integer.toString(n.getHairNo()));
		}
		System.out.println(hairs);*/
	
		int cusNo = Integer.parseInt(tfCusNo.getText());
		Customer customer = new Customer(cusNo);
		int empNo = Integer.parseInt(tfCusNo.getText());
		Employee employee = new Employee(empNo);
		String eventName = cmbEvent.getSelectedItem().toString();
		int eventNo = mapNoEvent.get(eventName);
		Event event = new Event(eventNo);
		int price = Integer.parseInt(tfPrice.getText());
		Sale sale = new Sale(saleNo, customer, employee, event, price);
		saleService.updateSale(sale);
		
		saleList = saleService.selectAllSale();
		drawTable(saleList);
	}
	
	public int getCusNo(String cusName) {
		Customer customer = new Customer(cusName);
		return customerService.selectCusNoByName(customer);
	}
	
	public int getEmpNo(String empName) {
		Employee employee = new Employee(empName);
		return employeeService.selectEmpNo(employee);
	}

}