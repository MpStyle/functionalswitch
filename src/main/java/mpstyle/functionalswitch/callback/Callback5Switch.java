package mpstyle.functionalswitch.callback;

import mpstyle.functionalswitch.FunctionalSwitch;
import mpstyle.functionalswitch.InvalidFunctionalDefinitionException;

public class Callback5Switch<A, B, C, D, E> extends FunctionalSwitch<String, Callback5<A, B, C, D, E>> {
    public void run(String key, A a, B b, C c, D d, E e) throws InvalidFunctionalDefinitionException {
        if (containsKey(key)) {
            getFunctional(key).call(a, b, c, d, e);
            return;
        }

        if (containsDefault()) {
            getFunctionalDefault().call(a, b, c, d, e);
            return;
        }

        throw new InvalidFunctionalDefinitionException(key);
    }

}
