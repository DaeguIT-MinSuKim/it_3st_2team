package kr.or.dgit.it_3st_2team.ui;

import java.awt.Container;
import java.awt.EventQueue;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BoxLayout;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import kr.or.dgit.it_3st_2team.dto.Customer;
import kr.or.dgit.it_3st_2team.dto.Sale;
import kr.or.dgit.it_3st_2team.service.SaleService;
import javax.swing.JList;
import javax.swing.AbstractListModel;

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
		
		JList list = new JList();
		list.setModel(new AbstractListModel() {
			String[] values = new String[] {"커트", "드라이", "샴푸", "펌", "매직", "트리트먼트", "앰플", "기타"};
			public int getSize() {
				return values.length;
			}
			public Object getElementAt(int index) {
				return values[index];
			}
		});
		pnl1_4_1.add(list);
		
		JPanel pnl1_5 = new JPanel();
		pnl1.add(pnl1_5);
		pnl1_5.setLayout(new GridLayout(0, 6, 0, 0));
		
		JLabel lblEvent = new JLabel("이벤트 :");
		pnl1_5.add(lblEvent);
		
		JComboBox cmbEvent = new JComboBox();
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
		if (e.getSource() == btnSearch) {
			actionPerformedBtnSearch(e);
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
	protected void actionPerformedBtnSearch(ActionEvent e) {
		EnrollFrameSearchCustomer searchCustomer = new EnrollFrameSearchCustomer();
		searchCustomer.setVisible(true);
	}
}
