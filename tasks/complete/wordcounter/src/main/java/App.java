import java.io.*;
import java.util.Map;
import java.util.TreeMap;

public class App {
    public static void main(String[] args) {
        //создано 2 тестовых файла
        //1 находится в корневом каталоге - testFile.txt
        //2 находится в доп созднном каталоге - src\fileDirectory\bash.txt
        int maxCountWord = Integer.MIN_VALUE;
        String filePath;
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        TreeMap<String, Integer> map = new TreeMap<>();
        try {
            filePath = reader.readLine();
            File file = new File(filePath);
            BufferedReader fileReader = new BufferedReader(new FileReader(file));
            while (fileReader.ready()) {
                String fileStr = fileReader.readLine().toLowerCase();
                String replacementString = fileStr.replaceAll("\\p{Punct}|[“]"," ").trim();
                //I HAVE A PROBLEM!
                //test file in src\fileDirectory\bash.txt have a UTF-8 BOM encoding!
                // в общем, эта хрень добавляет мне в начале или в конце слов пробел очень странный.гугл говорит что это неразрывной пробел[\uFEFF]
                // 26 пробелов в тексте.
                //.trim обрезает его с конца и их становится 19. как обрезать вначале я не знаю!
                //replaceFirst("[\\uFEFF-\\uFFFF]+"," ") не сработало :(
                String [] arrayString = replacementString.split("\\p{Space}+");
                for (String string: arrayString) {
                    if(!map.containsKey(string)) {
                        map.put(string,1);
                        //System.out.println("мапа не содержит: \""+string+"\" - оно было добавлено, счетчик слова установлен на значение: "+map.get(string).intValue());
                    } else {
                        int count = map.get(string);
                        map.put(string,++count);
                        if (maxCountWord<count){
                            maxCountWord=count;
                        }
                        //System.out.println("слово \""+string+"\" уже есть в мапе, значение счетчика изменено на "+map.get(string));
                    }
                }
            }
            System.out.println();
            map.forEach((x,y)->System.out.println(x+": "+y));
            System.out.println("макимальное повторение слов = "+maxCountWord);
            System.out.println("Выводим слова с макимальным числом повторений:");
            for (Map.Entry<String,Integer> iterator: map.entrySet()) {
                if (iterator.getValue().equals(maxCountWord)) {
                    System.out.print(iterator.getKey()+" ");
                }



            }
            reader.close();
            fileReader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
