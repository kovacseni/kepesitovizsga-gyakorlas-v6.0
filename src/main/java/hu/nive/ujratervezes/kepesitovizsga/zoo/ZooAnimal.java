package hu.nive.ujratervezes.kepesitovizsga.zoo;

import java.util.Objects;

public abstract class ZooAnimal {

    protected String name;
    protected int length;
    protected long weight;
    protected AnimalType type;

    protected ZooAnimal(String name) {
        this.name = name;
    }

    protected ZooAnimal(String name, int length) {
        this(name);
        this.length = length;
    }

    protected ZooAnimal(String name, int length, long weight) {
        this(name, length);
        this.weight = weight;
    }

    public String getName() {
        return name;
    }

    public AnimalType getType() {
        return type;
    }

    public int getLength() {
        return length;
    }

    public long getWeight() {
        return weight;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ZooAnimal zooAnimal = (ZooAnimal) o;
        return Objects.equals(name, zooAnimal.name) && type == zooAnimal.type;
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, type);
    }
}
