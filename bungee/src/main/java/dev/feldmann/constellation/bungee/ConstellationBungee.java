package dev.feldmann.constellation.bungee;

import dev.feldmann.constellation.common.Constellation;
import lombok.Getter;
import net.md_5.bungee.api.plugin.Plugin;

public class ConstellationBungee extends Plugin {
    @Getter
    private static ConstellationBungee instance;
    @Getter
    private Constellation constellation;
    @Getter
    private BungeeServiceProvider bungeeServiceProvider;

    @Override
    public void onEnable() {
        instance = this;
        constellation = new Constellation();
        bungeeServiceProvider = new BungeeServiceProvider();
        constellation.getServiceManager().startProvider(bungeeServiceProvider);
    }

    @Override
    public void onDisable() {
        constellation.stop();
    }
}
