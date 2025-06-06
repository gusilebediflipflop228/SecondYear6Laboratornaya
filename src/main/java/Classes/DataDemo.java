package Classes;

import java.util.ArrayList;
import java.util.List;

public class DataDemo {
    public static List<Integer> getAll(Data data) {
        List<Integer> res = new ArrayList<>();
        for (int num : data) {
            res.add(num);
        }
        return res;
    }
}
