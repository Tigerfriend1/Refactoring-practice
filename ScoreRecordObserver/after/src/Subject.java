import java.util.ArrayList;
import java.util.List;

public abstract class Subject {
	private List<Observer> observers=new ArrayList<>();
	
	public void attach(Observer observer) {observers.add(observer);}
	public void detach(Observer observer) {observers.remove(observer);}
	
	protected void notify_() {
		for (Observer observer : observers) observer.update();
	}
}
