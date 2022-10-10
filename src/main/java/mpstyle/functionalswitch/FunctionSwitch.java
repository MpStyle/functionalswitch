package mpstyle.functionalswitch;

import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

public class FunctionSwitch<TInput, TOutput> {
    private final Map<String, Function<TInput, TOutput>> functionalContainer = new HashMap<>();
    private Function<TInput, TOutput> functionalDefault = null;

    private FunctionSwitch() {
    }

    public static <TInput, TOutput> FunctionSwitch<TInput, TOutput> build() {
        return new FunctionSwitch<>();
    }

    public FunctionSwitch<TInput, TOutput> add(String key, Function<TInput, TOutput> f) {
        functionalContainer.put(key, f);
        return this;
    }

    public FunctionSwitch<TInput, TOutput> add(String[] keys, Function<TInput, TOutput> f) {
        add(Arrays.asList(keys), f);
        return this;
    }

    public FunctionSwitch<TInput, TOutput> add(Collection<String> keys, Function<TInput, TOutput> f) {
        for (String key : keys) {
            functionalContainer.put(key, f);
        }
        return this;
    }

    public FunctionSwitch<TInput, TOutput> addDefault(Function<TInput, TOutput> f) {
        functionalDefault = f;
        return this;
    }

    public boolean containsKey(String key) {
        return functionalContainer.containsKey(key);
    }

    public Function<TInput, TOutput> getFunctional(String key) {
        return functionalContainer.get(key);
    }

    public Function<TInput, TOutput> getFunctionalDefault() {
        return functionalDefault;
    }

    public boolean containsDefault() {
        return functionalDefault != null;
    }

    public TOutput apply(String key, TInput param) throws InvalidBehaviorException {
        if (containsKey(key)) {
            return getFunctional(key).apply(param);
        }

        if (containsDefault()) {
            return getFunctionalDefault().apply(param);
        }

        throw new InvalidBehaviorException("Key not found and default not define");
    }
}
