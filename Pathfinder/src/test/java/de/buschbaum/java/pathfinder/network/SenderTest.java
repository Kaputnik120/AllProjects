/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package de.buschbaum.java.pathfinder.network;

import de.buschbaum.java.pathfinder.api.Status;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import org.junit.Test;

/**
 *
 * @author uli
 */
public class SenderTest {

    public SenderTest() {
    }

    @Test
    public void testSender() throws IOException {
        Sender sender = new Sender();

        Status status = new Status();
        status.setPos(new int[]{8, 8});
        status.setMapDimensions(new int[]{20, 20});
        status.setAngle(50);
        status.setRobotSize(new double[]{1.3, 3.2});

        List<int[]> barriers = new ArrayList<>(20);
        barriers.add(new int[]{17, 3});
        barriers.add(new int[]{5, 5});
        barriers.add(new int[]{6, 6});
        barriers.add(new int[]{6, 5});
        barriers.add(new int[]{5, 6});
        barriers.add(new int[]{1, 1});
        barriers.add(new int[]{1, 2});
        barriers.add(new int[]{3, 2});
        barriers.add(new int[]{2, 2});
        barriers.add(new int[]{3, 3});
        barriers.add(new int[]{4, 4});
        barriers.add(new int[]{5, 4});
        barriers.add(new int[]{4, 3});
        barriers.add(new int[]{17, 5});
        barriers.add(new int[]{17, 4});
        barriers.add(new int[]{13, 12});
        barriers.add(new int[]{14, 13});
        barriers.add(new int[]{15, 14});
        barriers.add(new int[]{15, 13});
        status.setBarriers(barriers);

        status.setAccX(new Double[]{12.0, 11.0, 8.0, 5.4, 3.2, 2.0, 1.0, 0.75, 0.6, 0.003, 0.0,
            -1.0, -3.0, -5.0, -7.0, -7.4, -8.0, -12.0, -13.0});
        status.setAccY(new Double[]{12.0, 11.0, 8.0, 5.4, 3.2, 2.0, 1.0, 0.75, 0.6, 0.003, 0.0,
            -1.0, -3.0, -5.0, -7.0, -7.4, -8.0, -12.0, -13.0});
        status.setAccZ(new Double[]{12.0, 11.0, 8.0, 5.4, 3.2, 2.0, 1.0, 0.75, 0.6, 0.003, 0.0,
            -1.0, -3.0, -5.0, -7.0, -7.4, -8.0, -12.0, -13.0});

        status.setPointerX(13);
        status.setPointerY(13);
        status.setPointerZ(13);

        sender.send(status);
    }

}
