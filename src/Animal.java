import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

public class Animal {

    //---common variables---
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


    //return list of Strings
    public List<String> getFriendName(){
        return friend.stream()
                .map(friend->friend.getName())
                .collect(Collectors.toList());
    }

    //---methods---
    public void loosesFriend(Animal animal){
        //only can lose a friend if already have at least one
            if(animal.getFriend().size()!=0){
                Random rand = new Random();
                Integer prob = rand.nextInt(animal.getFriend().size()); //generate random value as big as list of friend size
                Animal friend = animal.getFriend().get(prob);
                System.out.println(animal.getName() + " has lost friendship w/ "+animal.getFriend().get(prob).getName());
                friend.getFriend().remove(animal);//both animals lose the friendship :(
                animal.getFriend().remove(friend);//friendship comes from both ways at the same time :/
        }
            else{
                //that's the good part of not having friends... you can't lose them :)
               System.out.println(animal.getName()+ " was going to lose a friend but... can't lose a friend because still don't have a friend :(");
            }
    }

    public void gainFriend(List<Animal> animals, Animal animal){
        Random rand = new Random();

        //generate new List with all animals BUT oneself
        List<Animal> newAnimals = new ArrayList<>();
        for (Animal eachanimal:animals){
            newAnimals.add(eachanimal);
        }
        newAnimals.remove(animal); //removing here myself

        Integer prob = rand.nextInt(newAnimals.size()); //generate random value from new array size

        if(!animal.getFriend().containsAll(newAnimals)){ //if you are friend with everybody you can't make new friend
                while(animal.getFriend().contains(newAnimals.get(prob))){ //in case random value point to already friend animal
                    prob = rand.nextInt(newAnimals.size());
                }

                animal.setFriend(newAnimals.get(prob)); //both animals become friends now
                newAnimals.get(prob).setFriend(animal);
                System.out.println("Wow! "+animal.getName()+" now is friend w/ "+newAnimals.get(prob).getName());

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
