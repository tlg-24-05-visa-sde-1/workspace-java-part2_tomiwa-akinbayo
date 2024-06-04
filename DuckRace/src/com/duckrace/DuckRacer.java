package com.duckrace;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

class DuckRacer {
    private final int id;
    private String name;
    private final Collection<Reward> rewards = new ArrayList<>();

    public DuckRacer(int id, String name) {
        this.id = id;
        setName(name);
    }

    // business methods
    public void win(Reward reward) {
        rewards.add(reward);
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getWins() {
        return rewards.size();
    }

    // NOTE: return a read-only view of the rewards collection, (don't want client to modify)
    public Collection<Reward> getRewards() {
        return Collections.unmodifiableCollection(rewards);
    }

    @Override
    public String toString() {
        return String.format("%s: name= %s, id= %s, wins= %s, rewards= %s",
                getClass().getSimpleName(), getName(), getId(), getWins(), getRewards());
    }
}
