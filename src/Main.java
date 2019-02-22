import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {


        List<Animal> animals = new ArrayList<>(); //A list we will fill with all animals

        //creation objects, all extends and polymorph from Animal class
        Animal dogKillian = new Dog();
        dogKillian.setName("Killian");
        ((Dog) dogKillian).setType("Hunting Dog");
        dogKillian.setFavoriteFood("Meat");
        animals.add(dogKillian);

        Animal parrotOne = new Parrot();
        ((Parrot) parrotOne).setCanSpeak(false);
        parrotOne.setName("Parrot One");
        parrotOne.setFavoriteFood("Grain");
        ((Parrot) parrotOne).setLengthWings(0.25);
        animals.add(parrotOne);

        Animal chickenOne = new Chicken();
        chickenOne.setName("Chicken One");
        ((Chicken) chickenOne).setBroiler(true);
        chickenOne.setFavoriteFood("Corn");
        ((Chicken) chickenOne).setLengthWings(0.75);
        animals.add(chickenOne);

        Animal dogRocky = new Dog();
        dogRocky.setName("Rocky");
        ((Dog) dogRocky).setType("Working Dog");
        dogRocky.setFavoriteFood("Fresh meat");
        animals.add(dogRocky);

        Animal parrotTwo = new Parrot();
        ((Parrot) parrotTwo).setCanSpeak(true);
        parrotTwo.setName("Parrot Two");
        parrotTwo.setFavoriteFood("Corn");
        ((Parrot) parrotTwo).setLengthWings(0.5);
        animals.add(parrotTwo);

        Animal dogPeter = new Dog();
        dogPeter.setName("Peter");
        ((Dog) dogPeter).setType("Sport Dog");
        dogPeter.setFavoriteFood("Pedigree");
        animals.add(dogPeter);

        Animal chickenTwo = new Chicken();
        chickenTwo.setName("Rocky");
        ((Chicken) chickenTwo).setBroiler(false);
        chickenTwo.setFavoriteFood("Corn");
        ((Chicken) chickenTwo).setLengthWings(0.75);
        animals.add(chickenTwo);



        //---init---
        System.out.println("Welcome to the zoo, what would you like to do?");
        System.out.println("1: Check the animals\n2: Live one day\n3: Exit");
        Scanner sc = new Scanner(System.in);
        int menu = sc.nextInt();
        Integer probOverDay = 0;   //this variable will change overtime, changing % to make and lose friends



       while(menu <= 3){ //if enter whatever different kicks you out of the program
           if(menu == 1){
               //loop through array of animals and print toString method
               for (Animal animal:animals) {
                   System.out.println(animal.toString()); //
               }
           }
           if(menu==2){
               if(probOverDay<30){ //change variable every day
                   probOverDay+=5;
               }
               //call method dayOver
               dayOver(animals,probOverDay);
           }
           if(menu == 3){ //exit
               System.out.println("bye");
               break;
           }
            //printing shown each round while playing
           System.out.println("\nWelcome another day to the zoo, what would you like to do?");
           System.out.println("1: Check the animals\n2: Live one day\n3: Exit");
           menu = sc.nextInt();
       }
    }


    //receive list of animals and Integer that change overtime
    public static void dayOver(List<Animal> animals, Integer prob){
        Random rand = new Random();

        //each animal, has a probability to make or lose a friend
        for (Animal animal:animals) {
            Integer probability = rand.nextInt(100);

            if(probability<(59-prob)){ //60% of probability to lose a friend at the beginning
                animal.loosesFriend(animal);
            }
            if(probability >(59-prob) && probability < 79){ //20% prob to make a new friend at the beginning
                animal.gainFriend(animals, animal);
            }
        }
    }

}
