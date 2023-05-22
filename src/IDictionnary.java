package src;

public interface IDictionnary {
    boolean insert(String word);
    boolean delete(String word);
    boolean search(String word);
    int[] batchInsert(String path);
    int[] batchDelete(String path);
    int getTableSize();
    int collisions();
}
