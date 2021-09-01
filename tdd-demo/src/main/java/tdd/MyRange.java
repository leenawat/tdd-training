package tdd;

public class MyRange {

    private final String input;

    public MyRange(String input) {
        this.input = input;
    }

    public boolean startWithInclude() {
        return input.startsWith("[");
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

}
