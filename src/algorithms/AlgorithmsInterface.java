package algorithms;

public interface AlgorithmsInterface extends Runnable {

    /**
     * This function will set the animationDelay to the given delay.
     *
     * @param delay
     */
    void setAnimationDelay(int delay);

    /**
     * This function will return the animationDelay.
     *
     * @return int between 0 to 100.
     */
    int getAnimationDelay();
}
