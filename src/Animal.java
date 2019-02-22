import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Animal {

    private List<Animal> friend = new ArrayList<>();
    private String name;
    private String favoriteFood;

//--constructors--
    public Animal (){

    }

    public Animal(String name, String favoriteFood){
        this.name = name;
        this.favoriteFood = favoriteFood;
        this.friend=null;
    }

    public Animal(String name, String favoriteFood, ArrayList<Animal> friend){
        this.name = name;
        this.favoriteFood = favoriteFood;
        this.friend = friend;
    }


    //---getters && setters---

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getFavoriteFood() {
        return favoriteFood;
    }

    public void setFavoriteFood(String favoriteFood) {
        this.favoriteFood = favoriteFood;
    }

    public List<Animal> getFriend() {
        return friend;
    }

    public void setFriend(Animal friend) {
        this.friend.add(friend);
    }

    //---methods---


    public void loosesFriend(Animal animal){
       // System.out.println(animal.getFriend()==null);
            if(animal.getFriend().size()!=0){
                Random rand = new Random();
                Integer prob = rand.nextInt(animal.getFriend().size());
                Animal friend = animal.getFriend().get(prob);
             System.out.println(animal.getName() + " has lost friendship w/ "+animal.getFriend().get(prob).getName());
                friend.getFriend().remove(animal);
                animal.getFriend().remove(prob);
        }
            else{
               System.out.println(animal.getName()+ " was going to lose a friend but... can't lose a friend because still don't have a friend :(");
            }
    }

    public void gainFriend(List<Animal> animals, Animal animal){
        Random rand = new Random();

        List<Animal> newAnimals = new ArrayList<>();
        for (Animal eachanimal:animals){
            newAnimals.add(eachanimal);
        }
        newAnimals.remove(animal);
        Integer prob = rand.nextInt(newAnimals.size());

        if(!animal.getFriend().containsAll(newAnimals)){
            if (newAnimals.get(prob).getName() == animal.getName()  || animal.getFriend().contains(newAnimals.get(prob))){
                while(newAnimals.get(prob).getName() == animal.getName() || animal.getFriend().contains(newAnimals.get(prob))){
                    prob = rand.nextInt(newAnimals.size());
                }
            }
            else{
                animal.setFriend(newAnimals.get(prob));
                newAnimals.get(prob).setFriend(animal);
                System.out.println("Wow! "+animal.getName()+" now is friend w "+newAnimals.get(prob).getName());
            }

        }
        else{
            System.out.println(animal.getName() + " is friend with everone!!!");
        }


    }


    @Override
    public String toString() {
        return "Animal{" +
               "friend=" + friend +
                ", name='" + name + '\'' +
                ", favoriteFood='" + favoriteFood + '\'' +
                '}';
    }
}
