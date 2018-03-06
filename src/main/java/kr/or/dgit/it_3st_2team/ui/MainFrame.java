package kr.or.dgit.it_3st_2team.ui;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.FlowLayout;

//khj (테스트용. 삭제예정)
public class MainFrame extends JFrame implements ActionListener {


	private JPanel contentPane;
	private JMenuItem mntmNewMenuItem;
	private JMenuItem mntmNewMenuItem_1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainFrame frame = new MainFrame();
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
	public MainFrame() {
		initComponents();
	}
	private void initComponents() {
		setTitle("hairshop");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 461, 281);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		
		JMenuBar menuBar = new JMenuBar();
		contentPane.add(menuBar, BorderLayout.NORTH);
		
		JMenu mnNewMenu = new JMenu("고객관리");
		menuBar.add(mnNewMenu);
		
		mntmNewMenuItem = new JMenuItem("헤어주문");
		mntmNewMenuItem.addActionListener(this);
		mnNewMenu.add(mntmNewMenuItem);
		
		JMenu mnNewMenu_1 = new JMenu("운영");
		menuBar.add(mnNewMenu_1);
		
		mntmNewMenuItem_1 = new JMenuItem("차트 현황");
		mntmNewMenuItem_1.addActionListener(this);
		mnNewMenu_1.add(mntmNewMenuItem_1);
	}

	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == mntmNewMenuItem_1) {
			actionPerformedMntmNewMenuItem_1(e);
		}
		if (e.getSource() == mntmNewMenuItem) {
			actionPerformedMntmNewMenuItem(e);
		}
	}
	protected void actionPerformedMntmNewMenuItem(ActionEvent e) {
		/*Container cp = getContentPane();
		EnrollPanel en = new EnrollPanel();
		
		cp.add(en);
		revalidate();
		repaint();*/
		/*EnrollFrame ef = new EnrollFrame();
		ef.setVisible(true);*/
		
		EnrollFrame ef = new EnrollFrame();
		ef.setVisible(true);
	}
	protected void actionPerformedMntmNewMenuItem_1(ActionEvent e) {
		PolylineBarChart cf = new PolylineBarChart();
		setContentPane(cf);
		validate();
	}
}
