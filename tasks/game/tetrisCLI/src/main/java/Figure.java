/**
 * Класс Figure описывает фигурку тетриса
 */
public class Figure {
    // Матрица которая определяет форму фигурки: 1 - клетка не пустая, 0 - пустая
    private int[][] matrix;
    // Координаты
    private int x;
    private int y;

    public Figure(int x, int y, int[][] matrix) {
        this.x = x;
        this.y = y;
        this.matrix = matrix;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public int[][] getMatrix() {
        return matrix;
    }

    /**
     * Поворачиваем фигурку.
     * Для простоты - просто вокруг главной диагонали.
     */
    //TODO сделать поворот не туда-обратно, а по часовой стрелке
    public void rotate() {
        int[][] matrix2 = new int[3][3];

        for (int y = 0; y < 3; y++) {
            for (int x = 0; x < 3; x++) {
                matrix2[y][x] = matrix[x][y];
            }
        }

        matrix = matrix2;
    }

    /**
     * Двигаем фигурку влево.
     * Проверяем не вылезла ли она за границу поля и/или не залезла ли на занятые клетки.
     */
    public void left() {
        x--;
        if (!isCurrentPositionAvailable())
            x++;
    }

    /**
     * Двигаем фигурку вправо.
     * Проверяем не вылезла ли она за границу поля и/или не залезла ли на занятые клетки.
     */
    public void right() {
        x++;
        if (!isCurrentPositionAvailable())
            x--;
    }

    /**
     * Двигаем фигурку вверх.
     * Используется, если фигурка залезла на занятые клетки.
     */
    public void up() {
        y--;
    }

    /**
     * Двигаем фигурку вниз.
     */
    public void down() {
        y++;
    }

    /**
     * Двигаем фигурку вниз до тех пор, пока не залезем на кого-нибудь.
     */
    public void downMaximum() {
        while (isCurrentPositionAvailable()) {
            y++;
        }

        y--;
    }

    /**
     * Проверяем - может ли фигурка находится на текущей позиции:
     * а) не выходит ли она за границы поля
     * б) не заходит ли она на занятые клетки
     */
    public boolean isCurrentPositionAvailable() {
        Field field = Tetris.game.getField();

        for (int y = 0; y < 3; y++) {
            for (int x = 0; x < 3; x++) {
                if (matrix[y][x] == 1) {
                    if (this.y + y >= field.getHeight())
                        return false;

                    Integer value = field.getValue(this.x + x, this.y + y);
                    if (value == null || value == 1)
                        return false;
                }
            }
        }

        return true;
    }

    /**
     * Приземляем фигурку - добавляем все ее непустые клетки к клеткам поля.
     */
    public void landed() {
        Field field = Tetris.game.getField();

        for (int y = 0; y < 3; y++) {
            for (int x = 0; x < 3; x++) {
                if (matrix[y][x] == 1)
                    field.setValue(this.x + x, this.y + y, 1);
            }
        }
    }
}
