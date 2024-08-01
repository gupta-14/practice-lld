package LLD.DesignPatterns.ObserverPattern.Observable;

import LLD.DesignPatterns.ObserverPattern.Observer.NotificationObserver;

import java.util.ArrayList;
import java.util.List;

public class IphoneObservableImpl implements StocksObserverable{

    public List<NotificationObserver> observerList = new ArrayList<>();
    public int stockCount = 0;

    @Override
    public void add(NotificationObserver observer){ observerList.add(observer); }

    @Override
    public void remove(NotificationObserver observer){ observerList.remove(observer); }

    @Override
    public void notifyUsers(){
        for (NotificationObserver observer: observerList){
            observer.update();
        }
    }

    @Override
    public void setStockCount(int newStockAdded){
        if (stockCount == 0) {
            notifyUsers();
        }
        stockCount += newStockAdded;
    }

    @Override
    public int getStockCount(){ return stockCount; }
}
