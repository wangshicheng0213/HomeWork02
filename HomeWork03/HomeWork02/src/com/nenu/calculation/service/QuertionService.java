package com.nenu.calculation.service;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintStream;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import java.util.Scanner;

import com.nenu.calculation.Main;
import com.nenu.calculation.model.Calculation;
import com.nenu.calculation.model.Paper;

public class QuertionService {
	public Paper questionCre(Calculation calculation) {
		ArrayList<String> arrayQuertion = new ArrayList<String>();
		ArrayList<String> arrayAnwser = new ArrayList<String>();
		String temp = calculation.getQuestionNum().toString();
		int account = Integer.valueOf(temp);
		int questionCount = 0;
//		System.out.println(this.getClass().getClassLoader().getResource("/"));
        File file = new File("E:\\Users\\Administrator\\eclipse-workspace\\HomeWork02\\src\\com\\nenu\\calculation\\service\\result.txt");
        PrintStream ps = null;
		try {
			ps = new PrintStream(new FileOutputStream(file));
		} catch (FileNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
        ps.println("2018102996");// 往文件里写入学号字符串
		//System.out.println(account);
		while(questionCount != account){
			int opNumber = Integer.valueOf(calculation.getOpNum().toString());
//			随机三到五个数字
//			Random random = new Random();
//			int nums = random.nextInt(3) + 3;
			//System.out.println(nums);
			int nums = opNumber + 1;
			ArrayList<Integer> numArrayList = new ArrayList<Integer>();
			int numDown = Integer.valueOf(calculation.getNumDown().toString());
			int numUp = Integer.valueOf(calculation.getNumUp().toString());
			for (int j = 0; j < nums; j++) {
				Random randomNum = new Random();
				int number = randomNum.nextInt(numUp - numDown + 1) + numDown;
				numArrayList.add(number);
			}
//			System.out.println(numArrayList);
			//随机数字 - 1个运算符
			Map<Integer, String> opeMap = new HashMap<Integer, String>();
			opeMap.put(1, "+");
			opeMap.put(2, "-");
			opeMap.put(3, "*");
			opeMap.put(4, "÷");
			int opeNum = 0;
			ArrayList<String> operrayList = new ArrayList<String>();
			Boolean isCheck01 = Boolean.valueOf(calculation.getIsCheck01().toString());
			if(isCheck01) {
				while(opeNum != nums - 1){
					Random randomOpe = new Random();
					int key = randomOpe.nextInt(4)+1;
					String ope01 = opeMap.get(key);
					operrayList.add(ope01);
					opeNum ++;
				}
			}
			else {
				while(opeNum != nums - 1){
					Random randomOpe = new Random();
					int key = randomOpe.nextInt(2)+1;
					String ope01 = opeMap.get(key);
					operrayList.add(ope01);
					opeNum ++;
				}
			}
//			System.out.println(operrayList);
//			Set<Entry<Integer, Character>> opeSet = opeMap.entrySet();
//			Iterator<Entry<Integer, Character>> ope = opeSet.iterator();
//			System.out.print("[");
//			while(ope.hasNext()){
//				Entry<Integer, Character> type = (Entry<Integer, Character>)ope.next();
//				int k = type.getKey();
//				Character v = type.getValue();
//				System.out.print(v + ",");
//			}
//			System.out.println("]");
			if(true){
//				System.out.println(numArrayList);
//				System.out.println(operrayList);
				ArrayList<String> equString = new ArrayList<String>();
				equString.add(numArrayList.get(0).toString());
				for (int i = 1; i < nums; i++) {
					equString.add(operrayList.get(i - 1).toString());
					equString.add(numArrayList.get(i).toString());
				}
//				System.out.println(equString);
				StringBuilder stringBuilder = new StringBuilder();
				for (int i = 0; i < equString.size(); i++) {
					stringBuilder.append(equString.get(i));
				}
		        float data = 0;
//		        System.out.println(stringBuilder.toString());
				try {
					String expression = stringBuilder.toString();
					stringBuilder.append("=");
					arrayQuertion.add(stringBuilder.toString());
					Main nbl = new Main(expression);
			        String nbls_cc = new String();
			        float result = 0;
			        nbl.zz_hz();
//			        nbl.nbls_bc();
//			        System.out.println("对应的逆波兰式为 ：" + nbls_cc);
//			        System.out.println("结果是：");
			        data = nbl.js_nbl();
			        //分数保留2位
			        DecimalFormat df = new DecimalFormat("0.00");
//			        String num3 = df.format(num);
			        String dataStr = df.format(data);
//			        System.out.println(result);			 
//					data = evaluateExpression(expression);			         
					stringBuilder.append(dataStr);
					arrayAnwser.add(dataStr);
//			        System.out.println(stringBuilder);
//			        File dest = new File("../HomeWork01/result.txt");
//			        BufferedWriter writer = new BufferedWriter(new FileWriter(dest));
//			        writer.write(stringBuilder.toString());
//			        writer.flush();
//			        writer.close(); 
				} catch (Exception e) {
					questionCount = questionCount - 1;
				}
	            ps.print(stringBuilder + "\n");// 在已有的基础上添加字符串
				questionCount ++;
			}//每生成一个题目+1
		}
//		System.out.println("问题集：" + arrayQuertion);
//		System.out.println("结果集：" + arrayAnwser);
		Paper paper = new Paper();
		paper.setQueNum(account);
		paper.setQuestion(arrayQuertion);
		paper.setAnswer(arrayAnwser);
		ps.flush();
		ps.close();
		return paper;
	}
}
