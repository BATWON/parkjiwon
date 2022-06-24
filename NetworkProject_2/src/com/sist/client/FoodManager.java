package com.sist.client;

import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;

import javax.swing.JPanel;

import com.sist.data.FoodLocationVO;
//import com.sist.main.FoodMain;
public class FoodManager extends JPanel implements MouseListener{
    public PosterCard[] foods=new PosterCard[15];
    public JPanel pan=new JPanel();
    public ControllerPanel cp;
    public FoodManager(ControllerPanel cp)
    {
    	this.cp=cp;
    }
    public void cardPrint(ArrayList<FoodLocationVO> list)
    {
    	setLayout(null);
    	//JPanel p=new JPanel();
    	pan.setLayout(new GridLayout(3,5));
    	int i=0;
    	for(FoodLocationVO m:list)
    	{
    		
    		foods[i]=new PosterCard();
        	foods[i].setOpaque(true);
        	foods[i].setBackground(Color.yellow);
    		pan.add(foods[i]);
    		foods[i].addMouseListener(this);
    		i++;
    	}
    	
    	pan.setBounds(10, 35, 840, 750);
//    	pan.setOpaque(true);
//    	pan.setBackground(Color.pink);
    	add(pan);
    	
    	
    }
    public void cardInit(ArrayList<FoodLocationVO> list)
    {
    	for(int i=0;i<list.size();i++)
    	{
    		
    		foods[i].poster.setIcon(null);
    		foods[i].name.setText("");
    		foods[i].address.setText("");
   
    	}
    	pan.removeAll();
		pan.validate();
    }
	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
//		for(int i=0;i<musics.length;i++)
//		{
//			if(e.getSource()==musics[i])
//			{
//				String title=musics[i].title.getText();
//				for(int j=0;j<MusicSystem.getList().size();j++)
//				{
//					Music m=MusicSystem.getList().get(j);
//					if(m.getTitle().equals(title))
//					{
//						cp.df.album.setText(m.getAlbum());
//						cp.df.title.setText(m.getTitle());
//						cp.df.singer.setText(m.getSinger());
//						String s="";
//						if(m.getState().equals("유지"))
//						{
//							s="-";
//						}
//						else if(m.getState().equals("상승"))
//						{
//							s="▲"+m.getIdcrement();
//						}
//						else if(m.getState().equals("하강"))
//						{
//							s="▼"+m.getIdcrement();
//						}
//						cp.df.idcrement.setText(s);
//						cp.df.movie.setText(m.getKey());
//						try
//				    	{
//				    		URL url=new URL("http:"+m.getPoster());
//				    		Image img=NetworkMain.getImage(new ImageIcon(url), 350, 250);
//				    		cp.df.posterLa.setIcon(new ImageIcon(img));
//				    		
//				    	}catch(Exception ex) {}
//						break;
//					}
//				}
//				cp.card.show(cp, "DF");// 화면 이동 
//			}
//		}
	}
	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
}
