package ������;

import java.util.ArrayList;
import java.util.Scanner;

class User{
	String userName="";
	String carNum="";
	int posX;
	int posY;
	

	void setPosX(int x) {
		this.posX=x;
	}
	int getPosX() {
		return posX;
	}
	void setPosY(int y) {
		this.posY=y;
	}
	int getPosY() {
		return posY;
	}
	
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
	ArrayList<User> list;
	
	ParkingLot(){
		list=new ArrayList<>();
	}
	
	void add(User u) {
		list.add(u);
	}
	
	boolean contains(User u) {
		return list.contains(u);
	}
	
	int size() {
		return list.size();
	}
	
	User uesrGet(User u){
		int index=list.indexOf(u);
		return list.get(index);
	}
	
	void remove(User u) {
		list.remove(u);
	}
}


class ParkControl{
	static ParkingLot park = new ParkingLot();
	static int parkingSize;
	static int cntCol =0;
	static int cntRow =0;
	static int col,row;
	
	
	static void insert(String name, String num) {
		if(park.size()<parkingSize) {
			
			User u = new User();
			u.setUserName(name);
			u.setCarNum(num);
			u.setPosX(cntCol);
			u.setPosY(cntRow);
			park.list.add(u);
			
			ParkControl.park.uesrGet(u);

			System.out.println(num + "�� ����" + "("+cntRow+", "+cntCol +")�� �����߽��ϴ�.\n");
			calc();
		}
		else {
			System.out.println("�����Դϴ�. ");
		}
	}
	
	static void calc() {
		if(cntCol==col-1) {
			cntRow++;
			cntCol=0;
			
		}
		else {
			cntCol++;
		}
	}
	
	static void firstDoParking() {
		
		for(int i=0;i<row;i++) {
			for(int j=0;j<col;j++) {
				System.out.print("(" + i + ", " + j + ") : ____" );
			}
			System.out.println();
		}
	}

	static void doParking() {
		
		int cnt=0;
		
		for(int i=0;i<row;i++) {
			
			for(int j=0;j<col;j++) {
				
				
				if(park.list.get(cnt).posX==j && park.list.get(cnt).posY==i ) {
					
					System.out.print("(" + i + ", " + j + ") : "+park.list.get(cnt).getCarNum()+"("+park.list.get(cnt).getUserName()+")" );
				
				}
				else {
					System.out.print("(" + i + ", " + j + ") : _________________" );
				}
				
				
				
				
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
		
		Scanner s = new Scanner(System.in);
		System.out.println("12191608 ���ؿ�");
		System.out.println("���ϸ� �����忡 ���� ���� ȯ���մϴ�!");
		System.out.print("������ ũ��(��� ��)�� �Է��ϼ��� : ");

		int row,col;
		row =s.nextInt();
		col= s.nextInt();
		
		System.out.println("���ؿ� �ٹ��� �����մϴ�!\n");
		
		ParkControl.parkingSize=row*col;
		ParkControl.col=col;
		ParkControl.row=row;
		
		User[] user= new User[row*col];
		
		for(int i=0;i<row*col;i++) {
			user[i]=new User();
		}
		
		boolean go = true;
		String num;
		
		ParkControl.firstDoParking();
		
		while(go) {
			
			System.out.print("���� ��ȣ�� �Է��ϼ���! : ");
			num=s.next();
			for(int i=0;i<numList.length;i++) {
				if(num.equals(numList[i])) {
					ParkControl.insert(userList[i],num);
				}
				
			}
			ParkControl.doParking();
		}
	
		
	
		
		
		s.close();
		
	}

}
