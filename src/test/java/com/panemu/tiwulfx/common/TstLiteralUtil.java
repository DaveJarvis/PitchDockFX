/*
 * Copyright (C) 2015 Panemu.
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

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Locale;
import java.util.logging.Level;
import java.util.logging.Logger;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 *
 * @author amrullah
 */
public class TstLiteralUtil {

	public TstLiteralUtil() {
	}

	@BeforeEach
	public void setUp() {
		Logger.getLogger("com.panemu.tiwulfx").setLevel(Level.WARNING);
		TiwulFXUtil.setLocale(Locale.getDefault());
	}
	
	@Test
	public void hello() {
		assertEquals(TiwulFXUtil.getLiteral("max.record"), "Max Record");
	}
	
	@Test public void testIndonesia() {
		Locale loc = new Locale("in", "ID");
		TiwulFXUtil.setLocale(loc);
		TiwulFXUtil.addLiteralBundle("com.panemu.test.res.test-literal");
		assertEquals(TiwulFXUtil.getLiteral("add.record"), "Tambah Data");
		assertEquals(TiwulFXUtil.getLiteral("max.record"), "Max Record");
		assertEquals(TiwulFXUtil.getLiteral("s1"), "Kata Pertama");
		assertEquals(TiwulFXUtil.getLiteral("s2"), "Kata Kedua");
		assertEquals(TiwulFXUtil.getLiteral("s3"), "Third String");
	}
	
	@Test public void testDefault() {
		TiwulFXUtil.addLiteralBundle("com.panemu.test.res.test-literal");
		assertEquals(TiwulFXUtil.getLiteral("add.record"), "Create new record");
		assertEquals(TiwulFXUtil.getLiteral("max.record"), "Max Record");
		assertEquals(TiwulFXUtil.getLiteral("s1"), "First String");
		assertEquals(TiwulFXUtil.getLiteral("s2"), "Second String");
		assertEquals(TiwulFXUtil.getLiteral("s3"), "Third String");
	}
	
	@Test public void testArabic() {
		Locale loc = new Locale("ar", "SA");
		TiwulFXUtil.setLocale(loc);
		TiwulFXUtil.addLiteralBundle("com.panemu.test.res.test-literal");
		assertEquals(TiwulFXUtil.getLiteral("add.record"), "Create new record");
		assertEquals(TiwulFXUtil.getLiteral("max.record"), "Max Record");
		assertEquals(TiwulFXUtil.getLiteral("s1"), "الكلمة الأولى");
		assertEquals(TiwulFXUtil.getLiteral("s2"), "Second String");
		assertEquals(TiwulFXUtil.getLiteral("s3"), "Third String");
	}
}
