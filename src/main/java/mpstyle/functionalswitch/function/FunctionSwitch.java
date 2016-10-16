package mpstyle.functionalswitch.function;

import com.googlecode.totallylazy.Function1;
import mpstyle.functionalswitch.FunctionalSwitch;
import mpstyle.functionalswitch.InvalidFunctionalDefinitionException;

public class FunctionSwitch<F, T> extends FunctionalSwitch<String, Function1<F, T>> {
    public T call(String key, F param) throws InvalidFunctionalDefinitionException, Exception {
        if (containsKey(key)) {
            return getFunctional(key).call(param);
        }

        if (containsDefault()) {
            return getFunctionalDefault().call(param);
        }

        throw new InvalidFunctionalDefinitionException(key);
    }
}
