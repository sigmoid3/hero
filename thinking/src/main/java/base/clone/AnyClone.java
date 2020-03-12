package base.clone;/*
 * on 2019/3/17
 * By SIGMOD3
 * */

//choose deep clone and sequential method
public class AnyClone {
    public static void main(String[] args) {
        Address address = new Address("常州", "湖塘", "89");
        Custemor custemor = new Custemor(1, 23, address);
        System.out.println(custemor.toString());
        Custemor custemor1 = custemor.clone();
        System.out.println(custemor1.toString());
    }
}

class Custemor implements Cloneable {
    private int id;
    private int age;
    private Address address;

    public Custemor(int id, int age, Address address) {
        //super();
        this.address = address;
        this.id = id;
        this.age = age;
    }

    @Override
    public String toString() {
        return "Customer:[id:" + this.id + ",age:" + this.age + ",address:" + this.address + "]";
    }

    @Override
    public Custemor clone() {
        Custemor custemor = null;
        try {
            custemor = (Custemor) super.clone();
            custemor.address = address.clone();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
        return custemor;
    }
}

class Address {
    private String city;
    private String town;
    private String number;

    public Address(String city, String town, String number) {
        this.number = number;
        this.city = city;
        this.town = town;
    }

    @Override
    public String toString() {
        return "Address:[city:" + this.city + ",town:" + this.town + ",number" + this.number + "]";
    }

    @Override
    protected Address clone() {
        Address address = null;
        try {
            address = (Address) super.clone();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
        return address;
    }
}
