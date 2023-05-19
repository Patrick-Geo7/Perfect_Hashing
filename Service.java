import java.util.*;
public class Service {

    //converts string to a number
    public static int hash(String str) {
        int hash = 0;
        for (int i = 0; i < str.length(); i++) {
            hash = str.charAt(i) + ((hash << 5) - hash);
        }
        return hash;
    }
    //converts number to its binary
    public static String hashedToBinary(int hash){
        return Integer.toBinaryString(hash);
    }
    // converts binary to its vector
    public static int[] keyVector(String binaryString){
        int[] binaryVector = new int[binaryString.length()];
        int i=0;
        while(i<binaryString.length()){
            binaryVector[i] = binaryString.charAt(i)-'0';
            i++;
        }
        return binaryVector;}

    // performs matrix multiplication and returns result (binary vector)
    public static int[] hashedKey(int[][] hx, int[] key){
        int[] hashedKey = new int[hx.length];
        for(int i=0;i<hx.length;i++){
            for(int j=0;j<key.length;j++){
                hashedKey[i] = (hashedKey[i] + hx[i][j]*key[j])%2;
            }
        }
        return hashedKey;}

    // return the vector result to binary
    public String StringHashedKey(int[] hashedkey){
        String StringHashedKey="";
        for (int j : hashedkey) {
            StringHashedKey += (char) j;
        }
        return StringHashedKey;}

    // converet binary to integer (index)
    public int InthashedKey(String StringHashedKey){
        return Integer.parseInt(StringHashedKey,2);
    }

}
