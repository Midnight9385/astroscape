import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

public class ReadWriteImage {

    // Google logo url

    public static void main(String[] args) {
    BufferedImage k = new BufferedImage(200,200,BufferedImage.TYPE_INT_ARGB);

try{
File outputfile = new File("C:\\Users\\67971\\Desktop\\image.jpg");
ImageIO.write(k, "jpg", outputfile);
}catch(IOException o)
{o.printStackTrace();}
}
}