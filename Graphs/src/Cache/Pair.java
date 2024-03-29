package Cache;

import java.io.Serializable;

public class Pair<K, V> implements Serializable {
    private K key;
    private V value;

    public K getKey() {
        return this.key;
    }

    public V getValue() {
        return this.value;
    }

    public Pair(K key, V value) {
        this.key = key;
        this.value = value;
    }

    public String toString() {
        return this.key + "=" + this.value;
    }

    public int hashCode() {
        return this.key.hashCode() * 13 + (this.value == null ? 0 : this.value.hashCode());
    }

    public boolean equals(Object o) {
        if (this == o) {
            return true;
        } else if (!(o instanceof Pair)) {
            return false;
        } else {
            Pair pair = (Pair)o;
            if (this.key != null) {
                if (!this.key.equals(pair.getKey())) {
                    return false;
                }
            } else if (pair.getKey() != null) {
                return false;
            }

            if (this.value != null) {
                if (!this.value.equals(pair.getValue())) {
                    return false;
                }
            } else if (pair.getValue() != null) {
                return false;
            }

            return true;
        }
    }
}
