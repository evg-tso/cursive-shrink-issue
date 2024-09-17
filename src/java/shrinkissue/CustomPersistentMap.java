package shrinkissue;

import clojure.lang.*;

import java.util.Iterator;
import java.util.Set;

/**
 * This is persistent map that has an allowed key set.
 */
public class CustomPersistentMap extends APersistentMap {

    private IPersistentMap delegate;
    private final Set<Object> allowedKeys;

    public CustomPersistentMap(IPersistentMap delegate, Set<Object> allowedKeys) {
        this.delegate = delegate;
        this.allowedKeys = allowedKeys;
    }

    @Override
    public boolean containsKey(Object o) {
        if (!allowedKeys.contains(o)) {
            throw new IllegalArgumentException("Key " + o + " is not allowed");
        }

        return delegate.containsKey(o);
    }

    @Override
    public IMapEntry entryAt(Object o) {
        if (!allowedKeys.contains(o)) {
            throw new IllegalArgumentException("Key " + o + " is not allowed");
        }

        return delegate.entryAt(o);
    }

    @Override
    public IPersistentMap assoc(Object o, Object o1) {
        if (!allowedKeys.contains(o)) {
            throw new IllegalArgumentException("Key " + o + " is not allowed");
        }

        delegate = delegate.assoc(o, o1);
        return this;
    }

    @Override
    public IPersistentMap assocEx(Object o, Object o1) {
        if (!allowedKeys.contains(o)) {
            throw new IllegalArgumentException("Key " + o + " is not allowed");
        }

        delegate = delegate.assocEx(o, o1);
        return this;
    }

    @Override
    public IPersistentMap without(Object o) {
        if (!allowedKeys.contains(o)) {
            throw new IllegalArgumentException("Key " + o + " is not allowed");
        }

        delegate = delegate.without(o);
        return this;
    }

    @Override
    public Object valAt(Object o) {
        if (!allowedKeys.contains(o)) {
            throw new IllegalArgumentException("Key " + o + " is not allowed");
        }

        return delegate.valAt(o);
    }

    @Override
    public Object valAt(Object o, Object o1) {
        if (!allowedKeys.contains(o)) {
            throw new IllegalArgumentException("Key " + o + " is not allowed");
        }

        return delegate.valAt(o, o1);
    }

    @Override
    public int count() {
        return delegate.count();
    }

    @Override
    public IPersistentCollection empty() {
        delegate = (IPersistentMap)delegate.empty();
        return this;
    }

    @Override
    public ISeq seq() {
        return delegate.seq();
    }

    @Override
    public Iterator<?> iterator() {
        return delegate.iterator();
    }
}
