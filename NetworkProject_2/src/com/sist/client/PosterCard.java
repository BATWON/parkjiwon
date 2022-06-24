package com.sist.client;
import java.awt.Color;
import java.awt.Image;
import java.net.URL;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.LineBorder;

import com.sist.data.FoodLocationVO;
import com.sist.data.FoodMain;
import com.sist.main.NetworkMain;
public class PosterCard extends JPanel{
    JLabel poster=new JLabel();
    JLabel name=new JLabel();
    JLabel address =new JLabel();
    //FoodLocationVO m
    public PosterCard()
    {
    	poster.setBorder(new LineBorder(Color.blue,2));
    	name.setBorder(new LineBorder(Color.red,1));
    	address.setBorder(new LineBorder(Color.red,1));
    	setLayout(null);
    	poster.setBounds(5,5,165,170);
    	poster.setOpaque(true);
    	poster.setBackground(Color.pink);
    	try
    	{
    		
    		URL url=new URL("");
    		Image img=NetworkMain.getImage(new ImageIcon(url), 168, 170);
    		poster.setIcon(new ImageIcon(img));
    	}catch(Exception ex) {}
    	
    	name.setBounds(5,180, 165, 30);
    	name.setOpaque(true);
    	name.setBackground(Color.orange);
//    	name.setText(m.getName());
    	address.setBounds(5, 215 , 165, 30);
    	address.setOpaque(true);
    	address.setBackground(Color.cyan);
//    	address.setText(m.getAddress());
    	add(poster);
    	add(name);
    	add(address);
    }
}
