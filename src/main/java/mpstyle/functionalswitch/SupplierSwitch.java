package mpstyle.functionalswitch;

import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Supplier;

public class SupplierSwitch<TOutput> {
    private final Map<String, Supplier<TOutput>> functionalContainer = new HashMap<>();
    private Supplier<TOutput> functionalDefault = null;

    public SupplierSwitch<TOutput> add(String key, Supplier<TOutput> f) {
        functionalContainer.put(key, f);
        return this;
    }

    public SupplierSwitch<TOutput> add(String[] keys, Supplier<TOutput> f) {
        add(Arrays.asList(keys), f);
        return this;
    }

    public SupplierSwitch<TOutput> add(Collection<String> keys, Supplier<TOutput> f) {
        for (String key : keys) {
            functionalContainer.put(key, f);
        }
        return this;
    }

    public SupplierSwitch<TOutput> addDefault(Supplier<TOutput> f) {
        functionalDefault = f;
        return this;
    }

    public boolean containsKey(String key) {
        return functionalContainer.containsKey(key);
    }

    public Supplier<TOutput> getFunctional(String key) {
        return functionalContainer.get(key);
    }

    public Supplier<TOutput> getFunctionalDefault() {
        return functionalDefault;
    }

    public boolean containsDefault() {
        return functionalDefault != null;
    }

    private SupplierSwitch() {
    }

    public static <TOutput> SupplierSwitch<TOutput> build() {
        return new SupplierSwitch<>();
    }

    public TOutput get(String key) throws InvalidBehaviorException {
        if (containsKey(key)) {
            return getFunctional(key).get();
        }

        if (containsDefault()) {
            return getFunctionalDefault().get();
        }

        throw new InvalidBehaviorException("Key not found and default not define");
    }
}
