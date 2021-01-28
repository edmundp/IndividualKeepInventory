/*
This file is part of the "Individual Keep-Inventory" project (https://github.com/Logics4/IndividualKeepInventory)
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

package io.github.logics4.individualkeepinventory.sponge;

import org.spongepowered.api.entity.living.player.Player;
import org.spongepowered.api.event.Listener;
import org.spongepowered.api.event.entity.DestructEntityEvent;
import org.spongepowered.api.event.filter.Getter;
import org.spongepowered.api.plugin.Plugin;

import io.github.logics4.individualkeepinventory.common.Constants;

@Plugin(id = "${project.parent.artifactId}",
    name = "${project.parent.name}",
    authors = {"Logics4"},
    version = "${project.parent.version}",
    description = "${project.parent.description}",
    url = "${project.parent.url}")
public class IKI {

    @Listener
    public void onPlayerDeath(DestructEntityEvent.Death event, @Getter("getTargetEntity")Player player) {
        if (player.hasPermission(Constants.IKI_KEEPINVENTORY_PERMISSION)) {
            event.setKeepInventory(true);
        }
    }
}
