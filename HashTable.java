public class HashTable<K, V> {
    private static class Entry<K, V> {
        K key;
        V value;
        Entry<K, V> next;

        public Entry(K key, V value) {
            this.key = key;
            this.value = value;
        }
    }

    private Entry<K, V>[] table;
    private int size;
    private static final int CAPACITY = 10;

    @SuppressWarnings("unchecked")
    public HashTable() {
        table = new Entry[CAPACITY];
        size = 0;
    }

    private int hash(K key) {
        if (key == null) return 0;
        return Math.abs(key.hashCode()) % table.length;
    }

    public void put(K key, V value) {
        int index = hash(key);
        Entry<K, V> current = table[index];

        while (current != null) {
            if (current.key.equals(key)) {
                current.value = value;
                return;
            }
            current = current.next;
        }

        Entry<K, V> newEntry = new Entry<>(key, value);
        newEntry.next = table[index];
        table[index] = newEntry;
        size++;
    }

    public V get(K key) {
        int index = hash(key);
        Entry<K, V> current = table[index];

        while (current != null) {
            if (current.key.equals(key)) {
                return current.value;
            }
            current = current.next;
        }
        return null;
    }

    public void remove(K key) {
        int index = hash(key);
        Entry<K, V> current = table[index];
        Entry<K, V> prev = null;

        while (current != null) {
            if (current.key.equals(key)) {
                if (prev == null) {
                    table[index] = current.next;
                } else {
                    prev.next = current.next;
                }
                size--;
                return;
            }
            prev = current;
            current = current.next;
        }
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public static void main(String[] args) {
        HashTable<String, Integer> map = new HashTable<>();

        System.out.println("Пустота таблицы до добавления: " + map.isEmpty() + "\n");

        map.put("apple", 5);
        map.put("banana", 3);
        map.put("orange", 7);
        map.put("pear", 2);

        System.out.println("Пустота таблицы псоле добавления: " + map.isEmpty() + "\n");

        System.out.println("Размер: " + map.size());
        System.out.println("banana: " + map.get("banana") + "\n");

        map.remove("apple");
        System.out.println("apple до remove: " + map.size());
        System.out.println("apple после remove: " + map.get("apple"));
    }
}