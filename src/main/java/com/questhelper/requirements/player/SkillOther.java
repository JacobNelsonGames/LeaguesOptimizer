package com.questhelper.requirements.player;

public enum SkillOther {
    NONE("None"),
    ALL_SKILLS("All Skills"),
    ANY_SKILLS("Any Skills");

    private final String name;

    SkillOther(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
