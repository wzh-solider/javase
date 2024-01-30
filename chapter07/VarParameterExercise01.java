public class VarParameterExercise01 {
	public static void main(String[] args) {
		Method m = new Method();
		String m1 = m.showScore("jian", 40.5, 50.5);
		String m2 = m.showScore("wang", 40.5, 50.5, 30);
		String m3 = m.showScore("li", 40.5, 50.5, 30, 40, 50);
		System.out.println(m1 + "\n" + m2 + "\n" + m3);
	}
}

class Method {
	public String showScore(String name, double... score) {
		double rel = 0;
		for (int i = 0; i < score.length; i++) 
			rel += score[i];
		return "姓名：" + name + "\n" + score.length + "门课程总成绩：" + rel;
	}
}