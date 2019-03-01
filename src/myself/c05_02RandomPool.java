package myself;

import java.util.HashMap;

public class c05_02RandomPool {

    public static class RandomPool<K> {

        private HashMap<K, Integer> keyIndexMap;
        private HashMap<Integer, K> indexKeyMap;
        public int size;

        public RandomPool() {
            keyIndexMap = new HashMap<K, Integer>();
            indexKeyMap = new HashMap<Integer, K>();
            size = 0;
        }

        public void insert(K key) {
            keyIndexMap.put(key, ++size);
            indexKeyMap.put(size, key);
        }

        public K getRandom() {
            if (size == 0) {
                return null;
            }
            int randomnum = (int)(Math.random() * size)+1;
//            System.out.printf( randomnum + "");
            return indexKeyMap.get(randomnum);//0~size-1
        }

        public boolean delete(K key) {
            if (size == 0) {
                System.out.printf("Pool Is Empty");
                return false;
            }
            //先拿到key对应的Index
            int delIndex = keyIndexMap.get(key);
            K lastKey = indexKeyMap.get(size);
            //把最后的换到要删除的位置
            keyIndexMap.put(lastKey, delIndex);
            indexKeyMap.put(delIndex, lastKey);

            keyIndexMap.remove(key);
            indexKeyMap.remove(size);
            size--;
            return true;
        }

        public static void main(String[] args) {
            RandomPool<String> pool = new RandomPool<String>();
            pool.insert("A");
            pool.insert("B");
            pool.insert("C");
            System.out.println(pool.getRandom());
            System.out.println(pool.getRandom());
            System.out.println(pool.getRandom());
            System.out.println(pool.getRandom());
            System.out.println(pool.getRandom());
            System.out.println("=========================");
            pool.delete("A");
            System.out.println(pool.getRandom());
            System.out.println(pool.getRandom());
            System.out.println(pool.getRandom());
            System.out.println(pool.getRandom());
            System.out.println(pool.getRandom());
        }
    }

}





















