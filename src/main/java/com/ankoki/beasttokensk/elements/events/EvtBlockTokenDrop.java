package com.ankoki.beasttokensk.elements.events;

import ch.njol.skript.Skript;
import ch.njol.skript.doc.*;
import ch.njol.skript.lang.util.SimpleEvent;
import ch.njol.skript.registrations.EventValues;
import ch.njol.skript.util.Getter;
import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;
import org.bukkit.event.Event;
import me.mraxetv.beasttokens.api.events.tokendrops.blocks.BTBlockTokenDropEvent;
import org.jetbrains.annotations.Nullable;

@Name("Block Token Drop")
@Description("Fired when a block drops BeastTokens")
@Examples({"on block token drop:" +
           "    if player has permission \"tokens.gain\":",
           "        send \"You broke %event-block% and recieved %event-tokens% tokens\"",
           "        stop",
           "    cancel event",
           "    send \"You can't earn tokens until you have unlocked this!\""})
@Since("1.0")
@RequiredPlugins("BeastTokens")
public class EvtBlockTokenDrop extends SimpleEvent {

    static {
        Skript.registerEvent("Block Token Drop", EvtBlockTokenDrop.class, BTBlockTokenDropEvent.class, "[(beasttokens|beast tokens)] block token[s] (drop|dropping)");
        EventValues.registerEventValue(BTBlockTokenDropEvent.class, Player.class, new Getter<Player, BTBlockTokenDropEvent>() {
            @Override
            public Player get(BTBlockTokenDropEvent e) {
                return e.getPlayer();
            }
        }, 0);
        EventValues.registerEventValue(BTBlockTokenDropEvent.class, Block.class, new Getter<Block, BTBlockTokenDropEvent>() {
            @Override
            public Block get(BTBlockTokenDropEvent e) {
                return e.getBlock();
            }
        }, 0);
        EventValues.registerEventValue(BTBlockTokenDropEvent.class, Location.class, new Getter<Location, BTBlockTokenDropEvent>() {
            @Override
            public Location get(BTBlockTokenDropEvent e) {
                return e.getBlock().getLocation();
            }
        }, 0);
        EventValues.registerEventValue(BTBlockTokenDropEvent.class, World.class, new Getter<World, BTBlockTokenDropEvent>() {
            @Nullable
            @Override
            public World get(BTBlockTokenDropEvent btBlockTokenDropEvent) {
                return btBlockTokenDropEvent.getBlock().getLocation().getWorld();
            }
        }, 0);
    }

    @Override
    public boolean check(Event e) {
       return true;
    }
}