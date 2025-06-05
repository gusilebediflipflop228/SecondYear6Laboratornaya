import Classes.CollectionsDemo;
import Classes.Human;
import org.junit.Test;

import java.util.*;

import static org.junit.Assert.*;


public class CollectionsDemoTest {


    @Test
    public void countStringsStartingWithCharshouldReturnCorrectCount() {

        ArrayList<String> list = new ArrayList<>();
        char symbol = 'a';

        list.add("apple");
        list.add("banana");
        list.add("avocado");
        list.add("cherry");
        list.add("apricot");

        int result = CollectionsDemo.countStringsStartingWithChar(list, symbol);

        assertEquals(3, result); // "apple", "avocado", "apricot"
    }

    @Test
    public void countStringsStartingWithCharemptyList_shouldReturnZero() {
        ArrayList<String> list = new ArrayList<>();
        assertEquals(0, CollectionsDemo.countStringsStartingWithChar(list, 'a'));
    }

    @Test
    public void countStringsStartingWithCharcaseSensitiveCheck() {

        ArrayList<String> list = new ArrayList<>();

        list.add("apple");
        list.add("Apple");
        list.add("APPLE");

        assertEquals(2, CollectionsDemo.countStringsStartingWithChar(list, 'A'));
    }



    @Test
    public void testFindNamesakesWithNamesakes() {
        List<Human> humans = new ArrayList<>();
        humans.add(new Human("Иванов", "Иван", "Иванович", 10));
        humans.add(new Human("Петрова", "Анна", "Сергеевна", 10));
        humans.add(new Human("Боженко", "Марк", "Константинович", 10));
        humans.add(new Human("Иванов", "Тимур", "Елизарович", 10));

        Human target = new Human("Иванов", "Денис","Петрович",10);
        List<Human> namesakes = CollectionsDemo.findHumanWithSameLastName(humans, target);

        assertEquals(2, namesakes.size());
        assertEquals("Иван", namesakes.get(0).getFirstName());
        assertEquals("Тимур", namesakes.get(1).getFirstName());
    }

    @Test
    public void testFindNamesakesNoNamesakes() {
        List<Human> humans = new ArrayList<>();
        humans.add(new Human("Петрова", "Анна", "Сергеевна", 10));
        humans.add(new Human("Боженко", "Марк", "Константинович", 10));

        Human target = new Human("Иванов", "Денис","Петрович",10);
        List<Human> namesakes =  CollectionsDemo.findHumanWithSameLastName(humans, target);

        assertTrue(namesakes.isEmpty());
    }

    @Test
    public void testFindNamesakesCaseSensitiveLastName() {
        List<Human> humans = new ArrayList<>();
        humans.add(new Human("Иванов", "Тимур", "Елизарович", 10));
        humans.add(new Human("иванов", "Иван", "Иванович", 10));

        Human target = new Human("Иванов", "Денис","Петрович",10);
        List<Human> namesakes =  CollectionsDemo.findHumanWithSameLastName(humans, target);

        assertEquals(1, namesakes.size()); // Должен учитывать регистр
        assertEquals("Тимур", namesakes.get(0).getFirstName());
    }



    @Test
    public void testRemoveSingleHuman() {
        List<Human> humans = Arrays.asList(
                new Human("John", "Doe", "Smith", 30),
                new Human("Jane", "Doe", "Smith", 28),
                new Human("Alice", "Johnson", "Brown", 25)
        );
        Human target = new Human("Jane", "Doe", "Smith", 28);

        List<Human> expected = Arrays.asList(
                new Human("John", "Doe", "Smith", 30),
                new Human("Alice", "Johnson", "Brown", 25)
        );

        List<Human> result = CollectionsDemo.removeHuman(humans, target);

        assertEquals(expected, result);
    }

    @Test
    public void testRemoveAllMatchingHumans() {
        List<Human> humans = Arrays.asList(
                new Human("John", "Doe", "Smith", 30),
                new Human("John", "Doe", "Smith", 30),
                new Human("Alice", "Johnson", "Brown", 25)
        );
        Human target = new Human("John", "Doe", "Smith", 30);

        List<Human> expected = Arrays.asList(
                new Human("Alice", "Johnson", "Brown", 25)
        );

        List<Human> result = CollectionsDemo.removeHuman(humans, target);

        assertEquals(expected, result);
    }

