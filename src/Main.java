import java.util.*;

public class Main {

    static List<String> list = new ArrayList<>();

    public static void main(String[] args){

//        list.add("0:start:0");
//        list.add("1:start:2");
//        list.add("1:end:5");
//        list.add("0:end:6");
//        int[]arr = exclusiveTime(list,2);

//        list.add("0:start:0");
//        list.add("0:start:2");
//        list.add("0:end:5");
//        list.add("0:start:6");
//        list.add("0:end:6");
//        list.add("0:end:7");
//        int[]arr = exclusiveTime(list,1);

        list.add("0:start:0");
        list.add("0:start:2");
        list.add("0:end:5");
        list.add("1:start:6");
        list.add("1:end:6");
        list.add("0:end:7");

        int[]arr = exclusiveTime(list,2);

        for(int i : arr){
            System.out.println("-> "+i);
        }
    }

    public static int[] exclusiveTime(List<String> logs,int n) {

            int[] res = new int[n];
            Stack<Integer> stack = new Stack<>();//store id, not timestamp
            int prev = 0;//store timestamp
            for (String log : logs){
                String[] strs = log.split(":");
                int id = Integer.parseInt(strs[0]);
                int curr = Integer.parseInt(strs[2]);
                if (strs[1].equals("start")){
                    if (!stack.isEmpty()){
                        res[stack.peek()] += curr - prev;
                    }
                    stack.push(id);
                    prev = curr;
                }else{
                    res[stack.pop()] += curr - prev + 1;
                    prev = curr + 1;
                }
            }
            return res;
        }

    }