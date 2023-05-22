package src;

import org.junit.jupiter.api.Test;
import src.Trees.dictionary;

import static org.junit.jupiter.api.Assertions.*;


public class HashTablesTest {


    @Test
    void size_100(){

        long start;
        long end;
        int n = 100;
        String path = "100.txt";

        String[] str = new String[]{"8QY8q", "G9ZOhRE", "WVp", "RkBg", "R2xmMh", "m91e1Je", "ozLUT", "FlBt", "6iFR2Dr", "hhh", "alooo", "8QY8q", "Nw", "ydgoLA", "A35p2F1", "JD8rQ", "wvy", "sRpa", "gEpxl", "hahaha"};

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

        start = System.nanoTime();
        int[] hashTable_2 = hashTable_2_Dict.batchInsert(path);
        end = System.nanoTime();
        long hashTable_2_Time = end - start;

        assertArrayEquals(Avl,RedBlack);
        assertArrayEquals(Avl,hashTable_1);
        assertArrayEquals(Avl,hashTable_2);

        System.out.println("***Total Insertion Time 100 element***");
        System.out.println("RedBlack tree insertion time : " + RedBlackTime/1000 + " ms");
        System.out.println("Avl tree insertion time : " + AvlTime/1000 + " ms");
        System.out.println("one level hashTable insertion time : " + hashTable_1_Time/1000 + " ms");
        System.out.println("two levels hashTable insertion time : " + hashTable_2_Time/1000 + " ms");
        System.out.println("===========================================================================================");

        RedBlackTime = 0;
        AvlTime = 0;
        hashTable_1_Time = 0;
        hashTable_2_Time = 0;

        for(int i=0; i<20; i++){

            start = System.nanoTime();
            boolean RedDelete = RedBlack_Dict.delete(str[i]);
            end = System.nanoTime();
            RedBlackTime += (end-start);

            start = System.nanoTime();
            boolean AvlDelete = Avl_Dict.delete(str[i]);
            end = System.nanoTime();
            AvlTime += (end-start);

            start = System.nanoTime();
            boolean hashTable_1_Delete = hashTable_1_Dict.delete(str[i]);
            end = System.nanoTime();
            hashTable_1_Time += (end-start);

            start = System.nanoTime();
            boolean hashTable_2_Delete = hashTable_2_Dict.delete(str[i]);
            end = System.nanoTime();
            hashTable_2_Time += (end-start);

            assertEquals(AvlDelete,RedDelete);
            assertEquals(AvlDelete,hashTable_1_Delete);
            assertEquals(AvlDelete,hashTable_2_Delete);

        }

        System.out.println("***Average Delete Time***");
        System.out.println("RedBlack Average Delete Time : " + RedBlackTime/20/1000 + " ms");
        System.out.println("Avl Average Delete Time : " + AvlTime/20/1000 + " ms");
        System.out.println("one level hashTable Average Delete Time : " + hashTable_1_Time/20/1000 + " ms");
        System.out.println("two levels hashTable Average Delete Time : " + hashTable_2_Time/20/1000 + " ms");
        System.out.println("===========================================================================================");

        RedBlackTime = 0;
        AvlTime = 0;
        hashTable_1_Time = 0;
        hashTable_2_Time = 0;


        for(int i=0; i<20; i++){

            start = System.nanoTime();
            boolean RedSearch = RedBlack_Dict.search(str[i]);
            end = System.nanoTime();
            RedBlackTime += (end-start);

            start = System.nanoTime();
            boolean AvlSearch = Avl_Dict.search(str[i]);
            end = System.nanoTime();
            AvlTime += (end-start);

            start = System.nanoTime();
            boolean hashTable_1_Search = hashTable_1_Dict.search(str[i]);
            end = System.nanoTime();
            hashTable_1_Time += (end-start);

            start = System.nanoTime();
            boolean hashTable_2_Search = hashTable_2_Dict.search(str[i]);
            end = System.nanoTime();
            hashTable_2_Time += (end-start);

            assertEquals(AvlSearch,RedSearch);
            assertEquals(AvlSearch,hashTable_1_Search);
            assertEquals(AvlSearch,hashTable_2_Search);

        }

        System.out.println("***Average Search Time***");
        System.out.println("RedBlack Average Search Time : " + RedBlackTime/20/1000 + " ms");
        System.out.println("Avl Average Search Time : " + AvlTime/20/1000 + " ms");
        System.out.println("one level hashTable Average Search Time : " + hashTable_1_Time/20/1000 + " ms");
        System.out.println("two levels hashTable Average Search Time : " + hashTable_2_Time/20/1000 + " ms");
        System.out.println("===========================================================================================");

        System.out.println("***Number of collisions in hash Tables***");
        System.out.println("one level collisions : " + hashTable_1_Dict.collisions() );
        System.out.println("two levels collisions : " + hashTable_2_Dict.collisions() );
        System.out.println("===========================================================================================");
        System.out.println("*** size of hash Tables ***");
        System.out.println("one level size : " + hashTable_1_Dict.getTableSize() );
        System.out.println("two levels size : " + hashTable_2_Dict.getTableSize() );

    }

