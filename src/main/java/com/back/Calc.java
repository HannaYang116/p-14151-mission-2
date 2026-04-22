package com.back;

public class Calc {


    public static int run(String mathEx) { // mathEx 계산할 문자열
        // 내부 재귀 계산 함수 호출
        return calc(mathEx);
    }

    private static int calc(String exp) {

        if (!exp.contains(" + ") && !exp.contains(" - ") && !exp.contains(" * ") && !exp.contains("(")) {
            return Integer.parseInt(exp);
        }

        if(exp.contains("(")){
            int openIdx = exp.lastIndexOf("("); // 가장 안쪽 괄호
            int closeIdx = exp.indexOf(")",openIdx);
            String inner = exp.substring(openIdx+1,closeIdx);
            int inner_val= calc(inner);
            String new_exp= exp.substring(0,openIdx)
                    + inner_val
                    + exp.substring(closeIdx+1);
            return calc(new_exp);
        }


        if (exp.contains(" + ")) {

            int plusIdx = exp.lastIndexOf((" + ")); // 마지막 + 찾기
            if (plusIdx != -1) {
                String left = exp.substring(0, plusIdx); // + 기준으로 앞부분 수식 자름
                String right = exp.substring(plusIdx + 3); // 공백 포함
                return calc(left) + calc(right);
            }
        }

        if (exp.contains(" - ")) {
            int minusIdx = exp.lastIndexOf((" - "));
            if (minusIdx != -1){
                String left = exp.substring(0, minusIdx);
                String right = exp.substring(minusIdx + 3);
                return calc(left) - calc(right);
            }
        }

        if(exp.contains(" * ")){
            int mulIdx = exp.lastIndexOf((" * "));
            if(mulIdx != -1 ){
                String left = exp.substring(0,mulIdx);
                String right = exp.substring(mulIdx +3 );
                return calc(left) * calc(right);
            }
        }


        return 0;
    }

}