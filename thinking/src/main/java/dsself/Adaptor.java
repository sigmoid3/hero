package dsself;

/*
 * on 2019/3/18
 * By SIGMOD3
 * */

import java.awt.*;

public class Adaptor {
    public static void main(String[] args) {
        GPSCar gc =new GPSCar();
        gc.setName("Benz");
        gc.setSpeed(210);
        System.out.println(gc);
    }
}

//OCP is to choosed to used in something adding new function
class GPSCar extends Car implements GPS{
    @Override
    public Point getLocation(){
        Point point = new Point();
        point.setLocation(super.getSpeed(),super.getSpeed());
        return point;
    }
    @Override
    public String toString(){
        StringBuilder sb=new StringBuilder();
        sb.append(super.toString());
        sb.append(",坐标：（"+getLocation().x+","+getLocation().y+"）");
        return sb.toString();
    }
}

class Car{
    private String name;
    private double speed;

    public double getSpeed() {
        return speed;
    }

    public String getName() {
        return name;
    }

    public void setSpeed(double speed) {
        this.speed = speed;
    }

    public void setName(String name) {
        this.name = name;
    }
    @Override
    public String toString(){
        StringBuilder sb = new StringBuilder();
        sb.append("车名："+name+",");
        sb.append("速度："+speed+"千米/小时");
        return sb.toString();
    }
}
interface GPS{
    Point getLocation();
}