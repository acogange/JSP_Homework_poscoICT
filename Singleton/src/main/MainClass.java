package main;

import org.apache.catalina.tribes.membership.McastService;

import cls.MyClass;
import cls.YouClass;
import single.SingletonClass;

public class MainClass {

	public static void main(String[] args) {

		MyClass mycls = new MyClass();
		YouClass ycls = new YouClass();

		//ycls.setCount(mycls.getNumber());
		mycls.method();
		ycls.func();
		System.out.println(ycls.toString());
		
		/*
		 * System.out.println(SingletonClass.getInstance());
		 * System.out.println(SingletonClass.getInstance());
		 * System.out.println(SingletonClass.getInstance());
		 */
	}

}
