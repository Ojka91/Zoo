public class Dog extends Animal {


    private String type;


    //---constructors---

    public  Dog (){}

    public Dog (String type){
        this.type = type;
    }

    //---setters && getters

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }


    @Override
    public String toString() {
        return "Dog{" +
                "type='" + type + '\'' +
                '}';
    }
}
