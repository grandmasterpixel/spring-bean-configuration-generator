package tbd.pack;

import com.google.testing.compile.Compilation;
import com.google.testing.compile.JavaFileObjects;
import org.junit.jupiter.api.Test;

import static com.google.testing.compile.CompilationSubject.assertThat;
import static com.google.testing.compile.Compiler.javac;

class SpringBeanConfigurationGeneratorTest {

    @org.junit.jupiter.api.BeforeEach
    void setUp() {
    }

    @org.junit.jupiter.api.AfterEach
    void tearDown() {
    }

    @Test
    void someTest() {
        Compilation compilation =
                javac()
                        .withProcessors(new SpringBeanConfigurationGenerator())
                        .compile(JavaFileObjects.forResource("tbd.pack/HelloWorld.java"),
                                JavaFileObjects.forResource("tbd.pack/Muh.java"));

        assertThat(compilation).succeeded();
    }
}