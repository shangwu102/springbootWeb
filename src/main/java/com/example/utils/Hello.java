package com.example.utils;

public class Hello {
    public static void main(String[] args) {
        int N = 100;
        int count = 0;

        for (int i = 1; i <= N; i++) {
            if (isGood(i)) {
                count++;
            }
        }

        System.out.println("1 到 " + N + " 共有 " + count + " 个好数");
    }

    // 判断一个数是否是“好数”
    public static boolean isGood(int num) {
        int position = 1; // 位序，从个位开始为第1位
        while (num > 0) {
            int digit = num % 10;
            // 奇数位上数字要是奇数，偶数位上数字要是偶数
            if (position % 2 == 1) { // 奇数位
                if (digit % 2 == 0) return false;
            } else { // 偶数位
                if (digit % 2 == 1) return false;
            }
            num /= 10;
            position++;
        }
        return true;
    }
}
