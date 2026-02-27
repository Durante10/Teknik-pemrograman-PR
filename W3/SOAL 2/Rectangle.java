public class Rectangle extends Shape{
    private double width;
    private double length;

    public Rectangle(){
        width = 1.5;
        length = 2.5;
    }

    public Rectangle(double width, double length){
        this.width = width;
        this.length = length;
    }

    public Rectangle(double width, double length, String color, boolean filled){
        super(color, filled);
        this.width = width;
        this.length = length;
    }

    //Getter 
    public double getWidth(){
        return width;
    }

    public double getLength(){
        return length;
    }

    //Setter 
    public void setWidth(double width){
        this.width = width;
    }

    public void setLength(double length){
        this.length = length;
    }

    public double getArea(){
        return getLength() * getWidth();
    }

    public double getPerimeter(){
        return 2 * (getLength() + getWidth());
    }

    @Override
    public String toString(){
        return "A Rectangle with width= " + getWidth() + " and length= " + getLength() + ", base area= " + getArea() + ", perimeter= " + getPerimeter() +", which a subclass of " + super.toString();
    }
}