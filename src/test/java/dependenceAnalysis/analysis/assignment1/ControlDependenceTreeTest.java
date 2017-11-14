package dependenceAnalysis.analysis.assignment1;

import dependenceAnalysis.analysis.ControlDependenceTree;
import dependenceAnalysis.util.cfg.CFGExtractor;
import dependenceAnalysis.util.cfg.Graph;
import dependenceAnalysis.util.cfg.Node;
import org.junit.Test;
import org.objectweb.asm.ClassReader;
import org.objectweb.asm.Opcodes;
import org.objectweb.asm.tree.ClassNode;
import org.objectweb.asm.tree.MethodNode;

import java.io.IOException;
import java.io.InputStream;
import java.util.Collection;
import java.util.List;

import static junit.framework.TestCase.assertTrue;

/**
 * Created by neilwalkinshaw on 13/11/2017.
 */
public class ControlDependenceTreeTest {

    @Test
    public void testAreaEquals() throws IOException {
        //Pick suitable ClassNode and MethodNode as test subjects.
        ClassNode cn = new ClassNode(Opcodes.ASM4);
        InputStream in=CFGExtractor.class.getResourceAsStream("/java/awt/geom/Area.class");
        ClassReader classReader=new ClassReader(in);
        classReader.accept(cn, 0);

        MethodNode target = null;
        for(MethodNode mn : (List<MethodNode>)cn.methods){
            if(mn.name.equals("equals")) //let's pick out the "equals" method as our subject
                target = mn;
        }

        //Run the post dominator tree generation code.
        ControlDependenceTree cdt = new ControlDependenceTree(cn,target);
        Graph submission = cdt.computeResult();

        dependenceAnalysis.analysis.assignment1.solution.ControlDependenceTree cdtSol = new dependenceAnalysis.analysis.assignment1.solution.ControlDependenceTree(cn,target);
        cdtSol.setControlFlowGraph(cdt.getControlFlowGraph());
        Graph solution = cdtSol.computeResult();

        for(Node n : solution.getNodes()){
            Collection<Node> solSuccs = solution.getSuccessors(n);
            Collection<Node> subSuccs = submission.getSuccessors(n);
            assertTrue(solSuccs.containsAll(subSuccs));
            assertTrue(subSuccs.containsAll(solSuccs));
        }
    }

}
