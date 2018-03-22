package ru.infragreen22.greenfly.commands;

import org.bukkit.ChatColor;
import org.bukkit.Sound;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import java.util.ArrayList;

public class ToggleFly implements CommandExecutor {

    // в этой хуйне (да-да, я знаю, что это коллекция, дайте побыть неформальным)
    // хранятся все игроки, у кого на данный момент есть флай (т.е., они летают)
    public ArrayList<String> hasFly = new ArrayList<>();

    @Override
    public boolean onCommand(CommandSender commandSender, Command command, String s, String[] strings) {
        Player player = (Player) commandSender;
        if(!(commandSender instanceof Player)) {
            commandSender.sendMessage("Вы должны быть игроком, чтобы выполнить эту команду!");
            return false;
        }
        if(player.isOp() || player.hasPermission("greenfly.fly")) {
            if(!(hasFly.contains(player.getName()))) {
                player.setAllowFlight(true);
                player.setFlying(true);
                // не уверен, как это работает, надо будет потом посмотреть
                player.playSound(player.getLocation(), Sound.ENTITY_CAT_PURREOW, 1, Integer.MAX_VALUE);
                player.sendMessage(ChatColor.AQUA + "" + ChatColor.BOLD + "Режим полёта включен " +
                        "для игрока " + player.getName() + " в мире " + player.getWorld().getName());
                hasFly.add(player.getName());
            }
            else {
                player.setAllowFlight(false);
                player.setFlying(false);
                // та же хуйня
                player.playSound(player.getLocation(), Sound.ENTITY_CAT_HISS, 1, Integer.MAX_VALUE);
                player.sendMessage(ChatColor.AQUA + "" + ChatColor.BOLD + "Режим полёта выключен для " +
                        "игрока " + player.getName() + " в мире " + player.getWorld().getName());
                hasFly.remove(player.getName());
            }
        }
        else {
            player.sendMessage(ChatColor.RED + "" + ChatColor.BOLD +
                    "Соррян, но тебе нельзя использовать эту команду!");
        }
        return false;
    }

}
