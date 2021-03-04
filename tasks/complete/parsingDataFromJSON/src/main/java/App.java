import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.*;
import java.lang.reflect.Type;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import java.time.format.DateTimeFormatterBuilder;
import java.util.List;


public class App {
    public static void main(String[] args){
        File file = new File("src\\main\\resources\\CompaniesData.json");
        FileReader fileReader = null;
        try {
            fileReader = new FileReader(file);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        Gson gson = new Gson();
        List<Company> companyList;
        Type collectionsType = new TypeToken<List<Company>>(){}.getType();
        companyList = gson.fromJson(fileReader,collectionsType);
        try {
            fileReader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
//        for ( Company com: companyList
//             ) {
//            //System.out.println(com.toString());
//            System.out.println(com);
//        }
        //companyList.forEach(System.out::println);
        //companyList.stream().forEach(System.out::println); //чем это отличается от кода выше

        // Для сформированной коллекции:
        // Вывести все имеющиеся компании в формате «Краткое название» – «Дата основания 17/01/98»;
        DateTimeFormatter dtfPattern = DateTimeFormatter.ofPattern("dd/MM/yy");
        System.out.println("Выводим все имеющиеся компании.");
//        for ( Company com: companyList
//             ) {
//            System.out.println("«Краткое название: "+com.getNameShort()+
//            "» - «Дата основания: "+com.getEgrulDate().format(dtfPattern)+"»");
//        }

        //и как лучше выводить?
//        companyList.forEach(com ->
//        System.out.println("«Краткое название: "+com.getNameShort()+
//        "» - «Дата основания: "+com.getEgrulDate().format(dtfPattern)+"»"));
        companyList.stream().forEach(company ->
                System.out.println("«Краткое название: "+company.getNameShort()+
                "» - «Дата основания: "+company.getEgrulDate().format(dtfPattern)+"»"));

        System.out.println();
        //////////////////////////////////////////////////////////////////////////////////////////////////////
        // Вывести все ценные бумаги (их код, дату истечения и полное название организации-владельца),
        //которые просрочены на текущий день, а также посчитать суммарное число всех таких бумаг;

        LocalDate currentDay = LocalDate.now();
        System.out.println("Сегодня: "+currentDay.format(dtfPattern));
        //before перед
        //after после
        System.out.println("Выводим все ценные бумаги которые просрочены на текущий день.");

//        int count = 0;
//        for (Company com: companyList
//             ) {
//            for (Securities sec: com.getSecurities()
//                 ) {
//                if (sec.getDateTo().isBefore(currentDay)) {
//                    System.out.println("код: "+sec.getCode()+", дата истечения: "+sec.getDateTo().format(dtfPattern)+
//                    ", полное название организации-владельца: "+sec.getNameFull());
//                    count++;
//                }
//            }
//        }

//если обьявить  companyList.stream().forEach() без .stream(), ничего не меняется.3 раз не понимаю как правильнее
        companyList.stream().forEach(company -> company.getSecurities().stream()
                .filter(securities -> securities.getDateTo().isBefore(currentDay))
                .forEach(securities ->
                        System.out.println("код: "+securities.getCode()+", дата истечения: "
                                +securities.getDateTo().format(dtfPattern)+
                                ", полное название организации-владельца: "+securities.getNameFull())));

        long count = companyList.stream().flatMap(company -> company.getSecurities().stream()
                .filter(securities -> securities.getDateTo().isBefore(currentDay))).count();
        System.out.println("Общее количество просроченных бумаг: "+ count);

        System.out.println();
        // На запрос пользователя в виде даты «ДД.ММ.ГГГГ», «ДД.ММ,ГГ», «ДД/ММ/ГГГГ» и «ДД/ММ/ГГ»
        //вывести название и дату создания всех организаций, основанных после введенной даты;
        System.out.println("Введите запрос в виде даты «ДД.ММ.ГГГГ», «ДД.ММ,ГГ», «ДД/ММ/ГГГГ» и «ДД/ММ/ГГ»");
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        try {
            String requestDateIn = bufferedReader.readLine();
            // если ввести 25.12.95, то он не считает это как 1995 год, а считает как 2095. очент странно.

//            String dotFullDate = "dd.MM.yyyy";
//            DateTimeFormatter dtfDotFull = DateTimeFormatter.ofPattern(dotFullDate);
//            String dotShortDate = "dd.MM.yy";
//            DateTimeFormatter dtfDotShort = DateTimeFormatter.ofPattern(dotShortDate);
//            String slashShortDate = "dd/MM/yy";
//            DateTimeFormatter dtfSlashShort = DateTimeFormatter.ofPattern(slashShortDate);
//            String slashFullDate = "dd/MM/yyyy";
//            DateTimeFormatter dtfSlashFull = DateTimeFormatter.ofPattern(slashFullDate);
//            DateTimeFormatter dtfFull = new DateTimeFormatterBuilder()
//                    .appendOptional(dtfSlashFull)
//                    .appendOptional(dtfSlashShort)
//                    .appendOptional(dtfDotFull)
//                    .appendOptional(dtfDotShort)
//                    .toFormatter();

            DateTimeFormatter dtfFull = new DateTimeFormatterBuilder()
                    //не работает, если сначала объявить короткие паттерны. видимо тогда до длинных не доходит дело
                    .appendPattern("[dd/MM/yyyy][dd.MM.yyyy][dd.MM.yy][dd/MM/yy]")
                    // так же работает если в каждый аппенд добавлять 1 паттерн
                    .toFormatter();

            LocalDate requestDate = LocalDate.parse(requestDateIn,dtfFull);
            System.out.println(requestDate);
            System.out.println("Выводим название и дату создания всех организаций, основанных после введенной даты.");
//            for (Company com : companyList
//                 ) {
//                if (com.getEgrulDate().isAfter(requestDate)) {
//                    System.out.println("название организации: "+com.getNameFull()
//                            + ", дата создания: "+ com.getEgrulDate().format(dtfPattern));
//                }
//            }
            companyList.stream().filter(company -> company.getEgrulDate().isAfter(requestDate))
                    .forEach(company ->
                            System.out.println("название организации: "+company.getNameFull()
                                    + ", дата создания: "+ company.getEgrulDate().format(dtfPattern)));

            System.out.println();
            //На запрос пользователя в виде кода валюты, например EU, USD, RUB и пр. выводить id и коды
            //ценных бумаг, использующих заданную валюту.
            System.out.println("Введите запрос в виде кода валюты, например UAH, EU, USD, RUB и пр.");

            String requestIn = bufferedReader.readLine();

            System.out.println(requestIn);
            System.out.println("Выводим id и коды ценных бумаг, использующих заданную валюту.");
//            for (Company com: companyList
//                 ) {
//                for (Securities sec: com.getSecurities()
//                     ) {
//                    if (sec.getCurrency().getCode().equals(requestIn)) {
//                        System.out.println("id ценных бумаг: "+sec.getId()+", код ценных бумаг: "+sec.getCode());
//                    }
//                }
//            }
            companyList.forEach(company -> company.getSecurities().stream()
                    .filter(securities -> securities.getCurrency().getCode().equals(requestIn))
                    .forEach(securities ->
                            System.out.println("id ценных бумаг: "+securities.getId()
                                    +", код ценных бумаг: "+securities.getCode())));

            bufferedReader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
