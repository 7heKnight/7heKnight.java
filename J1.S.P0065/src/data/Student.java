package data;

public class Student{
    private String name;
    private char type;
    private String classes;
    private double mathM;
    private double chemistryM;
    private double physicalM;
    private double avg;

    public Student(String name, String classes, double mathM, double chemistryM, double physicalM) {
        this.name = name;
        this.classes = classes;
        this.mathM = mathM;
        this.chemistryM = chemistryM;
        this.physicalM = physicalM;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    
    public String getClasses() {
        return classes;
    }

    public void setClasses(String classes) {
        this.classes = classes;
    }

    public double getMathM() {
        return mathM;
    }

    public void setMathM(double mathM) {
        this.mathM = mathM;
    }

    public double getChemistryM() {
        return chemistryM;
    }

    public void setChemistryM(double chemistryM) {
        this.chemistryM = chemistryM;
    }

    public double getPhysicalM() {
        return physicalM;
    }

    public void setPhysicalM(double physicalM) {
        this.physicalM = physicalM;
    }

    public char getType() {
        return type;
    }

    public void setType(char type) {
        this.type = type;
    }

    public double getAvg() {
        return avg;
    }

    public void setAvg(double avg) {
        this.avg = avg;
    }

    @Override
    public String toString() {
        return "Name: " + name + "\nClasses: " + classes + "\nAVG: " + avg + "\nType: " + type;
    }
    
}
