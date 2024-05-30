package objContainersHomework;

import java.util.*;

public class Main {

    public static void main(String[] args) {
        Address address1 = new Address("Bucharest", "RO");
        Address address2 = new Address("Los Angeles", "USA");
        Address address3 = new Address("Barcelona" , "SP");

        List<Address> footballAddresses = new ArrayList<>();
        footballAddresses.add(address1);
        Hobby hobby1 = new Hobby("Football", 5, footballAddresses);

        List<Address> surfingAddresses = new ArrayList<>();
        surfingAddresses.add(address2);
        Hobby hobby2 = new Hobby("Surfing", 2, surfingAddresses);

        List<Address> singingAddresses = new ArrayList<>();
        singingAddresses.add(address1);
        singingAddresses.add(address2);
        singingAddresses.add(address3);
        Hobby hobby3 = new Hobby("Singing" , 3 , singingAddresses);

        Map<Person, List<Hobby>> personHobbies = new HashMap<>();

        Person person1 = new Person("Florinel Coman", 27);
        Person person2 = new Person("Ana Maria Prodan", 50);
        Person person3 = new Person("Smiley" , 39);


        List<Hobby> florinelHobbies = new ArrayList<>();
        florinelHobbies.add(hobby1);
        personHobbies.put(person1, florinelHobbies);

        List<Hobby> smileyHobbies = new ArrayList<>();
        smileyHobbies.add(hobby1);
        smileyHobbies.add(hobby2);
        smileyHobbies.add(hobby3);
        personHobbies.put(person3, smileyHobbies);

        List<Hobby> anaHobbies = new ArrayList<>();
        anaHobbies.add(hobby2);
        personHobbies.put(person2, anaHobbies);

        TreeSet<Person> treeSetByName = new TreeSet<>(new NameComparator());
        TreeSet<Person> treeSetByAge = new TreeSet<>(new AgeComparator());

        treeSetByName.addAll(personHobbies.keySet());
        treeSetByAge.addAll(personHobbies.keySet());

        System.out.println("Sorted by name:");
        for (Person person : treeSetByName) {
            System.out.println(person);
            List<Hobby> hobbies = personHobbies.get(person);
            for (Hobby hobby : hobbies) {
                System.out.println(" - " + hobby);
                System.out.print("   Can be practiced in: ");
                for (Address address : hobby.addresses) {
                    System.out.print(address + ", ");
                }
                System.out.println();
            }
        }

        System.out.println("\nSorted by age:");
        for (Person person : treeSetByAge) {
            System.out.println(person);
        }
    }

}
