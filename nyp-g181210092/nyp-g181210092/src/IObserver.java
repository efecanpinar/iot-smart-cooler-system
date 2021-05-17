
public interface IObserver {
	public void update(int temperature);
	public void registerObserver(IObserver o);
	public void removeObserver(IObserver o);
	public void notifyObserver();
}
