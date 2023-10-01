package sesson7.thuc_hanh.animal_interface_edible;
import sesson7.thuc_hanh.animal_interface_edible.animal.Animal;
import sesson7.thuc_hanh.animal_interface_edible.animal.Tiger;
import sesson7.thuc_hanh.animal_interface_edible.animal.Chicken;
import sesson7.thuc_hanh.animal_interface_edible.fruit.Fruit;
import sesson7.thuc_hanh.animal_interface_edible.fruit.Apple;
import sesson7.thuc_hanh.animal_interface_edible.fruit.Orange;

public class AnimalAndInterfaceEdibleTest {
    public static void main(String[] args) {
        Animal[] animals = new Animal[2];
        animals[0] = new Tiger();
        animals[1] = new Chicken();
        for (Animal animal : animals) {
            System.out.println(animal.makeSound());
        }
        Chicken chicken = (Chicken) animals[1];
        System.out.println(chicken.howToEat());
        Fruit[] fruits = new Fruit[2];
        fruits[0] = new Orange();
        fruits[1] = new Apple();
        for (Fruit fruit : fruits) {
            System.out.println(fruit.howToEat());
        }
    }
}
