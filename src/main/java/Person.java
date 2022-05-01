import java.util.Objects;
import java.util.OptionalInt;

public class Person {

    protected final String name;
    protected final String surname;
    protected int age;
    protected String address;

    public Person(String name, String surname) {
        this.name = name;
        this.surname = surname;
    }

    public Person(String name, String surname, int age) {
        this.name = name;
        this.surname = surname;
        this.age = age;
    }

    public Person(String name, String surname, String address) {
        this.name = name;
        this.surname = surname;
        this.address = address;
    }

    public Person(String name, String surname, int age, String address) {
        this.name = name;
        this.surname = surname;
        this.age = age;
        this.address = address;
    }

    public boolean hasAge() {
        return getAge().isPresent();
    }

    public boolean hasAddress() {
        return this.address != null;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public OptionalInt getAge() {
        return OptionalInt.of(age);
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void happyBirthday() {
        if (hasAge()) this.age++;
    }


    public PersonBuilder newChildBuilder() {
        PersonBuilder personBuilder = new PersonBuilder();
        personBuilder
                .setSurname(this.surname)
                .setAddress(this.address);
        return personBuilder;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Person person = (Person) o;

        return ((age == person.age) &&
                name.equals(person.name) &&
                surname.equals(person.surname) &&
                address.equals(person.address));
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, surname, age, address);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(" Name: ");
        sb.append(name);
        sb.append("\n Surname: ");
        sb.append(surname);
        if (this.age != 0) {
            sb.append("\n Age: ");
            sb.append(age);
        }
        if (this.address != null) {
            sb.append("\n Address: ");
            sb.append(address);
        }
        sb.append("\n");
        return sb.toString();
    }
//        return "Person{" +
//                "name='" + name + '\'' +
//                ", surname='" + surname + '\'' +
//                ", age=" + age +
//                ", address='" + address + '\'' +
//                '}';
//    }
    }