    @Test
    void size_250(){

        long start;
        long end;
        int n = 250;
        String path = "250.txt";

        String[] str = new String[]{"XpoeE", "G9ZOhRE", "tu3YFtp", "RkBg", "8sDjE", "m91e1Je", "ozLUT", "H", "iTZW", "hhh", "alooo", "4lk6G5C", "Nw", "y0xh", "A35p2F1", "u1", "CzK1pd4", "sRpa", "wyt", "hahaha"};

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

        start = System.nanoTime();
        int[] hashTable_2 = hashTable_2_Dict.batchInsert(path);
        end = System.nanoTime();
        long hashTable_2_Time = end - start;

        assertArrayEquals(Avl,RedBlack);
        assertArrayEquals(Avl,hashTable_1);
        assertArrayEquals(Avl,hashTable_2);

        System.out.println("***Total Insertion Time 250 element***");
        System.out.println("RedBlack tree insertion time : " + RedBlackTime/1000 + " ms");
        System.out.println("Avl tree insertion time : " + AvlTime/1000 + " ms");
        System.out.println("one level hashTable insertion time : " + hashTable_1_Time/1000 + " ms");
        System.out.println("two levels hashTable insertion time : " + hashTable_2_Time/1000 + " ms");
        System.out.println("===========================================================================================");

        RedBlackTime = 0;
        AvlTime = 0;
        hashTable_1_Time = 0;
        hashTable_2_Time = 0;

        for(int i=0; i<20; i++){

            start = System.nanoTime();
            boolean RedDelete = RedBlack_Dict.delete(str[i]);
            end = System.nanoTime();
            RedBlackTime += (end-start);

            start = System.nanoTime();
            boolean AvlDelete = Avl_Dict.delete(str[i]);
            end = System.nanoTime();
            AvlTime += (end-start);

            start = System.nanoTime();
            boolean hashTable_1_Delete = hashTable_1_Dict.delete(str[i]);
            end = System.nanoTime();
            hashTable_1_Time += (end-start);

            start = System.nanoTime();
            boolean hashTable_2_Delete = hashTable_2_Dict.delete(str[i]);
            end = System.nanoTime();
            hashTable_2_Time += (end-start);

            assertEquals(AvlDelete,RedDelete);
            assertEquals(AvlDelete,hashTable_1_Delete);
            assertEquals(AvlDelete,hashTable_2_Delete);

        }

        System.out.println("***Average Delete Time***");
        System.out.println("RedBlack Average Delete Time : " + RedBlackTime/20/1000 + " ms");
        System.out.println("Avl Average Delete Time : " + AvlTime/20/1000 + " ms");
        System.out.println("one level hashTable Average Delete Time : " + hashTable_1_Time/20/1000 + " ms");
        System.out.println("two levels hashTable Average Delete Time : " + hashTable_2_Time/20/1000 + " ms");
        System.out.println("===========================================================================================");

        RedBlackTime = 0;
        AvlTime = 0;
        hashTable_1_Time = 0;
        hashTable_2_Time = 0;


        for(int i=0; i<20; i++){

            start = System.nanoTime();
            boolean RedSearch = RedBlack_Dict.search(str[i]);
            end = System.nanoTime();
            RedBlackTime += (end-start);

            start = System.nanoTime();
            boolean AvlSearch = Avl_Dict.search(str[i]);
            end = System.nanoTime();
            AvlTime += (end-start);

            start = System.nanoTime();
            boolean hashTable_1_Search = hashTable_1_Dict.search(str[i]);
            end = System.nanoTime();
            hashTable_1_Time += (end-start);

            start = System.nanoTime();
            boolean hashTable_2_Search = hashTable_2_Dict.search(str[i]);
            end = System.nanoTime();
            hashTable_2_Time += (end-start);

            assertEquals(AvlSearch,RedSearch);
            assertEquals(AvlSearch,hashTable_1_Search);
            assertEquals(AvlSearch,hashTable_2_Search);

        }

        System.out.println("***Average Search Time***");
        System.out.println("RedBlack Average Search Time : " + RedBlackTime/20/1000 + " ms");
        System.out.println("Avl Average Search Time : " + AvlTime/20/1000 + " ms");
        System.out.println("one level hashTable Average Search Time : " + hashTable_1_Time/20/1000 + " ms");
        System.out.println("two levels hashTable Average Search Time : " + hashTable_2_Time/20/1000 + " ms");
        System.out.println("===========================================================================================");

        System.out.println("***Number of collisions in hash Tables***");
        System.out.println("one level collisions : " + hashTable_1_Dict.collisions() );
        System.out.println("two levels collisions : " + hashTable_2_Dict.collisions() );
        System.out.println("===========================================================================================");
        System.out.println("*** size of hash Tables ***");
        System.out.println("one level size : " + hashTable_1_Dict.getTableSize() );
        System.out.println("two levels size : " + hashTable_2_Dict.getTableSize() );

    }
    @Test
    void size_500(){

        long start;
        long end;
        int n = 500;
        String path = "500.txt";

        String[] str = new String[]{"D8GBMWN", "G9ZOhRE", "L", "RkBg", "Ww", "m91e1Je", "8Bfb", "H", "DMU87O", "hhh", "alooo", "7", "Nw", "sXJYH7", "A35p2F1", "uo", "CzK1pd4", "l2za4h", "E6", "hahaha"};

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

        start = System.nanoTime();
        int[] hashTable_2 = hashTable_2_Dict.batchInsert(path);
        end = System.nanoTime();
        long hashTable_2_Time = end - start;

        assertArrayEquals(Avl,RedBlack);
        assertArrayEquals(Avl,hashTable_1);
        assertArrayEquals(Avl,hashTable_2);

        System.out.println("***Total Insertion Time 500 element***");
        System.out.println("RedBlack tree insertion time : " + RedBlackTime/1000 + " ms");
        System.out.println("Avl tree insertion time : " + AvlTime/1000 + " ms");
        System.out.println("one level hashTable insertion time : " + hashTable_1_Time/1000 + " ms");
        System.out.println("two levels hashTable insertion time : " + hashTable_2_Time/1000 + " ms");
        System.out.println("===========================================================================================");

        RedBlackTime = 0;
        AvlTime = 0;
        hashTable_1_Time = 0;
        hashTable_2_Time = 0;

        for(int i=0; i<20; i++){

            start = System.nanoTime();
            boolean RedDelete = RedBlack_Dict.delete(str[i]);
            end = System.nanoTime();
            RedBlackTime += (end-start);

            start = System.nanoTime();
            boolean AvlDelete = Avl_Dict.delete(str[i]);
            end = System.nanoTime();
            AvlTime += (end-start);

            start = System.nanoTime();
            boolean hashTable_1_Delete = hashTable_1_Dict.delete(str[i]);
            end = System.nanoTime();
            hashTable_1_Time += (end-start);

            start = System.nanoTime();
            boolean hashTable_2_Delete = hashTable_2_Dict.delete(str[i]);
            end = System.nanoTime();
            hashTable_2_Time += (end-start);

            assertEquals(AvlDelete,RedDelete);
            assertEquals(AvlDelete,hashTable_1_Delete);
            assertEquals(AvlDelete,hashTable_2_Delete);

        }

        System.out.println("***Average Delete Time***");
        System.out.println("RedBlack Average Delete Time : " + RedBlackTime/20/1000 + " ms");
        System.out.println("Avl Average Delete Time : " + AvlTime/20/1000 + " ms");
        System.out.println("one level hashTable Average Delete Time : " + hashTable_1_Time/20/1000 + " ms");
        System.out.println("two levels hashTable Average Delete Time : " + hashTable_2_Time/20/1000 + " ms");
        System.out.println("===========================================================================================");

        RedBlackTime = 0;
        AvlTime = 0;
        hashTable_1_Time = 0;
        hashTable_2_Time = 0;


        for(int i=0; i<20; i++){

            start = System.nanoTime();
            boolean RedSearch = RedBlack_Dict.search(str[i]);
            end = System.nanoTime();
            RedBlackTime += (end-start);

            start = System.nanoTime();
            boolean AvlSearch = Avl_Dict.search(str[i]);
            end = System.nanoTime();
            AvlTime += (end-start);

            start = System.nanoTime();
            boolean hashTable_1_Search = hashTable_1_Dict.search(str[i]);
            end = System.nanoTime();
            hashTable_1_Time += (end-start);

            start = System.nanoTime();
            boolean hashTable_2_Search = hashTable_2_Dict.search(str[i]);
            end = System.nanoTime();
            hashTable_2_Time += (end-start);

            assertEquals(AvlSearch,RedSearch);
            assertEquals(AvlSearch,hashTable_1_Search);
            assertEquals(AvlSearch,hashTable_2_Search);

        }

        System.out.println("***Average Search Time***");
        System.out.println("RedBlack Average Search Time : " + RedBlackTime/20/1000 + " ms");
        System.out.println("Avl Average Search Time : " + AvlTime/20/1000 + " ms");
        System.out.println("one level hashTable Average Search Time : " + hashTable_1_Time/20/1000 + " ms");
        System.out.println("two levels hashTable Average Search Time : " + hashTable_2_Time/20/1000 + " ms");
        System.out.println("===========================================================================================");

        System.out.println("***Number of collisions in hash Tables***");
        System.out.println("one level collisions : " + hashTable_1_Dict.collisions() );
        System.out.println("two levels collisions : " + hashTable_2_Dict.collisions() );
        System.out.println("===========================================================================================");
        System.out.println("*** size of hash Tables ***");
        System.out.println("one level size : " + hashTable_1_Dict.getTableSize() );
        System.out.println("two levels size : " + hashTable_2_Dict.getTableSize() );

    }

