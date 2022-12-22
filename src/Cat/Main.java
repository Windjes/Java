package Cat;

import Cat.Cat;

public class Main {
    public static void main(String[] args) {
        Cat bigCat = new Cat(5500, "Murka", 2, "Black");
        Cat smallCat = new Cat(1000, "Kuzya", 1, "White");
        bigCat.setName("Pushok");
        bigCat.setAge(15);
        System.out.println("The name of big cat is " + bigCat.getName());
        System.out.println("The name of small cat is " + smallCat.getName());
        System.out.println("Age " + bigCat.getAge());
    }

}