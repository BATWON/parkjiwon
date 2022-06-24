package com.sist.main;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.UIManager;

import com.sist.client.ControllerPanel;
import com.sist.client.MenuForm;
import com.sist.client.WaitForm;
import com.sist.data.FoodLocationVO;
import com.sist.data.FoodSystem;
public class NetworkMain extends JFrame implements ActionListener{
    MenuForm menu=new MenuForm();
    ControllerPanel cp=new ControllerPanel();
    WaitForm wr=new WaitForm();
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
    	
    	/*for(int i=0;i<cp.hf.mm.musics.length;i++)
    	{
    		cp.hf.mm.musics[i].addMouseListener(this);
    	}*/
    	
    	totalpage=FoodSystem.musicTotalPage();
    	cp.hf.pagLa.setText(curpage+ " page / "+totalpage+" pages");
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
//	@Override
//	public void actionPerformed(ActionEvent e) {
//		// TODO Auto-generated method stub
//		if(e.getSource()==cp.hf.b1)// 이전 
//		{
//			if(curpage>1)
//			{
//				curpage--;
//				ArrayList<Music> list=
//						   cp.hf.ms.musicListData(cno, curpage);
//				
//				cp.hf.mm.cardInit(list);
//				cp.hf.mm.cardPrint(list);
//				
//				cp.hf.pagLa.setText(curpage+ " page / "+totalpage+" pages");
//			}
//		}
//		else if(e.getSource()==cp.hf.b2) // 다음 
//		{
//			if(curpage<totalpage)
//			{
//				System.out.println("cno="+cno);
//				curpage++;
//				ArrayList<Music> list=
//						   cp.hf.ms.musicListData(cno, curpage);
//				
//				cp.hf.mm.cardInit(list);
//				cp.hf.mm.cardPrint(list);
//				
//				cp.hf.pagLa.setText(curpage+ " page / "+totalpage+" pages");
//			}
//		}
//		for(int i=0;i<cp.hf.m.length;i++)
//		{
//			if(e.getSource()==cp.hf.m[i])
//			{
//				curpage=1;
//				cno=i+1;
//				//System.out.println("button Click:"+(i+1));
//				ArrayList<Music> list=
//						   cp.hf.ms.musicListData(cno, curpage);
//				
//				cp.hf.mm.cardInit(list);
//				cp.hf.mm.cardPrint(list);
//				
//				cp.hf.pagLa.setText(curpage+ " page / "+totalpage+" pages");
//			}
//		}
//	}
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
//			else if(e.getSource()==cp.hf.b2) // 다음 
//			{
//				if(curpage<totalpage)
//				{
//					System.out.println("cno="+cno);
//					curpage++;
//					ArrayList<FoodHouseVO> list=
//							   cp.hf.ms.foodListData(curpage);
//					
//					cp.hf.mm.cardInit(list);
//					cp.hf.mm.cardPrint(list);
//					
//					cp.hf.pagLa.setText(curpage+ " page / "+totalpage+" pages");
//				}
//			}
//			for(int i=0;i<cp.hf.m.length;i++)
//			{
//				if(e.getSource()==cp.hf.m[i])
//				{
//					curpage=1;
//					cno=i+1;
//					//System.out.println("button Click:"+(i+1));
//					ArrayList<Music> list=
//							   cp.hf.ms.musicListData(cno, curpage);
//					
//					cp.hf.mm.cardInit(list);
//					cp.hf.mm.cardPrint(list);
//					
//					cp.hf.pagLa.setText(curpage+ " page / "+totalpage+" pages");
//				}
//			}
	}

	

}
