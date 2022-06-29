package single;
//delegate(=대리인)
public class SingletonClass {
	private static SingletonClass sc=null;
	public int num; 
	public SingletonClass() {
		
	}
	
	public static SingletonClass getInstance() {
		if(sc==null) {
			sc=new SingletonClass();
		}
		return sc;
	}
}
