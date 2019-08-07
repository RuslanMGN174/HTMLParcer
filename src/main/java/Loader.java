import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.regex.Pattern;

public class Loader {

    private static final String FILE_PATTERN = "([^s]+(.(jpg|png|gif|bmp))$)";
    private static String url;
    private static File file;

//    "([^s]+(.(jpg|png|gif|bmp))$)"

    public static void main(String[] args) throws Exception {

        url = "https://lenta.ru/";

        Document document = Jsoup.connect(url).get();

        Elements element = document.select("img");
//        if (element.hasAttr("alt")){
        element.forEach(System.out::println);
//        }

        BufferedImage image;

//        for (Element elements : element) {
//            String imageURL = elements.absUrl("src");
//            System.out.println(imageURL);
//
//            String imageName = getFileName(imageURL);
//            image = ImageIO.read(new URL(imageURL));
//
//            file = new File("C:\Users\knyazev.r\Desktop\New\\" + imageName);
//            if (image != null)
//                try {
//                    ImageIO.write(image, "jpg", file);
//                } catch (Exception e) {
//                    continue;
//                }
//            System.out.println(imageName);
//        }
    }

    public static String setFileResolution(String name) {
        String suffix = ".png";
        return name + suffix;
    }

    public static String getFileName(String name) {
        String fullFileName = name.substring(name.lastIndexOf("/") + 1);
        if (!Pattern.compile(FILE_PATTERN).matcher(fullFileName).matches()) {
            return setFileResolution(fullFileName);
        }
        return fullFileName;
    }
}
