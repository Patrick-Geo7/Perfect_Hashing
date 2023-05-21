package src;

import org.junit.jupiter.api.Test;
import src.Trees.dictionary;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

public class SmallTest {

    @Test
    void size_20(){

        long start;
        long end;
        int n = 20;
        System.out.println("hiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiii");

        dictionary RedBlack_Dict = new dictionary("RedBlack");
        dictionary Avl_Dict = new dictionary("avl");

        System.out.println("11111111111111111111111111111111111111111111111111111111111");
        Dictionnary hashTable_1_Dict = new Dictionnary("oneLevel",n);
        System.out.println("222222222222222222222222222222222222222222222222222222222222");
        Dictionnary hashTable_2_Dict = new Dictionnary("twoLevels",n);

        String path = "20.txt";

        System.out.println("RedBlack");
        start = System.nanoTime();
        int[] RedBlack = RedBlack_Dict.batchInsert(path);
        end = System.nanoTime();
        long RedBlackTime = end - start;

        System.out.println("Avl");
        start = System.nanoTime();
        int[] Avl = Avl_Dict.batchInsert(path);
        end = System.nanoTime();
        long AvlTime = end - start;

        System.out.println("hash1");
        start = System.nanoTime();
        int[] hashTable_1 = hashTable_1_Dict.batchInsert(path);
        end = System.nanoTime();
        long hashTable_1_Time = end - start;

        System.out.println("hash2");
        start = System.nanoTime();
        int[] hashTable_2 = hashTable_2_Dict.batchInsert(path);
        end = System.nanoTime();
        long hashTable_2_Time = end - start;

        assertArrayEquals(RedBlack,Avl);
        assertArrayEquals(hashTable_1,Avl);
        assertArrayEquals(hashTable_2,Avl);



    }

}
