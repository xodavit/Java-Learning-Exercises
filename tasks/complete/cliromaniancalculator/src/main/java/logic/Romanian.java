package logic;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public enum Romanian {
    N(0),
    I(1),
    IV(4),
    V(5),
    IX(9),
    X(10),
    XL(40),
    L(50),
    XC(90),
    C(100);

    private int arabian;


    Romanian(int arabian) {
        this.arabian = arabian;
    }

    public int getArabian() {
        return arabian;
    }

    public static List<Romanian> getReverseSortedValues() {
        return Arrays.stream(values())
                .sorted(Comparator.comparing((Romanian r) -> r.arabian)
                .reversed())
                .collect(Collectors.toList());
    }
}
