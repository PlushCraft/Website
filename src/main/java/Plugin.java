import org.bukkit.plugin.java.JavaPlugin;
import org.eclipse.jetty.server.Server;

public class Plugin extends JavaPlugin {
    Server server;

    @Override
    public void onEnable() {
        try {
            server = Website.main();
        } catch (Exception exception) {
            exception.printStackTrace();
        }
    }
    @Override
    public void onDisable() {
        try {
            server.stop();
        } catch (Exception exception) {
            exception.printStackTrace();
        }
    }
}
