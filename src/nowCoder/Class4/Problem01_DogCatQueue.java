package nowCoder.Class4;

import java.util.LinkedList;
import java.util.Queue;

public class Problem01_DogCatQueue {
	public static class Pet {
		private String type;

		public Pet(String type) {
			this.type = type;
		}

		public String getPetType() {
			return this.type;
		}
	}

	public static class Dog extends Pet {
		public Dog() {
			super("Dog");
		}
	}

	public static class Cat extends Pet {
		public Cat() {
			super("Cat");
		}
	}

	public static class PetEnterQueue {
		private Pet pet;
		private int count;

		public PetEnterQueue(Pet pet, int count) {
			this.pet = pet;
			this.count = count;
		}

		public Pet getPet() {
			return this.pet;
		}

		public int getCount() {
			return this.count;
		}

		public String getEnterPetType() {
			return this.pet.getPetType();
		}
	}

	public static class DogCatQueue {
		private Queue<PetEnterQueue> dogQ;
		private Queue<PetEnterQueue> catQ;
		private int count;

		public DogCatQueue() {
			this.dogQ = new LinkedList<>();
			this.catQ = new LinkedList<>();
			this.count = 0;
		}

		public void add(Pet pet) {
			if (pet.getPetType() == "Dog") {
				this.dogQ.add(new PetEnterQueue(pet, this.count++));
			} else if (pet.getPetType() == "Cat") {
				this.catQ.add(new PetEnterQueue(pet, this.count++));
			} else {
				throw new RuntimeException("err, not dog or cat");
			}
		}

		public Pet pollAll() {
			if (!this.dogQ.isEmpty() && !this.catQ.isEmpty()) {
				if (this.dogQ.peek().getCount() < this.catQ.peek().getCount()) {
					return this.dogQ.poll().getPet();
				} else {
					return this.catQ.poll().getPet();
				}
			} else if (!this.dogQ.isEmpty()) {
				return this.dogQ.poll().getPet();
			} else if (!this.catQ.isEmpty()) {
				return this.catQ.poll().getPet();
			} else {
				throw new RuntimeException("err, queue is empty!");
			}
		}

		public Dog pollDog() {
			if (!this.dogQ.isEmpty()) {
				return (Dog) this.dogQ.poll().getPet();
			} else {
				throw new RuntimeException("Dog queue is empty!");
			}
		}

		public Cat pollCat() {
			if (!this.catQ.isEmpty()) {
				return (Cat) this.catQ.poll().getPet();
			} else {
				throw new RuntimeException("Cat queue is empty!");
			}
		}

		public boolean isEmpty() {
			return this.dogQ.isEmpty() && this.catQ.isEmpty();
		}

		public boolean isDogQueueEmpty() {
			return this.dogQ.isEmpty();
		}

		public boolean isCatQueueEmpty() {
			return this.catQ.isEmpty();
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		DogCatQueue test = new DogCatQueue();
		Pet dog1 = new Dog();
		Pet cat1 = new Cat();
		Pet dog2 = new Dog();
		Pet cat2 = new Cat();
		Pet dog3 = new Dog();
		Pet cat3 = new Cat();

		test.add(dog1);
		test.add(cat1);
		test.add(dog2);
		test.add(cat2);
		test.add(dog3);
		test.add(cat3);

		// while (!test.isDogQueueEmpty()) {
		// System.out.println(test.pollDog().getPetType());
		// }
		while (!test.isEmpty()) {
			System.out.println(test.pollAll().getPetType());
		}

	}

}
