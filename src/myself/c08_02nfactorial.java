package myself;

public class c08_02nfactorial {

    public static int nFactorial(int n){
        if(n == 1){
            return 1;
        }
        return n * nFactorial(n -1 );
    }

    public static void main(String[] args) {
        System.out.println(nFactorial(5));
    }
}
