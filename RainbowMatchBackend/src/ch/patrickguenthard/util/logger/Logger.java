package ch.patrickguenthard.util.logger;


public class Logger {
    private String className;

    public Logger(String classname) {
	this.className = classname;
    }

    public void info(String message) {
	print("info",message);
    }

    public void err(String message) {
	print("error",message);
    }

    public void debug(String message) {
	print("debug",message);
    }

    private void print(String prefix, String message) {
	System.out.println("("+prefix+") ["+className+"] " + message);
    }
}
