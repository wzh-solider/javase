import java.util.Scanner;

public class MulForExercise01 {
	public static void main(String[] args) {
		Scanner myScanner = new Scanner(System.in);
		System.out.println("������ѧ���ɼ���");
		double[] score = new double[5];
		double[] eachClassSum = new double[3];
		double everyClassSum = 0;
		double classOneSum = 0, classTwoSum = 0, classThreeSum = 0;
		int t = 0;
		for (int j = 1; j <= 3; j++) {
			for (int i = 0; i < 5; i++) {
				System.out.print("�������" + j + "�����" + (i + 1) + "��ͬѧ�ĳɼ�");
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
		System.out.println("��ƽ���ɼ� = " + everClassAver);
		System.out.println("1��ƽ���ɼ� = " + classOneAver);
		System.out.println("2��ƽ���ɼ� = " + classTwoAver);
		System.out.println("3��ƽ���ɼ� = " + classThreeAver);
		System.out.println("������ļ�������Ϊ��" + t);
	}
}