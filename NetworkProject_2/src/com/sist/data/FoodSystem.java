package com.sist.data;

import java.io.FileInputStream;
import java.io.ObjectInputStream;
import java.util.ArrayList;

public class FoodSystem {
	   private static ArrayList<FoodLocationVO> list=
		          new ArrayList<FoodLocationVO>();
	   
	   static
	   {
		   try
		   {
			   FileInputStream fis=
					   new FileInputStream("c:\\java_data\\food.txt");
			   ObjectInputStream ois=
					   new ObjectInputStream(fis);
			   list=(ArrayList<FoodLocationVO>)ois.readObject();
			   ois.close();
			   fis.close();
		   }catch(Exception ex){}
	   }
	   
	   public static ArrayList<FoodLocationVO> getList() {
			  return list;
		    }
			public static ArrayList<FoodLocationVO> foodListData(int page)
		    {
			   ArrayList<FoodLocationVO> cList=
					   new ArrayList<FoodLocationVO>();
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
				   FoodLocationVO m=list.get(i);
				     if(j<15)// && i>=(pagecnt+((cno-1)*100)))
					 {
						   cList.add(m);
						   j++;
					 }
				  
			   }
			   return cList;
		   }
			

	public static int musicTotalPage()
	{
		   return (int)(Math.ceil(10000/15.0));
	}
	public static void main(String[] args) {
		   ArrayList<FoodLocationVO> list=foodListData(1);
		   for(FoodLocationVO m:list)
		   {
			   System.out.println(m.getNo()+"."+m.getName());
		   }
		   
		}
	
	   public static ArrayList<FoodLocationVO> foodFind(String fd){
		   ArrayList<FoodLocationVO> fList = new ArrayList<FoodLocationVO>();
		   for (FoodLocationVO m:list) {
			   if(m.getName().contains(fd)) {
				   fList.add(m);
			   }
		   }
		   return fList;
	   }
	
	public static ArrayList<FoodLocationVO> foodTop10(){
		   ArrayList<FoodLocationVO> tList = new ArrayList<FoodLocationVO>();
		   for (int i=0; i<10; i++) {
			   FoodLocationVO m = list.get(i);
			   tList.add(m);
		   }
		   return tList;
	}
}
