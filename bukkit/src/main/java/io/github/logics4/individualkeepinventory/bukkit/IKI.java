/*
This file is part of the "IndividualKeepInventory" project.
You can find it here: https://github.com/Logics4/IndividualKeepInventory

Copyright (C) 2020  Logics4

This program is free software: you can redistribute it and/or modify
it under the terms of the GNU General Public License as published by
the Free Software Foundation, either version 3 of the License, or
(at your option) any later version.

This program is distributed in the hope that it will be useful,
but WITHOUT ANY WARRANTY; without even the implied warranty of
MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
GNU General Public License for more details.

You should have received a copy of the GNU General Public License
along with this program.  If not, see <https://www.gnu.org/licenses/>.
*/

package io.github.logics4.individualkeepinventory.bukkit;

import io.github.logics4.individualkeepinventory.common.Constants;

import org.bstats.bukkit.MetricsLite;

import org.bukkit.Material;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.PlayerDeathEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.SkullMeta;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.ArrayList;
import java.util.List;

public class IKI extends JavaPlugin implements Listener {

    @Override
    public void onEnable() {
        getServer().getPluginManager().registerEvents(this, this);

        int bStatsId = 10156; // Plugin ID for bStats for Bukkit
        new MetricsLite(this, bStatsId);
    }

    @EventHandler
    public void onPlayerDeath(PlayerDeathEvent event) {
        if (event.getEntity().hasPermission(Constants.IKI_KEEPINVENTORY_PERMISSION)) {
            // Inventory is kept, but XP will be still be lost
            event.setKeepInventory(true);

            // Remove all drops except for player heads
            // This also handles scenarios where the inventory has player heads
            ItemStack playerHeadStack = null;
            for (ItemStack item : event.getDrops()) {
                if (item.getType() == Material.SKULL_ITEM) {
                    SkullMeta skull = (SkullMeta)item.getItemMeta();
                    // Make sure the player head is of the killed player
                    if (skull.hasOwner() && skull.getOwningPlayer().equals(event.getEntity())) {
                        // Ensure amount is not more than 1
                        item.setAmount(1);

                        if (playerHeadStack == null) {
                            playerHeadStack = item;
                        }
                    }
                }
            }

            event.getDrops().clear();
            if (playerHeadStack != null) {
                event.getDrops().add(playerHeadStack);
            }
        }
    }
}
