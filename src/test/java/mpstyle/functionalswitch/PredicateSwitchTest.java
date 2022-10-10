package mpstyle.functionalswitch;

import junit.framework.TestCase;
import org.junit.Assert;

public class PredicateSwitchTest extends TestCase {

    public void testBehavior() throws InvalidBehaviorException {
        var behavior = PredicateSwitch.<Integer>build()
                .add("key01", input -> input % 2 == 0)
                .add("key02", input -> input % 5 == 0)
                .addDefault(input -> false);

        Assert.assertFalse(behavior.test("key01", 5));
        Assert.assertTrue(behavior.test("key02", 5));
        Assert.assertFalse(behavior.test("key03", 5));
    }
}