package Shapes;

public abstract class Shape {
    private Double perimeter;
    private Double area;

    protected abstract double calculatePerimeter();
    protected abstract double calculateArea();

    public void setPerimeter(Double perimeter) {
        this.perimeter = perimeter;
    }

    public void setArea(Double area) {
        this.area = area;
    }

    public Double getPerimeter() {
        return perimeter;
    }

    public Double getArea() {
        return area;
    }
}
