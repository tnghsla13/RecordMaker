package employee;

public class Employees {

	private int idNum, score;

	public Employees() {

		this.idNum = 0;
		this.score = 0;
	}

	public static void main(String[] args) {

		printGuideLine(args);

	}

	private static void printGuideLine(final String[] args) {

		if (args.length == 0) {
			System.out.println("You didn't input count !");
			System.out
					.println("You can use this format -> java [program name] [count]");
			System.out.println("Try one more");

		} else if (args.length > 1) {
			System.out.println("Too many input !");
			System.out
					.println("You can use this format -> java [program name] [count]");
			System.out.println("Try one more");

		} else {

			try {

				int count = Integer.parseInt(args[0]);
				printScores(count);

			} catch (NumberFormatException e) {

				System.out
						.println("java [program name] [count] -> In this format, 'count' must be integer");
				System.out.println("Try one more");
			}

		}
	}

	private static void printScores(final int count) {

		int idNum = 0, score = 0;
		Employees[] empArr = new Employees[99999];

		if (count > 0) {

			System.out.printf("Scores of %d employees are like followings\n\n",
					count);
			System.out.printf("%-7s %-3s\n", "ID", "Scores");
			System.out.println("---------------");

			for (int i = 0; i < count; i++) {

				idNum = (int) (Math.random() * 100000);
				score = (int) (Math.random() * 100);

				empArr[i] = new Employees();

				while (sequentialSearch(empArr, idNum)) {

					idNum = (int) (Math.random() * 100000);
				}
				empArr[i].setIdNum(idNum);
				empArr[i].setScore(score);

				System.out.printf("NT%05d %d\n", empArr[i].getIdNum(),
						empArr[i].getScore());
			}

		} else if (count > 99999) {

			System.out.println("We don't have so much employees");

		} else {

			System.out.printf("None...");
		}
	}

	private static boolean sequentialSearch(final Employees[] empArr,
			final int idNum) {

		int i = 0;
		while (empArr[i] != null) {

			if (empArr[i].getIdNum() == idNum)
				return true;

			i++;
		}

		return false;
	}

	public int getIdNum() {
		return idNum;
	}

	public void setIdNum(int idNum) {
		this.idNum = idNum;
	}

	public int getScore() {
		return score;
	}

	public void setScore(int score) {
		this.score = score;
	}
}