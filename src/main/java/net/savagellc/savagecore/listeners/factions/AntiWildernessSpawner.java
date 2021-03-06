package net.savagellc.savagecore.listeners.factions;

import com.massivecraft.factions.Board;
import com.massivecraft.factions.FLocation;
import com.massivecraft.factions.Faction;
import net.savagellc.savagecore.persist.Config;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.SpawnerSpawnEvent;

public class AntiWildernessSpawner implements Listener {

    @EventHandler
    public void onSpawnerSpawn(SpawnerSpawnEvent e) {

        if (Config.denyWildernessSpawners) {
            FLocation loc = new FLocation(e.getSpawner().getLocation());
            Faction faction = Board.getInstance().getFactionAt(loc);
            if (faction == null) { return; }

            if (faction.isWilderness()) {
                e.setCancelled(true);
            }
        }
    }
}