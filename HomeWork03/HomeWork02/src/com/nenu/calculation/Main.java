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
 * @author ������
 * @ClassName: Main
 * @Version 1.0 
 * @Copyright ����ʦ����ѧ
 * @date 2018��9��27�� ����6:58:42
 * @description ��������
 */
public class Main {
//	public static void main(String[] args) {
//		System.out.println("������n������Ҫ������ϰ����Ŀ����");
//		Scanner scanner = new Scanner(System.in);
//		boolean key1 = true;
//		String temp = null;
//		while(key1){
//			temp = scanner.next();//������ϰ�������
//			if(!temp.matches("^\\d+$")){
//				System.out.println("���������������һ��");
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
//        ps.println("2018102996");// ���ļ���д��ѧ���ַ���
//		//System.out.println(account);
//		while(questionCount != account){
//			//��������������
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
//			//������� - 1�������
//			Map<Integer, String> opeMap = new HashMap<Integer, String>();
//			opeMap.put(1, "+");
//			opeMap.put(2, "-");
//			opeMap.put(3, "*");
//			opeMap.put(4, "��");
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
////			        System.out.println("��Ӧ���沨��ʽΪ ��" + nbls_cc);
////			        System.out.println("����ǣ�");
//			        data = nbl.js_nbl();
//			        //��������2λ
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
//	            ps.print(stringBuilder + "\n");// �����еĻ���������ַ���
//				questionCount ++;
//			}//ÿ����һ����Ŀ+1
//		}
//		ps.flush();
//		ps.close();
//	}

    //  ������ջ
    private Stack<String> czf_stack = new Stack<>();        // ��� �������ջ
    private  ArrayList<String> ysbds_list = new ArrayList<>();     //��� ԭʼ���ʽ�� arraylist
    private  ArrayList<String> nblbds_list = new ArrayList<>();      // ���ת����� �沨��ʽ
    private static final int One = 1;      //
    private static final int Two = 3;     //
    private static final int Three = 5;   //�涨���ȼ�   Three ���
     //  ����һ������ջ
     private static Stack<String> ys_stack = new Stack<>();
     
      // ��ʼ��                             ʹ��StringTokenizer�ָ� �ַ���
     public Main(String bdString) {
         // TODO Auto-generated constructor stub
        StringTokenizer stringTokenizer = new StringTokenizer(bdString, "+-*��()",true);
        while(stringTokenizer.hasMoreTokens()){
              ysbds_list.add(stringTokenizer.nextToken());
             //System.out.println(stringTokenizer.nextToken());
         }
    }
     
     /**
      * 
      * @author ������
      * @title: isNum
      * @date 2016��3��27�� ����7:59:48
      * @param str
      * @return boolean
      */
     // �ж� �Ƿ�������
     public boolean isNum(String str){
         if(str.matches("[0-9]+")){    //����ʹ��������ʽ ��֤�Ƿ�������
             //System.out.println("Y");
            return true;
         }else{
             //System.out.println("N");
             return false;
         }
     }
     
     // �ж� �Ƿ��ǲ�����
    public boolean isCzf(String str){
        if(str.matches("[\\+\\-\\*\\��\\(\\)]")){
            //System.out.println("Y");
            return true;
         }else{
             //System.out.println("N");
             return false;
         }
     }
    
     // ��ȡ ���ȼ�
    public int getYxj(String str){
         
         switch(str){
         case "(":return Three;
         case "*":
         case "��":return Two;
         case "+":
         case "-":return One;
         case ")":return 0;
         
         default : return -1;
          
         }
         
      }
      /**
       * 
       * @author ������
       * @title: isYxj
       * @date 2016��3��28�� ����9:00:02
       * @param str1
       * @param str2
       * @return boolean
       */
     // �ж����ȼ� 
      public boolean isYxj(String str1,String str2){
          return getYxj(str1) > getYxj(str2);   
      }
      /**
       * 
       * @author ������
       * @title: stack_czf
       * @date 2016��3��28�� ����9:01:12
       * @param czf void
       */
      //   ********* �� ��ǰ����Ԫ��Ϊ ������ʱ**********    ������ ���Ĵ��룬 ���ڲ�����ջ���ж�
      public void stack_czf(String czf){
         
          //�жϵ�ǰջ���Ƿ�Ϊ��
        if(czf_stack.isEmpty()){
             czf_stack.push(czf);
              return;
         }
          
          //�ж��Ƿ�Ϊ (
         if("(".equals(czf)){
             czf_stack.push(czf);
             return;
         }
         
         //�ж��Ƿ�Ϊ )
         if(")".equals(czf)){
            String string = "";
             while(!"(".equals(string = czf_stack.pop())){
                 nblbds_list.add(string);
             }
             return;
        }
          
         //��� ��ǰջ��Ԫ����  (  ֱ����ջ
         if("(".equals(czf_stack.peek())){
             czf_stack.push(czf);
             return;
         }
         
         // �ж� �� ջ��Ԫ�ص����ȼ� , > Ϊtrue
         if(isYxj(czf, czf_stack.peek())){
            czf_stack.push(czf);
             return;
         }
         
         if(!isYxj(czf, czf_stack.peek())){
             nblbds_list.add(czf_stack.pop());
             stack_czf(czf);   //������ú��� �����������εĲ���������
         }
         
     }
     /**
      * 
      * @author ������
      * @title: zz_hz
      * @date 2016��3��28�� ����9:28:44 void
      */
     // ��׺ ��> ��׺
    public void zz_hz(){
         
         // ����ԭʼ���ʽlist
         for(String str:ysbds_list){
             
             //System.out.println("->  " + str);
             
             if(isNum(str)){
                 nblbds_list.add(str);
             }else if(isCzf(str)){
                 stack_czf(str);
             }else{
                 System.out.println("�Ƿ�");
             }
             
         }
         
         // ������ԭʼ���ʽ��  ��������ջ��Ԫ�� ȫ������� �沨�����ʽlist
 
         while(!czf_stack.isEmpty()){
             //System.out.println("���� " + czf_stack.peek());
            nblbds_list.add(czf_stack.pop());
         }
         
     }
     /**
      * 
      * @author ������
      * @title: jsff
      * @date 2016��3��28�� ����10:03:01
      * @param s1
      * @param s2
      * @param s3
      * @return int
      */
    // ������㷽��
     public Float jsff(String s1,String s2,String s3){
         float a = Float.parseFloat(s2);
         float b = Float.parseFloat(s1);
         switch(s3){
         case "+":return a+b;
         case "-":return a-b;
         case "*":return a*b;
         case "��":return a/b;
         default : return (float) 0.0;
        }
     }
     /**
      * 
      * @author ������
      * @title: js_nbl
      * @date 2016��3��28�� ����3:21:41
      * @return flaot
      */
     //  ���� �沨��ʽ
     public Float js_nbl(){
         for(String str:nblbds_list){
             if(isNum(str)){
                 ys_stack.push(str);
             }else{
                 ys_stack.push(String.valueOf(jsff(ys_stack.pop(), ys_stack.pop(), str)));
            }
         }
         return Float.parseFloat(ys_stack.pop());  //��� ջ��Ԫ�� ��Ϊ���
     }
     
 //    public void nbls_bc(){
 //        for(String string:nblbds_list){
 //            nbls_cc += string;
 //        }
 //    }
}
