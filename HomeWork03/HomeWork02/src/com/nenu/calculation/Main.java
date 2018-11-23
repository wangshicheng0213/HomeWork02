package com.nenu.calculation;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintStream;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.Scanner;
import java.util.Set;
import java.util.Stack;
import java.util.StringTokenizer;
import java.util.Map.Entry;
/**
 * 
 * @author 李明阳
 * @ClassName: Main
 * @Version 1.0 
 * @Copyright 东北师范大学
 * @date 2018年9月27日 下午6:58:42
 * @description 四则运算
 */
public class Main {
//	public static void main(String[] args) {
//		System.out.println("请输入n，即想要产生练习题题目数量");
//		Scanner scanner = new Scanner(System.in);
//		boolean key1 = true;
//		String temp = null;
//		while(key1){
//			temp = scanner.next();//输入练习题的数量
//			if(!temp.matches("^\\d+$")){
//				System.out.println("输入错误，请再输入一次");
//			}
//			else
//				key1 = false;
//		}
//		int account = Integer.valueOf(temp);
//		int questionCount = 0;
//        File file = new File("../HomeWork01/result.txt");
//        PrintStream ps = null;
//		try {
//			ps = new PrintStream(new FileOutputStream(file));
//		} catch (FileNotFoundException e1) {
//			// TODO Auto-generated catch block
//			e1.printStackTrace();
//		}
//        ps.println("2018102996");// 往文件里写入学号字符串
//		//System.out.println(account);
//		while(questionCount != account){
//			//随机三到五个数字
//			Random random = new Random();
//			int nums = random.nextInt(3) + 3;
//			//System.out.println(nums);
//			ArrayList<Integer> numArrayList = new ArrayList<Integer>();
//			for (int j = 0; j < nums; j++) {
//				Random randomNum = new Random();
//				int number = randomNum.nextInt(101);
//				numArrayList.add(number);
//			}
////			System.out.println(numArrayList);
//			//随机数字 - 1个运算符
//			Map<Integer, String> opeMap = new HashMap<Integer, String>();
//			opeMap.put(1, "+");
//			opeMap.put(2, "-");
//			opeMap.put(3, "*");
//			opeMap.put(4, "÷");
//			int opeNum = 0;
//			ArrayList<String> operrayList = new ArrayList<String>();
//			while(opeNum != nums - 1){
//				Random randomOpe = new Random();
//				int key = randomOpe.nextInt(4)+1;
//				String ope01 = opeMap.get(key);
//				operrayList.add(ope01);
//				opeNum ++;
//			}
////			System.out.println(operrayList);
////			Set<Entry<Integer, Character>> opeSet = opeMap.entrySet();
////			Iterator<Entry<Integer, Character>> ope = opeSet.iterator();
////			System.out.print("[");
////			while(ope.hasNext()){
////				Entry<Integer, Character> type = (Entry<Integer, Character>)ope.next();
////				int k = type.getKey();
////				Character v = type.getValue();
////				System.out.print(v + ",");
////			}
////			System.out.println("]");
//			if(true){
////				System.out.println(numArrayList);
////				System.out.println(operrayList);
//				ArrayList<String> equString = new ArrayList<String>();
//				equString.add(numArrayList.get(0).toString());
//				for (int i = 1; i < nums; i++) {
//					equString.add(operrayList.get(i - 1).toString());
//					equString.add(numArrayList.get(i).toString());
//				}
////				System.out.println(equString);
//				StringBuilder stringBuilder = new StringBuilder();
//				for (int i = 0; i < equString.size(); i++) {
//					stringBuilder.append(equString.get(i));
//				}
//		        float data = 0;
//				try {
//					String expression = stringBuilder.toString();
//					Main nbl = new Main(expression);
//			        String nbls_cc = new String();
//			        float result = 0;
//			        nbl.zz_hz();
////			        nbl.nbls_bc();
////			        System.out.println("对应的逆波兰式为 ：" + nbls_cc);
////			        System.out.println("结果是：");
//			        data = nbl.js_nbl();
//			        //分数保留2位
//			        DecimalFormat df = new DecimalFormat("0.00");
////			        String num3 = df.format(num);
//			        String dataStr = df.format(data);
////			        System.out.println(result);
//			         
////					data = evaluateExpression(expression);
//			         
//					stringBuilder.append("=" + dataStr);
//			        System.out.println(stringBuilder);
////			        File dest = new File("../HomeWork01/result.txt");
////			        BufferedWriter writer = new BufferedWriter(new FileWriter(dest));
////			        writer.write(stringBuilder.toString());
////			        writer.flush();
////			        writer.close(); 
//				} catch (Exception e) {
//					questionCount = questionCount - 1;
//				}
//	            ps.print(stringBuilder + "\n");// 在已有的基础上添加字符串
//				questionCount ++;
//			}//每生成一个题目+1
//		}
//		ps.flush();
//		ps.close();
//	}

    //  操作符栈
    private Stack<String> czf_stack = new Stack<>();        // 存放 运算符的栈
    private  ArrayList<String> ysbds_list = new ArrayList<>();     //存放 原始表达式的 arraylist
    private  ArrayList<String> nblbds_list = new ArrayList<>();      // 存放转换后的 逆波兰式
    private static final int One = 1;      //
    private static final int Two = 3;     //
    private static final int Three = 5;   //规定优先级   Three 最高
     //  定义一个运算栈
     private static Stack<String> ys_stack = new Stack<>();
     
