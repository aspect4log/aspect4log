/*  This file is part of the aspect4log  project.
 This program is free software; you can redistribute it and/or
 modify it under the terms of the GNU Lesser General Public License
 as published by the Free Software Foundation; version 2.1
 of the License.
 This program is distributed in the hope that it will be useful,
 but WITHOUT ANY WARRANTY; without even the implied warranty of
 MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the
 GNU Lesser General Public License for more details.
 You should have received a copy of the GNU Lesser General Public License
 along with this program; if not, write to the Free Software
 Foundation, Inc., 59 Temple Place, Suite 330, Boston, MA 02111-1307 USA.

 Copyright 2007-2014 Semochkin Vitaliy Evgenevich aka Yilativs
  
 */
package net.sf.aspect4log.slf4j;

import net.sf.aspect4log.aspect.LogAspect;

import org.slf4j.Logger;
import org.slf4j.Marker;


/**
 * This class implements slf4j logger and adds ident based on current thread ident level in {@link LogAspect}
 * 
 * @author yilativs
 *
 */
public class IdentAwareLogger implements Logger {

	private final Logger logger;
	

	public IdentAwareLogger(Logger logger) {
		this.logger = logger;
	}
	
	private static String buildIdent(){
		return LogAspect.getLogFormatConfiguration().getMessageBuilderFactory().buildIdent();
	}

	@Override
	public void debug(String s) {
		logger.debug(buildIdent()+s);
	}

	@Override
	public void debug(String s, Object o) {
		logger.debug(buildIdent()+s, o);
	}

	@Override
	public void debug(String s, Object... o) {
		logger.debug(buildIdent()+s, o);
	}

	@Override
	public void debug(String s, Throwable o) {
		logger.debug(buildIdent()+s, o);
	}

	@Override
	public void debug(Marker s, String o) {
		logger.debug(buildIdent()+s, o);
	}

	@Override
	public void debug(String s, Object o, Object oo) {
		logger.debug(buildIdent()+s, o, oo);
	}

	@Override
	public void debug(Marker s, String o, Object oo) {
		logger.debug(buildIdent()+s, o, oo);
	}

	@Override
	public void debug(Marker s, String o, Object... oo) {
		logger.debug(buildIdent()+s, o, oo);
	}

	@Override
	public void debug(Marker s, String o, Throwable oo) {
		logger.debug(buildIdent()+s, o, oo);
	}

	@Override
	public void debug(Marker s, String o, Object a, Object oo) {
		logger.debug(buildIdent()+s, o, a, oo);
	}

	@Override
	public void error(String s) {
		logger.error(buildIdent()+s);
	}

	@Override
	public void error(String s, Object o) {
		logger.error(buildIdent()+s, o);
	}

	@Override
	public void error(String s, Object... o) {
		logger.error(buildIdent()+s, o);
	}

	@Override
	public void error(String s, Throwable o) {
		logger.error(buildIdent()+s, o);
	}

	@Override
	public void error(Marker s, String o) {
		logger.error(buildIdent()+s, o);
	}

	@Override
	public void error(String s, Object o, Object oo) {
		logger.error(buildIdent()+s, o, oo);
	}

	@Override
	public void error(Marker s, String o, Object oo) {
		logger.error(buildIdent()+s, o, oo);
	}

	@Override
	public void error(Marker s, String o, Object... oo) {
		logger.error(buildIdent()+s, o, oo);
	}

	@Override
	public void error(Marker s, String o, Throwable oo) {
		logger.error(buildIdent()+s, o, oo);
	}

	@Override
	public void error(Marker s, String o, Object a, Object oo) {
		logger.error(buildIdent()+s, o, a, oo);
	}

	@Override
	public String getName() {
		return logger.getName();
	}

	@Override
	public void info(String s) {
		logger.info(buildIdent()+s);
	}

	@Override
	public void info(String s, Object o) {
		logger.info(buildIdent()+s, o);
	}

	@Override
	public void info(String s, Object... o) {
		logger.info(buildIdent()+s, o);
	}

	@Override
	public void info(String s, Throwable o) {
		logger.info(buildIdent()+s, o);
	}

	@Override
	public void info(Marker s, String o) {
		logger.info(buildIdent()+s, o);
	}