    @Test
    void size_1k(){

        long start;
        long end;
        int n = 1000;
        String path = "1000.txt";

        String[] str = new String[]{"Q01H", "vmY0", "A", "mKA5rFd", "uQu97", "GN11", "Sb", "H", "6YBCtI", "hhh", "alooo", "FlO1B", "Nw", "sXJYH7", "2", "uo", "CzK1pd4", "Miqzc", "QBWFpdK", "hahaha"};

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

        start = System.nanoTime();
        int[] hashTable_2 = hashTable_2_Dict.batchInsert(path);
        end = System.nanoTime();
        long hashTable_2_Time = end - start;

        assertArrayEquals(Avl,RedBlack);
        assertArrayEquals(Avl,hashTable_1);
        assertArrayEquals(Avl,hashTable_2);

        System.out.println("***Total Insertion Time 1000 element***");
        System.out.println("RedBlack tree insertion time : " + RedBlackTime/1000 + " ms");
        System.out.println("Avl tree insertion time : " + AvlTime/1000 + " ms");
        System.out.println("one level hashTable insertion time : " + hashTable_1_Time/1000 + " ms");
        System.out.println("two levels hashTable insertion time : " + hashTable_2_Time/1000 + " ms");
        System.out.println("===========================================================================================");

        RedBlackTime = 0;
        AvlTime = 0;
        hashTable_1_Time = 0;
        hashTable_2_Time = 0;

        for(int i=0; i<20; i++){

            start = System.nanoTime();
            boolean RedDelete = RedBlack_Dict.delete(str[i]);
            end = System.nanoTime();
            RedBlackTime += (end-start);

            start = System.nanoTime();
            boolean AvlDelete = Avl_Dict.delete(str[i]);
            end = System.nanoTime();
            AvlTime += (end-start);

            start = System.nanoTime();
            boolean hashTable_1_Delete = hashTable_1_Dict.delete(str[i]);
            end = System.nanoTime();
            hashTable_1_Time += (end-start);

            start = System.nanoTime();
            boolean hashTable_2_Delete = hashTable_2_Dict.delete(str[i]);
            end = System.nanoTime();
            hashTable_2_Time += (end-start);

            assertEquals(AvlDelete,RedDelete);
            assertEquals(AvlDelete,hashTable_1_Delete);
            assertEquals(AvlDelete,hashTable_2_Delete);

        }

        System.out.println("***Average Delete Time***");
        System.out.println("RedBlack Average Delete Time : " + RedBlackTime/20/1000 + " ms");
        System.out.println("Avl Average Delete Time : " + AvlTime/20/1000 + " ms");
        System.out.println("one level hashTable Average Delete Time : " + hashTable_1_Time/20/1000 + " ms");
        System.out.println("two levels hashTable Average Delete Time : " + hashTable_2_Time/20/1000 + " ms");
        System.out.println("===========================================================================================");

        RedBlackTime = 0;
        AvlTime = 0;
        hashTable_1_Time = 0;
        hashTable_2_Time = 0;


        for(int i=0; i<20; i++){

            start = System.nanoTime();
            boolean RedSearch = RedBlack_Dict.search(str[i]);
            end = System.nanoTime();
            RedBlackTime += (end-start);

            start = System.nanoTime();
            boolean AvlSearch = Avl_Dict.search(str[i]);
            end = System.nanoTime();
            AvlTime += (end-start);

            start = System.nanoTime();
            boolean hashTable_1_Search = hashTable_1_Dict.search(str[i]);
            end = System.nanoTime();
            hashTable_1_Time += (end-start);

            start = System.nanoTime();
            boolean hashTable_2_Search = hashTable_2_Dict.search(str[i]);
            end = System.nanoTime();
            hashTable_2_Time += (end-start);

            assertEquals(AvlSearch,RedSearch);
            assertEquals(AvlSearch,hashTable_1_Search);
            assertEquals(AvlSearch,hashTable_2_Search);

        }

        System.out.println("***Average Search Time***");
        System.out.println("RedBlack Average Search Time : " + RedBlackTime/20/1000 + " ms");
        System.out.println("Avl Average Search Time : " + AvlTime/20/1000 + " ms");
        System.out.println("one level hashTable Average Search Time : " + hashTable_1_Time/20/1000 + " ms");
        System.out.println("two levels hashTable Average Search Time : " + hashTable_2_Time/20/1000 + " ms");
        System.out.println("===========================================================================================");

        System.out.println("***Number of collisions in hash Tables***");
        System.out.println("one level collisions : " + hashTable_1_Dict.collisions() );
        System.out.println("two levels collisions : " + hashTable_2_Dict.collisions() );
        System.out.println("===========================================================================================");
        System.out.println("*** size of hash Tables ***");
        System.out.println("one level size : " + hashTable_1_Dict.getTableSize() );
        System.out.println("two levels size : " + hashTable_2_Dict.getTableSize() );

    }


