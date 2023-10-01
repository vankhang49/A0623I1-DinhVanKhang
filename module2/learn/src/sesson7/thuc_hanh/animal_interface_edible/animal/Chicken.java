package sesson7.thuc_hanh.animal_interface_edible.animal;

import sesson7.thuc_hanh.animal_interface_edible.edible.Edible;

public class Chicken extends Animal implements Edible {
    @Override
    public String makeSound() {
        return "Chicken: cuc-cuc!";
    }

    @Override
    public String howToEat() {
        return "Chicken could be fried";
    }
}
