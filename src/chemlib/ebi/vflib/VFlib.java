/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package chemlib.ebi.vflib;


import chemlib.ebi.vflib.helper.BondType;
import chemlib.ebi.vflib.interfaces.IMapper;
import chemlib.ebi.vflib.interfaces.INode;
import chemlib.ebi.vflib.interfaces.IQuery;
import chemlib.ebi.vflib.map.VFMapper;
import chemlib.ebi.vflib.query.TemplateCompiler;
import java.util.List;
import java.util.Map;
import org.openscience.cdk.Bond;
import org.openscience.cdk.DefaultChemObjectBuilder;
import org.openscience.cdk.exception.CDKException;
import org.openscience.cdk.interfaces.IAtom;
import org.openscience.cdk.interfaces.IBond;
import org.openscience.cdk.interfaces.IMolecule;
import org.openscience.cdk.tools.manipulator.AtomContainerManipulator;

/**
 *
 * @author sar
 */
public class VFlib {

    public static void main(String[] args) throws Exception {
        TestVFlib();
    }

    /**
     * 
     * @throws org.openscience.cdk.exception.CDKException
     */
    public static void TestVFlib() throws CDKException {
        BondType.getInstance().setBondSensitiveFlag(false);
        IMolecule benzene = createBenzene();
        IQuery benzeneQuery = TemplateCompiler.compile(benzene);
        IMapper mapper = new VFMapper(benzeneQuery);

        List<Map<INode, IAtom>> maps = mapper.getMaps(benzene);

        if (maps.size() > 0 && maps.size()==12) {
            System.out.println("Correct Mapping Found");
            System.out.println("Mapping count " + maps.size() + ", Mapping Size: " + maps.get(0).size());

        } else {
            System.out.println("No/Flase Match reported");
        }


//        assertEquals(12, maps.size());
    }

    public static IMolecule createHexane() throws CDKException {
        IMolecule result = DefaultChemObjectBuilder.getInstance().newMolecule();

        IAtom c1 = DefaultChemObjectBuilder.getInstance().newAtom("C");
        c1.setID("1");
        IAtom c2 = DefaultChemObjectBuilder.getInstance().newAtom("C");
        c2.setID("2");
        IAtom c3 = DefaultChemObjectBuilder.getInstance().newAtom("C");
        c3.setID("3");
        IAtom c4 = DefaultChemObjectBuilder.getInstance().newAtom("C");
        c4.setID("4");
        IAtom c5 = DefaultChemObjectBuilder.getInstance().newAtom("C");
        c5.setID("5");
        IAtom c6 = DefaultChemObjectBuilder.getInstance().newAtom("C");
        c6.setID("6");

        result.addAtom(c1);
        result.addAtom(c2);
        result.addAtom(c3);
        result.addAtom(c4);
        result.addAtom(c5);
        result.addAtom(c6);

        IBond bond1 = new Bond(c1, c2, IBond.Order.SINGLE);
        IBond bond2 = new Bond(c2, c3, IBond.Order.SINGLE);
        IBond bond3 = new Bond(c3, c4, IBond.Order.SINGLE);
        IBond bond4 = new Bond(c4, c5, IBond.Order.SINGLE);
        IBond bond5 = new Bond(c5, c6, IBond.Order.SINGLE);


        result.addBond(bond1);
        result.addBond(bond2);
        result.addBond(bond3);
        result.addBond(bond4);
        result.addBond(bond5);

        AtomContainerManipulator.percieveAtomTypesAndConfigureAtoms(result);

        return result;
    }

    public static IMolecule createBenzene() throws CDKException {
        IMolecule result = DefaultChemObjectBuilder.getInstance().newMolecule();

        IAtom c1 = DefaultChemObjectBuilder.getInstance().newAtom("C");
        c1.setID("1");
        IAtom c2 = DefaultChemObjectBuilder.getInstance().newAtom("C");
        c2.setID("2");
        IAtom c3 = DefaultChemObjectBuilder.getInstance().newAtom("C");
        c3.setID("3");
        IAtom c4 = DefaultChemObjectBuilder.getInstance().newAtom("C");
        c4.setID("4");
        IAtom c5 = DefaultChemObjectBuilder.getInstance().newAtom("C");
        c5.setID("5");
        IAtom c6 = DefaultChemObjectBuilder.getInstance().newAtom("C");
        c6.setID("6");

        result.addAtom(c1);
        result.addAtom(c2);
        result.addAtom(c3);
        result.addAtom(c4);
        result.addAtom(c5);
        result.addAtom(c6);

        IBond bond1 = new Bond(c1, c2, IBond.Order.SINGLE);
        IBond bond2 = new Bond(c2, c3, IBond.Order.DOUBLE);
        IBond bond3 = new Bond(c3, c4, IBond.Order.SINGLE);
        IBond bond4 = new Bond(c4, c5, IBond.Order.DOUBLE);
        IBond bond5 = new Bond(c5, c6, IBond.Order.SINGLE);
        IBond bond6 = new Bond(c6, c1, IBond.Order.DOUBLE);


        result.addBond(bond1);
        result.addBond(bond2);
        result.addBond(bond3);
        result.addBond(bond4);
        result.addBond(bond5);
        result.addBond(bond6);


        AtomContainerManipulator.percieveAtomTypesAndConfigureAtoms(result);



        return result;
    }
}