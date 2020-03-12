package dsself;

/*
 * on 2019/3/18
 * By SIGMOD3
 * */

import java.util.Scanner;

public class Strategy {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String type = scan.nextLine();
        TypeChooser.getSaver(type).save();
        scan.close();
    }
}
//it is more applied to save funciton
interface ImageSaver{
    void save();
}

class GIFSaver implements ImageSaver{
    @Override
    public void save(){
        System.out.println("GIFSaver test save...");
    }
}

class JPEGSaver implements ImageSaver{
    @Override
    public void save(){
        System.out.println("JPEGSaver test save...");
    }
}

class PNGSaver implements ImageSaver{
    @Override
    public void save(){
        System.out.println("PNGSaver test save...");
    }
}

class TypeChooser{
    public static ImageSaver getSaver(String type){
        if(type.equalsIgnoreCase("GIF")) {
            return new GIFSaver();
        }else if(type.equalsIgnoreCase("JPEG")){
            return new JPEGSaver();
        }else if(type.equalsIgnoreCase("PNG")){
            return new PNGSaver();
        }else{
            return null;
        }
    }
}