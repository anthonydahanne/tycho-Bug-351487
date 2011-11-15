/*******************************************************************************
 * Copyright (c) 2008, 2011 Sonatype Inc. and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    Sonatype Inc. - initial API and implementation
 *******************************************************************************/
package sample.plugin;

import java.util.ArrayList;
import java.util.List;

import org.apache.maven.model.Dependency;
import org.codehaus.plexus.component.annotations.Component;
import org.eclipse.tycho.core.utils.TychoVersion;
import org.eclipse.tycho.p2.facade.internal.TychoP2RuntimeMetadata;

@Component(role = TychoP2RuntimeMetadata.class)
public class DefaultTychoP2RuntimeMetadata implements TychoP2RuntimeMetadata {
    private static final List<Dependency> ARTIFACTS;

    static {
        ARTIFACTS = new ArrayList<Dependency>();

        ARTIFACTS.add(newDependency("com.compuware", "com.compuware.touchpoint", "1.0.0-SNAPSHOT", "jar"));
    }

    public List<Dependency> getRuntimeArtifacts() {
        return ARTIFACTS;
    }

    private static Dependency newDependency(String groupId, String artifactId, String version, String type) {
        Dependency d = new Dependency();
        d.setGroupId(groupId);
        d.setArtifactId(artifactId);
        d.setVersion(version);
        d.setType(type);
        return d;
    }

}
