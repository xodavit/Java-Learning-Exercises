import java.util.ArrayList;

/**
 * Класс Field описывает "поле клеток" игры Тетрис
 */
public class Field {
    //ширина и высота
    private int width;   //x
    private int height;  //y
    //ВАЖНО!
    //Двумерный массив можно представить как массив массивов или как прямоугольную матрицу.
    //При этом первой координатой в массиве у нас будет номер строки, а второй - столбца.
    //Другими словами ячейка с координатами x, y - это matrix[y][x].

    //матрица поля: 1 - клетка занята, 0 - свободна
    private int[][] matrix;

    public Field(int width, int height) {
        this.width = width;
        this.height = height;
        matrix = new int[height][width];
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

    public int[][] getMatrix() {
        return matrix;
    }

    /**
     * Метод возвращает значение, которое содержится в матрице с координатами (x,y)
     * Если координаты за пределами матрицы, метод возвращает null.
     */
    public Integer getValue(int x, int y) {
        if (x >= 0 && x < width && y >= 0 && y < height)
            return matrix[y][x];

        return null;
    }

    /**
     * Метод устанавливает переданное значение(value) в ячейку матрицы с координатами (x,y)
     */
    public void setValue(int x, int y, int value) {
        if (x >= 0 && x < width && y >= 0 && y < height)
            matrix[y][x] = value;
    }

    /**
     * Метод печатает на экран текущее содержание матрицы
     */
    public void print() {
        //Создаем массив, куда будем "рисовать" текущее состояние игры
        int[][] canvas = new int[height][width];

        //Копируем "матрицу поля" в массив
        for (int y = 0; y < height; y++) {
            for (int x = 0; x < width; x++) {
                canvas[y][x] = matrix[y][x];
            }
        }

        //Копируем фигурку в массив, только непустые клетки
        int left = Tetris.game.getFigure().getX();
        int top = Tetris.game.getFigure().getY();
        int[][] brickMatrix = Tetris.game.getFigure().getMatrix();

        for (int y = 0; y < 3; y++) {
            for (int x = 0; x < 3; x++) {
                if (top + y >= height || left + x >= width) continue;
                if (brickMatrix[y][x] == 1)
                    canvas[top + y][left + x] = 2;
            }
        }


        //Выводим "нарисованное" на экран, но начинаем с "границы кадра".
        System.out.println("---------------------------------------------------------------------------\n");

        for (int y = 0; y < height; y++) {
            for (int x = 0; x < width; x++) {
                int index = canvas[y][x];
                if (index == 0)
                    System.out.print(" . ");
                else if (index == 1)
                    System.out.print(" X ");
                else if (index == 2)
                    System.out.print(" X ");
                else
                    System.out.print("???");
            }
            System.out.println();
        }


        System.out.println();
        System.out.println();
    }

    /**
     * Удаляем заполненные линии
     */
    public void removeFullLines() {
        //Создаем список для хранения линий
        ArrayList<int[]> lines = new ArrayList<>();

        //Копируем все непустые линии в список.
        for (int y = 0; y < height; y++) {
            //подсчитываем количество единиц в строке - просто суммируем все ее значения
            int count = 0;
            for (int x = 0; x < width; x++) {
                count += matrix[y][x];
            }

            //Если сумма строки не равна ее ширине - добавляем в список
            if (count != width)
                lines.add(matrix[y]);
        }

        //Добавляем недостающие строки в начало списка.
        while (lines.size() < height) {
            lines.add(0, new int[width]);
        }

        //Преобразуем список обратно в матрицу
        matrix = lines.toArray(new int[height][width]);
    }
}
