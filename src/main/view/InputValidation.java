package view;

import java.util.Arrays;

public class InputValidation {
    public boolean isLessThan(String input, int number) {
        return input.length() <= number;
    }
    public boolean isChildrenNamesLessThan(String[] childrenNames, int number) {
        for (String childName : childrenNames) {
            String name = childName.trim();
            if (name.length() > 5) {
                return false;
            }
        }
        return true;
    }
    public boolean isYorN(String input) {
        return input.equalsIgnoreCase("y") || input.equalsIgnoreCase("Y") || input.equalsIgnoreCase("n") || input.equalsIgnoreCase("N");
    }
}
