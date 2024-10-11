package com.zw;

public class Calculate {
    public int sub(int num1, int num2){
        return num1 - num2;
    }

    public int div(int num1, int num2) throws Exception {
        if(num2 == 0){
            throw new Exception("除数不能为0");
        }
        return num1 / num2;
    }
}
