package mpstyle.functionalswitch;

import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public abstract class FunctionalSwitch<F, T> {
    private Map<F, T> functionalContainer = new HashMap<F, T>();
    private T functionalDefault = null;

    public FunctionalSwitch<F, T> add(F key, T f) {
        functionalContainer.put(key, f);
        return this;
    }

    public FunctionalSwitch<F, T> add(F[] keys, T f) {
        add(Arrays.asList(keys), f);
        return this;
    }

    public FunctionalSwitch<F, T> add(Collection<F> keys, T f) {
        for (F key : keys) {
            functionalContainer.put(key, f);
        }
        return this;
    }

    public FunctionalSwitch<F, T> addDefault(T f) {
        functionalDefault = f;
        return this;
    }

    public boolean containsKey(F key) {
        return functionalContainer.containsKey(key);
    }

    public T getFunctional(F key) {
        return functionalContainer.get(key);
    }

    public T getFunctionalDefault() {
        return functionalDefault;
    }

    public boolean containsDefault() {
        return functionalDefault != null;
    }
}
