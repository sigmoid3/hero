package old.tree;/*
//https://github.com/CarpenterLee/JCFInternals/blob/master/markdown/5-TreeSet%20and%20TreeMap.md


import static java.awt.Color.BLACK;
import static java.awt.Color.RED;

public class RedBlack {
    public static void main(String[] args) {
    }

    //Rotate left
    private void rotateLeft(Entry<K, V> p) {
        if (p != null) {
            Entry<K, V> r = p.right;    //设置右节点为根节点
            p.right = r.left;           //分支迁移到左子树
            if (r.left != null)         //若左子树不空，则设置左子树
                r.left.parent = p;
            r.parent = p.parent;        //该树的父亲
            if (p.parent == null)       //若没有父亲，则该树的根节点为所有树的根节点
                root = r;
            else if (p.parent.left == p)    //p为原左子树根节点，现改为r
                p.parent.left = r;
            else
                p.parent.right = r;         //p为原右子树根节点，现改为r
            r.left = p;                     //连接p和r
            p.parent = r;
        }
    }

    //Rotate Right
    private void rotateRight(Entry<K, V> p) {
        if (p != null) {
            Entry<K, V> l = p.left;     //设置左节点为根节点
            p.left = l.right;           //分支迁移到右子树
            if (l.right != null)        //若右子树不空，则设置右子树
                l.right.parent = p;
            l.parent = p.parent;        //该树的父亲
            if (p.parent == null)       //若没有父亲，则该树的根节点为所有树的根节点
                root = l;
            else if (p.parent.right == p)   //p为原右子树根节点，现改为l
                p.parent.right = l;
            else
                p.parent.left = l;          //p为原左子树根节点，现改为l
            l.right = p;                    //连接p和l
            p.parent = l;
        }
    }

    //Find Successor
    private static <K, V> TreeMap.Entry<K, V> successor(Entry<K, V> t) {
        if (t == null)
            return null;
        else if (t.right != null) {         //t的右子树不空，则t的后继是其右子树中最小的那个元素
            Entry<K, V> p = t.right;
            while (p.left != null)          //列有序时即为最左边
                p = p.left;
            return p;
        } else {                            //t的右子树为空，则t的后继是其第一个向左走的祖先
            Entry<K, V> p = t.parent;
            Entry<K, V> ch = t;
            while (p != null && ch == p.right) {    //树的本质是垂直扩展，判断存在父节点，并且父节点的右孩子是ch节点
                ch = p;                             //迭代寻找p.parent节点，得到在p右边一列的第一个节点为后继节点
                p = p.parent;
            }
            return p;
        }
    }

    //getEntry()是根据key的自然顺序（或者比较器顺序）对二叉查找树进行查找，直到找到满足k.compareTo(p.key) == 0的entry
    //getEntry()方法
    final Entry<K, V> getEntry(Object key) {
        //......
        if (key == null)
            throw new NullPointerException();                       //不允许Key值为空
        Comparable<? super K> k = (Comparable<? super K>) key;      //使用元素的自然顺序
        Entry<K, V> p = root;
        while (p != null) {
            int cmp = k.compareTo(p.key);
            if (cmp < 0)        //向左找
                p = p.left;
            else if (cmp > 0)   //向右找
                p = p.right;
            else
                return p;
        }
        return null;
    }

    public V put(K key, V value) {
        //......
        int cmp;
        Entry<K, V> parent;
        if (key == null)
            throw new NullPointerException();
        Comparable<? super K> k = (Comparable<? super K>) key;  //使用元素的自然顺序
        do {
            parent = t;
            cmp = k.compareTo(t.key);
            if (cmp < 0) t = t.left;
            else if (cmp > 0) t = t.right;
            else return t.setValue(value);
        } while (t != null);                    //查找合适的value位置

        Entry<K, V> e = new Entry<>(key, value, parent);        //创建并插入新的entry
        if (cmp < 0)
            parent.left = e;
        else
            parent.right = e;
        fixAfterInsertion(e);                   //调整函数具体应该是需要改变节点的颜色和节点的结构，需要进行旋转
        size++;
        return null;
    }

    */
