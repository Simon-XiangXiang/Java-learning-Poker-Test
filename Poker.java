package com.xiangxiang.test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

public class Poker {

	public static void main(String[] args) {
		
		Scanner	sc = new Scanner(System.in);
		 
		
		//装牌容器
		HashMap<Integer, String> card = new HashMap<Integer, String>();
		
		//用于洗牌
		ArrayList<Integer> list = new ArrayList<Integer>();
		
		//定义花色数组和点数数组
		String[] color = {"红桃","黑桃","方片","梅花"};
		String[] num = {"3","4","5","6","7","8","9","10","J","Q","K","A","2"};
		
		//定义一个索引代表每张牌的大小,便于洗牌之后对牌排序
		int index = 0;
		 
		//创建54张牌
		for (String s1 : num) {
			for (String s2 : color) {
				card.put(index, s2.concat(s1));
				list.add(index);
				index++;
			}
		}
		card.put(index, "小王");
		list.add(index);
		index++;
		card.put(index, "大王");
		list.add(index);

		//洗牌(洗的是编号)
		Collections.shuffle(list);
		
		//发牌(发的也是编号)
		TreeSet<Integer> gaojin = new TreeSet<Integer>();
		TreeSet<Integer> longwu = new TreeSet<Integer>();
		TreeSet<Integer> you = new TreeSet<Integer>();
		TreeSet<Integer> dipai = new TreeSet<Integer>();
		
		for (Integer i : list) {
			if (i < 3) {
				dipai.add(i);
			}else if (i % 3 == 0) {
				gaojin.add(i);
			}else if (i % 3 == 1) {
				longwu.add(i);
			}else {
				you.add(i);
			}
		}
		
		//看牌
		lookPoker("你的", you, card);
		System.out.println("------------------------------------------------");
		System.out.println("是否叫地主?");
		System.out.println("1.叫地主                          2.不叫地主");
		boolean flag = true;
		while (flag) {
			int i = sc.nextInt();
			if (i == 1) {
				System.out.println("------------------------------------------------");
				you.addAll(dipai);
				lookPoker("底", dipai, card);
				System.out.println("------------------------------------------------");
				lookPoker("你的", you, card);
				flag = false;
			} else if (i == 2) {
				System.out.println("------------------------------------------------");
				System.out.println("高进叫了地主");
				gaojin.addAll(dipai);
				System.out.println("------------------------------------------------");
				lookPoker("底", dipai, card);
				flag = false;
			} else {
				System.out.println("------------------------------------------------");
				System.out.println("输入有误请重新输入");
			}
		}
		
		

		
		
		
		System.out.println("------------------------------------------------");
		System.out.println("出老千看到了高进和龙五的牌");
		System.out.println("------------------------------------------------");
		lookPoker("高进的", gaojin, card);
		System.out.println("------------------------------------------------");
		lookPoker("龙五的", longwu, card);
		System.out.println("------------------------------------------------");
		System.out.println("------------------------------------------------");
		System.out.println("你是否能赢呢= =?");
		
	}
	
	//看牌
	public static void lookPoker(String name, TreeSet<Integer> ts, HashMap<Integer, String> hm) {
		System.out.println(name + "牌是");
		for (Integer key : ts) {
			System.out.print(hm.get(key) + " ");
		}
		System.out.println();
	}

}
