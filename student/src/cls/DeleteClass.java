package cls;
import java.util.Scanner;

//학생 정보 삭제
import dao.StudentDao;
import dto.StudentDto;
public class DeleteClass implements ProcessClass {
	public DeleteClass() {
		
	}
	
	public void process()
	{
		
		Scanner s=new Scanner(System.in);
		
		System.out.print("삭제하고자하는 학생의 번호를 입력하시오 ");
		int num=s.nextInt();
		int cnt=0;
		StudentDao dao=StudentDao.getInstance();
		
		for (StudentDto i:dao.list)
		{ 
			if (i.getNumber()==num) {
				dao.list.remove(i);
				break;
			}
			
	
		}
		
		
		for (StudentDto i:dao.list)
		{
			System.out.println(i);
			
		}
	}

}
