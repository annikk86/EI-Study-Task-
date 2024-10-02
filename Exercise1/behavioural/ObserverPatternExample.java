// Observer Pattern: Publisher-Subscriber Example
import java.util.ArrayList;
import java.util.List;

// Observer Interface
interface Subscriber {
    void update(String message);
}

// Concrete Observer
class EmailSubscriber implements Subscriber {
    private String name;

    public EmailSubscriber(String name) {
        this.name = name;
    }

    @Override
    public void update(String message) {
        System.out.println(name + " received message: " + message);
    }
}

// Subject Interface
interface Publisher {
    void subscribe(Subscriber subscriber);
    void unsubscribe(Subscriber subscriber);
    void notifySubscribers(String message);
}

// Concrete Subject
class NewsletterPublisher implements Publisher {
    private List<Subscriber> subscribers = new ArrayList<>();

    @Override
    public void subscribe(Subscriber subscriber) {
        subscribers.add(subscriber);
    }

    @Override
    public void unsubscribe(Subscriber subscriber) {
        subscribers.remove(subscriber);
    }

    @Override
    public void notifySubscribers(String message) {
        for (Subscriber subscriber : subscribers) {
            subscriber.update(message);
        }
    }
}

// Main Class
public class ObserverPatternExample {
    public static void main(String[] args) {
        NewsletterPublisher publisher = new NewsletterPublisher();
        
        Subscriber subscriber1 = new EmailSubscriber("Alice");
        Subscriber subscriber2 = new EmailSubscriber("Bob");
        
        publisher.subscribe(subscriber1);
        publisher.subscribe(subscriber2);
        
        publisher.notifySubscribers("New issue released!");

        publisher.unsubscribe(subscriber1);
        publisher.notifySubscribers("Special announcement!");
    }
}
