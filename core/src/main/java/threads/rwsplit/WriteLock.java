package alg2020.threads.rwsplit;

/**
 * @Author: minqian
 * @Create: 2020/3/28
 * @Description:
 **/
public class WriteLock implements Lock {
    private final ReadWriteLockImpl readWriteLock;

    WriteLock(ReadWriteLockImpl readWriteLock) {
        this.readWriteLock = readWriteLock;
    }

    @Override
    public void lock() throws InterruptedException {
        try {
            readWriteLock.incrementReadingWriters();
            while (readWriteLock.getReadingReaders() > 0 || readWriteLock.getWritingWriters() > 0) {
                readWriteLock.getMutex().wait();
            }
        } finally {
            this.readWriteLock.decrementWaitingWriters();
        }
        readWriteLock.incrementReadingWriters();
    }

    @Override
    public void unlock() {
        synchronized (readWriteLock.getMutex()) {
            readWriteLock.decrementWritingWriters();
            readWriteLock.changePrefer(false);
            readWriteLock.getMutex().notifyAll();
        }
    }
}
