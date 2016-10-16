package mpstyle.functionalswitch.callback;

import mpstyle.functionalswitch.FunctionalSwitch;
import mpstyle.functionalswitch.InvalidFunctionalDefinitionException;

public class Callback2Switch<A, B> extends FunctionalSwitch<String, Callback2<A, B>> {
    public void run(String key, A a, B b) throws InvalidFunctionalDefinitionException {
        if (containsKey(key)) {
            getFunctional(key).call(a, b);
            return;
        }

        if (containsDefault()) {
            getFunctionalDefault().call(a, b);
            return;
        }

        throw new InvalidFunctionalDefinitionException(key);
    }
}
