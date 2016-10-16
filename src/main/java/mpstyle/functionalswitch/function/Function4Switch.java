package mpstyle.functionalswitch.function;

import com.googlecode.totallylazy.Function4;
import mpstyle.functionalswitch.FunctionalSwitch;
import mpstyle.functionalswitch.InvalidFunctionalDefinitionException;

public class Function4Switch<A, B, C, D, E> extends FunctionalSwitch<String, Function4<A, B, C, D, E>> {
    public E call(String key, A a, B b, C c, D d) throws InvalidFunctionalDefinitionException, Exception {
        if (containsKey(key)) {
            return getFunctional(key).call(a, b, c, d);
        }

        if (containsDefault()) {
            return getFunctionalDefault().call(a, b, c, d);
        }

        throw new InvalidFunctionalDefinitionException(key);
    }
}