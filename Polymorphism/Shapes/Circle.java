package Shapes;

public class Circle extends Shape{

    private Double radius;

    public Circle(Double radius) {
        this.radius = radius;
        super.setArea(calculateArea());
        super.setPerimeter(calculatePerimeter());
    }

    @Override
    protected double calculatePerimeter() {
        return 2 * Math.PI * radius;
    }

    @Override
    protected double calculateArea() {
        return Math.PI * (radius * 2);
    }

    public final Double getRadius() {
        return radius;
    }
}
