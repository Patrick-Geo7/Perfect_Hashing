public class Dictionnary implements IDictionnary{
    /**
     * @param word 
     * @return
     */
    @Override
    public boolean insert(String word) {
        return false;
    }

    /**
     * @param word 
     * @return
     */
    @Override
    public boolean delete(String word) {
        return false;
    }

    /**
     * @param word 
     * @return
     */
    @Override
    public boolean search(String word) {
        return false;
    }

    /**
     * @param path 
     * @return
     */
    @Override
    public int[] batchinsert(String path) {
        return new int[0];
    }

    /**
     * @param path 
     * @return
     */
    @Override
    public int[] batchdelete(String path) {
        return new int[0];
    }
}
