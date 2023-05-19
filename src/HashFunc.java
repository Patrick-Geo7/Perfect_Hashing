import java.math.*;
import java.sql.Array;
import java.util.Random;
import java.util.random.*;
//to choose a random hash function of the Universal Family of Hash Functions(Matrix Method).

public class HashFunc {
    int b;
    int u=32;
    //a matrix for generating a hash function will be of the size b-by-u 0/1 matrix
    public HashFunc(int u, int b){
        this.b = b;
        this.u = u;

    }
    public int[][] GenerateHashFunc(){

        int[][] hx = new int[this.u][this.b];
        Random rand = new Random();
        for(int i = 0; i<this.getU(); i++){
            for(int j = 0; j<this.getB(); j++){
                hx[i][j] = rand.nextInt(2);
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
