package com.sist.client;

import java.awt.Image;
import java.net.URL;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import com.sist.data.FoodLocationVO;
import com.sist.data.FoodSystem;
//import com.sist.data.Music;
import com.sist.main.NetworkMain;
// Network 
public class WaitForm extends JPanel{
	JTable table;
	DefaultTableModel model;
//	JTextArea ta;
//	JTextField tf;
//	JButton b1,b2;
    public WaitForm()
    {
//    	String[] col={"ID","Name","Sex"};
//    	String[][] row=new String[0][3];
//    	model=new DefaultTableModel(row,col);
    	String[] col={"","Name"};
    	Object[][] row=new Object[0][3];
    	model=new DefaultTableModel(row,col) {	// 익명의 클래스 => 상속없이 오버라이딩

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
    		
    	};

    	table=new JTable(model);
    	table.setRowHeight(50);
    	JScrollPane js1=new JScrollPane(table);
    	
//    	ta=new JTextArea();
//    	ta.setEditable(false);
//    	JScrollPane js2=new JScrollPane(ta);
//    	
//    	tf=new JTextField();
//    	
//    	b1=new JButton("쪽지보내기");
//    	b2=new JButton("정보보기");
    	
    	// 배치
    	setLayout(null);// 사용자 정의
//    	js2.setBounds(0, 15, 250, 250);
//    	add(js2);
//    	
//    	tf.setBounds(0, 270, 250, 30);
//    	add(tf);
    	
    	js1.setBounds(0, 320 , 250, 250);
    	add(js1);
    	
       	try {
    		ArrayList<FoodLocationVO> list = FoodSystem.foodTop10();
    		for(FoodLocationVO m:list) {
    			URL url = new URL(m.getPoster());
    			Image img = NetworkMain.getImage(new ImageIcon(url), 50, 45);
    			Object[] data = {
    				new ImageIcon(img),
    				m.getName()
    			};
    			model.addRow(data);
    		}
    	} catch(Exception ex) {}
    	
//    	JPanel p=new JPanel();
//    	p.add(b1);
//    	p.add(b2);
//    	p.setBounds(0, 580, 250, 35);
//    	add(p);
    	
    }
}
