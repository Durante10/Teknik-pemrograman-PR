public class Square extends Rectangle{
    
    public Square (){
        super(1.0,1.0);
    }

    public Square (double side){
        super(side,side);
    }
    //Get
    public double getSide(){
        return getWidth();
    }

    //Set
    public void setSide(double side){
        super.setWidth(side);
        super.setLength(side);
    }

    @Override
    public void setWidth(double side){
        setSide(side);
        
    }

    @Override
    public void setLength(double side){
        setSide(side);
    }

    @Override
    public String toString(){
        return "A Square with side= " + getSide() +", base area= " + super.getArea() +", which is a subclass " + super.toString();
    }


}