package mpstyle.functionalswitch;

import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Consumer;

public class ConsumerSwitch<TInput> {
    private final Map<String, Consumer<TInput>> functionalContainer = new HashMap<>();
    private Consumer<TInput> functionalDefault = null;

    public ConsumerSwitch<TInput> add(String key, Consumer<TInput> f) {
        functionalContainer.put(key, f);
        return this;
    }

    public ConsumerSwitch<TInput> add(String[] keys, Consumer<TInput> f) {
        add(Arrays.asList(keys), f);
        return this;
    }

    public ConsumerSwitch<TInput> add(Collection<String> keys, Consumer<TInput> f) {
        for (String key : keys) {
            functionalContainer.put(key, f);
        }
        return this;
    }

    public ConsumerSwitch<TInput> addDefault(Consumer<TInput> f) {
        functionalDefault = f;
        return this;
    }

    public boolean containsKey(String key) {
        return functionalContainer.containsKey(key);
    }

    public Consumer<TInput> getFunctional(String key) {
        return functionalContainer.get(key);
    }

    public Consumer<TInput> getFunctionalDefault() {
        return functionalDefault;
    }

    public boolean containsDefault() {
        return functionalDefault != null;
    }

    private ConsumerSwitch() {
    }

    public static <TInput> ConsumerSwitch<TInput> build() {
        return new ConsumerSwitch<>();
    }

    public void accept(String key, TInput param) throws InvalidBehaviorException {
        if (containsKey(key)) {
            getFunctional(key).accept(param);
            return;
        }

        if (containsDefault()) {
            getFunctionalDefault().accept(param);
            return;
        }

        throw new InvalidBehaviorException("Key not found and default not define");
    }
}
