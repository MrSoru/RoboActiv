package GrMechMag.com.Resources.Texts;

public enum ErrorMessages {
    ERR_NO_GETFILE("Hubo un error al obtener el archivo: \"{0}\"{1}{2}"),
    ERR_NO_GETFILE_EXISTS("La ruta \"{0}\" no existe en el sistema"),
    ERR_NO_GETFILE_WRITE("La ruta \"{0}\" no tiene permisos de escritura"),
    ERR_NO_GETFILE_READ("La ruta \"{0}\" no tiene permisos de lectura"),
    ERR_NO_SETFILE_WRITE("Hubo un error al escribir el archivo: {0}{1}{2}")
    ;

    private final String text;

    ErrorMessages(String text) {
        this.text = text;
    }

    public String toString() {
        return this.text;
    }}
