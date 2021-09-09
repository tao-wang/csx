import org.opensourcephysics.frames.PlotFrame;
import polyfun.Polynomial;

/**
 * Class for approximating the area under a curve
 */
public abstract class Riemann {

    /**
     * This constructor takes as input the left and right endpoints of the interval
     * over which the Riemann sum is to be calculated, and the number of
     * subintervals used to calculate the Riemann sum. It sets dx equal to (right -
     * left)/subintervals.
     *
     * @param left
     * @param right
     * @param subintervals
     */
    public Riemann(double left, double right, int subintervals) {
        this.left = left;
        this.right = right;
        this.subintervals = subintervals;
        this.delta = (right - left) / subintervals;
    }

    /**
     * Gets the left hand endpoint.
     *
     * @return the left hand endpoint.
     */
    public double getLeft() {
        return left;
    }

    /**
     * Sets the left hand endpoint.
     *
     * @param left the left hand endpoint
     */
    public void setLeft(double left) {
        this.left = left;
    }

    /**
     * Gets the right hand endpoint.
     *
     * @return the right hand endpoint.
     */
    public double getRight() {
        return right;
    }

    /**
     * Sets the right hand endpoint.
     *
     * @param right the right hand endpoint
     */
    public void setRight(double right) {
        this.right = right;
    }

    /**
     * Gets the number of subintervals
     *
     * @return the number of subintervals into which the area is subdivided
     */
    public double getSubintervals() {
        return subintervals;
    }

    /**
     * Set the number of subintervals
     *
     * @param subintervals the number of subintervals into which the area is subdivided
     */
    public void setSubintervals(double subintervals) {
        this.subintervals = subintervals;
    }

    /**
     * Get the width of each slice
     *
     * @return the width of each slice; i.e. delta x
     */
    public double getDelta() {
        return delta;
    }

    /**
     * Recalculate the width of each slice based on the bounds and number of
     * subintervals
     */
    public void recalculateDelta() {
        this.delta = (right - left) / subintervals;
    }

    /**
     * This method calculates a Riemann sum. If RiemannSumRule extends Riemann and
     * RSR is an object of type RiemannSumRule, then RSR.rs should calculate a
     * Riemann sum using the particular Riemann sum rule implemented in
     * RiemannSumRule.
     *
     * @param poly         the polynomial whose Riemann sum is to be calculated
     * @param left         the left hand endpoint of the Riemann sum
     * @param right        the right hand endpoint of the Riemann sum
     * @param subintervals the number of subintervals in the Riemann sum
     * @return Returns the value of the Riemann sum, calculated according to a particular rule which is determined by the child class that extends this method
     */
    public double rs(Polynomial poly, double left, double right, int subintervals) {
        // If left is more than right, call this method with reversed bounds and negate
        // it; by one of the area
        // postulates this works.
        if (left > right) {
            return -rs(poly, right, left, subintervals);
        }

        // Set the instance variables to the parameters and calculate the delta x
        setLeft(left);
        setRight(right);
        setSubintervals(subintervals);
        setDelta();

        // Add up slices from left to right
        double sum = 0;
        for (double x = left; x <= right; x += delta) {
            // Calculate a slice and add it to the total
            sum += slice(poly, x, x + delta);
        }
        return sum;
    }

    /**
     * This method graphs the accumulation function corresponding to the input
     * polynomial and the input left hand endpoint. If RiemannSumRule extends
     * Riemann and RSR is an object of type RiemannSumRule, then RSR.rsAcc should
     * graph the accumulation function corresponding to the input polynomial and the
     * input left hand endpoint using the particular Riemann sum rule implemented in
     * RiemannSumRule.
     *
     * @param pframe    is the PlotFrame on which the polynomial and the Riemann sum are
     *                  drawn
     * @param poly      is the polynomial whose accumulation function is to be calculated
     * @param index     is the number associated to the collection of (x,y) coordinates
     *                  that make up the dataset which, when plotted, is the graph of the
     *                  accumulation function
     * @param precision is the difference between the x-coordinates of two adjacent points
     *                  on the graph of the accumulation function
     * @param base      is the left hand endpoint of the accumulation function
     */
    public void rsAcc(PlotFrame pframe, Polynomial poly, int index, double precision, double base) {
        pframe.setConnected(true);
        pframe.setMarkerSize(index, 0);

        for (double x = base - 3; x <= base + 3; x += precision) {
            pframe.append(index, x, rs(poly, base, x, 100));
        }
    }

    public void rsPlot(PlotFrame pframe, Polynomial poly, int index, double precision, double left, double right,
                       int subintervals) {
        // Swap left and right if left is more than right
        if (left > right) {
            double temp = left;
            left = right;
            right = temp;
        }
        setLeft(left);
        setRight(right);
        setSubintervals(subintervals);
        setDelta();

        for (double x = left; x <= right; x += delta) {
            slicePlot(pframe, poly, x, x + delta);
        }

        for (double i = left; i <= right; i += precision) {
            pframe.setConnected(true);
            pframe.setMarkerSize(index, 0);
            pframe.append(index, i, poly.evaluate(i).getTerms()[0].getTermDouble());
        }
    }

    /**
     * This method calculates the (signed) area between the graph of a polynomial
     * and the x-axis, over a given interval on the x-axis. If RiemannSumRule
     * extends Riemann and RSR is an object of type RiemannSumRule, then RSR.slice
     * should calculate this area using the particular Riemann sum rule implemented
     * in RiemannSumRule.
     *
     * @param poly   is the polynomial whose area (over or under the x-axis), over the
     *               interval from sleft to sright, is to be calculated
     * @param sleft  is the left hand endpoint of the interval
     * @param sright is the right hand endpoint of the interval
     * @return A slice of the riemann sum
     */
    public abstract double slice(Polynomial poly, double sleft, double sright);

    /**
     * This method draws the region whose (signed) area is calculated by slice. If
     * RiemannSumRule extends Riemann and RSR is an object of type RiemannSumRule,
     * then RSR.slicePlot should draw this region using the particular Riemann sum
     * rule implemented in RiemannSumRule.
     *
     * @param pframe is the PlotFrame on which the slicePlot is to be drawn
     * @param poly   is the polynomial whose area (over or under the x-axis), over the
     *               interval from sleft to sright, is to be drawn
     * @param sleft  is the left hand endpoint of the interval
     * @param sright is the right hand endpoint of the interval
     */
    public abstract void slicePlot(PlotFrame pframe, Polynomial poly, double sleft, double sright);

}
