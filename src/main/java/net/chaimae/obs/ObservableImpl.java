package net.chaimae.obs;

import java.util.ArrayList;
import java.util.List;

public class ObservableImpl implements Observable {
    private int state;
    private List<Observer> observers;

    public ObservableImpl() {
        this.observers = new ArrayList<>();
    }

    @Override
    public void subscribe(Observer o) {
        observers.add(o);
    }

    @Override
    public void unsubscribe(Observer o) {
        observers.remove(o);
    }

    @Override
    public void notifyObservers() {
        for (Observer o : observers) {
            o.update(this);
        }
    }

    public void setState(int newState) {
        this.state = newState;
        notifyObservers();
    }

    public double getState() {
        return (double) state;
    }
}
