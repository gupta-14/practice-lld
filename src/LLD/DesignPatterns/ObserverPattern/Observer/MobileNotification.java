package LLD.DesignPatterns.ObserverPattern.Observer;

import LLD.DesignPatterns.ObserverPattern.Observable.StocksObserverable;

public class MobileNotification implements NotificationObserver{

    String emailId;
    StocksObserverable observerable;

    public MobileNotification(String emailId, StocksObserverable observerable){
        this.emailId = emailId;
        this.observerable = observerable;
    }

    @Override
    public void update() {
        sendMsgOnMobile(emailId, "Product back in stock");

    }

    public void sendMsgOnMobile(String emailId, String msg){
        System.out.println("MSG sent to: "+ emailId);
    }
}
