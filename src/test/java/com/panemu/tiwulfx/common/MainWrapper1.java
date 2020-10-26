/*
 * Copyright (C) 2018 Panemu.
 *
 * This library is free software; you can redistribute it and/or
 * modify it under the terms of the GNU Lesser General Public
 * License as published by the Free Software Foundation; either
 * version 2.1 of the License, or (at your option) any later version.
 *
 * This library is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the GNU
 * Lesser General Public License for more details.
 *
 * You should have received a copy of the GNU Lesser General Public
 * License along with this library; if not, write to the Free Software
 * Foundation, Inc., 51 Franklin Street, Fifth Floor, Boston,
 * MA 02110-1301  USA
 */
package com.panemu.tiwulfx.common;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * //
 *
 *
 * @author amrullah
 */
public class MainWrapper1 {
	
	public static void main(String[] args) {
//		FrmTstLookupField.main(args);
		Logger tiwulLogger = Logger.getLogger("com.panemu.tiwulfx");
		tiwulLogger.setLevel(Level.FINE);
		Logger rootLog = Logger.getLogger("");
		rootLog.getHandlers()[0].setLevel( Level.FINE ); 
		TiwulFXUtil.DEFAULT_NULL_LABEL = "---";
//		FrmTstDropdown.main(args);
		FrmTstDropdown.main(args);
	}
}
