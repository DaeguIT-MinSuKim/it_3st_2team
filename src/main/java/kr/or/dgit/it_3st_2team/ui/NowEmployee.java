package kr.or.dgit.it_3st_2team.ui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.FlowLayout;
import java.awt.Point;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.swing.AbstractButton;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import kr.or.dgit.it_3st_2team.dto.Employee;
import kr.or.dgit.it_3st_2team.dto.Title;
import kr.or.dgit.it_3st_2team.service.EmployeeService;
import kr.or.dgit.it_3st_2team.service.TitleService;

@SuppressWarnings("serial")
public class NowEmployee extends JFrame implements ActionListener {

	private AbstractButton tftitleno = null;
	private JPanel contentPane;
	private JTable table;
	private TextField empno;
	private TextField empname;
	private TextField joindate;
	private TextField id;
	private TextField epassword;
	int row = -1;
	private EmployeeService eservice;
	private TitleService tservice;
	private List<Title> tlist;
	private List<Employee> elist;
	JComboBox<Title> Jcomtitle;

	private String title[] = { "직책번호", "이름", "입사일", "주소", "아이디", "패스워드", "직책번호", "희망휴무요일", "퇴사유무" };

	JScrollPane jsp;
	DefaultTableModel model;
	private JButton btnMod;
	private JTextField tfaddr;
	private JFrame jf;
	private JTextField e_tf;
	public JComboBox empfind;

	private Map<String, Integer> map;
	private JComboBox<String> hday;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					NowEmployee frame = new NowEmployee();
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
	public NowEmployee() {
		tservice = new TitleService();
		eservice = new EmployeeService();
		initComponents();
	}

