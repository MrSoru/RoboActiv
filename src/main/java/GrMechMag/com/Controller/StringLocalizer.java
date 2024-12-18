package GrMechMag.com.Controller;
import GrMechMag.com.Helpers.Actions;

import java.util.HashMap;

public class StringLocalizer<T extends Enum<T>> {

    HashMap<String, String> L;
    public StringLocalizer(T value) {
        L = new HashMap<>();

        // Iterar sobre las constantes del enum
        for (Enum constant : value.getClass().getEnumConstants()) {
            L.put(constant.name(), constant.toString());
        }
    }

    public String Locate(String value){
        return Actions.Coalesce(L.get(value), value).toString();
    }
}