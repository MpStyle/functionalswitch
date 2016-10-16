package mpstyle.functionalswitch.function;

import com.googlecode.totallylazy.Function5;
import mpstyle.functionalswitch.FunctionalSwitch;
import mpstyle.functionalswitch.InvalidFunctionalDefinitionException;

public class Function5Switch<A, B, C, D, E, F> extends FunctionalSwitch<String, Function5<A, B, C, D, E, F>> {
    public F call(String key, A a, B b, C c, D d, E e) throws InvalidFunctionalDefinitionException, Exception {
        if (containsKey(key)) {
            return getFunctional(key).call(a, b, c, d, e);
        }

        if (containsDefault()) {
            return getFunctionalDefault().call(a, b, c, d, e);
        }

        throw new InvalidFunctionalDefinitionException(key);
    }
}