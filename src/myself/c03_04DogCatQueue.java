package myself;

import java.util.LinkedList;
import java.util.Queue;

public class c03_04DogCatQueue {

    public static class Pet {
        private String type;

        public Pet(String type) {
            this.type = type;
        }

        public String getType() {
            return this.type;
        }
    }

    public static class dog extends Pet {
        public dog() {
            super("dog");
        }
    }

    public static class cat extends Pet {
        public cat() {
            super("cat");
        }
    }

    public static class PetInsertType {
        private Pet pet;
        private int count;

        public PetInsertType(Pet pet, int count) {
            this.pet = pet;
            this.count = count;
        }

        public Pet getPet() {
            return pet;
        }

        public int getCount() {
            return count;
        }

        public String getInsertPetType() {
            return this.pet.getType();
        }
    }

    public static class DagCatQueue {

        public Queue<PetInsertType> DogQueue;
        public Queue<PetInsertType> CatQueue;
        public int count;

        public DagCatQueue() {
            DogQueue = new LinkedList<PetInsertType>();
            CatQueue = new LinkedList<PetInsertType>();
            count = 0;
        }

        //添加操作
        public void add(Pet pet) {
            if (pet.getType().equals("dog")) {
                DogQueue.add(new PetInsertType(pet, count++));
            } else if (pet.getType().equals("cat")) {
                CatQueue.add(new PetInsertType(pet, count++));
            } else {
                throw new RuntimeException("what the type? err!");
            }
        }

        //弹出操作
        public Pet pollAll() {
            if (!DogQueue.isEmpty() && !CatQueue.isEmpty()) {
                int dc = DogQueue.peek().getCount();
                int cc = CatQueue.peek().getCount();
                return dc > cc ? DogQueue.poll().getPet() : CatQueue.poll().getPet();
            } else if (!DogQueue.isEmpty()) {
                return DogQueue.poll().getPet();
            } else if (!CatQueue.isEmpty()) {
                return CatQueue.poll().getPet();
            }

            throw new RuntimeException("empty!!!!!");
        }

        //弹狗
        public dog pollDog(){
            if(!DogQueue.isEmpty()){
                return (dog)DogQueue.poll().getPet();
            }
            throw new RuntimeException("dog empty!!!!");
        }

        //弹猫
        public cat pollCat(){
            if(!CatQueue.isEmpty()){
                return (cat)CatQueue.poll().getPet();
            }
            throw new RuntimeException("cat empty!!!!");
        }

        public boolean isEmpty(){
            return DogQueue.isEmpty()&&CatQueue.isEmpty();
        }

        public boolean isDogQueueEmpty(){
            return DogQueue.isEmpty();
        }

        public boolean isCatQueueEmpty(){
            return CatQueue.isEmpty();
        }

    }

    public static void main(String[] args) {
        DagCatQueue test = new DagCatQueue();

        Pet dog1 = new dog();
        Pet cat1 = new cat();
        Pet dog2 = new dog();
        Pet cat2 = new cat();
        Pet dog3 = new dog();
        Pet cat3 = new cat();

        test.add(dog1);
        test.add(cat1);
        test.add(dog2);
        test.add(cat2);
        test.add(dog3);
        test.add(cat3);

        test.add(dog1);
        test.add(cat1);
        test.add(dog2);
        test.add(cat2);
        test.add(dog3);
        test.add(cat3);

        test.add(dog1);
        test.add(cat1);
        test.add(dog2);
        test.add(cat2);
        test.add(dog3);
        test.add(cat3);
        while (!test.isDogQueueEmpty()) {
            System.out.println(test.pollDog().getType());
        }
        while (!test.isEmpty()) {
            System.out.println(test.pollAll().getType());
        }
    }
}