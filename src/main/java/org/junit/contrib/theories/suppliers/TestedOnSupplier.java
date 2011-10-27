package org.junit.contrib.theories.suppliers;

import org.junit.contrib.theories.ParameterSignature;
import org.junit.contrib.theories.ParameterSupplier;
import org.junit.contrib.theories.PotentialAssignment;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class TestedOnSupplier extends ParameterSupplier {
    @Override
    public List<PotentialAssignment> getValueSources(ParameterSignature sig) {
        List<PotentialAssignment> list = new ArrayList<PotentialAssignment>();
        TestedOn testedOn = sig.getAnnotation(TestedOn.class);
        int[] ints = testedOn.ints();
        for (int i : ints) {
            list.add(PotentialAssignment.forValue(Arrays.asList(ints).toString(), i));
        }
        return list;
    }
}
