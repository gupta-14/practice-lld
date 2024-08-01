package LLD.DesignPatterns.FactoryPattern;

public class ShapeFactory {
    Shape getShape(String input){
        switch (input){
            case "RECTANGLE":
                return new Rectangle();
            case "SQUARE":
                return new Square();
            default:
                return null;
        }
    }
}
