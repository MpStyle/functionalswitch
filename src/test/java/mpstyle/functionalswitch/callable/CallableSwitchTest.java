package mpstyle.functionalswitch.callable;

import org.junit.Before;
import org.junit.Test;

import java.util.concurrent.Callable;

import static org.junit.Assert.*;

public class CallableSwitchTest {
    private CallableSwitch<String> callableSwitch = new CallableSwitch<>();

    @Before
    public void setUp() throws Exception {
        callableSwitch.add("key1", new Callable<String>() {
            @Override
            public String call() throws Exception {
                return "key1";
            }
        }).add("key2", new Callable<String>() {
            @Override
            public String call() throws Exception {
                return "key2";
            }
        }).add("key3", new Callable<String>() {
            @Override
            public String call() throws Exception {
                return "key3";
            }
        }).addDefault(new Callable<String>() {
            @Override
            public String call() throws Exception {
                return "default";
            }
        });
    }

    @Test
    public void call() throws Exception {
        assertEquals(callableSwitch.call("key1"), "key1");
        assertEquals(callableSwitch.call("key2"), "key2");
        assertEquals(callableSwitch.call("key3"), "key3");
        assertEquals(callableSwitch.call("key4"), "default");
    }

}