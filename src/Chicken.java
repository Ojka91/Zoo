public class Chicken extends Animal {

    private Double lengthWings;
    private boolean isBroiler;


    //---constructors---

    public Chicken(){

    }

    public Chicken(Double lengthWings, boolean isBroiler){
        this.lengthWings = lengthWings;
        this.isBroiler = isBroiler;
    }

    //---setters && getters---

    public Double getLengthWings() {
        return lengthWings;
    }

    public void setLengthWings(Double lengthWings) {
        this.lengthWings = lengthWings;
    }

    public boolean isBroiler() {
        return isBroiler;
    }

    public void setBroiler(boolean broiler) {
        isBroiler = broiler;
    }

    @Override
    public String toString() {
        return "Chicken " + getName() + " / is boriler? "+ isBroiler() + " / lengh wings " + getLengthWings()+ " / likes "
                + getFavoriteFood() + " / has the next friends: " + getFriendName();
    }
}
