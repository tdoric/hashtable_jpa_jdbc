package assignment.hashtable;

public class TableEntry<K, V> {
	
	final K key;
    V value;
    TableEntry<K,V> next;

    public TableEntry(K key, V value, TableEntry<K, V> next) {
        this.key = key;
        this.value = value;
        this.next = next; 
    }

    public K getKey() {
        return key;
    }

    public V getValue() {
        return value;
    }
    
    public void setValue(V value) {
		this.value = value;
	}

	public TableEntry<K, V> getNext() {
        return next;
    }

	@Override
	public boolean equals(Object obj) {
		if(obj==this) return true;
		if(obj instanceof TableEntry) {
			TableEntry<K, V> tableEntry = (TableEntry<K, V>) obj;
			return key.equals(tableEntry.getKey())
					&&value.equals(tableEntry.getValue());
		}
		return false;
	}

	@Override
	public int hashCode() {
		int hash = 13;
        hash = 17 * hash + ((key == null) ? 0 : key.hashCode());
        hash = 17 * hash + ((value == null) ? 0 : value.hashCode());
        return hash;
	}

	@Override
	public String toString() {
		return "{" + key + ", " + value + "}";
	}
    
    
    

}
