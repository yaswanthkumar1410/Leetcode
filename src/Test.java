public class Test {
    public static void test(){
        int k=5;
     for(int i=0;i<k;i++){
         if(true){
             continue;
         }
         System.out.println("cont");
     }
    }
    public static void  main(String[] args){
        test();
    }
}
