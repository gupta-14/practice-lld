package LLD.DesignPatterns.FactoryPattern;

public class MainClass {
    public static void main(String args[]){
        ShapeFactory shapeFactory = new ShapeFactory();
        Shape shapeObj = shapeFactory.getShape("SQUARE");
        shapeObj.draw();
    }
}
