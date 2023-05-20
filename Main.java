import java.util.Scanner;
import java.util.concurrent.TimeUnit;

import static java.lang.Math.*;
import static java.lang.Math.log;

public class Main {

    public static void main(String[] args) throws InterruptedException {

        boolean flag = true;
        Scanner sc = new Scanner(System.in);
        System.out.println("Please choose your preferred type of hashTable");
        System.out.println("1- One Level O(N^2) space");
        System.out.println("2- Two Level O(N) space");
        String option = sc.next();
        System.out.print("please Enter the space N : ");
        int N = sc.nextInt();

        IDictionnary dictionary;

        if(option.equals("1")){
            dictionary = new Dictionnary("oneLevel",N);
        } else {
            dictionary = new Dictionnary("TwoLevel",N);
        }

        while(flag){
            System.out.print("\n1- Insert a word\n2- Delete a word\n3- Search for a word\n4- Batch Insert\n5- Batch Delete\n6- exit\n");
            System.out.print("\nPlease choose an option: ");
            String option_menu2 = sc.next();

            switch (option_menu2) {
                case "1" -> {
                    System.out.print("Enter a word to be inserted : ");
                    String inserted_word = sc.next();

                    if (dictionary.insert(inserted_word)) {
                        System.out.println("Word inserted Successfully\n");
                    } else {
                        System.out.println("Word already exist\n");
                    }
                }
                case "2" -> {
                    System.out.print("Enter a word to be deleted: ");
                    String deleted_word = sc.next();
                    if (dictionary.delete(deleted_word)) {
                        System.out.print("Word Successfully deleted\n");
                    } else {
                        System.out.print("Word not found\n");
                    }
                }
                case "3" ->{
                    System.out.print("Enter a word to search for it: ");
                    String searched = sc.next();

                    long startTime = System.nanoTime();
                    boolean result = dictionary.search(searched);
                    long endTime = System.nanoTime();
                    if (result) {
                        System.out.println("the word \"" + searched + "\" is found");
                    }
                    else {
                        System.out.println("the word \"" + searched + "\" is not found");
                        System.out.println("Time taken to search " + searched + " words = " + (endTime - startTime) / 1000 + " ms");
                    }

                }

                case "4" -> {
                    System.out.print("Enter a full path to txt file : ");
                    String path = sc.next();
                    long start = System.currentTimeMillis();
                    int[] counters = dictionary.batchInsert(path);
                    long end = System.currentTimeMillis();

                    System.out.println(counters[0] + " words inserted " + counters[1] + " words already existed ");
                    System.out.println("Time taken to insert " + (counters[0] + counters[1]) + " words = " + (end - start) + " ms");



                }

                case "5" -> {
                    System.out.print("Enter a full path to txt file : ");
                    String path = sc.next();
                    long start = System.currentTimeMillis();
                    int[] counters = dictionary.batchDelete(path);
                    long end = System.currentTimeMillis();
                    System.out.println(counters[0] + " words deleted " + counters[1] + " words not found in dictionary\n");
                    System.out.println("Time taken to delete from  dictionary " + (end - start) + " ms");
                }

                case "6" ->{
                    flag = false;
                }
            }
        }

        System.out.print("Closing Dictionary");
        int i = 10;
        while(i>=0) {
            System.out.print(".");
            i = i - 1;

            TimeUnit.MILLISECONDS.sleep(500);
        }




    }
}