package logic;

import lombok.NoArgsConstructor;
import sweets.Sweet;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;

@NoArgsConstructor
public class Box implements Optimization, Preparation {
    //индексацию я сделал с 1
    SweetMenu menu = new SweetMenu();
    private ArrayList<Sweet> box = new ArrayList<>();
    private boolean isPacked = false;
    private static final String INFO =
            "Введите номер конфеты что бы добавить ее в подарок.\n"
                    + "Если вы введете \"0\", вы сможете добавить свою конфету\nкоманды:\n"
                    + "c/C - показать команды\n"
                    + "m/M - показать сладкое меню\n"
                    + "p/P - упаковать подарок\n"
                    + "i/I - показать состав коробки\n"
                    + "d/D - удалить последний добавленный подарок\n"
                    + "di/Di - удалить по индексу\n"
                    + "dp/DP - оптимизация по цене(удаление минимальных)\n"
                    + "dw/DW - оптимизация по весу(удаление минимальных)\n"
                    + "exit/quit - выход\n";

    @Override
    public void getMenu() {
        System.out.println("Меню \nИндекс 0 - своя конфета");
        Sweet[] sweetMenu = menu.getSweetMenu();
        for (int i = 1; i < sweetMenu.length; i++) {
            System.out.printf("Индекс %s: %s", i, sweetMenu[i]);
        }
    }

    public static boolean isInteger(String s) {
        try {
            Integer.parseInt(s);
        } catch (NumberFormatException | NullPointerException e) {
            return false;
        }
        // only got here if we didn't return false
        return true;
    }

