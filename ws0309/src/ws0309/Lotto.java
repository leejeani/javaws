package ws0309;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Random;

public class Lotto {
	private HashSet<Integer> winningNum;
	private double prizeMoney; 
	public Lotto() {
		winningNum = new HashSet<Integer>();
	}
	
	public double getPrizeMoney() {
		return prizeMoney;
	}

	public void makeWinningNumberMoney(){
		Random r = new Random();
		prizeMoney = r.nextInt(2000000000)+1;
		while(winningNum.size() < 3) {
			int num = r.nextInt(25)+1;
			winningNum.add(num);
		}
		System.out.printf("%f\n",prizeMoney);
		for(int num:winningNum) {
			System.out.println(num);
		}
	}
	public int checkRanking(ArrayList<Integer> myNum){
		int grade = 0;
		int cnt = 0;
		for(int n:myNum) {
			for(int num:winningNum) {
				if(n == num) {
					cnt++;
				}
			}
		}
		if(cnt == 3) {
			grade = 1;
		}else if(cnt == 2) {
			grade = 2;
		}else if(cnt == 1) {
			grade = 3;
		}else {
			grade = 0;
		}
		return grade;
	}
	public double prizeMoney(int grade) {
		double money = 0.0;
		switch(grade) {
		case 1: money = prizeMoney * 0.7; break;
		case 2: money = prizeMoney * 0.2; break;
		case 3: money = prizeMoney * 0.1; break;
		default: money = 0;
		}
		return money;
	}
}












