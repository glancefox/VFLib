/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package chemlib.ebi.molecule.mcs.algorithm.vflib.builder;

import chemlib.ebi.molecule.mcs.algorithm.vflib.interfaces.IBondMatcher;
import chemlib.ebi.molecule.mcs.algorithm.vflib.interfaces.IEdge;
import chemlib.ebi.molecule.mcs.algorithm.vflib.interfaces.INode;

/**
 *
 * @author Syed Asad Rahman <asad @ ebi.ac.uk>
 */
public class EdgeBuilder implements IEdge {

    private NodeBuilder source;
    private NodeBuilder target;
    private IBondMatcher matcher;

    /**
     * 
     * @param source
     * @param target
     * @param matcher
     */
    public EdgeBuilder(NodeBuilder source, NodeBuilder target, IBondMatcher matcher) {
        this.source = source;
        this.target = target;
        this.matcher = matcher;
    }

    
    /**
     * 
     * @return
     */
    @Override
    public INode getSource() {
        return source;
    }

    
    /**
     *
     * @return
     */
    @Override
    public INode getTarget() {
        return target;
    }

    
    /**
     *
     * @return
     */
    @Override
    public IBondMatcher getBondMatcher() {
        return matcher;
    }
}
