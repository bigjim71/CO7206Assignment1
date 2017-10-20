package dependenceAnalysis.analysis;

import dependenceAnalysis.util.cfg.Graph;
import dependenceAnalysis.util.cfg.Node;
import org.objectweb.asm.tree.ClassNode;
import org.objectweb.asm.tree.MethodNode;

import java.util.Set;

/**
 * Created by neilwalkinshaw on 19/10/2017.
 */
public class ProgramDependenceGraph extends Analysis {

    public ProgramDependenceGraph(ClassNode cn, MethodNode mn) {
        super(cn, mn);
    }

    /**
     * Return a graph representing the Program Dependence Graph of the control
     * flow graph, which is stored in the controlFlowGraph class attribute
     * (this is inherited from the Analysis class).
     *
     * You may wish to use the class that computes the Control Dependence Tree to
     * obtain the control dependences, and may wish to use the code in the
     * dependenceAnalysis.analysis.DataFlowAnalysis class to obtain the data dependences.
     * 
     * @return
     */
    public Graph computeResult() {
        //TODO as part of assignment.
        return null;
    }

    /**
     * Compute the set of nodes that belong to a backward slice, computed from a given
     * node in the program dependence graph.
     *
     * @param node
     * @return
     */
    public Set<Node> backwardSlice(Node node){
        //TODO as part of assignment
        return null;
    }

    /**
     * Compute the Tightness slice-based metric. The proportion of nodes in a control flow graph that occur
     * in every possible slice of that control flow graph.
     * @return
     */
    public double computeTightness(){
        //TODO as part of assignment
        return 0D;
    }

    /**
     * Compute the Overlap slice-based metric: How many statements per output-slice are unique to that slice?
     * Output slices are computed by computing backward slices from the set of nodes with incoming data dependencies,
     * but with no outgoing data dependencies.
     * @return
     */
    public double computeOverlap(){
        //TODO as part of assignment
        return 0D;
    }
}
