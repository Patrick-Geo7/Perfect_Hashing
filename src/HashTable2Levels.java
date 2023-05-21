package src;

import java.util.Objects;

import static java.lang.Math.*;
import static java.lang.Math.log;

public class HashTable2Levels implements IHashTable{

    int [][] hashFunction;
    int b;
    int n;
    int NN;
    HashTable1Level[] hashmap;
    HashFunc hashUtility= new HashFunc();
    int rebuildCount;

    HashTable2Levels(int N){
        // get the number of bits required to represent N
        b = (int)  ceil(log(N)/log(2));;
        n=0;NN=N;
        hashmap = new HashTable1Level[(int) Math.pow(2, b)];
        //initialize each slot in the hashtable with a new hashtable
        for (int i=0;i<(int) Math.pow(2, b);i++){
            hashmap[i]= new HashTable1Level(1);
        }
        //initialize the hash function
        hashFunction = hashUtility.getHashFuncion(32,b);
    }

    @Override
    public boolean insert(String key) {
        rebuildCount=0;

//        if (n+1>NN){
//            System.out.println(" size exceeded !!!!!");
//            return false;
//        }

        int index1 = hashUtility.getIndex(hashFunction,key);
        HashTable1Level hash = hashmap[index1];

        int index2= hashUtility.getIndex(hash.hashFunction,key);
        if (hash.hashmap[index2]==null){
            System.out.println("inserted perfectly");
            hash.hashmap[index2]=key;
            n+=1;
            return true;
        }
        else if((Objects.equals(hash.hashmap[index2], key))){
            System.out.println("key already exists");
            return false;
        }
        else{
            // collision
            // 10   128  11

            if (hash.b < (int) ceil(log(pow(hash.n+1,2))/log(2)))
            {
                hashmap[index1]= new HashTable1Level(hash.n);
                System.out.println("new hash table size");
                rebuildCount+=1;
            }
            else{
                hashmap[index1].hashmap= new String[(int)pow(2,hash.b)];
            }
            for (String element:hash.hashmap) {
                if (element != null) {
                    hashmap[index1].insert(element);
                    rebuildCount+=hashmap[index1].getRebuildCount();
                }
            }
            hashmap[index1].insert(key);
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

    @Override
    public boolean delete(String  key) {

        int index1 =hashUtility.getIndex(hashFunction,key);
        HashTable1Level hash = hashmap[index1];
        int index2= hashUtility.getIndex(hash.hashFunction,key);
        if (Objects.equals(hash.hashmap[index2], key)){
            hash.hashmap[index2]=null;
            n-=1;
            return true;
        }
        return false;

    }

    @Override
    public boolean search(String key) {
        int index1 =hashUtility.getIndex(hashFunction,key);
        HashTable1Level hash = hashmap[index1];
        int index2= hashUtility.getIndex(hash.hashFunction,key);
        return Objects.equals(hash.hashmap[index2], key);
    }
}
