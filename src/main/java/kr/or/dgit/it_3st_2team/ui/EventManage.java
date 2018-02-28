package kr.or.dgit.it_3st_2team.ui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.List;

import javax.swing.BoxLayout;
import javax.swing.JButton;
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
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableModel;

import kr.or.dgit.it_3st_2team.dto.Event;
import kr.or.dgit.it_3st_2team.dto.Title;
import kr.or.dgit.it_3st_2team.service.EventService;
import kr.or.dgit.it_3st_2team.ui.TitleManage.TableSelect;

import java.awt.Insets;
import java.awt.Dimension;
import java.awt.Component;
import java.awt.Point;

@SuppressWarnings("serial")
public class EventManage extends JFrame implements ActionListener {

	private JPanel EventManage;
	private JTextField eventNo;
	private JTextField eventName;
	private JTextField eventdis;
	private JButton btnAdd;
	private JButton btnDel;
	private JButton btnMod;
	int row = -1;
	private EventService eservice;

	private String title[] = { "이벤트번호", "이벤트명", "이벤트 할인율" };
	private JTable table;
	JScrollPane jsp;
	DefaultTableModel model;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					EventManage frame = new EventManage();
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
	public EventManage() {
		eservice = new EventService();
		initComponents();
	}

	private void initComponents() {
		setTitle("이벤트등록");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 406, 374);
		EventManage = new JPanel();
		EventManage.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(EventManage);
		EventManage.setLayout(new BorderLayout(0, 0));

		JPanel panel = new JPanel();
		EventManage.add(panel, BorderLayout.CENTER);
		panel.setLayout(new GridLayout(0, 1, 0, 0));

		JPanel panel_5 = new JPanel();
		panel.add(panel_5);
		panel_5.setLayout(new BorderLayout(0, 0));

		JPanel panel_6 = new JPanel();
		panel_5.add(panel_6);
		panel_6.setLayout(new BorderLayout(0, 0));

		JPanel panel_8 = new JPanel();
		FlowLayout flowLayout = (FlowLayout) panel_8.getLayout();
		panel_6.add(panel_8, BorderLayout.CENTER);

		JPanel panel_15 = new JPanel();
		panel_15.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel_8.add(panel_15);
		panel_15.setLayout(new GridLayout(0, 1, 0, 0));

		JPanel panel_9 = new JPanel();
		panel_15.add(panel_9);
		FlowLayout flowLayout_1 = (FlowLayout) panel_9.getLayout();

		JLabel label = new JLabel("이벤트 번호");
		label.setFont(new Font("굴림", Font.PLAIN, 17));
		label.setHorizontalAlignment(SwingConstants.CENTER);
		panel_9.add(label);

		eventNo = new JTextField();
		eventNo.setMargin(new Insets(2, 1, 2, 2));
		eventNo.setColumns(10);
		panel_9.add(eventNo);

		JPanel panel_10 = new JPanel();
		panel_15.add(panel_10);
		panel_10.setLayout(new FlowLayout(FlowLayout.RIGHT, 20, 5));

		JLabel label_1 = new JLabel("이벤트 명");
		label_1.setAlignmentX(Component.CENTER_ALIGNMENT);
		label_1.setFont(new Font("굴림", Font.PLAIN, 17));
		label_1.setHorizontalAlignment(SwingConstants.CENTER);
		panel_10.add(label_1);

		eventName = new JTextField();
		eventName.setMargin(new Insets(2, 2, 2, 0));
		eventName.setColumns(10);
		panel_10.add(eventName);

		JPanel panel_14 = new JPanel();
		panel_15.add(panel_14);
		panel_14.setLayout(new FlowLayout(FlowLayout.RIGHT, 10, 5));

		JLabel label_2 = new JLabel("이벤트 할인율");
		label_2.setHorizontalAlignment(SwingConstants.CENTER);
		label_2.setFont(new Font("굴림", Font.PLAIN, 17));
		panel_14.add(label_2);

		eventdis = new JTextField();
		eventdis.setColumns(10);
		panel_14.add(eventdis);

		JPanel panel_7 = new JPanel();
		panel_6.add(panel_7, BorderLayout.SOUTH);
		panel_7.setLayout(new GridLayout(0, 3, 0, 0));

		JScrollPane scrollPane = new JScrollPane();
		panel.add(scrollPane);

		
		
		table = new JTable();
		table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		scrollPane.setViewportView(table);

		lEvent();
		
		table.setSelectionBackground(Color.yellow);
		table.setSelectionForeground(Color.MAGENTA);

		table.addMouseListener(new TableSelect());

		JPanel panel_1 = new JPanel();
		EventManage.add(panel_1, BorderLayout.SOUTH);
		panel_1.setLayout(new GridLayout(0, 2, 0, 0));

