package mpstyle.functionalswitch.callable;

import mpstyle.functionalswitch.FunctionalSwitch;
import mpstyle.functionalswitch.InvalidFunctionalDefinitionException;

import java.util.concurrent.Callable;

public class CallableSwitch<T> extends FunctionalSwitch<String, Callable<T>> {
    public T call(String key) throws InvalidFunctionalDefinitionException, Exception {
        if (containsKey(key)) {
            return getFunctional(key).call();
        }

        if (containsDefault()) {
            return getFunctionalDefault().call();
        }

        throw new InvalidFunctionalDefinitionException(key);
    }
}
