package main;

import java.util.List;

import db.jdbcConnect;
import dto.Student;

public class MainClass {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		jdbcConnect jdbcconn=new jdbcConnect();
		//jdbcconn.getConnection();//db에 대한 정보 얻어오는 문장
		
		int number=1001;
		
		String name="홍길동";
		
		//int count=jdbcconn.insertData(number, name);
		//System.out.println("count:"+count);
		
		/*
		  number=1002; name="성춘향";
		  
		  boolean b=jdbcconn.createData(name, number);
		  
		  if(b) { System.out.println("문제없음"); }
		 */
		boolean count =jdbcconn.update(1, "홍길동");
		
		if (count)
		{
			System.out.println("수정 완료");
			
		}
		//List<Student> list=jdbcconn.allSelect();
		/*
		 * for (Student s : list) { System.out.println(s.toString()); }
		 */
		
	}

}
