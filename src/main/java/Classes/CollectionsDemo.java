package Classes;

import java.util.*;

public class CollectionsDemo {

    public static int countStringsStartingWithChar(List<String> strings, char symbol) {
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

    public static List<Human> findHumanWithSameLastName(List<Human> humans, Human person) {
        List<Human> namesakes = new ArrayList<>();
        String targetLastName = person.getLastName();

        for (Human human : humans) {
            if (human.getLastName().equals(targetLastName)) {
                namesakes.add(human);
            }
        }

        return namesakes;
    }

    public static List<Human> removeHuman(List<Human> humans, Human target) {
        List<Human> result = new ArrayList<>();
        for (Human human : humans) {
            if (!human.equals(target)) {
                result.add(new Human(human.getLastName(), human.getFirstName(), human.getPatronymic(), human.getAge()));
            }
        }
        return result;
    }

    public static List<Set<Integer>> filterNonIntersecting(List<Set<Integer>> setsList, Set<Integer> targetSet) {
        List<Set<Integer>> result = new ArrayList<>();
        boolean flag = true;

        for (Set<Integer> set : setsList) {
            for (Integer num : targetSet) {
                if (set.contains(num)) {
                    flag = false;
                    break;
                }
            }
            if (flag) {
                result.add(set);
            }
            flag = true;
        }
        return result;
    }

    public static Set<Human> getHumansWithMaxAge(List<? extends Human> humans) {
        Set<Human> result = new HashSet<>();
        int maxAge = Integer.MIN_VALUE; // -2^31

        for (Human human : humans) {
            if (human.getAge() > maxAge) {
                maxAge = human.getAge();
                result.add(human);
            } else if (human.getAge() == maxAge) {
                result.add(human);
            }
        }

        return result;
    }

    public static Set<Human> filterHumans(Map<Integer, Human> humanMap, Set<Integer> identifiers) {
        Set<Human> result = new HashSet<>();

        for (int id : identifiers) {
            if (identifiers.contains(id)) {
                result.add(humanMap.get(id));
            }
        }

        return result;
    }

    public static Set<Human> filterHumans18(Map<Integer, Human> humanMap, Set<Integer> identifiers) {
        Set<Human> result = new HashSet<>();

        for (Human h : humanMap.values()) {
            if (h.getAge() >= 18) {
                result.add(h);
            }
        }
        return result;
    }

    public static Map<Integer, Integer> idByAge(Map<Integer, Human> humanMap) {
        HashMap<Integer, Integer> result = new HashMap<>();
        for (int i : humanMap.keySet()) {
            result.put(i, humanMap.get(i).getAge());
        }
        return result;
    }

    public static Map<Integer, List<Human>> groupHumansByAge(Set<Human> humans) { // 10
        Map<Integer, List<Human>> result = new HashMap<>();

        for (Human human : humans) {
            result.putIfAbsent(human.getAge(), new ArrayList<>());
            result.get(human.getAge()).add(human);
        }
        return result;
    }



}
