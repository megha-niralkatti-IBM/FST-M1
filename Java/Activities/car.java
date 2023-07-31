package activities;

public class car {
    String color, transmission; //class member variables
    int make,tyres,doors;

    //constructor
    car( ){
        tyres = 4;
        doors = 4;
    }

    //class Methods
    public void displayCharacteristics(){
        System.out.println("colour of the car: "+color);
        System.out.println("Make of the car: " +make);
        System.out.println("Transmission of the car:"+transmission);
        System.out.println("Number od doors on the car" +doors);
        System.out.println("No of tyres on the car: "+tyres);

    }
    public void accelerate(){
        System.out.println("car is moving forward");
    }

    public void brake(){
        System.out.println("Car has stopped");
    }

}
