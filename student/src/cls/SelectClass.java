package cls;
import dao.StudentDao;
import dto.StudentDto;
import java.util.Scanner;

import dao.StudentDao;

//학생 정보 검색
public class SelectClass implements ProcessClass{
	public SelectClass() {

	}
	
public void process() {
		
	Scanner s=new Scanner(System.in);
	
	System.out.print("찾고자하는 학생의 번호를 입력하시오 ");
	int num=s.nextInt();
	StudentDao dao=StudentDao.getInstance();
	
	for (StudentDto i:dao.list)
	{
		if (i.getNumber()==num) {
		System.out.print("찾는 학생의 정보 ");
		System.out.print("번호: "+i.getNumber());
		System.out.print("   이름: "+i.getName());
		System.out.print("   영어점수: "+i.getEnglish());	
		System.out.println("   수학점수: "+i.getMath());
		}
	}
	
}
}
