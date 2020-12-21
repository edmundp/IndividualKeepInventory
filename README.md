# Individual Keep-Inventory (for Bukkit and Sponge)
This is a simple plugin I have made, which allows you to set the `keepInventory` mechanic in Minecraft in a per-player way.
</br></br>

## Server Requirements:
- **Java 8**;
- **If you use a Bukkit-based server (Craftbukkit/Spigot/Paper/etc...):** This was tested in version 1.12.2 of Minecraft; in theory, this should work as far back as 1.8.8 though (and newer versions too).
- **If you use a Sponge-based server (SpongeVanilla/SpongeForge/etc...?):** This was tested in version 1.12.2 of Minecraft and version 7.3.0 of SpongeVanilla; in theory, as long as your server version supports that API version you should be fine.
</br></br>

## How to use it?
**WARNING: Do NOT set the `keepInventory` gamerule to `true` in the world, through `/gamerule` or any equivalent command (if you have a world management plugin); this plugin won't work otherwise.** If you have already done it, set it to `false`.</br>

1 - Install this plugin and a permission management plugin in your server ([LuckPerms](https://luckperms.net/) is what we recommend!);</br></br>
2 - With the permission management plugin you have installed, give the permission `iki.events.playerdeath.keepinventory` to whoever you want.
</br></br>

## Examples
Assuming you are using Luckperms:</br>
1 - If you want to give `keepInventory` to a specific player or group:
```
/luckperms user <playername> permission set iki.events.playerdeath.keepinventory true
```
</br>

2 - If you want to give `keepInventory` to everyone except a specific player:
```
/luckperms group default permission set iki.events.playerdeath.keepinventory true

/luckperms user <playername> permission set iki.events.playerdeath.keepinventory false
```
</br>
And there might be other use-cases I could spend 40 more hours covering here.
</br></br>

## How to Compile
**Requirements:**
- Although the plugin is compatible and runs in JRE 8, you will need **JDK 11 or higher** to compile the source code;
- **Maven 3.6.3 or higher**.</br>

**Instructions:**</br>
1 - With Git, `git clone` this repository;</br>
2 - Use `mvn clean install` on the root directory of the project.</br>
The plugin should be in `<project's root>/jar/target/`, named `IndividualKeepInventory-<versionTag>.jar`. Do not use the one with the `original-` prefix.
</br></br>

## License
This program is free software: you can redistribute it and/or modify
it under the terms of the GNU General Public License as published by
the Free Software Foundation, either version 3 of the License, or
(at your option) any later version.</br>

This program is distributed in the hope that it will be useful,
but WITHOUT ANY WARRANTY; without even the implied warranty of
MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
GNU General Public License for more details.</br>

You should have received a copy of the GNU General Public License
along with this program.  If not, see <https://www.gnu.org/licenses/>.
