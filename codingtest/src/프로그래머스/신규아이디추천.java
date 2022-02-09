package 프로그래머스;

    class 신규아이디 {
        public String solution(String new_id) {
            String answer = "";
            new_id = method1(new_id);
            new_id = method2(new_id);
            new_id = method3(new_id);
            new_id = method4(new_id);
            new_id = method5(new_id);
            new_id = method6(new_id);
            new_id = method7(new_id);
            System.out.println(new_id);
            answer = new_id;
            return answer;
        }
        public String method1(String answer){
            return answer.toLowerCase();
        }
        public String method2(String answer){
            return answer.replaceAll("[^a-z0-9_.-]","");
        }
        public String method3(String answer){
            while(answer.contains("..")){
                answer = answer.replace("..",".");
            }
            return answer;
        }
        public String method4(String answer){
            if(answer.charAt(0) == '.' && answer.length() > 1){
                answer = answer.substring(1,answer.length());
            }
            if(answer.charAt(answer.length()-1) == '.'&& answer.length() > 1){
                answer = answer.substring(0,answer.length()-1);
            }
            if(answer.charAt(0)=='.'){
                answer = "";
            }
            return answer;
        }
        public String method5(String answer){
            if(answer.length() == 0){
                return "a";
            }
            return answer;
        }
        public String method6(String answer){
            if(answer.length()>=16){
                answer = answer.substring(0,15);
            }
            answer = method4(answer);
            return answer;
        }
        public String method7(String answer){
            while(answer.length() < 3){
                answer += answer.charAt(answer.length()-1);
            }
            return answer;
        }
    }
