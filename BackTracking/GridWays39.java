package BackTracking;

public class GridWays39 {
    //O(2^n) solution
    public static int gridWays(int startRight, int startDown,int n,int m){
        if (startRight==n-1||startDown==m-1) {
            return 1;
        }
        if (startRight==n||startDown==m) {
            return 0;
        }
        int w1 = gridWays(startRight+1, startDown, n, m);
        int w2 = gridWays(startRight,startDown+1,n,m);
        return w1 + w2;
        

    }
    //O(n+m) solution
    public static int factorial(int val){
        if (val<2) {
            return 1;
        }
        return val*factorial(val-1);
    }
    public static int gridWaysByFormula(int n,int m){
        return (factorial(n-1+m-1)/(factorial(n-1)*factorial(m-1)));
    }
    public static void main(String[] args) {
        System.out.println(gridWays(0, 0, 8, 8));
        
        System.out.println(gridWaysByFormula( 3, 3));
    }
}
