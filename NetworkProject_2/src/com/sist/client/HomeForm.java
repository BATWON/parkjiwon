package com.sist.client;
import java.awt.Color;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import com.sist.data.FoodLocationVO;
import com.sist.data.FoodSystem;

public class HomeForm extends JPanel{
    public JButton b1,b2; // 이전 , 다음 
    public JButton m=new JButton();
    public FoodManager mm;
    public FoodSystem ms=new FoodSystem();
    public JLabel pagLa=new JLabel("0 page / 0 pages");
    public HomeForm(ControllerPanel cp)
    {
    	mm=new FoodManager(cp);
    	b1=new JButton("이전");
    	b2=new JButton("다음");
    	JPanel p=new JPanel();
    	String title="검색하기";
    	
    		m=new JButton(title);
    		p.add(m);
    	
    	// 배치 
    	setLayout(null);
    	p.setBounds(0, 0, 840, 35);
//    	p.setOpaque(true);
//    	p.setBackground(Color.orange);
    	add(p);
    	mm.setBounds(0,0, 840, 780);
//    	mm.setOpaque(true);
//    	mm.setBackground(Color.orange);
    	add(mm);
    	
    	JPanel p1=new JPanel();
    	p1.add(b1);
    	p1.add(pagLa);
    	p1.add(b2);
    	
    	p1.setBounds(0, 790, 840, 35);
//    	p1.setOpaque(true);
//    	p1.setBackground(Color.orange);
    	add(p1);
    	
    	// 시작과 동시에 데이터를 받기 
    	ArrayList<FoodLocationVO> list=FoodSystem.foodListData(1);
    	mm.cardPrint(list);
    	
    }
}