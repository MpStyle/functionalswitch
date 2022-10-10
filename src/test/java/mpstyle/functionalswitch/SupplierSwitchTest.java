package mpstyle.functionalswitch;

import junit.framework.TestCase;
import org.junit.Assert;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

public class SupplierSwitchTest extends TestCase {
    public void testBehavior() throws InvalidBehaviorException {
        Assert.assertEquals(Integer.valueOf(5), SupplierSwitch.<Integer>build()
                .add("key01", () -> 5)
                .add("key02", () -> 6)
                .addDefault(() -> 0)
                .get("key01"));
    }
}