public class ArithmeticOperatorExercise02 {
	public static void main(String[] args) {
		int holiday = 59;
		int holiday_residue = holiday % 7;
		int date = holiday / 7;
		System.out.println("合" + date + "个星期零" + holiday_residue + "天");
	}
}
class Print_DegreeCentigrade {
	public static void main(String[] args) {
		double Fahrenheit = 234.6;
		double DegreeCentigrade = 5.0 / 9 * (Fahrenheit - 100);
		System.out.println("摄氏温度为：" + DegreeCentigrade);
}
}