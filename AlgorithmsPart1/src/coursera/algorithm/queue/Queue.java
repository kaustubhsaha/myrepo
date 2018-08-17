package coursera.algorithm.queue;

public interface Queue<V> {

	public void enqueue(V val);
	
	public V dequeue();
}
