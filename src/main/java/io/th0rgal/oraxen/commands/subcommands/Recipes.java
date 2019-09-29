package io.th0rgal.oraxen.commands.subcommands;

import io.th0rgal.oraxen.commands.CommandInterface;
import io.th0rgal.oraxen.recipes.ShapedBuilder;
import io.th0rgal.oraxen.settings.Message;

import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class Recipes implements CommandInterface {

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {

        if (args.length == 1) {
            sender.sendMessage("$help");

        } else if (sender instanceof Player) {
            Player player = (Player) sender;

            switch (args[1]) {
                case "open":
                    if (args.length > 2) {
                        createRecipe(player, args[2]);
                    } else {
                        sender.sendMessage("$recipeslist");
                    }
                    break;
                case "save":
                    ShapedBuilder.saveRecipe(player.getUniqueId());
                    break;
                default:
                    break;
            }

        } else {
            Message.NOT_A_PLAYER_ERROR.send(sender);
        }

        return true;
    }


    private void createRecipe (Player player, String recipeType) {
        switch (recipeType.toLowerCase()) {
            case "shapedbuilder":
                new ShapedBuilder(player);
        }
    }

}