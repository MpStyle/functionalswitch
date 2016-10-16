package mpstyle.functionalswitch.function;

import com.googlecode.totallylazy.Function2;
import mpstyle.functionalswitch.FunctionalSwitch;

public class Function2Switch<A, B, C> extends FunctionalSwitch<String, Function2<A, B, C>> {
    public C call(String key, A a, B b) throws Exception {
        if (containsKey(key)) {
            return getFunctional(key).call(a,b);
        }

        if (containsDefault()) {
            return getFunctionalDefault().call(a,b);
        }

        return null;
    }
}