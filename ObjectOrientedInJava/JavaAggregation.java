package ObjectOrientedInJava;

public class JavaAggregation {
    public static void main(String[] args) {
        mycar c = new mycar();
        driver d = new driver(c);
    }
}
class mycar {
    public void drive(){
        System.out.println("I am Driving");
    }
    protected void drop(){
        System.out.println("Dropped");
    }  
}

class driver{
    mycar obj;
    driver(mycar obj){
        this.obj=obj;
    }
    void print(){
        obj.drive();
        obj.drop();
    }
}
// The concept of the java Aggregation of the video number 86
// Imp -- Interview Question
// Association---> 1)Aggregation 2)Composition 