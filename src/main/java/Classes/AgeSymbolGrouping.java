package Classes;
import java.util.*;

public class AgeSymbolGrouping {
    public static Map<Integer, Map<Character, List<Human>>> mapAgeToLetterToList(List<Human> humans) {
        Map<Integer, Map<Character, List<Human>>> map = new LinkedHashMap<>();
        for (Human h : humans) {
            if (!map.containsKey(h.getAge())) {
                map.put(h.getAge(), new LinkedHashMap<>());
            }
            if (!map.get(h.getAge()).containsKey(h.getLastName().charAt(0))) {
                map.get(h.getAge()).put(h.getLastName().charAt(0), new ArrayList<>());
            }
            map.get(h.getAge()).get(h.getLastName().charAt(0)).add(h);
        }
        return map;
    }
}
