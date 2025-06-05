package Classes;

import java.util.Collection;
import java.util.Comparator;
import java.util.TreeSet;

class OrderedHumanList implements Iterable<Human> {
    private final TreeSet<Human> humans;

    public OrderedHumanList(Collection<? extends Human> humans) {
        // Comparator by full name (FIO)
        this.humans = new TreeSet<>(Comparator.comparing(Human::getFullName));
        this.humans.addAll(humans);
    }

    @Override
    public Iterator<Human> iterator() {
        return humans.iterator();
    }

    // Optional: method to add new Human
    public boolean add(Human human) {
        return humans.add(human);
    }
}