/*    红黑树规则:
     *1.只有红色和黑色，新插入的节点是红色的
     *2.根节点是黑色
     *3.红节点不能连续
     *4.对于任意节点，从该节点到nil的任何路径含有相同个数的黑节点
     *另外，情况1-3相应改变
     **//*



    //红黑树调整函数fixAfterInsertion()
    private void fixAfterInsertion(Entry<K, V> x) {
        x.color = RED;
        while (x != null && x != root && x.parent.color == RED) {   //插入的不是空节点，不是根节点,为红节点
            if (parentOf(x) == leftOf(parentOf(parentOf(x)))) {
                Entry<K, V> y = rightOf(parentOf(parentOf(x)));
                if (colorOf(y) == RED) {
                    setColor(parentOf(x), BLACK);              // 情况1   颜色变换
                    setColor(y, BLACK);                        // 情况1
                    setColor(parentOf(parentOf(x)), RED);      // 情况1
                    x = parentOf(parentOf(x));                 // 情况1
                } else {
                    if (x == rightOf(parentOf(x))) {
                        x = parentOf(x);                       // 情况2   左旋右旋调整
                        rotateLeft(x);                         // 情况2
                    }
                    setColor(parentOf(x), BLACK);              // 情况3
                    setColor(parentOf(parentOf(x)), RED);      // 情况3
                    rotateRight(parentOf(parentOf(x)));        // 情况3
                }
            } else {
                Entry<K, V> y = leftOf(parentOf(parentOf(x)));
                if (colorOf(y) == RED) {
                    setColor(parentOf(x), BLACK);              // 情况4   另一种相对情况
                    setColor(y, BLACK);                        // 情况4
                    setColor(parentOf(parentOf(x)), RED);      // 情况4
                    x = parentOf(parentOf(x));                 // 情况4
                } else {
                    if (x == leftOf(parentOf(x))) {
                        x = parentOf(x);                       // 情况5
                        rotateRight(x);                        // 情况5
                    }
                    setColor(parentOf(x), BLACK);              // 情况6
                    setColor(parentOf(parentOf(x)), RED);      // 情况6
                    rotateLeft(parentOf(parentOf(x)));         // 情况6
                }
            }
        }
        root.color = BLACK;     //根节点颜色设置
    }

    //红黑树entry删除函数deleteEntry(),寻找到大于p的最小value的节点s，重新指向
    private void deleteEntry(Entry<K, V> p) {
        modCount++;
        size--;
        if (p.left != null && p.right != null) {        //删除点p的左右子树都非空。
            Entry<K, V> s = successor(p);               //后继
            p.key = s.key;
            p.value = s.value;
            p = s;
        }
        Entry<K, V> replacement = (p.left != null ? p.left : p.right);
        if (replacement != null) {                      //删除点p只有一棵子树非空。
            replacement.parent = p.parent;
            if (p.parent == null)
                root = replacement;
            else if (p == p.parent.left)
                p.parent.left = replacement;            //修改父子间引用关系
            else
                p.parent.right = replacement;
            p.left = p.right = p.parent = null;
            if (p.color == BLACK)                       //只有删除点是BLACK的时候，才会触发调整函数
                fixAfterDeletion(replacement);          //调整
        } else if (p.parent == null) {
            root = null;
        } else {                                        //删除点p的左右子树都为空
            if (p.color == BLACK)
                fixAfterDeletion(p);                    // 调整
            if (p.parent != null) {
                if (p == p.parent.left)
                    p.parent.left = null;
                else if (p == p.parent.right)
                    p.parent.right = null;
                p.parent = null;
            }
        }
    }

    private void fixAfterDeletion(Entry<K, V> x) {
        while (x != root && colorOf(x) == BLACK) {
            if (x == leftOf(parentOf(x))) {
                Entry<K, V> sib = rightOf(parentOf(x));
                if (colorOf(sib) == RED) {
                    setColor(sib, BLACK);                   // 情况1
                    setColor(parentOf(x), RED);             // 情况1
                    rotateLeft(parentOf(x));                // 情况1
                    sib = rightOf(parentOf(x));             // 情况1
                }
                if (colorOf(leftOf(sib)) == BLACK &&
                        colorOf(rightOf(sib)) == BLACK) {
                    setColor(sib, RED);                     // 情况2
                    x = parentOf(x);                        // 情况2
                } else {
                    if (colorOf(rightOf(sib)) == BLACK) {
                        setColor(leftOf(sib), BLACK);       // 情况3
                        setColor(sib, RED);                 // 情况3
                        rotateRight(sib);                   // 情况3
                        sib = rightOf(parentOf(x));         // 情况3
                    }
                    setColor(sib, colorOf(parentOf(x)));    // 情况4
                    setColor(parentOf(x), BLACK);           // 情况4
                    setColor(rightOf(sib), BLACK);          // 情况4
                    rotateLeft(parentOf(x));                // 情况4
                    x = root;                               // 情况4
                }
            } else { // 跟前四种情况对称
                Entry<K, V> sib = leftOf(parentOf(x));
                if (colorOf(sib) == RED) {
                    setColor(sib, BLACK);                   // 情况5
                    setColor(parentOf(x), RED);             // 情况5
                    rotateRight(parentOf(x));               // 情况5
                    sib = leftOf(parentOf(x));              // 情况5
                }
                if (colorOf(rightOf(sib)) == BLACK &&
                        colorOf(leftOf(sib)) == BLACK) {
                    setColor(sib, RED);                     // 情况6
                    x = parentOf(x);                        // 情况6
                } else {
                    if (colorOf(leftOf(sib)) == BLACK) {
                        setColor(rightOf(sib), BLACK);      // 情况7
                        setColor(sib, RED);                 // 情况7
                        rotateLeft(sib);                    // 情况7
                        sib = leftOf(parentOf(x));          // 情况7
                    }
                    setColor(sib, colorOf(parentOf(x)));    // 情况8
                    setColor(parentOf(x), BLACK);           // 情况8
                    setColor(leftOf(sib), BLACK);           // 情况8
                    rotateRight(parentOf(x));               // 情况8
                    x = root;                               // 情况8
                }
            }
        }
        setColor(x, BLACK);
    }

    // TreeSet是对TreeMap的简单包装
    public class TreeSet<E> extends AbstractSet<E>
            implements NavigableSet<E>, Cloneable, java.io.Serializable {
        //......
        private transient NavigableMap<E, Object> m;
        // Dummy value to associate with an Object in the backing Map
        private static final Object PRESENT = new Object();

        public TreeSet() {
            this.m = new TreeMap<E, Object>();// TreeSet里面有一个TreeMap
        }

        //......
        public boolean add(E e) {
            return m.put(e, PRESENT) == null;
        }
        //......
    }


}

*/