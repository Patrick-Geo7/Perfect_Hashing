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

        String[] str = new String[]{
                "jXIc4vL",
                "v8zPI1C",
                "SriYiI",
                "zVHi5B",
                "WPzu",
                "Tim8F",
                "dcn",
                "WjXK",
                "haha",
                "ceO8eO",
                "alooo",
                "FNcrtQ",
                "Sci218F",
                "SGijU",
                "rhPld2",
                "aG66G",
                "jlyCY6",
                "B3OGZI",
                "pH",
                "Jpu7"};

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

        String[] str = new String[]{
                "2sfE",
                "owQqbfm",
                "tu3YFtp",
                "Gtvegrt",
                "Ptre8",
                "U31",
                "lOmZax",
                "8sDjE",
                "hahaha",
                "momom",
                "zDJ1B2",
                "7VuA79m",
                "a79lb",
                "RsUg",
                "kiTCc",
                "LCe5EMk",
                "k11Pbyz",
                "jv0pt0k",
                "N2",
                "0pe"
            };

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

        String[] str = new String[]{
                "vEhpVOZ",
                "Qjn",
                "DfaiEHA",
                "VzuSf",
                "oajasod",
                "UIXnEC",
                "TZO",
                "g55IE",
                "2evybLV",
                "ogd",
                "msZ",
                "rteM7",
                "XZfn",
                "I0iVzd",
                "L3qsCrG",
                "wJgpD",
                "XnKUrI",
                "Yl0thu",
                "Swj6C",
                "U9x"
        };

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

        String[] str = new String[]{
                "Rkvhs",
                "MiiMGTw",
                "wkg9N",
                "YJGArNP",
                "PKpEz6",
                "IML",
                "ou0T9",
                "Y75",
                "asdmo",
                "asdal",
                "GKiRvzZ",
                "b8Fs",
                "sPLe9H",
                "y3CbRm",
                "O4QPo",
                "DbTlHc",
                "GPrDC",
                "80Ml",
                "GZcGL",
                "odNwABp"
        };

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

        String[] str = new String[]{
                "vaVBW3Z0",
                "GFa35bIa",
                "04WTNdhB",
                "xgMGz",
                "LZAa7",
                "0gBHByc",
                "8bqigPE",
                "xfLfC",
                "k2wTQafv",
                "5r3TYZ",
                "bL57lKP1",
                "lczOb2",
                "X5qhQ",
                "fpjha",
                "7jEKUd",
                "KWOAFU",
                "sRq6Dkh",
                "9jSTlIJ",
                "O1yPndIp",
                "ZIUxkV2"
        };

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

        String[] str = new String[]{
                "WwHIrf",
                "0bfDB",
                "wm7eP",
                "Nw4Ux",
                "brOO1",
                "et63cT2",
                "rUZgLBz",
                "qsnoSNAw",
                "qfmdc2L",
                "pbXRhCt",
                "nwvGN",
                "cpp3K",
                "0Rx1LioZ",
                "BDLe2vaN",
                "stN8coL",
                "bLv0eMFc",
                "uvXbF",
                "vl3iZ",
                "a8WVHGWb",
                "M87i2aQ"
        };

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

        String[] str = new String[]{
                "ZNBIA",
                "1nAE8RA",
                "CXKkReX",
                "4OBaFmN8",
                "sJmO5hG",
                "DApoIG",
                "0UIXn2",
                "D7XKb",
                "CMhquw",
                "q61lSng",
                "IGbvKKYR",
                "LKTD7",
                "5Glui2sG",
                "UwYX7bZ",
                "oY1z0Ox",
                "Gzh8d",
                "zw4DfH",
                "Xdw3m",
                "ddZIl",
                "PN8ZFl"
        };

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


    @Test
    void size_1M(){

        long start;
        long end;
        int n = 1000000;
        String path = "1M.txt";

        String[] str = new String[]{
                "ZNBIA",
                "1nAE8RA",
                "CXKkReX",
                "4OBaFmN8",
                "sJmO5hG",
                "DApoIG",
                "0UIXn2",
                "D7XKb",
                "CMhquw",
                "q61lSng",
                "IGbvKKYR",
                "LKTD7",
                "5Glui2sG",
                "UwYX7bZ",
                "oY1z0Ox",
                "Gzh8d",
                "zw4DfH",
                "Xdw3m",
                "ddZIl",
                "PN8ZFl"
        };

        dictionary RedBlack_Dict = new dictionary("RedBlack");
        dictionary Avl_Dict = new dictionary("avl");

//        Dictionnary hashTable_1_Dict = new Dictionnary("oneLevel",n);
        Dictionnary hashTable_2_Dict = new Dictionnary("twoLevels",n);


        start = System.nanoTime();
        int[] RedBlack = RedBlack_Dict.batchInsert(path);
        end = System.nanoTime();
        long RedBlackTime = end - start;

        start = System.nanoTime();
        int[] Avl = Avl_Dict.batchInsert(path);
        end = System.nanoTime();
        long AvlTime = end - start;

//        start = System.nanoTime();
//        int[] hashTable_1 = hashTable_1_Dict.batchInsert(path);
//        end = System.nanoTime();
//        long hashTable_1_Time = end - start;

        start = System.nanoTime();
        int[] hashTable_2 = hashTable_2_Dict.batchInsert(path);
        end = System.nanoTime();
        long hashTable_2_Time = end - start;

        assertArrayEquals(Avl,RedBlack);
//        assertArrayEquals(Avl,hashTable_1);
        assertArrayEquals(Avl,hashTable_2);

        System.out.println("***Total Insertion Time 20000 element***");
        System.out.println("RedBlack tree insertion time : " + RedBlackTime/1000 + " ms");
        System.out.println("Avl tree insertion time : " + AvlTime/1000 + " ms");
//        System.out.println("one level hashTable insertion time : " + hashTable_1_Time/1000 + " ms");
        System.out.println("two levels hashTable insertion time : " + hashTable_2_Time/1000 + " ms");
        System.out.println("===========================================================================================");

        RedBlackTime = 0;
        AvlTime = 0;
//        hashTable_1_Time = 0;
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

//            start = System.nanoTime();
//            boolean hashTable_1_Delete = hashTable_1_Dict.delete(str[i]);
//            end = System.nanoTime();
//            hashTable_1_Time += (end-start);

            start = System.nanoTime();
            boolean hashTable_2_Delete = hashTable_2_Dict.delete(str[i]);
            end = System.nanoTime();
            hashTable_2_Time += (end-start);

            assertEquals(AvlDelete,RedDelete);
//            assertEquals(AvlDelete,hashTable_1_Delete);
            assertEquals(AvlDelete,hashTable_2_Delete);

        }

        System.out.println("***Average Delete Time***");
        System.out.println("RedBlack Average Delete Time : " + RedBlackTime/20/1000 + " ms");
        System.out.println("Avl Average Delete Time : " + AvlTime/20/1000 + " ms");
