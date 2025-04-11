import classes.CollectionsDemo;
import org.junit.Assert;
import org.junit.Test;
import java.util.ArrayList;


public class CollectionsDemoTest {


    @Test
    public void countStringsStartingWithChar_shouldReturnCorrectCount() {

        ArrayList<String> list = new ArrayList<>();
        char symbol = 'a';

        list.add("apple");
        list.add("banana");
        list.add("avocado");
        list.add("cherry");
        list.add("apricot");

        int result = CollectionsDemo.countStringsStartingWithChar(list, symbol);

        Assert.assertEquals(3, result); // "apple", "avocado", "apricot"
    }

    @Test
    public void countStringsStartingWithChar_emptyList_shouldReturnZero() {
        ArrayList<String> list = new ArrayList<>();
        Assert.assertEquals(0, CollectionsDemo.countStringsStartingWithChar(list, 'a'));
    }

    @Test
    public void countStringsStartingWithChar_caseSensitiveCheck() {

        ArrayList<String> list = new ArrayList<>();
 
        list.add("apple");
        list.add("Apple");
        list.add("APPLE");

        Assert.assertEquals(2, CollectionsDemo.countStringsStartingWithChar(list, 'A'));
    }

}