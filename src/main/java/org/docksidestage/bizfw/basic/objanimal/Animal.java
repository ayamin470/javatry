package org.docksidestage.bizfw.basic.objanimal;

import org.docksidestage.bizfw.basic.objanimal.barking.BarkedSound;
import org.docksidestage.bizfw.basic.objanimal.loud.Loudable;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * The object for animal(動物).
 * @author jflute
 * @author ayamin
 */
public abstract class Animal implements Loudable {

    private static final Logger logger = LoggerFactory.getLogger(Animal.class);
    protected final BarkedSound.BarkingProcess barkingProcess = new BarkedSound.BarkingProcess(); // <-- これを追加
    // ===================================================================================
    //                                                                           Attribute
    //                                                                           =========
    protected int hitPoint; // HP

    // ===================================================================================
    //                                                                         Constructor
    //                                                                         ===========
    public Animal() {
        hitPoint = getInitialHitPoint();
    }

    protected int getInitialHitPoint() {
        return 10;
    }

    // ===================================================================================
    //                                                                               Bark
    //                                                                              ======

    public BarkedSound bark() {

        return barkingProcess.bark(getBarkWord(), this::downHitPoint);
    }

    protected abstract String getBarkWord(); // このメソッドはAnimalに残る (各動物固有の鳴き声のため)

    // ===================================================================================
    //                                                                           Hit Point
    //                                                                           =========
    protected void downHitPoint() {
        --hitPoint;
        if (hitPoint <= 0) {
            throw new IllegalStateException("I'm very tired, so I want to sleep" + getBarkWord());
        }
    }

    // ===================================================================================
    //                                                                               Loud
    //                                                                              ======
    @Override
    public String soundLoudly() {
        return bark().getBarkWord();
    }

    // ===================================================================================
    //                                                                            Accessor
    //                                                                            ========
    public int getHitPoint() {
        return hitPoint;
    }
}
