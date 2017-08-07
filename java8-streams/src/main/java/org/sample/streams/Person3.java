package org.sample.streams;

public class Person3 {

    private String name;
    private String country;
    private Integer age;
    private Integer weight;

    public Person3(String name, String country, Integer age, Integer weight) {
        this.name = name;
        this.country = country;
        this.age = age;
        this.weight = weight;
    }

    public String getName() {
        return name;
    }

    public String getCountry() {
        return country;
    }

    public Integer getAge() {
        return age;
    }

    public Integer getWeight() {
        return weight;
    }

    @Override
    public String toString() {
        return "Person3{" + "name=" + name + ", country=" + country + ", age=" + age + ", weight=" + weight + '}';
    }
}
