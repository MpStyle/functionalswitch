package mpstyle.functionalswitch.callback;

import mpstyle.functionalswitch.FunctionalSwitch;

public class Callback4Switch<A, B, C, D> extends FunctionalSwitch<String, Callback4<A, B, C, D>> {

    public void run(String key, A a, B b, C c, D d)  {
        if (containsKey(key)) {
            getFunctional(key).call(a, b, c, d);
            return;
        }

        if (containsDefault()) {
            getFunctionalDefault().call(a, b, c, d);
        }
    }

}
