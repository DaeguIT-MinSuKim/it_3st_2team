package kr.or.dgit.it_3st_2team.ui;

import java.awt.BorderLayout;

import javax.swing.JLabel;
import javax.swing.JPanel;

public class EnrollSearchCase2 extends JPanel {

	/**
	 * Create the panel.
	 */
	public EnrollSearchCase2() {

		initComponents();
	}
	private void initComponents() {
		setLayout(new BorderLayout(0, 0));
		
		JLabel lblNewLabel = new JLabel("고객별 검색");
		add(lblNewLabel);
	}

}
