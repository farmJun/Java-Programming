package upDown;

import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.util.InputMismatchException;
import java.util.Scanner;
import java.io.IOException;

public class upDown {
	
	public static void main(String[] args)throws IOException {
		System.out.println("�й� : 12191608, �̸� : ���ؿ�");
		try {
			FileWriter writer = new FileWriter("log.txt");
			writer.write("�й� : 12191608, �̸� : ���ؿ�\n");
			System.out.println("Guess What(1~100)!");	
			int randomNum = (int)(Math.random()*100)+1;
			int count =0;
			int game = 0;
			boolean again=true;
			String tryAgain;
			Scanner scanner = new Scanner(System.in);
			do {
				System.out.print("Input>");
				int num;
			try {
				num=scanner.nextInt();
			}
			catch (InputMismatchException e) {
				System.out.println("���ڸ� �Է��ϼ���.");
				scanner.next();
				continue;
			}
			if(num>randomNum) {
				System.out.println("Down");
				count++;
			}
			else if(num<randomNum){
				System.out.println("Up");
				count++;
			}
			else if(num==randomNum){
				count++;
				System.out.println("����!! " + count +"������ ����!");
				System.out.print("�ٽ��ϰڽ��ϱ�?(y/n)>");
				writer.write("���ӹ�ȣ "+game+" : ���� "+count+"������ ����\n");
				game++;
				tryAgain = scanner.next();
				randomNum = (int)(Math.random()*100)+1;
				assert (tryAgain.equals("y")||tryAgain.equals("n")):"y�� n�� �Է� �����մϴ�.";
				if(tryAgain.equals("n")) {
				again=false;
					}
				}
			}
			while(again);
				scanner.close();
				writer.close();
			} 
		catch (FileNotFoundException e){
			System.out.println("������ ã�� �� �����ϴ�.");		
		}
	} 
}

