public class Calculations {
    public static long power(int n){
        long result = 1;
        for(int i = 0; i < n; i++){
            result *= 2;
        }
        return result;
    }
    public static long sum(int a, int b){
        long result = 0;
        for(int i=a; i<=b; i++){
            result += i;
        }
        return result;
    }
}