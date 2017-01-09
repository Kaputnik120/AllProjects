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

    private SimpleStringProperty msg;

    public OtherTableModel(String msg) {
        this.msg = new SimpleStringProperty(msg);
    }

    @Override
    public String toString() {
        return "OtherTableModel{" + "msg=" + getMsg() + '}';
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 41 * hash + Objects.hashCode(this.getMsg());
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
        if (!Objects.equals(this.msg, other.msg)) {
            return false;
        }
        return true;
    }

    /**
     * @return the msg
     */
    public SimpleStringProperty getMsg() {
        return msg;
    }

    /**
     * @param msg the msg to set
     */
    public void setMsg(SimpleStringProperty msg) {
        this.msg = msg;
    }

}
