package logic;

public class Check {
    public static void checkFloatInData(String data) throws Exception {
        if (data.contains(".")) {
            Error.getFloatDataError();
        }
    }

    public static void checkNumberInData(Data data) throws Exception {
        if (data.getFirstArg()<1||data.getFirstArg()>10){
            Error.getNumberError();
        }
        if (data.getSecondArg()<1||data.getSecondArg()>10){
            Error.getNumberError();
        }
    }

    public static void checkRomanianNumberInData(String[] dataArray, Data data) {
        if (Character.isAlphabetic(dataArray[0].charAt(0)) && Character.isAlphabetic(dataArray[1].charAt(0))) {
            data.setRomanian(true);
        }
    }
    public static void checkValidData(String[] dataArray) throws Exception {
        if (Character.isAlphabetic(dataArray[0].charAt(0)) && Character.isDigit(dataArray[1].charAt(0))
                || Character.isDigit(dataArray[0].charAt(0)) && Character.isAlphabetic(dataArray[1].charAt(0))) {
            Error.getLogicError();
        }
    }
}
