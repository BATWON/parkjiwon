package com.sist.client;

/*
 * 	Container (윈도우창)
 * 		- JFrame : 일반 윈도우 창
 * 		- JPanel : 단독 실행 불가 (JFrame, JDialong)
 * 			=> 변경되는 화면
 * 		- JWindow : 타이틀바가 없는 창
 * 		- JDialog : 창 위에 창
 * 	Component
 * 		- 기능이 한 개인 윈도우 => 단독 실행 불가능 => JFrame, JPanel
 * 		- Button
 * 			- JButton ==> <input type=button>
 * 			- JRadioButton ==> <input type=radio>
 * 			- JCheckBox ==> <input type=checkbox>
 * 		- 입력창
 * 			- 한 줄 입력 : JTextField, JPasswordField
 * 						  ==> <input type=text>
 * 						  ==> <input type=password>
 * 			- 여러 줄 입력 : JTextArea(메모장) => JTextPane(word)
 * 							==> <textarea>
 * 		- JLabel : 기능 없이 보여만 줌 (이미지) <label>
 */
import javax.swing.*;	// Container, Component 
import java.awt.*;
import javax.swing.table.*;

public class MusicFindForm extends JPanel {

	public JTextField tf;
	public JButton btn;
	public JTable table;
	public DefaultTableModel model;
	
	// 초기화
	public MusicFindForm() {
		tf=new JTextField();
		btn = new JButton("검색");
		String[] col = {"순위", "", "곡명", "가수명"};
		// 순위:int 사진:ImageIcon 곡명,가수명:String => Object
		Object[][] row = new Object[0][4];
		model = new DefaultTableModel(row, col) {
			// 이미지 출력
			@Override
			public boolean isCellEditable(int row, int column) {
				// TODO Auto-generated method stub
				return false;	// 편집 방지
			}

			@Override
			public Class<?> getColumnClass(int columnIndex) {
				// TODO Auto-generated method stub
				return getValueAt(0, columnIndex).getClass();
			}
			
		};	// 익명의 클래스 => 생성자 안에서 재정의
		table = new JTable(model);
		table.setRowHeight(40);
		table.setShowGrid(false);
		table.setShowHorizontalLines(true);
		table.getTableHeader().setReorderingAllowed(false);
		JScrollPane js = new JScrollPane(table);
		
		// 배치
		
		setLayout(null);	// 직접 배치
		tf.setBounds(10, 15, 200, 30);
		btn.setBounds(215, 15, 100, 30);
		js.setBounds(10, 55, 800, 500);
		
		add(tf);
		add(btn);
		add(js);
		
		
		
		
	}
	
	
	
}
