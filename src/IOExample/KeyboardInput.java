package IOExample;

import java.util.Scanner;

public class KeyboardInput {

	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		System.out.println("输入您的姓名");
		String name = sc.nextLine();
		System.out.println("输入您的年龄");
		int age = sc.nextInt();
		System.out.println("输入您的身高");
		float height = sc.nextFloat();
		
		System.out.println(name + age + height);
	}
}
