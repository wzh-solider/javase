import java.util.Scanner;

public class MulForExercise01 {
	public static void main(String[] args) {
		Scanner myScanner = new Scanner(System.in);
		System.out.println("请输入学生成绩：");
		double[] score = new double[5];
		double[] eachClassSum = new double[3];
		double everyClassSum = 0;
		double classOneSum = 0, classTwoSum = 0, classThreeSum = 0;
		int t = 0;
		for (int j = 1; j <= 3; j++) {
			for (int i = 0; i < 5; i++) {
				System.out.print("请输入第" + j + "个班第" + (i + 1) + "名同学的成绩");
				score[i] = myScanner.nextDouble();
				if (score[i] >= 60)
					t++;
				switch(j)
				{
				case 1: classOneSum += score[i];break;
				case 2: classTwoSum += score[i];break;
				case 3: classThreeSum += score[i];break;
				}
			}
		}
		everyClassSum = classOneSum + classTwoSum + classThreeSum;
		double everClassAver = everyClassSum / 3.0;
		double classOneAver = classOneSum / 5.0;
		double classTwoAver = classTwoSum / 5.0;
		double classThreeAver = classThreeSum / 5.0;
		System.out.println("总平均成绩 = " + everClassAver);
		System.out.println("1班平均成绩 = " + classOneAver);
		System.out.println("2班平均成绩 = " + classTwoAver);
		System.out.println("3班平均成绩 = " + classThreeAver);
		System.out.println("三个班的及格人数为：" + t);
	}
}