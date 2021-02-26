package helpers;

import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

public class MagnificenHealthUtil {
    public static <T> List<T> join(List<T> first, T second) {
        CopyOnWriteArrayList<T> list = new CopyOnWriteArrayList<>(first);
        list.add(second);

        return list;
    }
}
