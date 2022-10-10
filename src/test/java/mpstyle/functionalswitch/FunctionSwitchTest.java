package mpstyle.functionalswitch;

import junit.framework.TestCase;
import org.junit.Assert;

public class FunctionSwitchTest extends TestCase {
    public void testBehavior() throws InvalidBehaviorException {
        Assert.assertEquals(Integer.valueOf(6), FunctionSwitch.<Integer, Integer>build()
                .add("key01", input -> input + 1)
                .add("key02", input -> input + 2)
                .addDefault(input -> 0)
                .apply("key01", 5));
    }
}