package mpstyle.functionalswitch;

import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Predicate;

public class PredicateSwitch<TInput> {
    private final Map<String, Predicate<TInput>> functionalContainer = new HashMap<>();
    private Predicate<TInput> functionalDefault = null;

    public PredicateSwitch<TInput> add(String key, Predicate<TInput> f) {
        functionalContainer.put(key, f);
        return this;
    }

    public PredicateSwitch<TInput> add(String[] keys, Predicate<TInput> f) {
        add(Arrays.asList(keys), f);
        return this;
    }

    public PredicateSwitch<TInput> add(Collection<String> keys, Predicate<TInput> f) {
        for (String key : keys) {
            functionalContainer.put(key, f);
        }
        return this;
    }

    public PredicateSwitch<TInput> addDefault(Predicate<TInput> f) {
        functionalDefault = f;
        return this;
    }

    public boolean containsKey(String key) {
        return functionalContainer.containsKey(key);
    }

    public Predicate<TInput> getFunctional(String key) {
        return functionalContainer.get(key);
    }

    public Predicate<TInput> getFunctionalDefault() {
        return functionalDefault;
    }

    public boolean containsDefault() {
        return functionalDefault != null;
    }

    private PredicateSwitch() {
    }

    public static <TInput> PredicateSwitch<TInput> build() {
        return new PredicateSwitch<>();
    }

    public boolean test(String key, TInput param) throws InvalidBehaviorException {
        if (containsKey(key)) {
            return getFunctional(key).test(param);
        }

        if (containsDefault()) {
            return getFunctionalDefault().test(param);
        }

        throw new InvalidBehaviorException("Key not found and default not define");
    }
}
