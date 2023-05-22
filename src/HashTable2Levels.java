package src;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

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
    HashTable1Level[] get_hashtables(){
        return  hashmap;
    }
    public void printSize() {
//        System.out.println("printttt");
        Set<String> debug = new HashSet<String>();
        int size = 0;
        for (int i = 0; i < pow(2, b); i++) {
//            System.out.println(i + " ");

            for (int j = 0; j < Math.pow(2, hashmap[i].b); j++) {

                if (hashmap[i].hashmap[j] != null) {
                    size++;
                    boolean found = false;
                    for (String s : debug) {
                        if (s != null) {


                            if (s.equals(hashmap[i].hashmap[j])) {
//                                System.out.print("found");
//                                System.out.println("        " + j + " " + hashmap[i].hashmap[j]);
                                found = true;
                            }
                        }

                    }
                    if (!found) {

                        debug.add(hashmap[i].hashmap[j]);
//                        System.out.println("        " + j + " " + hashmap[i].hashmap[j]);}
                    }

                }

            }

        }
//        System.out.println("size isssss" + debug.size());
//        System.out.println("size isssss" + size);
    }

    @Override
    public void printt(){
        System.out.println("printttt");
        System.out.println("printttt");
        Set<String> debug= new HashSet<String>();
        int size=0;
        for (int i=0;i< pow (2,b);i++){
            System.out.println(i+" ");

            for (int j=0;j<Math.pow(2,hashmap[i].b);j++){

                if (hashmap[i].hashmap[j]!=null) {
                    size++;
                    boolean found=false;
                    for (String s:debug)
                    {
                        if (s!=null) {


                            if (s.equals(hashmap[i].hashmap[j])) {
                                System.out.print("found");
                                System.out.println("        " + j + " " + hashmap[i].hashmap[j]);
                                found = true;
                            }
                        }

                    }
                    if (!found){

                        debug.add( hashmap[i].hashmap[j]);
                        System.out.println("        " + j + " " + hashmap[i].hashmap[j]);}
                }

            }
        }
        System.out.println("size isssss" + debug.size());
        System.out.println("size isssss" + size);
    }

    HashTable2Levels(int N){
        // get the number of bits required to represent N
        b = (int)  ceil(log(N)/log(2));;
        n=0;
        NN=N;
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
//        System.out.println("inserttttttttttttttttttttttttt");
//        System.out.println("n="+n);
        rebuildCount=0;
        int index1 = hashUtility.getIndex(hashFunction,key);
        HashTable1Level hash = hashmap[index1];
        int index2= hashUtility.getIndex(hash.hashFunction,key);

        if (hash.hashmap[index2]==null){
//            System.out.println("inserted perfectly");
            hash.hashmap[index2]=key;
//            hashmap[index1].hashmap[index2]=key;

            //printSize();
//            System.out.println("n="+n);
            n+=1;
            hashmap[index1].n++;
//            System.out.println("n="+n);
            return true;
        }
//        Objects.equals(hash.hashmap[index2], key)

        else if(hash.hashmap[index2].compareTo(key)==0){
//            System.out.println("key already exists");
//            System.out.println("n="+n);
            return false;
        }
        else{
            // collision
            // 10   128  11

            if (hash.b < (int) ceil(log(pow((hash.n)+1,2))/log(2)))
            {
//                System.out.println("llllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllll");
//                System.out.println(hashmap[index1].n);
                hashmap[index1]= new HashTable1Level(hash.n+1);
//                System.out.println(hashmap[index1].n);
//                System.out.println("new hash table size");
             //   rebuildCount+=1;

                for (String element:hash.hashmap) {
                    if (element != null) {
                        hashmap[index1].insert(element);
                        rebuildCount+=hashmap[index1].getRebuildCount();
                    }
                }

            }
//            else{
//                hashmap[index1].hashmap = new String[(int)pow(2,hash.b)];
//            }

//            for (String element:hash.hashmap) {
//                if (element != null) {
//                    hashmap[index1].insert(element);
//                    rebuildCount+=hashmap[index1].getRebuildCount();
//                }
//            }

//            System.out.println("n="+n);
//            System.out.println("-------------------------------------------------------------------------------------------------");
//            System.out.println("size before insert");
//            printSize();
//            printt();
            boolean bool=hashmap[index1].insert(key);
            rebuildCount+=hashmap[index1].getRebuildCount();
//            System.out.println("-------------------------------------------------------------------------------------------------");
//            System.out.println("size after inserrt");
//            printSize();
//            System.out.println("the key"+key + "index" + index1);
//            printt();


//            hashmap[index1].insert(key);
            if (bool) {
                n+=1;
//                System.out.println("inserted after collision");
//                printSize();
//                System.out.println("the key"+key + "index" + index1);
//                printt();


//                System.out.println("n="+n);
//                System.out.println("n="+n);
                return true;
            }
            else{
//                System.out.println("couldn't insert after collision key already exist");
//                System.out.println("n="+n);
                return false;
            }
        }
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

    public int size(){
        int sum = 0;
        for(int i=0; i<NN; i++){
            sum += hashmap[i].n;
        }
        return sum;
    }



    @Override
    public String[] getHashmap() {
        return new String[0];
    }

    @Override
    public boolean search(String key) {
        int index1 =hashUtility.getIndex(hashFunction,key);
        HashTable1Level hash = hashmap[index1];
        int index2= hashUtility.getIndex(hash.hashFunction,key);
        return Objects.equals(hash.hashmap[index2], key);
    }
}
