package dto;

import java.io.Serializable;
import java.sql.Date;

public class MemberDto implements Serializable{
	private String id;
	private String pwd;
	private String name;
	private String birth;
	private String daum;
	private int height;
	public MemberDto() {}
	public MemberDto(String id, String pwd, String name,String birth, String daum, int height) {
		super();
		this.id = id;
		this.pwd = pwd;
		this.name = name;
		this.birth = birth;
		this.daum = daum;
		this.height = height;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getPwd() {
		return pwd;
	}
	public void setPwd(String pwd) {
		this.pwd = pwd;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getBirth() {
		return birth;
	}
	public void setBirth(String birth) {
		this.birth = birth;
	}
	public String getDaum() {
		return daum;
	}
	public void setDaum(String daum) {
		this.daum = daum;
	}
	public int getHeight() {
		return height;
	}
	public void setHeight(int height) {
		this.height = height;
	}
}


