public class Cylinder extends Shape{
    private double radius;
    private double height;
    
    /*Constructor: Set Cylinder */
    public Cylinder(double r, double h){
        super("Cylinder");
        radius = r;
        height = h;
    }

    /*Mengembalikan area dari silinder ini */
    @Override
    public double area(){
        return Math.PI * radius * radius * height;
    }

    /*Mengembalikan informasi tentang silinder */
    @Override
    public String toString(){
        return super.toString() + " of radius " + radius + ", height" + height + ", and with a volume of " + area();
    }
    
}