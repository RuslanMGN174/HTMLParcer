import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.net.URL;
import java.util.regex.Pattern;

public class Loader {

    private static final String FILE_PATTERN = "([^s]+(.(jpg|png|gif|bmp))$)";
    private static String url;
    private static File file;
    private static BufferedImage image;

    public static void main(String[] args) throws Exception {

        url = "https://lenta.ru/";

        Document document = Jsoup.connect(url).get();
        Elements element = document.select("img");

        for (Element elements : element) {
            String imageURL = elements.absUrl("src");
            String imageName = getFileName(imageURL);

            if (isImageFile(imageName)) {
                image = ImageIO.read(new URL(imageURL));
            }

            file = new File("C:\\Users\\knyazev.r\\Desktop\\New\\" + imageName);
            ImageIO.write(image, "jpg", file);
        }
    }

    protected static String setFileResolution(String name) {
        String suffix = ".png";
        return name + suffix;
    }

    protected static String getFileName(String name) {
        return name.substring(name.lastIndexOf("/") + 1);
    }

    private static boolean isImageFile(String file) {
        return Pattern.compile(FILE_PATTERN).matcher(file).matches();
    }
}
