import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

@RunWith(Parameterized.class)
public class ParameterizetTest {
    @Parameterized.Parameters
    public static Collection<Object[]> params(){
        Object[] first = { "Vasua","Pupkin"};
        Object[] second = { "Nastya","Nepupkina"};
        return Arrays.asList(first,second);
        //return Arrays.asList(new Object[][]{{"Petya","Dudkin"}{"Diana","Neptunkina"}});
    }
    @Parameterized.Parameter(0)
    public String name;
    @Parameterized.Parameter(1)
    public String lastName;

    @Test
    public void printName(){
        System.out.println(String.format("Меня зовут  %s %s",name,lastName));
    }
}
