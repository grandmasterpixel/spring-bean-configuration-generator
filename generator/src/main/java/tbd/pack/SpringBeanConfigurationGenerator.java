package tbd.pack;

import org.springframework.beans.factory.support.SimpleBeanDefinitionRegistry;
import org.springframework.context.annotation.AnnotatedBeanDefinitionReader;
import org.springframework.context.annotation.ConfigurationClassPostProcessor;

import javax.annotation.processing.AbstractProcessor;
import javax.annotation.processing.Processor;
import javax.annotation.processing.RoundEnvironment;
import javax.annotation.processing.SupportedAnnotationTypes;
import javax.lang.model.element.TypeElement;
import javax.lang.model.type.ArrayType;
import javax.lang.model.type.DeclaredType;
import javax.lang.model.type.ErrorType;
import javax.lang.model.type.ExecutableType;
import javax.lang.model.type.IntersectionType;
import javax.lang.model.type.MirroredTypesException;
import javax.lang.model.type.NoType;
import javax.lang.model.type.NullType;
import javax.lang.model.type.PrimitiveType;
import javax.lang.model.type.TypeMirror;
import javax.lang.model.type.TypeVariable;
import javax.lang.model.type.TypeVisitor;
import javax.lang.model.type.UnionType;
import javax.lang.model.type.WildcardType;
import java.util.Set;

@SupportedAnnotationTypes({
        "tbd.pack.GenerateSpringBeanConfiguration",
})
public final class SpringBeanConfigurationGenerator extends AbstractProcessor implements Processor {
    @Override
    public boolean process(Set<? extends TypeElement> annotations, RoundEnvironment roundEnv) {
        final var registry = new SimpleBeanDefinitionRegistry();
        final var reader = new AnnotatedBeanDefinitionReader(registry);
        final var postProcessor = new ConfigurationClassPostProcessor();
        for (final var element : roundEnv.getElementsAnnotatedWith(GenerateSpringBeanConfiguration.class)) {
            final var generateSpringBeanConfiguration = element.getAnnotation(GenerateSpringBeanConfiguration.class);
            try {
                final var configs = generateSpringBeanConfiguration.configurations();
                for (final var config : configs) {
                    // when are we in this path?
                    // possibly when we process a class annotated with GenerateSpringBeanConfiguration from a different compilation unit?
                    throw new UnsupportedOperationException();
                }
            } catch (MirroredTypesException mte) {
                final var typeMirrors = mte.getTypeMirrors();
                for (final var typeMirror : typeMirrors) {
                    final Object result = typeMirror.accept(new TypeVisitor<>() {
                        @Override
                        public Object visit(TypeMirror t, Object o) {
                            return null;
                        }

                        @Override
                        public Object visitPrimitive(PrimitiveType t, Object o) {
                            return null;
                        }

                        @Override
                        public Object visitNull(NullType t, Object o) {
                            return null;
                        }

                        @Override
                        public Object visitArray(ArrayType t, Object o) {
                            return null;
                        }

                        @Override
                        public Object visitDeclared(DeclaredType t, Object o) {
                            final var element = (TypeElement) t.asElement();
                            Class<?> clazz;
                            try {
                                clazz = Class.forName(element.getQualifiedName().toString());
                                reader.registerBean(clazz);
                            } catch (ClassNotFoundException e) {
                                clazz = null;
                            }
                            return null;
                        }

                        @Override
                        public Object visitError(ErrorType t, Object o) {
                            return null;
                        }

                        @Override
                        public Object visitTypeVariable(TypeVariable t, Object o) {
                            return null;
                        }

                        @Override
                        public Object visitWildcard(WildcardType t, Object o) {
                            return null;
                        }

                        @Override
                        public Object visitExecutable(ExecutableType t, Object o) {
                            return null;
                        }

                        @Override
                        public Object visitNoType(NoType t, Object o) {
                            return null;
                        }

                        @Override
                        public Object visitUnknown(TypeMirror t, Object o) {
                            return null;
                        }

                        @Override
                        public Object visitUnion(UnionType t, Object o) {
                            return null;
                        }

                        @Override
                        public Object visitIntersection(IntersectionType t, Object o) {
                            return null;
                        }
                    }, null);
                }
            }
        }
        postProcessor.postProcessBeanDefinitionRegistry(registry);
        return false;
    }
}
