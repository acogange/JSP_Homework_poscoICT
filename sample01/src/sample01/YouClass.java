package sample01;

public class YouClass {
   
   private String name;
   
   
   public YouClass() {
      
   }

   public YouClass(String name) {
      super();
      this.name = name;
   }

   @Override
   public String toString() {
      return "YouClass [name=" + name + "]";
   }
   
}