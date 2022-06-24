package com.sist.client;
import java.awt.*;
import javax.swing.*;
public class MenuForm extends JPanel{
     public JButton homeBtn,musicBtn,chatBtn,exitBtn,newsBtn;
     // 초기화 
     public MenuForm()
     {
    	 setLayout(new GridLayout(5,1,10,10));
    	 homeBtn=new JButton("홈");
    	 // <input type=button value="홈">
    	 musicBtn=new JButton("뮤직");
    	 chatBtn=new JButton("채팅");
    	 exitBtn=new JButton("종료");
    	 newsBtn=new JButton("뉴스");// JSON => 네이버뉴스 (openApi)
    	 // 배치 
    	 add(homeBtn);
    	 add(musicBtn);
    	 add(chatBtn);
    	 add(newsBtn);
    	 add(exitBtn);
     }
}