    @Test
    public void testRemoveNonExistingHuman() {
        List<Human> humans = Arrays.asList(
                new Human("John", "Doe", "Smith", 30),
                new Human("Jane", "Doe", "Smith", 28),
                new Human("Alice", "Johnson", "Brown", 25)
        );
        Human target = new Human("Nonexistent", "Human", "Person", 99);

        List<Human> expected = new ArrayList<>(humans);

        List<Human> result = CollectionsDemo.removeHuman(humans, target);

        assertEquals(expected, result);
    }
    @Test
    public void testNoIntersections() {
        List<Set<Integer>> setsList = Arrays.asList(
                new HashSet<>(Arrays.asList(1, 2, 3)),
                new HashSet<>(Arrays.asList(4, 5, 6)),
                new HashSet<>(Arrays.asList(7, 8, 9))
        );
        Set<Integer> targetSet = new HashSet<>(Arrays.asList(10, 11, 12));

        List<Set<Integer>> expected = new ArrayList<>(setsList);

        List<Set<Integer>> result = CollectionsDemo.filterNonIntersecting(setsList, targetSet);

        assertEquals(expected, result);
    }

    @Test
    public void testSomeIntersections() {
        List<Set<Integer>> setsList = Arrays.asList(
                new HashSet<>(Arrays.asList(1, 2, 3)),
                new HashSet<>(Arrays.asList(4, 5, 6)),
                new HashSet<>(Arrays.asList(7, 8, 9))
        );
        Set<Integer> targetSet = new HashSet<>(Arrays.asList(3, 6));

        List<Set<Integer>> expected = Collections.singletonList(
                new HashSet<>(Arrays.asList(7, 8, 9))
        );

        List<Set<Integer>> result = CollectionsDemo.filterNonIntersecting(setsList, targetSet);

        assertEquals(expected, result);
    }

    @Test
    public void testAllIntersections() {
        List<Set<Integer>> setsList = Arrays.asList(
                new HashSet<>(Arrays.asList(1, 2, 3)),
                new HashSet<>(Arrays.asList(4, 5, 6)),
                new HashSet<>(Arrays.asList(7, 8, 9))
        );
        Set<Integer> targetSet = new HashSet<>(Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9));

        List<Set<Integer>> expected = new ArrayList<>();

        List<Set<Integer>> result = CollectionsDemo.filterNonIntersecting(setsList, targetSet);

