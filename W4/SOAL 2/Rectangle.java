public class Rectangle extends Shape{
    private double length;
    private double width;

    /*Constructor: Set Persegi panjang */

    public Rectangle(double L,double W){
        super("Rectangle");
        length = L;
        width = W;
    }

    /*Mengembalikkan area persegi panjang */
    @Override
    public double area(){
        return length * width;
    }

    /*Mengembalikan informasi tentang persegi panjang */
    @Override
    public String toString(){
        return super.toString() + " of length " + length + " ,width " + width + " ,and an area of "+ area();
    }


}