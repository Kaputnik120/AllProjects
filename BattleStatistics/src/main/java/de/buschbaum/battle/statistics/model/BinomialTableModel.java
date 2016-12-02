/*
 * Copyright (c) 2013 Hays AG
 */
package de.buschbaum.battle.statistics.model;

import java.util.Objects;
import javafx.beans.property.SimpleStringProperty;

/**
 *
 * @author ucb
 */
public class BinomialTableModel {

    private final SimpleStringProperty lostWounds;
    private final SimpleStringProperty chance;

    public BinomialTableModel(String lostWounds, String chance) {
        this.lostWounds = new SimpleStringProperty(lostWounds);
        this.chance = new SimpleStringProperty(chance);
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 41 * hash + Objects.hashCode(this.lostWounds);
        hash = 41 * hash + Objects.hashCode(this.chance);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final BinomialTableModel other = (BinomialTableModel) obj;
        if (!Objects.equals(this.lostWounds, other.lostWounds)) {
            return false;
        }
        if (!Objects.equals(this.chance, other.chance)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "BinomialTableModel{" + "lostWounds=" + lostWounds + ", chance=" + chance + '}';
    }

    
    
    public String getLostWounds() {
        return lostWounds.get();
    }

    public String getChance() {
        return chance.get();
    }

}
