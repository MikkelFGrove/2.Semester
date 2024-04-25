/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vop;

/**
 *
 * @author erso
 */
public class ShapeFacade {

    //Singleton Stufff:
    private static ShapeFacade instance = null;

    public static ShapeFacade getInstance() {
        if (instance == null) {
            instance = new ShapeFacade();
        }
        return instance;
    }

    private ShapeFacade() {
    }
    //---------------------------

    // enum som kendes af GUI'en
    public enum SHAPES {
        CIRCLE, ELLIPSE, RECTANGLE, SQUARE
    };

    // Facadens public metoder
    public String getShapeInfo(SHAPES shape, double x, double y) {
        ShapeInterface aShape;
        switch (shape){
            case CIRCLE:
                aShape = new Circle(x);
                return aShape.toString();
            case ELLIPSE:
                aShape = new Ellipse(x, y);
                return aShape.toString();
            case SQUARE:
                aShape = new Square(x);
                return aShape.toString();
            case RECTANGLE:
                aShape = new Rectangle(x, y);
                return aShape.toString();
        }

        throw new UnsupportedOperationException("Not supported yet.");
    }

}
