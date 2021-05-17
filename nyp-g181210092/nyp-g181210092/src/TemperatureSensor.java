import java.util.ArrayList;
import java.util.Random;

public class TemperatureSensor implements IObserver{

	public int temperature;
	private ArrayList<IObserver> observers; 
	
	public TemperatureSensor() {
		observers = new ArrayList<IObserver>();
	}
	
	@Override
	public void update(int temperature) {
		this.temperature = temperature;
	}

	@Override
	public void registerObserver(IObserver o) {
		 observers.add(o);
	}

	@Override
	public void removeObserver(IObserver o) {
		int iterator = observers.indexOf(o);
		if(iterator >= 0) {
			observers.remove(iterator);
		}
	}

	@Override
	public void notifyObserver() {
		for(int i = 0; i < observers.size(); i++) {
			 IObserver observer = (IObserver)observers.get(i);
			 observer.update(temperature);
		}
	}
	
	public void temperatureValue() {
		Random random = new Random();
		temperature = random.nextInt(50);
		System.out.println("Current temperature is = " + temperature + "\n");
	}
	
	public void updateTemperature() {
		notifyObserver();
	}
	
	public void setTemperature(int temperature) {
		this.temperature = temperature;
		updateTemperature();
	}
	
	public float getTemperature() {
		return temperature;
	}
}
