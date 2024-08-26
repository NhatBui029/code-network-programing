/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package webService;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.StringTokenizer;

/**
 *
 * @author pc
 */
public class WS_961 {
    public static void main(String[] args) {
        String deBai = getNumber("B18DCCN411");
        System.out.println(deBai);
        
        String[] split = deBai.split(";");
        StringBuilder builder = new StringBuilder(split[0]);
        builder.append(",");
        StringTokenizer st = new StringTokenizer(split[1], ",");
        List<String> list = new ArrayList<>();
        
        while(st.hasMoreTokens()){
            String tmp = st.nextToken();
            list.add(tmp);
        }
        
        Collections.sort(list, new Comparator<String>(){
            @Override
            public int compare(String o1, String o2) {
                String x = new StringBuilder(o1).append(o2).toString();
                String y = new StringBuilder(o2).append(o1).toString();
                
                if(Integer.parseInt(x) > Integer.parseInt(y)){
                    return 1;
                } else {
                    return 0;
                }
            }      
        });
        
        StringBuilder res = new StringBuilder();
        for(String s: list){
            res.append(s);
        }
        builder.append(res);
        
        greatestNumber(Integer.parseInt(split[0]), res.toString());
        
    }

    private static String getNumber(java.lang.String studentCode) {
        vn.medianews.NumberS_Service service = new vn.medianews.NumberS_Service();
        vn.medianews.NumberS port = service.getNumberSPort();
        return port.getNumber(studentCode);
    }

    private static boolean greatestNumber(int reqId, java.lang.String greatestNumber) {
        vn.medianews.NumberS_Service service = new vn.medianews.NumberS_Service();
        vn.medianews.NumberS port = service.getNumberSPort();
        return port.greatestNumber(reqId, greatestNumber);
    }
}
