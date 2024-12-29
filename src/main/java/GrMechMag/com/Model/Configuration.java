package GrMechMag.com.Model;

import java.io.File;
import java.io.Serializable;

/**
 * Clase de perfilado de configracion del proyecto
 * @author MrSoru
 * */
public class Configuration implements Serializable {
    private static File ConfigFiles;
    private static int Timer;
    private static String Datafiles;
    private static String EmployeeID;
    private static final String Name = "RoboActiv.GMM";
    private static final String ConfigPath = "..\\Configuration\\";
    private static boolean ActivateWindowsEvent;

    public Configuration() { }

    public Configuration(Configuration configuration) {
        ConfigFiles = configuration.getConfigFiles();
        Timer = configuration.getTimer();
        Datafiles = configuration.getDatafiles();
        EmployeeID = configuration.getEmployeeID();
        ActivateWindowsEvent = configuration.getActivateWindowsEvent();
    }

    public static String getConfigPathFile() {
        return ConfigPath + Name;
    }

    public static String getEmployeeID() {
        return EmployeeID;
    }

    public static void setEmployeeID(final String employeeID) {
        EmployeeID = employeeID;
    }

    public static File getConfigFiles() {
        return ConfigFiles;
    }

    public static void setConfigFiles(final File configFiles) {
        ConfigFiles = configFiles;
    }

    public static int getTimer() {
        return Timer;
    }

    public static void setTimer(final int timer) {
        Timer = timer;
    }

    public static String getDatafiles() {
        return Datafiles;
    }

    public static void setDatafiles(String datafiles) {
        Datafiles = datafiles;
    }

    public static void setActivateWindowsEvent(final boolean activateWindowsEvent){
        ActivateWindowsEvent = activateWindowsEvent;
    }

    public static boolean getActivateWindowsEvent(){
        return ActivateWindowsEvent;
    }
}