    @Test
    void size_5k(){

        long start;
        long end;
        int n = 5000;
        String path = "5k.txt";

        String[] str = new String[]{"K8XpYw3", "G9ZOhRE", "L", "W4CJ55", "HO5lWnN", "ofG7Yz", "wZtGa2l", "2WoqVSA", "SkPwhd", "fumB3T", "alooo", "d1mF3Io", "kli2Loc", "sXJYH7", "EDQH4t8", "uo", "CzK1pd4", "n6dyQ", "E6", "hahaha"};

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

        start = System.nanoTime();
        int[] hashTable_2 = hashTable_2_Dict.batchInsert(path);
        end = System.nanoTime();
        long hashTable_2_Time = end - start;

        assertArrayEquals(Avl,RedBlack);
        assertArrayEquals(Avl,hashTable_1);
        assertArrayEquals(Avl,hashTable_2);

        System.out.println("***Total Insertion Time 5000 element***");
        System.out.println("RedBlack tree insertion time : " + RedBlackTime/1000 + " ms");
        System.out.println("Avl tree insertion time : " + AvlTime/1000 + " ms");
        System.out.println("one level hashTable insertion time : " + hashTable_1_Time/1000 + " ms");
        System.out.println("two levels hashTable insertion time : " + hashTable_2_Time/1000 + " ms");
        System.out.println("===========================================================================================");

        RedBlackTime = 0;
        AvlTime = 0;
        hashTable_1_Time = 0;
        hashTable_2_Time = 0;

        for(int i=0; i<20; i++){

            start = System.nanoTime();
            boolean RedDelete = RedBlack_Dict.delete(str[i]);
            end = System.nanoTime();
            RedBlackTime += (end-start);

            start = System.nanoTime();
            boolean AvlDelete = Avl_Dict.delete(str[i]);
            end = System.nanoTime();
            AvlTime += (end-start);

            start = System.nanoTime();
            boolean hashTable_1_Delete = hashTable_1_Dict.delete(str[i]);
            end = System.nanoTime();
            hashTable_1_Time += (end-start);

            start = System.nanoTime();
            boolean hashTable_2_Delete = hashTable_2_Dict.delete(str[i]);
            end = System.nanoTime();
            hashTable_2_Time += (end-start);

            assertEquals(AvlDelete,RedDelete);
            assertEquals(AvlDelete,hashTable_1_Delete);
            assertEquals(AvlDelete,hashTable_2_Delete);

        }

        System.out.println("***Average Delete Time***");
        System.out.println("RedBlack Average Delete Time : " + RedBlackTime/20/1000 + " ms");
        System.out.println("Avl Average Delete Time : " + AvlTime/20/1000 + " ms");
        System.out.println("one level hashTable Average Delete Time : " + hashTable_1_Time/20/1000 + " ms");
        System.out.println("two levels hashTable Average Delete Time : " + hashTable_2_Time/20/1000 + " ms");
        System.out.println("===========================================================================================");

        RedBlackTime = 0;
        AvlTime = 0;
        hashTable_1_Time = 0;
        hashTable_2_Time = 0;


        for(int i=0; i<20; i++){

            start = System.nanoTime();
            boolean RedSearch = RedBlack_Dict.search(str[i]);
            end = System.nanoTime();
            RedBlackTime += (end-start);

            start = System.nanoTime();
            boolean AvlSearch = Avl_Dict.search(str[i]);
            end = System.nanoTime();
            AvlTime += (end-start);

            start = System.nanoTime();
            boolean hashTable_1_Search = hashTable_1_Dict.search(str[i]);
            end = System.nanoTime();
            hashTable_1_Time += (end-start);

            start = System.nanoTime();
            boolean hashTable_2_Search = hashTable_2_Dict.search(str[i]);
            end = System.nanoTime();
            hashTable_2_Time += (end-start);

            assertEquals(AvlSearch,RedSearch);
            assertEquals(AvlSearch,hashTable_1_Search);
            assertEquals(AvlSearch,hashTable_2_Search);

        }

        System.out.println("***Average Search Time***");
        System.out.println("RedBlack Average Search Time : " + RedBlackTime/20/1000 + " ms");
        System.out.println("Avl Average Search Time : " + AvlTime/20/1000 + " ms");
        System.out.println("one level hashTable Average Search Time : " + hashTable_1_Time/20/1000 + " ms");
        System.out.println("two levels hashTable Average Search Time : " + hashTable_2_Time/20/1000 + " ms");
        System.out.println("===========================================================================================");

        System.out.println("***Number of collisions in hash Tables***");
        System.out.println("one level collisions : " + hashTable_1_Dict.collisions() );
        System.out.println("two levels collisions : " + hashTable_2_Dict.collisions() );
        System.out.println("===========================================================================================");
        System.out.println("*** size of hash Tables ***");
        System.out.println("one level size : " + hashTable_1_Dict.getTableSize() );
        System.out.println("two levels size : " + hashTable_2_Dict.getTableSize() );

    }


