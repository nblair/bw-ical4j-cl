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

import net.fortuna.ical4j.model.ParameterList;
import net.fortuna.ical4j.model.Property;
import net.fortuna.ical4j.model.PropertyFactoryImpl;
import net.fortuna.ical4j.model.ValidationException;

/**
 *
 * Defines a Response iCalendar VOTE component property.
 * @author miked
 */
public class Response extends Property {

    private static final long serialVersionUID = -1765522613173314831L;

    private int response;

    /**
     * Default constructor.
     */
    public Response() {
        super(RESPONSE, PropertyFactoryImpl.getInstance());
    }

    /**
     * @param aList a list of parameters for this component
     * @param aValue a value string for this component
     */
    public Response(final ParameterList aList, final String aValue) {
        super(RESPONSE, aList, PropertyFactoryImpl.getInstance());
        setValue(aValue);
    }

    /**
     * @param val a response
     */
    public Response(final int val) {
        super(RESPONSE, PropertyFactoryImpl.getInstance());
        response = val;
    }

    /**
     * @param aList a list of parameters for this component
     * @param val a response
     */
    public Response(final ParameterList aList, final int val) {
        super(RESPONSE, aList, PropertyFactoryImpl.getInstance());
        response = val;
    }

    /**
     * @return Returns the response.
     */
    public final int getResponse() {
        return response;
    }

    /**
     * {@inheritDoc}
     */
    public final void setValue(final String val) {
        response = Integer.parseInt(val);
    }

    /**
     * {@inheritDoc}
     */
    public final String getValue() {
        return String.valueOf(getResponse());
    }

    /**
     * @param val The response to set.
     */
    public final void setResponse(final int val) {
        response = val;
    }

    /**
     * {@inheritDoc}
     */
    public final void validate() throws ValidationException {
        // TODO: Auto-generated method stub
    }
}
