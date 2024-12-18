package GrMechMag.com.Resources.Texts;

public enum ToUserMessages {
    Information("Information"),
    FailureAudit("FailureAudit"),
    SuccessAudit("SuccessAudit"),
    Warning("Warning");

    private final String text;

    ToUserMessages(String text) {
        this.text = text;
    }

    public String toString() {
        return this.text;
    }
}
