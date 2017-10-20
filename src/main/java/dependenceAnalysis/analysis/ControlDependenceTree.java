package dependenceAnalysis.analysis;

import dependenceAnalysis.util.cfg.Graph;
import org.objectweb.asm.tree.ClassNode;
import org.objectweb.asm.tree.MethodNode;

/**
 * Created by neilwalkinshaw on 19/10/2017.
 */
public class ControlDependenceTree extends Analysis {

    public ControlDependenceTree(ClassNode cn, MethodNode mn) {
        super(cn, mn);
    }

    /**
     * Return a graph representing the control dependence tree of the control
     * flow graph, which is stored in the controlFlowGraph class attribute
     * (this is inherited from the Analysis class).
     *
     * You may wish to use the post dominator tree code you implement to support
     * computing the Control Dependence Graph.
     *
     * @return
     */
    public Graph computeResult() {
        //TODO as part of assignment.
        return null;
    }
}
