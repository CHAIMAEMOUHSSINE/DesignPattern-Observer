package net.chaimae.obs;

public class ObserverImpl1 implements Observer{
    @Override
    public void update(int newState) {
        System.out.println("ObserverImpl1: " + newState);
    }
}
