package dsself;

/**
 * @Author: Sandro
 * @Create: 2019-05-27 11:32
 * @Info: nicemap
 **/

/*public class SweetMap<K, V> extends AbstractSetMultimap<K, V> implements Serializable {
    private static final int DEFAULT_VALUES_PER_KEY = 2;
    @VisibleForTesting
    transient int expectedValuesPerKey = 2;
    @GwtIncompatible
    private static final long serialVersionUID = 0L;

    public static <K, V> S·weetMap<K, V> create() {
        return new SweetMap();
    }

    public static <K, V> SweetMap<K, V> create(int expectedKeys, int expectedValuesPerKey) {
        return new SweetMap(expectedKeys, expectedValuesPerKey);
    }

    public static <K, V> SweetMap<K, V> create(Multimap<? extends K, ? extends V> multimap) {
        return new SweetMap(multimap);
    }

    private SweetMap() {
        super(new HashMap());
    }

    private SweetMap(int expectedKeys, int expectedValuesPerKey) {
        super(Maps.newHashMapWithExpectedSize(expectedKeys));
        Preconditions.checkArgument(expectedValuesPerKey >= 0);
        this.expectedValuesPerKey = expectedValuesPerKey;
    }

    private SweetMap(Multimap<? extends K, ? extends V> multimap) {
        super(Maps.newHashMapWithExpectedSize(multimap.keySet().size()));
        this.putAll(multimap);
    }

    @Override
    public Set<V> createCollection() {
        return Sets.newHashSetWithExpectedSize(this.expectedValuesPerKey);
    }

    @GwtIncompatible
    private void writeObject(ObjectOutputStream stream) throws IOException {
        stream.defaultWriteObject();
        Serialization.writeMultimap(this, stream);
    }

    @GwtIncompatible
    private void readObject(ObjectInputStream stream) throws IOException, ClassNotFoundException {
        stream.defaultReadObject();
        this.expectedValuesPerKey = 2;
        int distinctKeys = Serialization.readCount(stream);
        Map<K, Collection<V>> map = Maps.newHashMap();
        this.setMap(map);
        Serialization.populateMultimap(this, stream, distinctKeys);
    }
}*/
