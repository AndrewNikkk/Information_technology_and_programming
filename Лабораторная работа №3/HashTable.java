import java.util.LinkedList;

public class HashTable<K, V> {
    private LinkedList<Entry<K, V>> [] buckets;
    private int size;
    private static final int INITIAL_CAPACITY = 16;


    private static class Entry<K, V> {
        private K key;
        private V value;

        public Entry(K key, V value) {
            this.key = key;
            this.value = value;
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
    }

    @SuppressWarnings("unchecked")
    public HashTable() {
        buckets = new LinkedList[INITIAL_CAPACITY];
        size = 0;
    }

    private int hash(K key) {
        return Math.abs(key.hashCode()) % buckets.length;
    }

    public void put(K key, V value) {
        int index = hash(key);
        if (buckets[index] == null) {
            buckets[index] = new LinkedList<>();
        }
        for (Entry<K, V> entry : buckets[index]) {
            if (entry.getKey().equals(key)) {
                entry.setValue(value);
                return;
            }
        }
        buckets[index].add(new Entry<>(key, value));
        size++;
    }

    public V get(K key) {
        int index = hash(key);
        if (buckets[index] != null) {
            for (Entry<K, V> entry : buckets[index]) {
                if (entry.getKey().equals(key)) {
                    return entry.getValue();
                }
            }
        }
        return null;
    }

    public void remove(K key) {
        int index = hash(key);
        if (buckets[index] != null) {
            for (Entry<K, V> entry : buckets[index]) {
                if (entry.getKey().equals(key)) {
                    buckets[index].remove(entry);
                    size--;
                    return;
                }
            }
        }
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }


    public static void main(String[] args) {
        HashTable<Integer, String> table = new HashTable<>();

        System.out.println("Таблица пустая - " + table.isEmpty());

        table.put(101, "Ivan");
        table.put(305, "Petr");
        table.put(555, "Anna");

        System.out.println("Размер таблицы - " + table.size());

        System.out.println("Получим пользователя 101 - " + table.get(101));
        System.out.println("Получим пользователя 305 - " + table.get(305));
        System.out.println("Получим пользователя 555 - " + table.get(555));
        System.out.println("Получим пользователя 770 - " + table.get(770));

        table.put(101, "Nikolay");

        System.out.println("Обновили ник пользователя 101 - " + table.get(101));

        table.remove(305);
        System.out.println("Размер таблицы после удаления элемента - " + table.size());
        System.out.println("Номера 305 теперь нет - " + table.get(305));

        table.remove(101);
        table.remove(555);
        System.out.println("Таблица пустая - " + table.isEmpty());
    }
}

