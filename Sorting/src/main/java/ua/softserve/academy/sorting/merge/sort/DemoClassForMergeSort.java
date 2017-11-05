/*
* DemoClassForMergeSort
*
* Version 1.0-SNAPSHOT
*
* 05.11.17
*
* All rights reserved by DoubleO Team (Team#1)
* */

package ua.softserve.academy.sorting.merge.sort;

/**
 * This is demo class of implementation MergeSort interface.
 * For this example we used inner class Person.
 */
public class DemoClassForMergeSort implements MergeSort<DemoClassForMergeSort.Person>{

    private Person[] people;

    @Override
    public Person[] getArray() {
        return people;
    }

    public static class Person implements Comparable<Person>{
        private String name;
        private int age;

        public Person(String name, int age) {
            this.name = name;
            this.age = age;
        }

        public Person() {
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public int getAge() {
            return age;
        }

        public void setAge(int age) {
            this.age = age;
        }

        @Override
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
        }

        @Override
        public int compareTo(Person person) {
            return this.age - person.getAge();
        }
    }

    public DemoClassForMergeSort(int arraySize) {
        people = new Person[arraySize];
    }

    public void setPersonByIndex(int index, Person person){
        people[index] = person;
    }

    public Person getPersonByIndex(int index){
        return people[index];
    }

    public Person[] getPeople() {
        return people;
    }

    public void setPeople(Person[] people) {
        this.people = people;
    }
}
