package fr.kstars.pluginslab.models;

import net.kyori.adventure.text.Component;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.scoreboard.*;

import static fr.kstars.pluginslab.utils.ChatUtils.SeveralInvisibleCharacters;

public class Scoreboard {

    public static void setScoreboard(Player player) {
        ScoreboardManager scoreboardManager = Bukkit.getScoreboardManager();
        org.bukkit.scoreboard.Scoreboard newScoreboard = scoreboardManager.getNewScoreboard();
        Objective objective = newScoreboard.registerNewObjective("scoreboard", Criteria.DUMMY, Component.text("§6§lPLUGINLAB"));
        objective.setDisplaySlot(DisplaySlot.SIDEBAR);

        for (int i = 6; i != 0; i--) {
            switch (i) {
                case 6, 3, 0:
                    Score invisibleScore = objective.getScore("");
                    invisibleScore.setScore(i);
                    continue;
                case 5:
                    Score playerInfoScore = objective.getScore(SeveralInvisibleCharacters + "§6§l• PLAYER INFO");
                    playerInfoScore.setScore(i);
                    continue;
                case 4:
                    Score nameScore = objective.getScore(SeveralInvisibleCharacters + "§6NAME: §7" + player.getName());
                    nameScore.setScore(i);
                case 2:
                    Score serverInfoScore = objective.getScore(SeveralInvisibleCharacters + "§9§l• SERVER INFO");
                    serverInfoScore.setScore(i);
                case 1:
                    Score onlinePlayersScore = objective.getScore(SeveralInvisibleCharacters + "§9§lONLINE: §7" + Bukkit.getOnlinePlayers().size());
                    onlinePlayersScore.setScore(i);
            }
        }

        player.setScoreboard(newScoreboard);
    }
}
