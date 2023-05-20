package src;

import java.math.*;
import java.util.Random;
import java.util.random.*;
public class HashFunc {
    int b;
    int u;


    public int[][] getHashFuncion(int u,int b){
        this.u = u;
        this.b = b;
        System.out.println("u"+this.getB());
        System.out.println("v"+this.getU());
        int[][] hx=new int [this.getB()][this.getU()];
        Random rand = new Random();
        for(int i = 0; i<this.getB(); i++){
            for(int j = 0; j<this.getU(); j++){
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
    //converts string to a number
    private static int hash(String str) {
        int hash = 0;
        for (int i = 0; i < str.length(); i++) {
            hash = str.charAt(i) + ((hash << 5) - hash);
        }
        return hash;
    }
    //converts number to its binary
    private static String hashedToBinary(int hash){
        return Integer.toBinaryString(hash);
    }
    // converts binary to its vector
    private static int[] keyVector(String binaryString){
        int[] binaryVector = new int[binaryString.length()];
        int i=0;
        while(i<binaryString.length()){
            binaryVector[i] = binaryString.charAt(i)-'0';
            i++;
        }
        return binaryVector;}

    // performs matrix multiplication and returns result (binary vector)
    private static int[] hashedKey(int[][] hx, int[] key){
        int[] hashedKey = new int[hx.length];
        for(int i=0;i<hx.length;i++){
            for(int j=0;j<key.length;j++){
                hashedKey[i] = (hashedKey[i] + hx[i][j]*key[j])%2;
            }
        }
        return hashedKey;}

    // return the vector result to binary
    private String StringHashedKey(int[] hashedkey){
        String StringHashedKey="";
        for (int j : hashedkey) {
            StringHashedKey +=  j;
        }
        return StringHashedKey;}

    // converet binary to integer (index)
    private int InthashedKey(String StringHashedKey){
//        System.out.println(StringHashedKey);
        return Integer.parseInt(StringHashedKey,2);
    }

    public int getIndex(int[][] hx,String key){

        int number=hash(key);
        String binaryString=hashedToBinary(number);
//        System.out.println("binarString"+binaryString);
        int [] vector = keyVector(binaryString);
//        System.out.println("vector");
//        for (int i:vector) System.out.println(i);
        int [] result = hashedKey(hx,vector);
//        System.out.println("result");
//        for (int i:result) System.out.println(i);
//        System.out.println("hashed binary string");
        String hashedBinaryString= StringHashedKey(result);
//        System.out.println(hashedBinaryString);
        return InthashedKey(hashedBinaryString);

    }




}