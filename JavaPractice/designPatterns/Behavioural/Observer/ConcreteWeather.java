import java.util.ArrayList;
import java.util.List;

public class ConcreteWeather implements Weather{

    int temperature;
    int humidity;

    List<Observer> observers = new ArrayList<Observer>();

    @Override
    public void removeObserver(Observer observer) {
        observers.remove(observer);
    }

    @Override
    public void registerObserver(Observer observer) {
        observers.add(observer);

    }

    void setWeather(int temperature, int humidity) {
        this.temperature = temperature;
        this.humidity = humidity;
        System.out.println("set called with "+ temperature + " humidity "+ humidity);
        notifyObservers();
    }


    @Override
    public void notifyObservers() {

        for (Observer observer : observers) {
            observer.update(temperature, humidity);
        }

    }
}
