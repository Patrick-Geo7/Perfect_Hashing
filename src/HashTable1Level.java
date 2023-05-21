package src;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

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

    public String[] getHashmap() {
        return hashmap;
    }

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
//        printHashFunction();
        n=0;
    }

    @Override
    public boolean insert(String key) {
        rebuildCount=0;
        int index = hashUtility.getIndex(hashFunction,key);
//        if (n+1>NN){
//            System.out.println(" size exceeded !!!!!");
//            return false;
//        }
        if (hashmap[index]==null ){
//            System.out.println("perfectly inserted");
            hashmap[index]=key;
//            printSize();
            n+=1;
            return true;
        }
        else if (Objects.equals(hashmap[index], key)){

//            System.out.println("key already exists");
            return false;
        }
        else{ //collision
//            System.out.println("collision!!!!!!!!!");
            //create a new hashmap (helper)
            //while (true)
            //      update hash function
            //      try inserting all elements
            //      if collision -> repeat
            //      else -> break
            //assign the helper hashmap to the original hashmap

            String[] helper;
            while (true){
                helper= new String[(int) Math.pow(2,b)];
                hashFunction= hashUtility.getHashFuncion(32,b);
//                System.out.println("hash functionnnnnnnnnnn");
//                printHashFunction();
//                System.out.println(" no of rebuilds"+ rebuildCount);
                rebuildCount+=1;
                boolean flag =false;
                for (String element:hashmap) {
                    if (element != null) {
                        index = hashUtility.getIndex(hashFunction,element) ;
                        if (helper[index] == null) {
                            helper[index] = element;
                        }
                        else{ //collision
                            flag=true;
                            break;
                        }
                    }
                }
                if (!flag) {
                    index = hashUtility.getIndex(hashFunction, key);
                    if (helper[index] == null) {
                        helper[index] = key;
                        break;
                    }
                    else if (Objects.equals(helper[index], key)){
//                        System.out.println("same");
                        break;
                    }
                    else{
                        System.out.println(helper[index]+"   "+key);
                        System.out.println(hashUtility.getIndex(hashFunction, key));
                        System.out.println(hashUtility.getIndex(hashFunction, helper[index]));
//                        printHashFunction();
//                        printt();
//                        System.out.println(NN);
                        System.out.println("hablllllllllllllllllll");
                    }
                }
            }
            hashmap=helper.clone();

            n+=1;
            return true;
        }
//        printSize();

    }
    void printHashFunction(){
        for (int i=0;i<b;i++){
            for (int j=0;j<32;j++){
                System.out.print(hashFunction[i][j]+" ");
            }
            System.out.println(" ");
        }
    }

    public int getRebuildCount() {
        return rebuildCount;
    }

    public int getN() {
        return n;
    }

    @Override
    public void printt(){
        System.out.println("printttt");
        Set<String> debug= new HashSet<String>();
        int size=0;
        // Adding elements to the Set
        // using add() method
//        String debug[]=new String[NN];int i=0;
        for (int j=0;j<Math.pow(2,b);j++) {

//            if (hashmap[j]!=null) {
                size++;
                boolean found = false;
                for (String s : debug) {

                    if (hashmap!=null && s.equals(hashmap[j])) {
                        System.out.print("found");
                        System.out.println("        " + j + " " + hashmap[j]);
                        found = true;
                    }

                }
                if (!found && hashmap[j]!=null) {

                    debug.add(hashmap[j]);
                    System.out.println("        " + j + " " + hashmap[j]);
                }
//        }

        }
        System.out.println("size isssss" + debug.size());
        System.out.println("size isssss" + size);
    }

    public void printSize(){
        System.out.println("printttt");
        Set<String> debug= new HashSet<String>();
        int size=0;
        // Adding elements to the Set
        // using add() method
//        String debug[]=new String[NN];int i=0;
            for (int j=0;j<Math.pow(2,b);j++){

                if (hashmap[j]!=null) {
                    size++;
                    boolean found = false;
                    for (String s : debug) {

                        if (s.equals(hashmap[j])) {
//                                    System.out.print("found");
//                                    System.out.println("        " + j + " " + hashmap[j]);
                            found = true;
                        }

                    }
                    if (!found) {

                        debug.add(hashmap[j]);
//                    System.out.println("        " + j + " " + hashmap[j]);}
                    }
                }
            }
        System.out.println("size isssss" + debug.size());
//        System.out.println("size isssss" + size);
    }

    public int getNN() {
        return NN;
    }

    @Override
    public boolean delete(String key) {
        int index=hashUtility.getIndex(hashFunction,key);
//        System.out.println("elhash map index  "+ hashmap[index] + "index  "+index);
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
