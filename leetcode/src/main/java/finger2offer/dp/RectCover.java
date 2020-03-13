package finger2offer.dp;

public class RectCover {
    public static void main(String[] args) {
        RectCover rc = new RectCover();
        System.out.println(rc.RectCover(7));
    }

    public int RectCover(int target) {
        if (target < 3) {
            return target;
        }
        return RectCover(target - 1) + RectCover(target - 2);
    }
}