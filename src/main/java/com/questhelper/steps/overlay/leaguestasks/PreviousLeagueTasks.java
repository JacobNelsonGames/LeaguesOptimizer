package com.questhelper.steps.overlay.leaguestasks;

import com.questhelper.QuestHelperQuest;
import com.questhelper.requirements.item.ItemRequirement;
import com.questhelper.requirements.player.CombatLevelRequirement;
import com.questhelper.requirements.player.SkillOther;
import com.questhelper.requirements.player.SkillRequirement;
import com.questhelper.requirements.quest.QuestRequirement;
import com.questhelper.steps.DetailedQuestStep;
import net.runelite.api.ItemID;
import net.runelite.api.QuestState;
import net.runelite.api.Skill;
import net.runelite.api.coords.WorldPoint;

public class PreviousLeagueTasks
{
    ShatteredRelicsLeagueTasks shatteredClass;

    private void addLeagueTask(DetailedQuestStep leagueStep, Integer LeaguePoints)
    {
        if (shatteredClass != null)
        {
            shatteredClass.addLeagueTask(leagueStep, LeaguePoints);
        }
    }

    PreviousLeagueTasks(ShatteredRelicsLeagueTasks InshatteredClass)
    {
        shatteredClass = InshatteredClass;
    }

    public void setupTrailblazerMissedSteps()
    {
        addLeagueTask(
                new DetailedQuestStep(shatteredClass,
                        new WorldPoint(1761, 3559, 0),
                        "Serve 20 Stews in the Mess Hall"),
                25
        );

        addLeagueTask(
                new DetailedQuestStep(shatteredClass,
                        new WorldPoint(3142, 3448, 0),
                        "Ferment 100 Jugs of Wine",
                        new SkillRequirement(Skill.COOKING, 35, false)),
                25
        );

        addLeagueTask(
                new DetailedQuestStep(shatteredClass,
                        new WorldPoint(2817, 3442, 0),
                        "Cook 100 Lobsters",
                        new SkillRequirement(Skill.COOKING, 40, false)),
                25
        );

        addLeagueTask(
                new DetailedQuestStep(shatteredClass,
                        new WorldPoint(3142, 3448, 0),
                        "Make a Pineapple Pizza",
                        new SkillRequirement(Skill.COOKING, 65, false)),
                25
        );

        addLeagueTask(
                new DetailedQuestStep(shatteredClass,
                        new WorldPoint(3143, 3443, 0),
                        "Enter the Cooks' Guild",
                        new SkillRequirement(Skill.COOKING, 32, false)),
                25
        );

        addLeagueTask(
                new DetailedQuestStep(shatteredClass,
                        new WorldPoint(2257, 3148, 0),
                        "Cook a Rabbit in Tirannwn",
                        new QuestRequirement(QuestHelperQuest.UNDERGROUND_PASS, QuestState.FINISHED)),
                25
        );

        addLeagueTask(
                new DetailedQuestStep(shatteredClass,
                        new WorldPoint(1761, 3559, 0),
                        "Serve 20 Pizzas in the Mess Hall",
                        new SkillRequirement(Skill.COOKING, 65, false)),
                50
        );

        addLeagueTask(
                new DetailedQuestStep(shatteredClass,
                        new WorldPoint(2816, 3441, 0),
                        "Cook 100 Sharks",
                        new SkillRequirement(Skill.COOKING, 80, false),
                        new SkillRequirement(Skill.FISHING, 76, false)),
                50
        );

        addLeagueTask(
                new DetailedQuestStep(shatteredClass,
                        new WorldPoint(2903, 3118, 0),
                        "Cook 100 Karambwans",
                        new QuestRequirement(QuestHelperQuest.TAI_BWO_WANNAI_TRIO, QuestState.FINISHED),
                        new SkillRequirement(Skill.COOKING, 30, false),
                        new SkillRequirement(Skill.FISHING, 65, false)),
                50
        );

        addLeagueTask(
                new DetailedQuestStep(shatteredClass,
                        "Reach Level 99 Cooking",
                        new SkillRequirement(Skill.COOKING, 99, false)),
                125
        );

        addLeagueTask(
                new DetailedQuestStep(shatteredClass,
                        "Obtain 25 Million Cooking XP",
                        new SkillRequirement(Skill.COOKING, 99, false)),
                125
        );

        addLeagueTask(
                new DetailedQuestStep(shatteredClass,
                        new WorldPoint(3184, 3946, 0),
                        "Cook a Dark Crab",
                        new SkillRequirement(Skill.FISHING, 85, false),
                        new SkillRequirement(Skill.COOKING, 90, false)),
                125
        );

        addLeagueTask(
                new DetailedQuestStep(shatteredClass,
                        new WorldPoint(2651, 3368, 0),
                        "Spin a Ball of Wool"),
                5
        );

        addLeagueTask(
                new DetailedQuestStep(shatteredClass,
                        "Cut a Sapphire",
                        new ItemRequirement("Uncut Sapphire", ItemID.UNCUT_SAPPHIRE).quantity(1),
                        new ItemRequirement("Chisel", ItemID.CHISEL).quantity(1),
                        new SkillRequirement(Skill.CRAFTING, 20, false)),
                5
        );

        addLeagueTask(
                new DetailedQuestStep(shatteredClass,
                        new WorldPoint(3278, 3191, 0),
                        "Craft a Leather Body",
                        new ItemRequirement("Leather", ItemID.LEATHER).quantity(1),
                        new ItemRequirement("Needle", ItemID.NEEDLE).quantity(1),
                        new ItemRequirement("Thread", ItemID.THREAD).quantity(1),
                        new SkillRequirement(Skill.CRAFTING, 14, false)),
                5
        );

        addLeagueTask(
                new DetailedQuestStep(shatteredClass,
                        new WorldPoint(3428, 3320, 0),
                        "Craft a Snelm",
                        new SkillRequirement(Skill.CRAFTING, 15, false),
                        new QuestRequirement(QuestHelperQuest.PRIEST_IN_PERIL, QuestState.FINISHED)),
                5
        );

        addLeagueTask(
                new DetailedQuestStep(shatteredClass,
                        "Craft 100 Unpowered Orbs",
                        new SkillRequirement(Skill.CRAFTING, 46, false)),
                25
        );

        addLeagueTask(
                new DetailedQuestStep(shatteredClass,
                        "Craft an Emerald Ring",
                        new SkillRequirement(Skill.CRAFTING, 27, false)),
                25
        );

        addLeagueTask(
                new DetailedQuestStep(shatteredClass,
                        "Craft a Ruby Amulet",
                        new SkillRequirement(Skill.CRAFTING, 50, false)),
                25
        );

        addLeagueTask(
                new DetailedQuestStep(shatteredClass,
                        new WorldPoint(2933, 3292, 0),
                        "Enter the Crafting Guild",
                        new SkillRequirement(Skill.CRAFTING, 40, false)),
                25
        );

        addLeagueTask(
                new DetailedQuestStep(shatteredClass,
                        "Craft a Dragonstone Amulet",
                        new ItemRequirement("Dragonstone", ItemID.DRAGONSTONE).quantity(1),
                        new SkillRequirement(Skill.CRAFTING, 80, false)),
                50
        );

        addLeagueTask(
                new DetailedQuestStep(shatteredClass,
                        "Craft 30 Blue Dragonhide Bodies",
                        new SkillRequirement(Skill.CRAFTING, 71, false)),
                50
        );

        addLeagueTask(
                new DetailedQuestStep(shatteredClass,
                        new WorldPoint(3087, 3569, 0),
                        "Craft an Air Battlestaff in the Wilderness",
                        new SkillRequirement(Skill.CRAFTING, 66, false)),
                50
        );

        addLeagueTask(
                new DetailedQuestStep(shatteredClass,
                        "Reach Level 99 Crafting",
                        new SkillRequirement(Skill.CRAFTING, 99, false)),
                125
        );

        addLeagueTask(
                new DetailedQuestStep(shatteredClass,
                        "Obtain 25 Million Crafting XP",
                        new SkillRequirement(Skill.CRAFTING, 99, false)),
                125
        );

        addLeagueTask(
                new DetailedQuestStep(shatteredClass,
                        "Craft an Onyx Amulet",
                        new SkillRequirement(Skill.CRAFTING, 90, true)),
                125
        );

        addLeagueTask(
                new DetailedQuestStep(shatteredClass,
                        "Equip a Full Mithril Set",
                        new ItemRequirement("Mithril Helmet", ItemID.MITHRIL_FULL_HELM).quantity(1),
                        new ItemRequirement("Mithril Platebody", ItemID.MITHRIL_PLATEBODY).quantity(1),
                        new ItemRequirement("Mithril Plateskirt", ItemID.MITHRIL_PLATESKIRT).quantity(1),
                        new SkillRequirement(Skill.DEFENCE, 20, false)),
                5
        );

        addLeagueTask(
                new DetailedQuestStep(shatteredClass,
                        new WorldPoint(1509, 3566, 0),
                        "Equip Tier 5 Shayzien Armour",
                        new SkillRequirement(Skill.DEFENCE, 20, false)),
                25
        );

        addLeagueTask(
                new DetailedQuestStep(shatteredClass,
                        "Equip a Full Adamant Set",
                        new ItemRequirement("Adamant Helmet", ItemID.ADAMANT_FULL_HELM).quantity(1),
                        new ItemRequirement("Adamant Platebody", ItemID.ADAMANT_PLATEBODY).quantity(1),
                        new ItemRequirement("Adamant Plateskirt", ItemID.ADAMANT_PLATESKIRT).quantity(1),
                        new SkillRequirement(Skill.DEFENCE, 30, false)),
                25
        );

        addLeagueTask(
                new DetailedQuestStep(shatteredClass,
                        "Equip a Full Rune Set",
                        new ItemRequirement("Rune Helmet", ItemID.RUNE_FULL_HELM).quantity(1),
                        new ItemRequirement("Rune Platebody", ItemID.RUNE_PLATEBODY).quantity(1),
                        new ItemRequirement("Rune Plateskirt", ItemID.RUNE_PLATESKIRT).quantity(1),
                        new SkillRequirement(Skill.DEFENCE, 40, false)),
                25
        );

        addLeagueTask(
                new DetailedQuestStep(shatteredClass,
                        "Equip a Full Gilded Set",
                        new CombatLevelRequirement(126)),
                50
        );

        addLeagueTask(
                new DetailedQuestStep(shatteredClass,
                        "Equip a Full God Rune Set",
                        new CombatLevelRequirement(126)),
                50
        );

        addLeagueTask(
                new DetailedQuestStep(shatteredClass,
                        "Equip a Full God Dragonhide Set",
                        new CombatLevelRequirement(126)),
                50
        );

        addLeagueTask(
                new DetailedQuestStep(shatteredClass,
                        new WorldPoint(2853, 3164, 0),
                        "Equip a Full Obsidian Armour Set",
                        new SkillRequirement(Skill.DEFENCE, 60, false),
                        new CombatLevelRequirement(80)),
                50
        );

        addLeagueTask(
                new DetailedQuestStep(shatteredClass,
                        new WorldPoint(2853, 3164, 0),
                        "Equip a Toktz-Ket-Xil",
                        new SkillRequirement(Skill.DEFENCE, 60, false),
                        new ItemRequirement("Obby shield", ItemID.TOKTZKETXIL).quantity(1)),
                50
        );

        addLeagueTask(
                new DetailedQuestStep(shatteredClass,
                        new WorldPoint(2745, 3147, 0),
                        "Equip Some Dragon Platelegs or a Dragon Plateskirt",
                        new SkillRequirement(Skill.DEFENCE, 60, false),
                        new CombatLevelRequirement(70)),
                50
        );

        addLeagueTask(
                new DetailedQuestStep(shatteredClass,
                        new WorldPoint(2921, 3742, 0),
                        "Equip a Pair of Dragon Boots",
                        new CombatLevelRequirement(80),
                        new SkillRequirement(Skill.SLAYER, 83, false)),
                50
        );

        addLeagueTask(
                new DetailedQuestStep(shatteredClass,
                        "Reach Level 99 Defence",
                        new SkillRequirement(Skill.DEFENCE, 99, false)),
                125
        );

        addLeagueTask(
                new DetailedQuestStep(shatteredClass,
                        "Obtain 25 Million Defence XP",
                        new SkillRequirement(Skill.DEFENCE, 99, false)),
                125
        );

        addLeagueTask(
                new DetailedQuestStep(shatteredClass,
                        "Equip a Full Dragon Set",
                        new CombatLevelRequirement(126)),
                125
        );

        addLeagueTask(
                new DetailedQuestStep(shatteredClass,
                        new WorldPoint(3650, 3219, 0),
                        "Equip a Piece of the Justiciar Set",
                        new SkillRequirement(Skill.DEFENCE, 75, false),
                        new QuestRequirement(QuestHelperQuest.SINS_OF_THE_FATHER, QuestState.FINISHED)),
                125
        );

        addLeagueTask(
                new DetailedQuestStep(shatteredClass,
                        new WorldPoint(3650, 3219, 0),
                        "Equip a Full Justiciar Set",
                        new QuestRequirement(QuestHelperQuest.SINS_OF_THE_FATHER, QuestState.FINISHED),
                        new CombatLevelRequirement(120)),
                250
        );

        addLeagueTask(
                new DetailedQuestStep(shatteredClass,
                        new WorldPoint(2807, 3460, 0),
                        "Rake a Farming Patch",
                        new ItemRequirement("Rake", ItemID.RAKE).quantity(1)),
                0
        );

        addLeagueTask(
                new DetailedQuestStep(shatteredClass,
                        new WorldPoint(2807, 3460, 0),
                        "Plant Seeds in an Allotment Patch",
                        new ItemRequirement("Potato Seeds", ItemID.POTATO_SEED).quantity(1),
                        new ItemRequirement("Seed Dibber", ItemID.SEED_DIBBER).quantity(1),
                        new ItemRequirement("Rake", ItemID.RAKE).quantity(1)),
                0
        );

        addLeagueTask(
                new DetailedQuestStep(shatteredClass,
                        new WorldPoint(1761, 3559, 0),
                        "Complete 1 Farming Contract",
                        new SkillRequirement(Skill.FARMING, 45, false)),
                5
        );

        addLeagueTask(
                new DetailedQuestStep(shatteredClass,
                        new WorldPoint(2807, 3460, 0),
                        "Protect Your Crops",
                        new ItemRequirement("Buckets of Compost", ItemID.COMPOST).quantity(2)),
                5
        );

        addLeagueTask(
                new DetailedQuestStep(shatteredClass,
                        new WorldPoint(1761, 3559, 0),
                        "Plant 100 Golovanova Seeds",
                        new SkillRequirement(Skill.FARMING, 34, false)),
                25
        );

        addLeagueTask(
                new DetailedQuestStep(shatteredClass,
                        new WorldPoint(1249, 3719, 0),
                        "Enter the Farming Guild",
                        new SkillRequirement(Skill.FARMING, 45, false)),
                25
        );

        addLeagueTask(
                new DetailedQuestStep(shatteredClass,
                        new WorldPoint(2809, 3463, 0),
                        "Harvest an Irit Leaf",
                        new ItemRequirement("Irit Seed", ItemID.IRIT_SEED).quantity(1),
                        new SkillRequirement(Skill.FARMING, 44, false)),
                25
        );

        addLeagueTask(
                new DetailedQuestStep(shatteredClass,
                        new WorldPoint(2809, 3463, 0),
                        "Fill a Bucket With Supercompost",
                        new ItemRequirement("Pineapple", ItemID.PINEAPPLE).quantity(1)),
                25
        );

        addLeagueTask(
                new DetailedQuestStep(shatteredClass,
                        new WorldPoint(2859, 3433, 0),
                        "Check a grown Fruit Tree",
                        new ItemRequirement("Apple tree seed", ItemID.APPLE_TREE_SEED).quantity(1),
                        new SkillRequirement(Skill.FARMING, 27, false)),
                25
        );

        addLeagueTask(
                new DetailedQuestStep(shatteredClass,
                        new WorldPoint(2345, 3163, 0),
                        "Check a grown Papaya Tree in Lletya",
                        new QuestRequirement(QuestHelperQuest.UNDERGROUND_PASS, QuestState.FINISHED)),
                25
        );

        addLeagueTask(
                new DetailedQuestStep(shatteredClass,
                        new WorldPoint(2471, 3446, 0),
                        "Check a grown Papaya Tree in the Gnome Stronghold",
                        new SkillRequirement(Skill.FARMING, 57, false)),
                25
        );

        addLeagueTask(
                new DetailedQuestStep(shatteredClass,
                        new WorldPoint(2827, 3692, 0),
                        "Harvest Any Herb at the Troll Stronghold",
                        new QuestRequirement(QuestHelperQuest.MY_ARMS_BIG_ADVENTURE, QuestState.FINISHED),
                        new SkillRequirement(Skill.FARMING, 9, false)),
                25
        );

        addLeagueTask(
                new DetailedQuestStep(shatteredClass,
                        new WorldPoint(1761, 3559, 0),
                        "Plant 100 Bologano Seeds",
                        new SkillRequirement(Skill.FARMING, 54, false)),
                50
        );

        addLeagueTask(
                new DetailedQuestStep(shatteredClass,
                        new WorldPoint(1249, 3719, 0),
                        "Enter the Farming Guild's Mid Tier",
                        new SkillRequirement(Skill.FARMING, 65, false)),
                50
        );

        addLeagueTask(
                new DetailedQuestStep(shatteredClass,
                        new WorldPoint(2856, 3432, 0),
                        "Check a grown Palm Tree",
                        new ItemRequirement("Palm Tree Seed", ItemID.PALM_TREE_SEED).quantity(1),
                        new SkillRequirement(Skill.FARMING, 68, false)),
                50
        );

        addLeagueTask(
                new DetailedQuestStep(shatteredClass,
                        new WorldPoint(2437, 3419, 0),
                        "Dig Up Some Magic Roots",
                        new ItemRequirement("Magic Seed", ItemID.MAGIC_SEED).quantity(1),
                        new SkillRequirement(Skill.FARMING, 75, false),
                        new SkillRequirement(Skill.WOODCUTTING, 75, false)),
                50
        );

        addLeagueTask(
                new DetailedQuestStep(shatteredClass,
                        new WorldPoint(3195, 3233, 0),
                        "Check a grown Magic Tree in Lumbridge",
                        new SkillRequirement(Skill.FARMING, 75, false)),
                50
        );

        addLeagueTask(
                new DetailedQuestStep(shatteredClass,
                        new WorldPoint(3707, 3836, 0),
                        "Check a grown Mahogany Tree",
                        new QuestRequirement(QuestHelperQuest.BONE_VOYAGE, QuestState.FINISHED),
                        new SkillRequirement(Skill.FARMING, 55, false)),
                50
        );

        addLeagueTask(
                new DetailedQuestStep(shatteredClass,
                        new WorldPoint(2241, 3266, 0),
                        "Harvest Some Sweetcorn in Prifddinas",
                        new QuestRequirement(QuestHelperQuest.SONG_OF_THE_ELVES, QuestState.FINISHED)),
                50
        );

        addLeagueTask(
                new DetailedQuestStep(shatteredClass,
                        new WorldPoint(3291, 6115, 0),
                        "Check a grown Crystal Tree",
                        new SkillRequirement(Skill.FARMING, 74, false),
                        new SkillRequirement(Skill.HUNTER, 80, false),
                        new QuestRequirement(QuestHelperQuest.SONG_OF_THE_ELVES, QuestState.FINISHED)),
                50
        );

        addLeagueTask(
                new DetailedQuestStep(shatteredClass,
                        "Harvest a Snapdragon in Weiss",
                        new QuestRequirement(QuestHelperQuest.MAKING_FRIENDS_WITH_MY_ARM, QuestState.FINISHED),
                        new SkillRequirement(Skill.FARMING, 62, false)),
                50
        );

        addLeagueTask(
                new DetailedQuestStep(shatteredClass,
                        new WorldPoint(2796, 3097, 0),
                        "Check a grown Calquat Tree",
                        new SkillRequirement(Skill.FARMING, 72, false)),
                50
        );

        addLeagueTask(
                new DetailedQuestStep(shatteredClass,
                        new WorldPoint(3313, 3204, 0),
                        "Check a grown Cactus",
                        new SkillRequirement(Skill.FARMING, 55, false)),
                50
        );

        addLeagueTask(
                new DetailedQuestStep(shatteredClass,
                        new WorldPoint(3313, 3203, 0),
                        "Check a grown Potato Cactus",
                        new SkillRequirement(Skill.FARMING, 64, false)),
                50
        );

        addLeagueTask(
                new DetailedQuestStep(shatteredClass,
                        "Reach Level 99 Farming",
                        new SkillRequirement(Skill.FARMING, 99, false)),
                125
        );

        addLeagueTask(
                new DetailedQuestStep(shatteredClass,
                        "Obtain 25 Million Farming XP",
                        new SkillRequirement(Skill.FARMING, 99, false)),
                125
        );

        addLeagueTask(
                new DetailedQuestStep(shatteredClass,
                        "Travel Between Your Spirit Trees",
                        new SkillRequirement(Skill.FARMING, 91, false)),
                125
        );

        addLeagueTask(
                new DetailedQuestStep(shatteredClass,
                        new WorldPoint(2858, 3433, 0),
                        "Check a grown Dragonfruit Tree in Catherby",
                        new SkillRequirement(Skill.FARMING, 81, false)),
                125
        );

        addLeagueTask(
                new DetailedQuestStep(shatteredClass,
                        "Burn Some Normal Logs",
                        new ItemRequirement("Log", ItemID.LOGS).quantity(1)),
                5
        );

        addLeagueTask(
                new DetailedQuestStep(shatteredClass,
                        new WorldPoint(1630, 3959, 0),
                        "1 Wintertodt Kill",
                        new SkillRequirement(Skill.FIREMAKING, 50, false)),
                5
        );

        addLeagueTask(
                new DetailedQuestStep(shatteredClass,
                        "Burn Some Oak Logs",
                        new ItemRequirement("Oak Log", ItemID.OAK_LOGS).quantity(1),
                        new SkillRequirement(Skill.FIREMAKING, 15, false)),
                5
        );

        addLeagueTask(
                new DetailedQuestStep(shatteredClass,
                        new WorldPoint(2564, 3083, 0),
                        "Light a Torch"),
                5
        );

        addLeagueTask(
                new DetailedQuestStep(shatteredClass,
                        new WorldPoint(1630, 3959, 0),
                        "200 Wintertodt Kills",
                        new SkillRequirement(Skill.FIREMAKING, 50, false)),
                25
        );

        addLeagueTask(
                new DetailedQuestStep(shatteredClass,
                        new WorldPoint(1630, 3959, 0),
                        "300 Wintertodt Kills",
                        new SkillRequirement(Skill.FIREMAKING, 50, false)),
                25
        );

        addLeagueTask(
                new DetailedQuestStep(shatteredClass,
                        new WorldPoint(1630, 3959, 0),
                        "400 Wintertodt Kills",
                        new SkillRequirement(Skill.FIREMAKING, 50, false)),
                25
        );

        addLeagueTask(
                new DetailedQuestStep(shatteredClass,
                        new WorldPoint(1630, 3959, 0),
                        "500 Wintertodt Kills",
                        new SkillRequirement(Skill.FIREMAKING, 50, false)),
                25
        );

        addLeagueTask(
                new DetailedQuestStep(shatteredClass,
                        "Burn 100 Willow Logs",
                        new SkillRequirement(Skill.FIREMAKING, 30, false)),
                25
        );

        addLeagueTask(
                new DetailedQuestStep(shatteredClass,
                        new WorldPoint(2431, 3426, 0),
                        "Equip a Harpie Bug Lantern",
                        new SkillRequirement(Skill.FIREMAKING, 33, false),
                        new SkillRequirement(Skill.SLAYER, 33, false)),
                25
        );

        addLeagueTask(
                new DetailedQuestStep(shatteredClass,
                        new WorldPoint(2933, 3211, 0),
                        "Light a bullseye lantern",
                        new QuestRequirement(QuestHelperQuest.TEARS_OF_GUTHIX, QuestState.FINISHED),
                        new SkillRequirement(Skill.FIREMAKING, 49, false)),
                25
        );

        addLeagueTask(
                new DetailedQuestStep(shatteredClass,
                        "Burn 100 Yew Logs",
                        new SkillRequirement(Skill.FIREMAKING, 60, false)),
                50
        );

        addLeagueTask(
                new DetailedQuestStep(shatteredClass,
                        "Burn Some Magic Logs",
                        new SkillRequirement(Skill.FIREMAKING, 75, false)),
                50
        );

        addLeagueTask(
                new DetailedQuestStep(shatteredClass,
                        "Reach Level 99 Firemaking",
                        new SkillRequirement(Skill.FIREMAKING, 99, false)),
                125
        );

        addLeagueTask(
                new DetailedQuestStep(shatteredClass,
                        "Obtain 25 Million Firemaking XP",
                        new SkillRequirement(Skill.FIREMAKING, 99, false)),
                125
        );

        addLeagueTask(
                new DetailedQuestStep(shatteredClass,
                        new WorldPoint(2837, 3432, 0),
                        "Catch a Shrimp"),
                5
        );

        addLeagueTask(
                new DetailedQuestStep(shatteredClass,
                        new WorldPoint(2837, 3432, 0),
                        "Catch a Herring",
                        new SkillRequirement(Skill.FISHING, 10, false)),
                5
        );

        addLeagueTask(
                new DetailedQuestStep(shatteredClass,
                        new WorldPoint(2837, 3432, 0),
                        "Catch an Anchovy",
                        new SkillRequirement(Skill.FISHING, 15, false)),
                5
        );

        addLeagueTask(
                new DetailedQuestStep(shatteredClass,
                        new WorldPoint(2809, 3012, 0),
                        "Catch a Karambwanji",
                        new SkillRequirement(Skill.FISHING, 5, false)),
                5
        );

        addLeagueTask(
                new DetailedQuestStep(shatteredClass,
                        new WorldPoint(2663, 3163, 0),
                        "Complete a Fishing Trawler Game"),
                5
        );

        addLeagueTask(
                new DetailedQuestStep(shatteredClass,
                        new WorldPoint(2835, 3432, 0),
                        "Catch 100 Lobsters",
                        new SkillRequirement(Skill.FISHING, 40, false)),
                25
        );

        addLeagueTask(
                new DetailedQuestStep(shatteredClass,
                        new WorldPoint(2835, 3432, 0),
                        "Catch 50 Swordfish",
                        new SkillRequirement(Skill.FISHING, 50, false)),
                25
        );

        addLeagueTask(
                new DetailedQuestStep(shatteredClass,
                        new WorldPoint(2562, 3372, 0),
                        "Catch 50 Salmon",
                        new SkillRequirement(Skill.FISHING, 30, false)),
                25
        );

        addLeagueTask(
                new DetailedQuestStep(shatteredClass,
                        new WorldPoint(2856, 2972, 0),
                        "Catch a Salmon on Karamja",
                        new SkillRequirement(Skill.FISHING, 30, false)),
                25
        );

        addLeagueTask(
                new DetailedQuestStep(shatteredClass,
                        new WorldPoint(2610, 3393, 0),
                        "Enter the Fishing Guild",
                        new SkillRequirement(Skill.FISHING, 68, false)),
                25
        );

        addLeagueTask(
                new DetailedQuestStep(shatteredClass,
                        new WorldPoint(2836, 3430, 0),
                        "Catch 100 Shark",
                        new SkillRequirement(Skill.FISHING, 76, false)),
                50
        );

        addLeagueTask(
                new DetailedQuestStep(shatteredClass,
                        new WorldPoint(2903, 3118, 0),
                        "Catch 100 Karambwans",
                        new QuestRequirement(QuestHelperQuest.TAI_BWO_WANNAI_TRIO, QuestState.FINISHED),
                        new SkillRequirement(Skill.FISHING, 65, false)),
                50
        );

        addLeagueTask(
                new DetailedQuestStep(shatteredClass,
                        new WorldPoint(2345, 3700, 0),
                        "Catch a Monkfish",
                        new SkillRequirement(Skill.FISHING, 62, false),
                        new QuestRequirement(QuestHelperQuest.SWAN_SONG, QuestState.FINISHED)),
                50
        );

        addLeagueTask(
                new DetailedQuestStep(shatteredClass,
                        new WorldPoint(2664, 3162, 0),
                        "Equip a Full Angler's Outfit",
                        new SkillRequirement(Skill.FISHING, 34, false)),
                50
        );

        addLeagueTask(
                new DetailedQuestStep(shatteredClass,
                        new WorldPoint(3184, 3946, 0),
                        "Catch 100 Dark Crabs",
                        new SkillRequirement(Skill.FISHING, 85, false)),
                50
        );

        addLeagueTask(
                new DetailedQuestStep(shatteredClass,
                        "Reach Level 99 Fishing",
                        new SkillRequirement(Skill.FISHING, 99, false)),
                125
        );

        addLeagueTask(
                new DetailedQuestStep(shatteredClass,
                        "Obtain 25 Million Fishing XP",
                        new SkillRequirement(Skill.FISHING, 99, false)),
                125
        );

        addLeagueTask(
                new DetailedQuestStep(shatteredClass,
                        new WorldPoint(2187, 3067, 0),
                        "Dissect 50 Sacred Eels",
                        new SkillRequirement(Skill.FISHING, 87, false),
                        new SkillRequirement(Skill.COOKING, 72, false),
                        new QuestRequirement(QuestHelperQuest.REGICIDE, QuestState.FINISHED)),
                125
        );

        addLeagueTask(
                new DetailedQuestStep(shatteredClass,
                        "Fletch Some Arrow Shafts",
                        new ItemRequirement("Logs", ItemID.LOGS).quantity(1),
                        new ItemRequirement("Knife", ItemID.KNIFE).quantity(1)),
                5
        );

        addLeagueTask(
                new DetailedQuestStep(shatteredClass,
                        "Fletch an Oak Shortbow",
                        new ItemRequirement("Oak Logs", ItemID.OAK_LOGS).quantity(1),
                        new ItemRequirement("Knife", ItemID.KNIFE).quantity(1),
                        new SkillRequirement(Skill.FLETCHING, 20, false)),
                5
        );

        addLeagueTask(
                new DetailedQuestStep(shatteredClass,
                        "Fletch 150 Iron Arrows",
                        new ItemRequirement("Logs", ItemID.LOGS).quantity(1),
                        new ItemRequirement("Knife", ItemID.KNIFE).quantity(1),
                        new ItemRequirement("Feathers", ItemID.FEATHER).quantity(1),
                        new ItemRequirement("Iron Arrowtips", ItemID.IRON_ARROWTIPS).quantity(1),
                        new SkillRequirement(Skill.FLETCHING, 15, false)),
                5
        );

        addLeagueTask(
                new DetailedQuestStep(shatteredClass,
                        "Fletch a Willow Shortbow",
                        new SkillRequirement(Skill.FLETCHING, 35, false)),
                25
        );

        addLeagueTask(
                new DetailedQuestStep(shatteredClass,
                        "Create a Mithril Grapple",
                        new SkillRequirement(Skill.FLETCHING, 59, true),
                        new SkillRequirement(Skill.SMITHING, 59, true)),
                25
        );

        addLeagueTask(
                new DetailedQuestStep(shatteredClass,
                        "Fletch some Broad Arrows or Bolts",
                        new SkillRequirement(Skill.FLETCHING, 52, true),
                        new SkillRequirement(Skill.SLAYER, 2, false)),
                25
        );

        addLeagueTask(
                new DetailedQuestStep(shatteredClass,
                        new WorldPoint(2724, 3485, 0),
                        "Fletch 50 Maple Longbow (u) in Kandarin",
                        new SkillRequirement(Skill.FLETCHING, 55, false),
                        new SkillRequirement(Skill.WOODCUTTING, 45, false)),
                25
        );

        addLeagueTask(
                new DetailedQuestStep(shatteredClass,
                        "Fletch a Magic Shortbow",
                        new SkillRequirement(Skill.WOODCUTTING, 75, false),
                        new SkillRequirement(Skill.FLETCHING, 80, false)),
                50
        );

        addLeagueTask(
                new DetailedQuestStep(shatteredClass,
                        "Fletch a Rune Crossbow",
                        new SkillRequirement(Skill.FLETCHING, 69, false)),
                50
        );

        addLeagueTask(
                new DetailedQuestStep(shatteredClass,
                        "Reach Level 99 Fletching",
                        new SkillRequirement(Skill.FLETCHING, 99, false)),
                125
        );

        addLeagueTask(
                new DetailedQuestStep(shatteredClass,
                        "Obtain 25 Million Fletching XP",
                        new SkillRequirement(Skill.FLETCHING, 99, false)),
                125
        );

        addLeagueTask(
                new DetailedQuestStep(shatteredClass,
                        "Clean a Grimy Guam",
                        new ItemRequirement("Grimy Guam", ItemID.GRIMY_GUAM_LEAF).quantity(1),
                        new SkillRequirement(Skill.HERBLORE, 3, false)),
                5
        );

        addLeagueTask(
                new DetailedQuestStep(shatteredClass,
                        "Make an Attack Potion",
                        new ItemRequirement("Grimy Guam", ItemID.GRIMY_GUAM_LEAF).quantity(1),
                        new ItemRequirement("Eye of Newt", ItemID.EYE_OF_NEWT).quantity(1),
                        new SkillRequirement(Skill.HERBLORE, 3, false)),
                5
        );

        addLeagueTask(
                new DetailedQuestStep(shatteredClass,
                        new WorldPoint(3193, 3405, 0),
                        "Drink a strength potion",
                        new ItemRequirement("Limpwurt", ItemID.LIMPWURT_ROOT).quantity(1)),
                5
        );

        addLeagueTask(
                new DetailedQuestStep(shatteredClass,
                        "Make 30 Prayer Potions",
                        new SkillRequirement(Skill.HERBLORE, 38, false)),
                25
        );

        addLeagueTask(
                new DetailedQuestStep(shatteredClass,
                        "Clean a Grimy Avantoe",
                        new SkillRequirement(Skill.HERBLORE, 48, false)),
                25
        );

        addLeagueTask(
                new DetailedQuestStep(shatteredClass,
                        "Make a 4 dose potion",
                        new ItemRequirement("Amulet of chemistry", ItemID.AMULET_OF_CHEMISTRY).quantity(1),
                        new SkillRequirement(Skill.CRAFTING, 34, false),
                        new SkillRequirement(Skill.MAGIC, 27, false)),
                25
        );

        addLeagueTask(
                new DetailedQuestStep(shatteredClass,
                        "Make a Combat Potion",
                        new SkillRequirement(Skill.HERBLORE, 36, false)),
                25
        );

        addLeagueTask(
                new DetailedQuestStep(shatteredClass,
                        "Make a Saradomin Brew",
                        new SkillRequirement(Skill.HERBLORE, 81, false)),
                50
        );

        addLeagueTask(
                new DetailedQuestStep(shatteredClass,
                        "Clean 100 Grimy Dwarf Weed",
                        new SkillRequirement(Skill.HERBLORE, 70, false)),
                50
        );

        addLeagueTask(
                new DetailedQuestStep(shatteredClass,
                        "Make 20 Ranging Potions",
                        new SkillRequirement(Skill.HERBLORE, 72, false)),
                50
        );

        addLeagueTask(
                new DetailedQuestStep(shatteredClass,
                        "Make 20 Stamina Potions",
                        new SkillRequirement(Skill.HERBLORE, 77, false)),
                50
        );

        addLeagueTask(
                new DetailedQuestStep(shatteredClass,
                        "Make 20 Magic Potions",
                        new SkillRequirement(Skill.HERBLORE, 76, false)),
                50
        );

        addLeagueTask(
                new DetailedQuestStep(shatteredClass,
                        "Make a Saradomin Brew",
                        new SkillRequirement(Skill.HERBLORE, 81, false)),
                50
        );

        addLeagueTask(
                new DetailedQuestStep(shatteredClass,
                        "Clean 100 Grimy Dwarf Weed",
                        new SkillRequirement(Skill.HERBLORE, 70, false)),
                50
        );

        addLeagueTask(
                new DetailedQuestStep(shatteredClass,
                        "Make 20 Ranging Potions",
                        new SkillRequirement(Skill.HERBLORE, 72, false)),
                50
        );

        addLeagueTask(
                new DetailedQuestStep(shatteredClass,
                        "Make 20 Stamina Potions",
                        new SkillRequirement(Skill.HERBLORE, 77, false)),
                50
        );

        addLeagueTask(
                new DetailedQuestStep(shatteredClass,
                        "Make 20 Magic Potions",
                        new SkillRequirement(Skill.HERBLORE, 76, false)),
                50
        );

        addLeagueTask(
                new DetailedQuestStep(shatteredClass,
                        "Reach Level 99 Herblore",
                        new SkillRequirement(Skill.HERBLORE, 99, false)),
                125
        );

        addLeagueTask(
                new DetailedQuestStep(shatteredClass,
                        "Obtain 25 Million Herblore XP",
                        new SkillRequirement(Skill.HERBLORE, 99, false)),
                125
        );

        addLeagueTask(
                new DetailedQuestStep(shatteredClass,
                        "Make a Super Combat Potion",
                        new SkillRequirement(Skill.HERBLORE, 90, true)),
                125
        );

        addLeagueTask(
                new DetailedQuestStep(shatteredClass,
                        "Make an Extended Antifire Potion",
                        new SkillRequirement(Skill.HERBLORE, 84, false)),
                125
        );

        addLeagueTask(
                new DetailedQuestStep(shatteredClass,
                        "Reach Level 99 Hitpoints",
                        new SkillRequirement(Skill.HITPOINTS, 99, false)),
                125
        );

        addLeagueTask(
                new DetailedQuestStep(shatteredClass,
                        "Obtain 25 Million Hitpoints XP",
                        new SkillRequirement(Skill.HITPOINTS, 99, false)),
                125
        );

        addLeagueTask(
                new DetailedQuestStep(shatteredClass,
                        "Catch a Baby Impling",
                        new SkillRequirement(Skill.HUNTER, 17, false)),
                5
        );

        addLeagueTask(
                new DetailedQuestStep(shatteredClass,
                        new WorldPoint(2557, 2912, 0),
                        "Snare a Bird",
                        new ItemRequirement("Bird Snare", ItemID.BIRD_SNARE).quantity(1)),
                5
        );

        addLeagueTask(
                new DetailedQuestStep(shatteredClass,
                        new WorldPoint(2558, 2912, 0),
                        "Catch a Crimson Swift in the Feldip Hills"),
                5
        );

        addLeagueTask(
                new DetailedQuestStep(shatteredClass,
                        new WorldPoint(2548, 2907, 0),
                        "Equip full Graahk, Larupia or Kyatt",
                        new SkillRequirement(Skill.HUNTER, 31, false)),
                25
        );

        addLeagueTask(
                new DetailedQuestStep(shatteredClass,
                        new WorldPoint(3536, 3448, 0),
                        "Catch a Swamp Lizard or Salamander",
                        new QuestRequirement(QuestHelperQuest.PRIEST_IN_PERIL, QuestState.FINISHED),
                        new SkillRequirement(Skill.HUNTER, 29, false)),
                25
        );

        addLeagueTask(
                new DetailedQuestStep(shatteredClass,
                        new WorldPoint(2341, 3588, 0),
                        "Catch a Butterfly",
                        new SkillRequirement(Skill.HUNTER, 15, false)),
                25
        );

        addLeagueTask(
                new DetailedQuestStep(shatteredClass,
                        new WorldPoint(3760, 3760, 0),
                        "Dismantle 20 Filled Bird Houses",
                        new QuestRequirement(QuestHelperQuest.BONE_VOYAGE, QuestState.FINISHED),
                        new SkillRequirement(Skill.HUNTER, 5, false),
                        new SkillRequirement(Skill.CRAFTING, 5, false)),
                25
        );

        addLeagueTask(
                new DetailedQuestStep(shatteredClass,
                        new WorldPoint(3760, 3760, 0),
                        "Setup a Yew Bird House",
                        new QuestRequirement(QuestHelperQuest.BONE_VOYAGE, QuestState.FINISHED),
                        new SkillRequirement(Skill.HUNTER, 59, false),
                        new SkillRequirement(Skill.CRAFTING, 60, false)),
                25
        );

        addLeagueTask(
                new DetailedQuestStep(shatteredClass,
                        new WorldPoint(3199, 3170, 0),
                        "Catch 50 Implings in Puro-Puro",
                        new QuestRequirement(QuestHelperQuest.LOST_CITY, QuestState.FINISHED),
                        new SkillRequirement(Skill.HUNTER, 17, false)),
                25
        );

        addLeagueTask(
                new DetailedQuestStep(shatteredClass,
                        new WorldPoint(2722, 3790, 0),
                        "Catch a Snowy Knight",
                        new SkillRequirement(Skill.HUNTER, 35, false)),
                25
        );

        addLeagueTask(
                new DetailedQuestStep(shatteredClass,
                        new WorldPoint(2547, 2907, 0),
                        "Trap a Spined Larupia in the Feldip Hills",
                        new SkillRequirement(Skill.HUNTER, 31, false)),
                25
        );

        addLeagueTask(
                new DetailedQuestStep(shatteredClass,
                        new WorldPoint(2383, 3595, 0),
                        "Equip a Spottier Cape",
                        new SkillRequirement(Skill.HUNTER, 66, false)),
                25
        );

        addLeagueTask(
                new DetailedQuestStep(shatteredClass,
                        new WorldPoint(2475, 3242, 0),
                        "Catch a Red Salamander",
                        new SkillRequirement(Skill.HUNTER, 59, false)),
                25
        );

        addLeagueTask(
                new DetailedQuestStep(shatteredClass,
                        new WorldPoint(3402, 3106, 0),
                        "Catch 30 Orange Salamanders",
                        new SkillRequirement(Skill.HUNTER, 47, false)),
                25
        );

        addLeagueTask(
                new DetailedQuestStep(shatteredClass,
                        new WorldPoint(3537, 3446, 0),
                        "Catch a Swamp Lizard in Morytania",
                        new SkillRequirement(Skill.HUNTER, 29, false),
                        new QuestRequirement(QuestHelperQuest.PRIEST_IN_PERIL, QuestState.FINISHED)),
                25
        );

        addLeagueTask(
                new DetailedQuestStep(shatteredClass,
                        new WorldPoint(3304, 3666, 0),
                        "Catch a Black Salamander",
                        new SkillRequirement(Skill.HUNTER, 67, false)),
                25
        );

        addLeagueTask(
                new DetailedQuestStep(shatteredClass,
                        "Catch a Dragon Impling",
                        new SkillRequirement(Skill.HUNTER, 83, false)),
                50
        );

        addLeagueTask(
                new DetailedQuestStep(shatteredClass,
                        new WorldPoint(3762, 3759, 0),
                        "Setup a Magic Bird House",
                        new QuestRequirement(QuestHelperQuest.BONE_VOYAGE, QuestState.FINISHED),
                        new SkillRequirement(Skill.HUNTER, 74, false),
                        new SkillRequirement(Skill.CRAFTING, 75, false)),
                50
        );

        addLeagueTask(
                new DetailedQuestStep(shatteredClass,
                        new WorldPoint(3199, 3169, 0),
                        "Catch 200 Implings in Puro-Puro",
                        new QuestRequirement(QuestHelperQuest.LOST_CITY, QuestState.FINISHED),
                        new SkillRequirement(Skill.HUNTER, 17, false)),
                50
        );

        addLeagueTask(
                new DetailedQuestStep(shatteredClass,
                        new WorldPoint(3245, 6083, 0),
                        "Catch a Crystal Impling",
                        new SkillRequirement(Skill.HUNTER, 80, false),
                        new QuestRequirement(QuestHelperQuest.SONG_OF_THE_ELVES, QuestState.FINISHED)),
                50
        );

        addLeagueTask(
                new DetailedQuestStep(shatteredClass,
                        new WorldPoint(2703, 3789, 0),
                        "Trap a Sabre-Toothed Kyatt",
                        new SkillRequirement(Skill.HUNTER, 55, false)),
                50
        );

        addLeagueTask(
                new DetailedQuestStep(shatteredClass,
                        new WorldPoint(2557, 2928, 0),
                        "Catch 50 Red Chinchompas in Kandarin",
                        new SkillRequirement(Skill.HUNTER, 63, false),
                        new QuestRequirement(QuestHelperQuest.EAGLES_PEAK, QuestState.FINISHED)),
                50
        );

        addLeagueTask(
                new DetailedQuestStep(shatteredClass,
                        new WorldPoint(3142, 3782, 0),
                        "Catch a Black Chinchompa",
                        new SkillRequirement(Skill.HUNTER, 73, false)),
                50
        );

        addLeagueTask(
                new DetailedQuestStep(shatteredClass,
                        "Reach Level 99 Hunter",
                        new SkillRequirement(Skill.HUNTER, 99, false)),
                125
        );

        addLeagueTask(
                new DetailedQuestStep(shatteredClass,
                        "Obtain 25 Million Hunter XP",
                        new SkillRequirement(Skill.HUNTER, 99, false)),
                125
        );

        addLeagueTask(
                new DetailedQuestStep(shatteredClass,
                        "Catch a Lucky Impling Bare-Handed",
                        new SkillRequirement(Skill.HUNTER, 99, true)),
                125
        );

        addLeagueTask(
                new DetailedQuestStep(shatteredClass,
                        new WorldPoint(3695, 3834, 0),
                        "Catch a Herbiboar 100 Times",
                        new QuestRequirement(QuestHelperQuest.BONE_VOYAGE, QuestState.FINISHED),
                        new SkillRequirement(Skill.HUNTER, 80, false)),
                125
        );

        addLeagueTask(
                new DetailedQuestStep(shatteredClass,
                        new WorldPoint(3695, 3834, 0),
                        "Catch a Herbiboar 250 Times",
                        new QuestRequirement(QuestHelperQuest.BONE_VOYAGE, QuestState.FINISHED),
                        new SkillRequirement(Skill.HUNTER, 81, false)),
                125
        );

        addLeagueTask(
                new DetailedQuestStep(shatteredClass,
                        new WorldPoint(3695, 3834, 0),
                        "Catch a Herbiboar 500 Times",
                        new QuestRequirement(QuestHelperQuest.BONE_VOYAGE, QuestState.FINISHED),
                        new SkillRequirement(Skill.HUNTER, 82, false)),
                125
        );

        addLeagueTask(
                new DetailedQuestStep(shatteredClass,
                        new WorldPoint(3695, 3834, 0),
                        "Receive a Torstol From a Herbiboar",
                        new QuestRequirement(QuestHelperQuest.BONE_VOYAGE, QuestState.FINISHED),
                        new SkillRequirement(Skill.HUNTER, 80, false),
                        new SkillRequirement(Skill.HERBLORE, 77, false)),
                125
        );

        addLeagueTask(
                new DetailedQuestStep(shatteredClass,
                        new WorldPoint(3245, 6083, 0),
                        "Equip an Elven Signet",
                        new SkillRequirement(Skill.HUNTER, 80, false),
                        new QuestRequirement(QuestHelperQuest.SONG_OF_THE_ELVES, QuestState.FINISHED)),
                125
        );

        addLeagueTask(
                new DetailedQuestStep(shatteredClass,
                        new WorldPoint(3141, 3773, 0),
                        "Equip 250 Black Chinchompas",
                        new SkillRequirement(Skill.HUNTER, 73, false)),
                125
        );

        addLeagueTask(
                new DetailedQuestStep(shatteredClass,
                        new WorldPoint(3141, 3773, 0),
                        "Equip 500 Black Chinchompas",
                        new SkillRequirement(Skill.HUNTER, 73, false)),
                125
        );

        addLeagueTask(
                new DetailedQuestStep(shatteredClass,
                        new WorldPoint(3141, 3773, 0),
                        "Equip 1000 Black Chinchompas",
                        new SkillRequirement(Skill.HUNTER, 73, false)),
                125
        );

        addLeagueTask(
                new DetailedQuestStep(shatteredClass,
                        "Cast Home Teleport"),
                0
        );

        addLeagueTask(
                new DetailedQuestStep(shatteredClass,
                        new WorldPoint(3111, 3169, 0),
                        "Equip a Wizard Robe and Hat"),
                5
        );

        addLeagueTask(
                new DetailedQuestStep(shatteredClass,
                        new WorldPoint(3202, 3435, 0),
                        "Equip an Elemental Staff"),
                5
        );

        addLeagueTask(
                new DetailedQuestStep(shatteredClass,
                        "Equip a Piece of a Mystic Set",
                        new ItemRequirement("Mystic boots", ItemID.MYSTIC_BOOTS).quantity(1),
                        new SkillRequirement(Skill.MAGIC, 40, false),
                        new SkillRequirement(Skill.DEFENCE, 20, false)),
                25
        );

        addLeagueTask(
                new DetailedQuestStep(shatteredClass,
                        "Teleport Using Law Runes",
                        new ItemRequirement("Law runes", ItemID.LAW_RUNE).quantity(1),
                        new SkillRequirement(Skill.MAGIC, 25, false)),
                25
        );

        addLeagueTask(
                new DetailedQuestStep(shatteredClass,
                        "Equip an Elemental Battlestaff or Mystic Staff",
                        new ItemRequirement("Fire Battlestaff", ItemID.FIRE_BATTLESTAFF).quantity(1),
                        new SkillRequirement(Skill.MAGIC, 30, false),
                        new SkillRequirement(Skill.ATTACK, 30, false)),
                25
        );

        addLeagueTask(
                new DetailedQuestStep(shatteredClass,
                        "Cast a Blast Spell",
                        new SkillRequirement(Skill.MAGIC, 41, false)),
                25
        );

        addLeagueTask(
                new DetailedQuestStep(shatteredClass,
                        "Cast High Level Alchemy",
                        new SkillRequirement(Skill.MAGIC, 55, false)),
                25
        );

        addLeagueTask(
                new DetailedQuestStep(shatteredClass,
                        "Cast Ice Rush",
                        new SkillRequirement(Skill.MAGIC, 58, false),
                        new QuestRequirement(QuestHelperQuest.DESERT_TREASURE, QuestState.FINISHED)),
                25
        );

        addLeagueTask(
                new DetailedQuestStep(shatteredClass,
                        new WorldPoint(3091, 3958, 0),
                        "Equip a God Cape",
                        new SkillRequirement(Skill.MAGIC, 60, false)),
                25
        );

        addLeagueTask(
                new DetailedQuestStep(shatteredClass,
                        new WorldPoint(3091, 3958, 0),
                        "Cast Saradomin Strike",
                        new SkillRequirement(Skill.MAGIC, 60, false)),
                25
        );

        addLeagueTask(
                new DetailedQuestStep(shatteredClass,
                        new WorldPoint(3091, 3958, 0),
                        "Cast Claws of Guthix",
                        new SkillRequirement(Skill.MAGIC, 60, false)),
                25
        );

        addLeagueTask(
                new DetailedQuestStep(shatteredClass,
                        new WorldPoint(3091, 3958, 0),
                        "Cast Flames of Zamorak",
                        new SkillRequirement(Skill.MAGIC, 60, false)),
                25
        );

        addLeagueTask(
                new DetailedQuestStep(shatteredClass,
                        "Cast Resurrect Crops",
                        new SkillRequirement(Skill.MAGIC, 78, false)),
                50
        );

        addLeagueTask(
                new DetailedQuestStep(shatteredClass,
                        new WorldPoint(1631, 3672, 0),
                        "Cast Kourend Castle Teleport",
                        new SkillRequirement(Skill.MAGIC, 69, false)),
                50
        );

        addLeagueTask(
                new DetailedQuestStep(shatteredClass,
                        "Equip a combination Battlestaff or Mystic Staff",
                        new ItemRequirement("Lava Battlestaff", ItemID.LAVA_BATTLESTAFF).quantity(1),
                        new SkillRequirement(Skill.MAGIC, 30, false),
                        new SkillRequirement(Skill.SLAYER, 75, false),
                        new SkillRequirement(Skill.ATTACK, 30, false)),
                50
        );

        addLeagueTask(
                new DetailedQuestStep(shatteredClass,
                        "Cast a Wave Spell",
                        new SkillRequirement(Skill.MAGIC, 62, false)),
                50
        );

        addLeagueTask(
                new DetailedQuestStep(shatteredClass,
                        "Cast a Surge Spell",
                        new SkillRequirement(Skill.MAGIC, 81, false)),
                50
        );

        addLeagueTask(
                new DetailedQuestStep(shatteredClass,
                        new WorldPoint(3173, 9897, 0),
                        "Equip Bryophyta's Staff",
                        new CombatLevelRequirement(100)),
                50
        );

        addLeagueTask(
                new DetailedQuestStep(shatteredClass,
                        new WorldPoint(2158, 3865, 0),
                        "Switch to the Lunar Spellbook",
                        new QuestRequirement(QuestHelperQuest.LUNAR_DIPLOMACY, QuestState.FINISHED)),
                50
        );

        addLeagueTask(
                new DetailedQuestStep(shatteredClass,
                        "Cast Moonclan Teleport",
                        new SkillRequirement(Skill.MAGIC, 69, false),
                        new QuestRequirement(QuestHelperQuest.LUNAR_DIPLOMACY, QuestState.FINISHED)),
                50
        );

        addLeagueTask(
                new DetailedQuestStep(shatteredClass,
                        "Cast Fertile Soil",
                        new SkillRequirement(Skill.MAGIC, 83, false),
                        new QuestRequirement(QuestHelperQuest.LUNAR_DIPLOMACY, QuestState.FINISHED)),
                50
        );

        addLeagueTask(
                new DetailedQuestStep(shatteredClass,
                        new WorldPoint(2620, 3686, 0),
                        "Equip a Mud Battlestaff",
                        new CombatLevelRequirement(100)),
                50
        );

        addLeagueTask(
                new DetailedQuestStep(shatteredClass,
                        "Cast Ice Burst",
                        new SkillRequirement(Skill.MAGIC, 70, false),
                        new QuestRequirement(QuestHelperQuest.DESERT_TREASURE, QuestState.FINISHED)),
                50
        );

        addLeagueTask(
                new DetailedQuestStep(shatteredClass,
                        "Cast Ice Blitz",
                        new SkillRequirement(Skill.MAGIC, 82, false),
                        new QuestRequirement(QuestHelperQuest.DESERT_TREASURE, QuestState.FINISHED)),
                50
        );

        addLeagueTask(
                new DetailedQuestStep(shatteredClass,
                        "Cast Smoke Barrage",
                        new SkillRequirement(Skill.MAGIC, 86, false),
                        new QuestRequirement(QuestHelperQuest.DESERT_TREASURE, QuestState.FINISHED)),
                50
        );

        addLeagueTask(
                new DetailedQuestStep(shatteredClass,
                        "Cast Shadow Barrage",
                        new SkillRequirement(Skill.MAGIC, 88, false),
                        new QuestRequirement(QuestHelperQuest.DESERT_TREASURE, QuestState.FINISHED)),
                50
        );

        addLeagueTask(
                new DetailedQuestStep(shatteredClass,
                        new WorldPoint(3363, 3296, 0),
                        "Equip a Piece of the Infinity Robe Set",
                        new SkillRequirement(Skill.MAGIC, 50, false)),
                50
        );

        addLeagueTask(
                new DetailedQuestStep(shatteredClass,
                        "Cast Paddewwa Teleport",
                        new SkillRequirement(Skill.MAGIC, 54, false),
                        new QuestRequirement(QuestHelperQuest.DESERT_TREASURE, QuestState.FINISHED)),
                50
        );

        addLeagueTask(
                new DetailedQuestStep(shatteredClass,
                        new WorldPoint(3091, 3958, 0),
                        "Imbue a God Cape",
                        new SkillRequirement(Skill.MAGIC, 60, false),
                        new QuestRequirement(QuestHelperQuest.THE_MAGE_ARENA_II, QuestState.FINISHED)),
                50
        );

        addLeagueTask(
                new DetailedQuestStep(shatteredClass,
                        new WorldPoint(3019, 3957, 0),
                        "Equip a Piece of the Dagon'Hai Set",
                        new SkillRequirement(Skill.MAGIC, 70, false),
                        new SkillRequirement(Skill.DEFENCE, 40, false)),
                50
        );

        addLeagueTask(
                new DetailedQuestStep(shatteredClass,
                        "Reach Level 99 Magic",
                        new SkillRequirement(Skill.MAGIC, 99, false)),
                125
        );

        addLeagueTask(
                new DetailedQuestStep(shatteredClass,
                        "Obtain 25 Million Magic XP",
                        new SkillRequirement(Skill.MAGIC, 99, false)),
                125
        );

        addLeagueTask(
                new DetailedQuestStep(shatteredClass,
                        "Cast Spellbook Swap",
                        new SkillRequirement(Skill.MAGIC, 96, false),
                        new QuestRequirement(QuestHelperQuest.LUNAR_DIPLOMACY, QuestState.FINISHED)),
                125
        );

        addLeagueTask(
                new DetailedQuestStep(shatteredClass,
                        "Create a Catherby Teleport Tablet",
                        new SkillRequirement(Skill.MAGIC, 87, false),
                        new QuestRequirement(QuestHelperQuest.LUNAR_DIPLOMACY, QuestState.FINISHED)),
                125
        );

        addLeagueTask(
                new DetailedQuestStep(shatteredClass,
                        "Cast Blood Barrage",
                        new SkillRequirement(Skill.MAGIC, 92, false),
                        new QuestRequirement(QuestHelperQuest.DESERT_TREASURE, QuestState.FINISHED)),
                125
        );

        addLeagueTask(
                new DetailedQuestStep(shatteredClass,
                        "Cast Ice Barrage",
                        new SkillRequirement(Skill.MAGIC, 94, false),
                        new QuestRequirement(QuestHelperQuest.DESERT_TREASURE, QuestState.FINISHED)),
                125
        );

        addLeagueTask(
                new DetailedQuestStep(shatteredClass,
                        new WorldPoint(3363, 3296, 0),
                        "Equip a Full Infinity Robe Set",
                        new SkillRequirement(Skill.MAGIC, 50, false)),
                125
        );

        addLeagueTask(
                new DetailedQuestStep(shatteredClass,
                        new WorldPoint(3363, 3296, 0),
                        "Equip a Master Wand",
                        new SkillRequirement(Skill.MAGIC, 60, false)),
                125
        );

        addLeagueTask(
                new DetailedQuestStep(shatteredClass,
                        new WorldPoint(3363, 3296, 0),
                        "Equip a Mage's Book",
                        new SkillRequirement(Skill.MAGIC, 60, false)),
                125
        );

        addLeagueTask(
                new DetailedQuestStep(shatteredClass,
                        new WorldPoint(3650, 3219, 0),
                        "Equip a Sanguinesti Staff",
                        new SkillRequirement(Skill.MAGIC, 75, false),
                        new QuestRequirement(QuestHelperQuest.SINS_OF_THE_FATHER, QuestState.FINISHED)),
                125
        );

        addLeagueTask(
                new DetailedQuestStep(shatteredClass,
                        new WorldPoint(3019, 3957, 0),
                        "Equip a Full Dagon'Hai Set",
                        new SkillRequirement(Skill.MAGIC, 70, false),
                        new SkillRequirement(Skill.DEFENCE, 40, false)),
                125
        );

        addLeagueTask(
                new DetailedQuestStep(shatteredClass,
                        "Craft a Ghorrock Teleport Tablet",
                        new SkillRequirement(Skill.MAGIC, 96, false),
                        new QuestRequirement(QuestHelperQuest.DESERT_TREASURE, QuestState.FINISHED)),
                125
        );

        addLeagueTask(
                new DetailedQuestStep(shatteredClass,
                        new WorldPoint(2626, 3143, 0),
                        "Mine some Copper Ore",
                        new ItemRequirement("Bronze pickaxe", ItemID.BRONZE_PICKAXE).quantity(1)),
                0
        );

        addLeagueTask(
                new DetailedQuestStep(shatteredClass,
                        "Mine some Ore With a Steel Pickaxe",
                        new ItemRequirement("Steel pickaxe", ItemID.STEEL_PICKAXE).quantity(1),
                        new SkillRequirement(Skill.MINING, 6, false)),
                5
        );

        addLeagueTask(
                new DetailedQuestStep(shatteredClass,
                        "Obtain a Gem while mining",
                        new SkillRequirement(Skill.MINING, 2, false)),
                5
        );

        addLeagueTask(
                new DetailedQuestStep(shatteredClass,
                        "Mine 50 Iron Ore",
                        new SkillRequirement(Skill.MINING, 15, false)),
                25
        );

        addLeagueTask(
                new DetailedQuestStep(shatteredClass,
                        "Mine some Ore With a Rune Pickaxe",
                        new SkillRequirement(Skill.MINING, 41, false)),
                25
        );

        addLeagueTask(
                new DetailedQuestStep(shatteredClass,
                        "Obtain a Clue Geode While Mining",
                        new SkillRequirement(Skill.MINING, 2, false)),
                25
        );

        addLeagueTask(
                new DetailedQuestStep(shatteredClass,
                        new WorldPoint(3819, 3808, 0),
                        "Complete a Volcanic Mine Game",
                        new SkillRequirement(Skill.MINING, 50, false)),
                25
        );

        addLeagueTask(
                new DetailedQuestStep(shatteredClass,
                        new WorldPoint(3064, 3377, 0),
                        "Obtain 20 Golden Nuggets",
                        new SkillRequirement(Skill.MINING, 30, false)),
                25
        );

        addLeagueTask(
                new DetailedQuestStep(shatteredClass,
                        new WorldPoint(3402, 3106, 0),
                        "Mine 30 Chunks of Granite",
                        new SkillRequirement(Skill.MINING, 45, false)),
                25
        );

        addLeagueTask(
                new DetailedQuestStep(shatteredClass,
                        new WorldPoint(1502, 3835, 0),
                        "Obtain Adamantite Ore at the Blast Mine",
                        new SkillRequirement(Skill.MINING, 60, false)),
                50
        );

        addLeagueTask(
                new DetailedQuestStep(shatteredClass,
                        "Mine 50 Adamantite Ore",
                        new SkillRequirement(Skill.MINING, 70, false)),
                50
        );

        addLeagueTask(
                new DetailedQuestStep(shatteredClass,
                        new WorldPoint(3819, 3808, 0),
                        "Buy an Ash Covered Tome",
                        new QuestRequirement(QuestHelperQuest.BONE_VOYAGE, QuestState.FINISHED),
                        new SkillRequirement(Skill.MINING, 50, false)),
                50
        );

        addLeagueTask(
                new DetailedQuestStep(shatteredClass,
                        "Use Some Icy Basalt to Teleport to Weiss",
                        new QuestRequirement(QuestHelperQuest.MAKING_FRIENDS_WITH_MY_ARM, QuestState.FINISHED)),
                50
        );

        addLeagueTask(
                new DetailedQuestStep(shatteredClass,
                        "Use Your Portal Nexus to Teleport to Weiss",
                        new QuestRequirement(QuestHelperQuest.MAKING_FRIENDS_WITH_MY_ARM, QuestState.FINISHED),
                        new SkillRequirement(Skill.CONSTRUCTION, 72, false)),
                50
        );

        addLeagueTask(
                new DetailedQuestStep(shatteredClass,
                        new WorldPoint(3059, 3379, 0),
                        "Equip a Full Prospector Outfit",
                        new SkillRequirement(Skill.MINING, 30, false)),
                50
        );

        addLeagueTask(
                new DetailedQuestStep(shatteredClass,
                        new WorldPoint(3624, 3325, 0),
                        "Convert 2,000 Daeyalt Shards Into Essence",
                        new SkillRequirement(Skill.MINING, 60, false),
                        new QuestRequirement(QuestHelperQuest.PRIEST_IN_PERIL, QuestState.FINISHED),
                        new QuestRequirement(QuestHelperQuest.SINS_OF_THE_FATHER, QuestState.FINISHED)),
                50
        );

        addLeagueTask(
                new DetailedQuestStep(shatteredClass,
                        "Reach Level 99 Mining",
                        new SkillRequirement(Skill.MINING, 99, false)),
                125
        );

        addLeagueTask(
                new DetailedQuestStep(shatteredClass,
                        "Obtain 25 Million Mining XP",
                        new SkillRequirement(Skill.MINING, 99, false)),
                125
        );

        addLeagueTask(
                new DetailedQuestStep(shatteredClass,
                        new WorldPoint(3818, 3810, 0),
                        "Mine a Runite Ore Fragment",
                        new QuestRequirement(QuestHelperQuest.BONE_VOYAGE, QuestState.FINISHED),
                        new SkillRequirement(Skill.MINING, 85, false)),
                125
        );

        addLeagueTask(
                new DetailedQuestStep(shatteredClass,
                        new WorldPoint(3057, 3885, 0),
                        "Mine Some Runite Ore in the Wilderness",
                        new SkillRequirement(Skill.MINING, 85, false)),
                125
        );

        addLeagueTask(
                new DetailedQuestStep(shatteredClass,
                        "Bury Some Bones"),
                5
        );

        addLeagueTask(
                new DetailedQuestStep(shatteredClass,
                        "Restore 5 Prayer Points at an Altar",
                        new SkillRequirement(Skill.PRAYER, 5, false)),
                5
        );

        addLeagueTask(
                new DetailedQuestStep(shatteredClass,
                        "Superhuman Strength and Improved Reflexes",
                        new SkillRequirement(Skill.PRAYER, 16, false)),
                5
        );

        addLeagueTask(
                new DetailedQuestStep(shatteredClass,
                        new WorldPoint(2949, 3821, 0),
                        "Sacrifice Some Bones at the Chaos Temple"),
                5
        );

        addLeagueTask(
                new DetailedQuestStep(shatteredClass,
                        new WorldPoint(3052, 3493, 0),
                        "Reach a Prayer Bonus of 15",
                        new SkillRequirement(Skill.PRAYER, 31, false)),
                25
        );

        addLeagueTask(
                new DetailedQuestStep(shatteredClass,
                        new WorldPoint(2981, 3613, 0),
                        "Bury Some Wyvern or Dragon Bones"),
                25
        );

        addLeagueTask(
                new DetailedQuestStep(shatteredClass,
                        "Use the Protect from Melee Prayer",
                        new SkillRequirement(Skill.PRAYER, 43, false)),
                25
        );

        addLeagueTask(
                new DetailedQuestStep(shatteredClass,
                        new WorldPoint(3763, 3872, 0),
                        "Use Enriched Bones on the Strange Machine",
                        new QuestRequirement(QuestHelperQuest.BONE_VOYAGE, QuestState.FINISHED),
                        new ItemRequirement("Enriched Bones", ItemID.SMALL_ENRICHED_BONE).quantity(1)),
                25
        );

        addLeagueTask(
                new DetailedQuestStep(shatteredClass,
                        new WorldPoint(2949, 3821, 0),
                        "Sacrifice Some Dragon Bones at the Chaos Temple"),
                25
        );

        addLeagueTask(
                new DetailedQuestStep(shatteredClass,
                        new WorldPoint(3202, 3858, 0),
                        "Bury Some Lava Dragon Bones"),
                25
        );

        addLeagueTask(
                new DetailedQuestStep(shatteredClass,
                        "Restore 75 Prayer Points at an Altar",
                        new SkillRequirement(Skill.PRAYER, 75, false)),
                50
        );

        addLeagueTask(
                new DetailedQuestStep(shatteredClass,
                        new WorldPoint(3003, 3376, 0),
                        "Reach a Prayer Bonus of 30",
                        new QuestRequirement(QuestHelperQuest.WANTED, QuestState.FINISHED),
                        new SkillRequirement(Skill.PRAYER, 2, false)),
                50
        );

        addLeagueTask(
                new DetailedQuestStep(shatteredClass,
                        "Reach Level 99 Prayer",
                        new SkillRequirement(Skill.PRAYER, 99, false)),
                125
        );

        addLeagueTask(
                new DetailedQuestStep(shatteredClass,
                        "Obtain 25 Million Prayer XP",
                        new SkillRequirement(Skill.PRAYER, 99, false)),
                125
        );

        addLeagueTask(
                new DetailedQuestStep(shatteredClass,
                        new WorldPoint(3232, 3424, 0),
                        "Equip a Studded Body and Chaps",
                        new SkillRequirement(Skill.DEFENCE, 20, false),
                        new SkillRequirement(Skill.RANGED, 20, false)),
                5
        );

        addLeagueTask(
                new DetailedQuestStep(shatteredClass,
                        new WorldPoint(3232, 3424, 0),
                        "Equip a Maple Shortbow",
                        new SkillRequirement(Skill.RANGED, 30, false)),
                5
        );

        addLeagueTask(
                new DetailedQuestStep(shatteredClass,
                        "Equip a Full Green Dragonhide Set",
                        new ItemRequirement("Green d'hide body", ItemID.GREEN_DHIDE_BODY).quantity(1),
                        new ItemRequirement("Green d'hide chaps", ItemID.GREEN_DHIDE_CHAPS).quantity(1),
                        new ItemRequirement("Green d'hide vambs", ItemID.GREEN_DHIDE_VAMBRACES).quantity(1),
                        new QuestRequirement(QuestHelperQuest.DRAGON_SLAYER_I, QuestState.FINISHED),
                        new SkillRequirement(Skill.DEFENCE, 40, false),
                        new SkillRequirement(Skill.RANGED, 40, false)),
                25
        );

        addLeagueTask(
                new DetailedQuestStep(shatteredClass,
                        "Equip a Full Blue Dragonhide Set",
                        new ItemRequirement("Blue d'hide body", ItemID.BLUE_DHIDE_BODY).quantity(1),
                        new ItemRequirement("Blue d'hide chaps", ItemID.BLUE_DHIDE_CHAPS).quantity(1),
                        new ItemRequirement("Blue d'hide vambs", ItemID.BLUE_DHIDE_VAMBRACES).quantity(1),
                        new SkillRequirement(Skill.DEFENCE, 40, false),
                        new SkillRequirement(Skill.RANGED, 50, false)),
                25
        );

        addLeagueTask(
                new DetailedQuestStep(shatteredClass,
                        "Equip a Full Red Dragonhide Set",
                        new ItemRequirement("Red d'hide body", ItemID.RED_DHIDE_BODY).quantity(1),
                        new ItemRequirement("Red d'hide chaps", ItemID.RED_DHIDE_CHAPS).quantity(1),
                        new ItemRequirement("Red d'hide vambs", ItemID.RED_DHIDE_VAMBRACES).quantity(1),
                        new SkillRequirement(Skill.DEFENCE, 40, false),
                        new SkillRequirement(Skill.RANGED, 60, false)),
                25
        );

        addLeagueTask(
                new DetailedQuestStep(shatteredClass,
                        "Equip a Yew Shortbow",
                        new ItemRequirement("Yew shortbow", ItemID.YEW_SHORTBOW).quantity(1),
                        new SkillRequirement(Skill.FLETCHING, 65, true),
                        new SkillRequirement(Skill.RANGED, 40, false)),
                25
        );

        addLeagueTask(
                new DetailedQuestStep(shatteredClass,
                        "Equip Some Ranger Boots",
                        new CombatLevelRequirement(126)),
                50
        );

        addLeagueTask(
                new DetailedQuestStep(shatteredClass,
                        "Equip a Full Black Dragonhide Set",
                        new ItemRequirement("Black d'hide body", ItemID.BLACK_DHIDE_BODY).quantity(1),
                        new ItemRequirement("Black d'hide chaps", ItemID.BLACK_DHIDE_CHAPS).quantity(1),
                        new ItemRequirement("Black d'hide vambs", ItemID.BLACK_DHIDE_VAMBRACES).quantity(1),
                        new SkillRequirement(Skill.DEFENCE, 40, false),
                        new SkillRequirement(Skill.RANGED, 70, false),
                        new SkillRequirement(Skill.CRAFTING, 84, false)),
                50
        );

        addLeagueTask(
                new DetailedQuestStep(shatteredClass,
                        "Equip a Magic Shortbow",
                        new ItemRequirement("Magic shortbow", ItemID.MAGIC_SHORTBOW).quantity(1),
                        new SkillRequirement(Skill.FLETCHING, 80, true),
                        new SkillRequirement(Skill.RANGED, 50, false)),
                50
        );

        addLeagueTask(
                new DetailedQuestStep(shatteredClass,
                        "Equip a Rune Crossbow",
                        new SkillRequirement(Skill.FLETCHING, 69, false),
                        new SkillRequirement(Skill.RANGED, 61, false)),
                50
        );

        addLeagueTask(
                new DetailedQuestStep(shatteredClass,
                        new WorldPoint(2307, 3214, 0),
                        "Equip a Dark Bow",
                        new SkillRequirement(Skill.RANGED, 60, false),
                        new SkillRequirement(Skill.SLAYER, 90, false),
                        new QuestRequirement(QuestHelperQuest.MOURNINGS_END_PART_I, QuestState.FINISHED)),
                50
        );

        addLeagueTask(
                new DetailedQuestStep(shatteredClass,
                        new WorldPoint(2640, 3699, 0),
                        "Equip an Ava's Assembler",
                        new CombatLevelRequirement(100),
                        new QuestRequirement(QuestHelperQuest.DRAGON_SLAYER_II, QuestState.FINISHED),
                        new SkillRequirement(Skill.RANGED, 70, false)),
                50
        );

        addLeagueTask(
                new DetailedQuestStep(shatteredClass,
                        "Reach Level 99 Ranged",
                        new SkillRequirement(Skill.RANGED, 99, false)),
                125
        );

        addLeagueTask(
                new DetailedQuestStep(shatteredClass,
                        "Obtain 25 Million Ranged XP",
                        new SkillRequirement(Skill.RANGED, 99, false)),
                125
        );

        addLeagueTask(
                new DetailedQuestStep(shatteredClass,
                        new WorldPoint(3075, 3654, 0),
                        "Equip a Craw's Bow",
                        new CombatLevelRequirement(90)),
                125
        );

        addLeagueTask(
                new DetailedQuestStep(shatteredClass,
                        new WorldPoint(3252, 3401, 0),
                        "Visit the Rune Essence Mine",
                        new QuestRequirement(QuestHelperQuest.RUNE_MYSTERIES, QuestState.FINISHED)),
                5
        );

        addLeagueTask(
                new DetailedQuestStep(shatteredClass,
                        new WorldPoint(2984, 3293, 0),
                        "Craft an Air Rune"),
                5
        );

        addLeagueTask(
                new DetailedQuestStep(shatteredClass,
                        new WorldPoint(2984, 3293, 0),
                        "Craft Any Rune",
                        new QuestRequirement(QuestHelperQuest.RUNE_MYSTERIES, QuestState.FINISHED)),
                5
        );

        addLeagueTask(
                new DetailedQuestStep(shatteredClass,
                        new WorldPoint(2984, 3293, 0),
                        "Locate a Runecrafting Altar With a Talisman",
                        new QuestRequirement(QuestHelperQuest.RUNE_MYSTERIES, QuestState.FINISHED)),
                5
        );

        addLeagueTask(
                new DetailedQuestStep(shatteredClass,
                        new WorldPoint(3186, 3165, 0),
                        "Craft 50 Water Runes",
                        new SkillRequirement(Skill.RUNECRAFT, 5, false)),
                5
        );

        addLeagueTask(
                new DetailedQuestStep(shatteredClass,
                        new WorldPoint(3313, 3254, 0),
                        "Craft a Fire Rune",
                        new SkillRequirement(Skill.RUNECRAFT, 14, false),
                        new QuestRequirement(QuestHelperQuest.RUNE_MYSTERIES, QuestState.FINISHED)),
                5
        );

        addLeagueTask(
                new DetailedQuestStep(shatteredClass,
                        new WorldPoint(3104, 3560, 0),
                        "Use the Abyss",
                        new QuestRequirement(QuestHelperQuest.ENTER_THE_ABYSS, QuestState.FINISHED)),
                5
        );

        addLeagueTask(
                new DetailedQuestStep(shatteredClass,
                        new WorldPoint(2986, 3293, 0),
                        "Craft 200 Essence Into Runes",
                        new SkillRequirement(Skill.RUNECRAFT, 2, false)),
                25
        );

        addLeagueTask(
                new DetailedQuestStep(shatteredClass,
                        new WorldPoint(2986, 3293, 0),
                        "Craft 4 Runes With 1 Essence",
                        new SkillRequirement(Skill.RUNECRAFT, 33, false)),
                25
        );

        addLeagueTask(
                new DetailedQuestStep(shatteredClass,
                        new WorldPoint(2986, 3293, 0),
                        "Craft Any Combination Rune",
                        new SkillRequirement(Skill.RUNECRAFT, 6, false)),
                25
        );

        addLeagueTask(
                new DetailedQuestStep(shatteredClass,
                        new WorldPoint(2409, 4378, 0),
                        "Craft 50 Cosmic Runes",
                        new SkillRequirement(Skill.RUNECRAFT, 27, false)),
                25
        );

        addLeagueTask(
                new DetailedQuestStep(shatteredClass,
                        new WorldPoint(2309, 3215, 0),
                        "Craft 50 Death Runes",
                        new SkillRequirement(Skill.RUNECRAFT, 65, false),
                        new QuestRequirement(QuestHelperQuest.MOURNINGS_END_PART_II, QuestState.FINISHED)),
                25
        );

        addLeagueTask(
                new DetailedQuestStep(shatteredClass,
                        new WorldPoint(2866, 3019, 0),
                        "Craft 50 Nature Runes",
                        new SkillRequirement(Skill.RUNECRAFT, 44, false)),
                25
        );

        addLeagueTask(
                new DetailedQuestStep(shatteredClass,
                        new WorldPoint(3055, 3446, 0),
                        "Craft a Body Rune",
                        new SkillRequirement(Skill.RUNECRAFT, 20, false)),
                25
        );

        addLeagueTask(
                new DetailedQuestStep(shatteredClass,
                        new WorldPoint(3312, 3252, 0),
                        "Craft a Lava Rune at the Fire Altar",
                        new SkillRequirement(Skill.RUNECRAFT, 23, false)),
                25
        );

        addLeagueTask(
                new DetailedQuestStep(shatteredClass,
                        new WorldPoint(3105, 3560, 0),
                        "Fill a Large Pouch",
                        new QuestRequirement(QuestHelperQuest.ENTER_THE_ABYSS, QuestState.FINISHED),
                        new SkillRequirement(Skill.RUNECRAFT, 50, false)),
                25
        );

        addLeagueTask(
                new DetailedQuestStep(shatteredClass,
                        new WorldPoint(2984, 3293, 0),
                        "Craft 2500 Essence Into Runes",
                        new SkillRequirement(Skill.RUNECRAFT, 20, false)),
                50
        );

        addLeagueTask(
                new DetailedQuestStep(shatteredClass,
                        new WorldPoint(2158, 3865, 0),
                        "Craft 50 Astral Runes",
                        new SkillRequirement(Skill.RUNECRAFT, 40, false),
                        new QuestRequirement(QuestHelperQuest.LUNAR_DIPLOMACY, QuestState.FINISHED)),
                50
        );

        addLeagueTask(
                new DetailedQuestStep(shatteredClass,
                        new WorldPoint(2858, 3381, 0),
                        "Craft 50 Law Runes",
                        new SkillRequirement(Skill.RUNECRAFT, 65, false)),
                50
        );

        addLeagueTask(
                new DetailedQuestStep(shatteredClass,
                        new WorldPoint(3634, 3341, 0),
                        "Craft a Rune Using Daeyalt Essence",
                        new QuestRequirement(QuestHelperQuest.SINS_OF_THE_FATHER, QuestState.FINISHED)),
                50
        );

        addLeagueTask(
                new DetailedQuestStep(shatteredClass,
                        new WorldPoint(3105, 3560, 0),
                        "Fill a Giant Pouch",
                        new QuestRequirement(QuestHelperQuest.ENTER_THE_ABYSS, QuestState.FINISHED),
                        new SkillRequirement(Skill.RUNECRAFT, 75, false)),
                50
        );

        addLeagueTask(
                new DetailedQuestStep(shatteredClass,
                        "Reach Level 99 Runecraft",
                        new SkillRequirement(Skill.RUNECRAFT, 99, false)),
                125
        );

        addLeagueTask(
                new DetailedQuestStep(shatteredClass,
                        "Obtain 25 Million Runecraft XP",
                        new SkillRequirement(Skill.RUNECRAFT, 99, false)),
                125
        );

        addLeagueTask(
                new DetailedQuestStep(shatteredClass,
                        new WorldPoint(2927, 3536, 0),
                        "Receive a Slayer Task"),
                5
        );

        addLeagueTask(
                new DetailedQuestStep(shatteredClass,
                        "Earn Some Slayer Points",
                        new SkillRequirement(Skill.SLAYER, 2, false)),
                5
        );

        addLeagueTask(
                new DetailedQuestStep(shatteredClass,
                        new WorldPoint(2927, 3536, 0),
                        "Check Your Slayer Task"),
                5
        );

        addLeagueTask(
                new DetailedQuestStep(shatteredClass,
                        new WorldPoint(3110, 3513, 0),
                        "Equip a Spiny Helmet",
                        new SkillRequirement(Skill.DEFENCE, 5, false)),
                5
        );

        addLeagueTask(
                new DetailedQuestStep(shatteredClass,
                        new WorldPoint(3093, 3471, 0),
                        "Receive a Slayer Task From Vannaka"),
                5
        );

        addLeagueTask(
                new DetailedQuestStep(shatteredClass,
                        new WorldPoint(2792, 3615, 0),
                        "Defeat a Cockatrice in the Fremennik Province",
                        new SkillRequirement(Skill.SLAYER, 25, false)),
                5
        );

        addLeagueTask(
                new DetailedQuestStep(shatteredClass,
                        new WorldPoint(2792, 3615, 0),
                        "Defeat a Pyrefiend in the Fremennik Province",
                        new SkillRequirement(Skill.SLAYER, 30, false)),
                5
        );

        addLeagueTask(
                new DetailedQuestStep(shatteredClass,
                        new WorldPoint(2929, 3535, 0),
                        "Receive a Slayer Task From Turael or Spria"),
                5
        );

        addLeagueTask(
                new DetailedQuestStep(shatteredClass,
                        new WorldPoint(3510, 3509, 0),
                        "Receive a Slayer Task From Mazchna",
                        new QuestRequirement(QuestHelperQuest.PRIEST_IN_PERIL, QuestState.FINISHED)),
                5
        );

        addLeagueTask(
                new DetailedQuestStep(shatteredClass,
                        new WorldPoint(2431, 3426, 0),
                        "Unlock Bigger and Badder",
                        new SkillRequirement(Skill.SLAYER, 2, false)),
                25
        );

        addLeagueTask(
                new DetailedQuestStep(shatteredClass,
                        "Slay 250 Creatures",
                        new SkillRequirement(Skill.SLAYER, 10, false)),
                25
        );

        addLeagueTask(
                new DetailedQuestStep(shatteredClass,
                        "Defeat a Superior Slayer Creature",
                        new SkillRequirement(Skill.SLAYER, 30, false)),
                25
        );

        addLeagueTask(
                new DetailedQuestStep(shatteredClass,
                        new WorldPoint(3746, 3782, 0),
                        "Defeat a Fossil Island Wyvern",
                        new QuestRequirement(QuestHelperQuest.BONE_VOYAGE, QuestState.FINISHED),
                        new SkillRequirement(Skill.SLAYER, 66, true)),
                25
        );

        addLeagueTask(
                new DetailedQuestStep(shatteredClass,
                        new WorldPoint(3169, 3174, 0),
                        "Defeat a Wall Beast",
                        new SkillRequirement(Skill.SLAYER, 35, false)),
                25
        );

        addLeagueTask(
                new DetailedQuestStep(shatteredClass,
                        "Complete Demon Slayer",
                        new QuestRequirement(QuestHelperQuest.DEMON_SLAYER, QuestState.FINISHED)),
                25
        );

        addLeagueTask(
                new DetailedQuestStep(shatteredClass,
                        new WorldPoint(2792, 3615, 0),
                        "Defeat a Kurask in the Fremennik Province",
                        new SkillRequirement(Skill.SLAYER, 70, false)),
                25
        );

        addLeagueTask(
                new DetailedQuestStep(shatteredClass,
                        new WorldPoint(2792, 3615, 0),
                        "Defeat a Turoth in the Fremennik Province",
                        new SkillRequirement(Skill.SLAYER, 55, false)),
                25
        );

        addLeagueTask(
                new DetailedQuestStep(shatteredClass,
                        new WorldPoint(2792, 3615, 0),
                        "Defeat a Jelly in the Fremennik Province",
                        new SkillRequirement(Skill.SLAYER, 52, false)),
                25
        );

        addLeagueTask(
                new DetailedQuestStep(shatteredClass,
                        "Defeat a Bloodveld in Kandarin",
                        new SkillRequirement(Skill.SLAYER, 50, false)),
                25
        );

        addLeagueTask(
                new DetailedQuestStep(shatteredClass,
                        new WorldPoint(2511, 3464, 0),
                        "Defeat a Fire Giant in Kandarin",
                        new CombatLevelRequirement(40)),
                25
        );

        addLeagueTask(
                new DetailedQuestStep(shatteredClass,
                        new WorldPoint(3010, 3157, 0),
                        "Defeat a Skeletal Wyvern",
                        new SkillRequirement(Skill.SLAYER, 72, false)),
                25
        );

        addLeagueTask(
                new DetailedQuestStep(shatteredClass,
                        "Assemble a Slayer Helm",
                        new SkillRequirement(Skill.CRAFTING, 55, false),
                        new QuestRequirement(QuestHelperQuest.RUM_DEAL, QuestState.FINISHED)),
                25
        );

        addLeagueTask(
                new DetailedQuestStep(shatteredClass,
                        "Defeat a Slayer Boss",
                        new SkillRequirement(Skill.SLAYER, 75, false)),
                50
        );

        addLeagueTask(
                new DetailedQuestStep(shatteredClass,
                        "Complete 50 Slayer Tasks",
                        new SkillRequirement(Skill.SLAYER, 75, false)),
                50
        );

        addLeagueTask(
                new DetailedQuestStep(shatteredClass,
                        "Complete 100 Slayer Tasks",
                        new SkillRequirement(Skill.SLAYER, 75, false)),
                50
        );

        addLeagueTask(
                new DetailedQuestStep(shatteredClass,
                        "Defeat 10 Superior Slayer Creatures",
                        new SkillRequirement(Skill.SLAYER, 75, false)),
                50
        );

        addLeagueTask(
                new DetailedQuestStep(shatteredClass,
                        "Defeat 20 Superior Slayer Creatures",
                        new SkillRequirement(Skill.SLAYER, 75, false)),
                50
        );

        addLeagueTask(
                new DetailedQuestStep(shatteredClass,
                        new WorldPoint(3746, 3782, 0),
                        "Defeat an Ancient Wyvern",
                        new QuestRequirement(QuestHelperQuest.BONE_VOYAGE, QuestState.FINISHED),
                        new SkillRequirement(Skill.SLAYER, 82, true)),
                50
        );

        addLeagueTask(
                new DetailedQuestStep(shatteredClass,
                        new WorldPoint(3228, 6046, 0),
                        "Defeat a Bloodveld in Tirannwn",
                        new SkillRequirement(Skill.SLAYER, 50, false),
                        new QuestRequirement(QuestHelperQuest.SONG_OF_THE_ELVES, QuestState.FINISHED)),
                50
        );

        addLeagueTask(
                new DetailedQuestStep(shatteredClass,
                        new WorldPoint(2333, 3171, 0),
                        "Defeat a Kurask in Tirannwn",
                        new SkillRequirement(Skill.SLAYER, 70, false),
                        new QuestRequirement(QuestHelperQuest.SONG_OF_THE_ELVES, QuestState.FINISHED)),
                50
        );

        addLeagueTask(
                new DetailedQuestStep(shatteredClass,
                        new WorldPoint(2307, 3214, 0),
                        "Defeat a Dark Beast in Tirannwn",
                        new SkillRequirement(Skill.SLAYER, 90, false),
                        new QuestRequirement(QuestHelperQuest.MOURNINGS_END_PART_I, QuestState.FINISHED)),
                50
        );

        addLeagueTask(
                new DetailedQuestStep(shatteredClass,
                        new WorldPoint(3228, 6046, 0),
                        "Defeat a Nechryael in Tirannwn",
                        new QuestRequirement(QuestHelperQuest.REGICIDE, QuestState.FINISHED)),
                50
        );

        addLeagueTask(
                new DetailedQuestStep(shatteredClass,
                        new WorldPoint(2641, 3700, 0),
                        "Defeat a Basilisk Knight",
                        new SkillRequirement(Skill.SLAYER, 60, false),
                        new QuestRequirement(QuestHelperQuest.THE_FREMENNIK_EXILES, QuestState.FINISHED)),
                50
        );

        addLeagueTask(
                new DetailedQuestStep(shatteredClass,
                        new WorldPoint(2869, 2969, 0),
                        "Receive a Slayer Task From Duradel",
                        new QuestRequirement(QuestHelperQuest.SHILO_VILLAGE, QuestState.FINISHED)),
                50
        );

        addLeagueTask(
                new DetailedQuestStep(shatteredClass,
                        new WorldPoint(2282, 3612, 0),
                        "Defeat a Cave Kraken",
                        new SkillRequirement(Skill.SLAYER, 87, false),
                        new SkillRequirement(Skill.MAGIC, 50, false)),
                50
        );

        addLeagueTask(
                new DetailedQuestStep(shatteredClass,
                        new WorldPoint(3313, 3204, 0),
                        "Defeat a Dust Devil in the Kharidian Desert",
                        new SkillRequirement(Skill.SLAYER, 65, false)),
                50
        );

    }

}
