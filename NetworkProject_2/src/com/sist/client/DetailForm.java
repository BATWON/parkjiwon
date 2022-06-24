package com.sist.client;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class DetailForm extends JPanel implements ActionListener{
   public ControllerPanel cp;
   JLabel posterLa=new JLabel();
   JLabel address=new JLabel();
   JLabel tel=new JLabel();
   JLabel type=new JLabel();
   JLabel price=new JLabel();
   JLabel parking=new JLabel();
   JLabel time=new JLabel();
   JLabel menu=new JLabel();
   JButton b1;
   public DetailForm(ControllerPanel cp)
   {
	   b1=new JButton("목록");
//	   b2=new JButton("동영상");
	   this.cp=cp;
	   //setBackground(Color.cyan);
//	   // 배치 
	   setLayout(null);
	   posterLa.setBounds(10, 15, 350, 250 );
	   address.setBounds(365, 15, 400, 35);
	   tel.setBounds(365, 55, 400, 35);
	   type.setBounds(365, 95, 400, 35);
	   price.setBounds(365, 135, 400, 35);
	   parking.setBounds(365, 175, 400, 35);
	   time.setBounds(365, 215, 400, 35);
	   menu.setBounds(365, 255, 400, 35);
//	   movie.setVisible(false);
	   JPanel p=new JPanel();
	   p.add(b1);//p.add(b2);
	   p.setBounds(365, 220, 400, 35);
//	   
	   add(posterLa);add(address);
	   add(tel);add(type);
	   add(price);add(parking);
	   add(time);add(menu);
	   add(p);//add(movie);
//	   
	   b1.addActionListener(this);
//	   b2.addActionListener(this);
   }

@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource()==b1)
		{
			cp.card.show(cp,"HF");
		}
	//	else if(e.getSource()==b2)
	//	{
	//		try
	//		{
	//			Runtime.getRuntime().exec("\"C:\\Program Files (x86)\\Google\\Chrome\\Application\\chrome.exe "
	//					             +"http://youtube.com/embed/"+movie.getText());
	//		}catch(Exception ex){}
	}
}
