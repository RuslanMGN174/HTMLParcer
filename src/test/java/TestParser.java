import junit.framework.TestCase;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

public class TestParser extends TestCase {
    List<String> filesTypes;
    String FILE_PATTERN = "([^s]+(.(jpg|png|gif|bmp))$)";

    @Override
    protected void setUp() throws Exception {
        filesTypes = new ArrayList<String>(){{
            add("qwe.bmp");
            add("asd.jpg");
            add("aasdfert4tsd.jpg");
            add("zx2c.png");
            add("rt3456y.gif");
            add("asfasdfasdf");
        }};
    }

    public void testNameFormat(){
        for (String file : filesTypes){
            String actual = file;
            System.out.println(file.substring(file.lastIndexOf(".")));
            if (!Pattern.compile(FILE_PATTERN).matcher(file).matches()) {
                actual = Loader.setFileResolution(file);
                System.out.println(actual);
            }
        }
    }

}
