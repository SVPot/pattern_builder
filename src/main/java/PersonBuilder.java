import java.util.OptionalInt;

public class PersonBuilder {

    private String name;
    private String surname;
    private int age;
    private String address;

    public PersonBuilder setName(String name) {
        this.name = name;
        return this;
    }

    public PersonBuilder setSurname(String surname) {
        this.surname = surname;
        return this;
    }

    public PersonBuilder setAge(int age) throws IllegalArgumentException {
        if (age < 0) {
            throw new IllegalArgumentException("Please provide person age!");
        }
        this.age = age;
        return this;
    }

    public PersonBuilder setAddress(String address) {
        this.address = address;
        return this;
    }

    public Person build() throws IllegalStateException, IllegalArgumentException {
        if (this.name == null || this.name.isEmpty()) {
            throw new IllegalStateException("Please provide person name!");
        }
        if (surname == null || surname.isEmpty()) {
            throw new IllegalStateException("Please provide person surname!");
        }
        if (address != null) {
            return (age > 0) ?
                    new Person(name, surname, age, address) :
                    new Person(name, surname, address);
        }
        return (age > 0) ?
                new Person(name, surname, age) :
                new Person(name, surname);
    }
}