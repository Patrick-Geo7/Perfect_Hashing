import static java.lang.Math.*;
import static java.lang.Math.log;

public class Main {

    public static void main(String[] args) {
        System.out.println("Hello world!");
        System.out.println((int) ceil(log(pow(1,2))/log(2)));
        System.out.println("3aaaaaaaaaaaaaaa");
//        HashTable1Level hashTable = new HashTable1Level(4);
//        //insertionn testttttttttttttttttt
//        hashTable.insert("a");
//        for (int i=0;i< Math.pow(2, hashTable.b);i++){
//            System.out.println(i+" "+hashTable.hashmap[i]);
//        }
//        hashTable.insert("b");
//        for (int i=0;i< Math.pow(2, hashTable.b);i++){
//            System.out.println(i+" "+hashTable.hashmap[i]);
//        }
//        hashTable.insert("c");
//        for (int i=0;i< Math.pow(2, hashTable.b);i++){
//            System.out.println(i+" "+hashTable.hashmap[i]);
//        }
//        hashTable.insert("d");
//        for (int i=0;i< Math.pow(2, hashTable.b);i++){
//            System.out.println(i+" "+hashTable.hashmap[i]);
//        }
//        //// searchhhhh test
//        System.out.println(hashTable.search("a"));
//        System.out.println(hashTable.search("z"));
//
//
//
//        // deleteeeeeeeeee testttt
//        hashTable.delete("a");
//        System.out.println("after deletinggggg a");
//        for (int i=0;i< Math.pow(2, hashTable.b);i++){
//            System.out.println(i+" "+hashTable.hashmap[i]);
//        }
//        System.out.println("after deletinggggg z");
//        hashTable.delete("z");
//        for (int i=0;i< Math.pow(2, hashTable.b);i++){
//            System.out.println(i+" "+hashTable.hashmap[i]);
//        }

        //insertionn testttttttttttttttttt
        HashTable2Levels hashTable = new HashTable2Levels(5);
        System.out.println("a");
        hashTable.insert("a");
        for (int i=0;i< Math.pow(2, hashTable.b);i++){
            System.out.println(i+" ");
            for (int j=0;j<Math.pow(2, hashTable.hashmap[i].b);j++){
                System.out.println("        "+j+" "+hashTable.hashmap[i].hashmap[j]);
            }
        }
        System.out.println("b");
        hashTable.insert("b");
        for (int i=0;i< Math.pow(2, hashTable.b);i++){
            System.out.println(i+" ");
            for (int j=0;j<Math.pow(2, hashTable.hashmap[i].b);j++){
                System.out.println("        "+j+" "+hashTable.hashmap[i].hashmap[j]);
            }
        }
        System.out.println("c");
        hashTable.insert("c");
        for (int i=0;i< Math.pow(2, hashTable.b);i++){
            System.out.println(i+" ");
            for (int j=0;j<Math.pow(2, hashTable.hashmap[i].b);j++){
                System.out.println("        "+j+" "+hashTable.hashmap[i].hashmap[j]);
            }
        }
        System.out.println("d");
        hashTable.insert("d");
        for (int i=0;i< Math.pow(2, hashTable.b);i++){
            System.out.println(i+" ");
            for (int j=0;j<Math.pow(2, hashTable.hashmap[i].b);j++){
                System.out.println("        "+j+" "+hashTable.hashmap[i].hashmap[j]);
            }
        }
        System.out.println("e");
        hashTable.insert("e");
        for (int i=0;i< Math.pow(2, hashTable.b);i++){
            System.out.println(i+" ");
            for (int j=0;j<Math.pow(2, hashTable.hashmap[i].b);j++){
                System.out.println("        "+j+" "+hashTable.hashmap[i].hashmap[j]);
            }
        }
//        hashTable.insert("b");
//        for (int i=0;i< Math.pow(2, hashTable.b);i++){
//            System.out.println(i+" "+hashTable.hashmap[i]);
//        }
//        hashTable.insert("c");
//        for (int i=0;i< Math.pow(2, hashTable.b);i++){
//            System.out.println(i+" "+hashTable.hashmap[i]);
//        }
//        hashTable.insert("d");
//        for (int i=0;i< Math.pow(2, hashTable.b);i++){
//            System.out.println(i+" "+hashTable.hashmap[i]);
//        }
//        //// searchhhhh test
//        System.out.println(hashTable.search("a"));
//        System.out.println(hashTable.search("z"));
//
//
//
//        // deleteeeeeeeeee testttt
//        hashTable.delete("a");
//        System.out.println("after deletinggggg a");
//        for (int i=0;i< Math.pow(2, hashTable.b);i++){
//            System.out.println(i+" "+hashTable.hashmap[i]);
//        }
//        System.out.println("after deletinggggg z");
//        hashTable.delete("z");
//        for (int i=0;i< Math.pow(2, hashTable.b);i++){
//            System.out.println(i+" "+hashTable.hashmap[i]);
//        }



//        hashTable.insert("c");






    }
}