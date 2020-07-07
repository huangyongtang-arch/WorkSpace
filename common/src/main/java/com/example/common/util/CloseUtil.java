package com.example.common.util;

import java.io.Closeable;

public class CloseUtil {
	
	public static void close(Closeable closeable) {
		if (closeable != null) {
			try {
				closeable.close();
			} catch (Exception e) {
			}
		}
	}
}
