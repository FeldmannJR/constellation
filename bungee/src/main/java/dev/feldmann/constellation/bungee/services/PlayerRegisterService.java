package dev.feldmann.constellation.bungee.services;

import dev.feldmann.constellation.bungee.BungeeService;
import dev.feldmann.constellation.common.repositories.user.User;
import dev.feldmann.constellation.common.repositories.user.UserRepository;
import dev.feldmann.constellation.common.services.ServiceProvider;
import dev.feldmann.constellation.common.services.ServiceStatus;
import lombok.NonNull;
import net.md_5.bungee.api.chat.TextComponent;
import net.md_5.bungee.api.event.LoginEvent;
import net.md_5.bungee.api.event.PostLoginEvent;
import net.md_5.bungee.event.EventHandler;

import java.util.Optional;

public class PlayerRegisterService extends BungeeService {

    @EventHandler
    public void login(LoginEvent ev) {
        ev.registerIntent(getPlugin());
        runAsync(() -> {
            try {
                UserRepository userRepository = resolve(UserRepository.class);
                Optional<User> load = userRepository.load(ev.getConnection().getUniqueId());
                if (!load.isPresent()) {
                    userRepository.registerUser(ev.getConnection().getUniqueId(), ev.getConnection().getName());
                }
            } catch (Exception ex) {
                ex.printStackTrace();
                ev.setCancelled(true);
                ev.setCancelReason(TextComponent.fromLegacyText("§cOcorreu um erro!"));
            }
            ev.completeIntent(getPlugin());
        });
    }

    @EventHandler
    public void join(PostLoginEvent ev) {
        ev.getPlayer().sendMessage(TextComponent.fromLegacyText("§b§lWelcome to Constellation Network!"));
    }
}
