package mpstyle.functionalswitch.callback;

import mpstyle.functionalswitch.FunctionalSwitch;

public class CallbackSwitch<F> extends FunctionalSwitch<String, Callback<F>> {

    public void run(String key, F param) {
        if (containsKey(key)) {
            getFunctional(key).call(param);
            return;
        }

        if (containsDefault()) {
            getFunctionalDefault().call(param);
        }
    }
}
