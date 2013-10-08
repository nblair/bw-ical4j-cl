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
package net.fortuna.ical4j.model.property;

import net.fortuna.ical4j.model.ComponentNameList;
import net.fortuna.ical4j.model.ParameterList;
import net.fortuna.ical4j.model.Property;
import net.fortuna.ical4j.model.PropertyFactoryImpl;
import net.fortuna.ical4j.model.ValidationException;

/**
 * $Id: Categories.java,v 1.18 2010/03/06 12:57:23 fortuna Exp $
 * 
 * Created: [Apr 6, 2004]
 *
 * Defines an ACCEPT-RESPONSE iCalendar component property.
 * <pre>
 * </pre>
 * @author benf
 * @author mike douglass
 */
public class AcceptResponse extends Property {

    private static final long serialVersionUID = -7769987073466681634L;

    private ComponentNameList components;

    /**
     * Default constructor.
     */
    public AcceptResponse() {
        super(ACCEPT_RESPONSE, PropertyFactoryImpl.getInstance());
        components = new ComponentNameList();
    }

    /**
     * @param aValue a value string for this component
     */
    public AcceptResponse(final String aValue) {
        super(ACCEPT_RESPONSE, PropertyFactoryImpl.getInstance());
        setValue(aValue);
    }

    /**
     * @param aList a list of parameters for this component
     * @param aValue a value string for this component
     */
    public AcceptResponse(final ParameterList aList, final String aValue) {
        super(ACCEPT_RESPONSE, aList, PropertyFactoryImpl.getInstance());
        setValue(aValue);
    }

    /**
     * @param cList a list of component names
     */
    public AcceptResponse(final ComponentNameList cList) {
        super(ACCEPT_RESPONSE, PropertyFactoryImpl.getInstance());
        components = cList;
    }

    /**
     * @param aList a list of parameters for this component
     * @param cList a list of component names
     */
    public AcceptResponse(final ParameterList aList, 
    		final ComponentNameList cList) {
        super(ACCEPT_RESPONSE, aList, PropertyFactoryImpl.getInstance());
        components = cList;
    }

    /**
     * {@inheritDoc}
     */
    public final void setValue(final String aValue) {
    	components = new ComponentNameList(aValue);
    }

    /**
     * {@inheritDoc}
     */
    public final void validate() throws ValidationException {
        /*
         * ; the following is optional, ; and MAY occur more than once (";" xparam)
         */
    }

    /**
     * @return Returns the component names.
     */
    public final ComponentNameList getComponentNames() {
        return components;
    }

    /**
     * {@inheritDoc}
     */
    public final String getValue() {
        return getComponentNames().toString();
    }
}
