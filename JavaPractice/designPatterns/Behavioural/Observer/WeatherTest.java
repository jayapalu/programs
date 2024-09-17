public class WeatherTest {

    public static void main(String[] args) {

        ConcreteWeather concreteWeather = new ConcreteWeather();
        ConcreteObserver concreteObserver = new ConcreteObserver();

        concreteWeather.registerObserver(concreteObserver);

        concreteWeather.setWeather(10,20);
        concreteWeather.setWeather(30,40);
    }
}
