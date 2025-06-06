package Classes;
import java.util.*;

public class PhoneBook {
    private final Map<Human, List<String>> book = new HashMap<>(); // человек в номера телефонов

    public void addPhone(Human person, String phone) {
        book.computeIfAbsent(person, k -> new ArrayList<>()); //новое знач
        List<String> phones = book.get(person);
        if (!phones.contains(phone)) {
            phones.add(phone);
        }
    }

    public boolean removePhone(Human person, String phone) {
        List<String> phones = book.get(person);
        if (phones != null) {
            boolean removed = phones.remove(phone);
            if (phones.isEmpty()) {
                book.remove(person);
            }
            return removed;
        }
        return false;
    }

    public List<String> getPhones(Human person) {
        return book.getOrDefault(person, Collections.emptyList()); //знач в карте
    }

    public Optional<Human> findPersonByPhone(String phone) {
        for (Map.Entry<Human, List<String>> entry : book.entrySet()) {
            if (entry.getValue().contains(phone)) {
                return Optional.of(entry.getKey());
            }
        }
        return Optional.empty();
    }

    public Map<Human, List<String>> findByLastNamePrefix(String prefix) {
        Map<Human, List<String>> result = new HashMap<>();
        String pfx = prefix.toLowerCase();
        for (Map.Entry<Human, List<String>> entry : book.entrySet()) {
            if (entry.getKey().getLastName().toLowerCase().startsWith(pfx)) {
                result.put(entry.getKey(), new ArrayList<>(entry.getValue()));
            }
        }
        return result;
    }

    public Map<Human, List<String>> getAll() {
        Map<Human, List<String>> copy = new HashMap<>();
        for (Map.Entry<Human, List<String>> entry : book.entrySet()) {
            copy.put(entry.getKey(), new ArrayList<>(entry.getValue()));
        }
        return copy;
    }
}
