package  com.encyrptedtext;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import java.io.File;
import java.io.FileOutputStream;

public class EncrpytedMain {
    final static String secretKey = "AEs1899jyhh!!!!";

    public static void marshallText(String originalString, String filename) {
        try{
            //creating the JAXB context
            JAXBContext jContext = JAXBContext.newInstance(com.encyrptedtext.Text.class);
            //creating the marshaller object
            Marshaller marshallObj = jContext.createMarshaller();
            //setting the property to show xml format output
            marshallObj.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
            //setting the values in POJO class
            String encryptedString = AES.encrypt(originalString, secretKey) ;
            Text result = new Text(encryptedString);
            //calling the marshall method
            marshallObj.marshal(result, new FileOutputStream(filename));

        } catch (Exception ex) {
            System.out.println("Error: " + ex.getMessage());
        }
    }

    public static String unmarshallText(String filename) {
        try{
            //getting the xml file to read
            File file = new File(filename);
            //creating the JAXB context
            JAXBContext jContext = JAXBContext.newInstance(com.encyrptedtext.Text.class);
            //creating the unmarshall object
            Unmarshaller unmarshallerObj = jContext.createUnmarshaller();
            //calling the unmarshall method
            Text text=(Text) unmarshallerObj.unmarshal(file);
            String decryptedString = AES.decrypt(text.getText(), secretKey);
            return decryptedString;
        } catch (Exception ex) {
            System.out.println("Error: " + ex.getMessage());
            return "";
        }
    }
}
