package ua.lviv.iot;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class StringManagerTest {
    StringManager stringManager;


    @BeforeEach
    void setUp() {
        stringManager = new StringManager();
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void getLocationStoreByRegular() {
        String str = "'Скриня' - 49°50'06.4\"N 23°59'41.9\"E\n" +
                "'Форум' - 49°50'59.7\"N 24°01'20.3\"E\n" +
                "'Метро' - 49°49'23.5\"N 23°54'58.3\"E";
      var res =  stringManager.getLocationStoreByRegular(str);

        Assertions.assertEquals("49°50'06.4", res.get(0));
        Assertions.assertEquals("23°59'41.9", res.get(1));
        Assertions.assertEquals("49°50'59.7", res.get(2));
        Assertions.assertEquals("24°01'20.3", res.get(3));
        Assertions.assertEquals("49°49'23.5", res.get(4));
        Assertions.assertEquals("23°54'58.3", res.get(5));

    }
}