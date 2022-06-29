package dto;
//학생의 정보 항목 Data Transfer Object
public class StudentDto {
	private int number;
	private String name;
	private int english;
	private int math;
	public  StudentDto() {}
	
	public StudentDto(int number, String name, int english, int math) {
		super();
		this.number = number;
		this.name = name;
		this.english = english;
		this.math = math;
	}
	public int getNumber() {
		return number;
	}
	public void setNumber(int number) {
		this.number = number;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getEnglish() {
		return english;
	}
	public void setEnglish(int english) {
		this.english = english;
	}
	public int getMath() {
		return math;
	}
	public void setMath(int math) {
		this.math = math;
	}
	@Override
	public String toString() {
		return "StudentDto [number=" + number + ", name=" + name + ", english=" + english + ", math=" + math + "]";
	}

}
