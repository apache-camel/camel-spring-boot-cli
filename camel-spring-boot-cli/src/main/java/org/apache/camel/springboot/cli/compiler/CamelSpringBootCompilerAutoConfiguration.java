package org.apache.camel.springboot.cli.compiler;

import org.codehaus.groovy.control.CompilationFailedException;
import org.codehaus.groovy.control.customizers.ImportCustomizer;
import org.springframework.boot.cli.compiler.CompilerAutoConfiguration;
import org.springframework.boot.cli.compiler.DependencyCustomizer;

/**
 * @author vinod.pahuja@gmail.com
 */

public class CamelSpringBootCompilerAutoConfiguration extends CompilerAutoConfiguration {

    // @Override
    // public boolean matches(ClassNode classNode) {
    //     return AstUtils.hasAtLeastOneAnnotation(classNode, "RouteBuilder");
    // }

	@Override
	public void applyDependencies(DependencyCustomizer dependencies) {
		dependencies.add("org.apache.camel:camel-core:3.18.0");
	}

	@Override
	public void applyImports(ImportCustomizer imports)
			throws CompilationFailedException {
		imports.addImports("org.apache.camel.builder.RouteBuilder");

        imports.addImports("org.apache.camel.CamelContext");
        imports.addImports("org.apache.camel.impl.DefaultCamelContext");
	}

}