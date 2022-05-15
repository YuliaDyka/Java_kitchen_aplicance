package ua.lviv.iot;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args ) throws IOException {  

        String str = "'Скриня' - 49°50'06.4\"N 23°59'41.9\"E\n" +
                "'Форум' - 49°50'59.7\"N 24°01'20.3\"E\n" +
                "'Метро' - 49°49'23.5\"N 23°54'58.3\"E";

        StringManager stringManager = new StringManager();
        List<String> resStrByRegularList = stringManager.getLocationStoreByRegular(str);

        System.out.println("----- Location stores by regulars ------");
        for(String res: resStrByRegularList) {
            System.out.println("loc: " + res);
        }
    }
}
