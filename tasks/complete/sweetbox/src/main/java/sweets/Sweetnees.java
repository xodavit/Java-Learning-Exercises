package sweets;

public abstract class Sweetnees {
    private String title;
    private int weight; //in gramm
    private double price; //in kopeika
    private String unique_parameter;

    public Sweetnees() {
        this("нет названия",0,0,"без уникальности");

    }


    public Sweetnees(String title, int weight, double price, String unique_parameter) {
        this.title = title;
        this.weight = weight;
        this.price = price;
        this.unique_parameter = unique_parameter;
    }



    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getUnique_parameter() {
        return unique_parameter;
    }

    public void setUnique_parameter(String unique_parameter) {
        this.unique_parameter = unique_parameter;
    }

    private String getInfo() {
        String info = "";
        info += "Сладость=\"" + title + '\"' +
                ", уникальный параметр=\"" + unique_parameter + '\"' +
                ", цена=" + price +
                "руб., вес=" + weight +
                "гр." +
                '}';
        return info;
    }

    @Override
    public String toString() {
        return getInfo();
    }
}
