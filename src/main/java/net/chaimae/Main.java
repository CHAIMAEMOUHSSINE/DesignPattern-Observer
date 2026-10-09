package net.chaimae;


import net.chaimae.obs.*;

import java.awt.*;

public class Main {
    public static void main(String[] args) {
        ObservableImpl observable = new ObservableImpl();
        Observer o1 = new ObserverImpl1();
        Observer o2 = new ObserverImpl2();
        observable.subscribe(o1);
        observable.subscribe(o2);
        observable.subscribe(new Observer(){
            @Override
            public void update(Observable o) {
                if ( o instanceof ObservableImpl ) {
                    System.out.println("-------------OBS IMPL3-----------------");
                    System.out.println("Res: " + ((ObservableImpl) o).getState() * ((ObservableImpl) o).getState() * Math.cos(((ObservableImpl) o).getState()));
                    System.out.println("-------------OBS IMPL3-----------------");
                }
            };


                });

        //la fct lambda
        observable.subscribe(   obs -> {
            if ( obs instanceof ObservableImpl ) {
                System.out.println("-------------OBS IMPL4-----------------");
                System.out.println("Res: " + ((ObservableImpl) obs).getState() * ((ObservableImpl) obs).getState() * Math.cos(((ObservableImpl) obs).getState()));
                System.out.println("-------------OBS IMPL4-----------------");
            }
                }
        );


        observable.setState(60);
        observable.setState(80);
        observable.unsubscribe(o1);
        observable.setState(100);


        Button button =new Button("ok");
        button.addActionListener(e -> {
            System.out.println(e.getSource());

        });


    }}