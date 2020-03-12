package base.listptr;
/**
 * @Author: Sandro
 * @Create: 2019-08-13 20:16
 * @Info:
 **/

public class GoDao implements Cloneable{
    @Override
    public Object clone() {
        try {
            return super.clone();
        } catch (CloneNotSupportedException e) {
            return null;
        }
    }
    public GoDao(String age,String name){
        this.age = age;
        this.name = name;
    }
    private String age;
    private String name;
}
