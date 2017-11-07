package ua.softserve.academy.algorithms.sorting.merge_sort;

import ua.softserve.academy.algorithms.sorting.merge_sort.interfaces.MergeSortComparator;
import java.util.Comparator;

/**
 * This is demo class of implementation MergeSort interface.
 * For this example we used inner class Person.
 */
public class DemoClassForMergeSortComparator implements MergeSortComparator<DemoClassForMergeSortComparator.Person> {

    private Person[] people;
    private Comparator<Person> comparator;

    @Override
    public Person[] getArray() {
        return people;
    }

    @Override
    public Comparator<Person> getComparator() {
        return comparator;
    }

    public static class Person{
        private String name;
        private int age;

        public Person(String name, int age) {
            this.name = name;
            this.age = age;
        }

        public String getName() {
            return name;
        }

        /*public void setName(String name) {
            this.name = name;
        }*/

        public int getAge() {
            return age;
        }

        /*public void setAge(int age) {
            this.age = age;
        }*/

        /*@Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            Person person = (Person) o;

            if (age != person.age) return false;
            return name != null ? name.equals(person.name) : person.name == null;
        }

        @Override
        public int hashCode() {
            int result = name != null ? name.hashCode() : 0;
            result = 31 * result + age;
            return result;
        }*/
    }

    public DemoClassForMergeSortComparator(int arraySize, Comparator<Person> comparator) {
        people = new Person[arraySize];
        this.comparator = comparator;
    }

    public void setPersonByIndex(int index, Person person){
        people[index] = person;
    }

    /*public Person getPersonByIndex(int index){
        return people[index];
    }*/

    /*public Person[] getPeople() {
        return people;
    }*/

    /*public void setPeople(Person[] people) {
        this.people = people;
    }*/

    public void setComparator(Comparator<Person> comparator) {
        this.comparator = comparator;
    }
}
