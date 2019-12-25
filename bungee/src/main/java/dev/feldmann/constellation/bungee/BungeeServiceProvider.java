package dev.feldmann.constellation.bungee;

import dev.feldmann.constellation.common.services.ServiceProvider;
import dev.feldmann.constellation.common.utils.ObjectLoader;

import java.io.IOException;
import java.util.List;

public class BungeeServiceProvider extends ServiceProvider {
    @Override
    public void onRegister() {
        autoLoadServices();
    }

    public void autoLoadServices() {
        try {
            List<BungeeService> instancesFromClasses = ObjectLoader.createInstancesFromClasses(getClass().getPackage().getName() + ".services", BungeeService.class);
            for (BungeeService instancesFromClass : instancesFromClasses) {
                registerService(instancesFromClass.getClass(), instancesFromClass);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
