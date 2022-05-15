package ua.lviv.iot;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringManager {
    public List<String> getLocationStoreByRegular(String str)
    {
        ArrayList<Character> location = new ArrayList<Character>();
        List<String> res = new ArrayList<>();

        Pattern pat = Pattern.compile("\\d+°\\d+'\\d+\\.\\d+");


        Matcher m = pat.matcher(str);
        while(m.find()) {
            var r = m.group();
            res.add(r);
        }

        return res;
    }








    // --------------------------- example -----



    private List<String> getLocationStore(String str)
    {
        String result = "";
        boolean isStart = false;
        ArrayList<Character> location = new ArrayList<Character>();
        List<String> res = new ArrayList<>();

        for (int i = 0; i < str.length(); i++) {
            var ch = str.charAt(i);
            if (Character.isDigit(ch)) {
                isStart = true;
            }
            if(isStart && ch == '"') {
                isStart = false;

                var locStr = getStringRepresentation(location);

                res.add(locStr);
                location = new ArrayList<>();

            }
            if(isStart ) {
                location.add(ch);
            }
        }
        return res;
    }

    private List<String> getLocationStoreByRegularBeet(String str)
    {
        ArrayList<Character> location = new ArrayList<Character>();
        List<String> res = new ArrayList<>();

        Pattern pat = Pattern.compile("\"N.*?\"E");

        Matcher m = pat.matcher(str);
        while(m.find()) {
            var r = m.group();
            var locStr = r.replaceAll("\"N", "");
            locStr = locStr.replaceAll("\"E", "");
            res.add(locStr);
        }

        return res;
    }

    private String getStringRepresentation(ArrayList<Character> list)
    {
        StringBuilder builder = new StringBuilder(list.size());
        for(Character ch: list)
        {
            builder.append(ch);
        }
        return builder.toString();
    }
}