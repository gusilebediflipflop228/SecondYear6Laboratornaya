import Classes.Human;
import Classes.PhoneBook;
import org.junit.Test;

import java.util.List;
import java.util.Map;
import java.util.Optional;

import static org.junit.Assert.*;

public class PhoneBookTest {
    @Test
    public void testAddPhoneToNewPerson() {
        PhoneBook pb = new PhoneBook();
        Human h = new Human("Иванов", "Иван", "Иванович", 30);
        pb.addPhone(h, "123456");
        List<String> phones = pb.getPhones(h);
        assertEquals(1, phones.size());
        assertEquals("123456", phones.get(0));
    }

    @Test
    public void testAddMultiplePhonesToSamePerson() {
        PhoneBook pb = new PhoneBook();
        Human h = new Human("Петров", "Петр", "Петрович", 40);
        pb.addPhone(h, "111111");
        pb.addPhone(h, "222222");
        List<String> phones = pb.getPhones(h);
        assertEquals(2, phones.size());
        assertTrue(phones.contains("111111"));
        assertTrue(phones.contains("222222"));
    }


    @Test
    public void testRemoveExistingPhone() {
        PhoneBook pb = new PhoneBook();
        Human h = new Human("Иванов", "Иван", "Иванович", 30);
        pb.addPhone(h, "123456");
        pb.addPhone(h, "654321");
        boolean removed = pb.removePhone(h, "123456");
        assertTrue("Phone should be removed", removed);
        List<String> phones = pb.getPhones(h);
        assertEquals(1, phones.size());
        assertEquals("654321", phones.get(0));
    }

    @Test
    public void testGetPhonesReturnsPhonesForExistingPerson() {
        PhoneBook pb = new PhoneBook();
        Human h = new Human("Иванов", "Иван", "Иванович", 30);
        pb.addPhone(h, "123456");
        pb.addPhone(h, "654321");
        List<String> phones = pb.getPhones(h);
        assertEquals(2, phones.size());
        assertTrue(phones.contains("123456"));
        assertTrue(phones.contains("654321"));
    }

    @Test
    public void testGetPhonesReturnsEmptyListForPersonWithNoPhones() {
        PhoneBook pb = new PhoneBook();
        Human h = new Human("Петров", "Петр", "Петрович", 25);
        List<String> phones = pb.getPhones(h);
        assertTrue(phones.isEmpty());
    }

    @Test
    public void testGetAllEmptyPhoneBook() {
        PhoneBook pb = new PhoneBook();
        Map<Human, List<String>> all = pb.getAll();
        assertTrue(all.isEmpty());
    }

    @Test
    public void testFindPersonByExistingPhone() {
        PhoneBook pb = new PhoneBook();
        Human h1 = new Human("Иванов", "Иван", "Иванович", 30);
        Human h2 = new Human("Петров", "Петр", "Петрович", 40);

        pb.addPhone(h1, "123456");
        pb.addPhone(h2, "654321");

        Optional<Human> found1 = pb.findPersonByPhone("123456");
        Optional<Human> found2 = pb.findPersonByPhone("654321");

        assertTrue(found1.isPresent());
        assertEquals(h1, found1.get());

        assertTrue(found2.isPresent());
        assertEquals(h2, found2.get());
    }

    @Test
    public void testFindPersonByNonexistentPhone() {
        PhoneBook pb = new PhoneBook();
        Human h = new Human("Сидоров", "Сидор", "Сидорович", 25);
        pb.addPhone(h, "111111");

        Optional<Human> found = pb.findPersonByPhone("999999");
        assertFalse(found.isPresent());
    }

}
