abstract public class Shape {
    protected String shapeName;

    public Shape(String ShapeName){
        shapeName=ShapeName;
    }

    public String toString(){
        String result = "Nama bangun" + shapeName + "\n";
        return result;
    }

    public abstract double area();
    
}