package kr.or.dgit.it_3st_2team.ui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.FlowLayout;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.swing.AbstractButton;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import kr.or.dgit.it_3st_2team.dto.Employee;
import kr.or.dgit.it_3st_2team.dto.Title;
import kr.or.dgit.it_3st_2team.service.EmployeeService;
import kr.or.dgit.it_3st_2team.service.TitleService;

@SuppressWarnings("serial")
public class NowEmployee extends JFrame implements ActionListener {

	private static final AbstractButton tftitleno = null;
	private JPanel contentPane;
	private JTable table;
	private TextField empno;
	private TextField empname;
	private TextField joindate;
	private TextField id;
	private TextField epassword;
	private TextField titlename;
	int row = -1;
	private EmployeeService eservice;
	private TitleService tservice;

	private String title[] = { "직책번호", "이름", "입사일", "아이디", "패스워드", "직책명" };

	JScrollPane jsp;
	DefaultTableModel model;

	private JButton btnAdd;
	private JButton btnDel;
	private JButton btnMod;

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
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 708, 300);
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
		panel_2.add(empno);

		JLabel lblname = new JLabel("이름");
		panel_2.add(lblname);

		empname = new TextField(5);
		panel_2.add(empname);

		JLabel lbljoindate = new JLabel("입사일");
		panel_2.add(lbljoindate);

		joindate = new TextField(5);
		panel_2.add(joindate);

		JLabel lblid = new JLabel("아이디");
		panel_2.add(lblid);

		id = new TextField(5);
		panel_2.add(id);

		JLabel lblepassword = new JLabel("패스워드");
		panel_2.add(lblepassword);

		epassword = new TextField(5);
		panel_2.add(epassword);

		JLabel lbltitlename = new JLabel("직책번호");
		panel_2.add(lbltitlename);

		titlename = new TextField(5);
		panel_2.add(titlename);

		JPanel pBottom = new JPanel();
		contentPane.add(pBottom, BorderLayout.SOUTH);

		btnAdd = new JButton("추가");
		btnAdd.addActionListener(this);
		pBottom.add(btnAdd);

		btnDel = new JButton("삭제");
		btnDel.addActionListener(this);
		pBottom.add(btnDel);

		btnMod = new JButton("수정");
		btnMod.addActionListener(this);
		pBottom.add(btnMod);
	}

	private void lNow() {
		List<Employee> lists = null;
		EmployeeService service = new EmployeeService();
		lists = service.selecteNowEmplyoee();
		Object[][] data = getRows(lists);

		model = new DefaultTableModel(data, title);
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
		titlename.setText("");
		empname.setText("");
		joindate.setText("");
		id.setText("");
		epassword.setText("");
		empno.requestFocus(); // tfSang 텍스트 필드로 커서를 가져온다.
	}

	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnAdd) {
			actionPerformedBtnAdd(e);
		}
		if (e.getSource() == btnDel) {
			actionPerformedBtnDel(e);
		}
		if (e.getSource() == btnMod) {
			actionPerformedBtnMod(e);
		}
	}

	private void actionPerformedBtnMod(ActionEvent e) {
		String[] str = new String[6];
		Object ob = e.getSource();
		if (row == -1) {
			JOptionPane.showConfirmDialog(this, "먼저 수정할 행을 선택해주세요", "수정확인", JOptionPane.INFORMATION_MESSAGE);

			return;
		}
		/*model.setValueAt(empno.getText(), row, 0);
		model.setValueAt(empname.getText(), row, 1);
		model.setValueAt(joindate.getText(), row, 2);
		model.setValueAt(id.getText(), row, 3);
		model.setValueAt(epassword.getText(), row, 4);
		model.setValueAt(titlename.getText(), row, 5);*/
		str[0] = empno.getText();
		str[1] = empname.getText();
		str[2] = joindate.getText();
		str[3] = id.getText();
		str[4] = epassword.getText();
		str[5] = titlename.getText();

	}

	private void actionPerformedBtnDel(ActionEvent e) {
		int row = table.getSelectedRow();
		int neno = (int) (table.getValueAt(row, 0));
		if (row == -1) {
			JOptionPane.showMessageDialog(this, "먼저 삭제할 행을 선택해주세요");

			return;
		}

		else {
			int b = JOptionPane.showConfirmDialog(this, "데이터를 삭제할까요?", "삭제", JOptionPane.YES_NO_OPTION,
					JOptionPane.QUESTION_MESSAGE);
			if (b == 0) {
				// model.removeRow(row);
				tservice.deleteTitle(neno);
				row = -1;
				this.clearData();
				lNow();
			}
		}

	}

	@SuppressWarnings("deprecation")
	protected void actionPerformedBtnAdd(ActionEvent e) {
		String[] str = new String[6];
		Object ob = e.getSource();
		if (empno.getText().equals("")) // titleno를 비교하는 것이므로 equals로 비교한다.
		{
			JOptionPane.showMessageDialog(this, "직책번호를 입력해주세요");
			empno.requestFocus();
			return;
		}
		if (empname.getText().equals("")) // empname를 비교하는 것이므로 equals로 비교한다.
		{
			JOptionPane.showMessageDialog(this, "이름을 입력해주세요");
			empname.requestFocus();
			return;
		}
		if (joindate.getText().equals("")) // joindate를 비교하는 것이므로 equals로 비교한다.
		{
			JOptionPane.showMessageDialog(this, "입사일을 입력해주세요");
			joindate.requestFocus();
			return;
		}
		if (id.getText().equals("")) // id를 비교하는 것이므로 equals로 비교한다.
		{
			JOptionPane.showMessageDialog(this, "아이디를 입력해주세요");
			id.requestFocus();
			return;
		}
		if (epassword.getText().equals("")) // epassword를 비교하는 것이므로 equals로 비교한다.
		{
			JOptionPane.showMessageDialog(this, "비밀번호를 입력해주세요");
			epassword.requestFocus();
			return;
		}
		if (titlename.getText().equals("")) // titlename를 비교하는 것이므로 equals로 비교한다.
		{
			JOptionPane.showMessageDialog(this, "직책명을 입력해주세요");
			titlename.requestFocus();
			return;
		}
		str[0] = empno.getText();
		str[1] = empname.getText();
		str[2] = joindate.getText();
		str[3] = id.getText();
		str[4] = epassword.getText();
		str[5] = titlename.getText();

		// model.addRow(str);
		Date date = new Date();
		SimpleDateFormat Sdf = new SimpleDateFormat("yyyy-mm-dd");
		try {
			date = Sdf.parse(str[2]);
		} catch (ParseException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		lNow();

	}

	class TableSelect extends MouseAdapter {

		@Override
		public void mouseClicked(MouseEvent e) {
			row = table.getSelectedRow(); // 테이블에서 선택된 행의 값을 row에 저장한다.

			// 행번호와 행의 데이터 텍스트 필드에 출력하기
			empno.setText(table.getValueAt(row, 0).toString());
			empname.setText(table.getValueAt(row, 1).toString());
			joindate.setText(table.getValueAt(row, 2).toString());
			id.setText(table.getValueAt(row, 3).toString());
			epassword.setText(table.getValueAt(row, 4).toString());
			titlename.setText(table.getValueAt(row, 5).toString());
		}

	}
}
