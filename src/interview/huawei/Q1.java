package interview.huawei;

import java.util.*;

/*
performance
Adam,125
Andy,110
Bill,92
Evan,154

organization
Aaron,Abel,Adam
Aaron,Abel,Andy
Aaron,Jone,Bill
Aaron,Jone,Evan
eof


Aaron<481>
-Jone<246>
--Evan<154>
--Bill<92>
-Abel<235>
--Adam<125>
--Andy<110>
*/
public class Q1 {

    static Map<String, Integer> map = new HashMap<>();

    public static void main(String[] args) {
        List<String> mgrList = new ArrayList<>(); // 经理
        Map<String, List<String>> mgrEmpMap = new HashMap<>(); // 经理，员工
        Map<String, List<String>> empPerMap = new HashMap<>(); // 员工，外包

        Scanner sc = new Scanner(System.in);
        String line;
        while (sc.hasNextLine()) {
            line = sc.nextLine();
            if (line.contentEquals("performance")) {
                while (!(line = sc.nextLine()).contentEquals("")) {
                    String[] perf = line.trim().split(",");
                    map.put(perf[0], Integer.parseInt(perf[1]));
                }
            }
            if (line.contentEquals("organization")) {
                while (!(line = sc.nextLine()).contentEquals("eof")) {
                    String[] org = line.trim().split(",");
                    // 这行员工不在记录
                    if (!empPerMap.containsKey(org[1])) {
                        // 这行经理不在记录
                        if (!mgrEmpMap.containsKey(org[0])) {
                            mgrList.add(org[0]);
                            mgrEmpMap.put(org[0], new ArrayList<>());
                            map.put(org[0], 0);
                        }
                        empPerMap.put(org[1], new ArrayList<>());
                        map.put(org[1], 0);
                    }
                    // 这行员工
                    List<String> curPers = empPerMap.get(org[1]);
                    curPers.add(org[2]);
                    map.put(org[1], map.get(org[1]) + map.get(org[2]));
                    // 这行经理
                    List<String> curEmps = mgrEmpMap.get(org[0]);
                    if (!curEmps.contains(org[1])) curEmps.add(org[1]);
                    map.put(org[0], map.get(org[0]) + map.get(org[2]));
                }
                break;
            }
        }
        mgrList.sort(Q1::comparator);
        for (String manager : mgrList) {
            System.out.println(manager + "<" + map.get(manager) + ">");
            mgrEmpMap.get(manager).sort(Q1::comparator);
            for (String employee : mgrEmpMap.get(manager)) {
                System.out.println("-" + employee + "<" + map.get(employee) + ">");
                empPerMap.get(employee).sort(Q1::comparator);
                for (String performance : empPerMap.get(employee)) {
                    System.out.println("--" + performance + "<" + map.get(performance) + ">");
                }
            }
        }
    }

    private static int comparator(String s, String t) {
        // 从大到小逆序
        if (map.get(s) < map.get(t)) return  1;
        if (map.get(s) > map.get(t)) return -1;
        else return t.compareTo(s);
    }

}