package src;

import org.junit.jupiter.api.Test;
import src.Trees.dictionary;

import static org.junit.jupiter.api.Assertions.*;


public class HashTablesTest {

    @Test
    void size_1k(){

        long start;
        long end;
        int n = 1000;
        String path = "1000.txt";

        dictionary RedBlack_Dict = new dictionary("RedBlack");
        dictionary Avl_Dict = new dictionary("avl");

        Dictionnary hashTable_1_Dict = new Dictionnary("oneLevel",n);
        Dictionnary hashTable_2_Dict = new Dictionnary("twoLevels",n);


        start = System.nanoTime();
        int[] RedBlack = RedBlack_Dict.batchInsert(path);
        end = System.nanoTime();
        long RedBlackTime = end - start;

        start = System.nanoTime();
        int[] Avl = Avl_Dict.batchInsert(path);
        end = System.nanoTime();
        long AvlTime = end - start;

        start = System.nanoTime();
        int[] hashTable_1 = hashTable_1_Dict.batchInsert(path);
        end = System.nanoTime();
        long hashTable_1_Time = end - start;

//        start = System.nanoTime();
//        int[] hashTable_2 = hashTable_2_Dict.batchInsert(path);
//        end = System.nanoTime();
//        long hashTable_2_Time = end - start;

        assertArrayEquals(Avl,RedBlack);
        assertArrayEquals(Avl,hashTable_1);
//        assertArrayEquals(Avl,hashTable_2);



    }
    @Test
    void size_500(){

        long start;
        long end;
        int n = 500;
        String path = "500.txt";

        dictionary RedBlack_Dict = new dictionary("RedBlack");
        dictionary Avl_Dict = new dictionary("avl");

        Dictionnary hashTable_1_Dict = new Dictionnary("oneLevel",n);
        Dictionnary hashTable_2_Dict = new Dictionnary("twoLevels",n);


        start = System.nanoTime();
        int[] RedBlack = RedBlack_Dict.batchInsert(path);
        end = System.nanoTime();
        long RedBlackTime = end - start;

        start = System.nanoTime();
        int[] Avl = Avl_Dict.batchInsert(path);
        end = System.nanoTime();
        long AvlTime = end - start;

        start = System.nanoTime();
        int[] hashTable_1 = hashTable_1_Dict.batchInsert(path);
        end = System.nanoTime();
        long hashTable_1_Time = end - start;

//        start = System.nanoTime();
//        int[] hashTable_2 = hashTable_2_Dict.batchInsert(path);
//        end = System.nanoTime();
//        long hashTable_2_Time = end - start;

        assertArrayEquals(Avl,RedBlack);
        assertArrayEquals(Avl,hashTable_1);
//        assertArrayEquals(Avl,hashTable_2);



    }

    @Test
    void size_250(){

        long start;
        long end;
        int n = 250;
        String path = "250.txt";

        dictionary RedBlack_Dict = new dictionary("RedBlack");
        dictionary Avl_Dict = new dictionary("avl");

        Dictionnary hashTable_1_Dict = new Dictionnary("oneLevel",n);
        Dictionnary hashTable_2_Dict = new Dictionnary("twoLevels",n);


        start = System.nanoTime();
        int[] RedBlack = RedBlack_Dict.batchInsert(path);
        end = System.nanoTime();
        long RedBlackTime = end - start;

        start = System.nanoTime();
        int[] Avl = Avl_Dict.batchInsert(path);
        end = System.nanoTime();
        long AvlTime = end - start;

        start = System.nanoTime();
        int[] hashTable_1 = hashTable_1_Dict.batchInsert(path);
        end = System.nanoTime();
        long hashTable_1_Time = end - start;

//        start = System.nanoTime();
//        int[] hashTable_2 = hashTable_2_Dict.batchInsert(path);
//        end = System.nanoTime();
//        long hashTable_2_Time = end - start;

        assertArrayEquals(Avl,RedBlack);
        assertArrayEquals(Avl,hashTable_1);
//        assertArrayEquals(Avl,hashTable_2);



    }

    @Test
    void size_100(){

        long start;
        long end;
        int n = 100;
        String path = "100.txt";

        dictionary RedBlack_Dict = new dictionary("RedBlack");
        dictionary Avl_Dict = new dictionary("avl");

        Dictionnary hashTable_1_Dict = new Dictionnary("oneLevel",n);
        Dictionnary hashTable_2_Dict = new Dictionnary("twoLevels",n);


        start = System.nanoTime();
        int[] RedBlack = RedBlack_Dict.batchInsert(path);
        end = System.nanoTime();
        long RedBlackTime = end - start;

        start = System.nanoTime();
        int[] Avl = Avl_Dict.batchInsert(path);
        end = System.nanoTime();
        long AvlTime = end - start;

        start = System.nanoTime();
        int[] hashTable_1 = hashTable_1_Dict.batchInsert(path);
        end = System.nanoTime();
        long hashTable_1_Time = end - start;

//        start = System.nanoTime();
//        int[] hashTable_2 = hashTable_2_Dict.batchInsert(path);
//        end = System.nanoTime();
//        long hashTable_2_Time = end - start;

        assertArrayEquals(Avl,RedBlack);
        assertArrayEquals(Avl,hashTable_1);
//        assertArrayEquals(Avl,hashTable_2);



    }

    @Test
    void size_10(){

        long start;
        long end;
        int n = 10;
        String path = "10.txt";

        dictionary RedBlack_Dict = new dictionary("RedBlack");
        dictionary Avl_Dict = new dictionary("avl");

        Dictionnary hashTable_1_Dict = new Dictionnary("oneLevel",n);
        Dictionnary hashTable_2_Dict = new Dictionnary("twoLevels",n);


        start = System.nanoTime();
        int[] RedBlack = RedBlack_Dict.batchInsert(path);
        end = System.nanoTime();
        long RedBlackTime = end - start;

        start = System.nanoTime();
        int[] Avl = Avl_Dict.batchInsert(path);
        end = System.nanoTime();
        long AvlTime = end - start;

        start = System.nanoTime();
        int[] hashTable_1 = hashTable_1_Dict.batchInsert(path);
        end = System.nanoTime();
        long hashTable_1_Time = end - start;

//        start = System.nanoTime();
//        int[] hashTable_2 = hashTable_2_Dict.batchInsert(path);
//        end = System.nanoTime();
//        long hashTable_2_Time = end - start;

        assertArrayEquals(Avl,RedBlack);
        assertArrayEquals(Avl,hashTable_1);
//        assertArrayEquals(Avl,hashTable_2);



    }

}
