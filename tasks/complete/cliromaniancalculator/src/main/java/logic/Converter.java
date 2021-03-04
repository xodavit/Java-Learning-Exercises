package logic;

import java.util.List;

public class Converter {
    private static List<Romanian> romanianNumbers = Romanian.getReverseSortedValues();

    public static List<Romanian> getRomanianNumbers() {
        return romanianNumbers;
    }

    public static String arabianToRomanian(int num){
        StringBuilder romanian = new StringBuilder();

        String numString = ""+num;

        if (numString.contains("-")) {
            numString = numString.replace("-","");
            num = Integer.parseInt(numString);
            romanian.append("-");
        }

        int i = 0;

        if (num == 0) {
            romanian.append(getRomanianNumbers().get(getRomanianNumbers().size()-1));
        }

        while ((num > 0) && (i < getRomanianNumbers().size())) {
            Romanian currentRomanianSymbol = getRomanianNumbers().get(i);

            if (currentRomanianSymbol.getArabian() <= num) {
                romanian.append(currentRomanianSymbol.name());
                num -= currentRomanianSymbol.getArabian();
            } else {
                i++;
            }
        }
        return romanian.toString();
    }

    public static String romanianToArabian(String num){
        String romanian = num.toUpperCase();
        int arabianResult = 0;

        int i = 0;

        while ((romanian.length() > 0) && (i < getRomanianNumbers().size())) {
            Romanian romanianSymbol = getRomanianNumbers().get(i);

            if (romanian.startsWith(romanianSymbol.name())) {
                arabianResult += romanianSymbol.getArabian();
                romanian = romanian.substring(romanianSymbol.name().length());
            } else {
                i++;
            }
        }
        return String.format("%d",arabianResult);
    }
}
