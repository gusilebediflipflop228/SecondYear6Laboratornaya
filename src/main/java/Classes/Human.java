package Classes;

import java.util.Objects;

public class Human {
    private String lastName, firstName, patronymic;
    private int age;


    public Human(String lastName, String firstName, String patronymic, int age) {
        this.lastName = lastName;
        this.firstName = firstName;
        this.patronymic = patronymic;
        this.age = age;
    }

    public Human(String lastName, String firstName, String patronymic, int age, String fullName) { // конструктор
        this.lastName = lastName;
        this.firstName = firstName;
        this.patronymic = patronymic;
        this.age = age;
    }

    public Human (Human copy){ // конструктор копирования
        this.lastName = copy.lastName;
        this.firstName = copy.firstName;
        this.patronymic = copy.patronymic;
        this.age = copy.age;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Human human = (Human) o;
        return age == human.age && Objects.equals(lastName, human.lastName) && Objects.equals(firstName, human.firstName) && Objects.equals(patronymic, human.patronymic);
    }

    @Override
    public int hashCode() {
        return Objects.hash(lastName, firstName, patronymic, age);
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getPatronymic() {
        return patronymic;
    }

    public void setPatronymic(String patronymic) {
        this.patronymic = patronymic;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
}