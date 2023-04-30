import java.util.ArrayList;

class Star {

    //Private members
    private String name;
    private double diameter;
    private int age;
    private double temperature;

    //No-args constructor
    public Star() {
        this.name = "The Sun";
        this.diameter = 1.392;
        this.age = 4600000;
        this.temperature = 6000;
    }

    //Constructor with args
    public Star(String name, double diameter, int age, double temperature) {
        this.name = name;
        this.diameter = diameter;
        this.age = age;
        this.temperature = temperature;
    }

    //Copy constructor
    public Star(Star other) {
        this.name = other.getName();
        this.diameter = other.getDiameter();
        this.age = other.getAge();
        this.temperature = other.getTemp();
    }

    //Getters
    public String getName() {
        return this.name;
    }
    public double getDiameter() {
        return this.diameter;
    }
    public int getAge() {
        return this.age;
    }
    public double getTemp() {
        return this.temperature;
    }

    //Setters
    public void setName(String n) {
        this.name = n;
    }
    public void setDiameter(double n) {
        this.diameter = n;
    }
    public void setAge(int n) {
        this.age = n;
    }
    public void setTemp(double n) {
        this.temperature = n;
    }
}

class Galaxy {

    public ArrayList<Star> stars;

    //Private members
    private String name;
    private int numStars;
    private double diameter;

    //No-args constructor
    public Galaxy() {
        this.stars = new ArrayList<Star>();
        for(int i = 0; i < 5; i++) {
            stars.add(new Star());
        }
        this.name = "Milky Way";
        this.numStars = stars.size();
        this.diameter = 100000.00;
    }

    //Constructor with args
    public Galaxy(ArrayList<Star> stars, String name, double diameter) {
        this.stars = stars;
        this.name = name;
        this.numStars = stars.size();
        this.diameter = diameter;
    }

    //Copy constructor
    public Galaxy(Galaxy g) {
        this.stars = g.stars;
        this.setName(g.getName());
        this.setDiameter(g.getDiameter());
        this.numStars = (g.getNumStars());
    }

    //Getters
    public String getName() {
        return this.name;
    }

    public int getNumStars() {
        return this.numStars;
    }

    public double getDiameter() {
        return this.diameter;
    }

    //Setters
    public void setName(String n) {
        this.name = n;
    }

    public void setDiameter(double d) {
        this.diameter = d;
    }

    public void printInfo() {
        System.out.println("Galaxy {\n\tName:\t\t" + this.getName() + ",\n\tNo. of stars:\t" + this.getNumStars() + ",\n\tDiameter:\t" + this.getDiameter()
        + ",\n\tStars:");
        for (Star star : stars) {
            System.out.println("\t\t{\n\t\t\tName:\t\t" + star.getName() + "\n\t\t\tAge:\t\t" + star.getAge() + "\n\t\t\tDiameter:\t" + star.getDiameter() + "\n\t\t\tTemperature:\t" + star.getTemp());
            System.out.println("\t\t}");
        }
        System.out.println("\t}");
    }
}

public class StarProgram {
    public static void main(String[] args) {
        Galaxy galaxy = new Galaxy();
        galaxy.printInfo();
    }
}
