public class recursion {
   public int method (int n) {
      if (n == 42) {
      
         System.out.println(n);
      
         return n;
      
      }
      
      else {
      
         if(n % 3 == 0) {
         
            System.out.println(n);
         
            return (method(n + 3));
         
         }
      
      }
   }
   public static void main(String[] arg){
   int n = 30;
   method(n);
   }
}