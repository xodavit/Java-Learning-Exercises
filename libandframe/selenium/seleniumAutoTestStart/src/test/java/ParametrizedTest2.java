import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.*;

import java.util.Arrays;
import java.util.Collection;

@RunWith(Parameterized.class)
public class ParametrizedTest2 {
    Calculator calc = new Calculator();
    @Parameterized.Parameters
    public static Collection<Object[]> data(){
        Object[] first = {1,1,2};
        Object[] second = { 3,3,6};
        return Arrays.asList(first,second);
        //return Arrays.asList(new Object[][]{{1,1,2}{2,2,4}});
    }
    @Parameterized.Parameter
    public int a;
    @Parameterized.Parameter(1)
    public int b;
    @Parameterized.Parameter(2)
    public int c;

    @Test
    public void testSum(){

        int d = calc.sum(a,b);
        Assert.assertEquals("Не совпадает сумма",c,d);
        //Assert.assertEquals(c,calc.sum(a,b)); // bad idea, not name error
    }

}
