package parking;
import java.util.Scanner;
class User{
	String userName;
	String carNum;
	void setUserName(String name) {
		this.userName=name;
	}
	String getUserName() {
		return userName;
	}
	void setCarNum(String num) {
		this.carNum=num;
	}
	String getCarNum() {
		return carNum;
	}
}
class ParkingLot {
	User USER[][];
	ParkingLot(int row, int col) {
		USER = new User[row][col];
	}
	boolean isFull() {
		for (User[] user : USER) {
			for (User userOfUser : user) {
				if (userOfUser == null) {
					return false;
				}
			}
		}
		return true;
	}
	void parking(User user, String num) {
		for (int i = 0; i < USER.length; i++) {
			for (int j = 0; j < USER[i].length; j++) {
				if (USER[i][j] == null) {
					continue;
				}
				if (num.equals(USER[i][j].getCarNum())) {
					System.out.println("���� " +  USER[i][j].getUserName() + ", " +  USER[i][j].getCarNum() + "�� ���� �����߽��ϴ�.");
					USER[i][j] = null;
					return;
				}
			}
		}
		if (isFull()) {
			System.out.println("�����Դϴ�.");
			return;
		} 
		else {
			for (int i = 0; i < USER.length; i++) {
				for (int j = 0; j < USER[i].length; j++) {
					if (USER[i][j] == null) {
						USER[i][j] = user;
						System.out.print(USER[i][j].getCarNum()+"�� ���� (" +i+", "+j+")�� �����߽��ϴ�.");
						return;
					}
				}
			}
		}
	}
	void draw() {
		for (int i = 0; i < USER.length; i++) {
			for (int j = 0; j < USER[i].length; j++) {
				System.out.print("(" + i + ", " + j +") : ");
				if (USER[i][j] != null) {
					System.out.print(USER[i][j].getCarNum() + "(" +  USER[i][j].getUserName() + ")");
				}
				else {
					System.out.print("_____");
				}
				System.out.print(" ");
			}
			System.out.println();
		}
	}
}
public class Main {
	public static void main(String[] args) {
		String[] userList = {"��ī��","���α�","�ߵ���","�̻��ؾ�","ġ�ڸ�Ÿ",
				"���̸�","ĳ����","������","��","��������",
				"�Ḹ��","���ڿ�","����","������","������",
				"���","����","�ޱ��","��Ʒ簡","���Ƽ��"};
		String[] numList= {"1111","2222","3333","4444","5555",
				"6666","7777","8888","9999","1222",
				"1333","1444","1555","1666","1777",
				"1888","1999","2111","2333","2444"};
		Scanner s= new Scanner(System.in);
		System.out.println("�ǽ�����4 12191608 ���ؿ�");
		System.out.println("���ϸ� �����忡 ���� ���� ȯ���մϴ�!");
		System.out.print("������ ũ��(��� ��)�� �Է��ϼ��� : ");
		int row=s.nextInt();
		int col=s.nextInt();
		System.out.println("���ؿ� �ٹ��� �����մϴ�.\n");
		ParkingLot park= new ParkingLot(row,col);
		while(true) {
			park.draw();
			System.out.print("���� ��ȣ�� �Է��ϼ��� :");
			String num=s.next();
			if(num.equals("���")){
				System.out.println("���ؿ� ����մϴ�.");
				break;
			}
			try {
				int isItNum = Integer.parseInt(num);
			}
			catch(NumberFormatException e) {
				System.out.println("���ڸ� �Է��ϼ���. \n");
				continue;
			}
			User u= new User();
			boolean doParking=true;
			for(int i=0;i<numList.length;i++) {
				if(num.equals(numList[i])) {
					u.setCarNum(num);
					u.setUserName(userList[i]);
					doParking=true;
					break;
				}
				else {
					doParking=false;
				}
			}
			if(doParking) {
				park.parking(u,num);
				System.out.println();
			}
			else {
				System.out.println("��ϵ��� ���� �����Դϴ�.");
			}
			System.out.println();
		}
		s.close();
	}
}
