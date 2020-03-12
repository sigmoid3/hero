package base.listptr;

import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

import thinkings.base.listptr.GoDao;

/**
 * @Author: Sandro
 * @Create: 2019-08-13 20:16
 * @Info:
 **/
public class GoTest {
    public void test() {
        List<GoDao> goDaoList = new LinkedList<>();
        for (int i = 0; i < 5; i++) {
            GoDao goDao = new GoDao(String.valueOf(i), "sando");
            goDaoList.add(goDao);
        }
        System.out.println(goDaoList);
        System.out.println("==========================");
        moveItem(4,1,goDaoList);
        System.out.println(goDaoList);
        System.out.println("==========================");
        moveItem(3,2,goDaoList);
        System.out.println(goDaoList);
    }

    public void moveItem(int sourceIndex, int targetIndex, List<GoDao> list) {
        if (sourceIndex <= targetIndex) {
            Collections.rotate(list.subList(sourceIndex, targetIndex + 1), -1);
        } else {
            Collections.rotate(list.subList(targetIndex, sourceIndex + 1), 1);
        }
    }

    private void removeToPos(List<GoDao> list, int toIdx) {
        Iterator<GoDao> iterator = list.iterator();
        while (iterator.hasNext()) {
            GoDao goDao = iterator.next();
            try {
                GoDao goDao1 = (GoDao)goDao.clone();
                list.add(toIdx, goDao1);
            } catch (Exception e) {
                e.printStackTrace();
            }
            iterator.remove();
        }
    }
}
