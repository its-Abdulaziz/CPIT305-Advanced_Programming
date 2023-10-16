import java.io.Serializable;
import java.util.Date;

public class metadataLab4 implements Serializable {

    private String name;
    private boolean readable;
    private boolean writable;
    private boolean executable;
    private String lastModified;

    public metadataLab4(String name, boolean readable, boolean writable, boolean executable, String lastModified) {
        this.name = name;
        this.readable = readable;
        this.writable = writable;
        this.executable = executable;
        this.lastModified = lastModified;
    }

    private String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isReadable() {
        return readable;
    }

    public void setReadable(boolean readable) {
        this.readable = readable;
    }

    public boolean isWritable() {
        return writable;
    }

    public void setWritable(boolean writable) {
        this.writable = writable;
    }

    public boolean isExecutable() {
        return executable;
    }

    public void setExecutable(boolean executable) {
        this.executable = executable;
    }

    public String getLastModified() {
        return lastModified;
    }

    public void setLastModified(String lastModified) {
        this.lastModified = lastModified;
    }

    @Override
    public String toString() {
        return
                "name= " + name + '\n' +
                        "readable= " + readable + '\n' +
                        "writable= " + writable + '\n' +
                        "executable= " + executable + '\n' +
                        "lastModified= " + lastModified + '\n';
    }
}
