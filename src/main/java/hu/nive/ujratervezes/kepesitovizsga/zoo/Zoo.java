package hu.nive.ujratervezes.kepesitovizsga.zoo;

import javax.sql.DataSource;
import java.sql.*;
import java.util.*;

public class Zoo {

    private Set<ZooAnimal> animals = new HashSet<>();
    private DataSource dataSource;

    public Zoo(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    public Set<ZooAnimal> getAnimals() {
        return new HashSet<>(animals);
    }

    public void loadAnimals() {
        try (Connection conn = dataSource.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery("select * from animals;")) {

            while (rs.next()) {
                getAnimal(rs);
            }
        } catch (SQLException sqle) {
            throw new IllegalStateException("Can not get data.", sqle);
        }
    }

    private void getAnimal(ResultSet rs) throws SQLException {
        if (rs.getString("animal_type").equals("LION")) {
            animals.add(new Lion(rs.getString("animal_name")));
        } else if (rs.getString("animal_type").equals("GIRAFFE")) {
            animals.add(new Giraffe(rs.getString("animal_name"), rs.getInt("length_of_member")));
        } else if ((rs.getString("animal_type").equals("ELEPHANT"))) {
            animals.add(new Elephant(rs.getString("animal_name"), rs.getInt("length_of_member"), rs.getLong("weight")));
        } else {
            throw new IllegalArgumentException("There is no such animal type in this Zoo!");
        }
    }

    public void addAnimal(ZooAnimal animal) {
        try (Connection conn = dataSource.getConnection();
             PreparedStatement stmt = conn.prepareStatement("insert into animals(animal_name, length_of_member, weight, animal_type) values (?, ?, ?, ?);")) {
            stmt.setString(1, animal.getName());
            stmt.setInt(2, animal.getLength());
            stmt.setLong(3, animal.getWeight());
            stmt.setString(4, animal.getType().toString());
            stmt.executeUpdate();
        } catch (SQLException sqle) {
            throw new IllegalStateException("Can not insert data.", sqle);
        }
    }

    public ZooAnimal getHeaviestAnimalInTheZoo() {
        long max = 0;
        ZooAnimal animal = null;
        for (ZooAnimal z : animals) {
            if (z.getWeight() > max) {
                max = z.getWeight();
                animal = z;
            }
        }
        return animal;
    }

    public long countWeights() {
        long count = 0L;
        for (ZooAnimal z : animals) {
            count += z.getWeight();
        }
        return count;
    }

    public ZooAnimal findExactAnimal(ZooAnimal animal) {
        for (ZooAnimal z : animals) {
            if (z.equals(animal)) {
                return z;
            }
        }
        throw new IllegalArgumentException("There is no such animal in the zoo!");
    }

    public ZooAnimal findExactAnimalByName(String name) {
        for (ZooAnimal z : animals) {
            if (z.getName().equals(name)) {
                return z;
            }
        }
        throw new IllegalArgumentException("There is no such animal in the zoo!");
    }

    public int getNumberOfAnimals() {
        return animals.size();
    }

    public List<ZooAnimal> getAnimalsOrderedByName() {
        List<ZooAnimal> zooAnimals = new ArrayList<>();
        zooAnimals.addAll(animals);
        zooAnimals.sort(Comparator.comparing(ZooAnimal::getName));
        return zooAnimals;
    }

    public Map<AnimalType, Integer> getAnimalStatistics() {
        Map<AnimalType, Integer> statistics = new HashMap<>();
        for (ZooAnimal z : animals) {
            if (!statistics.containsKey(z.getType())) {
                statistics.put(z.getType(), 1);
            } else {
                statistics.put(z.getType(), statistics.get(z.getType()) + 1);
            }
        }
        return statistics;
    }
}
