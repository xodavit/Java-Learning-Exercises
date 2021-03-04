import logic.Check;
import logic.Converter;
import logic.Data;
import logic.Error;
import method.Addition;
import method.Division;
import method.Multiplication;
import method.Substraction;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Calculator {
    private BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    private String readData;
    private Data data;
    private String[] dataArray;

    public String getReadData() {
        return readData;
    }

    public BufferedReader getReader() {
        return reader;
    }

    public Data getData() {
        return data;
    }

    public String[] getDataArray() {
        return dataArray;
    }

    public void setData(Data data) {
        this.data = data;
    }

    public void setReadData(String readData) {
        this.readData = readData;
    }

    public void setDataArray(String[] dataArray) {
        this.dataArray = dataArray;
    }

    public void start() throws Exception {
        while (!App.isIsExit()) {
            this.enterData();
            if (getReadData().equalsIgnoreCase("e")||getReadData().equalsIgnoreCase("q")) {
                App.setIsExit(true);
                System.out.println("Exit from app");
                break;
            }
            this.prepareData();
            this.calculation();
            this.printAnswer();
        }

    }

    public void enterData(){
        System.out.println("--------------");
        System.out.println("Введите текст:");


        try {
            setReadData(getReader().readLine().replaceAll(" ",""));

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void splitData(String data) throws Exception {
        if (data.contains("+")) {
            setDataArray(getReadData().split("[+]"));
            getData().setMathSymbol('+');

        } else if (data.contains("-")) {
            setDataArray(getReadData().split("[-]"));
            getData().setMathSymbol('-');

        } else if (data.contains("*")) {
            setDataArray(getReadData().split("[*]"));
            getData().setMathSymbol('*');

        } else if (data.contains("/")) {
            setDataArray(getReadData().split("[/]"));
            getData().setMathSymbol('/');

        } else Error.getSymbolError();
    }

    public void prepareData() throws Exception {
        setData(new Data());

        Check.checkFloatInData(getReadData());

        if (!getReadData().isEmpty()) {
            this.splitData(getReadData());

        } else {
            Error.getDataError();
        }

        Check.checkValidData(getDataArray());

        Check.checkRomanianNumberInData(getDataArray(),getData());

        if (getData().isRomanian()) {
            getDataArray()[0] = Converter.romanianToArabian(getDataArray()[0]);
            getDataArray()[1] = Converter.romanianToArabian(getDataArray()[1]);
        }

        this.parseNumberInData(getDataArray(),getData());


        Check.checkNumberInData(getData());
    }

    public void parseNumberInData(String[] dataArray, Data data) {
        data.setFirstArg(Integer.parseInt(dataArray[0]));

        data.setSecondArg(Integer.parseInt(dataArray[1]));
    }

    public void calculation() throws Exception {

        switch (getData().getMathSymbol()) {
            case '+':
                getData().setAnswer(Addition.additional(getData()));
                break;
            case '-':
                getData().setAnswer(Substraction.substraction(getData()));
                break;
            case '*':
                getData().setAnswer(Multiplication.multiplication(getData()));
                break;
            case '/':
                getData().setAnswer(Division.division(getData()));
                break;
            default :
                Error.getSymbolError();
                break;
        }
    }

    public void getStartText(){
        String info = "Приложение читает из консоли введенные пользователем арифметические операции и выводит в консоль результат их выполнения." +
                "\nКалькулятор умеет выполнять операции сложения, вычитания, умножения и деления с двумя числами: a + b, a - b, a * b, a / b. Данные передаются в одну строку (смотрите пример)!" +
                "\nКалькулятор принимает на вход числа от 1 до 10 включительно, не более." +
                "\nКалькулятор умеет работать только с целыми числами." +
                "\nКалькулятор умеет работать только с арабскими или римскими цифрами одновременно, при вводе пользователем строки вроде 3 + II калькулятор выбросит исключение и прекратит свою работу." +
                "\nПри вводе пользователем строки, не соответствующей одной из вышеописанных арифметических операций, приложение выбрасывает исключение и завершает свою работу." +
                "\nПример работы программы: 1 + 2 или VI / III"+
                "\nДля выхода введите Q/q или E/e";
        System.out.println(info);
    }

    public void printAnswer(){
        if (getData().isRomanian()) {
            System.out.println("Ответ в римских: "+ Converter.arabianToRomanian(getData().getAnswer()));
        } else {
            System.out.println("Ответ: "+ getData().getAnswer());
        }
    }
}
