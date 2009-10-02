/*******************************************************************************
 * Copyright (c) 1998, 2009 Oracle. All rights reserved.
 * This program and the accompanying materials are made available under the 
 * terms of the Eclipse Public License v1.0 and Eclipse Distribution License v. 1.0 
 * which accompanies this distribution. 
 * The Eclipse Public License is available at http://www.eclipse.org/legal/epl-v10.html
 * and the Eclipse Distribution License is available at 
 * http://www.eclipse.org/org/documents/edl-v10.php.
 *
 * Contributors:
 *     Oracle - initial API and implementation from Oracle TopLink
 *     Flaivio Stutz - bug fix for getEntryAsURL
 ******************************************************************************/
package org.eclipse.persistence.internal.jpa.deployment;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.Collections;
import java.util.Iterator;

/**
 * This is an implementation of {@link Archive} when container returns a url
 * that is not one of the familiar URL types like file or jar URLs. So, we can
 * not recursively walk thru' its hierarchy. As a result {@link #getEntries()}
 * returns an empty collection.
 *
 * @author Sanjeeb.Sahoo@Sun.COM
 */
public class URLArchive implements Archive {
    /*
     * Implementation Note: This class does not have any dependency on either
     * EclipseLink or GlassFish implementation classes. Please retain this separation.
     */

    /**
     * The URL representation of this archive.
     */
    private URL url;

    public URLArchive(URL url) {
        this.url = url;
    }

    public Iterator<String> getEntries() {
        return Collections.EMPTY_LIST.iterator();
    }

    public InputStream getEntry(String entryPath) throws IOException {
        URL subEntry = new URL(url, entryPath);
        InputStream is = null;
        try {
            is = subEntry.openStream();
        } catch (IOException ioe) {
            // we return null when entry does not exist
        }
        return is;
    }

    public URL getEntryAsURL(String entryPath) throws IOException {
        URL subEntry = new URL(url, entryPath);
        try {
            InputStream is = subEntry.openStream();
            if (is == null){
            	return null;
            }
            is.close();
        } catch (IOException ioe) {
            return null; // return null when entry does not exist
        }
        return subEntry;
    }

    public URL getRootURL() {
        return url;
    }
}
