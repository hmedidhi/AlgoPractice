package com.practice.interview150.easy;

public class AddBinary {
    public String addBinary(String a, String b) {
        int x = a.length()-1;
        int y = b.length()-1;
        StringBuilder result = new StringBuilder();
        char carry = '0';
        while(x>0&&y>0){
            char ele1 = a.charAt(x);
            char ele2 = b.charAt(y);
            if(ele1=='1'&&ele2=='1'&&carry=='1'){
                result.append("1");
                carry = '1';
            }else if(ele1=='1'&&ele2=='1'&&carry=='0'){
                result.append("0");
                carry = '1';
            }else if((ele1=='1'||ele2=='1')&&carry=='0'){
                result.append("1");
                carry = '1';
            }else if((ele1=='1'||ele2=='1')&&carry=='1'){
                result.append("0");
            }else if((ele1=='0'&& ele2=='0')&&carry=='1'){
                result.append("0");
            }
            x--;
            y--;
        }

        return result.reverse().toString();
    }
}