	@Override
	public void info(String s, Object o, Object oo) {
		logger.info(buildIdent()+s, o, oo);
	}

	@Override
	public void info(Marker s, String o, Object oo) {
		logger.info(buildIdent()+s, o, oo);
	}

	@Override
	public void info(Marker s, String o, Object... oo) {
		logger.info(buildIdent()+s, o, oo);
	}

	@Override
	public void info(Marker s, String o, Throwable oo) {
		logger.info(buildIdent()+s, o, oo);
	}

	@Override
	public void info(Marker s, String o, Object a, Object oo) {
		logger.info(buildIdent()+s, o, a, oo);
	}

	@Override
	public boolean isDebugEnabled() {
		return logger.isDebugEnabled();
	}

	@Override
	public boolean isDebugEnabled(Marker arg0) {
		return logger.isDebugEnabled(arg0);
	}

	@Override
	public boolean isErrorEnabled() {
		return logger.isErrorEnabled();
	}

	@Override
	public boolean isErrorEnabled(Marker arg0) {
		return logger.isErrorEnabled(arg0);
	}

	@Override
	public boolean isInfoEnabled() {
		return logger.isInfoEnabled();
	}

	@Override
	public boolean isInfoEnabled(Marker arg0) {
		return logger.isInfoEnabled(arg0);
	}

	@Override
	public boolean isTraceEnabled() {
		return logger.isTraceEnabled();
	}

	@Override
	public boolean isTraceEnabled(Marker arg0) {
		return logger.isTraceEnabled(arg0);
	}

	@Override
	public boolean isWarnEnabled() {
		return logger.isWarnEnabled();
	}

	@Override
	public boolean isWarnEnabled(Marker arg0) {
		return logger.isWarnEnabled(arg0);
	}

	@Override
	public void trace(String s) {
		logger.trace(buildIdent()+s);
	}

	@Override
	public void trace(String s, Object o) {
		logger.trace(buildIdent()+s, o);
	}

	@Override
	public void trace(String s, Object... o) {
		logger.trace(buildIdent()+s, o);
	}

	@Override
	public void trace(String s, Throwable o) {
		logger.trace(buildIdent()+s, o);
	}

	@Override
	public void trace(Marker s, String o) {
		logger.trace(buildIdent()+s, o);
	}

	@Override
	public void trace(String s, Object o, Object oo) {
		logger.trace(buildIdent()+s, o, oo);
	}

	@Override
	public void trace(Marker s, String o, Object oo) {
		logger.trace(buildIdent()+s, o, oo);
	}

	@Override
	public void trace(Marker s, String o, Object... oo) {
		logger.trace(buildIdent()+s, o, oo);
	}

	@Override
	public void trace(Marker s, String o, Throwable oo) {
		logger.trace(buildIdent()+s, o, oo);
	}

	@Override
	public void trace(Marker s, String o, Object a, Object oo) {
		logger.trace(buildIdent()+s, o, a, oo);
	}

	@Override
	public void warn(String s) {
		logger.warn(buildIdent()+s);
	}

	@Override
	public void warn(String s, Object o) {
		logger.warn(buildIdent()+s, o);
	}

	@Override
	public void warn(String s, Object... o) {
		logger.warn(buildIdent()+s, o);
	}

	@Override
	public void warn(String s, Throwable o) {
		logger.warn(buildIdent()+s, o);
	}

	@Override
	public void warn(Marker s, String o) {
		logger.warn(buildIdent()+s, o);
	}

	@Override
	public void warn(String s, Object o, Object oo) {
		logger.warn(buildIdent()+s, o, oo);
	}

	@Override
	public void warn(Marker s, String o, Object oo) {
		logger.warn(buildIdent()+s, o, oo);
	}

	@Override
	public void warn(Marker s, String o, Object... oo) {
		logger.warn(buildIdent()+s, o, oo);
	}

	@Override
	public void warn(Marker s, String o, Throwable oo) {
		logger.warn(buildIdent()+s, o, oo);
	}

	@Override
	public void warn(Marker s, String o, Object a, Object oo) {
		logger.warn(buildIdent()+s, o, a, oo);
	}

}
