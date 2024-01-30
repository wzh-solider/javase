import java.util.Scanner; // 表示把java.util包下的 Scanner类导入
public class Input {
	// 编写一个main方法
	public static void main(String[] args) {
		// Scanner 类 是一个 简单的文本扫描器 在java.util包
		// 1.引入/导入 Scanner类所在的包
		// 2.new 创建 Scanner 对象
		// 3.接收用户的输入，使用相关的方法
		Scanner myScanner = new Scanner(System.in);
		System.out.println("请输入名字"); 

		// 程序执行到 next 方法时，会接收从键盘上扫描的内容
		String name = myScanner.next();// 接收用户的输入内容
		System.out.println("请输入年龄");
		int age = myScanner.nextInt();// 接收用户的输入内容
		System.out.println("请输入薪水");
		double sal = myScanner.nextDouble();// 接收用户的输入内容
		System.out.println("用户的信息如下：");
		System.out.println(" 名字 = " + name + " 年龄 = " + age + 
		" 薪水 = " + sal);
	}
}