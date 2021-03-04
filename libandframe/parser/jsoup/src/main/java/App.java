import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class App {
    private static Pattern pattern = Pattern.compile("\\d{2}\\.\\d{2}");

    private static String getDateFromString(String stringDate) throws Exception {
        Matcher matcher = pattern.matcher(stringDate);
        if (matcher.find()) {
            return matcher.group();
        }
        throw new Exception("Can`t extract date from string");
    }

    private static String getDayOfWeekFromString(String stringDate) throws Exception {
        String[] arrayList = stringDate.split(" ");
        return arrayList[1];
    }

    private static int printDayValues(Elements values, int index) {
        int iterationCount = 4;
        if (index == 0) {
            Element valueLn = values.get(4);
            boolean isMorning = valueLn.text().contains("Утро");
            boolean isDay = valueLn.text().contains("День");
            boolean isEvening = valueLn.text().contains("Вечер");
            boolean isNight = valueLn.text().contains("Ночь");

            if (isMorning) {
                iterationCount = 4;
            } else if (isDay) {
                iterationCount = 3;
            } else if (isEvening) {
                iterationCount = 2;
            } else if (isNight) {
                iterationCount = 1;
            }
        }
        for (int i = 0; i < iterationCount; i++) {
            Element valueLine = values.get(index + i);
            for (Element td : valueLine.select("td")) {
                System.out.print(td.text() + "      ");
            }
            System.out.println();
        }
        return iterationCount;
    }

    public static void main(String[] args) throws Exception {
        String url = "http://pogoda.msk.ru/";
        //System.out.println(new Parser().getPage(url));
        Document page = Parser.getPage(url);
        // css query language
        Element tableWth = page.select("table[class=wt]").first();
        //System.out.println(tableWth);
        //System.out.println(tableWth.text());
        Elements names = tableWth.select("tr[class=wth]");
        //System.out.println(names);
        //System.out.println(names.text());
        Elements values = tableWth.select("tr[valign=top]");
        //System.out.println(values.stream().toArray().length);
        //System.out.println(values);
        ///System.out.println(values.text());

        int index = 0;


        for (Element name : names
        ) {
            String dateString = name.select("th[id=dt]").text();
            String date = getDateFromString(dateString);
            String dayOfWeek = getDayOfWeekFromString(dateString);
            System.out.println("\n" + date + " " + dayOfWeek + "            Явления         Температура          Давление          Влажность         Ветер");
            int iterationCount = printDayValues(values, index);
            index = index + iterationCount;
        }
    }
}