    @Test
    void size_10k(){

        long start;
        long end;
        int n = 10000;
        String path = "10k.txt";

        String[] str = new String[]{"Jxf", "G9ZOhRE", "2oYZ", "W4CJ55", "5Tdu", "ofG7Yz", "d9VE", "2WoqVSA", "6bVba", "fumB3T", "alooo", "iloMC", "kli2Loc", "7bWzG", "EDQH4t8", "mpu", "CzK1pd4", "AWx", "YfRoZ", "hahaha"};

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

        start = System.nanoTime();
        int[] hashTable_2 = hashTable_2_Dict.batchInsert(path);
        end = System.nanoTime();
        long hashTable_2_Time = end - start;

        assertArrayEquals(Avl,RedBlack);
        assertArrayEquals(Avl,hashTable_1);
        assertArrayEquals(Avl,hashTable_2);

        System.out.println("***Total Insertion Time 10000 element***");
        System.out.println("RedBlack tree insertion time : " + RedBlackTime/1000 + " ms");
        System.out.println("Avl tree insertion time : " + AvlTime/1000 + " ms");
        System.out.println("one level hashTable insertion time : " + hashTable_1_Time/1000 + " ms");
        System.out.println("two levels hashTable insertion time : " + hashTable_2_Time/1000 + " ms");
        System.out.println("===========================================================================================");

        RedBlackTime = 0;
        AvlTime = 0;
        hashTable_1_Time = 0;
        hashTable_2_Time = 0;

        for(int i=0; i<20; i++){

            start = System.nanoTime();
            boolean RedDelete = RedBlack_Dict.delete(str[i]);
            end = System.nanoTime();
            RedBlackTime += (end-start);

            start = System.nanoTime();
            boolean AvlDelete = Avl_Dict.delete(str[i]);
            end = System.nanoTime();
            AvlTime += (end-start);

            start = System.nanoTime();
            boolean hashTable_1_Delete = hashTable_1_Dict.delete(str[i]);
            end = System.nanoTime();
            hashTable_1_Time += (end-start);

            start = System.nanoTime();
            boolean hashTable_2_Delete = hashTable_2_Dict.delete(str[i]);
            end = System.nanoTime();
            hashTable_2_Time += (end-start);

            assertEquals(AvlDelete,RedDelete);
            assertEquals(AvlDelete,hashTable_1_Delete);
            assertEquals(AvlDelete,hashTable_2_Delete);

        }

        System.out.println("***Average Delete Time***");
        System.out.println("RedBlack Average Delete Time : " + RedBlackTime/20/1000 + " ms");
        System.out.println("Avl Average Delete Time : " + AvlTime/20/1000 + " ms");
        System.out.println("one level hashTable Average Delete Time : " + hashTable_1_Time/20/1000 + " ms");
        System.out.println("two levels hashTable Average Delete Time : " + hashTable_2_Time/20/1000 + " ms");
        System.out.println("===========================================================================================");

        RedBlackTime = 0;
        AvlTime = 0;
        hashTable_1_Time = 0;
        hashTable_2_Time = 0;


        for(int i=0; i<20; i++){

            start = System.nanoTime();
            boolean RedSearch = RedBlack_Dict.search(str[i]);
            end = System.nanoTime();
            RedBlackTime += (end-start);

            start = System.nanoTime();
            boolean AvlSearch = Avl_Dict.search(str[i]);
            end = System.nanoTime();
            AvlTime += (end-start);

            start = System.nanoTime();
            boolean hashTable_1_Search = hashTable_1_Dict.search(str[i]);
            end = System.nanoTime();
            hashTable_1_Time += (end-start);

            start = System.nanoTime();
            boolean hashTable_2_Search = hashTable_2_Dict.search(str[i]);
            end = System.nanoTime();
            hashTable_2_Time += (end-start);

            assertEquals(AvlSearch,RedSearch);
            assertEquals(AvlSearch,hashTable_1_Search);
            assertEquals(AvlSearch,hashTable_2_Search);

        }

        System.out.println("***Average Search Time***");
        System.out.println("RedBlack Average Search Time : " + RedBlackTime/20/1000 + " ms");
        System.out.println("Avl Average Search Time : " + AvlTime/20/1000 + " ms");
        System.out.println("one level hashTable Average Search Time : " + hashTable_1_Time/20/1000 + " ms");
        System.out.println("two levels hashTable Average Search Time : " + hashTable_2_Time/20/1000 + " ms");
        System.out.println("===========================================================================================");

        System.out.println("***Number of collisions in hash Tables***");
        System.out.println("one level collisions : " + hashTable_1_Dict.collisions() );
        System.out.println("two levels collisions : " + hashTable_2_Dict.collisions() );
        System.out.println("===========================================================================================");
        System.out.println("*** size of hash Tables ***");
        System.out.println("one level size : " + hashTable_1_Dict.getTableSize() );
        System.out.println("two levels size : " + hashTable_2_Dict.getTableSize() );

    }