	private void initComponents() {
		setTitle("직원현황");
		/*yyj 03-07수정 이창만 닫기*/
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 1317, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));

		JPanel panel = new JPanel();
		contentPane.add(panel, BorderLayout.CENTER);
		panel.setLayout(new BorderLayout(0, 0));

		JScrollPane scrollPane = new JScrollPane();
		panel.add(scrollPane, BorderLayout.CENTER);

		table = new JTable();
		table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		scrollPane.setViewportView(table);
	
		lNow();
		
		table.setSelectionBackground(Color.yellow);
		table.setSelectionForeground(Color.MAGENTA);

		table.addMouseListener(new TableSelect());

		JPanel panel_1 = new JPanel();
		contentPane.add(panel_1, BorderLayout.NORTH);
		panel_1.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));

		JPanel panel_2 = new JPanel();
		panel_1.add(panel_2);

		JLabel lbltitleno = new JLabel("직원번호");
		panel_2.add(lbltitleno);

		empno = new TextField(5);
		empno.setEnabled(false);
		panel_2.add(empno);

		JLabel lblname = new JLabel("이름");
		panel_2.add(lblname);

		empname = new TextField(5);
		empname.setEnabled(false);
		panel_2.add(empname);

		JPanel panel_5 = new JPanel();
		panel_2.add(panel_5);
		panel_5.setLayout(new FlowLayout(FlowLayout.CENTER, 3, 3));

		JLabel lbljoindate = new JLabel("입사일");
		lbljoindate.setHorizontalAlignment(SwingConstants.LEFT);
		panel_5.add(lbljoindate);

		joindate = new TextField(15);
		joindate.setEnabled(false);
		panel_5.add(joindate);
		joindate.setPreferredSize(new Dimension(6, 21));

		JPanel panel_3 = new JPanel();
		panel_2.add(panel_3);
		panel_3.setLayout(new FlowLayout(FlowLayout.CENTER, 3, 3));

		JLabel lbladdr = new JLabel("주소");
		panel_3.add(lbladdr);

		tfaddr = new JTextField();
		tfaddr.setEnabled(false);
		tfaddr.setColumns(20);
		panel_3.add(tfaddr);

		JLabel lblid = new JLabel("아이디");
		panel_2.add(lblid);

		id = new TextField(8);
		id.setEnabled(false);
		panel_2.add(id);

		JLabel lblepassword = new JLabel("패스워드");
		panel_2.add(lblepassword);

		epassword = new TextField(8);
		panel_2.add(epassword);

		JPanel panel_4 = new JPanel();
		panel_2.add(panel_4);
		panel_4.setLayout(new FlowLayout(FlowLayout.CENTER, 3, 3));

		JLabel label_1 = new JLabel("직책");
		panel_4.add(label_1);

		tlist = tservice.selectTitle2();
		List<String> titleName = new ArrayList<>();
		for (Title t : tlist) {
			titleName.add(t.getTitleName());
		}
		map = new HashMap<>();
		for (Title t : tlist) {
			map.put(t.getTitleName(), t.getTitleNo());
		}
		for (String key : map.keySet()) {
			int value = map.get(key);
			// System.out.println(key+":"+value);
		}
		// JComboBox<Title> empfind = new JComboBox<Title>();
		empfind = new JComboBox(titleName.toArray());
		Title[] items = new Title[tlist.size()];
		tlist.toArray(items);

		System.out.println(items);

		// DefaultComboBoxModel<Title> cModel = new DefaultComboBoxModel<>(items);

		empfind.addActionListener(this);
		empfind.setLocation(new Point(5, 0));
		empfind.setMaximumSize(new Dimension(80, 30));
		empfind.setPreferredSize(new Dimension(85, 21));
		panel_4.add(empfind);
		// empfind.setModel(cModel);

		JLabel label = new JLabel("희망휴무요일");
		label.setMaximumSize(new Dimension(100, 15));
		label.setHorizontalAlignment(SwingConstants.CENTER);
		panel_2.add(label);

		hday = new JComboBox<>();
		hday.setModel(
				new DefaultComboBoxModel<String>(new String[] { "월요일", "화요일", "수요일", "목요일", "금요일", "토요일", "일요일" }));
		System.out.println(hday);

		hday.setMaximumSize(new Dimension(150, 30));
		hday.setToolTipText("희망휴무요일");
		panel_2.add(hday);

		JLabel lblE_tf = new JLabel("퇴사유무");
		panel_2.add(lblE_tf);

		e_tf = new JTextField();
		panel_2.add(e_tf);
		e_tf.setColumns(5);

		JPanel pBottom = new JPanel();
		contentPane.add(pBottom, BorderLayout.SOUTH);

		btnMod = new JButton("수정");
		btnMod.addActionListener(this);
		pBottom.add(btnMod);
	}

	private void lNow() {
		List<Employee> lists = null;
		EmployeeService service = new EmployeeService();
		lists = service.selecteNowEmplyoee();
		Object[][] data = getRows(lists);

		model = new DefaultTableModel(data, title) {
			  public boolean isCellEditable(int rowIndex, int mColIndex) {
	                return false;
	            }
		};
		
		table.setModel(model);
	}

	private Object[][] getRows(List<Employee> lists) {
		Object[][] rows = null;
		rows = new Object[lists.size()][];
		for (int i = 0; i < lists.size(); i++) {
			rows[i] = lists.get(i).toArray();
		}
		return rows;
	}

	public void clearData() {
		empno.setText(""); // 텍스트필드 창을 지운다.
		empname.setText("");
		joindate.setText("");
		id.setText("");
		epassword.setText("");
		empno.requestFocus(); // tfSang 텍스트 필드로 커서를 가져온다.
	}

	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnMod) {
			actionPerformedBtnMod(e);
		}
	}

	private void actionPerformedBtnMod(ActionEvent e) {
		int row = table.getSelectedRow();
		String[] str = new String[9];
		Object ob = e.getSource();
		boolean emp = (boolean) (table.getValueAt(row, 8));
		if (row == -1) {
			JOptionPane.showConfirmDialog(this, "먼저 수정할 행을 선택해주세요", "수정확인", JOptionPane.INFORMATION_MESSAGE);

			return;
		} else {
			int b = JOptionPane.showConfirmDialog(this, "수정하시겠습니까?", "확인", JOptionPane.YES_NO_OPTION,
					JOptionPane.QUESTION_MESSAGE);
			if (b == 0) {
				str[5] = epassword.getText();
				str[8] = (String) e_tf.getText();

				Object updateTitlename = table.getValueAt(row, 6);
				String st = null;
				for (int i = 0; i < tlist.size(); i++) {
					st = tlist.get(i).getTitleName();
					Boolean s = st.equals(updateTitlename);
					if (s) {
						empfind.setSelectedIndex(i);
						return;
					} else {
						empfind.setSelectedIndex(0);
					}
					lNow();
				}
			}

		}
		eservice.updateNowEmplyoee(new Employee((str[5]), str[8]));
	}

	class TableSelect extends MouseAdapter {

		@Override
		public void mouseClicked(MouseEvent e) {
			// 테이블에서 선택된 행의 값을 row에 저장한다.
			int row = table.getSelectedRow();
			String[] str = new String[9];
			// 행번호와 행의 데이터 텍스트 필드에 출력하기
			empno.setText(table.getValueAt(row, 0).toString());
			empname.setText(table.getValueAt(row, 1).toString());
			joindate.setText(table.getValueAt(row, 2).toString());
			tfaddr.setText(String.format("%s", table.getValueAt(row, 3)));
			id.setText(table.getValueAt(row, 4).toString());
			epassword.setText(table.getValueAt(row, 5).toString());

			String title = (String) table.getValueAt(row, 6);
			int titleNo = map.get(title);
			empfind.setSelectedIndex(titleNo - 1);

			String eoff = (String) table.getValueAt(row, 7);
			System.out.println(eoff);
			/*
			 * int eoffNo = map.get(eoff); empfind.setSelectedIndex(eoffNo - 1);
			 */

			if (eoff.equals("월")) {
				hday.setSelectedIndex(0);
			} else if (eoff.equals("화")) {
				hday.setSelectedIndex(1);
			} else if (eoff.equals("수")) {
				hday.setSelectedIndex(2);
			} else if (eoff.equals("목")) {
				hday.setSelectedIndex(3);
			} else if (eoff.equals("금")) {
				hday.setSelectedIndex(4);
			} else if (eoff.equals("토")) {
				hday.setSelectedIndex(5);
			} else if (eoff.equals("일")) {
				hday.setSelectedIndex(6);
			}
			System.out.println(hday);

			e_tf.setText(table.getValueAt(row, 8).toString());

		}
	}

}
/*
 * public JTextField getTfaddr() { return tfaddr; }
 * 
 * public void setTfaddr(String addr) { tfaddr.setText(addr); }
 */
