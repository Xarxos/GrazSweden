/* Deprecated class which I'm including to give a brief insight into my development process as I tried different
* approached that did not end up working :) */
public class Glass {
    static int gs = 0;
    private int r = 0;
    private int g = 0;
    private double fill = 0.0;
    private Glass inGlass1;
    private Glass inGlass2;
    private double outFlow;
    private double fillTime;

    public Glass(Glass inGlass1, Glass inGlass2) {
        this.inGlass1 = inGlass1;
        this.inGlass2 = inGlass2;
        this.g = g;
        this.r = r;
    }

    public void step(double currentTime) {
        double oldFill = fill;
        if(inGlass1 != null && inGlass1.getFill() >= 1.0) {
            fill += inGlass1.getOutFlow();
        }
        if(inGlass2 != null && inGlass2.getFill() >= 1.0) {
            fill += inGlass2.getOutFlow();
        }
        if(fill >= 1.0) {
            outFlow = 0.0;
            if(inGlass1 != null) {
                outFlow += inGlass1.getOutFlow() / 2;
            }
            if(inGlass2 != null) {
                outFlow += inGlass2.getOutFlow() / 2;
            }
            if(oldFill < 1.0) {
                fillTime = currentTime;
                //System.out.println(gs++);
            }
        }
    }

    public void resetFill() {
        fill = 0.0;
    }

    public Glass getInGlass1() {
        return inGlass1;
    }

    public Glass getInGlass2() {
        return inGlass2;
    }

    public double getOutFlow() {
        return outFlow;
    }

    public void setOutFlow(double outFlow) {
        this.outFlow = outFlow;
    }

    public double getFillTime() {
        return fillTime;
    }

    public void addFill(double fillAmount, int depth) {
        //System.out.println(gs++);
        //fill = 0.0;
        double newFill = fill + fillAmount;
        if(newFill <= 1.0) {
            fill = newFill;
            System.out.println("Yeah");
        }
        else {
            fill = 1.0;
            if(inGlass1 != null) {
                inGlass1.addFill((newFill - fill) / 2, depth+1);
                inGlass2.addFill((newFill - fill) / 2, depth+1);
            }
        }
    }

    public double getFill() {
        return fill;
    }

    public void setFill(double fill) {
        this.fill = fill;
    }
}
