package activities;

public class activity1 {
    public static void main(String[] args) {


        car car1 = new car();

        car1.make = 2022;
        car1.color = "Red";
        car1.transmission="Automatic";

        //using car class method
        car1.displayCharacteristics();
        car1.accelerate();
        car1.brake();
    }

}
