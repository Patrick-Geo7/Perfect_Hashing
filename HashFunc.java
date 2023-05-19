import java.math.*;
import java.util.Random;
import java.util.random.*;
public class HashFunc {
    int b;
    int u;


    public int[][] HashFunc(int u,int b){
        this.u = u;
        this.b = b;
        int[][] hx={{0}};
        Random rand = new Random();
        for(int i = 0; i<b; i++){
            for(int j = 0; j<u; j++){
                hx[i][j] = rand.nextInt(1);
            }
        }
    return hx;}
    public int getU(){
        return this.u;
    }
    public int getB(){
        return this.b;
    }

}
