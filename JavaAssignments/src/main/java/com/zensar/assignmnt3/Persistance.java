package com.zensar.assignmnt3;

import java.util.Random;

public abstract class Persistance {

	abstract void persist();

	static Persistance getPersistanceInstance() {

		//

		Random random = new Random();

		int randomNumber = random.nextInt(3);
		Persistance p;

		if (randomNumber == 2) {
			p = new FilePersistence();
		} else {
			p = new DatabasePersistence();
		}

		return p;
	}

}
