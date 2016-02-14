import com.google.common.base.Preconditions;
import org.apache.log4j.Logger;

import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;

/**
 * Created by fcriscuolo on 1/19/16.
 */
public class RegExTest {
    private static Logger LOG = Logger.getLogger(RegExTest.class);

    public static void main(String... args) {
        String regEx = "^[0-9_-]{1,128}\\.tar\\.asc$";
        List<String> testList = Arrays.asList("2015-06-01_12-34-56-789.tar.asc", "test1234.tar", "2015-06-01_12-34-56-789.tar",
                "2015-06-01_12-34-56-789.asc" );
        for (String s : testList) {

        if (s.matches(regEx)) {
            LOG.info(s + " is OK");
        } else {
            LOG.error(s + " fails");
        }
    }
        Path path01 = Paths.get("/tmp/file/ehr/2015-06-01_12-34-56-789.tar.asc");
        Path path02 = Paths.get("/tmp/file/ehr/2015-06-01_12-34-56-789.tar");
        for (Path p : Arrays.asList(path01, path02)){
            Preconditions.checkState(isValidTarFile(p),"Invalid tar file: " +p.toString());
            LOG.info(p.toString() +" is valid");
        }


    }

    private static final String tarfileRegEx = "^[0-9_-]{1,128}\\.tar\\.asc$";
    private static boolean isValidTarFile(Path p) {
        return  p.getFileName().toString().matches(tarfileRegEx);
    }


}
