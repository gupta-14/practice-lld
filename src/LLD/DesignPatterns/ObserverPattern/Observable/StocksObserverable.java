package LLD.DesignPatterns.ObserverPattern.Observable;

import LLD.DesignPatterns.ObserverPattern.Observer.NotificationObserver;

public interface StocksObserverable {
    
    public void add(NotificationObserver observer);
    
    public void remove(NotificationObserver observer);
    
    public void notifyUsers();
    
    public void setStockCount(int newStockAdded);
    
    public int getStockCount();
}
