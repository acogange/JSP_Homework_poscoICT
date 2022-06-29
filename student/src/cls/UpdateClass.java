package cls;

import java.util.Scanner;

import dao.StudentDao;
import dto.StudentDto;

//학생 정보 수정
public class UpdateClass implements ProcessClass{
	public UpdateClass() {

	}
	public void process() {
		
		Scanner s=new Scanner(System.in);
		
		System.out.print("변경할 학생의 번호를 입력하시오 ");
		int num=s.nextInt();
		
		System.out.print("학생의 변경할 영어점수를 입력하시오 ");
		int eng=s.nextInt();
		
		System.out.print("학생의 변경할 수학점수를 입력하시오 ");
		int m=s.nextInt();
		
		StudentDao dao=StudentDao.getInstance();
		for (StudentDto i:dao.list)
		{
			if (i.getNumber()==num) {
				i.setEnglish(eng);
				i.setMath(m);

				System.out.print("변경된 학생의 정보 ");
				System.out.print("찾는 학생의 정보 ");
				System.out.print("번호: "+i.getNumber());
				System.out.print("   이름: "+i.getName());
				System.out.print("   영어점수: "+i.getEnglish());	
				System.out.println("   수학점수: "+i.getMath());
			}
			
		}
		
	}
}
