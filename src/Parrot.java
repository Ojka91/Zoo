public class Parrot extends Animal{

    private boolean canSpeak;
    private Double lengthWings;

    //---constructors---
    public Parrot(){

    }

    public Parrot( boolean canSpeak, Double lengthWings){
        this.canSpeak = canSpeak;
        this.lengthWings = lengthWings;
    }


    //---getters & setters---

    public boolean isCanSpeak() {
        return canSpeak;
    }

    public void setCanSpeak(boolean canSpeak) {
        this.canSpeak = canSpeak;
    }


    public Double getLengthWings() {
        return lengthWings;
    }

    public void setLengthWings(Double lengthWings) {
        this.lengthWings = lengthWings;
    }
}
