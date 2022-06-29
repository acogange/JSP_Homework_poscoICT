package main;

import java.util.Scanner;

import cls.*;

public class MainClass {

	public static void main(String[] args) {
		// menu 추가(insert), 삭제( delete), 검색(select), 수정(update)
		while(true)
		{
			Scanner s=new Scanner(System.in);
			System.out.println(">>>>>>>>>menu");
			System.out.println("1. 학생 추가");
			System.out.println("2. 학생 삭제");
			System.out.println("3. 학생 검색");
			System.out.println("4. 학생 수정");
			System.out.println("5. 종료");
			
			System.out.print("작업번호 >> ");
			int number=s.nextInt();
			
			switch (number) {
			case 1:
				ProcessClass ic=new InsertClass();
				ic.process();
				break;
			case 2:
				DeleteClass dc=new DeleteClass();
				dc.process();
			
				break;
			case 3:
				SelectClass sc=new SelectClass();
				sc.process();
				break;
			case 4:
				UpdateClass up=new UpdateClass();
				up.process();
				break;
			case 5:
				System.exit(0);
				break;
			}
		}

	}

}
