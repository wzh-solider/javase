import java.util.Scanner; // ��ʾ��java.util���µ� Scanner�ർ��
public class Input {
	// ��дһ��main����
	public static void main(String[] args) {
		// Scanner �� ��һ�� �򵥵��ı�ɨ���� ��java.util��
		// 1.����/���� Scanner�����ڵİ�
		// 2.new ���� Scanner ����
		// 3.�����û������룬ʹ����صķ���
		Scanner myScanner = new Scanner(System.in);
		System.out.println("����������"); 

		// ����ִ�е� next ����ʱ������մӼ�����ɨ�������
		String name = myScanner.next();// �����û�����������
		System.out.println("����������");
		int age = myScanner.nextInt();// �����û�����������
		System.out.println("������нˮ");
		double sal = myScanner.nextDouble();// �����û�����������
		System.out.println("�û�����Ϣ���£�");
		System.out.println(" ���� = " + name + " ���� = " + age + 
		" нˮ = " + sal);
	}
}