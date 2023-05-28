package src;

import org.junit.platform.commons.util.StringUtils;

import java.math.*;
import java.util.Random;
import java.util.random.*;
public class HashFunc {
    int b;
    int u;


    public int[][] getHashFuncion(int u,int b){
        this.u = u;
        this.b = b;
//        System.out.println("u"+this.getB());
//        System.out.println("v"+this.getU());
        int[][] hx=new int [this.getB()][this.getU()];
        Random rand = new Random();
        for(int i = 0; i<this.getB(); i++){
            for(int j = 0; j<64; j++){
                hx[i][j] = rand.nextInt(2);
            }
        }
    return hx;
    }
    public long[] getHashFuncionL(int u,int b){

        long[] hx=new long [b];
        Random rand = new Random();
        for(int i = 0; i<b; i++){
                hx[i] = rand.nextLong();

        }
        for(int i = 0; i<b; i++){
            System.out.println(hx[i]);

        }
        return hx;
    }
    public long stringToLong(String str){
        StringBuilder binary  = new StringBuilder(new String());
        for (int i=0;i<str.length();i++){
            int ascii= (int) str.charAt(i);
            String binaryStr =Integer.toBinaryString(ascii);
//            System.out.println("ssss" + binaryStr);
            int n= binaryStr.length();
            while (n<8){
                binaryStr="0"+binaryStr;
                n++;
            }
            binary.append(binaryStr);
        }
        while (binary.length()<64)
        {
            binary= new StringBuilder("0" + binary);
        }
//        System.out.println("binary"+ binary);
        return  Long.parseLong(binary.toString(),2);
    }

    public int[] multiply(long[] hx, long key){
        // b x 64      64 * 1
        System.out.println("number key "+ key);
        int[] hashedKey = new int[hx.length];
        for (int i=0;i<hx.length;i++){
            System.out.println("multiplyy "+ (hx[i] & key));
            if ((hx[i] & key)%2==0){
                hashedKey[i]=0;
            }
            else{
                hashedKey[i]=1;
            }
        }
        return hashedKey;
    }



    public int getU(){
        return this.u;
    }
    public int getB(){
        return this.b;
    }

    //converts string to a number
    public static int hash(String str) {
//        int hash = 7;
//        for (int i = 0; i < str.length(); i++) {
//            hash = hash*128 + (int) str.charAt(i);
//        }
//        int hash=0;
//        int m=1;
//        for (int i = 0; i < str.length(); i++) {
//            hash+=
//        }
//        HashStrings hasher= new HashStrings();
//        String sha256Hash = hasher.calculateSHA256(str);
//        return Integer.parseInt(sha256Hash, 16);
        //last
        int hash = 0;
        for (int i = 0; i < str.length(); i++) {
            hash = str.charAt(i) + ((hash << 5) - hash);
        }
        //last
//        hash =str.hashCode();

        return hash;
    }
    //converts number to its binary
    private static String hashedToBinary(long hash){
        return Long.toBinaryString(hash);
    }
    // converts binary to its vector
    private static int[] keyVector(String binaryString){
        int[] binaryVector = new int[64];
        int i=0;
        while (i<64-binaryString.length()){
            binaryVector[i++]=0;
        }
        while(i<64){
            binaryVector[i] = binaryString.charAt(i-(64-binaryString.length()))-'0';
            i++;
        }
        return binaryVector;
    }
    // 4 & 6 = 1 0 //
    // performs matrix multiplication and returns result (binary vector)
    private static int[] hashedKey(int[][] hx, int[] key){
        int[] hashedKey = new int[hx.length];
        for(int i=0;i<hx.length;i++){
            for(int j=0;j<64;j++){
//                hashedKey[i] = (hashedKey[i] + hx[i][j]*key[j])%2;
                hashedKey[i] = (hashedKey[i] ^ hx[i][j] & key[j]);
            }
        }
        return hashedKey;
    }

    // return the vector result to binary
    private String StringHashedKey(int[] hashedkey){
        String StringHashedKey="";
        for (int j : hashedkey) {
            StringHashedKey +=  j;
        }
        return StringHashedKey;
    }

    // converet binary to integer (index)
    private int InthashedKey(String StringHashedKey){
//        System.out.println(StringHashedKey);
        return Integer.parseInt(StringHashedKey,2);
    }

    public int getIndex(int[][] hx,String key){

        long number=stringToLong(key);
//        System.out.println(" number "+ number);
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
//        System.out.println("binary "+hashedBinaryString);
//        System.out.println(hashedBinaryString);
//        System.out.println(" index "+ InthashedKey(hashedBinaryString));
        return InthashedKey(hashedBinaryString);

    }

    public int getIndexL(long[] hx,String key){

        long number=stringToLong(key);
//        long i = 907489889;
        System.out.println(" number "+ number);
        int [] result1 = multiply(hx,number);
        System.out.println("result");
        for (int i:result1) System.out.println(i);

        int[][] hx2= new int [8][64];
//        for (int )

//        System.out.println("vector");

        String hashedBinaryString= StringHashedKey(result1);
        System.out.println("binary "+hashedBinaryString);
        System.out.println(" index "+ InthashedKey(hashedBinaryString));
        return InthashedKey(hashedBinaryString);

    }
}
