package com.sist.data;

import java.util.ArrayList;
import java.io.*;

// DAO => 웹(오라클)
public class MusicSystem {
   private static ArrayList<Music> list=
		          new ArrayList<Music>();
   // 초기화 
   static
   {
	   try
	   {
		   FileInputStream fis=
				   new FileInputStream("c:\\java_data\\music.txt");
		   ObjectInputStream ois=
				   new ObjectInputStream(fis);
		   list=(ArrayList<Music>)ois.readObject();
		   ois.close();
		   fis.close();
	   }catch(Exception ex){}
   }
   
    public static ArrayList<Music> getList() {
	  return list;
    }
	public static ArrayList<Music> musicListData(int cno,int page)
    {
	   ArrayList<Music> cList=
			   new ArrayList<Music>();
	   // 페이지 나누기 
	   int j=0;
	   // 100  115  130
	   // 
	   int pagecnt=(page*15)-15;
	   /*
	    *    list.size ==> 700  (0~699)
	    *    cno  1 => 1
	    *    cno  2 => 100
	    *    cno  3 => 200
	    *    cno  4 => 300...
	    */
	   for(int i=0;i<list.size();i++)
	   {
		     Music m=list.get(i);
		     if(j<15 && i>=(pagecnt+((cno-1)*100)))
			 {
				   cList.add(m);
				   j++;
			 }
		  
	   }
	   return cList;
   }
   public static int musicToalPage()
   {
	   return (int)(Math.ceil(100/15.0));
   }
   public static void main(String[] args) {
	   ArrayList<Music> list=musicListData(7, 3);
	   for(Music m:list)
	   {
		   System.out.println(m.getMno()+"."+m.getTitle());
	   }
	   
   }
   
   public static ArrayList<Music> musicFind(String fd){
	   ArrayList<Music> fList = new ArrayList<Music>();
	   for (Music m:list) {
		   if(m.getTitle().contains(fd)) {
			   fList.add(m);
		   }
	   }
	   return fList;
   }
   
   public static ArrayList<Music> musicTop10(){
	   ArrayList<Music> tList = new ArrayList<Music>();
	   for (int i=0; i<10; i++) {
		   Music m = list.get(i);
		   tList.add(m);
	   }
	   return tList;
   }
   
}