//        System.out.println("one level hashTable Average Delete Time : " + hashTable_1_Time/20/1000 + " ms");
        System.out.println("two levels hashTable Average Delete Time : " + hashTable_2_Time/20/1000 + " ms");
        System.out.println("===========================================================================================");

        RedBlackTime = 0;
        AvlTime = 0;
//        hashTable_1_Time = 0;
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

//            start = System.nanoTime();
//            boolean hashTable_1_Search = hashTable_1_Dict.search(str[i]);
//            end = System.nanoTime();
//            hashTable_1_Time += (end-start);

            start = System.nanoTime();
            boolean hashTable_2_Search = hashTable_2_Dict.search(str[i]);
            end = System.nanoTime();
            hashTable_2_Time += (end-start);

            assertEquals(AvlSearch,RedSearch);
//            assertEquals(AvlSearch,hashTable_1_Search);
            assertEquals(AvlSearch,hashTable_2_Search);

        }

        System.out.println("***Average Search Time***");
        System.out.println("RedBlack Average Search Time : " + RedBlackTime/20/1000 + " ms");
        System.out.println("Avl Average Search Time : " + AvlTime/20/1000 + " ms");
//        System.out.println("one level hashTable Average Search Time : " + hashTable_1_Time/20/1000 + " ms");
        System.out.println("two levels hashTable Average Search Time : " + hashTable_2_Time/20/1000 + " ms");
        System.out.println("===========================================================================================");

        System.out.println("***Number of collisions in hash Tables***");
//        System.out.println("one level collisions : " + hashTable_1_Dict.collisions() );
        System.out.println("two levels collisions : " + hashTable_2_Dict.collisions() );
        System.out.println("===========================================================================================");
        System.out.println("*** size of hash Tables ***");
//        System.out.println("one level size : " + hashTable_1_Dict.getTableSize() );
        System.out.println("two levels size : " + hashTable_2_Dict.getTableSize() );

    }





}
