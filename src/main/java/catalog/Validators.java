package catalog;

import java.util.ArrayList;
import java.util.List;

public class Validators {

    public static boolean isEmpty(List list) {
        return list == null || list.size() == 0;
    }

    public static boolean isBlank(String string) {
        return string == null || string.trim().length() == 0;
    }
}





