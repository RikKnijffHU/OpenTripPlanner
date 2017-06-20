/* This program is free software: you can redistribute it and/or
 modify it under the terms of the GNU Lesser General Public License
 as published by the Free Software Foundation, either version 3 of
 the License, or (at your option) any later version.

 This program is distributed in the hope that it will be useful,
 but WITHOUT ANY WARRANTY; without even the implied warranty of
 MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 GNU General Public License for more details.

 You should have received a copy of the GNU General Public License
 along with this program.  If not, see <http://www.gnu.org/licenses/>. */

package org.opentripplanner.api.resource;

import org.opentripplanner.api.model.AbsoluteDirection;
import org.opentripplanner.api.model.RelativeDirection;
import org.opentripplanner.api.model.WalkStep;

import junit.framework.TestCase;

public class TestWalkStep extends TestCase {
    WalkStep step = new WalkStep();
    double angle1 = 0.0;
    double angle2 = 0.0;

    public void testRelativeDirectionRight() {
        setAngles(90);
        step.setDirections(angle1, angle2, false);
        testRelativeDirection(RelativeDirection.RIGHT);
    }

    public void testRelativeDirectionContinue() {
        setAngles(5);
        step.setDirections(angle1, angle2, false);
        testRelativeDirection(RelativeDirection.CONTINUE);
    }

    public void testRelativeDirectionHardLeft() {
        setAngles(240);
        step.setDirections(angle1, angle2, false);
        testRelativeDirection(RelativeDirection.HARD_LEFT);
    }

    public void testAbsoluteDirectionEast() {
        setAngles(90);
        step.setDirections(angle1, angle2, false);
        testAbsoluteDirection(AbsoluteDirection.EAST);
    }

    public void testAbsoluteDirectionNorth() {
        setAngles(5);
        step.setDirections(angle1, angle2, false);
        testAbsoluteDirection(AbsoluteDirection.NORTH);
    }

    public void testAbsoluteDirectionSouthWest() {
        setAngles(240);
        step.setDirections(angle1, angle2, false);
        testAbsoluteDirection(AbsoluteDirection.SOUTHWEST);
    }

    public void setAngles(int deg2) {
        angle1 = degreesToRadians(0);
        angle2 = degreesToRadians(deg2);
    }

    public void testAbsoluteDirection(AbsoluteDirection direction) {
        assertEquals(direction, step.absoluteDirection);
    }

    private void testRelativeDirection(RelativeDirection direction) {
        assertEquals(direction, step.relativeDirection);
    }

    private double degreesToRadians(double deg) {
        return deg * Math.PI / 180;
    }
}
