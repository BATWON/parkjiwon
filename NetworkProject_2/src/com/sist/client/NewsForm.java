package com.sist.client;

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.util.ArrayList;

import javax.swing.JLabel;
import javax.swing.JPanel;

import com.sist.data.NaverNewsMain;
import com.sist.data.News;

public class NewsForm extends JPanel {
	public NewsCard[] nc = new NewsCard[10];
	JLabel la = new JLabel("실시간 네이버 뉴스", JLabel.CENTER);
	
//	String data="뮤직";
	
	public NewsForm() {
		ArrayList<News> list = NaverNewsMain.newsAllData();
		JPanel p = new JPanel();
		p.setLayout(new GridLayout(10,1,5,10));
		for(int i=0; i<nc.length; i++) {
			nc[i] = new NewsCard();
			nc[i].la.setText(list.get(i).getTitle());
			nc[i].ta.setText(list.get(i).getDescription());
			p.add(nc[i]);
		}
		
		setLayout(new BorderLayout());
		la.setFont(new Font("궁서체",Font.BOLD,45));
		add("North",la);
		add("Center",p);
	}
}
