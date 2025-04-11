package classes;

import java.util.ArrayList;

public class CollectionsDemo {

    public static int countStringsStartingWithChar(ArrayList<String> strings, char symbol) {
        if (strings == null) {
            throw new IllegalArgumentException("Список не может быть null");
        }

        int count = 0;
        for (String str : strings) {
            if (str != null && !str.isEmpty() && str.charAt(0) == symbol) {
                count++;
            }
        }
        return count;
    }



}
