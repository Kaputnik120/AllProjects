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
public class OtherTableModel {

    private final SimpleStringProperty points;
    private final SimpleStringProperty singleHitChance;

    public OtherTableModel(String points, String singleHitChance) {
        this.points = new SimpleStringProperty(points);
        this.singleHitChance = new SimpleStringProperty(singleHitChance);
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 53 * hash + Objects.hashCode(this.points);
        hash = 53 * hash + Objects.hashCode(this.singleHitChance);
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
        final OtherTableModel other = (OtherTableModel) obj;
        if (!Objects.equals(this.points, other.points)) {
            return false;
        }
        if (!Objects.equals(this.singleHitChance, other.singleHitChance)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "OtherTableModel{" + "points=" + points + ", singleHitChance=" + singleHitChance + '}';
    }

    public String getPoints() {
        return points.get();
    }

    public String getSingleHitChance() {
        return singleHitChance.get();
    }
}
