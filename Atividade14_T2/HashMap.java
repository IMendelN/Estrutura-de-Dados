package Atividade14_T2;

/**
 * Implementação de um HashMap genérico utilizando encadeamento separado para
 * lidar com colisões.
 *
 * @param <K> o tipo da chave
 * @param <V> o tipo do valor
 */
@SuppressWarnings("unchecked")
public class HashMap<K, V> {
    private static final int DEFAULT_CAPACITY = 10;
    private static final double LOAD_FACTOR = 0.7;

    private Entry<K, V>[] table;
    private int size;

    /**
     * Classe interna que representa uma entrada (par chave-valor) na tabela de
     * dispersão.
     *
     * @param <K> o tipo da chave
     * @param <V> o tipo do valor
     */
    private static class Entry<K, V> {
        K key;
        V value;
        Entry<K, V> next;

        /**
         * Construtor da classe Entry.
         *
         * @param key   a chave da entrada
         * @param value o valor associado à chave
         */
        public Entry(K key, V value) {
            this.key = key;
            this.value = value;
            this.next = null;
        }
    }

    /**
     * Construtor da classe HashMap. Inicializa a tabela de dispersão com capacidade
     * padrão.
     */
    public HashMap() {
        table = new Entry[DEFAULT_CAPACITY];
        size = 0;
    }

    /**
     * Insere um par chave-valor no HashMap. Se a chave já existir, substitui o
     * valor associado.
     *
     * @param key   a chave a ser inserida
     * @param value o valor associado à chave
     * @throws IllegalArgumentException se a chave for nula
     */
    public void put(K key, V value) {
        if (key == null)
            throw new IllegalArgumentException("Chave não pode ser nula.");

        int index = getIndex(key);

        if (table[index] == null) {
            table[index] = new Entry<>(key, value);
            size++;
        } else {
            Entry<K, V> current = table[index];
            while (current.next != null) {
                if (current.key.equals(key)) {
                    current.value = value;
                    return;
                }
                current = current.next;
            }

            if (current.key.equals(key)) {
                current.value = value;
            } else {
                current.next = new Entry<>(key, value);
                size++;
            }
        }

        if (shouldResize())
            resize();
    }

    /**
     * Remove a entrada com a chave especificada do HashMap.
     *
     * @param key a chave a ser removida
     * @throws IllegalArgumentException se a chave for nula
     */
    public void remove(K key) {
        if (key == null)
            throw new IllegalArgumentException("Chave não pode ser nula.");

        int index = getIndex(key);

        Entry<K, V> current = table[index];
        Entry<K, V> previous = null;

        while (current != null) {
            if (current.key.equals(key)) {
                if (previous == null) {
                    table[index] = current.next;
                } else {
                    previous.next = current.next;
                }
                size--;
                return;
            }

            previous = current;
            current = current.next;
        }
    }

    /**
     * Retorna o valor associado à chave especificada.
     *
     * @param key a chave cujo valor está sendo procurado
     * @return o valor associado à chave, ou null se a chave não existir no HashMap
     * @throws IllegalArgumentException se a chave for nula
     */
    public V get(K key) {
        if (key == null)
            throw new IllegalArgumentException("Chave não pode ser nula.");

        int index = getIndex(key);

        Entry<K, V> current = table[index];

        while (current != null) {
            if (current.key.equals(key))
                return current.value;
            current = current.next;
        }

        return null;
    }

    private int getIndex(K key) {
        int hashCode = key.hashCode();
        return Math.abs(hashCode % table.length);
    }

    /**
     * Verifica se o HashMap deve ser redimensionado com base no fator de carga
     * atual.
     *
     * @return true se o redimensionamento for necessário, false caso contrário
     */
    boolean shouldResize() {
        double loadFactor = (double) size / table.length;
        return loadFactor >= LOAD_FACTOR;
    }

    /**
     * Redimensiona o HashMap, aumentando a capacidade e reorganizando as entradas
     * existentes.
     */
    void resize() {
        Entry<K, V>[] oldTable = table;
        table = new Entry[oldTable.length * 2];
        size = 0;

        for (Entry<K, V> entry : oldTable) {
            while (entry != null) {
                put(entry.key, entry.value);
                entry = entry.next;
            }
        }
    }

    /**
     * Imprime o conteúdo do HashMap, mostrando os índices e as entradas presentes.
     */
    public void printMap() {
        for (int i = 0; i < table.length; i++) {
            Entry<K, V> entry = table[i];
            System.out.print("[" + i + "]: ");
            while (entry != null) {
                System.out.print("(" + entry.key + ", " + entry.value + ") -> ");
                entry = entry.next;
            }
            System.out.println("null");
        }
    }
}
