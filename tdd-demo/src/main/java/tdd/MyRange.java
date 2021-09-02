package tdd;

import java.util.ArrayList;
import java.util.List;

public class MyRange {

    private final String input;

    public MyRange(String input) {
        this.input = input;
    }

    public boolean startWithInclude() {
        return input.startsWith("[");
    }

    public boolean endWithInclude() {
        return input.endsWith("]");
    }

    public int getStartNumber() {
        String numberStr = input.substring(1, input.length() - 1);
        // String startString = input.substring(0, 1);
        // String endString = input.substring(input.length() - 1, input.length());

        String[] listString = numberStr.split(",");

        int startNumber = Integer.parseInt(listString[0]);
        // Integer endNumber = Integer.parseInt(listString[1]);
        if (!startWithInclude()) {
            startNumber += 1;
        }
        return startNumber;
    }

    public int getEndNumber() {
        String numberStr = input.substring(1, input.length() - 1);

        String[] listString = numberStr.split(",");

        int endNumber = Integer.parseInt(listString[1]);

        if (!endWithInclude()) {
            endNumber -= 1;
        }
        return endNumber;
    }

    public List<String> getResult() {
        List<String> result = new ArrayList<>();
        for (int i = getStartNumber(); i <= getEndNumber(); i++) {
            result.add(i + "");
        }

        return result;
    }

    public void validateInput() {
        throw new RuntimeException();
    }
}
