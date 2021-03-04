package logic;

import sweets.Sweetnees;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Box implements Optimization,Preparation {
    //индексацию я сделал с 1
    SweetMenu menu = new SweetMenu();
    private ArrayList<Sweetnees> box;
    private boolean isPacked;
    public Box() {
        this.box = new ArrayList<>();
        this.isPacked = false;
    }

    @Override
    public void getMenu() {

        System.out.println("Меню \nИндекс 0 - своя конфета");
        for (int i = 1; i <menu.getSweetMenu().length ; i++) {
            String prefix = "Индекс "+ i +": ";
            System.out.println(prefix+menu.getSweetMenu()[i]);
        }
    }

    public static boolean isInteger(String s) {
        try {
            Integer.parseInt(s);
        } catch(NumberFormatException | NullPointerException e) {
            return false;
        }
        // only got here if we didn't return false
        return true;
    }

    @Override
    public void prepareGift() {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String inConsole;
        String info = "Введите номер конфеты что бы добавить ее в подарок.\nЕсли вы введете \"0\", вы сможете добавить свою конфету\nкоманды:\n"
                +"c/C - показать команды\n"
                +"m/M - показать сладкое меню\n"
                +"p/P - упаковать подарок\n"
                +"i/I - показать состав коробки\n"
                +"d/D - удалить последний добавленный подарок\n"
                +"di/Di - удалить по индексу\n"
                +"dp/DP - оптимизация по цене(удаление минимальных)\n"
                +"dw/DW - оптимизация по весу(удаление минимальных)\n";
        System.out.println(info);
        getMenu();
//////////////////////////////////////////////////////////////////////////////////////

        while (!isPacked) {
            try {
                inConsole =reader.readLine();
                if (!isInteger(inConsole)) {
                    if (inConsole.equals("c")||inConsole.equals("C")) {
                        System.out.println(info);
                    }
                    if (inConsole.equals("m")||inConsole.equals("M")) {
                        getMenu();
                    }
                    if (inConsole.equals("p")||inConsole.equals("P")) {
                        isPacked();
                        getAllInfo();
                    }
                    if (inConsole.equals("i")||inConsole.equals("I")) {
                        getAllInfo();
                    }
                    if (inConsole.equals("d")||inConsole.equals("D")) {
                        deleteLastSweet();
                        getInfo();

                    }
                    if (inConsole.equals("di")||inConsole.equals("DI")) {
                        System.out.println("\nвведите индекс для удаления");
                        int index = 0;

                        try {
                            index= Integer.parseInt(reader.readLine());
                        } catch (IOException e) {
                            System.out.println("промах мимо цифры");
                            e.printStackTrace();
                        }
                        deleteSweetByIndex(index-1);
                        getAllInfo();
                    }
                    if (inConsole.equals("dp")||inConsole.equals("DP")) {
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
                    if (inConsole.equals("dw")||inConsole.equals("DW")) {
                        System.out.println("введите предел веса для подарка");
                        try {
                            double maxWeight= Double.parseDouble(reader.readLine());
                            reduceWeight(maxWeight);
                            getAllInfo();
                        } catch (IOException e) {
                            System.out.println("какая-то ошибка, возможно неверная цена");
                            e.printStackTrace();
                        }
                    }
                }
                else if (isInteger(inConsole)) {
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
                            menu.getSweetMenu()[0].setUnique_parameter(uniq);
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                        addSweet(menu.getSweetMenu()[num]);
                        getInfo();
                    }
                    if (num > 0) {
                        try {
                            addSweet(menu.getSweetMenu()[num]);
                        }catch (Exception e) {
                            System.out.println("ты вышел за предел дозволенного");
                            reader.readLine();
                        }
                        getInfo();
                    }
                }
            }catch (IOException e) {
                e.printStackTrace();
            }
        }
        try {
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
//////////////////////////////////////////////////////////////////////////////////////////
    @Override
    public void isPacked() {
        isPacked = true;
    }

    @Override
    public void addSweet(Sweetnees sweetnees) {
        box.add(sweetnees);
        System.out.println("Сладость: " + sweetnees.getTitle()+" - "+sweetnees.getUnique_parameter()+", добавлена.");
    }

    @Override
    public void deleteSweetByIndex(int index) {

        System.out.println("Удалена сладость " +box.get(index).getTitle()+" по индексу : "+(index+1));
        box.remove(index);
    }

    @Override
    public void deleteLastSweet() {

        if(box.size()==0) {
            System.out.println("ты уже все удалил");
        } else {
            System.out.println("Удалена сладость " +box.get(box.size()-1).getTitle()+" по индексу : "+(box.size()));
            box.remove(box.size()-1);
        }


    }

    @Override
    public int getAllWeight() {
        int totalWeight = 0;
        for (Sweetnees sw: box) {
            totalWeight += sw.getWeight();
        }
        return totalWeight;
    }

    @Override
    public double getAllPrice() {
         int totalPrice = 0;
        for (Sweetnees sweet: box) {
            totalPrice += sweet.getPrice();
        }
        return totalPrice;
    }

    @Override
    public void getInfo() {
        String allInfo = "Общий вес коробки: "+ getAllWeight() +" грамм. Общая цена коробки: "+ getAllPrice()+" рублей. Количество сладостей в подарке: "+box.size()+"\n";
        System.out.println(allInfo);
    }

    @Override
    public void getAllInfo() {

        if (!(box.size()==0)) {
            int index = 0;

            System.out.println("Содержание коробки:");
            for (Sweetnees sw : box) {
                index++;
                String prefix = "Индекс: "+index+", ";
                System.out.println(prefix+sw.toString());

            }
            System.out.println();
            getInfo();
        }
        else System.out.println("коробка пуста");
    }

    @Override
    public void reduceWeight(double weight) {
        int count = 0;
        double min = Double.MAX_VALUE;
        Sweetnees minSweet = null;
        while (getAllWeight()>weight) {
            for (Sweetnees sweetnees : box
            ) {
                if (sweetnees.getWeight()<min) {
                    min = sweetnees.getWeight();

                    minSweet = sweetnees;
                }
            }
            System.out.println("минимальный вес конфеты в подарке: " + min);
            box.remove(minSweet);
            min = Double.MAX_VALUE;
            if (minSweet != null) {
                System.out.println("Удалена сладость: "+minSweet.getTitle());
            }
            count++;
        }

        System.out.println("Оптимизация подарка выполнена успешна. Удалено "+count+" сладостей");
    }

    @Override
    public void reducePrice(double price) {
        int count = 0;
        double min = Double.MAX_VALUE;
        Sweetnees minSweet = null;
        while (getAllPrice()>price) {
            for (Sweetnees sweetnees : box
            ) {
                if (sweetnees.getPrice()<min) {
                    min = sweetnees.getPrice();

                    minSweet = sweetnees;
                }
            }
            System.out.println("минимальное цена конфеты  в подарке: " + min);
            box.remove(minSweet);
            min = Double.MAX_VALUE;
            if (minSweet != null) {
                System.out.println("Удалена сладость: "+minSweet.getTitle());
            }
            count++;
        }
        System.out.println("Оптимизация подарка выполнена успешна. Удалено "+count+" сладостей");

    }
}
