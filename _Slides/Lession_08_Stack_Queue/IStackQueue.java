

/**
 * IStackQueue
 */
public interface IStackQueue {
    public boolean push(int value);
    public int pop();
    public boolean isFull();
    public boolean isEmpty();
    public void show();
}