import java.util.Objects;

import static java.lang.Math.*;
import static java.lang.Math.log;

public class HashTable2Levels implements IHashTable{

    int [][] hashFunction;
    int b;
    HashTable1Level[] hashmap;
    HashFunc hashUtility= new HashFunc();

    HashTable2Levels(int N){
        // get the number of bits required to represent N
        b = (int)  ceil(log(N)/log(2));
        System.out.println("N"+N);

        hashmap = new HashTable1Level[(int) Math.pow(2, b)];
        //initialize each slot in the hashtable with a new hashtable
        for (int i=0;i<(int) Math.pow(2, b);i++){
            hashmap[i]= new HashTable1Level(1);
        }
        //initialize the hash function
        hashFunction = hashUtility.getHashFuncion(32,b);
    }

    @Override
    public void insert(String key) {

        int index1 = hashUtility.getIndex(hashFunction,key);
        HashTable1Level hash = hashmap[index1];

        int index2= hashUtility.getIndex(hash.hashFunction,key);
        if (hash.hashmap[index2]==null){
            hash.hashmap[index2]=key;
        }
        else{
            // collision
            // 10   128  11
            //
            if (hash.b < (int) ceil(log(pow(hash.n+1,2))/log(2)))
            {
                hashmap[index1]= new HashTable1Level(hash.n);
                System.out.println("new hash table size");
            }


            for (String element:hash.hashmap) {
                if (element != null) {
                    hashmap[index1].insert(element);
                }
            }
            hashmap[index1].insert(key);
        }
    }

    @Override
    public void delete(String  key) {

        int index1 =hashUtility.getIndex(hashFunction,key);
        HashTable1Level hash = hashmap[index1];
        int index2= hashUtility.getIndex(hash.hashFunction,key);
        if (Objects.equals(hash.hashmap[index2], key))
            hash.hashmap[index2]=null;
    }

    @Override
    public boolean search(String key) {

        int index1 =hashUtility.getIndex(hashFunction,key);
        HashTable1Level hash = hashmap[index1];
        int index2= hashUtility.getIndex(hash.hashFunction,key);
        return Objects.equals(hash.hashmap[index2], key);
    }
}
