package src;

import java.util.Objects;

import static java.lang.Math.*;

public class HashTable1Level implements IHashTable {

    //M is the size of the hashtable; M = 2^b
    //b is the length of the translated(hashed keys)
    //u is the length of the actual key

    public String[] hashmap;
    int [][] hashFunction;
    int b;
    int n;
    int NN;
    int rebuildCount;
    HashFunc hashUtility= new HashFunc();

    HashTable1Level(int N){

        // get the number of bits required to represent N^2
        b = (int) ceil(log(pow(N,2))/log(2));
        if (N==1){
            b=1;
        }
        NN=N;
        //initialize the hashmap , hashfunction and current number of elements in the table
        hashmap = new String[(int) Math.pow(2,b)];
        hashFunction= hashUtility.getHashFuncion(32,b);
        n=0;
    }

    @Override
    public boolean insert(String key) {
        rebuildCount=0;
        int index = hashUtility.getIndex(hashFunction,key);
        if (n+1>NN){
            System.out.println(" size exceeded !!!!!");
            return false;
        }
        if (hashmap[index]==null ){
            System.out.println("perfectly inserted");
            hashmap[index]=key;
            n+=1;
            return true;
        }
        else if (Objects.equals(hashmap[index], key)){

            System.out.println("key already exists");
            return false;
        }
        else{ //collision
            System.out.println("collision!!!!!!!!!");
            //create a new hashmap (helper)
            //while (true)
            //      update hash function
            //      try inserting all elements
            //      if collision -> repeat
            //      else -> break
            //assign the helper hashmap to the original hashmap
            String[] helper= new String[(int) Math.pow(2,b)];

            while (true){
                hashFunction= hashUtility.getHashFuncion(32,b);
                rebuildCount+=1;
                for (String element:hashmap) {
                    if (element != null) {
                        index = hashUtility.getIndex(hashFunction,element) ;
                        if (helper[index] == null) {
                            helper[index] = element;
                        }
                        else { //collision
                            break;
                        }
                    }
                }
                index = hashUtility.getIndex(hashFunction,key) ;
                if (helper[index] == null) {
                    helper[index] = key;
                    break;
                }
            }
            hashmap=helper.clone();
        }

        n+=1;
        return true;
    }

    public int getRebuildCount() {
        return rebuildCount;
    }

    public int getN() {
        return n;
    }

    public int getNN() {
        return NN;
    }

    @Override
    public boolean delete(String key) {
        int index=hashUtility.getIndex(hashFunction,key);
        System.out.println("elhash map index  "+ hashmap[index] + "index  "+index);
        if (Objects.equals(hashmap[index], key))
        {
            hashmap[index]=null;
            n-=1;
            return true;
        }
        return false;

    }

    @Override
    public boolean search(String key) {
        int index=hashUtility.getIndex(hashFunction,key);
        return Objects.equals(hashmap[index], key);
    }
}
