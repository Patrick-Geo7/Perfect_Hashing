package src;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Dictionnary implements IDictionnary{

    IHashTable hashTable;
    int collisions = 0;
    Dictionnary(String name, int n){
        if(name.compareTo("oneLevel")==0){
            hashTable = new HashTable1Level(n);
        }
        else{
            hashTable = new HashTable2Levels(n);
        }
    }
    @Override
    public boolean insert(String key) {
        boolean flag = hashTable.insert(key);
        System.out.println("nnnnnnnnnnnnnnnnnnnnnnn");
        System.out.println(hashTable.getRebuildCount());
        collisions += hashTable.getRebuildCount();
        return flag;

        //edit the return value

    }

    /**
     * @param
     * @return
     */
    @Override
    public boolean delete(String key) {
        return hashTable.delete(key);

        //edit the return value

    }

    /**
     * @param
     * @return
     */
    @Override
    public boolean search(String key) {
        return hashTable.search(key);
    }

    /**
     * @param path 
     * @return
     */
    @Override
    public int[] batchInsert(String path) {
        collisions=0;
        int[] counters = {0,0};
        int insert_count = 0;
        int exist_count = 0;

        try{
            File myfile = new File(path);
            Scanner myReader = new Scanner(myfile);
            while(myReader.hasNextLine()){
                String word = myReader.nextLine();
                boolean inserted = this.insert(word);
                if(inserted){
                    insert_count = insert_count+1;
                }
                else
                    exist_count = exist_count+1;
            }
            myReader.close();
        }catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }

        counters[0] = insert_count;
        counters[1] = exist_count;

        // index 0 inserted ... index 1 existed
        return counters;

    }

    /**
     * @param path 
     * @return
     */
    @Override
    public int[] batchDelete(String path) {
        int[] counters = {0,0};
        int deleted_count=0;
        int notExist_count=0;

        try{
            File myfile = new File(path);
            Scanner myReader = new Scanner(myfile);
            while(myReader.hasNextLine()){
                String word = myReader.nextLine();
                boolean deleted = hashTable.delete(word);
                if(deleted){
                    deleted_count = deleted_count+1;
                }
                else
                    notExist_count = notExist_count+1;
            }
            myReader.close();
        }catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }

        counters[0] = deleted_count;
        counters[1] = notExist_count;
        return counters;

    }

    @Override
    public int collisions() {
        return this.collisions;
    }
    @Override
    public int getTableSize() {
        return hashTable.getTotalSize();
    }

}
