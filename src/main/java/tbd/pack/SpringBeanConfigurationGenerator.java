package tbd.pack;

import javax.annotation.processing.AbstractProcessor;
import javax.annotation.processing.Processor;
import javax.annotation.processing.RoundEnvironment;
import javax.annotation.processing.SupportedAnnotationTypes;
import javax.lang.model.element.TypeElement;
import javax.lang.model.type.MirroredTypeException;
import java.util.Set;

@SupportedAnnotationTypes({
        "tbd.pack.GenerateSpringBeanConfiguration",
})
public final class SpringBeanConfigurationGenerator extends AbstractProcessor implements Processor {
    @Override
    public boolean process(Set<? extends TypeElement> annotations, RoundEnvironment roundEnv) {
        for (final var element : roundEnv.getElementsAnnotatedWith(GenerateSpringBeanConfiguration.class)) {
            final var generateSpringBeanConfiguration = element.getAnnotation(GenerateSpringBeanConfiguration.class);
            final var configs = generateSpringBeanConfiguration.configurations();
            for (final var config : configs) {

            }
            try {
            } catch (MirroredTypeException mte) {
                final var what = mte.getTypeMirror();
            }
        }
        return false;
    }
}
