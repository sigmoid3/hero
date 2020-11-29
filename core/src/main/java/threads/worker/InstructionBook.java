package alg2020.threads.worker;

/**
 * @Author: minqian
 * @Create: 2020/3/29
 * @Description:
 **/
public abstract class InstructionBook {
    public final void create() {
        this.firstProcess();
        this.secondProcess();
    }

    protected abstract void firstProcess();

    protected abstract void secondProcess();
}