		JPanel panel_2 = new JPanel();
		panel_1.add(panel_2);

		JPanel panel_4 = new JPanel();
		panel_1.add(panel_4);
		panel_4.setLayout(new GridLayout(1, 0, 0, 0));

		btnAdd = new JButton("추가");
		btnAdd.addActionListener(this);
		panel_4.add(btnAdd);

		btnDel = new JButton("삭제");
		btnDel.addActionListener(this);
		panel_4.add(btnDel);

		btnMod = new JButton("수정");
		btnMod.addActionListener(this);
		panel_4.add(btnMod);

		JPanel panel_3 = new JPanel();
		EventManage.add(panel_3, BorderLayout.NORTH);
		panel_3.setLayout(new BoxLayout(panel_3, BoxLayout.X_AXIS));
	}

	private void lEvent() {
		List<Event> lists = null;
		EventService service = new EventService();
		lists = service.selectAllEvent();
		System.out.println(lists);
		Object[][] data = getRows(lists);

		model = new DefaultTableModel(data, title);
		table.setModel(model);
	}

	private Object[][] getRows(List<Event> lists) {
		Object[][] rows = new Object[lists.size()][];
		for (int i = 0; i < lists.size(); i++) {
			rows[i] = lists.get(i).toArray();
		}
		return rows;
	}

	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnMod) {
			actionPerformedBtnMod(e);
		}
		if (e.getSource() == btnDel) {
			actionPerformedBtnDel(e);
		}
		if (e.getSource() == btnAdd) {
			actionPerformedBtnAdd(e);
		}
	}

	protected void actionPerformedBtnAdd(ActionEvent e) {
		String[] str = new String[3];
		Object ob = e.getSource();
		if (eventNo.getText().equals("")) {
			JOptionPane.showMessageDialog(this, "이벤트번호를 입력해주세요");
			eventNo.requestFocus();
			return;
		}
		if (eventName.getText().equals("")) {
			JOptionPane.showMessageDialog(this, "이벤트명을 입력해주세요");
			eventName.requestFocus();
			return;
		}
		if (eventdis.getText().equals("")) {
			JOptionPane.showMessageDialog(this, "이벤트할인율을 입력해주세요");
			eventdis.requestFocus();
			return;
		}

		str[0] = eventNo.getText();
		str[1] = eventName.getText();
		str[2] = eventdis.getText();

		eservice.insertEvent(new Event(Integer.parseInt(str[0]), str[1], Float.parseFloat(str[2])));
		//model.addRow(str);
		lEvent();

	}

	protected void actionPerformedBtnDel(ActionEvent e) {
		int row = table.getSelectedRow();
		int Eno = (int) (table.getValueAt(row, 0));
		if (row == -1) {
			JOptionPane.showMessageDialog(this, "먼저 삭제할 행을 선택해주세요");

			return;
		}

		else {
			int b = JOptionPane.showConfirmDialog(this, "데이터를 삭제할까요?", "삭제", JOptionPane.YES_NO_OPTION,
					JOptionPane.QUESTION_MESSAGE);
			if (b == 0) {
				eservice.deleteEvent(Eno);
				//model.removeRow(row);
				row = -1;
				this.clearData();
				lEvent();
			}
		}
	}

	private void clearData() {

		eventNo.setText(""); // 텍스트필드 창을 지운다.
		eventName.setText("");
		eventdis.setText("");
	}

	protected void actionPerformedBtnMod(ActionEvent e) {
		String[] str = new String[3];
		Object ob = e.getSource();
		if (row == -1) {
			JOptionPane.showConfirmDialog(this, "먼저 수정할 행을 선택해주세요", "수정확인", JOptionPane.INFORMATION_MESSAGE);

			return;
		}
		/*model.setValueAt(eventNo.getText(), row, 0);
		model.setValueAt(eventName.getText(), row, 1);
		model.setValueAt(eventdis.getText(), row, 2);
		*/
		str[0] = eventNo.getText();
		str[1] = eventName.getText();
		str[2] = eventdis.getText();

		eservice.UpdateEvent(new Event(Integer.parseInt(str[0]), str[1], Float.parseFloat(str[2])));
		//model.addRow(str);
		lEvent();
	}

	class TableSelect extends MouseAdapter {

		@Override
		public void mouseClicked(MouseEvent e) {
			row = table.getSelectedRow(); // 테이블에서 선택된 행의 값을 row에 저장한다.

			System.out.println(table.getValueAt(row, 0));
			eventNo.setText(table.getValueAt(row, 0).toString());
			// 행번호와 행의 데이터 텍스트 필드에 출력하기
			eventName.setText((String) table.getValueAt(row, 1));
			eventdis.setText(table.getValueAt(row, 2).toString());
		}

	}
}
