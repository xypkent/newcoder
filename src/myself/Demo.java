package myself;

public class Demo {

    private  static void func(){
        System.out.println("func");
    }

    public static void main(String[] args) {
        ((Demo)null).func();
    }

}
