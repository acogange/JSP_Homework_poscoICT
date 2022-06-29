package cls;

import single.SingletonClass;

//함수 독립적 메소드 종속됨
public class YouClass {
	private int count;
	public YouClass()
	{
		
	}
	@Override
	public String toString() {
		return "YouClass [count=" + count + "]";
	}

	public void func() {
		SingletonClass sc=SingletonClass.getInstance();
		count=sc.num;
	}
	
	/*
	 * public void setCount(int count) { this.count = count; }
	 */
}
