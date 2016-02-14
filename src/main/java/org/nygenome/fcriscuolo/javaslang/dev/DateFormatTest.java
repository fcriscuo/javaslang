package org.nygenome.fcriscuolo.javaslang.dev;

import org.apache.log4j.Logger;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.function.Function;


/**
 * Created by fcriscuolo on 2/1/16.
 */
public class DateFormatTest {

    private static final Logger logger = Logger.getLogger(DateFormatTest.class);
    private static final  DateTimeFormatter formatter =DateTimeFormatter.ofPattern("uuuu-MM-dd'T'HH:mm");

    static Function<LocalDateTime, LocalDateTime> ldtFunction = (ldt) -> {
        String text = ldt.format(formatter);
        return LocalDateTime.parse(text,formatter);
    };

    public static void main (String...args) {
        LocalDateTime ldt = LocalDateTime.now().minusYears(10);
        logger.info(ldtFunction.apply(ldt));
    }
}
