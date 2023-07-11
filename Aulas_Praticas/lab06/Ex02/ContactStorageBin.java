package lab06.Ex02;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.List;
import java.io.FileOutputStream;
import java.nio.charset.StandardCharsets;


public class ContactStorageBin extends ContactStorage {
    private File file;

    public ContactStorageBin(File file) {
        super(file);
        this.file = file;
    }

    @Override
    public List<Contact> loadContacts() {
        List<Contact> contactos = new ArrayList<>();
        try (BufferedReader input = new BufferedReader(new FileReader(file))) {
            String linha;
            while ((linha = input.readLine()) != null) {
                String[] line = linha.split(" +");
                if (line.length == 2) {
                    Contact contacto = new Contact(line[0], line[1]);
                    contactos.add(contacto);
                }
            }

            input.close();
        } catch (Exception e) {
            System.err.printf("ERRO: %s\n", e.getMessage());
        }
        return contactos;
    }


    @Override
    public boolean saveContacts(List<Contact> list) {
    try (OutputStream out = new FileOutputStream(file)) {
            for (Contact contact : list) {
                String contacto = contact.toString() + "\n";
                byte[] data = contacto.getBytes((StandardCharsets.UTF_8));
               
                out.write(data);
            
            }

            out.close();
            return true;
        } catch (Exception e) {
            System.err.println(e.getMessage());
            return false;
        }

    }
}
