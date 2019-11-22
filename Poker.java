package com.xiangxiang.test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Set;
import java.util.TreeSet;

public class Poker {

	public static void main(String[] args) {
		
		//װ������
		HashMap<Integer, String> card = new HashMap<Integer, String>();
		
		//����ϴ��
		ArrayList<Integer> list = new ArrayList<Integer>();
		
		//���廨ɫ����͵�������
		String[] color = {"����","����","��Ƭ","÷��"};
		String[] num = {"3","4","5","6","7","8","9","10","J","Q","K","A","2"};
		
		//����һ����������ÿ���ƵĴ�С,����ϴ��֮���������
		int index = 0;
		
		//����54����
		for (String s1 : num) {
			for (String s2 : color) {
				card.put(index, s2.concat(s1));
				list.add(index);
				index++;
			}
		}
		card.put(index, "С��");
		list.add(index);
		index++;
		card.put(index, "����");
		list.add(index);

		//ϴ��(ϴ���Ǳ��)
		Collections.shuffle(list);
		
		//����(����Ҳ�Ǳ��)
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
		
		//����
		lookPoker("��", you, card);
		System.out.println("------------------------------------------------");
		System.out.println("�����ǧ��������λ���ֵ���");
		System.out.println("------------------------------------------------");
		lookPoker("�߽�", gaojin, card);
		System.out.println("------------------------------------------------");
		lookPoker("����", longwu, card);
		
	}
	
	//����
	public static void lookPoker(String name, TreeSet<Integer> ts, HashMap<Integer, String> hm) {
		System.out.println(name + "������");
		for (Integer key : ts) {
			System.out.print(hm.get(key) + " ");
		}
		System.out.println();
	}

}
