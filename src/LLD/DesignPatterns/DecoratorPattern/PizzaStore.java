package LLD.DesignPatterns.DecoratorPattern;

import LLD.DesignPatterns.DecoratorPattern.Pizza.BasePizza;
import LLD.DesignPatterns.DecoratorPattern.Pizza.ExtraCheese;
import LLD.DesignPatterns.DecoratorPattern.Pizza.Mushroom;
import LLD.DesignPatterns.DecoratorPattern.Pizza.VegPizza;

public class PizzaStore {
    public static void main(String args[]) {
        BasePizza pizza = new Mushroom(new ExtraCheese(new VegPizza()));
        System.out.println(pizza.cost());
    }
}
