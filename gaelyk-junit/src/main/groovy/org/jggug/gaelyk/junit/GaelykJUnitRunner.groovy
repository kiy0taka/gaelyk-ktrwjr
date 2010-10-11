package org.jggug.gaelyk.junit

import org.junit.runners.BlockJUnit4ClassRunner
import org.junit.runners.model.FrameworkMethod
import org.junit.runners.model.InitializationError
import org.junit.runners.model.Statement
import groovyx.gaelyk.GaelykCategory
import groovyx.gaelyk.plugins.PluginsHandler

public class GaelykJUnitRunner extends BlockJUnit4ClassRunner {

    public GaelykJUnitRunner(Class testClass) throws InitializationError {
        super(testClass);
    }

    protected Statement methodBlock(final FrameworkMethod method) {
        def stmt = super.methodBlock(method);
        return {
            use(GaelykCategory) {
                stmt.evaluate()
            }
        } as Statement
    }

}