      // 初始化                             使用StringTokenizer分割 字符串
     public Main(String bdString) {
         // TODO Auto-generated constructor stub
        StringTokenizer stringTokenizer = new StringTokenizer(bdString, "+-*÷()",true);
        while(stringTokenizer.hasMoreTokens()){
              ysbds_list.add(stringTokenizer.nextToken());
             //System.out.println(stringTokenizer.nextToken());
         }
    }
     
     /**
      * 
      * @author 李明阳
      * @title: isNum
      * @date 2016年3月27日 下午7:59:48
      * @param str
      * @return boolean
      */
     // 判断 是否是数字
     public boolean isNum(String str){
         if(str.matches("[0-9]+")){    //这里使用正则表达式 验证是否是数字
             //System.out.println("Y");
            return true;
         }else{
             //System.out.println("N");
             return false;
         }
     }
     
     // 判断 是否是操作符
    public boolean isCzf(String str){
        if(str.matches("[\\+\\-\\*\\÷\\(\\)]")){
            //System.out.println("Y");
            return true;
         }else{
             //System.out.println("N");
             return false;
         }
     }
    
     // 获取 优先级
    public int getYxj(String str){
         
         switch(str){
         case "(":return Three;
         case "*":
         case "÷":return Two;
         case "+":
         case "-":return One;
         case ")":return 0;
         
         default : return -1;
          
         }
         
      }
      /**
       * 
       * @author 李明阳
       * @title: isYxj
       * @date 2016年3月28日 上午9:00:02
       * @param str1
       * @param str2
       * @return boolean
       */
     // 判断优先级 
      public boolean isYxj(String str1,String str2){
          return getYxj(str1) > getYxj(str2);   
      }
      /**
       * 
       * @author 李明阳
       * @title: stack_czf
       * @date 2016年3月28日 上午9:01:12
       * @param czf void
       */
      //   ********* 当 当前操作元素为 操作符时**********    这里是 核心代码， 用于操作符栈的判断
      public void stack_czf(String czf){
         
          //判断当前栈内是否为空
        if(czf_stack.isEmpty()){
             czf_stack.push(czf);
              return;
         }
          
          //判断是否为 (
         if("(".equals(czf)){
             czf_stack.push(czf);
             return;
         }
         
         //判断是否为 )
         if(")".equals(czf)){
            String string = "";
             while(!"(".equals(string = czf_stack.pop())){
                 nblbds_list.add(string);
             }
             return;
        }
          
         //如果 当前栈顶元素是  (  直接入栈
         if("(".equals(czf_stack.peek())){
             czf_stack.push(czf);
             return;
         }
         
         // 判断 与 栈顶元素的优先级 , > 为true
         if(isYxj(czf, czf_stack.peek())){
            czf_stack.push(czf);
             return;
         }
         
         if(!isYxj(czf, czf_stack.peek())){
             nblbds_list.add(czf_stack.pop());
             stack_czf(czf);   //这里调用函数 本身，并将本次的操作数传参
         }
         
     }
     /**
      * 
      * @author 李明阳
      * @title: zz_hz
      * @date 2016年3月28日 上午9:28:44 void
      */
     // 中缀 —> 后缀
    public void zz_hz(){
         
         // 遍历原始表达式list
         for(String str:ysbds_list){
             
             //System.out.println("->  " + str);
             
             if(isNum(str)){
                 nblbds_list.add(str);
             }else if(isCzf(str)){
                 stack_czf(str);
             }else{
                 System.out.println("非法");
             }
             
         }
         
         // 遍历完原始表达式后  将操作符栈内元素 全部添加至 逆波兰表达式list
 
         while(!czf_stack.isEmpty()){
             //System.out.println("即将 " + czf_stack.peek());
            nblbds_list.add(czf_stack.pop());
         }
         
     }
     /**
      * 
      * @author 李明阳
      * @title: jsff
      * @date 2016年3月28日 上午10:03:01
      * @param s1
      * @param s2
      * @param s3
      * @return int
      */
    // 具体计算方法
     public Float jsff(String s1,String s2,String s3){
         float a = Float.parseFloat(s2);
         float b = Float.parseFloat(s1);
         switch(s3){
         case "+":return a+b;
         case "-":return a-b;
         case "*":return a*b;
         case "÷":return a/b;
         default : return (float) 0.0;
        }
     }
     /**
      * 
      * @author 李明阳
      * @title: js_nbl
      * @date 2016年3月28日 下午3:21:41
      * @return flaot
      */
     //  计算 逆波兰式
     public Float js_nbl(){
         for(String str:nblbds_list){
             if(isNum(str)){
                 ys_stack.push(str);
             }else{
                 ys_stack.push(String.valueOf(jsff(ys_stack.pop(), ys_stack.pop(), str)));
            }
         }
         return Float.parseFloat(ys_stack.pop());  //最后 栈中元素 即为结果
     }
     
 //    public void nbls_bc(){
 //        for(String string:nblbds_list){
 //            nbls_cc += string;
 //        }
 //    }
}
