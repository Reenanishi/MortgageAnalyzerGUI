package  com.encyrptedtext;

public class EncryptedTest {
    public static void main(String[] args) {
        try{
            //getting the xml file to read
            String filename = "/Users/ankurpandey/IdeaProjects/hellofx/src/hellofx/encyrptedtext/sample.xml";
            String originalString = "Hello world";
            System.out.println("Original string " + originalString);

            EncrpytedMain.marshallText(originalString, filename);

            String text = EncrpytedMain.unmarshallText(filename);
            System.out.println("Output string " + text);

        } catch (Exception ex) {
            System.out.println("Error: " + ex.getMessage());
        }
    }
}
