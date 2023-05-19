public interface IDictionnary {
    boolean insert(String word);
    boolean delete(String word);
    boolean search(String word);
    int[] batchinsert(String path);
    int[] batchdelete(String path);
}
