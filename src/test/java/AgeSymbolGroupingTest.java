import Classes.AgeSymbolGrouping;
import Classes.Human;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.util.*;

class AgeSymbolGroupingTest {

    @Test
    void testEmptyList() {
        List<Human> humans = new ArrayList<>();
        Map<Integer, Map<Character, List<Human>>> result = AgeSymbolGrouping.mapAgeToLetterToList(humans);
        assertTrue(result.isEmpty());
    }

    @Test
    void testSingleHuman() {
        Human h = new Human("Иванов", "Андрей", "Иванович", 20);
        Human h1 = new Human("Иванов", "Иван", "Иванович", 20);
        Human h2 = new Human("Леванов", "Иван", "Иванович", 40);

        List<Human> humans = List.of(h, h1);
        List<Human> humans1 = List.of(h2);
        List<Human> humansAll = List.of(h, h1, h2);

        Map<Integer, Map<Character, List<Human>>> excepted = new LinkedHashMap<>();

        Map<Character, List<Human>> map1 = new LinkedHashMap<>();
        map1.put('И', humans);

        Map<Character, List<Human>> map2 = new LinkedHashMap<>();
        map2.put('Л', humans1);

        excepted.put(20, map1);
        excepted.put(40, map2);

        Map<Integer, Map<Character, List<Human>>> result = AgeSymbolGrouping.mapAgeToLetterToList(humansAll);

        assertEquals(excepted, result);


//        assertEquals(1, result.size());
//        assertTrue(result.containsKey(20));
//        HashMap<Character, List<Human>> map = result.get(20);
//        assertEquals(1, map.size());
//        assertTrue(map.containsKey('И'));
//        assertEquals(h, map.get('И').get(0));
    }
}