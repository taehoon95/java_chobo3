package java_chobo3.ch08Exercise;

public class BankAccount {
	int minMoney;
	static int money;

	public BankAccount(int minMoney) {
		this.minMoney = minMoney;   
	}

	public void deposit(int i) { // 입금 메서드
		try {
			if (i < 0) {
				throw new InvalidWithdraw("입금금액이 음수로 입력되었습니다.");
			}else {
				money = money + i;
				System.out.printf("정상 입금처리: 입금금액 = %d, 잔금 = %d%n", i, money );
			}
		} catch (InvalidWithdraw e) {
			System.out.println("에러메세지 : " + e.getMessage());
		}
	}

	public void withdraw(int i){ // 출금 메서드		
		try {
			if (i < 0 || money - i < minMoney) {
				throw new InvalidWithdraw("요청액이 음수이거나 최저 잔금이하로 인출을 요청하셨습니다.");
			}else {
				money = money - i;
				System.out.printf("정상 출금처리: 출금금액 = %d, 잔금 = %d%n", i ,money );
			}
		} catch (InvalidWithdraw e) {
			e.printStackTrace();
		}
	}
}
