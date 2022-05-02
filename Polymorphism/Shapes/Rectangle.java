package Shapes;

public class Rectangle extends Shape{

    private Double height;
    private Double width;

    public Rectangle(Double height, Double width) {
        this.height = height;
        this.width = width;
        super.setPerimeter(calculatePerimeter());
        super.setArea(calculateArea());
    }

    @Override
    protected double calculatePerimeter() {
        return  2 * height + 2 * width;
    }

    @Override
    protected double calculateArea() {
        return height * width;
    }

    public Double getHeight() {
        return height;
    }

    public Double getWidth() {
        return width;
    }
}
