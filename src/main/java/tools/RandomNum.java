package tools;

import demo.LoggerController;

import java.util.Random;


/**
 * Created by lijing on 2018/5/24.
 */
public class RandomNum {

    //生成n位数的一个随机数
    public static String getNumRandom(int length){
        final  LoggerController log = LoggerController.getLogger("RandomNum");

        String num = "";
        //random()生成一个 [0,1)期间的随机数
        num=String.valueOf((long)(Math.random()*Math.pow(10,length)));
        //log.info(num);
       // System.out.println(num);
        return num;
    }

    //生成100-200的随机数
    public static int getNumRandom(int min,int max){
        int num=0;
        Random random=new Random();
        //nextInt(10) 是 [0,10)之间的随机数
        num = random.nextInt(max-min+1)+ min;
        return num;
    }

    //生成随机字符串
    public static String getStringRandom(int length) {
        String val = "";
        Random random = new Random();

        for (int i = 0; i < length; i++) {

            String charornum = random.nextInt(2) % 2 == 0 ? "char" : "num";

            if (charornum.equals("char")) {
                int tem = random.nextInt(2) % 2 == 0 ? 65 : 97;
                val+= (char) (random.nextInt(26) + tem);
                System.out.println(val);

            } else if (charornum.equals("num")) {
                val+= String.valueOf(random.nextInt(10));
            }

        }
        return val;
    }

    public static void main(String []args){
        String str=RandomNum.getStringRandom(3);

    }



}
