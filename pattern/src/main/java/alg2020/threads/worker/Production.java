package alg2020.threads.worker;

/**
 * @Author: minqian
 * @Create: 2020/3/29
 * @Description:
 **/
public class Production extends InstructionBook {
    //产品编号
    private final int prodID;

    public Production(int prodID) {
        this.prodID = prodID;
    }

    @Override
    protected void firstProcess() {
        System.out.println("execute the " + prodID + " first process");
    }

    @Override
    protected void secondProcess() {
        System.out.println("execute the " + prodID + " second process");
    }

    @Override
    public String toString() {
        return "PROD:" + prodID;
    }
}