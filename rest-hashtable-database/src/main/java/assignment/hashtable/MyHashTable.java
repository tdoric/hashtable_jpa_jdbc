package assignment.hashtable;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
/**
 * Own implemnetation of HashTable
 * @author Doric
 *
 * @param <K>
 * @param <V>
 */
public class MyHashTable<K, V> {
		
		private static Logger logger = LoggerFactory.getLogger(MyHashTable.class);
	 	private static final int DEFAULT_CAPACITY = 16;
	 	private TableEntry<K,V>[] table;
	    private int size;
	
	    public MyHashTable() {
	    	this(DEFAULT_CAPACITY);
	    }
	    @SuppressWarnings("unchecked")
		public MyHashTable(int capacity) {
	    	int highestOneBit = Integer.highestOneBit(capacity);
	    	if(capacity<1) {
	    		throw new IllegalArgumentException();
	    	}else if(capacity!=highestOneBit) {
	    		capacity= highestOneBit<<1;
	    	}
			this.table= new TableEntry[capacity];
			logger.info("Capacity of hashtable: "+capacity);
		}
	  
	    
	    public void put(K key, V value) {
	    	
	    	TableEntry<K, V> entry = new TableEntry<>(key, value, null);
	        int tableEntry = getHash(key) % getTablesSize();
	        TableEntry<K, V> existing = table[tableEntry];
	        
	        if (existing == null) {
	        	table[tableEntry] = entry;
	            size++;
	        } else {
	            while (existing.next != null) {
	                if (existing.key.equals(key)) {
	                    existing.value = value;
	                    return;
	                }
	                existing = existing.next;
	            }

	            if (existing.key.equals(key)) {
	                existing.value = value;
	            } else {
	                existing.next = entry;
	                size++;
	            }
	        }
	    }
	    public V get(K key) {
	        TableEntry<K, V> tableEntry = table[getHash(key) % getTablesSize()];

	        while (tableEntry != null) {
	            if (key == tableEntry.key) {
	                return tableEntry.value;
	            }
	            tableEntry = tableEntry.next;
	        }
	        return null;
	    }
	    public void remove(K key) {
	    	int tableEntryIndex = getHash(key) % getTablesSize();
	    	
	        if (table[tableEntryIndex] != null) 
	          {
	        	  TableEntry<K, V> prevEntry = null; 
	  	    	  TableEntry<K, V> tableEntry = table[tableEntryIndex];
	              while (tableEntry.next != null && !tableEntry.key.equals(key)) 
	              {
	            	  prevEntry = tableEntry;
	                  tableEntry = tableEntry.next;
	              }
	              if (tableEntry.key.equals(key)) 
	              {
	                  if (prevEntry == null)
	                      table[tableEntryIndex] = tableEntry.next;
	                  else
	                	  prevEntry.next = tableEntry.next;
	                      size--;
	              }
	          }
	 
	    	
	    }
	    
	    private int getHash(K key) {
	        return key == null ? 0 : Math.abs(key.hashCode());
	    }
	    
	    private int getTablesSize() {
	        return table.length;
	    }
	    
	    public int size() {
	        return size;
	    }
	    
		@Override
		public String toString() {
			StringBuilder sb = new StringBuilder();
	        for (TableEntry<K, V> tableEntry : table) {
	            sb.append("[");
	            while (tableEntry != null) {
	                sb.append(tableEntry);
	                if (tableEntry.next != null) {
	                    sb.append(", ");
	                }
	                tableEntry = tableEntry.next;
	            }
	            sb.append("]");
	        }
	        return "{" + sb.toString() + "}";
		}
	    
	    
	    


	

}
