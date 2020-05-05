package p02;


import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

import org.apache.commons.codec.digest.DigestUtils;
public class App {
	public static void main(String[] args)  {
    	Scanner in = new Scanner(System.in);
    	System.out.println("请输入学号/账号:");
    	String id=in.nextLine();
    	System.out.println("请输入密码:");
    	String psw=in.nextLine();
    	FileReader r;
		try {
			r = new FileReader("D:\\STS\\p02\\password.txt");
			BufferedReader bf=new BufferedReader(r);
	    	String text;
			try {
				text = bf.readLine();
				String[] a=text.split("\\b ");
				bf.close();
		    	r.close();
		    	if(id.equals(a[0])&&sha256hex(psw).equals(a[1])) {
		    		System.out.println("登陆成功！");
		    	}else {
		    		System.out.println("登陆失败！");
		    	}
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	    	
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	
    	
    		   
    }
    public static String sha256hex(String input) {
        return DigestUtils.sha256Hex(input);
    }
}

