package LLD.DesignPatterns.ObserverPattern;

import LLD.DesignPatterns.ObserverPattern.Observable.IphoneObservableImpl;
import LLD.DesignPatterns.ObserverPattern.Observable.StocksObserverable;
import LLD.DesignPatterns.ObserverPattern.Observer.MobileNotification;
import LLD.DesignPatterns.ObserverPattern.Observer.NotificationObserver;

public class Store {
    public static void main(String args[]){
        StocksObserverable iphoneObservableImpl = new IphoneObservableImpl();

        NotificationObserver observer1 = new MobileNotification("shubham.gupta@gmail.com", iphoneObservableImpl);
        NotificationObserver observer2 = new MobileNotification("shubham@gmail.com", iphoneObservableImpl);
        NotificationObserver observer3 = new MobileNotification("shubh@gmail.com", iphoneObservableImpl);

        iphoneObservableImpl.add(observer1);
        iphoneObservableImpl.add(observer2);
        iphoneObservableImpl.add(observer3);

        iphoneObservableImpl.setStockCount(10);
    }
}
