package  com.encyrptedtext;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "TextRoot")
@XmlAccessorType(XmlAccessType.FIELD)
public class Text {

    private static final long serialVersionUID = 1L;

    private String text;

    public Text(String text) {
        super();
        this.text = text;
    }

    @XmlElement(name="TEXT")
    public String getText() {
        return text;
    }


}