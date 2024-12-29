package GrMechMag.com.Controller;

import GrMechMag.com.Helpers.OsRecognizer;
import GrMechMag.com.Helpers.TextManagement;
import GrMechMag.com.Model.ActivityDay;
import GrMechMag.com.Model.Configuration;
import GrMechMag.com.Resources.EntryType;
import GrMechMag.com.Resources.Information;
import GrMechMag.com.Resources.Texts.ErrorMessages;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class FileController {

    WindowsLog WinLog;
    StringLocalizer<ErrorMessages> ErrorMes = new StringLocalizer<>(ErrorMessages.ERR_NO_GETFILE);
    Configuration config;

    public FileController() {
        WinLog = new WindowsLog(Information.ProgramName, Information.LogName);
    }

    public ArrayList<ActivityDay> GetInternalFiles(Configuration config) {
        List<String> Files;
        ArrayList<ActivityDay> activities = new ArrayList<ActivityDay>();
        File ruta = new File(config.getDatafiles());

        if (!ruta.exists()) {
            WinLog.WriteEvent(String.format(ErrorMes.Locate("ERR_NO_GETFILE_EXISTS")), EntryType.Warning, 1, true);
            return activities;
        }
        if (!ruta.canRead()) {
            WinLog.WriteEvent(String.format(ErrorMes.Locate("ERR_NO_GETFILE_WRITE")), EntryType.Warning, 1, true);
            return activities;
        }
        if (ruta.canWrite()) {
            WinLog.WriteEvent(String.format(ErrorMes.Locate("ERR_NO_GETFILE_READ")), EntryType.Warning, 1, true);
            return activities;
        }

        Files = Arrays.asList(ruta.list());

        Files.forEach((Item) -> activities.add(GetActivityDay(new File(Item))));

        return activities;
    }

    /**
     * Funcion para guardar la configuración
     *
     * @param file          Archivo donde se guardará la configuracion inicial
     * @param configuration Objeto de archivo que se va a guardar
     * @return Verdadero si se uarda el archivo de forma corrrecta; De lo contrario falso,
     */
    public boolean SaveConfiguration(File file, Configuration configuration) {
        if (file.exists()) {
            file.delete();
        }
        try {
            FileOutputStream f = new FileOutputStream(file);
            ObjectOutputStream o = new ObjectOutputStream(f);
            // escribe los objetos en un archivo
            o.writeObject(configuration);
            o.close();
            f.close();
            return true;
        } catch (FileNotFoundException ex) {
            Logger.getLogger(FileController.class.getName()).log(Level.INFO, ex.getMessage(), ex);
            return false;
        } catch (IOException ex) {
            Logger.getLogger(FileController.class.getName()).log(Level.WARNING, ex.getMessage(), ex);
            return false;
        }
    }

    public Configuration GetConfiguration(final File file) {
        try {
            Class.forName("GrMechMag.com.Model.Configuration");
            FileInputStream fi = null;
            try {
                fi = new FileInputStream(file);
                ObjectInputStream oi = new ObjectInputStream(fi);
                //Lee el objeto de un archivo
                Object obj2 = oi.readObject();
                Configuration Obj = (Configuration) obj2;
                oi.close();
                fi.close();
                return Obj;
            } catch (FileNotFoundException ex) {
                WinLog.WriteEvent(String.format(ErrorMes.Locate("ERR_NO_GETFILE") ,file.getPath() ,TextManagement.NewLine(3) ,ex.getMessage()), EntryType.Error, 200);
                return null;
            } catch (IOException | ClassNotFoundException ex) {
                Logger.getLogger(FileController.class.getName()).log(Level.WARNING, ex.getMessage(), ex);
                return null;
            } finally {
                try {
                    fi.close();
                } catch (IOException ex) {
                    Logger.getLogger(FileController.class.getName()).log(Level.SEVERE, ex.getMessage(), ex);
                }
            }
        } catch (ClassNotFoundException ex) {
            return null;
        }
    }

    public static boolean SaveActivityDay(File file, ActivityDay activityDay) {
        if (file.exists()) {
            file.delete();
        }
        try {
            FileOutputStream f = new FileOutputStream(file);
            ObjectOutputStream o = new ObjectOutputStream(f);
            // escribe los objetos en un archivo
            o.writeObject(activityDay);
            o.close();
            f.close();
            return true;
        } catch (FileNotFoundException ex) {
            Logger.getLogger(FileController.class.getName()).log(Level.INFO, ex.getMessage(), ex);
            return false;
        } catch (IOException ex) {
            Logger.getLogger(FileController.class.getName()).log(Level.WARNING, ex.getMessage(), ex);
            return false;
        }
    }

    public ActivityDay GetActivityDay(final File file) {
        try {
            Class.forName("GrMechMag.com.Model.ActivityDay");
            FileInputStream fi = null;
            try {
                fi = new FileInputStream(file);
                ObjectInputStream oi = new ObjectInputStream(fi);
                //Lee el objeto de un archivo
                Object obj2 = oi.readObject();
                ActivityDay Obj = (ActivityDay) obj2;
                oi.close();
                fi.close();
                return Obj;
            } catch (FileNotFoundException ex) {
                WinLog.WriteEvent(String.format(ErrorMes.Locate("ERR_NO_GETFILE") ,file.getPath() ,TextManagement.NewLine(3) ,ex.getMessage()), EntryType.Error, 200);
                return null;
            } catch (IOException | ClassNotFoundException ex) {
                Logger.getLogger(FileController.class.getName()).log(Level.WARNING, ex.getMessage(), ex);
                return null;
            } finally {
                try {
                    fi.close();
                } catch (IOException ex) {
                    Logger.getLogger(FileController.class.getName()).log(Level.SEVERE, ex.getMessage(), ex);
                }
            }
        } catch (ClassNotFoundException ex) {
            return null;
        }
    }

    public boolean Writefile(String Nombre, String FileExt, String Contenido) {
        String FileName = Nombre + "." + FileExt;
        File file = new File(OsRecognizer.getrunningpath() + "\\Resources\\" + FileName);

        if (file.exists()) {
            file.delete();
        }

        try {
            FileWriter myWriter = new FileWriter(file);
            myWriter.write(Contenido);
            myWriter.close();
        } catch (IOException e) {
            WinLog.WriteEvent(String.format(ErrorMes.Locate("ERR_NO_SETFILE_WRITE") ,file.getPath() ,TextManagement.NewLine(3) ,e.getMessage()), EntryType.Error, 200);
            return false;
        }

        return true;
    }

    public boolean Writefile(File Arch, String Nombre, String FileExt, String Contenido) {
        String FileName = Nombre + "." + FileExt;
        File file = Arch;

        if (file.exists()) {
            file.delete();
        }

        try {
            FileWriter myWriter = new FileWriter(file);
            myWriter.write(Contenido);
            myWriter.close();
        } catch (IOException e) {
            WinLog.WriteEvent(String.format(ErrorMes.Locate("ERR_NO_SETFILE_WRITE") ,file.getPath() ,TextManagement.NewLine(3) ,e.getMessage()), EntryType.Error, 200);
            return false;
        }
        return true;
    }
}
