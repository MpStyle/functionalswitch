package mpstyle.functionalswitch.function;

import com.googlecode.totallylazy.Function2;
import mpstyle.functionalswitch.FunctionalSwitch;
import mpstyle.functionalswitch.InvalidFunctionalDefinitionException;

public class Function2Switch<A, B, C> extends FunctionalSwitch<String, Function2<A, B, C>> {
    public C call(String key, A a, B b) throws InvalidFunctionalDefinitionException, Exception {
        if (containsKey(key)) {
            return getFunctional(key).call(a,b);
        }

        if (containsDefault()) {
            return getFunctionalDefault().call(a,b);
        }

        throw new InvalidFunctionalDefinitionException(key);
    }
}