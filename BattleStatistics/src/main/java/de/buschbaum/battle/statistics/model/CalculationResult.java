/*
 * Copyright (c) 2013 Hays AG
 */
package de.buschbaum.battle.statistics.model;

import java.util.List;
import java.util.Objects;

/**
 *
 * @author ucb
 */
public class CalculationResult {

    private List<Double> binomialResults;

    private List<String> messages;

    @Override
    public String toString() {
        return "CalculationResult{" + "binomialResults=" + binomialResults + ", messages=" + messages + '}';
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 11 * hash + Objects.hashCode(this.binomialResults);
        hash = 11 * hash + Objects.hashCode(this.messages);
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
        final CalculationResult other = (CalculationResult) obj;
        return true;
    }

    /**
     * @return the binomialResults
     */
    public List<Double> getBinomialResults() {
        return binomialResults;
    }

    /**
     * @param binomialResults the binomialResults to set
     */
    public void setBinomialResults(List<Double> binomialResults) {
        this.binomialResults = binomialResults;
    }

    /**
     * @return the messages
     */
    public List<String> getMessages() {
        return messages;
    }

    /**
     * @param messages the messages to set
     */
    public void setMessages(List<String> messages) {
        this.messages = messages;
    }

}
