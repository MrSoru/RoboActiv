package GrMechMag.com.Helpers;

import java.util.Objects;
import java.util.stream.Stream;

public class Actions {

    /**
     * Sentencia de obtención de primer valor no nulo
     * @param args Conjunto de valores que se obtendrá el primer no nulo
     * @return Object Primer objeto no nulo, en caso contrario un objeto nuevo
     * */
    public static Object Coalesce (Object... args){
        return Stream.of(args).filter(Objects::nonNull).findFirst().orElse(new Object());
    }
}
