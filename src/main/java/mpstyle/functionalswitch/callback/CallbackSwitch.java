package mpstyle.functionalswitch.callback;

import mpstyle.functionalswitch.FunctionalSwitch;
import mpstyle.functionalswitch.InvalidFunctionalDefinitionException;

public class CallbackSwitch<F> extends FunctionalSwitch<String, Callback<F>> {
    public void run(String key, F param) throws InvalidFunctionalDefinitionException {
        if (containsKey(key)) {
            getFunctional(key).call(param);
            return;
        }

        if (containsDefault()) {
            getFunctionalDefault().call(param);
            return;
        }

        throw new InvalidFunctionalDefinitionException(key);
    }
}
