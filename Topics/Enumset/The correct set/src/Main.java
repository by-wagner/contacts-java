import java.util.*;

public class Main {

    enum Element {
        FIRE, WIND, EARTH, SKY, WATER
    }

    public static void main(String[] args) {

        // Change this statement to use EnumSet
        Set<Element> set = EnumSet.noneOf(Element.class); // Initialize an empty EnumSet

        // Add elements to the set
        set.add(Element.FIRE);
        set.add(Element.WIND);
        set.add(Element.EARTH);
        set.add(Element.SKY);
        set.add(Element.WATER);

        /** instanceof operator returns true if set object has EnumSet type
         *  and false - otherwise
         */
        System.out.println(set instanceof EnumSet);
        System.out.println(set);
    }
}