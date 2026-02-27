public class Circle extends Shape{
    private double radius;
    
    public Circle(){
        radius = 1.0;
    }

    public Circle (double radius){
        this.radius = radius;
    }

    public Circle(double radius, String color,boolean filled){
        super(color,filled);
        this.radius=radius;
    }

    //Get
    public double getRadius(){
        return radius;
    }

    //Set
    public void setRadius(double radius){
        this.radius=radius;
    }

    public double getArea(){
        return radius * radius * Math.PI;
    }

    public double getPerimeter(){
        return radius * 2 * Math.PI;
    }

    @Override
    public String toString(){
        return "A Circle with radius= " + getRadius() + ", base area= " + getArea() + ", perimeter= " + getPerimeter() + ", which is a subclass of " + super.toString();
    }

}