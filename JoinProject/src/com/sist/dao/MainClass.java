package com.sist.dao;

import java.util.*;

public class MainClass {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		EmpJoinDAO dao = EmpJoinDAO.newInstance();
		
//		dao = EmpJoinDAO.newInstance();
//		System.out.println("dao = "+dao);
//		dao = EmpJoinDAO.newInstance();
//		System.out.println("dao = "+dao);
//		EmpJoinDAO dao3 = EmpJoinDAO.newInstance();
//		System.out.println("dao3 = "+dao);
		
		List<Emp> list = dao.empJoinData();
		for (Emp e:list) {
			System.out.println(e.getEmpno()+" "
					+e.getEname()+" "
					+e.getJob()+" "
					+e.getDbday()+" "
					+e.getSal()+" "
					+e.getDvo().getDname()+" "
					+e.getDvo().getLoc());
		}
		
		System.out.println("-----------------------------------------------------------");
		
		List<Emp> list1 = dao.empNonEquiJoinData();
		for (Emp e:list1) {
			System.out.println(e.getEmpno()+" "
					+e.getEname()+" "
					+e.getJob()+" "
					+e.getDbday()+" "
					+e.getSal()+" "
					+e.getDvo().getDname()+" "
					+e.getDvo().getLoc()+" "
					+e.getSvo().getGrade());
		}
		
		System.out.println("-----------------------------------------------------------");

		List<Emp> list2 = dao.empOuterJoin();
		for (Emp e:list2) {
			System.out.println(e.getEmpno()+" "
					+e.getEname()+" "
					+e.getJob()+" "
					+e.getDvo().getDname()+" "
					+e.getDvo().getLoc());
		}
	}

}
