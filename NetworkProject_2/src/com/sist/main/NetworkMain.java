package com.sist.main;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.URL;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.UIManager;

import com.sist.client.ControllerPanel;
import com.sist.client.LoginForm;
import com.sist.client.MenuForm;
import com.sist.client.WaitForm;
import com.sist.data.FoodLocationVO;
import com.sist.data.FoodSystem;

public class NetworkMain extends JFrame implements ActionListener{
    MenuForm menu=new MenuForm();
    ControllerPanel cp=new ControllerPanel();
    WaitForm wr=new WaitForm();
//    LoginForm lf = new LoginForm();
    int curpage=1;
    int totalpage=0;
    int cno=1;
    public NetworkMain()
    {
    	setTitle("네트워크 맛집 프로그램");
    	setLayout(null);// 사용자 정의 (직접 배치)
    	menu.setBounds(10, 15, 100, 350);
    	add(menu);
    	
    	cp.setBounds(120, 15, 850, 820);
    	add(cp);
//    	
    	wr.setBounds(980, 15, 250, 700);
    	add(wr);
    	
    	setSize(1250, 900);
    	setVisible(true);
    	// 종료 
    	setDefaultCloseOperation(EXIT_ON_CLOSE);
    	// 이벤트 등록 
    	
    		cp.hf.m.addActionListener(this);
    	
    	
    	cp.hf.b1.addActionListener(this);// 이전
    	cp.hf.b2.addActionListener(this);// 다음 
    	
    	totalpage=FoodSystem.musicTotalPage();
    	cp.hf.pagLa.setText(curpage+ " page / "+totalpage+" pages");
    	
    	// 1. menu 클릭
    	menu.chatBtn.addActionListener(this);
    	menu.exitBtn.addActionListener(this);
    	menu.homeBtn.addActionListener(this);
    	menu.newsBtn.addActionListener(this);
    	menu.foodBtn.addActionListener(this);
    	
    	cp.mf.btn.addActionListener(this);
    }
    public static Image getImage(ImageIcon ii,int width,int height)
    {
    	Image dimg=ii.getImage().getScaledInstance(width, height, Image.SCALE_SMOOTH);
    	return dimg;
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try
		{
			UIManager.setLookAndFeel("com.jtattoo.plaf.mcwin.McWinLookAndFeel");
		}catch(Exception ex){}
		new NetworkMain();
	}
	// 버튼 클릭시 처리 => 구현이 안됨 => 클릭을 하면 자동 시스템(JVM)에 의핸 자동 호출 

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource()==cp.hf.b1)// 이전 
			{
				if(curpage>1)
				{
					curpage--;
					ArrayList<FoodLocationVO> list=
							   cp.hf.ms.foodListData(curpage);
					
					cp.hf.mm.cardInit(list);
					cp.hf.mm.cardPrint(list);
					
					cp.hf.pagLa.setText(curpage+ " page / "+totalpage+" pages");
				}
			}
			else if(e.getSource()==cp.hf.b2) // 다음 
			{
				if(curpage<totalpage)
				{
					curpage++;
					ArrayList<FoodLocationVO> list=
							   cp.hf.ms.foodListData(curpage);
					
					cp.hf.mm.cardInit(list);
					cp.hf.mm.cardPrint(list);
					
					cp.hf.pagLa.setText(curpage+ " page / "+totalpage+" pages");
				}
			} else if (e.getSource()==menu.exitBtn) {
				System.exit(0);
			} else if (e.getSource()==menu.foodBtn) {
				cp.card.show(cp, "MF");
			} else if (e.getSource()==menu.homeBtn) {
				cp.card.show(cp, "HF");
			} else if (e.getSource()==cp.mf.btn) {	// 검색 버튼 클릭시
				// 1. 입력값 읽어오기
				String fd = cp.mf.tf.getText();
				if (fd.length()<1) {	// 입력이 안 된 상태
					JOptionPane.showMessageDialog(this, "검색어를 입력하세요");
					cp.mf.tf.requestFocus();
					return;
				}
				ArrayList<FoodLocationVO> fList = FoodSystem.foodFind(fd);
				for(int i=cp.mf.model.getRowCount()-1; i>=0; i--) {	// 출력된 내용 지우기
					cp.mf.model.removeRow(i);
				}	// 밑에서부터 지우기
				try {
						for (FoodLocationVO m:fList) {
							URL url = new URL(m.getPoster());
							Image img = getImage(new ImageIcon(url), 35, 30);
							Object[] data = {
									m.getNo(),
									new ImageIcon(img),
									m.getName(),
									m.getAddress()
							};
							cp.mf.model.addRow(data);
						}
				} catch(Exception ex) {}
			}

					curpage=1;

					ArrayList<FoodLocationVO> list=
							   cp.hf.ms.foodListData(curpage);
					
					cp.hf.mm.cardInit(list);
					cp.hf.mm.cardPrint(list);
					
					cp.hf.pagLa.setText(curpage+ " page / "+totalpage+" pages");

	}

	

}
