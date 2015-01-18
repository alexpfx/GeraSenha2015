package br.com.alexpfx.api.password;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import java.util.ArrayList;
import java.util.List;

public class SyllabicPasswordGeneratorTest {
    SyllabicPasswordGenerator generator;

    @Before
    public void setUp() throws Exception {
        generator = new SyllabicPasswordGenerator();
    }

    public void testGeneratePassword_size10() throws Exception {
        List<CharGroup> sortedPattern = new ArrayList<>();
        sortedPattern.add(CharGroup.ALPHABET);
        int size = 10;
        SyllabicPasswordOptions options = new SyllabicPasswordOptions.Builder().size(size).sortedPattern(sortedPattern).build();
        String s = generator.generatePassword(options);
        Assert.assertEquals(s.length(), size);
    }
}