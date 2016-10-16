package mpstyle.functionalswitch.function;

import com.googlecode.totallylazy.Function3;
import mpstyle.functionalswitch.FunctionalSwitch;

public class Function3Switch<A, B, C, D> extends FunctionalSwitch<String, Function3<A, B, C, D>> {
    public D call(String key, A a, B b, C c) throws Exception {
        if (containsKey(key)) {
            return getFunctional(key).call(a, b, c);
        }

        if (containsDefault()) {
            return getFunctionalDefault().call(a, b, c);
        }

        return null;
    }
}