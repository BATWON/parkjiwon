package com.sist.client;

import javax.swing.ImageIcon;
import javax.swing.JPanel;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.net.URL;
import java.util.*;
import com.sist.data.*;
import com.sist.main.NetworkMain;
public class MusicManager extends JPanel implements MouseListener{
    public PosterCard[] musics=new PosterCard[15];
    public JPanel pan=new JPanel();
    public ControllerPanel cp;
    public MusicManager(ControllerPanel cp)
    {
    	this.cp=cp;
    }
    public void cardPrint(ArrayList<Music> list)
    {
    	setLayout(null);
    	//JPanel p=new JPanel();
    	pan.setLayout(new GridLayout(3,5));
    	int i=0;
    	for(Music m:list)
    	{
    		
    		musics[i]=new PosterCard(m);
    		pan.add(musics[i]);
    		musics[i].addMouseListener(this);
    		i++;
    	}
    	
    	pan.setBounds(10, 35, 840, 750);
    	add(pan);
    	
    	
    }
    public void cardInit(ArrayList<Music> list)
    {
    	for(int i=0;i<list.size();i++)
    	{
    		
    		musics[i].poster.setIcon(null);
    		musics[i].singer.setText("");
    		musics[i].title.setText("");
   
    	}
    	pan.removeAll();
		pan.validate();
    }
	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		for(int i=0;i<musics.length;i++)
		{
			if(e.getSource()==musics[i])
			{
				String title=musics[i].title.getText();
				for(int j=0;j<MusicSystem.getList().size();j++)
				{
					Music m=MusicSystem.getList().get(j);
					if(m.getTitle().equals(title))
					{
						cp.df.album.setText(m.getAlbum());
						cp.df.title.setText(m.getTitle());
						cp.df.singer.setText(m.getSinger());
						String s="";
						if(m.getState().equals("유지"))
						{
							s="-";
						}
						else if(m.getState().equals("상승"))
						{
							s="▲"+m.getIdcrement();
						}
						else if(m.getState().equals("하강"))
						{
							s="▼"+m.getIdcrement();
						}
						cp.df.idcrement.setText(s);
						cp.df.movie.setText(m.getKey());
						try
				    	{
				    		URL url=new URL("http:"+m.getPoster());
				    		Image img=NetworkMain.getImage(new ImageIcon(url), 350, 250);
				    		cp.df.posterLa.setIcon(new ImageIcon(img));
				    		
				    	}catch(Exception ex) {}
						break;
					}
				}
				cp.card.show(cp, "DF");// 화면 이동 
			}
		}
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