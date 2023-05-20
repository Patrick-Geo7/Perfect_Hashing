package src;

public interface IHashTable {
    boolean insert(String key);
    boolean delete(String key);

    boolean search(String key);
    int getRebuildCount();
    int getN();

}
