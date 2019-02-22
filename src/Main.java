import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        //---object creation----

        List<Animal> animals = new ArrayList<>(); //A list with all animals

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
        Integer probOverDay = 0;



       while(menu <= 3){
           if(menu == 1){
               for (Animal animal:animals) {
                   System.out.println(animal.toString());


               }
           }
           if(menu==2){
               if(probOverDay<30){
                   probOverDay+=5;

               }
               dayOver(animals,probOverDay);
           }
           if(menu == 3){
               System.out.println("bye");
               break;
           }

           System.out.println("Welcome another day to the zoo, what would you like to do?");
           System.out.println("1: Check the animals\n2: Live one day\n3: Exit");
           menu = sc.nextInt();

       }



    }


    public static void dayOver(List<Animal> animals, Integer prob){
        System.out.println("Probability in crescendo = " + prob);


        Random rand = new Random();
        for (Animal animal:animals) {
            Integer probability = rand.nextInt(100);

            if(probability<(59-prob)){ //60% of probability to lose a friend et the beginning
               // System.out.println(animal.getName() + " " + animal.getFriend());
                animal.loosesFriend(animal);
            }
            if(probability >(59-prob) && probability < 79){ //20% prob to make a new friend at the beginning
                animal.gainFriend(animals, animal);
            }
        }


    }

}
