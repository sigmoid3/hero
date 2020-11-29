package alg2020.threads.rwsplit;

/**
 * @Author: minqian
 * @Create: 2020/3/28
 * @Description:
 **/
public class ReadWriteLockImpl implements ReadWriteLock {
    private final Object MUTEX = new Object();
    private int writingWriters = 0;
    private int waitingWriters = 0;
    private int readingReaders = 0;
    private boolean preferWriter;

    public ReadWriteLockImpl() {
        this(true);
    }

    public ReadWriteLockImpl(boolean preferWriter) {
        this.preferWriter = preferWriter;
    }

    @Override
    public Lock readLock() {
        return new ReadLock(this);
    }

    @Override
    public Lock writeLock() {
        return new WriteLock(this);
    }

    @Override
    public int getWritingWriters() {
        return this.writingWriters;
    }

    @Override
    public int getWaitingWriters() {
        return this.waitingWriters;
    }

    @Override
    public int getReadingReaders() {
        return this.readingReaders;
    }

    Object getMutex() {
        return this.MUTEX;
    }

    boolean getPreferWriter() {
        return this.preferWriter;
    }

    void changePrefer(boolean preferWriter) {
        this.preferWriter = preferWriter;
    }

    void incrementWaitingWriters() {
        this.writingWriters++;
    }

    void incrementReadingWriters() {
        this.readingReaders++;
    }

    void decrementWritingWriters() {
        this.writingWriters--;
    }

    void decrementWaitingWriters() {
        this.waitingWriters--;
    }

    void decrementReadingWriters() {
        this.readingReaders--;
    }
}
