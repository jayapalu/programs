public class ConcreteObserver implements Observer {

    int temperature;
    int humidity;

    @Override
    public void update(int temperature, int humidity) {
        this.temperature = temperature;
        this.humidity = humidity;
        display();
    }

    public void display() {
        System.out.println(" ConcreteObserver: Temperature: " + temperature + "\nHumidity: " + humidity);
    }
}

