package org.semanticweb.owlapi6.profiles;

import java.util.Arrays;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;
import org.semanticweb.owlapi6.formats.FunctionalSyntaxDocumentFormat;
import org.semanticweb.owlapi6.formats.RDFXMLDocumentFormat;

@RunWith(Parameterized.class)
public class ProfileQLDLOnlyTestCase extends ProfileBase {

    private final String premise;

    public ProfileQLDLOnlyTestCase(String premise) {
        this.premise = premise;
    }

    @Parameters
    public static List<String> getData() {
        return Arrays.asList(
            "<rdf:RDF xmlns:rdf=\"http://www.w3.org/1999/02/22-rdf-syntax-ns#\" xmlns:owl=\"http://www.w3.org/2002/07/owl#\" xmlns:first=\"urn:test#\" xml:base=\"urn:test\"><owl:Ontology/><owl:Thing rdf:about=\"urn:test#Ghent\"><first:path><owl:Thing rdf:about=\"urn:test#Antwerp\"/></first:path></owl:Thing><owl:SymmetricProperty rdf:about=\"urn:test#path\"/></rdf:RDF>");
    }

    @Test
    public void testQLDLOnly() {
        test(premise.startsWith("<rdf:RDF") ? new RDFXMLDocumentFormat()
            : new FunctionalSyntaxDocumentFormat(), premise, false, true, false, true);
    }
}