package mpstyle.functionalswitch;

import junit.framework.TestCase;
import org.junit.Assert;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

public class ConsumerSwitchTest extends TestCase {
    public void testBehavior() throws InvalidBehaviorException {
        CalledBehavior calledBehavior = mock(CalledBehavior.class);

        ConsumerSwitch.<Integer>build()
                .add("key01", calledBehavior::key01)
                .add("key02", calledBehavior::key02)
                .addDefault(calledBehavior::def)
                .accept("key01", 5);

        verify(calledBehavior).key01(5);
    }

    private static class CalledBehavior{
        public void key01(int input){}
        public void key02(int input){}
        public void def(int input){}
    }
}