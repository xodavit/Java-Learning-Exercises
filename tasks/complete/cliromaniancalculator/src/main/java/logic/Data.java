package logic;

public class Data {
    private int firstArg;
    private int secondArg;
    private char mathSymbol;
    private int answer;
    private boolean isRomanian;

    public Data() {
    }

    public int getFirstArg() {
        return firstArg;
    }

    public void setFirstArg(int firstArg) {
        this.firstArg = firstArg;
    }

    public int getSecondArg() {
        return secondArg;
    }

    public void setSecondArg(int secondArg) {
        this.secondArg = secondArg;
    }

    public char getMathSymbol() {
        return mathSymbol;
    }

    public void setMathSymbol(char mathSymbol) {
        this.mathSymbol = mathSymbol;
    }

    public int getAnswer() {
        return answer;
    }

    public void setAnswer(int answer) {
        this.answer = answer;
    }

    public boolean isRomanian() {
        return isRomanian;
    }

    public void setRomanian(boolean romanian) {
        isRomanian = romanian;
    }
}
