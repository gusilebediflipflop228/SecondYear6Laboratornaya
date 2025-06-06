package Classes;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class Data implements Iterable<Integer> {
    private String name;
    private Group[] groups;

    public Data(String name, Group[] groups) {
        this.name = name;
        this.groups = groups;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Group[] getGroups() {
        return groups;
    }

    public void setGroups(Group[] groups) {
        this.groups = groups;
    }

    public int length() {
        int total = 0;
        for (Group g : groups) total += g.length();
        return total;
    }

    @Override
    public Iterator<Integer> iterator() {
        return new DataIterator(groups);
    }

    private static class DataIterator implements Iterator<Integer> {
        private final Group[] groups;
        private int groupIdx = 0;
        private int dataIdx = 0;

        public DataIterator(Group[] groups) {
            this.groups = groups;
        }

        @Override
        public boolean hasNext() {
            while (groupIdx < groups.length) {
                if (dataIdx < groups[groupIdx].length()) {
                    return true;
                } else {
                    groupIdx++;
                    dataIdx = 0;
                }
            }
            return false;
        }

        @Override
        public Integer next() {
            if (!hasNext()) throw new NoSuchElementException();
            return groups[groupIdx].getData()[dataIdx++];
        }
    }
}
