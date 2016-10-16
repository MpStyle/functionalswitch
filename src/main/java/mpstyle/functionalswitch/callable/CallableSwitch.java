package mpstyle.functionalswitch.callable;

import mpstyle.functionalswitch.FunctionalSwitch;

import java.util.concurrent.Callable;

public class CallableSwitch<T> extends FunctionalSwitch<String, Callable<T>> {
    public T call(String key) throws Exception {
        if (containsKey(key)) {
            return getFunctional(key).call();
        }

        if (containsDefault()) {
            return getFunctionalDefault().call();
        }

        return null;
    }
}