    @Test
    void size_20k(){

        long start;
        long end;
        int n = 20000;
        String path = "20k.txt";

        String[] str = new String[]{"Jxf", "G9ZOhRE", "2oYZ", "W4CJ55", "5Tdu", "ofG7Yz", "d9VE", "2WoqVSA", "6bVba", "fumB3T", "alooo", "iloMC", "kli2Loc", "7bWzG", "EDQH4t8", "mpu", "CzK1pd4", "AWx", "YfRoZ", "hahaha"};

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

        start = System.nanoTime();
        int[] hashTable_2 = hashTable_2_Dict.batchInsert(path);
        end = System.nanoTime();
        long hashTable_2_Time = end - start;

        assertArrayEquals(Avl,RedBlack);
        assertArrayEquals(Avl,hashTable_1);
        assertArrayEquals(Avl,hashTable_2);

        System.out.println("***Total Insertion Time 20000 element***");
        System.out.println("RedBlack tree insertion time : " + RedBlackTime/1000 + " ms");
        System.out.println("Avl tree insertion time : " + AvlTime/1000 + " ms");
        System.out.println("one level hashTable insertion time : " + hashTable_1_Time/1000 + " ms");
        System.out.println("two levels hashTable insertion time : " + hashTable_2_Time/1000 + " ms");
        System.out.println("===========================================================================================");

        RedBlackTime = 0;
        AvlTime = 0;
        hashTable_1_Time = 0;
        hashTable_2_Time = 0;

        for(int i=0; i<20; i++){

            start = System.nanoTime();
            boolean RedDelete = RedBlack_Dict.delete(str[i]);
            end = System.nanoTime();
            RedBlackTime += (end-start);

            start = System.nanoTime();
            boolean AvlDelete = Avl_Dict.delete(str[i]);
            end = System.nanoTime();
            AvlTime += (end-start);

            start = System.nanoTime();
            boolean hashTable_1_Delete = hashTable_1_Dict.delete(str[i]);
            end = System.nanoTime();
            hashTable_1_Time += (end-start);

            start = System.nanoTime();
            boolean hashTable_2_Delete = hashTable_2_Dict.delete(str[i]);
            end = System.nanoTime();
            hashTable_2_Time += (end-start);

            assertEquals(AvlDelete,RedDelete);
            assertEquals(AvlDelete,hashTable_1_Delete);
            assertEquals(AvlDelete,hashTable_2_Delete);

        }

        System.out.println("***Average Delete Time***");
        System.out.println("RedBlack Average Delete Time : " + RedBlackTime/20/1000 + " ms");
        System.out.println("Avl Average Delete Time : " + AvlTime/20/1000 + " ms");
        System.out.println("one level hashTable Average Delete Time : " + hashTable_1_Time/20/1000 + " ms");
        System.out.println("two levels hashTable Average Delete Time : " + hashTable_2_Time/20/1000 + " ms");
        System.out.println("===========================================================================================");

        RedBlackTime = 0;
        AvlTime = 0;
        hashTable_1_Time = 0;
        hashTable_2_Time = 0;


        for(int i=0; i<20; i++){

            start = System.nanoTime();
            boolean RedSearch = RedBlack_Dict.search(str[i]);
            end = System.nanoTime();
            RedBlackTime += (end-start);

            start = System.nanoTime();
            boolean AvlSearch = Avl_Dict.search(str[i]);
            end = System.nanoTime();
            AvlTime += (end-start);

            start = System.nanoTime();
            boolean hashTable_1_Search = hashTable_1_Dict.search(str[i]);
            end = System.nanoTime();
            hashTable_1_Time += (end-start);

            start = System.nanoTime();
            boolean hashTable_2_Search = hashTable_2_Dict.search(str[i]);
            end = System.nanoTime();
            hashTable_2_Time += (end-start);

            assertEquals(AvlSearch,RedSearch);
            assertEquals(AvlSearch,hashTable_1_Search);
            assertEquals(AvlSearch,hashTable_2_Search);

        }

        System.out.println("***Average Search Time***");
        System.out.println("RedBlack Average Search Time : " + RedBlackTime/20/1000 + " ms");
        System.out.println("Avl Average Search Time : " + AvlTime/20/1000 + " ms");
        System.out.println("one level hashTable Average Search Time : " + hashTable_1_Time/20/1000 + " ms");
        System.out.println("two levels hashTable Average Search Time : " + hashTable_2_Time/20/1000 + " ms");
        System.out.println("===========================================================================================");

        System.out.println("***Number of collisions in hash Tables***");
        System.out.println("one level collisions : " + hashTable_1_Dict.collisions() );
        System.out.println("two levels collisions : " + hashTable_2_Dict.collisions() );
        System.out.println("===========================================================================================");
        System.out.println("*** size of hash Tables ***");
        System.out.println("one level size : " + hashTable_1_Dict.getTableSize() );
        System.out.println("two levels size : " + hashTable_2_Dict.getTableSize() );

    }








}
