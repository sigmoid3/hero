package io.lock;

/**
 * @Author: sandro
 * @Create: 2019-09-28
 * @Description:
 **/
public class WriteLock implements Lock {
    private final ReadWriteLockImpl readWriteLock;

    WriteLock(ReadWriteLockImpl readWriteLock) {
        this.readWriteLock = readWriteLock;
    }

    @Override
    public void lock() throws InterruptedException {
        synchronized (readWriteLock.getMutex()) {
            try {
                readWriteLock.incrementWritingWriters();
                while (readWriteLock.getReadingReaders() > 0 || readWriteLock.getWaitingWriters() > 0) {
                    readWriteLock.getMutex().wait();
                }
            } finally {
                this.readWriteLock.decrementWaitingWriters();
            }
            readWriteLock.incrementWritingWriters();
        }
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
