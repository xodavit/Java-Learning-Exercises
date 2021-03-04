import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public abstract class Sweet {
    private String title = "нет названия";
    private int weight = 0; //in gramm
    private double price = 0; //in kopeika
    private String uniqueParameter = "без уникальности";

    @Override
    public String toString() {
        return "Сладость=\"" + title + '\"' +
                ", уникальный параметр=\"" + uniqueParameter + '\"' +
                ", цена=" + price +
                "руб., вес=" + weight +
                "гр." +
                '}';
    }
}
