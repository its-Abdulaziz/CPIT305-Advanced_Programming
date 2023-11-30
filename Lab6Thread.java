import java.io.Serializable;

public class Lab6Thread implements Serializable {
    private long threadId;
    private String name;
    private boolean readable;
    private boolean writable;
    private boolean executable;
    private String lastModified;

    public Lab6Thread(long threadId, String name, boolean readable, boolean writable, boolean executable, String lastModified) {
        this.threadId = threadId;
        this.name = name;
        this.readable = readable;
        this.writable = writable;
        this.executable = executable;
        this.lastModified = lastModified;
    }

    @Override
    public String toString() {
        return "threadId= " + threadId + '\n' +
                        "fileName= " + name + '\n' +
                        "fileReadable= " + readable + '\n' +
                        "fileWritable= " + writable + '\n' +
                        "fileExecutable= " + executable + '\n' +
                        "lastModified= " + lastModified + '\n';
    }
}
