/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package chemlib.ebi.molecule.mcs.algorithm.vflib.interfaces;

import chemlib.ebi.molecule.mcs.algorithm.vflib.map.VFMatch;
import java.util.Map;
import org.openscience.cdk.interfaces.IAtom;

/*
 * MX Cheminformatics Tools for Java
 *
 * Copyright (c) 2007-2009 Metamolecular, LLC
 *
 * http://metamolecular.com
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in
 * all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
 * THE SOFTWARE.
 */
/**
 * @author Richard L. Apodaca <rapodaca at metamolecular.com>
 * @author Syed Asad Rahman <asad @ ebi.ac.uk> (modified the orignal code)
 */
public interface IState {

    /**
     * Returns the current mapping of query atoms onto target atoms.
     * This map is shared among all states obtained through nextState.
     *
     * @return the current mapping of query atoms onto target atoms
     */
    public Map<INode, IAtom> getMap();

    /**
     * Returns true if another candidate match can be found or
     * false otherwise.
     *
     * @return true if another candidate mapping can be found or
     * false otherwise
     */
    public boolean hasNextCandidate();

    /**
     * Returns the next candidate match.
     *
     * @return the next candidate match
     */
    public VFMatch nextCandidate();

    /**
     * Returns true if the given match will work with the current
     * map, or false otherwise.
     *
     * @param match the match to consider
     * @return true if the given match will work with the current
     * map, or false otherwise
     */
    public boolean isMatchFeasible(VFMatch match);

    /**
     * Returns true if all atoms in the query molecule have been
     * mapped.
     *
     * @return true if all atoms in the query molecule have been
     * mapped
     */
    public boolean isGoal();

    /**
     * Returns true if no match will come from this IState.
     *
     * @return true if no match will come from this IState
     */
    public boolean isDead();

    /**
     * Returns a state in which the atoms in match have been
     * added to the current mapping.
     *
     * @param match the match to consider
     * @return  a state in which the atoms in match have been
     * added to the current mapping
     */
    public IState nextState(VFMatch match);

    /**
     * Returns this IState's atom map to its original condition.
     */
    public void backTrack();
}
