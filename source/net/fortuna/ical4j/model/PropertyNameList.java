/**
 * Copyright (c) 2010, Ben Fortuna
 * All rights reserved.
 *
 * Redistribution and use in source and binary forms, with or without
 * modification, are permitted provided that the following conditions
 * are met:
 *
 *  o Redistributions of source code must retain the above copyright
 * notice, this list of conditions and the following disclaimer.
 *
 *  o Redistributions in binary form must reproduce the above copyright
 * notice, this list of conditions and the following disclaimer in the
 * documentation and/or other materials provided with the distribution.
 *
 *  o Neither the name of Ben Fortuna nor the names of any other contributors
 * may be used to endorse or promote products derived from this software
 * without specific prior written permission.
 *
 * THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS
 * "AS IS" AND ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT
 * LIMITED TO, THE IMPLIED WARRANTIES OF MERCHANTABILITY AND FITNESS FOR
 * A PARTICULAR PURPOSE ARE DISCLAIMED. IN NO EVENT SHALL THE COPYRIGHT OWNER OR
 * CONTRIBUTORS BE LIABLE FOR ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL,
 * EXEMPLARY, OR CONSEQUENTIAL DAMAGES (INCLUDING, BUT NOT LIMITED TO,
 * PROCUREMENT OF SUBSTITUTE GOODS OR SERVICES; LOSS OF USE, DATA, OR
 * PROFITS; OR BUSINESS INTERRUPTION) HOWEVER CAUSED AND ON ANY THEORY OF
 * LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY, OR TORT (INCLUDING
 * NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE OF THIS
 * SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.
 */
package net.fortuna.ical4j.model;

import java.io.Serializable;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import edu.emory.mathcs.backport.java.util.concurrent.CopyOnWriteArrayList;

import net.fortuna.ical4j.util.Strings;

/**
 *
 * Defines a list of iCalendar property names.
 * @author Ben Fortuna
 * @author Mike Douglass
 * 
 */
public class PropertyNameList implements Serializable {

    private static final long serialVersionUID = 4387692697196974638L;

    private List properties;

    /**
     * Default constructor.
     */
    public PropertyNameList() {
    	properties = new CopyOnWriteArrayList();
    }

    /**
     * Parses the specified string representation to create a list of property names.
     * @param aValue a string representation of a list of property names
     */
    public PropertyNameList(final String aValue) {
    	properties = new CopyOnWriteArrayList();

        final Pattern pattern = Pattern.compile("([^\\\\](?:\\\\{2})),|([^\\\\]),");
        final Matcher matcher = pattern.matcher(aValue);
        String[] propertyValues = null;

        if (matcher.find()) {
        	propertyValues = matcher.replaceAll("$1$2&quot;").split("&quot;");
        }
        else {
        	propertyValues = aValue.split(",");
        }

        for (int i = 0; i < propertyValues.length; i++) {
        	properties.add(Strings.unescape(propertyValues[i]));
        }
    }

    /**
     * @param propertyValues an array of property name values
     */
    public PropertyNameList(String[] propertyValues) {
    	properties = Arrays.asList(propertyValues);
    }
    
    /**
     * {@inheritDoc}
     */
    public final String toString() {
        final StringBuffer b = new StringBuffer();
        for (final Iterator i = properties.iterator(); i.hasNext();) {
            b.append(Strings.escape((String) i.next()));
            if (i.hasNext()) {
                b.append(',');
            }
        }
        return b.toString();
    }

    /**
     * Add an address to the list.
     * @param cname the property name to add
     * @return true
     * @see List#add(java.lang.Object)
     */
    public final boolean add(final String cname) {
        return properties.add(cname);
    }

    /**
     * @return boolean indicates if the list is empty
     * @see List#isEmpty()
     */
    public final boolean isEmpty() {
        return properties.isEmpty();
    }

    /**
     * @return an iterator
     * @see List#iterator()
     */
    public final Iterator iterator() {
        return properties.iterator();
    }

    /**
     * Remove a category from the list.
     * @param cname the property name to remove
     * @return true if the list contained the specified property name
     * @see List#remove(java.lang.Object)
     */
    public final boolean remove(final String cname) {
        return properties.remove(cname);
    }

    /**
     * @return the number of property names in the list
     * @see List#size()
     */
    public final int size() {
        return properties.size();
    }
}
