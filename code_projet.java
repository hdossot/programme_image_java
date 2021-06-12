import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

public class ReadWriteImage {

    public static void main(String[] args) {

        try {
        	String pathImage = "/Users/henry/Desktop/_NFA032/_projet/truc.ppm";
            // read an image from url
            BufferedImage image = ImageIO.read(new File(pathImage));

            // resize image to 300x150
            Image scaledImage = image.getScaledInstance(300, 150, Image.SCALE_DEFAULT);

            // save the resize image aka thumbnail
            ImageIO.write(
                    convertToBufferedImage(scaledImage),
                    "png",
                    new File("/Users/henry/Desktop/_NFA032/_projet/chouette2_size.png"));

        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("Done");

    }
