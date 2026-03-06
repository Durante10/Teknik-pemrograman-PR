public class Sphere extends Shape
{
    private double radius; //radius in feet
 
    // Constructor: Set bola

    public Sphere(double r)
    {
        super("Sphere");
        radius = r;
    }

    // Mengembalikan informasi area dari bola ini
    @Override
    public double area()
    {
        return 4*Math.PI*radius*radius;
    }
    
    // Mengembalikkan informasi tentang bola
    @Override
    public String toString()
    {
        return super.toString() + " of radius " + radius + " and with an area of " + area();
    }
}