    @Override
    public void prepareGift() {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String inConsole;

        System.out.println(INFO);

        getMenu();

        while (!isPacked) {
            try {
                inConsole = reader.readLine();
                if (isInteger(inConsole)) {
                    addSweet(reader, inConsole);
                } else {
                    executeCommand(reader, inConsole);
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        try {
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void isPacked() {
        isPacked = true;
    }

    @Override
    public void addSweet(Sweet sweet) {
        box.add(sweet);
        System.out.println("Сладость: " + sweet.getTitle() + " - " + sweet.getUniqueParameter() + ", добавлена.");
    }

    @Override
    public void deleteSweetByIndex(int index) {
        System.out.println("Удалена сладость " + box.get(index).getTitle() + " по индексу : " + (index + 1));
        box.remove(index);
    }

    @Override
    public void deleteLastSweet() {

        if (box.size() == 0) {
            System.out.println("ты уже все удалил");
        } else {
            System.out.println("Удалена сладость " + box.get(box.size() - 1).getTitle() + " по индексу : " + (box.size()));
            box.remove(box.size() - 1);
        }

    }

    @Override
    public int getAllWeight() {
        int totalWeight = 0;
        for (Sweet sw : box) {
            totalWeight += sw.getWeight();
        }
        return totalWeight;
    }

    @Override
    public double getAllPrice() {
        int totalPrice = 0;
        for (Sweet sweet : box) {
            totalPrice += sweet.getPrice();
        }
        return totalPrice;
    }

    @Override
    public void getInfo() {
        String allInfo = "Общий вес коробки: " + getAllWeight() + " грамм. Общая цена коробки: " + getAllPrice() + " рублей. Количество сладостей в подарке: " + box.size() + "\n";
        System.out.println(allInfo);
    }

    @Override
    public void getAllInfo() {

        if (!(box.size() == 0)) {
            int index = 0;

            System.out.println("Содержание коробки:");
            for (Sweet sw : box) {
                index++;
                String prefix = "Индекс: " + index + ", ";
                System.out.println(prefix + sw.toString());

            }
            System.out.println();
            getInfo();
        } else System.out.println("коробка пуста");
    }

    @Override
    public void reduceWeight(double weight) {
        int count = 0;
        while (getAllWeight() > weight) {
            Sweet minSweet = findMinSweetByWeight();

            if (minSweet != null) {
                System.out.println("минимальный вес конфеты в подарке: " + minSweet.getWeight());
                box.remove(minSweet);
                System.out.println("Удалена сладость: " + minSweet.getTitle());
            }
            count++;
        }

        printSuccessfulOptimisation(count);
    }

    @Override
    public void reducePrice(double price) {
        int count = 0;

        while (getAllPrice() > price) {
            Sweet minSweet = findMinSweetByPrice();

            if (minSweet != null) {
                System.out.println("минимальное цена конфеты  в подарке: " + minSweet.getPrice());
                box.remove(minSweet);
                System.out.println("Удалена сладость: " + minSweet.getTitle());
            }
            count++;
        }

        printSuccessfulOptimisation(count);
    }

    private void executeCommand(BufferedReader reader, String inConsole) {
        switch (inConsole.toLowerCase()) {
            case "c":
                System.out.println(INFO);
                break;
            case "m":
                getMenu();
                break;
            case "p":
                isPacked();
                getAllInfo();
                break;
            case "i":
                getAllInfo();
                break;
            case "d":
                deleteLastSweet();
                getInfo();
                break;
            case "di":
                deleteByIndex(reader);
                break;
            case "dp":
                optimizeByPrice(reader);
                break;
            case "dw":
                optimizeByWeight(reader);
                break;
            case "exit":
            case "quit":
                System.out.println("Пока!");
                System.exit(0);
                break;
        }
    }

    private void addSweet(BufferedReader reader, String inConsole) throws IOException {
        int num = Integer.parseInt(inConsole);
        if (num == 0) {
            try {
                System.out.println("Введите имя своей сладости");
                String name = reader.readLine();
                menu.getSweetMenu()[0].setTitle(name);
                System.out.println("Введите вес своей сладости");
                int weight = Integer.parseInt(reader.readLine());
                menu.getSweetMenu()[0].setWeight(weight);
                System.out.println("Введите цену своей сладости");
                double price = Double.parseDouble(reader.readLine());
                menu.getSweetMenu()[0].setPrice(price);
                System.out.println("Введите уникальность вашей конфеты");
                String uniq = reader.readLine();
                menu.getSweetMenu()[0].setUniqueParameter(uniq);
            } catch (IOException e) {
                e.printStackTrace();
            }
            addSweet(menu.getSweetMenu()[num]);
            getInfo();
        }
        if (num > 0) {
            try {
                addSweet(menu.getSweetMenu()[num]);
            } catch (Exception e) {
                System.out.println("ты вышел за предел дозволенного");
                reader.readLine();
            }
            getInfo();
        }
    }

    private void optimizeByWeight(BufferedReader reader) {
        System.out.println("введите предел веса для подарка");
        try {
            double maxWeight = Double.parseDouble(reader.readLine());
            reduceWeight(maxWeight);
            getAllInfo();
        } catch (IOException e) {
            System.out.println("какая-то ошибка, возможно неверная цена");
            e.printStackTrace();
        }
    }

    private void optimizeByPrice(BufferedReader reader) {
        System.out.println("введите предел цены для подарка");
        try {
            double maxPrice = Double.parseDouble(reader.readLine());
            reducePrice(maxPrice);
            getAllInfo();
        } catch (IOException e) {
            System.out.println("какая-то ошибка, возможно неверная цена");
            e.printStackTrace();
        }
    }

    private void deleteByIndex(BufferedReader reader) {
        System.out.println("\nвведите индекс для удаления");
        int index = 0;

        try {
            index = Integer.parseInt(reader.readLine());
        } catch (IOException e) {
            System.out.println("промах мимо цифры");
            e.printStackTrace();
        }
        deleteSweetByIndex(index - 1);
        getAllInfo();
    }

    private Sweet findMinSweetByWeight() {
        return box.stream()
                .min(Comparator.comparing(Sweet::getWeight))
                .orElse(null);
    }

    private Sweet findMinSweetByPrice() {
        return box.stream()
                .min(Comparator.comparing(Sweet::getPrice))
                .orElse(null);
    }

    private void printSuccessfulOptimisation(int count) {
        System.out.println("Оптимизация подарка выполнена успешна. Удалено " + count + " сладостей");
    }
}
