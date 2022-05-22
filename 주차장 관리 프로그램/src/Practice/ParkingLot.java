package Practice;

class Guest{
	String userName="___";
	int carNum;

	void setUserName(String name) {
		this.userName=name;
	}
	String getUserName() {
		return userName;
	}
	void setCarNum(int num) {
		this.carNum=num;
	}
	int getCarNum() {
		return carNum;
	}
}

public class ParkingLot {
	private Guest parkingLot[][];

	public ParkingLot(int a, int b) {
		parkingLot = new Guest[a][b];

	}

	public boolean full() {
		for (Guest[] a : parkingLot) {
			for (Guest b : a) {
				if (b == null) {
					return false;
				}
			}
		}
		return true;
	}

	public void printParkingLot() {
		for (int i = 0; i < parkingLot.length; i++) {
			for (int j = 0; j < parkingLot[i].length; j++) {
				System.out.print("(" + i + ", " + j + ") : ");
				if (parkingLot[i][j] != null) {
					Guest temp = parkingLot[i][j];
					System.out.print(temp.getCarNum() + "(" + temp.getUserName() + ")");
				} else {
					System.out.print("________");
				}
				System.out.print("  ");
			}
			System.out.println();
		}
	}

	public void parking(Guest guest, String str) {
		int num = Integer.parseInt(str);

		for (int i = 0; i < parkingLot.length; i++) {
			for (int j = 0; j < parkingLot[i].length; j++) {
				Guest temp = parkingLot[i][j];
				
				if (temp == null) {
					continue;
				}
				if (num == temp.getCarNum()) {
					System.out.println("���� " + temp.getUserName() + ", " + temp.getCarNum() + "�� ���� �����߽��ϴ�.");
					parkingLot[i][j] = null;
					return;
				}
			}
		}
		if (full()) {
			System.out.println("�����Դϴ�.");
			return;
		} else {
			for (int i = 0; i < parkingLot.length; i++) {
				for (int j = 0; j < parkingLot[i].length; j++) {
					if (parkingLot[i][j] == null) {
						parkingLot[i][j] = guest;
						return;
					}
				}
			}
		}
	}

}