        assertEquals(expected, result);
    }



    @Test
    public void testSingleMaxAge() {
        List<Human> humans = Arrays.asList(
                new Human("John", "Doe", "Smith", 30),
                new Human("Jane", "Doe", "Smith", 28),
                new Human("Alice", "Johnson", "Brown", 25)
        );

        Set<Human> expected = new HashSet<>();
        expected.add(new Human("John", "Doe", "Smith", 30));

        Set<Human> result = CollectionsDemo.getHumansWithMaxAge(humans);

        assertEquals(expected, result);
    }

    @Test
    public void testSeveralMaxAges() {
        List<Human> humans = Arrays.asList(
                new Human("John", "Doe", "Smith", 35),
                new Human("Jane", "Doe", "Smith", 35),
                new Human("Alice", "Johnson", "Brown", 25)
        );

        Set<Human> expected = new HashSet<>();
        expected.add(new Human("John", "Doe", "Smith", 35));
        expected.add(new Human("Jane", "Doe", "Smith", 35));

        Set<Human> result = CollectionsDemo.getHumansWithMaxAge(humans);

        assertEquals(expected, result);
    }

    @Test
    public void testOnlyOneHuman() {
        List<Human> humans = Collections.singletonList(
                new Human("John", "Doe", "Smith", 40)
        );

        Set<Human> expected = new HashSet<>();
        expected.add(new Human("John", "Doe", "Smith", 40));

        Set<Human> result = CollectionsDemo.getHumansWithMaxAge(humans);

        assertEquals(expected, result);
    }



    @Test
    public void testFilterHumansWithMatchingIdentifiers() {
        Map<Integer, Human> humanMap = new HashMap<>();
        humanMap.put(1, new Human("John", "Doe", "Smith", 30));
        humanMap.put(2, new Human("Jane", "Doe", "Smith", 28));
        humanMap.put(3, new Human("Alice", "Johnson", "Brown", 25));

        Set<Integer> identifiers = new HashSet<>(Arrays.asList(1, 3));

        Set<Human> expected = new HashSet<>();
        expected.add(new Human("John", "Doe", "Smith", 30));
        expected.add(new Human("Alice", "Johnson", "Brown", 25));

        Set<Human> result = CollectionsDemo.filterHumans(humanMap, identifiers);

        assertEquals(expected, result);
    }


    @Test
    public void testFilterHumansWithAllIdentifiersMatching() {
        Map<Integer, Human> humanMap = new HashMap<>();
        humanMap.put(1, new Human("John", "Doe", "Smith", 30));
        humanMap.put(2, new Human("Jane", "Doe", "Smith", 28));
        humanMap.put(3, new Human("Alice", "Johnson", "Brown", 25));

        Set<Integer> identifiers = new HashSet<>(Arrays.asList(1, 2, 3));

        Set<Human> expected = new HashSet<>(humanMap.values());

        Set<Human> result = CollectionsDemo.filterHumans(humanMap, identifiers);

        assertEquals(expected, result);
    }



    @Test
    public void testFilterHumansWithSomeAdults() {
        Map<Integer, Human> humanMap = new HashMap<>();
        humanMap.put(1, new Human("John", "Doe", "Smith", 30));
        humanMap.put(2, new Human("Jane", "Doe", "Smith", 17));
        humanMap.put(3, new Human("Alice", "Johnson", "Brown", 25));

        Set<Integer> identifiers = new HashSet<>(Arrays.asList(1, 2, 3));

        Set<Human> expected = new HashSet<>();
        expected.add(new Human("John", "Doe", "Smith", 30));
        expected.add(new Human("Alice", "Johnson", "Brown", 25));

        Set<Human> result = CollectionsDemo.filterHumans18(humanMap, identifiers);

        assertEquals(expected, result);
    }

    @Test
    public void testFilterHumansWithNoAdults() {
        Map<Integer, Human> humanMap = new HashMap<>();
        humanMap.put(1, new Human("John", "Doe", "Smith", 15));
        humanMap.put(2, new Human("Jane", "Doe", "Smith", 17));
        humanMap.put(3, new Human("Alice", "Johnson", "Brown", 16));

        Set<Integer> identifiers = new HashSet<>(Arrays.asList(1, 2, 3));

        Set<Human> expected = new HashSet<>();

        Set<Human> result = CollectionsDemo.filterHumans18(humanMap, identifiers);

        assertEquals(expected, result);
    }



    @Test
    public void testIdByAgeWithValidData() {
        Map<Integer, Human> humanMap = new HashMap<>();
        humanMap.put(1, new Human("John", "Doe", "Smith", 30));
        humanMap.put(2, new Human("Jane", "Doe", "Smith", 25));
        humanMap.put(3, new Human("Alice", "Johnson", "Brown", 18));

        Map<Integer, Integer> expected = new HashMap<>();
        expected.put(1, 30);
        expected.put(2, 25);
        expected.put(3, 18);

        Map<Integer, Integer> result = CollectionsDemo.idByAge(humanMap);

        assertEquals(expected, result);
    }

    @Test
    public void testIdByAgeWithDuplicateAges() {
        Map<Integer, Human> humanMap = new HashMap<>();
        humanMap.put(1, new Human("John", "Doe", "Smith", 30));
        humanMap.put(2, new Human("Jane", "Doe", "Smith", 30));
        humanMap.put(3, new Human("Alice", "Johnson", "Brown", 25));

        Map<Integer, Integer> expected = new HashMap<>();
        expected.put(1, 30);
        expected.put(2, 30);
        expected.put(3, 25);

        Map<Integer, Integer> result = CollectionsDemo.idByAge(humanMap);

        assertEquals(expected, result);
    }





    @Test
    public void testGroupHumansByAge() {
        Set<Human> humans = new HashSet<>();
        humans.add(new Human("John", "Doe", "Smith", 30));
        humans.add(new Human("Jane", "Doe", "Smith", 25));
        humans.add(new Human("Bob", "Smith", "Williams", 25));
        humans.add(new Human("Charlie", "Brown", "Adams", 18));

        Map<Integer, List<Human>> expected = new HashMap<>();
        expected.put(30, Arrays.asList(new Human("John", "Doe", "Smith", 30)));
        expected.put(25, Arrays.asList(new Human("Jane", "Doe", "Smith", 25), new Human("Bob", "Smith", "Williams", 25)));
        expected.put(18, Collections.singletonList(new Human("Charlie", "Brown", "Adams", 18)));

        Map<Integer, List<Human>> result = CollectionsDemo.groupHumansByAge(humans);

        assertEquals(expected, result);
    }


    @Test
    public void testGroupHumansByAgeWithEmptySet() {
        Set<Human> humans = new HashSet<>();

        Map<Integer, List<Human>> expected = new HashMap<>();

        Map<Integer, List<Human>> result = CollectionsDemo.groupHumansByAge(humans);

        assertEquals(expected, result);
    }

    @Test
    public void testGroupHumansByAgeWithUniqueAges() {
        Set<Human> humans = new HashSet<>();
        humans.add(new Human("John", "Doe", "Smith", 20));
        humans.add(new Human("Jane", "Doe", "Smith", 25));
        humans.add(new Human("Alice", "Johnson", "Brown", 30));

        Map<Integer, List<Human>> expected = new HashMap<>();
        expected.put(20, Collections.singletonList(new Human("John", "Doe", "Smith", 20)));
        expected.put(25, Collections.singletonList(new Human("Jane", "Doe", "Smith", 25)));
        expected.put(30, Collections.singletonList(new Human("Alice", "Johnson", "Brown", 30)));

        Map<Integer, List<Human>> result = CollectionsDemo.groupHumansByAge(humans);

        assertEquals(expected, result);
    }


}