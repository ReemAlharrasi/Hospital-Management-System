package interfaces;

public interface Manageable {
    void add(Object item);
    boolean removeById(String id);
    Object[] getAll();
}
