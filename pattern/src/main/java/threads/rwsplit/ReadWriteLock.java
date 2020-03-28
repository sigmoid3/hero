package threads.rwsplit;

/**
 * @Author: minqian
 * @Create: 2020/3/28
 * @Description:
 **/
public interface ReadWriteLock {
    Lock readLock();

    Lock writeLock();

    int getWritingWriters();

    int getWaitingWriters();

    int getReadingReaders();

    static ReadWriteLock readWriteLock() {
        return new ReadWriteLockImpl();
    }

    static ReadWriteLock readWriteLock(boolean preferWriter) {
        return new ReadWriteLockImpl(preferWriter);
    }
}
