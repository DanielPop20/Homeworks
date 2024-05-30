package objContainersHomework;

import java.util.List;

public class Hobby {

    private String name;
    private int frequency;
    public List<Address> addresses;

    public Hobby(String name, int frequency, List<Address> addresses) {
        this.name = name;
        this.frequency = frequency;
        this.addresses = addresses;
    }

    @Override
    public String toString() {
        return name + " (Frequency: " + frequency + " times/week)";
    }


}
