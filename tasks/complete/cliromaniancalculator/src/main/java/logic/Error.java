package logic;

public class Error {

    public static void getSymbolError() throws Exception{
            throw new Exception("Ошибка в символе операции");
    }

    public static void getNumberError() throws Exception {
            throw new Exception("Ошибка в аргументах. От 1 до 10 и только");
    }

    public static void getLogicError() throws Exception{
            throw new Exception("Ошибка в логике операции. Нельзя использовать одновременно римские и арабские цифры");
    }

    public static void getDataError() throws Exception{
            throw new Exception("Ошибка в данных. Возможно они отсутствуют");
    }

    public static void getFloatDataError() throws Exception{
            throw new Exception("Ошибка в данных. работаем только с целыми числами");
    }
}
