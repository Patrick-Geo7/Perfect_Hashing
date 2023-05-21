package src;

public interface IHashTable {
    boolean insert(String key);
    boolean delete(String key);
    public String[] getHashmap();
    boolean search(String key);
    int getRebuildCount();
    int getN();
    void printt();

}
