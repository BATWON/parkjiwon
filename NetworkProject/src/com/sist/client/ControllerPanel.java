package com.sist.client;

import java.awt.*;
import javax.swing.*;

// Controller => 화면 이동
public class ControllerPanel extends JPanel{
	public CardLayout card=new CardLayout();
	public HomeForm hf;
	public DetailForm df;
	public MusicFindForm mf = new MusicFindForm();
//	public LoginForm lf = new LoginForm();
    public ControllerPanel()
    {
    	hf=new HomeForm(this);
    	df=new DetailForm(this);
    	setLayout(card);
//    	add("LF",lf);
    	add("HF",hf);
    	add("DF",df);
    	add("MF",mf);
    }
}