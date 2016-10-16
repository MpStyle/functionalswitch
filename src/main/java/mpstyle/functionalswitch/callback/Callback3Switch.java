package mpstyle.functionalswitch.callback;

import mpstyle.functionalswitch.FunctionalSwitch;
import mpstyle.functionalswitch.InvalidFunctionalDefinitionException;

public class Callback3Switch<A, B, C> extends FunctionalSwitch<String, Callback3<A, B, C>> {
    public void run(String key, A a, B b, C c) throws InvalidFunctionalDefinitionException {
        if (containsKey(key)) {
            getFunctional(key).call(a, b, c);
            return;
        }

        if (containsDefault()) {
            getFunctionalDefault().call(a, b, c);
            return;
        }

        throw new InvalidFunctionalDefinitionException(key);
    }

}
