package settingsMethod;

import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonParseException;

import java.lang.reflect.Type;
import java.time.LocalDate;

public class LocalDateDeserializer implements JsonDeserializer<LocalDate> {
    //дает возможность заменить парсинг даты не в строки, а сразу в класс LocalDate
    //и убрать костыль из геттеров из строк в дату.
    //для этого нужно сделать  обьявление gson через gson builder в главном классе
    //      GsonBuilder gsonBuilder = new GsonBuilder();
    //		gsonBuilder.registerTypeAdapter(LocalDate.class, new LocalDateDeserializer());
    //		Gson gson = gsonBuilder.create();
    //      Gson gson = gsonBuilder.setPrettyPrinting().create();// для красивого форматирования
    @Override
    public LocalDate deserialize(JsonElement jsonElement, Type typeOfT, JsonDeserializationContext jsonDeserializationContext) throws JsonParseException {
        return LocalDate.parse(jsonElement.getAsString());
//        return LocalDate.parse(jsonElement.getAsString(),
//                DateTimeFormatter.ofPattern("yyyy-MM-dd").withLocale(Locale.ENGLISH));
    }
}
