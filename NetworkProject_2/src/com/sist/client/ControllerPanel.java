package com.sist.client;

import java.awt.*;

import javax.swing.*;
public class ControllerPanel extends JPanel{
	public CardLayout card=new CardLayout();
	public HomeForm hf;
	public DetailForm df;
	public FoodFindForm mf = new FoodFindForm();
    public ControllerPanel()
    {
    	hf=new HomeForm(this);
    	df=new DetailForm(this);
    	setLayout(card);
    	add("HF",hf);
    	add("DF",df);
    	add("MF",mf);
    }
    
}