package kr.or.dgit.it_3st_2team.ui;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Color;
import java.awt.Container;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import org.junit.rules.TestName;


public class TitleManage extends JFrame implements ActionListener {
	Container cp;
	JTable table;
	TextField tftitleno, tftitlename;
	Button btnAdd, btnDel, btnMod;

	JScrollPane jsp;
	DefaultTableModel model;
	JTable table2;

	String[][] data = { { "1", "사장" }, { "2", "실장" }, { "3", "디자이너" }, { "4", "스텝" } };

	String title[] = { "직책번호", "직책명" };

	int row = -1;

	public TitleManage(String title) {
		super(title);
		cp = this.getContentPane();
		this.setDesign();

		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setBounds(300, 100, 400, 400);
		cp.setBackground(new Color(255, 255, 200));
		this.setVisible(true);
	}

	public void setDesign() {
		cp.setLayout(new BorderLayout());
		// 탑패널 생성
		JPanel pTop = new JPanel();

		/// 텍스트필트 추가시작
		tftitleno = new TextField(5);
		pTop.add(new JLabel("직책번호"));
		pTop.add(tftitleno);

		tftitlename = new TextField(5);
		pTop.add(new JLabel("직책명"));
		pTop.add(tftitlename);

		cp.add("North", pTop);

		JPanel pBottom = new JPanel();

		btnAdd = new Button("추가");
		btnDel = new Button("삭제");
		btnMod = new Button("수정");

		btnAdd.addActionListener(this);
		btnDel.addActionListener(this);
		btnMod.addActionListener(this);

		pBottom.add(btnAdd);
		pBottom.add(btnDel);
		pBottom.add(btnMod);

		cp.add("South", pBottom);

		model = new DefaultTableModel(data, title);
		table2 = new JTable(model);
		jsp = new JScrollPane(table2);
		cp.add("Center", jsp);

		table2.setSelectionBackground(Color.yellow); // 테이블에서 선택시 색 변하게 하는 방법
		table2.setSelectionForeground(Color.MAGENTA); // 테이블에서 선택시 글자색 변하게 하는 방법

		table2.addMouseListener(new TableSelect());

	}

	public static void main(String[] args) {
		new TestName();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		String[] str = new String[4];
		Object ob = e.getSource();

		if (ob == btnAdd) {
			// 입력체크
			if (tftitleno.getText().equals("")) // 주소를 비교하는 것이므로 equals로 비교한다. ==로 하면 안될때가 있다
			{
				JOptionPane.showMessageDialog(this, "상품명을 입력해주세요");
				tftitleno.requestFocus();
				return;
			}

			if (tftitlename.getText().equals("")) // 주소를 비교하는 것이므로 equals로 비교한다. ==로 하면 안될때가 있다
			{
				JOptionPane.showMessageDialog(this, "수량을 입력해주세요");
				tftitlename.requestFocus();
				return;
			}
			str[0] = tftitleno.getText();
			str[1] = tftitlename.getText();

		} else if (ob == btnDel) // 삭제 버튼을 누를때
		{
			if (row == -1) {
				JOptionPane.showMessageDialog(this, "먼저 삭제할 행을 선택해주세요");

				return;
			}

			else {
				JOptionPane.showConfirmDialog(this, "를 삭제할까요?", "삭제", JOptionPane.YES_NO_OPTION,
						JOptionPane.QUESTION_MESSAGE);

				model.removeRow(row);
				row = -1;
				this.clearData();

			}
		} else if (ob == btnMod) {

			if (row == -1) {
				JOptionPane.showConfirmDialog(this, "먼저 수정할 행을 선택해주세요", "수정확인", JOptionPane.INFORMATION_MESSAGE);

				return;
			}
			model.setValueAt(tftitleno.getText(), row, 0);
			model.setValueAt(tftitlename.getText(), row, 1);
		}

	}

	public void clearData() {

		tftitleno.setText(""); // 텍스트필드 창을 지운다.
		tftitlename.setText("");
		tftitleno.requestFocus(); // tfSang 텍스트 필드로 커서를 가져온다.
	}

	class TableSelect extends MouseAdapter {

		@Override
		public void mouseClicked(MouseEvent e) {
			row = table2.getSelectedRow(); // 테이블에서 선택된 행의 값을 row에 저장한다.

			// 행번호와 행의 데이터 텍스트 필드에 출력하기
			tftitleno.setText((String) table2.getValueAt(row, 0));
			tftitlename.setText((String) table2.getValueAt(row, 1));
		}

	}

}