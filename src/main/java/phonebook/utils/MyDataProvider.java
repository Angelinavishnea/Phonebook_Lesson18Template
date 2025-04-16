package phonebook.utils;

import org.testng.annotations.DataProvider;
import phonebook.model.Contact;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class MyDataProvider {

    @DataProvider
    public Iterator<Object[]> addNewContact(){  //итератор проходит все элементы, object[] лист с Arrays
        List<Object[]> list = new ArrayList<>();
        list.add(new Object[]{"oliver1","Kan", "1234567890", "kan@gm.com", "Berlin", "goalkiper"});
        list.add(new Object[]{"oliver2","Kan", "12345678901", "kan@gm.com", "Berlin", "goalkiper"});
        list.add(new Object[]{"oliver3","Kan", "123456789012345", "kan@gm.com", "Berlin", "goalkiper"});
        return list.iterator();
    }

    @DataProvider
    public Iterator<Object[]> addNewContactFromCsv() throws IOException {
        List<Object[]> list = new ArrayList<>();

        BufferedReader reader = new BufferedReader(new FileReader(new File("src/test/resources/contact.csv")));
        String line = reader.readLine();

        while (line != null) {

            String[] split = line.split(",");
            list.add(new Object[]{new Contact()
                    .setName(split[0])
                    .setLastName(split[1])
                    .setPhone(split[2])
                    .setEmail(split[3])
                    .setAddress(split[4])
                    .setDesc(split[5])});
            line = reader.readLine();
        }

        return list.iterator();
    }
}
