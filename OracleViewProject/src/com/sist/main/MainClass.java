package com.sist.main;

import java.util.*;
import com.sist.dao.*;

public class MainClass {
	
	public static void main(String[] args) {
		EmpDeptDAO dao = EmpDeptDAO.newInstance();
		
		System.out.println("---------------- JOIN ----------------");
		List<EmpDeptVO> list = dao.empDeptListdata1();
		for (EmpDeptVO vo:list) {
			System.out.println(vo.getEname()+" "
					+vo.getDname()+" "
					+vo.getJob()+" "
					+vo.getLoc()+" "
					+vo.getGrade());
		}
		
		System.out.println("-------------- (복합)VIEW --------------");
		list = dao.empDeptListdata2();
		for (EmpDeptVO vo:list) {
			System.out.println(vo.getEname()+" "
					+vo.getDname()+" "
					+vo.getJob()+" "
					+vo.getLoc()+" "
					+vo.getGrade());
		}
		
		System.out.println("------------- 스칼라 서브쿼리 -------------");
		list = dao.empDeptListdata3();
		for (EmpDeptVO vo:list) {
			System.out.println(vo.getEname()+" "
					+vo.getDname()+" "
					+vo.getJob()+" "
					+vo.getLoc()+" "
					+vo.getGrade());
		}
	}
}
