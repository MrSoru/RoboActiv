package GrMechMag.com.Resources.Texts;

public enum ErrorMessages {
    ERR_NO_GETFILE("Hubo un error al obtener el archivo: \"{0}\"{1}{2}");

    private final String text;

    ErrorMessages(String text) {
        this.text = text;
    }

    public String toString() {
        return this.text;
    }}
