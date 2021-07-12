package threads.rwsplit;

/**
 * @Author: minqian
 * @Create: 2020/3/28
 * @Description:
 **/
public class ReadLock implements Lock {

    private final ReadWriteLockImpl readWriteLock;

    ReadLock(ReadWriteLockImpl readWriteLock) {
        this.readWriteLock = readWriteLock;
    }

    @Override
    public void lock() throws InterruptedException {
        synchronized (readWriteLock.getMutex()) {
            while (readWriteLock.getWritingWriters() > 0 || readWriteLock.getPreferWriter() && readWriteLock.getWaitingWriters() > 0) {
                readWriteLock.getMutex().wait();
            }
            readWriteLock.incrementReadingWriters();
        }
    }

    @Override
    public void unlock() {
        synchronized (readWriteLock.getMutex()) {
            readWriteLock.decrementReadingWriters();
            readWriteLock.changePrefer(true);
            readWriteLock.getMutex().notifyAll();
        }
    }
}
