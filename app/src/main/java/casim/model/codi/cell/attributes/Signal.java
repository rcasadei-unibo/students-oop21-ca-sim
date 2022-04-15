package casim.model.codi.cell.attributes;

/**
 * An enum for the growth signals for the CoDi growth phase (see in GrowthUpdateRule).
 */
public enum Signal {
    /**
     * An empty signal.
     */
    EMPTY(0),
    /**
     * An axon signal.
     */
    AXON_SIGNAL(1),
    /**
     * A dendrite signal.
     */
    DENDRITE_SIGNAL(4);

    private final int value;

    Signal(final int value) {
        this.value = value;
    }

    /**
     * Get the value linked to the signal.
     * 
     * @return the int value linked to the current signal.
     */
    public int getValue() {
        return this.value;
    }
}
