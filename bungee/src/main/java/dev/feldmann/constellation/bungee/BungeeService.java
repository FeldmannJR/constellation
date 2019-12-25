package dev.feldmann.constellation.bungee;

import dev.feldmann.constellation.common.services.Service;
import dev.feldmann.constellation.common.services.ServiceProvider;
import dev.feldmann.constellation.common.services.ServiceStatus;
import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;
import net.md_5.bungee.api.plugin.Listener;

public class BungeeService implements Service, Listener {
    @Getter
    @Setter
    private ServiceStatus status;
    @Getter
    @Setter
    private ServiceProvider serviceProvider;

    @Override
    public void boot() {
        ConstellationBungee.getInstance().getProxy().getPluginManager().registerListener(ConstellationBungee.getInstance(), this);
    }

    @Override
    public void start() {

    }

    @Override
    public void stop() {
        ConstellationBungee.getInstance().getProxy().getPluginManager().unregisterListener(this);
    }

    @Override
    public void afterStop() {

    }

    public ConstellationBungee getPlugin() {
        return ConstellationBungee.getInstance();
    }

    public void runAsync(Runnable r) {
        getPlugin().getProxy().getScheduler().runAsync(getPlugin(), r);
    }


}
