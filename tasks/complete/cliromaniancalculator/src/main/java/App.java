public class App {

    private static boolean isExit;

    public static void setIsExit(boolean isExit) {
        App.isExit = isExit;
    }

    public static boolean isIsExit() {
        return isExit;
    }

    public static void main(String[] args) throws Exception {

        Calculator calculator = new Calculator();
        calculator.getStartText();
        calculator.start();
    }
}
