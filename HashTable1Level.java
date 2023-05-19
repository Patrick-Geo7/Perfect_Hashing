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
    int N;
    HashFunc hashUtility= new HashFunc();


    HashTable1Level(int N){

        // get the number of bits required to represent N^2
        b = (int) ceil(log(pow(N,2))/log(2));
        if (N==1){
            b=1;
        }
        N=N;
        //initialize the hashmap , hashfunction and current number of elements in the table
        hashmap = new String[(int) Math.pow(2,b)];
        hashFunction= hashUtility.getHashFuncion(32,b);
        n=0;
    }

    @Override
    public void insert(String key) {

        int index = hashUtility.getIndex(hashFunction,key);
        if (n+1<=N){
            System.out.println(" size exceeded !!!!!");
            return;
        }
        if (hashmap[index]==null ){
            System.out.println("perfectly inserted");
            hashmap[index]=key;
        }
        else if (Objects.equals(hashmap[index], key)){

            System.out.println("key already exists");
            return;
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
    }


    @Override
    public void delete(String key) {
        int index=hashUtility.getIndex(hashFunction,key);
        System.out.println("elhash map index  "+ hashmap[index] + "index  "+index);
        if (Objects.equals(hashmap[index], key))
            hashmap[index]=null;
    }

    @Override
    public boolean search(String key) {
        int index=hashUtility.getIndex(hashFunction,key);
        return Objects.equals(hashmap[index], key);
    }
}
