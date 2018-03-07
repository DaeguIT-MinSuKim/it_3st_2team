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

import kr.or.dgit.it_3st_2team.dto.Title;
import kr.or.dgit.it_3st_2team.service.TitleService;

@SuppressWarnings("serial")
public class TitleManage extends JFrame implements ActionListener {

	private static final AbstractButton tftitleno = null;
	private JPanel contentPane;
	private JTable table;
	private TextField Titleno;
	private TextField Titlename;
	int row = -1;
	private TitleService tservice;

	private String[] title = { "직책번호", "직책명" };

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
					TitleManage frame = new TitleManage();
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
	public TitleManage() {
		tservice = new TitleService();
		initComponents();
	}

	private void initComponents() {
		setTitle("직책등록");
		/*yyj 03-07수정 이창만 닫기*/
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 385, 300);
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

		lTitle();

		table.setSelectionBackground(Color.yellow);
		table.setSelectionForeground(Color.MAGENTA);

		table.addMouseListener(new TableSelect());

		JPanel panel_1 = new JPanel();
		contentPane.add(panel_1, BorderLayout.NORTH);
		panel_1.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));

		JPanel panel_2 = new JPanel();
		panel_1.add(panel_2);

		JLabel lbltitleno = new JLabel("직책번호");
		panel_2.add(lbltitleno);

		Titleno = new TextField(5);
		panel_2.add(Titleno);

		JLabel lbltitlename = new JLabel("직책명");
		panel_2.add(lbltitlename);

		Titlename = new TextField(5);
		panel_2.add(Titlename);

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

	private void lTitle() {
		List<Title> lists = null;
		TitleService service = new TitleService();
		lists = service.selectTitle();
		System.out.println(lists);
		Object[][] data = getRows(lists);

		model = new DefaultTableModel(data, title) {
			public boolean isCellEditable(int rowIndex, int mColIndex) {
				return false;
			}
		};
		table.setModel(model);
	}

	private Object[][] getRows(List<Title> lists) {
		Object[][] rows = new Object[lists.size()][];
		for (int i = 0; i < lists.size(); i++) {
			rows[i] = lists.get(i).toArray();
		}
		return rows;
	}

	public void clearData() {

		Titleno.setText(""); // 텍스트필드 창을 지운다.
		Titlename.setText("");
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
		String[] str = new String[2];
		Object ob = e.getSource();

		if (row == -1) {
			JOptionPane.showConfirmDialog(this, "먼저 수정할 행을 선택해주세요", "수정확인", JOptionPane.INFORMATION_MESSAGE);

			return;
		}

		str[0] = Titleno.getText();
		str[1] = Titlename.getText();
		tservice.updateTitle(new Title(Integer.parseInt(str[0]), str[1]));
		lTitle();
		// model.setValueAt(Titleno.getText(), row, 0);
		// model.setValueAt(Titlename.getText(), row, 1);

	}

	private void actionPerformedBtnDel(ActionEvent e) {
		int row = table.getSelectedRow();
		int Titleno = (int) (table.getValueAt(row, 0));
		if (row == -1) {
			JOptionPane.showMessageDialog(this, "먼저 삭제할 행을 선택해주세요");

			return;
		}

		else {
			int b = JOptionPane.showConfirmDialog(this, "데이터를 삭제할까요?", "삭제", JOptionPane.YES_NO_OPTION,
					JOptionPane.QUESTION_MESSAGE);
			if (b == 0) {
				tservice.deleteTitle(Titleno);
				row = -1;
				this.clearData();
				lTitle();
			}
		}

	}

	protected void actionPerformedBtnAdd(ActionEvent e) {
		String[] str = new String[2];
		Object ob = e.getSource();
		if (Titleno.getText().equals("")) {
			JOptionPane.showMessageDialog(this, "직책번호를 입력해주세요");
			Titleno.requestFocus();
			return;
		}
		if (Titlename.getText().equals("")) {
			JOptionPane.showMessageDialog(this, "직책명을 입력해주세요");
			Titlename.requestFocus();
			return;
		}

		str[0] = Titleno.getText();
		str[1] = Titlename.getText();

		// model.addRow(str);

		tservice.insertTitle(new Title(Integer.parseInt(str[0]), str[1]));
		lTitle();
	}

	class TableSelect extends MouseAdapter {

		@Override
		public void mouseClicked(MouseEvent e) {
			row = table.getSelectedRow(); // 테이블에서 선택된 행의 값을 row에 저장한다.

			System.out.println(table.getValueAt(row, 0));
			Titleno.setText(table.getValueAt(row, 0).toString());
			// 행번호와 행의 데이터 텍스트 필드에 출력하기
			// Titleno.setText( (String) table.getValueAt(row , 0));
			Titlename.setText((String) table.getValueAt(row, 1));
		}

	}
}
