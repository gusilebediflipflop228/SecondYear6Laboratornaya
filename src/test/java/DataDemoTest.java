import Classes.Data;
import Classes.DataDemo;
import Classes.Group;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class DataDemoTest {

    @Test
    public void testGetAllWithNonEmptyData() {
        Data data = new Data("Testing data", new Group[] {new Group(100,new int[] {1,2,3,4,5}), new Group(200, new int[] {6,7,8,9,10})});
        List<Integer> result = DataDemo.getAll(data);
        assertEquals(Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10), result);
    }

    @Test
    public void testGetAllWithNegativeNumbers() {
        Data data = new Data("Testing data", new Group[] {new Group(100,new int[] {1,-2,3,-4,5}), new Group(200, new int[] {-6,7,-8,9,-10})});;
        List<Integer> result = DataDemo.getAll(data);
        assertEquals(Arrays.asList(1, -2, 3, -4, 5, -6, 7, -8, 9, -10), result);
    }
}
