package lists;
public interface List {
	public void insertStart(Object info);

	public void insertEnd(Object info);

	public boolean isEmpty();

	public boolean remove(Object info);

	public int size();
	
	public void printStartToEnd();
	
	public void printEndToStart();
}