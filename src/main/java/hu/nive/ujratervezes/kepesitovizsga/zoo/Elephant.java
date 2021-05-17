package hu.nive.ujratervezes.kepesitovizsga.zoo;

public class Elephant extends ZooAnimal {

    public Elephant(String name, int length, long weight) {
        super(name, length, weight);
        this.type = AnimalType.ELEPHANT;
    }
}
