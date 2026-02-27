
public class Cylinder extends Circle {
    private double height; //Private variable

    // Constructor with default color, radius and height
    public Cylinder(){
        super(); // call superclass no-arg constructor Circle()
        this.height = 1.0;
    }

    // Constructor with default radius, color but given height
    public Cylinder(double height){
        super(); // call superclass no-arg constructor Circle()
        this.height = height;
    }

    // Constructor with default color, but given radius, height
    public Cylinder(double radius, double height) {
        super(radius); // call superclass constructor Circle(radius)
        this.height = height;
    }

    // A public method for retrieving the height
    public double getHeight() {
        return height;
    }

    // A public method for set the height
    public void setHeight(double height) {
        this.height = height;
    }
    
    // A public method for computing the area of cylinder
    @Override
    public double getArea(){
        return 2 * Math.PI * super.getRadius() * (2 * super.getArea());
    }

    // A public method for computing the volume of cylinder
    // use superclass method getArea() to get the base area
    public double getVolume() {
        return super.getArea() * getHeight();
    }

    @Override
    public String toString(){
        return "Circle[radius= " + super.getRadius() + ", color= " + super.getColor() + ", height= " + getHeight() + ", base area= " + getArea() + ", volume= " + getVolume() + "]";
    }
}