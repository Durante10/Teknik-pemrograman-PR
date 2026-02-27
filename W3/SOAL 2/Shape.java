public class Shape{
    private String color;
    private boolean filled;
    
    public Shape(){
        color = "red";
        filled = true;
    }

    public Shape(String Color,boolean Filled){
        this.color = Color;
        this.filled = Filled;
    }

    //Getter
    public String getColor(){
        return color;
    }

    public boolean isfilled(){
        return filled;
    }

    //Setter
    public void setColor(String color){
        this.color=color;
    }

    public void setfilled(Boolean filled){
        this.filled=filled;
    }

    public String toString(){
        if (isfilled() == true) {
            return "Shape [ color= " + getColor() + ", Filled" + "]" + "\n";
        } else {
            return "Shape [ color= " + getColor() + ", Not Filled" + "]" +"\n";
        }
        
    }

}